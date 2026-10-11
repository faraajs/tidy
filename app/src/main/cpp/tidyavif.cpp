// SPDX-License-Identifier: GPL-3.0-only
#include <android/bitmap.h>
#include <android/data_space.h>
#include <avif/avif.h>
#include <jni.h>

#include <cerrno>
#include <cstdint>
#include <cstdio>
#include <fcntl.h>
#include <memory>
#include <new>
#include <string>
#include <sys/syscall.h>
#include <unistd.h>

namespace {
constexpr uint32_t kMaxDimension = 16384;
constexpr uint64_t kMaxPixels = 16777216;
constexpr size_t kMaxEncodedBytes = 64 * 1024 * 1024;

void throwIo(JNIEnv* env, const char* message) {
    // Native allocation failures and Java bitmap/array allocation failures use
    // the same checked API. Clear the old failure before throwing IOException.
    if (env->ExceptionCheck()) env->ExceptionClear();
    jclass type = env->FindClass("java/io/IOException");
    if (type) {
        env->ThrowNew(type, message);
        env->DeleteLocalRef(type);
    }
}

bool checkResult(JNIEnv* env, avifResult result, const char* operation) {
    if (result == AVIF_RESULT_OK) return true;
    char message[256];
    std::snprintf(message, sizeof(message), "%s: %s", operation, avifResultToString(result));
    throwIo(env, message);
    return false;
}

bool validDimensions(uint32_t width, uint32_t height) {
    return width > 0 && height > 0 && width <= kMaxDimension && height <= kMaxDimension &&
           static_cast<uint64_t>(width) * height <= kMaxPixels;
}

bool bitmapInfo(JNIEnv* env, jobject bitmap, AndroidBitmapInfo* info) {
    if (AndroidBitmap_getInfo(env, bitmap, info) != ANDROID_BITMAP_RESULT_SUCCESS) {
        throwIo(env, "Cannot access bitmap information (bitmap may be recycled)");
        return false;
    }
    if (info->format != ANDROID_BITMAP_FORMAT_RGBA_8888 ||
        (info->flags & ANDROID_BITMAP_FLAGS_IS_HARDWARE) != 0) {
        throwIo(env, "AVIF requires a software ARGB_8888 bitmap");
        return false;
    }
    if (!validDimensions(info->width, info->height) ||
        info->stride < static_cast<uint64_t>(info->width) * 4 ||
        static_cast<uint64_t>(info->stride) * info->height > kMaxPixels * 4) {
        throwIo(env, "Bitmap exceeds AVIF dimensions, pixel, or stride limits");
        return false;
    }
    return true;
}

class BitmapLock {
public:
    BitmapLock(JNIEnv* env, jobject bitmap) : env_(env), bitmap_(bitmap) {}
    ~BitmapLock() { if (locked_) AndroidBitmap_unlockPixels(env_, bitmap_); }
    bool lock() {
        if (AndroidBitmap_lockPixels(env_, bitmap_, &pixels) != ANDROID_BITMAP_RESULT_SUCCESS) {
            throwIo(env_, "Cannot lock bitmap pixels");
            return false;
        }
        locked_ = true;
        if (!pixels) {
            throwIo(env_, "Bitmap returned no pixel storage");
            return false;
        }
        return true;
    }
    bool unlock() {
        if (!locked_) return true;
        const int result = AndroidBitmap_unlockPixels(env_, bitmap_);
        locked_ = false;
        pixels = nullptr;
        if (result != ANDROID_BITMAP_RESULT_SUCCESS) {
            throwIo(env_, "Cannot unlock bitmap pixels");
            return false;
        }
        return true;
    }
    void* pixels = nullptr;
private:
    JNIEnv* env_;
    jobject bitmap_;
    bool locked_ = false;
};

struct EncodedData {
    avifRWData value = AVIF_DATA_EMPTY;
    ~EncodedData() { avifRWDataFree(&value); }
};

class InputBytes {
public:
    InputBytes(JNIEnv* env, jbyteArray array) : env_(env), array_(array) {
        bytes = env_->GetByteArrayElements(array_, nullptr);
    }
    ~InputBytes() { if (bytes) env_->ReleaseByteArrayElements(array_, bytes, JNI_ABORT); }
    jbyte* bytes;
private:
    JNIEnv* env_;
    jbyteArray array_;
};

using Image = std::unique_ptr<avifImage, decltype(&avifImageDestroy)>;
using Encoder = std::unique_ptr<avifEncoder, decltype(&avifEncoderDestroy)>;
using Decoder = std::unique_ptr<avifDecoder, decltype(&avifDecoderDestroy)>;
}  // namespace

