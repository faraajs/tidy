package id.eska.screenshotwebp;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.exifinterface.media.ExifInterface;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/** Runs only generated files below its unique app-cache directory. No personal media is read. */
public final class ConversionInstrumentation extends Instrumentation {
    private final List<String> failures = new ArrayList<>();
    private int checks;
    private Context context;
    private AppStateStore store;
    private File scratch, screenshots, photos;
    private MediaConverter converter;
    private String scenario;

    @Override public void onCreate(Bundle arguments) {
        super.onCreate(arguments);
        scenario = arguments == null ? null : arguments.getString("scenario");
        start();
    }

    @Override public void onStart() {
        context = getTargetContext();
        if (!Build.HARDWARE.equals("ranchu") && !Build.HARDWARE.equals("goldfish")) {
            Bundle refused = new Bundle();
            refused.putInt("tidy_failed", 1);
            refused.putString("tidy_errors", "This disposable runner is restricted to Android emulators.");
            finish(Activity.RESULT_CANCELED, refused);
            return;
        }
        if ("monitor".equals(scenario)) {
            MonitoringChecks.run(this, context);
            return;
        }
        store = new AppStateStore(context);
        AppStateStore.Config oldScreenshots = store.config(MediaCategory.SCREENSHOTS);
        AppStateStore.Config oldPhotos = store.config(MediaCategory.PHOTOS);
        boolean oldMonitoring = store.monitoringRequested();
        try {
            store.setMonitoringRequested(true);
            scratch = Files.createTempDirectory(context.getCacheDir().toPath(),
                    "tidy-conversion-instrumentation-").toFile().getCanonicalFile();
            screenshots = new File(scratch, "screenshots");
            photos = new File(scratch, "photos");
            require(screenshots.mkdir() && photos.mkdir(), "Create disposable roots");
            converter = new MediaConverter(context, new PathPolicy(
                    Collections.singletonList(screenshots), Collections.singletonList(photos)));
            if ("timestamp".equals(scenario)) {
                run("subsecond_activation_preserves_old_and_accepts_new", this::subsecondActivation);
            } else if ("fallback".equals(scenario)) {
                run("unavailable_avif_real_webp_fallback", this::unavailableAvifFallback);
            } else {
                run("native_avif_magic_pixels_alpha", this::nativeAvif);
                run("subsecond_activation_preserves_old_and_accepts_new", this::subsecondActivation);
                run("activation_consent_and_category_boundaries", this::activationConsent);
                run("durable_fingerprint_metadata_and_format_boundaries", this::fingerprintBoundaries);
                run("png_alpha_preserved_by_both_real_codecs", this::pngAlpha);
                run("all_eight_exif_orientations_and_metadata", this::orientations);
                run("avif_conversion_and_preserve_default", this::avifConversion);
                run("webp_existing_destinations_and_source_identity", this::collision);
                run("photo_sample_and_bounded_target", this::photoScaling);
                run("target_buckets_and_unmet_screenshot", this::targets);
                run("decode_error_preserves_source_and_paths", this::decodeError);
                run("explicit_delete_smaller_only", this::deleteSmaller);
                run("larger_output_never_deletes", this::largerOutput);
                run("same_size_same_mtime_source_change_prevents_delete", this::sourceChanged);
                run("changed_output_prevents_delete", this::outputChanged);
                run("no_replace_backup_and_rollback_collision", this::renameCollision);
                run("configuration_changed_preserves_source", this::configurationChanged);
                run("delete_consent_revoked_and_pause_before_commit", this::consentRevoked);
                run("real_preferences_safety_migration_history_accounting", this::stateMigration);
            }
        } catch (Throwable failure) {
            failures.add("setup: " + failure.getClass().getSimpleName() + ": " + failure.getMessage());
        } finally {
            restore(oldScreenshots);
            restore(oldPhotos);
            store.setMonitoringRequested(oldMonitoring);
            try {
                if (scratch != null) deleteTree(scratch);
            } catch (IOException cleanupFailure) {
                failures.add("disposable cleanup: " + cleanupFailure.getMessage());
            }
        }
        Bundle result = new Bundle();
        result.putInt("tidy_checks", checks);
        result.putInt("tidy_passed", Math.max(0, checks - failures.size()));
        result.putInt("tidy_failed", failures.size());
        result.putString("tidy_errors", String.join("\n", failures));
        result.putString("tidy_abi", Build.SUPPORTED_ABIS[0]);
        result.putInt("tidy_api", Build.VERSION.SDK_INT);
        result.putString("stream", "Tidy disposable conversion checks: " + checks
                + ", failures: " + failures.size() + "\n" + String.join("\n", failures) + "\n");
        finish(failures.isEmpty() ? Activity.RESULT_OK : Activity.RESULT_CANCELED, result);
    }

