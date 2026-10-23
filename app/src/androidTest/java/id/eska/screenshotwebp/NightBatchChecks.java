package id.eska.screenshotwebp;

import android.app.Activity;
import android.app.Instrumentation;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BooleanSupplier;

/** Isolated preferences and owned media only. No device clock or power-state changes. */
final class NightBatchChecks {
    static void lifecycle(Instrumentation instrumentation, Context target) {
        Bundle report = new Bundle();
        AppStateStore state = new AppStateStore(target);
        int checks = 0;
        try {
            require(!NightBatchScheduler.inWindow(System.currentTimeMillis(), ZoneId.systemDefault()),
                    "Lifecycle fixture runs only outside the real night window");
            state.setEnabled(MediaCategory.SCREENSHOTS, true);
            state.setMonitoringRequested(true);
            long activation = state.config(MediaCategory.SCREENSHOTS).activatedAtMillis;
            MonitorService.start(target);
            JobScheduler jobs = target.getSystemService(JobScheduler.class);
            JobInfo job = jobs.getPendingJob(NightBatchScheduler.JOB_ID);
            require(job != null && job.isPersisted() && job.isRequireCharging() && job.isRequireDeviceIdle(),
                    "Real Android job is persisted, charging-only and idle-only");
            require(job.getExtras().getLong("scheduled_for") > System.currentTimeMillis(), "Job waits for next 03:00");
            checks++;
            for (String action : new String[]{Intent.ACTION_BOOT_COMPLETED, Intent.ACTION_USER_UNLOCKED,
                    Intent.ACTION_MY_PACKAGE_REPLACED, Intent.ACTION_TIME_CHANGED, Intent.ACTION_TIMEZONE_CHANGED}) {
                new BootReceiver().onReceive(target, new Intent(action));
                MonitorService.start(target);
            }
            require(jobs.getAllPendingJobs().size() == 1 && !MonitorService.isRunning(),
                    "Boot, unlock, update and clock changes restore exactly one schedule, not a running monitor");
            require(state.config(MediaCategory.SCREENSHOTS).activatedAtMillis == activation, "Recovery preserves activation");
            checks++;
            Activity opened = instrumentation.startActivitySync(new Intent(target, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            instrumentation.runOnMainSync(opened::finish);
            require(jobs.getAllPendingJobs().size() == 1 && !MonitorService.isRunning()
                    && state.snapshot().screenshotCount == 0 && state.snapshot().processing == 0,
                    "Opening dashboard during daytime does not convert or create duplicate work");
            checks++;
            report.putInt("tidy_failed", 0);
        } catch (Throwable failure) {
            report.putInt("tidy_failed", 1);
            report.putString("tidy_errors", failure.getClass().getSimpleName() + ": " + failure.getMessage());
        }
        report.putInt("tidy_passed", checks);
        report.putString("stream", "Night schedule lifecycle; isolated test app remains scheduled for shell rejection check\n");
        instrumentation.finish(report.getInt("tidy_failed") == 0 ? Activity.RESULT_OK : Activity.RESULT_CANCELED, report);
    }

    static void run(Instrumentation instrumentation, Context target) {
        String id = "night-batch-" + UUID.randomUUID();
        Context context = GalleryChecks.isolated(target, id);
        AppStateStore state = new AppStateStore(context);
        Bundle report = new Bundle();
        List<MediaMonitor> sessions = new ArrayList<>();
        File root = null;
        int checks = 0;
        try {
            require(Environment.isExternalStorageManager(), "All files access for owned fixtures");
            root = GalleryChecks.createRoot();
            File screenshots = new File(root, "screenshots"), photos = new File(root, "photos");
            require(screenshots.mkdir() && photos.mkdir(), "Create owned category roots");
            for (int i = 0; i < 1500; i++) {
                File old = new File(screenshots, "old-" + i + ".jpg");
                Files.write(old.toPath(), new byte[]{1, 2, 3});
                require(old.setLastModified(System.currentTimeMillis() - 86_400_000), "Age old fixture");
            }
            state.setEnabled(MediaCategory.SCREENSHOTS, true);
            state.setEnabled(MediaCategory.PHOTOS, true);
            state.setFormat(MediaCategory.SCREENSHOTS, OutputFormat.WEBP);
            state.setMonitoringRequested(true);
            long activation = state.config(MediaCategory.SCREENSHOTS).activatedAtMillis;
            PathPolicy policy = new PathPolicy(List.of(screenshots), List.of(photos));
            ZoneId zone = ZoneId.of("Asia/Jakarta");
            AtomicLong clock = new AtomicLong(at(12));
            AtomicBoolean charging = new AtomicBoolean(false), asleep = new AtomicBoolean(true);
            BooleanSupplier gate = () -> asleep.get() && NightBatchScheduler.allowed(clock.get(), zone, charging.get());

            Batch daytime = batch(context, state, policy, gate, null, sessions);
            daytime.await();
            require(daytime.monitor.scanCount() == 0 && daytime.monitor.inspectedFiles() == 0
                    && daytime.results.isEmpty(), "Daytime unplugged: zero scan and conversion");
            checks++;
            charging.set(true);
            Batch dayCharging = batch(context, state, policy, gate, null, sessions);
            dayCharging.await();
            require(dayCharging.monitor.scanCount() == 0, "Charging during daytime still does not scan");
            checks++;

            clock.set(at(3)); charging.set(false);
            Batch unplugged = batch(context, state, policy, gate, null, sessions);
            unplugged.await();
            require(unplugged.monitor.scanCount() == 0, "Night without charger does not scan");
            checks++;
            charging.set(true); asleep.set(false);
            Batch awake = batch(context, state, policy, gate, null, sessions);
            awake.await();
            require(awake.monitor.scanCount() == 0, "Screen-on night does not scan");
            checks++;
            asleep.set(true); clock.set(at(6));
            Batch late = batch(context, state, policy, gate, null, sessions);
            late.await();
            require(late.monitor.scanCount() == 0, "Delayed callback after 06:00 does not scan");
            checks++;

            SystemClock.sleep(1100);
            writeImage(new File(screenshots, "daytime-a.png"));
            writeImage(new File(screenshots, "daytime-b.png"));
            long cpu = Process.getElapsedCpuTime(), started = SystemClock.elapsedRealtime();
            SystemClock.sleep(45_000);
            report.putLong("daytime_idle_cpu_ms", Process.getElapsedCpuTime() - cpu);
            report.putLong("daytime_idle_wall_ms", SystemClock.elapsedRealtime() - started);
            require(daytime.monitor.scanCount() == 0 && daytime.results.isEmpty(), "No watcher or recurring scan reacts to new daytime files");
            checks++;

            clock.set(at(3));
            Batch night = batch(context, state, policy, gate, null, sessions);
            night.monitor.start(); // Same session cannot start a second scan.
            night.await();
            require(night.monitor.scanCount() == 1 && night.results.size() == 2
                    && night.errors.isEmpty(), "One finite scan converts both daytime photos: " + night.errors);
            checks++;
            require(state.config(MediaCategory.SCREENSHOTS).activatedAtMillis == activation,
                    "Nightly run preserves the activation cutoff");
            state.markBatchDay("2026-10-24");
            AppStateStore reopened = new AppStateStore(context);
            require(reopened.lastBatchDay().equals("2026-10-24") && reopened.monitoringRequested()
                    && reopened.config(MediaCategory.SCREENSHOTS).activatedAtMillis == activation,
                    "Restart preserves automation, activation and nightly attempt");
            checks++;
            Batch duplicate = batch(context, state, policy, gate, null, sessions);
            duplicate.await();
            require(duplicate.results.isEmpty() && duplicate.errors.isEmpty(), "Processed fingerprints survive a fresh session");
            checks++;

            for (int i = 0; i < 5; i++) writeImage(new File(screenshots, "unplug-" + i + ".png"));
            Batch stopped = batch(context, state, policy, gate, () -> charging.set(false), sessions);
            stopped.await();
            require(stopped.results.size() == 1 && stopped.errors.isEmpty(), "Unplug after first result starts no following file");
            for (int i = 0; i < 5; i++) require(new File(screenshots, "unplug-" + i + ".png").isFile(), "Unplug keeps source safe");
            checks++;
            charging.set(true);
            Batch dawn = batch(context, state, policy, gate, () -> clock.set(at(6)), sessions);
            dawn.await();
            require(dawn.results.size() == 1 && dawn.errors.isEmpty(), "06:00 boundary prevents the next conversion");
            checks++;
            clock.set(at(3));
            Batch paused = batch(context, state, policy, gate, () -> state.setMonitoringRequested(false), sessions);
            paused.await();
            require(paused.results.size() == 1 && paused.errors.isEmpty(), "Pause prevents the next conversion");
            checks++;

            state.setMonitoringRequested(true);
            String[][] expected = {
                {"SCREENSHOTS", "WEBP", "a8a51adad755dee3d1fe2e5ed0f24e511eb5dc76fe50e62640c7aa28dc82b3ad"},
                {"SCREENSHOTS", "AVIF", "e72816134ff47fceda1c106af8238747cdaf8685bdb689c6d9ea029caa0d42f3"},
                {"PHOTOS", "WEBP", "2bf016de30f3dd23e8350d33d7ac93adc9a5181b02476182a57fb4febebdabfd"},
                {"PHOTOS", "AVIF", "616c7b38ff8956c3ecda62f5fa1d323464ee1d3aa4b23391a8f6229973c3db10"}
            };
            for (String[] fixture : expected) {
                MediaCategory category = MediaCategory.valueOf(fixture[0]);
                OutputFormat format = OutputFormat.valueOf(fixture[1]);
                state.setFormat(category, format);
                SystemClock.sleep(1100);
                File source = new File(category == MediaCategory.SCREENSHOTS ? screenshots : photos,
                        "compat-" + category + "-" + format + ".png");
                writeImage(source);
                MediaConverter.Result value = new MediaConverter(context, policy).convert(source, state.config(category));
                String hash = hash(Files.readAllBytes(value.output.toPath()));
                report.putString("compat_" + category + "_" + format, hash);
                require(hash.equals(fixture[2]) && value.width == 256 && value.height == 192
                        && source.isFile(), "Original 2.3.1 compression bytes: " + category + " " + format);
                checks++;
            }
            report.putInt("tidy_failed", 0);
        } catch (Throwable failure) {
            report.putInt("tidy_failed", 1);
            report.putString("tidy_errors", failure.getClass().getSimpleName() + ": " + failure.getMessage());
        } finally {
            state.setMonitoringRequested(false);
            for (MediaMonitor session : sessions) session.close();
            try {
                for (MediaMonitor session : sessions) awaitStopped(session);
                if (root != null) {
                    for (int i = 0; i < 1500; i++) Files.deleteIfExists(new File(root, "screenshots/old-" + i + ".jpg").toPath());
                    GalleryChecks.cleanup(context, root);
                }
                target.deleteSharedPreferences(id + "-state");
                target.deleteSharedPreferences(id + "-tidy_ui");
            } catch (Exception failure) {
                report.putInt("tidy_failed", 1);
                report.putString("tidy_cleanup_error", failure.toString());
            }
        }
        report.putInt("tidy_passed", checks);
        report.putString("stream", "Tidy 2.3.1 charging-only night batch\n");
        instrumentation.finish(report.getInt("tidy_failed") == 0 ? Activity.RESULT_OK : Activity.RESULT_CANCELED, report);
    }

    private static final class Batch implements MediaMonitor.Callback {
        MediaMonitor monitor;
        final List<MediaConverter.Result> results = Collections.synchronizedList(new ArrayList<>());
        final List<String> errors = Collections.synchronizedList(new ArrayList<>());
        final CountDownLatch done = new CountDownLatch(1);
        final AtomicInteger completions = new AtomicInteger();
        final Runnable afterResult;
        Batch(Runnable afterResult) { this.afterResult = afterResult; }
        @Override public void onProgress(int pending, int processing) {}
        @Override public void onResult(MediaConverter.Result result) {
            results.add(result);
            if (afterResult != null) afterResult.run();
        }
        @Override public void onError(MediaCategory category, String message) { errors.add(message); }
        @Override public void onFinished() { completions.incrementAndGet(); done.countDown(); }
        void await() throws Exception {
            require(done.await(30, TimeUnit.SECONDS), "Batch finishes without a periodic polling loop");
            awaitStopped(monitor);
            require(completions.get() == 1, "Exactly one completion callback");
        }
    }

    private static Batch batch(Context context, AppStateStore state, PathPolicy policy, BooleanSupplier gate,
            Runnable afterResult, List<MediaMonitor> sessions) {
        Batch batch = new Batch(afterResult);
        batch.monitor = new MediaMonitor(context, state, batch, policy, gate);
        sessions.add(batch.monitor);
        batch.monitor.start();
        return batch;
    }

    private static void awaitStopped(MediaMonitor monitor) throws Exception {
        long deadline = SystemClock.elapsedRealtime() + 10_000;
        while (!monitor.isTerminated() && SystemClock.elapsedRealtime() < deadline) Thread.sleep(10);
        require(monitor.isTerminated(), "All batch executors terminate");
    }

    private static long at(int hour) {
        return ZonedDateTime.of(2026, 10, 24, hour, 0, 0, 0, ZoneId.of("Asia/Jakarta")).toInstant().toEpochMilli();
    }

    private static void writeImage(File file) throws Exception {
        Bitmap bitmap = Bitmap.createBitmap(256, 192, Bitmap.Config.ARGB_8888);
        Random random = new Random(231);
        for (int y = 0; y < bitmap.getHeight(); y++) for (int x = 0; x < bitmap.getWidth(); x++)
            bitmap.setPixel(x, y, Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        try (FileOutputStream output = new FileOutputStream(file)) {
            require(bitmap.compress(Bitmap.CompressFormat.PNG, 100, output), "Write owned fixture");
        } finally { bitmap.recycle(); }
    }

    private static String hash(byte[] bytes) throws Exception {
        byte[] hash = MessageDigest.getInstance("SHA-256").digest(bytes);
        StringBuilder value = new StringBuilder();
        for (byte b : hash) value.append(String.format(java.util.Locale.ROOT, "%02x", b & 255));
        return value.toString();
    }

    private static void require(boolean value, String message) {
        if (!value) throw new AssertionError(message);
    }
}
