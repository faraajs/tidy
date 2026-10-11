package id.eska.screenshotwebp;

import android.content.Context;
import android.os.Environment;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

public final class PathPolicy {
    private static final MediaCategory[] CATEGORIES = MediaCategory.values();
    private static final char[] HEX = "0123456789abcdef".toCharArray();
    private final List<File> screenshotRoots;
    private final List<File> photoRoots;

    public PathPolicy(Context context) {
        Objects.requireNonNull(context, "context");
        File storage;
        try {
            storage = Environment.getExternalStorageDirectory().getCanonicalFile();
        } catch (IOException error) {
            throw new IllegalStateException("Shared storage path is unavailable", error);
        }
        screenshotRoots = List.of(new File(storage, "Pictures/Screenshots"),
                new File(storage, "DCIM/Screenshots"));
        photoRoots = List.of(new File(storage, "DCIM/Camera"));
    }

    // Injectable roots permit disposable policy/conversion tests without personal media.
    PathPolicy(List<File> screenshotRoots, List<File> photoRoots) {
        this.screenshotRoots = List.copyOf(screenshotRoots);
        this.photoRoots = List.copyOf(photoRoots);
    }

    public List<File> roots(MediaCategory category) {
        return Objects.requireNonNull(category, "category") == MediaCategory.SCREENSHOTS
                ? screenshotRoots : photoRoots;
    }

    public MediaCategory categoryOf(File candidate) {
        try {
            if (candidate == null || !supported(candidate) || !candidate.isFile()
                    || !candidate.canRead()) {
                return null;
            }
            for (MediaCategory category : CATEGORIES) {
                for (File root : roots(category)) {
                    if (isScopedFile(root, candidate)) {
                        return category;
                    }
                }
            }
            return null;
        } catch (SecurityException error) {
            return null;
        }
    }

    public boolean accepts(File candidate, AppStateStore.Config config) {
        try {
            return candidate != null && config != null && config.enabled
                    && config.activatedAtMillis > 0
                    && modifiedMillis(candidate) >= config.activatedAtMillis
                    && categoryOf(candidate) == config.category;
        } catch (IOException | SecurityException error) {
            return false;
        }
    }

    // Both File and NIO modification-time readers truncate fractions on Android 11.
    static long modifiedMillis(File file) throws IOException {
        try {
            StructStat stat = Os.stat(file.getPath());
            return stat.st_mtim.tv_sec * 1000L + stat.st_mtim.tv_nsec / 1_000_000L;
        } catch (ErrnoException failure) {
            throw new IOException("Image modification time is unavailable", failure);
        }
    }

    static boolean supported(File file) {
        String name = file.getName();
        return name.regionMatches(true, name.length() - 4, ".jpg", 0, 4)
                || name.regionMatches(true, name.length() - 5, ".jpeg", 0, 5)
                || name.regionMatches(true, name.length() - 4, ".png", 0, 4);
    }

    static boolean isScopedFile(File root, File candidate) {
        try {
            File lexicalRoot = root.getAbsoluteFile().toPath().normalize().toFile();
            File lexicalCandidate = candidate.getAbsoluteFile().toPath().normalize().toFile();
            File canonicalRoot = root.getCanonicalFile();
            File canonicalCandidate = candidate.getCanonicalFile();
            // Roots must not themselves redirect monitoring into some other shared folder.
            return lexicalRoot.equals(canonicalRoot)
                    && descendant(lexicalRoot, lexicalCandidate)
                    && descendant(canonicalRoot, canonicalCandidate)
                    && allowedRelativePath(lexicalRoot, lexicalCandidate)
                    && allowedRelativePath(canonicalRoot, canonicalCandidate)
                    && supported(lexicalCandidate) && supported(canonicalCandidate);
        } catch (IOException | SecurityException error) {
            return false;
        }
    }

    static boolean descendant(File root, File candidate) {
        String rootPath = root.getPath();
        String prefix = rootPath.endsWith(File.separator) ? rootPath : rootPath + File.separator;
        return candidate.getPath().startsWith(prefix) && !candidate.equals(root);
    }

    private static boolean allowedRelativePath(File root, File candidate) {
        for (java.nio.file.Path component : root.toPath().relativize(candidate.toPath())) {
            String name = component.toString();
            if (name.startsWith(".") || name.equalsIgnoreCase("Android")
                    || name.equalsIgnoreCase("cache")) {
                return false;
            }
        }
        return true;
    }

    public String fingerprint(File source, OutputFormat format) throws IOException {
        return fingerprintOf(source, format);
    }

    static String fingerprintOf(File source, OutputFormat format) throws IOException {
        Objects.requireNonNull(source, "source");
        Objects.requireNonNull(format, "format");
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(source.getCanonicalPath().getBytes(StandardCharsets.UTF_8));
            digest.update((byte) 0);
            digest.update(Long.toString(modifiedMillis(source)).getBytes(StandardCharsets.US_ASCII));
            digest.update((byte) 0);
            digest.update(Long.toString(source.length()).getBytes(StandardCharsets.US_ASCII));
            digest.update((byte) 0);
            digest.update(format.name().getBytes(StandardCharsets.US_ASCII));
            byte[] bytes = digest.digest();
            char[] hex = new char[bytes.length * 2];
            for (int i = 0; i < bytes.length; i++) {
                hex[i * 2] = HEX[(bytes[i] & 0xff) >>> 4];
                hex[i * 2 + 1] = HEX[bytes[i] & 0x0f];
            }
            return new String(hex);
        } catch (NoSuchAlgorithmException error) {
            throw new IOException("SHA-256 is unavailable", error);
        }
    }
}