    private void run(String name, Check check) {
        checks++;
        Bundle status = new Bundle();
        status.putString("tidy_check", name);
        try {
            check.run();
            status.putString("tidy_status", "passed");
            sendStatus(0, status);
        } catch (Throwable failure) {
            String error = name + ": " + failure.getClass().getSimpleName() + ": " + failure.getMessage();
            failures.add(error);
            status.putString("tidy_status", "failed");
            status.putString("tidy_error", error);
            sendStatus(-1, status);
        }
    }

    private AppStateStore.Config configure(MediaCategory category, OutputFormat format, boolean delete) {
        store.setEnabled(category, true);
        store.setFormat(category, format);
        store.setDeleteOriginals(category, delete);
        return store.config(category);
    }

    private void restore(AppStateStore.Config previous) {
        store.setEnabled(previous.category, false);
        store.setFormat(previous.category, previous.format);
        store.setDeleteOriginals(previous.category, previous.deleteOriginals);
        store.setEnabled(previous.category, previous.enabled);
    }

    private void nativeAvif() throws Exception {
        Bitmap original = quadrants(96, 64);
        byte[] bytes;
        try {
            original.setPixel(0, 0, Color.TRANSPARENT);
            bytes = NativeAvif.encode(original, 85);
        } finally {
            original.recycle();
        }
        require(bytes.length > 20 && ascii(bytes, 4, 4).equals("ftyp"), "AVIF file type box");
        require(new String(bytes, 8, Math.min(56, bytes.length - 8), StandardCharsets.ISO_8859_1)
                .contains("avif"), "AVIF compatible brand");
        Bitmap decoded = NativeAvif.decode(bytes);
        try {
            require(decoded.getWidth() == 96 && decoded.getHeight() == 64, "Native dimensions");
            require(Color.alpha(decoded.getPixel(0, 0)) == 0, "AVIF alpha retained");
            nearColor(decoded.getPixel(12, 12), Color.RED);
        } finally {
            decoded.recycle();
        }
    }

    private void pngAlpha() throws Exception {
        for (OutputFormat format : OutputFormat.values()) {
            AppStateStore.Config config = configure(MediaCategory.SCREENSHOTS, format, false);
            Bitmap bitmap = quadrants(64, 48);
            bitmap.setPixel(12, 12, Color.TRANSPARENT);
            bitmap.setPixel(48, 12, Color.argb(128, 0, 255, 0));
            File source = image(screenshots, "alpha-" + format.extension() + ".png", bitmap,
                    Bitmap.CompressFormat.PNG);
            MediaConverter.Result result = converter.convert(source, config);
            require(result.format == format && !result.fallback, "Real requested alpha codec");
            Bitmap decoded = output(result);
            try {
                require(Color.alpha(decoded.getPixel(12, 12)) == 0, "Transparent PNG pixel retained");
                require(Math.abs(Color.alpha(decoded.getPixel(48, 12)) - 128) <= 1,
                        "Semitransparent PNG pixel retained");
            } finally {
                decoded.recycle();
            }
        }
    }

