package id.eska.screenshotwebp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.exifinterface.media.ExifInterface;
import com.radzivon.bartoshyk.avif.coder.AvifChromaSubsampling;
import com.radzivon.bartoshyk.avif.coder.AvifSpeed;
import com.radzivon.bartoshyk.avif.coder.AvifSurfaceMode;
import com.radzivon.bartoshyk.avif.coder.HeifCoder;
import com.radzivon.bartoshyk.avif.coder.PreciseMode;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MediaConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J(\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001bH\u0002J(\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001bH\u0002J\u001a\u0010$\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J(\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020(H\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010*\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006,"}, d2 = {"Lid/eska/screenshotwebp/MediaConverter;", "", "<init>", "()V", "avifCoder", "Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;", "getAvifCoder", "()Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;", "avifCoder$delegate", "Lkotlin/Lazy;", "convert", "Lid/eska/screenshotwebp/ConversionResult;", "source", "Ljava/io/File;", "requested", "Lid/eska/screenshotwebp/OutputFormat;", "findCandidate", "Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;", "decoded", "Landroid/graphics/Bitmap;", "format", "target", "", "encode", "", "bitmap", "quality", "", "buildWebp", "verify", "", "file", "width", "height", "verifyBytes", "bytes", "allocateDestination", "failed", "sourceBytes", "message", "", "decodeSource", "applyExifOrientation", "EncodedCandidate", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MediaConverter {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: avifCoder$delegate, reason: from kotlin metadata */
    private final Lazy avifCoder = LazyKt.lazy(new Function0() { // from class: id.eska.screenshotwebp.MediaConverter$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MediaConverter.avifCoder_delegate$lambda$0();
        }
    });

    /* JADX INFO: compiled from: MediaConverter.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OutputFormat.values().length];
            try {
                iArr[OutputFormat.WEBP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OutputFormat.AVIF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HeifCoder avifCoder_delegate$lambda$0() {
        return new HeifCoder();
    }

    private final HeifCoder getAvifCoder() {
        return (HeifCoder) this.avifCoder.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0193  */
    /* JADX WARN: Code duplicated, block: B:71:0x01b8  */
    public final ConversionResult convert(File source, OutputFormat requested) throws Throwable {
        Bitmap bitmap;
        Bitmap bitmap2;
        File file;
        ConversionResult conversionResult;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(requested, "requested");
        long length = source.length();
        long maxBytes = TargetPolicyKt.targetBucket(length).getMaxBytes();
        Bitmap bitmapDecodeSource = decodeSource(source);
        if (bitmapDecodeSource == null) {
            return failed(length, maxBytes, requested, "Gambar tidak terbaca");
        }
        Bitmap bitmapApplyExifOrientation = applyExifOrientation(bitmapDecodeSource, source);
        try {
            EncodedCandidate encodedCandidateFindCandidate = findCandidate(bitmapApplyExifOrientation, requested, maxBytes);
            if (encodedCandidateFindCandidate == null) {
                EncodedCandidate encodedCandidateFindCandidate2 = findCandidate(bitmapApplyExifOrientation, MediaModelKt.fallbackFormat(requested), maxBytes);
                encodedCandidateFindCandidate = encodedCandidateFindCandidate2 != null ? EncodedCandidate.copy$default(encodedCandidateFindCandidate2, null, null, 0, 0, true, 15, null) : null;
            }
            if (encodedCandidateFindCandidate == null) {
                ConversionResult conversionResultFailed = failed(length, maxBytes, requested, "Tidak ada kandidat yang memenuhi batas ukuran");
                if (bitmapApplyExifOrientation != bitmapDecodeSource) {
                    bitmapApplyExifOrientation.recycle();
                }
                bitmapDecodeSource.recycle();
                return conversionResultFailed;
            }
            File fileAllocateDestination = allocateDestination(source, encodedCandidateFindCandidate.getFormat());
            if (fileAllocateDestination == null) {
                ConversionResult conversionResultFailed2 = failed(length, maxBytes, requested, "Tidak bisa membuat nama output");
                if (bitmapApplyExifOrientation != bitmapDecodeSource) {
                    bitmapApplyExifOrientation.recycle();
                }
                bitmapDecodeSource.recycle();
                return conversionResultFailed2;
            }
            File file2 = new File(fileAllocateDestination.getParentFile(), "." + fileAllocateDestination.getName() + "." + UUID.randomUUID() + ".tmp");
            try {
                FilesKt.writeBytes(file2, encodedCandidateFindCandidate.getBytes());
                try {
                    if (!verify(file2, encodedCandidateFindCandidate.getFormat(), encodedCandidateFindCandidate.getWidth(), encodedCandidateFindCandidate.getHeight())) {
                        conversionResult = failed(length, maxBytes, requested, "Verifikasi output gagal");
                    } else if (!file2.renameTo(fileAllocateDestination)) {
                        conversionResult = failed(length, maxBytes, requested, "Gagal menerbitkan output");
                    } else {
                        if (verify(fileAllocateDestination, encodedCandidateFindCandidate.getFormat(), encodedCandidateFindCandidate.getWidth(), encodedCandidateFindCandidate.getHeight())) {
                            if (source.delete()) {
                                EncodedCandidate encodedCandidate = encodedCandidateFindCandidate;
                                bitmap = bitmapApplyExifOrientation;
                                try {
                                    file = file2;
                                    bitmap3 = bitmapDecodeSource;
                                    bitmap4 = bitmap;
                                    try {
                                        conversionResult = new ConversionResult(ConversionResult.Status.SUCCESS, length, fileAllocateDestination.length(), maxBytes, Integer.valueOf(encodedCandidate.getWidth()), Integer.valueOf(encodedCandidate.getHeight()), source.getAbsolutePath(), fileAllocateDestination.getAbsolutePath(), null, requested, encodedCandidate.getFormat(), encodedCandidate.getUsedFallback(), fileAllocateDestination.length() <= maxBytes, 256, null);
                                    } catch (Throwable th) {
                                        th = th;
                                        bitmap2 = bitmap3;
                                        bitmap = bitmap4;
                                        try {
                                            file.delete();
                                            throw th;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (bitmap != bitmap2) {
                                                bitmap.recycle();
                                            }
                                            bitmap2.recycle();
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    bitmap2 = bitmapDecodeSource;
                                    file = file2;
                                    file.delete();
                                    throw th;
                                }
                            } else {
                                fileAllocateDestination.delete();
                                conversionResult = failed(length, maxBytes, requested, "Sumber tidak bisa dihapus");
                            }
                            file.delete();
                            bitmap5 = bitmap3;
                            bitmap6 = bitmap4;
                            if (bitmap6 != bitmap5) {
                                bitmap6.recycle();
                            }
                            bitmap5.recycle();
                            return conversionResult;
                        }
                        fileAllocateDestination.delete();
                        conversionResult = failed(length, maxBytes, requested, "Verifikasi akhir gagal");
                    }
                    file.delete();
                    bitmap5 = bitmap3;
                    bitmap6 = bitmap4;
                    if (bitmap6 != bitmap5) {
                        bitmap6.recycle();
                    }
                    bitmap5.recycle();
                    return conversionResult;
                } catch (Throwable th4) {
                    th = th4;
                    bitmap2 = bitmap3;
                    bitmap = bitmap4;
                    if (bitmap != bitmap2) {
                        bitmap.recycle();
                    }
                    bitmap2.recycle();
                    throw th;
                }
                bitmap4 = bitmapApplyExifOrientation;
                bitmap3 = bitmapDecodeSource;
                file = file2;
            } catch (Throwable th5) {
                th = th5;
                bitmap = bitmapApplyExifOrientation;
            }
        } catch (Throwable th6) {
            th = th6;
            bitmap = bitmapApplyExifOrientation;
            bitmap2 = bitmapDecodeSource;
        }
    }

    private final EncodedCandidate findCandidate(Bitmap decoded, OutputFormat format, long target) {
        Bitmap bitmap;
        Object objM6626constructorimpl;
        Object objM6626constructorimpl2;
        Object objM6626constructorimpl3;
        Iterator<Float> it = CompressionPlanKt.compressionScales().iterator();
        EncodedCandidate encodedCandidate = null;
        while (it.hasNext()) {
            float fFloatValue = it.next().floatValue();
            int iCoerceAtLeast = RangesKt.coerceAtLeast((int) (decoded.getWidth() * fFloatValue), 1);
            int iCoerceAtLeast2 = RangesKt.coerceAtLeast((int) (decoded.getHeight() * fFloatValue), 1);
            if (iCoerceAtLeast == decoded.getWidth() && iCoerceAtLeast2 == decoded.getHeight()) {
                bitmap = decoded;
            } else {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(decoded, iCoerceAtLeast, iCoerceAtLeast2, true);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
                bitmap = bitmapCreateScaledBitmap;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                MediaConverter mediaConverter = this;
                objM6626constructorimpl = Result.m6626constructorimpl(encode(bitmap, format, 20));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM6626constructorimpl = Result.m6626constructorimpl(ResultKt.createFailure(th));
            }
            try {
                if (Result.m6632isFailureimpl(objM6626constructorimpl)) {
                    objM6626constructorimpl = null;
                }
                byte[] bArr = (byte[]) objM6626constructorimpl;
                if (bArr != null && verifyBytes(bArr, format, iCoerceAtLeast, iCoerceAtLeast2)) {
                    EncodedCandidate encodedCandidate2 = new EncodedCandidate(bArr, format, iCoerceAtLeast, iCoerceAtLeast2, false);
                    if (encodedCandidate == null) {
                        encodedCandidate = encodedCandidate2;
                    }
                    if (bArr.length <= target) {
                        try {
                            Result.Companion companion3 = Result.INSTANCE;
                            MediaConverter mediaConverter2 = this;
                            objM6626constructorimpl2 = Result.m6626constructorimpl(encode(bitmap, format, 85));
                        } catch (Throwable th2) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objM6626constructorimpl2 = Result.m6626constructorimpl(ResultKt.createFailure(th2));
                        }
                        if (Result.m6632isFailureimpl(objM6626constructorimpl2)) {
                            objM6626constructorimpl2 = null;
                        }
                        byte[] bArr2 = (byte[]) objM6626constructorimpl2;
                        if (bArr2 != null && verifyBytes(bArr2, format, iCoerceAtLeast, iCoerceAtLeast2)) {
                            EncodedCandidate encodedCandidate3 = new EncodedCandidate(bArr2, format, iCoerceAtLeast, iCoerceAtLeast2, false);
                            if (bArr2.length <= target) {
                                if (bitmap != decoded) {
                                    bitmap.recycle();
                                }
                                return encodedCandidate3;
                            }
                        }
                        int i = 84;
                        EncodedCandidate encodedCandidate4 = encodedCandidate2;
                        int i2 = 21;
                        while (i2 <= i) {
                            int i3 = (i2 + i) / 2;
                            try {
                                Result.Companion companion5 = Result.INSTANCE;
                                MediaConverter mediaConverter3 = this;
                                objM6626constructorimpl3 = Result.m6626constructorimpl(encode(bitmap, format, i3));
                            } catch (Throwable th3) {
                                Result.Companion companion6 = Result.INSTANCE;
                                objM6626constructorimpl3 = Result.m6626constructorimpl(ResultKt.createFailure(th3));
                            }
                            if (Result.m6632isFailureimpl(objM6626constructorimpl3)) {
                                objM6626constructorimpl3 = null;
                            }
                            byte[] bArr3 = (byte[]) objM6626constructorimpl3;
                            if (bArr3 == null || !verifyBytes(bArr3, format, iCoerceAtLeast, iCoerceAtLeast2)) {
                                i = i3 - 1;
                            } else {
                                EncodedCandidate encodedCandidate5 = new EncodedCandidate(bArr3, format, iCoerceAtLeast, iCoerceAtLeast2, false);
                                if (bArr3.length <= target) {
                                    i2 = i3 + 1;
                                    encodedCandidate4 = encodedCandidate5;
                                } else {
                                    i = i3 - 1;
                                }
                            }
                        }
                        if (bitmap != decoded) {
                            bitmap.recycle();
                        }
                        return encodedCandidate4;
                    }
                    if (bitmap != decoded) {
                        bitmap.recycle();
                    }
                } else if (bitmap != decoded) {
                    bitmap.recycle();
                }
            } catch (Throwable th4) {
                if (bitmap == decoded) {
                    throw th4;
                }
                bitmap.recycle();
                throw th4;
            }
        }
        return encodedCandidate;
    }

    private final byte[] encode(Bitmap bitmap, OutputFormat format, int quality) {
        int i = WhenMappings.$EnumSwitchMapping$0[format.ordinal()];
        if (i == 1) {
            return buildWebp(bitmap, quality);
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return getAvifCoder().encodeAvif(bitmap, quality, AvifSpeed.SEVEN, PreciseMode.LOSSY, AvifSurfaceMode.AUTO, AvifChromaSubsampling.AUTO);
    }

    private final byte[] buildWebp(Bitmap bitmap, int quality) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!bitmap.compress(Bitmap.CompressFormat.WEBP_LOSSY, quality, byteArrayOutputStream)) {
            throw new IllegalStateException("Check failed.");
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    private final boolean verify(File file, OutputFormat format, int width, int height) {
        return file.isFile() && verifyBytes(FilesKt.readBytes(file), format, width, height);
    }

    private final boolean verifyBytes(byte[] bytes, OutputFormat format, int width, int height) {
        Object objM6626constructorimpl;
        Bitmap bitmapDecodeByteArray;
        try {
            Result.Companion companion = Result.INSTANCE;
            MediaConverter mediaConverter = this;
            int i = WhenMappings.$EnumSwitchMapping$0[format.ordinal()];
            if (i == 1) {
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                bitmapDecodeByteArray = HeifCoder.decode$default(getAvifCoder(), bytes, null, 2, null);
            }
            objM6626constructorimpl = Result.m6626constructorimpl(bitmapDecodeByteArray);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM6626constructorimpl = Result.m6626constructorimpl(ResultKt.createFailure(th));
        }
        Bitmap bitmap = (Bitmap) (Result.m6632isFailureimpl(objM6626constructorimpl) ? null : objM6626constructorimpl);
        if (bitmap == null) {
            return false;
        }
        boolean z = bitmap.getWidth() == width && bitmap.getHeight() == height;
        bitmap.recycle();
        return z;
    }

    private final File allocateDestination(File source, OutputFormat format) {
        File parentFile = source.getParentFile();
        if (parentFile == null) {
            return null;
        }
        String nameWithoutExtension = FilesKt.getNameWithoutExtension(source);
        String extension = format.getExtension();
        File file = new File(parentFile, nameWithoutExtension + "." + extension);
        int i = 1;
        while (file.exists()) {
            file = new File(parentFile, nameWithoutExtension + " (" + i + ")." + extension);
            i++;
            if (i > 10000) {
                return null;
            }
        }
        return file;
    }

    private final ConversionResult failed(long sourceBytes, long target, OutputFormat requested, String message) {
        return new ConversionResult(ConversionResult.Status.FAILED, sourceBytes, 0L, target, null, null, null, null, message, requested, requested, false, false, 6388, null);
    }

    private final Bitmap decodeSource(File source) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(source.getPath(), options);
        if (options.outWidth <= 0 || options.outHeight <= 0) {
            return null;
        }
        String path = source.getPath();
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = CompressionPlanKt.sampleSizeFor$default(options.outWidth, options.outHeight, 0, 4, null);
        options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeFile(path, options2);
    }

    private final Bitmap applyExifOrientation(Bitmap bitmap, File source) {
        Object objM6626constructorimpl;
        Bitmap bitmap2;
        Object objM6626constructorimpl2;
        try {
            Result.Companion companion = Result.INSTANCE;
            MediaConverter mediaConverter = this;
            objM6626constructorimpl = Result.m6626constructorimpl(Integer.valueOf(new ExifInterface(source.getPath()).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM6626constructorimpl = Result.m6626constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m6632isFailureimpl(objM6626constructorimpl)) {
            objM6626constructorimpl = 1;
        }
        int iIntValue = ((Number) objM6626constructorimpl).intValue();
        if (iIntValue == 0 || iIntValue == 1) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        switch (iIntValue) {
            case 2:
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.postRotate(180.0f);
                break;
            case 4:
                matrix.postScale(1.0f, -1.0f);
                break;
            case 5:
                matrix.postRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.postRotate(90.0f);
                break;
            case 7:
                matrix.postRotate(270.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.postRotate(270.0f);
                break;
            default:
                return bitmap;
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            MediaConverter mediaConverter2 = this;
            bitmap2 = bitmap;
            try {
                objM6626constructorimpl2 = Result.m6626constructorimpl(Bitmap.createBitmap(bitmap2, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true));
            } catch (Throwable th2) {
                th = th2;
                Result.Companion companion4 = Result.INSTANCE;
                objM6626constructorimpl2 = Result.m6626constructorimpl(ResultKt.createFailure(th));
            }
        } catch (Throwable th3) {
            th = th3;
            bitmap2 = bitmap;
        }
        return (Bitmap) (Result.m6632isFailureimpl(objM6626constructorimpl2) ? bitmap2 : objM6626constructorimpl2);
    }

    /* JADX INFO: compiled from: MediaConverter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0014\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;", "", "bytes", "", "format", "Lid/eska/screenshotwebp/OutputFormat;", "width", "", "height", "usedFallback", "", "<init>", "([BLid/eska/screenshotwebp/OutputFormat;IIZ)V", "getBytes", "()[B", "getFormat", "()Lid/eska/screenshotwebp/OutputFormat;", "getWidth", "()I", "getHeight", "getUsedFallback", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final /* data */ class EncodedCandidate {
        private final byte[] bytes;
        private final OutputFormat format;
        private final int height;
        private final boolean usedFallback;
        private final int width;

        public static /* synthetic */ EncodedCandidate copy$default(EncodedCandidate encodedCandidate, byte[] bArr, OutputFormat outputFormat, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                bArr = encodedCandidate.bytes;
            }
            if ((i3 & 2) != 0) {
                outputFormat = encodedCandidate.format;
            }
            if ((i3 & 4) != 0) {
                i = encodedCandidate.width;
            }
            if ((i3 & 8) != 0) {
                i2 = encodedCandidate.height;
            }
            if ((i3 & 16) != 0) {
                z = encodedCandidate.usedFallback;
            }
            boolean z2 = z;
            int i4 = i;
            return encodedCandidate.copy(bArr, outputFormat, i4, i2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final byte[] getBytes() {
            return this.bytes;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final OutputFormat getFormat() {
            return this.format;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getUsedFallback() {
            return this.usedFallback;
        }

        public final EncodedCandidate copy(byte[] bytes, OutputFormat format, int width, int height, boolean usedFallback) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            Intrinsics.checkNotNullParameter(format, "format");
            return new EncodedCandidate(bytes, format, width, height, usedFallback);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EncodedCandidate)) {
                return false;
            }
            EncodedCandidate encodedCandidate = (EncodedCandidate) other;
            return Intrinsics.areEqual(this.bytes, encodedCandidate.bytes) && this.format == encodedCandidate.format && this.width == encodedCandidate.width && this.height == encodedCandidate.height && this.usedFallback == encodedCandidate.usedFallback;
        }

        public int hashCode() {
            return (((((((Arrays.hashCode(this.bytes) * 31) + this.format.hashCode()) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Boolean.hashCode(this.usedFallback);
        }

        public String toString() {
            return "EncodedCandidate(bytes=" + Arrays.toString(this.bytes) + ", format=" + this.format + ", width=" + this.width + ", height=" + this.height + ", usedFallback=" + this.usedFallback + ")";
        }

        public EncodedCandidate(byte[] bytes, OutputFormat format, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            Intrinsics.checkNotNullParameter(format, "format");
            this.bytes = bytes;
            this.format = format;
            this.width = i;
            this.height = i2;
            this.usedFallback = z;
        }

        public final byte[] getBytes() {
            return this.bytes;
        }

        public final OutputFormat getFormat() {
            return this.format;
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getHeight() {
            return this.height;
        }

        public final boolean getUsedFallback() {
            return this.usedFallback;
        }
    }
}
