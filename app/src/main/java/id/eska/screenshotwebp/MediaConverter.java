package id.eska.screenshotwebp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;

import androidx.exifinterface.media.ExifInterface;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;

/** Local lossy conversion; source retention is the default and metadata is not copied. */
public final class MediaConverter {
    private static final long MAX_PIXELS = 16_777_216L;
    private static final int MAX_DIMENSION = 16_384;
    private static final int MAX_ENCODED_BYTES = 64 * 1024 * 1024;
    private static final long MAX_SOURCE_BYTES = 256L * 1024 * 1024;
    private static final int[] PHOTO_QUALITIES = {85, 55, 25};
    private static final float[] PHOTO_SCALES = {1f, .75f, .5f, .25f};
    private final PathPolicy paths;
    private final AppStateStore state;

    public MediaConverter(Context context, PathPolicy paths) {
        this.paths = paths;
        this.state = new AppStateStore(context);
    }

    public static final class Result {
        public final File output;
        public final MediaCategory category;
        public final OutputFormat format;
        public final long sourceBytes, outputBytes;
        public final int width, height;
        public final boolean fallback, targetMet, originalDeleted;

        public Result(File output, MediaCategory category, OutputFormat format,
                long sourceBytes, long outputBytes, int width, int height,
                boolean fallback, boolean targetMet, boolean originalDeleted) {
            this.output = output;
            this.category = category;
            this.format = format;
            this.sourceBytes = sourceBytes;
            this.outputBytes = outputBytes;
            this.width = width;
            this.height = height;
            this.fallback = fallback;
            this.targetMet = targetMet;
            this.originalDeleted = originalDeleted;
        }
    }

    public Result convert(File source, AppStateStore.Config config) throws IOException {
        if (source == null || config == null || !paths.accepts(source, config)) {
            throw new IOException("Source is not eligible for this enabled category");
        }
        File canonical = source.getCanonicalFile();
        SourceSnapshot captured = SourceSnapshot.capture(canonical);
        Bitmap bitmap = null;
        File published = null;
        StructStat owned = null;
        try {
            bitmap = decodeSource(canonical, config.category);
            long target = targetBytes(config.category, captured.length);
            Candidate candidate;
            boolean fallback = false;
            try {
                candidate = chooseCandidate(bitmap, config.category, config.format, target);
            } catch (IOException firstFailure) {
                if (config.category == MediaCategory.SCREENSHOTS
                        && config.format == OutputFormat.WEBP) {
                    throw firstFailure;
                }
                OutputFormat alternate = config.format == OutputFormat.AVIF
                        ? OutputFormat.WEBP : OutputFormat.AVIF;
                try {
                    candidate = chooseCandidate(bitmap, config.category, alternate, target);
                    fallback = true;
                } catch (IOException fallbackFailure) {
                    fallbackFailure.addSuppressed(firstFailure);
                    throw fallbackFailure;
                }
            }
            bitmap.recycle();
            bitmap = null;
            if (!paths.accepts(canonical, config) || !canonical.equals(canonical.getCanonicalFile())
                    || !captured.matches(canonical) || !settingsMatch(config)) {
                throw new IOException("Source or conversion settings changed before publication");
            }
            String name = canonical.getName();
            int dot = name.lastIndexOf('.');
            String stem = dot > 0 ? name.substring(0, dot) : name;
            // O_CREAT | O_EXCL provides atomic CREATE_NEW with descriptor-based ownership.
            for (int suffix = 0; suffix < 10_000; suffix++) {
                String extra = suffix == 0 ? "" : " (" + suffix + ")";
                File destination = new File(canonical.getParentFile(),
                        stem + ".tidy" + extra + "." + candidate.format.extension());
                FileDescriptor descriptor;
                try {
                    descriptor = Os.open(destination.getPath(), OsConstants.O_WRONLY
                            | OsConstants.O_CREAT | OsConstants.O_EXCL | OsConstants.O_NOFOLLOW, 0600);
                } catch (ErrnoException collision) {
                    if (collision.errno == OsConstants.EEXIST) continue;
                    throw new IOException("Could not reserve a new output file", collision);
                }
                published = destination;
                try (FileOutputStream stream = new FileOutputStream(descriptor)) {
                    try {
                        owned = Os.fstat(descriptor);
                    } catch (ErrnoException failure) {
                        throw new IOException("Could not identify the reserved output", failure);
                    }
                    FileChannel output = stream.getChannel();
                    ByteBuffer bytes = ByteBuffer.wrap(candidate.bytes);
                    while (bytes.hasRemaining()) output.write(bytes);
                    output.force(true);
                }
                break;
            }
            if (published == null) throw new IOException("No unused output filename available");
            if (!sameIdentity(owned, stat(published))) {
                throw new IOException("Output was replaced during publication");
            }
            verifyPublished(published, candidate.bytes, candidate.format,
                    candidate.width, candidate.height);
            boolean deleted = config.deleteOriginals
                    && deleteOriginalIfUnchanged(canonical, captured, published,
                            candidate.bytes, candidate.format, candidate.width, candidate.height, config);
            return new Result(published, config.category, candidate.format, captured.length,
                    candidate.bytes.length, candidate.width, candidate.height, fallback,
                    candidate.bytes.length <= target, deleted);
        } catch (OutOfMemoryError exhausted) {
            removeOwnedOutput(published, owned);
            throw new IOException("Image exceeds available conversion memory", exhausted);
        } catch (IOException | RuntimeException failure) {
            removeOwnedOutput(published, owned);
            if (failure instanceof IOException) throw (IOException) failure;
            throw new IOException("Image conversion failed", failure);
        } finally {
            if (bitmap != null && !bitmap.isRecycled()) bitmap.recycle();
        }
    }