    private void orientations() throws Exception {
        AppStateStore.Config config = configure(MediaCategory.SCREENSHOTS, OutputFormat.WEBP, false);
        int R = Color.RED, G = Color.GREEN, B = Color.BLUE, Y = Color.YELLOW;
        int[][] corners = {{R,G,B,Y}, {G,R,Y,B}, {Y,B,G,R}, {B,Y,R,G},
                {R,B,G,Y}, {B,R,Y,G}, {Y,G,B,R}, {G,Y,R,B}};
        for (int orientation = 1; orientation <= 8; orientation++) {
            File source = image(screenshots, "orientation-" + orientation + ".jpg", quadrants(96, 64),
                    Bitmap.CompressFormat.JPEG);
            ExifInterface exif = new ExifInterface(source);
            exif.setAttribute(ExifInterface.TAG_ORIENTATION, Integer.toString(orientation));
            exif.setAttribute(ExifInterface.TAG_MAKE, "TidySyntheticCamera");
            exif.setAttribute(ExifInterface.TAG_MODEL, "TidySyntheticModel");
            exif.setLatLong(12.3456, 65.4321);
            exif.saveAttributes();
            MediaConverter.SourceSnapshot before = MediaConverter.SourceSnapshot.capture(source);
            MediaConverter.Result result = converter.convert(source, config);
            require(before.matches(source) && !result.originalDeleted, "Oriented original unchanged");
            int width = orientation >= 5 ? 64 : 96;
            int height = orientation >= 5 ? 96 : 64;
            require(result.width == width && result.height == height, "Orientation dimensions " + orientation);
            Bitmap decoded = output(result);
            try {
                nearColor(decoded.getPixel(width / 4, height / 4), corners[orientation - 1][0]);
                nearColor(decoded.getPixel(width * 3 / 4, height / 4), corners[orientation - 1][1]);
                nearColor(decoded.getPixel(width / 4, height * 3 / 4), corners[orientation - 1][2]);
                nearColor(decoded.getPixel(width * 3 / 4, height * 3 / 4), corners[orientation - 1][3]);
            } finally {
                decoded.recycle();
            }
            ExifInterface clean = new ExifInterface(result.output);
            require(clean.getAttribute(ExifInterface.TAG_MAKE) == null
                    && clean.getAttribute(ExifInterface.TAG_MODEL) == null
                    && clean.getLatLong() == null, "GPS/camera metadata stripped");
            byte[] bytes = Files.readAllBytes(result.output.toPath());
            require(ascii(bytes, 0, 4).equals("RIFF") && ascii(bytes, 8, 4).equals("WEBP"),
                    "Actual WebP bytes");
        }
    }

    private void avifConversion() throws Exception {
        AppStateStore.Config config = configure(MediaCategory.SCREENSHOTS, OutputFormat.AVIF, false);
        File source = image(screenshots, "real-avif.jpg", quadrants(128, 80), Bitmap.CompressFormat.JPEG);
        ExifInterface exif = new ExifInterface(source);
        exif.setAttribute(ExifInterface.TAG_MAKE, "TidySyntheticCamera");
        exif.setLatLong(10.25, 20.5);
        exif.saveAttributes();
        MediaConverter.SourceSnapshot before = MediaConverter.SourceSnapshot.capture(source);
        MediaConverter.Result result = converter.convert(source, config);
        require(result.format == OutputFormat.AVIF && !result.fallback, "Actual selected AVIF path");
        require(before.matches(source) && !result.originalDeleted, "Default retains source byte-for-byte");
        Bitmap decoded = output(result);
        try {
            require(decoded.getWidth() == 128 && decoded.getHeight() == 80, "Published AVIF decode");
            nearColor(decoded.getPixel(20, 20), Color.RED);
        } finally {
            decoded.recycle();
        }
        String bytes = new String(Files.readAllBytes(result.output.toPath()), StandardCharsets.ISO_8859_1);
        require(!bytes.contains("TidySyntheticCamera") && !bytes.contains("Exif"),
                "AVIF carries no camera/EXIF item");
    }

    private void subsecondActivation() throws Exception {
        long activation = System.currentTimeMillis() / 1000L * 1000L + 500L;
        File before = image(screenshots, "before-activation.png", quadrants(16, 16),
                Bitmap.CompressFormat.PNG);
        File after = image(screenshots, "after-activation.png", quadrants(16, 16),
                Bitmap.CompressFormat.PNG);
        Files.setLastModifiedTime(before.toPath(),
                java.nio.file.attribute.FileTime.fromMillis(activation - 1));
        Files.setLastModifiedTime(after.toPath(),
                java.nio.file.attribute.FileTime.fromMillis(activation + 1));
        AppStateStore.Config config = new AppStateStore.Config(MediaCategory.SCREENSHOTS,
                true, activation, OutputFormat.WEBP, false);
        PathPolicy policy = new PathPolicy(Collections.singletonList(screenshots),
                Collections.singletonList(photos));
        require(!policy.accepts(before, config), "Do not admit pre-activation media in the same second");
        require(policy.accepts(after, config), "Admit post-activation media without losing millisecond precision");
    }

