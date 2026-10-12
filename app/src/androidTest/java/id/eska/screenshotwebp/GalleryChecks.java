package id.eska.screenshotwebp;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.ContentUris;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/** Only unique, generated Pictures fixtures and isolated preferences; safe on a physical device. */
final class GalleryChecks {
    static Context isolated(Context context, String id) {
        return new ContextWrapper(context) {
            @Override public Context getApplicationContext() { return this; }
            @Override public Context createDeviceProtectedStorageContext() { return this; }
            @Override public boolean isDeviceProtectedStorage() { return true; }
            @Override public SharedPreferences getSharedPreferences(String name, int mode) {
                return context.getSharedPreferences(id + "-" + name, mode);
            }
            @Override public boolean deleteSharedPreferences(String name) {
                return context.deleteSharedPreferences(id + "-" + name);
            }
        };
    }

    static File createRoot() throws Exception {
        File pictures = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        require(pictures.isDirectory() || pictures.mkdirs(), "Create Pictures fixture parent");
        return Files.createDirectory(new File(pictures, "tidy-gallery-check-" + UUID.randomUUID())
                .toPath()).toFile().getCanonicalFile();
    }

    static Uri findImage(Context context, File file) throws Exception {
        requireOwned(file);
        try (Cursor row = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Images.Media._ID}, MediaStore.Images.Media.DATA + " = ?",
                new String[]{file.getCanonicalPath()}, null)) {
            return row != null && row.moveToFirst()
                    ? ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, row.getLong(0))
                    : null;
        }
    }

    static Uri requireIndexed(Context context, MediaConverter.Result result) throws Exception {
        Uri uri = findImage(context, result.output);
        require(uri != null, "Gallery image row exists for " + result.output.getName());
        String[] columns = {MediaStore.Images.Media.MIME_TYPE, MediaStore.Images.Media.SIZE,
                MediaStore.Images.Media.IS_PENDING};
        try (Cursor row = context.getContentResolver().query(uri, columns, null, null, null)) {
            require(row != null && row.moveToFirst(), "Gallery image row readable");
            require(("image/" + result.format.extension()).equals(row.getString(0)), "Correct Gallery MIME");
            require(row.getLong(1) == result.outputBytes && row.getInt(2) == 0,
                    "Gallery row is complete, not pending");
        }
        try (InputStream input = context.getContentResolver().openInputStream(uri)) {
            require(input != null && Arrays.equals(Files.readAllBytes(result.output.toPath()),
                    readBytes(input)), "Gallery URI reads the exact verified file");
        }
        try (InputStream input = context.getContentResolver().openInputStream(uri)) {
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            require(bitmap != null, "Platform decoder opens Gallery URI");
            try {
                require(bitmap.getWidth() == result.width && bitmap.getHeight() == result.height,
                        "Gallery URI decoded dimensions");
            } finally {
                bitmap.recycle();
            }
        }
        return uri;
    }

    static void scan(Context context, File file, String mime) throws Exception {
        requireOwned(file);
        CountDownLatch complete = new CountDownLatch(1);
        MediaScannerConnection.scanFile(context, new String[]{file.getPath()},
                mime == null ? null : new String[]{mime}, (path, uri) -> complete.countDown());
        require(complete.await(10, TimeUnit.SECONDS), "Owned fixture scan completes");
    }

    static void awaitRemoved(Context context, File source) throws Exception {
        long deadline = SystemClock.elapsedRealtime() + 10_000;
        while (findImage(context, source) != null && SystemClock.elapsedRealtime() < deadline) {
            Thread.sleep(50);
        }
        require(findImage(context, source) == null, "Deleted fixture has no stale Gallery image row");
    }

    static void cleanup(Context context, File root) throws Exception {
        requireOwned(root);
        File[] children = root.listFiles();
        if (children != null) for (File child : children) {
            if (child.isDirectory()) cleanup(context, child);
            else {
                Files.deleteIfExists(child.toPath());
                scan(context, child, null);
            }
        }
        Files.deleteIfExists(root.toPath());
    }

    static void run(Instrumentation instrumentation, Context target) {
        String id = "tidy-gallery-prefs-" + UUID.randomUUID();
        Context context = isolated(target, id);
        Bundle report = new Bundle();
        List<String> failures = new ArrayList<>();
        File root = null;
        File unavailableRoot = null;
        int checks = 0;
        try {
            require(Environment.isExternalStorageManager(), "All-files access is required for owned Pictures fixtures");
            root = createRoot();
            report.putString("tidy_fixture_root", root.getPath());
            AppStateStore state = new AppStateStore(context);
            state.setEnabled(MediaCategory.SCREENSHOTS, true);
            state.setDeleteOriginals(MediaCategory.SCREENSHOTS, true);
            // Only isolated converter consent; no service or observer is started.
            state.setMonitoringRequested(true);
            SystemClock.sleep(1100); // Shared-storage mtime may have one-second precision.
            PathPolicy paths = new PathPolicy(Collections.singletonList(root), Collections.emptyList());
            MediaConverter converter = new MediaConverter(context, paths);
            // WebP first: this is the user's selected screenshot codec. No latency pass/fail threshold.
            for (OutputFormat format : new OutputFormat[]{OutputFormat.WEBP, OutputFormat.AVIF}) {
                checks++;
                String name = "gallery_1080x2400_" + format.extension();
                Bundle status = new Bundle();
                status.putString("tidy_check", name);
                try {
                    state.setFormat(MediaCategory.SCREENSHOTS, format);
                    AppStateStore.Config config = state.config(MediaCategory.SCREENSHOTS);
                    File source = image(root, "synthetic-" + format.extension() + ".png");
                    scan(context, source, "image/png");
                    require(findImage(context, source) != null, "Generated original is indexed first");
                    MediaConverter.SourceSnapshot before = MediaConverter.SourceSnapshot.capture(source);
                    long start = SystemClock.elapsedRealtime();
                    MediaConverter.Result result = converter.convert(source, config);
                    long elapsed = SystemClock.elapsedRealtime() - start;
                    report.putLong("tidy_" + format.extension() + "_1080x2400_ms", elapsed);
                    status.putLong("tidy_duration_ms", elapsed);
                    report.putString("tidy_" + format.extension() + "_actual_format", result.format.name());
                    report.putLong("tidy_" + format.extension() + "_source_bytes", result.sourceBytes);
                    report.putLong("tidy_" + format.extension() + "_output_bytes", result.outputBytes);
                    require(result.format == format && !result.fallback, "Benchmark uses requested real codec");
                    require(result.width == 1080 && result.height == 2400, "Screenshot pixels are never scaled");
                    checkPixels(MediaConverter.decodeOutput(Files.readAllBytes(result.output.toPath()), result.format));
                    Uri uri = findImage(context, result.output);
                    report.putString("tidy_" + format.extension() + "_image_uri", String.valueOf(uri));
                    report.putBoolean("tidy_" + format.extension() + "_original_deleted", result.originalDeleted);
                    if (format == OutputFormat.WEBP || result.originalDeleted) {
                        uri = requireIndexed(context, result);
                        require(result.outputBytes < before.length && result.originalDeleted && !source.exists(),
                                "Smaller screenshot source removed only with readable Gallery replacement");
                        try (InputStream input = context.getContentResolver().openInputStream(uri)) {
                            checkPixels(BitmapFactory.decodeStream(input));
                        }
                        awaitRemoved(context, source);
                    } else {
                        require(before.matches(source), "Gallery-unavailable AVIF retains exact original");
                        if (uri != null) {
                            boolean readable = false;
                            try {
                                requireIndexed(context, result);
                                readable = true;
                            } catch (AssertionError unavailable) {
                                status.putString("tidy_gallery_unavailable", unavailable.getMessage());
                            }
                            require(!readable || result.outputBytes >= before.length,
                                    "Readable smaller AVIF should honor deletion consent");
                        } else {
                            status.putString("tidy_gallery_unavailable", "Platform did not index AVIF as an image");
                        }
                    }
                    status.putString("tidy_status", "passed");
                    instrumentation.sendStatus(0, status);
                } catch (Throwable failure) {
                    failures.add(name + ": " + failure.getClass().getSimpleName() + ": " + failure.getMessage());
                    status.putString("tidy_status", "failed");
                    status.putString("tidy_error", failure.getMessage());
                    instrumentation.sendStatus(-1, status);
                }
            }
            checks++;
            try {
                state.setFormat(MediaCategory.SCREENSHOTS, OutputFormat.WEBP);
                unavailableRoot = Files.createTempDirectory(context.getCacheDir().toPath(),
                        "tidy-unindexed-").toFile().getCanonicalFile();
                File source = image(unavailableRoot, "no-gallery.png");
                MediaConverter.SourceSnapshot before = MediaConverter.SourceSnapshot.capture(source);
                MediaConverter privateConverter = new MediaConverter(context,
                        new PathPolicy(Collections.singletonList(unavailableRoot), Collections.emptyList()));
                MediaConverter.Result result = privateConverter.convert(source,
                        state.config(MediaCategory.SCREENSHOTS));
                require(result.outputBytes < before.length, "Unavailable-index fixture would otherwise qualify for deletion");
                require(!result.originalDeleted && before.matches(source), "Missing Gallery index retains exact original");
                checkPixels(MediaConverter.decodeOutput(Files.readAllBytes(result.output.toPath()), result.format));
            } catch (Throwable failure) {
                failures.add("gallery_unavailable_retains_source: " + failure.getClass().getSimpleName()
                        + ": " + failure.getMessage());
            }
        } catch (Throwable failure) {
            failures.add("setup: " + failure.getClass().getSimpleName() + ": " + failure.getMessage());
        } finally {
            try {
                if (root != null) cleanup(context, root);
                if (unavailableRoot != null) {
                    File[] owned = unavailableRoot.listFiles();
                    if (owned != null) for (File file : owned) Files.deleteIfExists(file.toPath());
                    Files.deleteIfExists(unavailableRoot.toPath());
                }
            } catch (Exception failure) {
                failures.add("owned fixture cleanup: " + failure.getMessage());
            }
            target.deleteSharedPreferences(id + "-state");
            target.deleteSharedPreferences(id + "-tidy_ui");
        }
        report.putInt("tidy_checks", checks);
        report.putInt("tidy_passed", Math.max(0, checks - failures.size()));
        report.putInt("tidy_failed", failures.size());
        report.putString("tidy_errors", String.join("\n", failures));
        report.putString("stream", "Owned Gallery checks: " + checks + ", failures: " + failures.size()
                + "\n" + String.join("\n", failures) + "\n");
        instrumentation.finish(failures.isEmpty() ? Activity.RESULT_OK : Activity.RESULT_CANCELED, report);
    }

    private static File image(File root, String name) throws Exception {
        Bitmap bitmap = Bitmap.createBitmap(1080, 2400, Bitmap.Config.ARGB_8888);
        Random random = new Random(230);
        int[] row = new int[1080];
        for (int y = 0; y < 2400; y++) {
            for (int x = 0; x < row.length; x++) {
                row[x] = y >= 2200 ? 0xff000000 | random.nextInt(0x1000000)
                        : y < 1200 ? (x < 540 ? Color.RED : Color.GREEN)
                        : (x < 540 ? Color.BLUE : Color.YELLOW);
            }
            bitmap.setPixels(row, 0, row.length, 0, y, row.length, 1);
        }
        // Real screen captures are opaque; encoded PNG alpha has separate codec regressions.
        File file = new File(root, name);
        try (FileOutputStream output = new FileOutputStream(file)) {
            require(bitmap.compress(Bitmap.CompressFormat.PNG, 100, output), "Generate synthetic screenshot PNG");
        } finally {
            bitmap.recycle();
        }
        return file;
    }

    private static void checkPixels(Bitmap bitmap) {
        require(bitmap != null, "Screenshot output decodes");
        try {
            require(bitmap.getWidth() == 1080 && bitmap.getHeight() == 2400, "Decoded screenshot dimensions");
            require(Color.alpha(bitmap.getPixel(20, 20)) == 255, "Screenshot remains opaque");
            nearColor(bitmap.getPixel(270, 600), Color.RED);
            nearColor(bitmap.getPixel(810, 600), Color.GREEN);
            nearColor(bitmap.getPixel(270, 1800), Color.BLUE);
            nearColor(bitmap.getPixel(810, 1800), Color.YELLOW);
        } finally {
            bitmap.recycle();
        }
    }

    private static void nearColor(int actual, int expected) {
        require(Math.abs(Color.red(actual) - Color.red(expected)) < 65
                && Math.abs(Color.green(actual) - Color.green(expected)) < 65
                && Math.abs(Color.blue(actual) - Color.blue(expected)) < 65, "Screenshot quadrant color retained");
    }

    private static byte[] readBytes(InputStream input) throws Exception {
        java.io.ByteArrayOutputStream bytes = new java.io.ByteArrayOutputStream();
        byte[] buffer = new byte[32 * 1024];
        int count;
        while ((count = input.read(buffer)) != -1) bytes.write(buffer, 0, count);
        return bytes.toByteArray();
    }

    private static void requireOwned(File file) throws Exception {
        File pictures = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                .getCanonicalFile();
        File relative = file.getCanonicalFile();
        while (relative.getParentFile() != null && !relative.getParentFile().equals(pictures)) {
            relative = relative.getParentFile();
        }
        require(pictures.equals(relative.getParentFile()) && relative.getName().startsWith("tidy-gallery-check-"),
                "Queries and cleanup must remain in generated unique Pictures fixture roots");
    }

    private static void require(boolean value, String message) {
        if (!value) throw new AssertionError(message);
    }
}
