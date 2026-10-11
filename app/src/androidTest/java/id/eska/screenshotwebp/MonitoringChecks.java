package id.eska.screenshotwebp;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/** Real FileObserver regression; the caller has already enforced emulator-only execution. */
final class MonitoringChecks {
    static void run(Instrumentation instrumentation, Context context) {
        String id = "tidy-monitor-check-" + UUID.randomUUID();
        File directory = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "Screenshots/" + id);
        Context isolated = new ContextWrapper(context) {
            @Override public Context getApplicationContext() { return this; }
            @Override public Context createDeviceProtectedStorageContext() { return this; }
            @Override public boolean isDeviceProtectedStorage() { return true; }
            @Override public SharedPreferences getSharedPreferences(String name, int mode) {
                return context.getSharedPreferences(id + "-" + name, mode);
            }
        };
        AppStateStore state = new AppStateStore(isolated);
        CountDownLatch watching = new CountDownLatch(1);
        CountDownLatch converted = new CountDownLatch(1);
        AtomicReference<MediaConverter.Result> result = new AtomicReference<>();
        AtomicReference<String> error = new AtomicReference<>();
        MediaMonitor monitor = null;
        Bundle report = new Bundle();
        try {
            require(Environment.isExternalStorageManager(), "Grant all-files access on the disposable emulator");
            require(directory.mkdirs(), "Create unique synthetic shared-storage directory");
            state.setEnabled(MediaCategory.SCREENSHOTS, true);
            state.setFormat(MediaCategory.SCREENSHOTS, OutputFormat.WEBP);
            state.setMonitoringRequested(true);
            monitor = new MediaMonitor(isolated, state, new MediaMonitor.Callback() {
                @Override public void onProgress(int pending, int processing) { watching.countDown(); }
                @Override public void onResult(MediaConverter.Result value) {
                    result.set(value);
                    converted.countDown();
                }
                @Override public void onError(MediaCategory category, String message) { error.set(message); }
            });
            monitor.start();
            require(watching.await(12, TimeUnit.SECONDS), "Initial observer registration finished");
            // Shared-storage mtime can have one-second granularity; CREATE must be eligible too.
            SystemClock.sleep(1100);
            File source = new File(directory, "slow-write.png");
            Bitmap bitmap = Bitmap.createBitmap(128, 96, Bitmap.Config.ARGB_8888);
            bitmap.eraseColor(Color.GREEN);
            try (FileOutputStream output = new FileOutputStream(source)) {
                // CREATE has an empty snapshot for longer than the stability interval.
                SystemClock.sleep(900);
                require(bitmap.compress(Bitmap.CompressFormat.PNG, 100, output), "Write real synthetic PNG");
            } finally {
                bitmap.recycle();
            }
            long completedAt = SystemClock.elapsedRealtime();
            boolean arrived = converted.await(12, TimeUnit.SECONDS);
            report.putLong("tidy_completed_write_ms", SystemClock.elapsedRealtime() - completedAt);
            require(arrived, "CLOSE_WRITE must not wait for the 20-second empty-file backoff; " + error.get());
            MediaConverter.Result actual = result.get();
            require(actual != null && actual.output.isFile() && actual.format == OutputFormat.WEBP,
                    "Publish real WebP output");
            require(source.isFile() && !actual.originalDeleted && state.snapshot().savedBytes == 0,
                    "Retain source and report no reclaimed bytes");
            Bitmap decoded = android.graphics.BitmapFactory.decodeFile(actual.output.getPath());
            require(decoded != null && decoded.getWidth() == 128 && decoded.getHeight() == 96,
                    "Decode produced WebP at source dimensions");
            decoded.recycle();
            report.putInt("tidy_checks", 1);
            report.putInt("tidy_passed", 1);
            report.putInt("tidy_failed", 0);
            report.putString("stream", "Real CREATE/CLOSE_WRITE regression passed\n");
        } catch (Throwable failure) {
            report.putInt("tidy_checks", 1);
            report.putInt("tidy_passed", 0);
            report.putInt("tidy_failed", 1);
            report.putString("tidy_errors", failure.getClass().getSimpleName() + ": " + failure.getMessage());
            report.putString("stream", "Real CREATE/CLOSE_WRITE regression failed: " + failure.getMessage() + "\n");
        } finally {
            state.setMonitoringRequested(false);
            if (monitor != null) monitor.close();
            try {
                File[] files = directory.listFiles();
                if (files != null) for (File file : files) Files.deleteIfExists(file.toPath());
                Files.deleteIfExists(directory.toPath());
                context.deleteSharedPreferences(id + "-state");
                context.deleteSharedPreferences(id + "-tidy_ui");
            } catch (Exception cleanup) {
                report.putInt("tidy_failed", 1);
                report.putString("tidy_errors", "Synthetic fixture cleanup failed: " + cleanup.getMessage());
            }
        }
        instrumentation.finish(report.getInt("tidy_failed") == 0 ? Activity.RESULT_OK : Activity.RESULT_CANCELED,
                report);
    }

    private static void require(boolean value, String message) {
        if (!value) throw new AssertionError(message);
    }
}