    private void activationConsent() throws Exception {
        File source = image(screenshots, "consent-gate.png", quadrants(16, 16), Bitmap.CompressFormat.PNG);
        Files.setLastModifiedTime(source.toPath(), java.nio.file.attribute.FileTime.fromMillis(2000));
        PathPolicy policy = new PathPolicy(Collections.singletonList(screenshots),
                Collections.singletonList(photos));
        require(!policy.accepts(source, new AppStateStore.Config(MediaCategory.SCREENSHOTS,
                true, 2001, OutputFormat.AVIF, false)), "Reject old media");
        require(policy.accepts(source, new AppStateStore.Config(MediaCategory.SCREENSHOTS,
                true, 2000, OutputFormat.AVIF, false)), "Accept inclusive activation boundary");
        require(!policy.accepts(source, new AppStateStore.Config(MediaCategory.SCREENSHOTS,
                false, 1000, OutputFormat.AVIF, false)), "Disabled category rejects input");
        require(!policy.accepts(source, new AppStateStore.Config(MediaCategory.PHOTOS,
                true, 1000, OutputFormat.AVIF, false)), "Wrong category rejects input");
        require(!policy.accepts(source, new AppStateStore.Config(MediaCategory.SCREENSHOTS,
                true, 0, OutputFormat.AVIF, false)), "Missing activation rejects input");
    }

    private void fingerprintBoundaries() throws Exception {
        File source = image(screenshots, "fingerprint.png", quadrants(16, 16), Bitmap.CompressFormat.PNG);
        Files.setLastModifiedTime(source.toPath(), java.nio.file.attribute.FileTime.fromMillis(2001));
        String original = PathPolicy.fingerprintOf(source, OutputFormat.AVIF);
        require(original.equals(PathPolicy.fingerprintOf(new File(screenshots, "./fingerprint.png"),
                OutputFormat.AVIF)), "Canonical aliases identify the same input");
        require(!original.equals(PathPolicy.fingerprintOf(source, OutputFormat.WEBP)), "Requested format distinguishes history");
        File other = image(screenshots, "fingerprint-other.png", quadrants(16, 16), Bitmap.CompressFormat.PNG);
        require(!original.equals(PathPolicy.fingerprintOf(other, OutputFormat.AVIF)), "Different paths distinguish history");
        Files.setLastModifiedTime(source.toPath(), java.nio.file.attribute.FileTime.fromMillis(2002));
        require(!original.equals(PathPolicy.fingerprintOf(source, OutputFormat.AVIF)), "Subsecond modification distinguishes history");
        Files.write(source.toPath(), new byte[]{1, 2, 3, 4});
        Files.setLastModifiedTime(source.toPath(), java.nio.file.attribute.FileTime.fromMillis(2001));
        require(!original.equals(PathPolicy.fingerprintOf(source, OutputFormat.AVIF)), "Changed length distinguishes history");
    }

    private void unavailableAvifFallback() throws Exception {
        Bitmap probe = quadrants(32, 32);
        boolean unavailable = false;
        try {
            NativeAvif.encode(probe, 55);
        } catch (LinkageError expected) {
            unavailable = true;
        } finally {
            probe.recycle();
        }
        require(unavailable, "Run this scenario only with the private native-library-omitted fixture APK");
        for (MediaCategory category : MediaCategory.values()) {
            AppStateStore.Config config = configure(category, OutputFormat.AVIF, false);
            File source = image(category == MediaCategory.SCREENSHOTS ? screenshots : photos,
                    "unavailable-avif.png", quadrants(128, 80), Bitmap.CompressFormat.PNG);
            MediaConverter.SourceSnapshot before = MediaConverter.SourceSnapshot.capture(source);
            MediaConverter.Result result = converter.convert(source, config);
            require(result.fallback && result.format == OutputFormat.WEBP,
                    "Unavailable AVIF produces actual WebP for " + category);
            require(before.matches(source) && !result.originalDeleted, "Fallback retains original bytes");
            byte[] bytes = Files.readAllBytes(result.output.toPath());
            require(ascii(bytes, 0, 4).equals("RIFF") && ascii(bytes, 8, 4).equals("WEBP"),
                    "Fallback publishes a real WebP container");
            Bitmap decoded = output(result);
            try {
                require(decoded.getWidth() == 128 && decoded.getHeight() == 80, "Fallback dimensions");
                nearColor(decoded.getPixel(20, 20), Color.RED);
            } finally {
                decoded.recycle();
            }
        }
    }