extern "C" JNIEXPORT jbyteArray JNICALL
Java_id_eska_screenshotwebp_NativeAvif_encode(JNIEnv*, jclass, jobject, jint);
extern "C" JNIEXPORT jobject JNICALL
Java_id_eska_screenshotwebp_NativeAvif_decode(JNIEnv*, jclass, jbyteArray);
extern "C" JNIEXPORT jboolean JNICALL
Java_id_eska_screenshotwebp_NativeAvif_renameNoReplaceUtf8(JNIEnv*, jclass, jbyteArray, jbyteArray);

extern "C" JNIEXPORT jbyteArray JNICALL
Java_id_eska_screenshotwebp_NativeAvif_encode(JNIEnv* env, jclass, jobject bitmap, jint quality) {
    if (!bitmap || quality < 0 || quality > 100) {
        throwIo(env, "AVIF encode requires a bitmap and quality from 0 to 100");
        return nullptr;
    }
    AndroidBitmapInfo info{};
    if (!bitmapInfo(env, bitmap, &info)) return nullptr;
    if (AndroidBitmap_getDataSpace(env, bitmap) != ADATASPACE_SRGB ||
        (info.flags & ANDROID_BITMAP_FLAGS_ALPHA_MASK) > ANDROID_BITMAP_FLAGS_ALPHA_UNPREMUL) {
        throwIo(env, "AVIF encode requires sRGB pixels with a valid alpha mode");
        return nullptr;
    }

    Image image(avifImageCreate(info.width, info.height, 8, AVIF_PIXEL_FORMAT_YUV444), avifImageDestroy);
    Encoder encoder(avifEncoderCreate(), avifEncoderDestroy);
    if (!image || !encoder) {
        throwIo(env, "Cannot allocate AVIF encoder");
        return nullptr;
    }
    image->colorPrimaries = AVIF_COLOR_PRIMARIES_BT709;
    image->transferCharacteristics = AVIF_TRANSFER_CHARACTERISTICS_SRGB;
    image->matrixCoefficients = AVIF_MATRIX_COEFFICIENTS_BT601;
    image->yuvRange = AVIF_RANGE_FULL;
    image->alphaPremultiplied = AVIF_FALSE;
    // The newly created image has no EXIF, XMP, ICC, or identifying metadata.
    avifRGBImage rgb;
    avifRGBImageSetDefaults(&rgb, image.get());
    rgb.format = AVIF_RGB_FORMAT_RGBA;
    rgb.depth = 8;
    rgb.rowBytes = info.stride;
    rgb.avoidLibYUV = AVIF_TRUE;
    const uint32_t alpha = info.flags & ANDROID_BITMAP_FLAGS_ALPHA_MASK;
    rgb.alphaPremultiplied = alpha == ANDROID_BITMAP_FLAGS_ALPHA_PREMUL ? AVIF_TRUE : AVIF_FALSE;
    rgb.ignoreAlpha = alpha == ANDROID_BITMAP_FLAGS_ALPHA_OPAQUE ? AVIF_TRUE : AVIF_FALSE;
    {
        BitmapLock lock(env, bitmap);
        if (!lock.lock()) return nullptr;
        rgb.pixels = static_cast<uint8_t*>(lock.pixels);
        if (!checkResult(env, avifImageRGBToYUV(image.get(), &rgb), "RGBA to YUV conversion")) return nullptr;
        if (!lock.unlock()) return nullptr;
    }
    encoder->codecChoice = AVIF_CODEC_CHOICE_AOM;
    encoder->maxThreads = 1;
    encoder->speed = 8;
    encoder->quality = quality;
    encoder->qualityAlpha = AVIF_QUALITY_LOSSLESS;
    EncodedData encoded;
    if (!checkResult(env, avifEncoderWrite(encoder.get(), image.get(), &encoded.value), "AVIF encoding")) return nullptr;
    if (!encoded.value.data || encoded.value.size == 0 || encoded.value.size > kMaxEncodedBytes) {
        throwIo(env, "AVIF output is empty or exceeds 64 MiB");
        return nullptr;
    }
    jbyteArray output = env->NewByteArray(static_cast<jsize>(encoded.value.size));
    if (!output) {
        throwIo(env, "Cannot allocate AVIF output byte array");
        return nullptr;
    }
    env->SetByteArrayRegion(output, 0, static_cast<jsize>(encoded.value.size), reinterpret_cast<const jbyte*>(encoded.value.data));
    if (env->ExceptionCheck()) {
        throwIo(env, "Cannot fill AVIF output byte array");
        return nullptr;
    }
    return output;
}

