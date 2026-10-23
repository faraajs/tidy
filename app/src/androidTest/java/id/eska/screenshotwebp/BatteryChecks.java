package id.eska.screenshotwebp;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
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
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/** Real observer/CPU comparison using only owned roots and isolated preferences. */
final class BatteryChecks {
    static void run(Instrumentation instrumentation, Context target, boolean baseline) {
        String id = "tidy-battery-" + UUID.randomUUID();
        Context isolated = GalleryChecks.isolated(target, id);
        AppStateStore state = new AppStateStore(isolated);
        Bundle report = new Bundle();
        File fixture = null;
        MediaMonitor monitor = null;
        int checks = 0;
        try {
            require(Environment.isExternalStorageManager(), "Owned shared-storage fixtures need All files access");
            fixture = GalleryChecks.createRoot();
            File screenshots = new File(fixture, "screenshots");
            File later = new File(fixture, "later");
            File photos = new File(fixture, "photos");
            require(screenshots.mkdir() && photos.mkdir(), "Create owned roots");
            // Old files are intentionally ineligible, as in an established personal library.
            for (int d = 0; d < 30; d++) {
                File directory = new File(screenshots, "old-" + d);
                require(directory.mkdir(), "Create owned library directory");
                for (int f = 0; f < 50; f++) {
                    File old = new File(directory, "old-" + f + ".jpg");
                    Files.write(old.toPath(), new byte[]{1, 2, 3});
                    require(old.setLastModified(System.currentTimeMillis() - 86_400_000), "Age fixture");
                }
            }
            state.setEnabled(MediaCategory.SCREENSHOTS, true);
            state.setFormat(MediaCategory.SCREENSHOTS, OutputFormat.WEBP);
            state.setMonitoringRequested(true);
            PathPolicy policy = new PathPolicy(List.of(screenshots, later), Collections.singletonList(photos));
            LinkedBlockingQueue<MediaConverter.Result> results = new LinkedBlockingQueue<>();
            AtomicInteger progress = new AtomicInteger();
            AtomicReference<String> error = new AtomicReference<>();
            monitor = new MediaMonitor(isolated, state, new MediaMonitor.Callback() {
                @Override public void onProgress(int pending, int processing) { progress.incrementAndGet(); }
                @Override public void onResult(MediaConverter.Result value) { results.add(value); }
                @Override public void onError(MediaCategory category, String message) { error.set(message); }
            }, policy);
            monitor.start();
            long ready = SystemClock.elapsedRealtime() + 20_000;
            while (progress.get() == 0 && SystemClock.elapsedRealtime() < ready) SystemClock.sleep(20);
            require(progress.get() > 0, "Initial observer registration completed");
            checks++;
            long scans = monitor.scanCount(), files = monitor.inspectedFiles();
            int updates = progress.get();
            long cpu = Process.getElapsedCpuTime(), start = SystemClock.elapsedRealtime();
            SystemClock.sleep(45_000);
            report.putLong("idle_wall_ms", SystemClock.elapsedRealtime() - start);
            report.putLong("idle_cpu_ms", Process.getElapsedCpuTime() - cpu);
            report.putLong("idle_full_scans", monitor.scanCount() - scans);
            report.putLong("idle_file_inspections", monitor.inspectedFiles() - files);
            report.putInt("idle_progress_callbacks", progress.get() - updates);
            instrumentation.sendStatus(0, report);
            require(results.isEmpty() && error.get() == null, "No historical image is converted");
            if (!baseline) require(monitor.scanCount() == scans && monitor.inspectedFiles() == files
                    && progress.get() == updates, "Idle library causes no periodic scan or duplicate progress");
            checks++;
            File fresh = new File(screenshots, "fresh.png");
            long closed = writeImage(fresh);
            MediaConverter.Result converted = results.poll(8, TimeUnit.SECONDS);
            report.putLong("fresh_image_ms", SystemClock.elapsedRealtime() - closed);
            require(converted != null && converted.output.isFile() && fresh.isFile()
                    && !converted.originalDeleted && converted.format == OutputFormat.WEBP,
                    "Real CLOSE_WRITE still converts and retains original: " + error.get());
            checks++;
            monitor.close();
            monitor = null;
            // The same generated bytes must produce the same legacy 2.3.1 compression result.
            for (MediaCategory category : MediaCategory.values()) {
                state.setEnabled(category, true);
                state.setMonitoringRequested(true);
                SystemClock.sleep(1100);
                for (OutputFormat format : OutputFormat.values()) {
                    state.setFormat(category, format);
                    File source = new File(category == MediaCategory.SCREENSHOTS ? screenshots : photos,
                            "compat-" + category.name() + "-" + format.name() + ".png");
                    writeImage(source);
                    MediaConverter.Result value = new MediaConverter(isolated, policy).convert(source, state.config(category));
                    String key = "compat_" + category.name() + "_" + format.name();
                    report.putString(key + "_sha256", hash(Files.readAllBytes(value.output.toPath())));
                    report.putLong(key + "_bytes", value.outputBytes);
                    report.putString(key + "_dimensions", value.width + "x" + value.height);
                    require(source.isFile() && !value.originalDeleted, "Compatibility fixture keeps original");
                    checks++;
                }
            }
            report.putInt("tidy_failed", 0);
            report.putInt("tidy_passed", checks);
            instrumentation.sendStatus(0, report);
        } catch (Throwable failure) {
            report.putInt("tidy_failed", 1);
            report.putInt("tidy_passed", checks);
            report.putString("tidy_errors", failure.getClass().getSimpleName() + ": " + failure.getMessage());
        } finally {
            state.setMonitoringRequested(false);
            if (monitor != null) monitor.close();
            try {
                if (fixture != null) {
                    // These deliberately invalid, old fixtures were never indexed as images.
                    // Avoid 1500 unnecessary MediaScanner calls during their cleanup.
                    for (int d = 0; d < 30; d++) for (int f = 0; f < 50; f++)
                        Files.deleteIfExists(new File(fixture, "screenshots/old-" + d + "/old-" + f + ".jpg").toPath());
                }
                if (fixture != null) GalleryChecks.cleanup(isolated, fixture);
                target.deleteSharedPreferences(id + "-state");
                target.deleteSharedPreferences(id + "-tidy_ui");
            } catch (Exception failure) {
                report.putInt("tidy_failed", 1);
                report.putString("tidy_cleanup_error", failure.toString());
            }
        }
        report.putString("stream", "Original 2.3.1 battery " + (baseline ? "baseline" : "verification") + "\n");
        instrumentation.finish(report.getInt("tidy_failed") == 0 ? Activity.RESULT_OK : Activity.RESULT_CANCELED, report);
    }

    private static long writeImage(File file) throws Exception {
        Bitmap bitmap = Bitmap.createBitmap(256, 192, Bitmap.Config.ARGB_8888);
        Random random = new Random(231);
        for (int y = 0; y < bitmap.getHeight(); y++) for (int x = 0; x < bitmap.getWidth(); x++)
            bitmap.setPixel(x, y, Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        try (FileOutputStream output = new FileOutputStream(file)) {
            require(bitmap.compress(Bitmap.CompressFormat.PNG, 100, output), "Write owned PNG");
        } finally { bitmap.recycle(); }
        return SystemClock.elapsedRealtime();
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