    private void collision() throws Exception {
        AppStateStore.Config config = configure(MediaCategory.SCREENSHOTS, OutputFormat.WEBP, false);
        File source = image(screenshots, "collision.png", quadrants(64, 48), Bitmap.CompressFormat.PNG);
        File existing = new File(screenshots, "collision.tidy.webp");
        byte[] sentinel = "do not overwrite".getBytes(StandardCharsets.UTF_8);
        Files.write(existing.toPath(), sentinel);
        File directoryCollision = new File(screenshots, "collision.tidy (1).webp");
        require(directoryCollision.mkdir(), "Create directory collision");
        MediaConverter.SourceSnapshot before = MediaConverter.SourceSnapshot.capture(source);
        MediaConverter.Result result = converter.convert(source, config);
        require(result.output.getName().equals("collision.tidy (2).webp"), "Unique publication name");
        require(Arrays.equals(Files.readAllBytes(existing.toPath()), sentinel)
                && directoryCollision.isDirectory(), "Existing paths untouched");
        require(before.matches(source), "Source inode, mtime, length and hash retained");
    }

    private void photoScaling() throws Exception {
        AppStateStore.Config config = configure(MediaCategory.PHOTOS, OutputFormat.WEBP, false);
        File source = image(photos, "photo-sample.png", quadrants(4000, 1000), Bitmap.CompressFormat.PNG);
        MediaConverter.Result result = converter.convert(source, config);
        require(result.width == 2000 && result.height == 500, "Power-of-two photo sample");
        require(result.targetMet && result.outputBytes <= MediaConverter.targetBytes(MediaCategory.PHOTOS,
                result.sourceBytes), "Real bounded-target photo encoding");
        Bitmap decoded = output(result);
        decoded.recycle();
        File noisy = image(photos, "photo-bounded.png", noise(1400, 1000), Bitmap.CompressFormat.PNG);
        MediaConverter.Result bounded = converter.convert(noisy, config);
        require(bounded.width <= 1400 && bounded.height <= 1000
                && bounded.width >= 350 && bounded.height >= 250, "Photo scale remains in bounded range");
        require(bounded.targetMet == (bounded.outputBytes <= MediaConverter.targetBytes(
                MediaCategory.PHOTOS, bounded.sourceBytes)), "Target flag reports actual size");
        output(bounded).recycle();
    }

    private void targets() throws Exception {
        require(MediaConverter.targetBytes(MediaCategory.PHOTOS, 500 * 1024) == 100 * 1024,
                "100KiB inclusive threshold");
        require(MediaConverter.targetBytes(MediaCategory.PHOTOS, 500 * 1024 + 1) == 250 * 1024,
                "250KiB threshold");
        require(MediaConverter.targetBytes(MediaCategory.PHOTOS, 1024 * 1024 + 1) == 500 * 1024,
                "500KiB threshold");
        require(MediaConverter.targetBytes(MediaCategory.PHOTOS, 3 * 1024 * 1024 + 1) == 750 * 1024,
                "750KiB threshold");
        AppStateStore.Config config = configure(MediaCategory.SCREENSHOTS, OutputFormat.WEBP, false);
        File source = image(screenshots, "unmet.png", noise(1024, 1024), Bitmap.CompressFormat.PNG);
        MediaConverter.Result result = converter.convert(source, config);
        require(result.width == 1024 && result.height == 1024, "Screenshots never scaled to hit target");
        require(result.outputBytes > 100 * 1024 && !result.targetMet, "Unmet target reported honestly");
    }

    private void decodeError() throws Exception {
        AppStateStore.Config config = configure(MediaCategory.SCREENSHOTS, OutputFormat.AVIF, true);
        File source = new File(screenshots, "broken.png");
        byte[] invalid = "synthetic invalid image".getBytes(StandardCharsets.UTF_8);
        Files.write(source.toPath(), invalid);
        MediaConverter.SourceSnapshot before = MediaConverter.SourceSnapshot.capture(source);
        String[] names = screenshots.list();
        try {
            converter.convert(source, config);
            throw new AssertionError("Corrupt source accepted");
        } catch (IOException expected) {
            require(before.matches(source), "Error leaves source unchanged");
            String[] after = screenshots.list();
            Arrays.sort(names);
            Arrays.sort(after);
            require(Arrays.equals(names, after), "Error leaves directory paths unchanged");
        }
    }

    private void deleteSmaller() throws Exception {
        AppStateStore.Config config = configure(MediaCategory.SCREENSHOTS, OutputFormat.WEBP, true);
        File source = image(screenshots, "delete-smaller.png", noise(256, 256), Bitmap.CompressFormat.PNG);
        long sourceSize = source.length();
        MediaConverter.Result result = converter.convert(source, config);
        require(result.outputBytes < sourceSize && result.originalDeleted && !source.exists(),
                "Explicit smaller valid output deletes only captured original");
        output(result).recycle();
        require(noBackups(), "Successful deletion leaves no temporary source backup");
    }