extern "C" JNIEXPORT jobject JNICALL
Java_id_eska_screenshotwebp_NativeAvif_decode(JNIEnv* env, jclass, jbyteArray bytes) {
    if (!bytes) {
        throwIo(env, "AVIF decode requires non-null encoded bytes");
        return nullptr;
    }
    const jsize length = env->GetArrayLength(bytes);
    if (length < 12 || static_cast<size_t>(length) > kMaxEncodedBytes) {
        throwIo(env, "AVIF input must contain 12 bytes to 64 MiB");
        return nullptr;
    }
    // Unlike GetPrimitiveArrayCritical, this may safely span codec work/JNI
    // bitmap allocation. The VM decides whether to pin or copy the array.
    InputBytes input(env, bytes);
    if (!input.bytes) {
        throwIo(env, "Cannot access AVIF input bytes");
        return nullptr;
    }
    Decoder decoder(avifDecoderCreate(), avifDecoderDestroy);
    if (!decoder) {
        throwIo(env, "Cannot allocate AVIF decoder");
        return nullptr;
    }
    decoder->codecChoice = AVIF_CODEC_CHOICE_AOM;
    decoder->maxThreads = 1;
    decoder->ignoreExif = AVIF_TRUE;
    decoder->ignoreXMP = AVIF_TRUE;
    decoder->imageSizeLimit = static_cast<uint32_t>(kMaxPixels);
    decoder->imageDimensionLimit = kMaxDimension;
    decoder->imageCountLimit = 1;
    if (!checkResult(env, avifDecoderSetIOMemory(decoder.get(), reinterpret_cast<const uint8_t*>(input.bytes), static_cast<size_t>(length)), "AVIF input") ||
        !checkResult(env, avifDecoderParse(decoder.get()), "AVIF container parsing")) return nullptr;
    if (!validDimensions(decoder->image->width, decoder->image->height) || decoder->image->depth != 8 ||
        decoder->imageCount != 1 || decoder->image->transformFlags != AVIF_TRANSFORM_NONE) {
        throwIo(env, "AVIF decode supports bounded 8-bit still images without unapplied transforms");
        return nullptr;
    }
    if (!checkResult(env, avifDecoderNextImage(decoder.get()), "AVIF decoding")) return nullptr;
    const avifImage* image = decoder->image;
    if (!validDimensions(image->width, image->height) || image->depth != 8) {
        throwIo(env, "Decoded AVIF pixels exceed resource limits");
        return nullptr;
    }

    jclass bitmapClass = env->FindClass("android/graphics/Bitmap");
    if (!bitmapClass) {
        throwIo(env, "Cannot resolve Android bitmap class");
        return nullptr;
    }
    jclass configClass = env->FindClass("android/graphics/Bitmap$Config");
    if (!configClass) {
        throwIo(env, "Cannot resolve Android bitmap config class");
        return nullptr;
    }
    jfieldID configField = env->GetStaticFieldID(configClass, "ARGB_8888", "Landroid/graphics/Bitmap$Config;");
    if (!configField) {
        throwIo(env, "Cannot resolve ARGB_8888 config");
        return nullptr;
    }
    jmethodID create = env->GetStaticMethodID(bitmapClass, "createBitmap", "(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;");
    if (!create) {
        throwIo(env, "Cannot resolve Android bitmap creation API");
        return nullptr;
    }
    jobject config = env->GetStaticObjectField(configClass, configField);
    if (!config || env->ExceptionCheck()) {
        throwIo(env, "Cannot access ARGB_8888 config");
        return nullptr;
    }
    jobject bitmap = env->CallStaticObjectMethod(bitmapClass, create, static_cast<jint>(image->width), static_cast<jint>(image->height), config);
    env->DeleteLocalRef(config);
    env->DeleteLocalRef(configClass);
    env->DeleteLocalRef(bitmapClass);
    if (!bitmap || env->ExceptionCheck()) {
        throwIo(env, "Cannot allocate decoded AVIF bitmap");
        return nullptr;
    }
    AndroidBitmapInfo info{};
    if (!bitmapInfo(env, bitmap, &info)) return nullptr;
    BitmapLock lock(env, bitmap);
    if (!lock.lock()) return nullptr;
    avifRGBImage rgb;
    avifRGBImageSetDefaults(&rgb, image);
    rgb.format = AVIF_RGB_FORMAT_RGBA;
    rgb.depth = 8;
    rgb.pixels = static_cast<uint8_t*>(lock.pixels);
    rgb.rowBytes = info.stride;
    rgb.alphaPremultiplied = AVIF_TRUE;
    rgb.avoidLibYUV = AVIF_TRUE;
    rgb.maxThreads = 1;
    if (!checkResult(env, avifImageYUVToRGB(image, &rgb), "YUV to RGBA conversion")) return nullptr;
    if (!lock.unlock()) return nullptr;
    return bitmap;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_id_eska_screenshotwebp_NativeAvif_renameNoReplaceUtf8(JNIEnv* env, jclass, jbyteArray source, jbyteArray destination) {
    if (!source || !destination) {
        throwIo(env, "Atomic rename requires non-null UTF-8 paths");
        return JNI_FALSE;
    }
    const jsize sourceLength = env->GetArrayLength(source);
    const jsize destinationLength = env->GetArrayLength(destination);
    if (sourceLength <= 0 || destinationLength <= 0 || sourceLength >= 4096 || destinationLength >= 4096) {
        throwIo(env, "Atomic rename path length is outside filesystem limits");
        return JNI_FALSE;
    }
    InputBytes sourceBytes(env, source);
    if (!sourceBytes.bytes) {
        throwIo(env, "Cannot access source rename path");
        return JNI_FALSE;
    }
    InputBytes destinationBytes(env, destination);
    if (!destinationBytes.bytes) {
        throwIo(env, "Cannot access destination rename path");
        return JNI_FALSE;
    }
    for (jsize i = 0; i < sourceLength; ++i) {
        if (sourceBytes.bytes[i] == 0) {
            throwIo(env, "Source rename path contains NUL");
            return JNI_FALSE;
        }
    }
    for (jsize i = 0; i < destinationLength; ++i) {
        if (destinationBytes.bytes[i] == 0) {
            throwIo(env, "Destination rename path contains NUL");
            return JNI_FALSE;
        }
    }
    try {
        // The syscall needs terminated UTF-8 strings, not JNI modified UTF-8.
        const std::string from(reinterpret_cast<const char*>(sourceBytes.bytes), static_cast<size_t>(sourceLength));
        const std::string to(reinterpret_cast<const char*>(destinationBytes.bytes), static_cast<size_t>(destinationLength));
        constexpr unsigned int kRenameNoReplace = 1;
        const long result = syscall(SYS_renameat2, AT_FDCWD, from.c_str(), AT_FDCWD, to.c_str(), kRenameNoReplace);
        const int error = errno;
        if (result == 0) return JNI_TRUE;
        if (error == EEXIST || error == ENOSYS || error == EINVAL || error == EOPNOTSUPP) return JNI_FALSE;
        char message[128];
        std::snprintf(message, sizeof(message), "Atomic no-replace rename failed (errno %d)", error);
        throwIo(env, message);
    } catch (const std::bad_alloc&) {
        throwIo(env, "Cannot allocate terminated rename paths");
    }
    return JNI_FALSE;
}