    private boolean settingsMatch(AppStateStore.Config requested) {
        AppStateStore.Config fresh = state.config(requested.category);
        return fresh.enabled && fresh.activatedAtMillis == requested.activatedAtMillis
                && fresh.format == requested.format
                && fresh.deleteOriginals == requested.deleteOriginals
                && state.monitoringRequested();
    }

    static long targetBytes(MediaCategory category, long sourceBytes) {
        if (category == MediaCategory.SCREENSHOTS || sourceBytes <= 500L * 1024) {
            return 100L * 1024;
        }
        if (sourceBytes > 3L * 1024 * 1024) return 750L * 1024;
        if (sourceBytes > 1024L * 1024) return 500L * 1024;
        return 250L * 1024;
    }

    private static Bitmap decodeSource(File source, MediaCategory category) throws IOException {
        BitmapFactory.Options bounds = new BitmapFactory.Options();
        bounds.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(source.getPath(), bounds);
        if (bounds.outWidth <= 0 || bounds.outHeight <= 0) {
            throw new IOException("Source is not a decodable JPEG or PNG image");
        }
        int sample = 1;
        if (category == MediaCategory.PHOTOS) {
            while ((Math.max(bounds.outWidth, bounds.outHeight) + (long) sample - 1) / sample
                    > 2560) sample *= 2;
        }
        int width = (int) ((bounds.outWidth + (long) sample - 1) / sample);
        int height = (int) ((bounds.outHeight + (long) sample - 1) / sample);
        checkDimensions(width, height);
        ExifInterface exif = new ExifInterface(source);
        int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_NORMAL);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = sample;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inMutable = true;
        options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        Bitmap decoded = BitmapFactory.decodeFile(source.getPath(), options);
        if (decoded == null) throw new IOException("Source pixels could not be decoded");
        try {
            checkDimensions(decoded.getWidth(), decoded.getHeight());
            Matrix transform = orientationMatrix(orientation);
            if (transform.isIdentity()) return decoded;
            Bitmap oriented = Bitmap.createBitmap(decoded, 0, 0, decoded.getWidth(),
                    decoded.getHeight(), transform, true);
            if (oriented != decoded) decoded.recycle();
            return oriented;
        } catch (IOException | RuntimeException | OutOfMemoryError failure) {
            decoded.recycle();
            throw failure;
        }
    }

    static Matrix orientationMatrix(int orientation) {
        Matrix matrix = new Matrix();
        switch (orientation) {
            case ExifInterface.ORIENTATION_FLIP_HORIZONTAL: matrix.setScale(-1, 1); break;
            case ExifInterface.ORIENTATION_ROTATE_180: matrix.setRotate(180); break;
            case ExifInterface.ORIENTATION_FLIP_VERTICAL: matrix.setScale(1, -1); break;
            case ExifInterface.ORIENTATION_TRANSPOSE:
                matrix.setValues(new float[]{0, 1, 0, 1, 0, 0, 0, 0, 1}); break;
            case ExifInterface.ORIENTATION_ROTATE_90: matrix.setRotate(90); break;
            case ExifInterface.ORIENTATION_TRANSVERSE:
                matrix.setValues(new float[]{0, -1, 0, -1, 0, 0, 0, 0, 1}); break;
            case ExifInterface.ORIENTATION_ROTATE_270: matrix.setRotate(270); break;
            default: break;
        }
        return matrix;
    }

    private static void checkDimensions(int width, int height) throws IOException {
        if (width <= 0 || height <= 0 || width > MAX_DIMENSION || height > MAX_DIMENSION
                || (long) width * height > MAX_PIXELS) {
            throw new IOException("Image dimensions exceed safe bitmap limits");
        }
    }

    private static Candidate chooseCandidate(Bitmap original, MediaCategory category,
            OutputFormat format, long target) throws IOException {
        if (category == MediaCategory.SCREENSHOTS) return encode(original, format, 55);
        Candidate smallest = null;
        IOException lastFailure = null;
        for (float scale : PHOTO_SCALES) {
            Bitmap scaled = original;
            try {
                if (scale != 1f) scaled = Bitmap.createScaledBitmap(original,
                        Math.max(1, Math.round(original.getWidth() * scale)),
                        Math.max(1, Math.round(original.getHeight() * scale)), true);
                for (int quality : PHOTO_QUALITIES) {
                    try {
                        Candidate next = encode(scaled, format, quality);
                        if (smallest == null || next.bytes.length < smallest.bytes.length) {
                            smallest = next;
                        }
                        if (smallest.bytes.length <= target) return smallest;
                    } catch (IOException failed) {
                        lastFailure = failed;
                    }
                }
            } finally {
                if (scaled != original) scaled.recycle();
            }
        }
        if (smallest != null) return smallest;
        throw lastFailure != null ? lastFailure : new IOException("No valid encoded candidate");
    }

    private static Candidate encode(Bitmap bitmap, OutputFormat format, int quality)
            throws IOException {
        byte[] bytes;
        try {
            if (format == OutputFormat.AVIF) {
                bytes = NativeAvif.encode(bitmap, quality);
            } else {
                LimitedBytes output = new LimitedBytes();
                if (!bitmap.compress(Bitmap.CompressFormat.WEBP_LOSSY, quality, output)) {
                    throw new IOException("WebP encoding failed");
                }
                bytes = output.toByteArray();
            }
            verifyEncoded(bytes, format, bitmap.getWidth(), bitmap.getHeight());
        } catch (LinkageError | RuntimeException failure) {
            throw new IOException(format + " codec failed", failure);
        }
        return new Candidate(bytes, format, bitmap.getWidth(), bitmap.getHeight());
    }

    static Bitmap decodeOutput(byte[] bytes, OutputFormat format) throws IOException {
        Bitmap bitmap;
        try {
            bitmap = format == OutputFormat.AVIF ? NativeAvif.decode(bytes)
                    : BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        } catch (LinkageError | RuntimeException failure) {
            throw new IOException("Output decoding failed", failure);
        }
        if (bitmap == null) throw new IOException("Output could not be decoded");
        return bitmap;
    }

    private static void verifyEncoded(byte[] bytes, OutputFormat format, int width, int height)
            throws IOException {
        if (bytes == null || bytes.length == 0 || bytes.length > MAX_ENCODED_BYTES) {
            throw new IOException("Encoded image exceeds safe byte limits or is empty");
        }
        Bitmap decoded = decodeOutput(bytes, format);
        try {
            if (decoded.getWidth() != width || decoded.getHeight() != height) {
                throw new IOException("Encoded image dimensions differ from expected pixels");
            }
        } finally {
            decoded.recycle();
        }
    }

    private static void verifyPublished(File output, byte[] expected, OutputFormat format,
            int width, int height) throws IOException {
        if (output.length() != expected.length || !Arrays.equals(hash(output), digest(expected))) {
            throw new IOException("Published output bytes changed or were incomplete");
        }
        byte[] actual = new byte[expected.length];
        try (InputStream input = Files.newInputStream(output.toPath())) {
            int offset = 0;
            while (offset < actual.length) {
                int count = input.read(actual, offset, actual.length - offset);
                if (count == -1) throw new IOException("Published output was truncated");
                offset += count;
            }
            if (input.read() != -1) throw new IOException("Published output grew during verification");
        }
        if (!Arrays.equals(actual, expected)) throw new IOException("Output changed during verification");
        verifyEncoded(actual, format, width, height);
    }

    /** No replacement rename on either leg; if restore is blocked, keep the named backup. */
    boolean deleteOriginalIfUnchanged(File source, SourceSnapshot snapshot, File output,
            byte[] encoded, OutputFormat format, int width, int height, AppStateStore.Config consent) {
        if (!consent.deleteOriginals || encoded.length >= snapshot.length || !settingsMatch(consent)) {
            return false;
        }
        File backup = new File(source.getParentFile(), "." + source.getName()
                + ".tidy-source-backup-" + UUID.randomUUID());
        boolean moved = false;
        try {
            verifyPublished(output, encoded, format, width, height);
            if (!snapshot.matches(source) || !settingsMatch(consent)) return false;
            moved = NativeAvif.renameNoReplace(source.getPath(), backup.getPath());
            if (!moved) return false;
            // Validate what was actually renamed, not the possibly newly recreated source path.
            if (!snapshot.matches(backup)) return false;
            verifyPublished(output, encoded, format, width, height);
            if (!snapshot.matches(backup) || !settingsMatch(consent)) return false;
            Files.delete(backup.toPath());
            moved = false;
            return true;
        } catch (IOException | LinkageError | RuntimeException failure) {
            return false;
        } finally {
            if (moved) {
                try {
                    NativeAvif.renameNoReplace(backup.getPath(), source.getPath());
                } catch (IOException | LinkageError | RuntimeException restoreBlocked) {
                    // Never replace an externally recreated source; backup remains recoverable.
                }
            }
        }
    }

    static final class SourceSnapshot {
        final long length, modified, device, inode;
        final byte[] sha256;

        private SourceSnapshot(StructStat stat, long modified, byte[] sha256) {
            this.length = stat.st_size;
            this.modified = modified;
            this.device = stat.st_dev;
            this.inode = stat.st_ino;
            this.sha256 = sha256;
        }

        static SourceSnapshot capture(File source) throws IOException {
            StructStat before = stat(source);
            long modified = modifiedMillis(before);
            if (!OsConstants.S_ISREG(before.st_mode) || before.st_size <= 0
                    || before.st_size > MAX_SOURCE_BYTES) {
                throw new IOException("Source must be a regular file within safe byte limits");
            }
            byte[] hash = hash(source);
            StructStat after = stat(source);
            if (!sameIdentity(before, after) || before.st_size != after.st_size
                    || modified != modifiedMillis(after)) {
                throw new IOException("Source changed while capturing its identity");
            }
            return new SourceSnapshot(after, modified, hash);
        }

        boolean matches(File file) throws IOException {
            StructStat before = stat(file);
            if (before.st_dev != device || before.st_ino != inode || before.st_size != length
                    || modifiedMillis(before) != modified) return false;
            byte[] current = hash(file);
            StructStat after = stat(file);
            return sameIdentity(before, after) && after.st_size == length
                    && modifiedMillis(after) == modified && Arrays.equals(sha256, current);
        }
    }

    private static StructStat stat(File file) throws IOException {
        try {
            return Os.lstat(file.getPath());
        } catch (ErrnoException failure) {
            throw new IOException("Image file identity is unavailable", failure);
        }
    }

    private static long modifiedMillis(StructStat stat) {
        return stat.st_mtim.tv_sec * 1000L + stat.st_mtim.tv_nsec / 1_000_000L;
    }

    private static boolean sameIdentity(StructStat a, StructStat b) {
        return a.st_dev == b.st_dev && a.st_ino == b.st_ino;
    }

    private static MessageDigest sha256() {
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException impossible) {
            throw new AssertionError(impossible);
        }
    }

    private static byte[] digest(byte[] bytes) {
        return sha256().digest(bytes);
    }

    private static byte[] hash(File file) throws IOException {
        MessageDigest digest = sha256();
        try (InputStream input = Files.newInputStream(file.toPath())) {
            byte[] buffer = new byte[32 * 1024];
            int count;
            long total = 0;
            while ((count = input.read(buffer)) != -1) {
                total += count;
                if (total > MAX_SOURCE_BYTES) throw new IOException("Image grew beyond safe byte limits");
                digest.update(buffer, 0, count);
            }
        }
        return digest.digest();
    }

    private static void removeOwnedOutput(File output, StructStat owned) {
        if (output == null || owned == null) return;
        try {
            if (sameIdentity(owned, stat(output))) Files.deleteIfExists(output.toPath());
        } catch (IOException ignored) {
            // Do not unlink an output replaced by another writer, or touch any source on failure.
        }
    }

    private static final class Candidate {
        final byte[] bytes;
        final OutputFormat format;
        final int width, height;

        Candidate(byte[] bytes, OutputFormat format, int width, int height) {
            this.bytes = bytes;
            this.format = format;
            this.width = width;
            this.height = height;
        }
    }

    private static final class LimitedBytes extends ByteArrayOutputStream {
        @Override public synchronized void write(int value) {
            if (count == MAX_ENCODED_BYTES) throw new IllegalStateException("WebP byte limit exceeded");
            super.write(value);
        }

        @Override public synchronized void write(byte[] bytes, int offset, int length) {
            if (length > MAX_ENCODED_BYTES - count) {
                throw new IllegalStateException("WebP byte limit exceeded");
            }
            super.write(bytes, offset, length);
        }
    }
}