    private void largerOutput() throws Exception {
        AppStateStore.Config config = configure(MediaCategory.SCREENSHOTS, OutputFormat.AVIF, true);
        Bitmap pixel = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        pixel.eraseColor(Color.RED);
        File source = image(screenshots, "tiny.png", pixel, Bitmap.CompressFormat.PNG);
        MediaConverter.SourceSnapshot before = MediaConverter.SourceSnapshot.capture(source);
        MediaConverter.Result result = converter.convert(source, config);
        require(result.format == OutputFormat.AVIF && result.outputBytes >= result.sourceBytes,
                "Synthetic AVIF size-gate precondition");
        require(!result.originalDeleted && before.matches(source), "Larger output retains source");
    }

    private void sourceChanged() throws Exception {
        AppStateStore.Config config = configure(MediaCategory.SCREENSHOTS, OutputFormat.WEBP, false);
        File source = image(screenshots, "source-changed.png", noise(256, 256), Bitmap.CompressFormat.PNG);
        MediaConverter.SourceSnapshot captured = MediaConverter.SourceSnapshot.capture(source);
        MediaConverter.Result result = converter.convert(source, config);
        byte[] changed = Files.readAllBytes(source.toPath());
        changed[changed.length - 1] ^= 1;
        Files.write(source.toPath(), changed);
        require(source.setLastModified(captured.modified), "Restore mtime for SHA-only change");
        byte[] outputBytes = Files.readAllBytes(result.output.toPath());
        AppStateStore.Config consent = configure(MediaCategory.SCREENSHOTS, OutputFormat.WEBP, true);
        require(!converter.deleteOriginalIfUnchanged(source, captured, result.output,
                outputBytes, result.format, result.width, result.height, consent), "SHA mismatch blocks delete");
        require(Arrays.equals(changed, Files.readAllBytes(source.toPath())), "Changed source retained");
        require(noBackups(), "Source mismatch never renamed original");
    }

    private void outputChanged() throws Exception {
        AppStateStore.Config config = configure(MediaCategory.SCREENSHOTS, OutputFormat.WEBP, false);
        File source = image(screenshots, "output-changed.png", noise(256, 256), Bitmap.CompressFormat.PNG);
        MediaConverter.SourceSnapshot captured = MediaConverter.SourceSnapshot.capture(source);
        MediaConverter.Result result = converter.convert(source, config);
        byte[] expected = Files.readAllBytes(result.output.toPath());
        Files.write(result.output.toPath(), new byte[]{1, 2, 3});
        AppStateStore.Config consent = configure(MediaCategory.SCREENSHOTS, OutputFormat.WEBP, true);
        require(!converter.deleteOriginalIfUnchanged(source, captured, result.output,
                expected, result.format, result.width, result.height, consent), "Output change blocks delete");
        require(captured.matches(source) && noBackups(), "Changed output leaves original untouched");
    }

    private void renameCollision() throws Exception {
        File source = new File(screenshots, "rename-source.png");
        File backup = new File(screenshots, ".rename-source-backup");
        byte[] original = {1, 2, 3, 4};
        byte[] replacement = {8, 7, 6};
        Files.write(source.toPath(), original);
        Files.write(backup.toPath(), replacement);
        require(!NativeAvif.renameNoReplace(source.getPath(), backup.getPath()), "Backup collision rejected");
        require(Arrays.equals(original, Files.readAllBytes(source.toPath()))
                && Arrays.equals(replacement, Files.readAllBytes(backup.toPath())), "Neither collision overwritten");
        Files.delete(backup.toPath());
        require(NativeAvif.renameNoReplace(source.getPath(), backup.getPath()), "Real backup rename");
        Files.write(source.toPath(), replacement);
        require(!NativeAvif.renameNoReplace(backup.getPath(), source.getPath()), "Rollback cannot overwrite new source");
        require(Arrays.equals(original, Files.readAllBytes(backup.toPath()))
                && Arrays.equals(replacement, Files.readAllBytes(source.toPath())), "Recoverable backup and recreated path retained");
        Files.delete(backup.toPath());
    }

