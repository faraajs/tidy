// SPDX-License-Identifier: GPL-3.0-only
package id.eska.screenshotwebp;

import android.graphics.Bitmap;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/** Source-built AVIF codec. Inputs are software ARGB_8888 pixels in sRGB. */
public final class NativeAvif {
    static {
        System.loadLibrary("tidyavif");
    }

    private NativeAvif() {}

    /** Encodes an 8-bit YUV444 still image with lossless alpha and no EXIF/XMP. */
    public static native byte[] encode(Bitmap bitmap, int quality) throws IOException;

    /** Decodes bounded 8-bit AVIF still images to premultiplied ARGB_8888. */
    public static native Bitmap decode(byte[] bytes) throws IOException;

    /**
     * Atomically moves a source only if the destination is absent. Unsupported
     * filesystem/kernel operations and existing destinations return false;
     * other failures throw. There is deliberately no overwrite fallback.
     */
    public static boolean renameNoReplace(String source, String destination) throws IOException {
        if (source == null || destination == null || source.isEmpty() || destination.isEmpty()
                || source.indexOf('\0') >= 0 || destination.indexOf('\0') >= 0) {
            throw new IOException("Atomic rename requires non-empty paths without NUL");
        }
        requireValidUnicode(source);
        requireValidUnicode(destination);
        // JNI modified UTF-8 cannot represent ordinary filesystem emoji paths.
        return renameNoReplaceUtf8(source.getBytes(StandardCharsets.UTF_8),
                destination.getBytes(StandardCharsets.UTF_8));
    }

    private static void requireValidUnicode(String path) throws IOException {
        for (int i = 0; i < path.length(); i++) {
            char value = path.charAt(i);
            if (Character.isHighSurrogate(value)) {
                if (++i >= path.length() || !Character.isLowSurrogate(path.charAt(i))) {
                    throw new IOException("Atomic rename path contains an unpaired surrogate");
                }
            } else if (Character.isLowSurrogate(value)) {
                throw new IOException("Atomic rename path contains an unpaired surrogate");
            }
        }
    }

    private static native boolean renameNoReplaceUtf8(byte[] source, byte[] destination) throws IOException;
}