    private void configurationChanged() throws Exception {
        AppStateStore.Config stale = configure(MediaCategory.SCREENSHOTS, OutputFormat.WEBP, true);
        File source = image(screenshots, "stale-settings.png", noise(128, 128), Bitmap.CompressFormat.PNG);
        MediaConverter.SourceSnapshot captured = MediaConverter.SourceSnapshot.capture(source);
        store.setEnabled(MediaCategory.SCREENSHOTS, false);
        try {
            converter.convert(source, stale);
            throw new AssertionError("Stale enabled configuration published");
        } catch (IOException expected) {
            require(captured.matches(source), "Paused settings preserve source");
            require(!new File(screenshots, "stale-settings.tidy.webp").exists(), "Paused settings publish nothing");
        }
    }

    private void consentRevoked() throws Exception {
        AppStateStore.Config config = configure(MediaCategory.SCREENSHOTS, OutputFormat.WEBP, false);
        File source = image(screenshots, "revoked-consent.png", noise(256, 256), Bitmap.CompressFormat.PNG);
        MediaConverter.SourceSnapshot captured = MediaConverter.SourceSnapshot.capture(source);
        MediaConverter.Result result = converter.convert(source, config);
        byte[] encoded = Files.readAllBytes(result.output.toPath());
        AppStateStore.Config consent = configure(MediaCategory.SCREENSHOTS, OutputFormat.WEBP, true);
        store.setDeleteOriginals(MediaCategory.SCREENSHOTS, false);
        require(!converter.deleteOriginalIfUnchanged(source, captured, result.output, encoded,
                result.format, result.width, result.height, consent), "Revoked opt-in blocks destructive commit");
        consent = configure(MediaCategory.SCREENSHOTS, OutputFormat.WEBP, true);
        store.setMonitoringRequested(false);
        try {
            require(!converter.deleteOriginalIfUnchanged(source, captured, result.output, encoded,
                    result.format, result.width, result.height, consent), "Pause blocks destructive commit");
            require(captured.matches(source) && noBackups(), "Consent revocation never moves or changes source");
        } finally {
            store.setMonitoringRequested(true);
        }
    }

    private void stateMigration() throws Exception {
        Context device = context.createDeviceProtectedStorageContext();
        String name = "tidy_instrumentation_" + System.nanoTime();
        SharedPreferences prefs = device.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences ui = device.getSharedPreferences(name + "_ui", Context.MODE_PRIVATE);
        try {
            require(prefs.edit().putString("screenshot_format", "WEBP")
                    .putString("photo_format", "AVIF").putInt("screenshot_count", 7)
                    .putLong("photo_count", 4).putLong("saved", 123456)
                    .putLong("screenshot_saved", 654321).putLong("fallback_count", 2)
                    .putBoolean("screenshot_enabled", true).putBoolean("photo_enabled", true)
                    .putLong("screenshot_activation", 1).putBoolean("delete_originals", true)
                    .putBoolean("monitoring_requested", true).commit(), "Seed real legacy preferences");
            require(ui.edit().putBoolean("dark_mode", false).commit(), "Seed real theme preferences");
            AppStateStore migrated = new AppStateStore(prefs, ui);
            AppStateStore.Config screenshotsConfig = migrated.config(MediaCategory.SCREENSHOTS);
            AppStateStore.Config photosConfig = migrated.config(MediaCategory.PHOTOS);
            require(screenshotsConfig.format == OutputFormat.WEBP && photosConfig.format == OutputFormat.AVIF,
                    "Migration retains separately selected formats");
            require(!screenshotsConfig.enabled && !photosConfig.enabled
                    && !screenshotsConfig.deleteOriginals && !photosConfig.deleteOriginals
                    && screenshotsConfig.activatedAtMillis == 0 && photosConfig.activatedAtMillis == 0
                    && !migrated.monitoringRequested(), "Migration discards legacy activation/deletion consent");
            AppStateStore.Snapshot oldCounts = migrated.snapshot();
            require(oldCounts.screenshotCount == 7 && oldCounts.photoCount == 4
                    && oldCounts.fallbackCount == 2 && oldCounts.savedBytes == 0,
                    "Migration retains counts, resets unproven reclaimed-space claims");
            require(!migrated.darkMode(), "Existing theme preference preserved");
            long before = System.currentTimeMillis();
            migrated.setEnabled(MediaCategory.SCREENSHOTS, true);
            migrated.setFormat(MediaCategory.SCREENSHOTS, OutputFormat.AVIF);
            migrated.setDeleteOriginals(MediaCategory.SCREENSHOTS, true);
            migrated.setMonitoringRequested(true);
            AppStateStore recreated = new AppStateStore(prefs, ui);
            AppStateStore.Config renewed = recreated.config(MediaCategory.SCREENSHOTS);
            require(renewed.enabled && renewed.deleteOriginals && renewed.format == OutputFormat.AVIF
                    && renewed.activatedAtMillis >= before && recreated.monitoringRequested(),
                    "Renewed explicit activation and consent persist across store recreation");
            AppStateStore.Config retainedConfig = configure(MediaCategory.SCREENSHOTS, OutputFormat.WEBP, false);
            File retainedSource = image(screenshots, "state-retained.png", noise(128, 128),
                    Bitmap.CompressFormat.PNG);
            MediaConverter.Result retained = converter.convert(retainedSource, retainedConfig);
            require(!retained.originalDeleted && retainedSource.exists(), "Accounting uses actually retained source");
            recreated.recordSuccess(retained);
            require(recreated.snapshot().screenshotCount == 8 && recreated.snapshot().savedBytes == 0,
                    "Retained originals never count as reclaimed storage");
            PathPolicy syntheticPaths = new PathPolicy(Collections.singletonList(screenshots),
                    Collections.singletonList(photos));
            String fingerprint = syntheticPaths.fingerprint(retainedSource, retained.format);
            recreated.markProcessed(fingerprint);
            require(prefs.contains("v23_processed_" + fingerprint), "Processed fingerprint committed to real disk preferences");
            AppStateStore reloaded = new AppStateStore(prefs, ui);
            require(reloaded.wasProcessed(fingerprint), "Retained-source fingerprint survives store recreation");
            AppStateStore.Config deletedConfig = configure(MediaCategory.SCREENSHOTS, OutputFormat.WEBP, true);
            File deletedSource = image(screenshots, "state-deleted.png", noise(128, 128),
                    Bitmap.CompressFormat.PNG);
            MediaConverter.Result deleted = converter.convert(deletedSource, deletedConfig);
            require(deleted.originalDeleted && !deletedSource.exists(), "Accounting uses actual opted-in deletion");
            reloaded.recordSuccess(deleted);
            require(reloaded.snapshot().savedBytes == deleted.sourceBytes - deleted.outputBytes,
                    "Only actual smaller-source deletion records reclaimed bytes");
        } finally {
            device.deleteSharedPreferences(name);
            device.deleteSharedPreferences(name + "_ui");
        }
    }

    private boolean noBackups() {
        File[] files = screenshots.listFiles();
        if (files == null) return false;
        for (File file : files) if (file.getName().contains(".tidy-source-backup-")) return false;
        return true;
    }

    private static Bitmap output(MediaConverter.Result result) throws IOException {
        byte[] bytes = Files.readAllBytes(result.output.toPath());
        require(result.outputBytes == bytes.length, "Result byte count is actual output size");
        return MediaConverter.decodeOutput(bytes, result.format);
    }

    private static File image(File root, String name, Bitmap bitmap, Bitmap.CompressFormat format)
            throws IOException {
        File file = new File(root, name);
        try (FileOutputStream output = new FileOutputStream(file)) {
            require(bitmap.compress(format, 100, output), "Create real synthetic source");
        } finally {
            bitmap.recycle();
        }
        return file;
    }

    private static Bitmap quadrants(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] row = new int[width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) row[x] = y < height / 2
                    ? (x < width / 2 ? Color.RED : Color.GREEN)
                    : (x < width / 2 ? Color.BLUE : Color.YELLOW);
            bitmap.setPixels(row, 0, width, 0, y, width, 1);
        }
        return bitmap;
    }

    private static Bitmap noise(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Random random = new Random(230);
        int[] row = new int[width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) row[x] = 0xff000000 | random.nextInt(0x1000000);
            bitmap.setPixels(row, 0, width, 0, y, width, 1);
        }
        return bitmap;
    }

    private static void nearColor(int actual, int expected) {
        require(Math.abs(Color.red(actual) - Color.red(expected)) < 65
                && Math.abs(Color.green(actual) - Color.green(expected)) < 65
                && Math.abs(Color.blue(actual) - Color.blue(expected)) < 65,
                "Decoded quadrant color " + Integer.toHexString(actual) + " expected " + Integer.toHexString(expected));
    }

    private static String ascii(byte[] bytes, int offset, int count) {
        return new String(bytes, offset, count, StandardCharsets.US_ASCII);
    }

    private static void require(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    private static void deleteTree(File file) throws IOException {
        File[] children = file.listFiles();
        if (children != null) for (File child : children) deleteTree(child);
        Files.deleteIfExists(file.toPath());
    }

    private interface Check { void run() throws Exception; }
}
