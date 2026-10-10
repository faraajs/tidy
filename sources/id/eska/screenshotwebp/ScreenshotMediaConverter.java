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
import java.io.FileOutputStream;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: ScreenshotMediaConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BC\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015JP\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J \u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0005H\u0002J(\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J(\u0010&\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\u0018\u0010'\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0013H\u0002J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010*\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010+\u001a\u00020,H\u0002R\"\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006-"}, d2 = {"Lid/eska/screenshotwebp/ScreenshotMediaConverter;", "", "avifEncoderOverride", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "", "webpEncoderOverride", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "avifCoder", "Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;", "getAvifCoder", "()Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;", "avifCoder$delegate", "Lkotlin/Lazy;", "convert", "Lid/eska/screenshotwebp/ConversionResult;", "source", "Ljava/io/File;", "requested", "Lid/eska/screenshotwebp/OutputFormat;", "publish", "sourceBytes", "", "target", "bytes", "format", "width", "height", "usedFallback", "", "encode", "bitmap", "quality", "buildWebp", "verify", "file", "verifyBytes", "moveWithoutReplacement", "destination", "applyExifOrientation", "failed", "message", "", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ScreenshotMediaConverter {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: avifCoder$delegate, reason: from kotlin metadata */
    private final Lazy avifCoder;
    private final Function2<Bitmap, Integer, byte[]> avifEncoderOverride;
    private final Function2<Bitmap, Integer, byte[]> webpEncoderOverride;

    /* JADX INFO: compiled from: ScreenshotMediaConverter.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OutputFormat.values().length];
            try {
                iArr[OutputFormat.AVIF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OutputFormat.WEBP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScreenshotMediaConverter() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScreenshotMediaConverter(Function2<? super Bitmap, ? super Integer, byte[]> function2, Function2<? super Bitmap, ? super Integer, byte[]> function3) {
        this.avifEncoderOverride = function2;
        this.webpEncoderOverride = function3;
        this.avifCoder = LazyKt.lazy(new Function0() { // from class: id.eska.screenshotwebp.ScreenshotMediaConverter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScreenshotMediaConverter.avifCoder_delegate$lambda$0();
            }
        });
    }

    public /* synthetic */ ScreenshotMediaConverter(Function2 function2, Function2 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function2, (i & 2) != 0 ? null : function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HeifCoder avifCoder_delegate$lambda$0() {
        return new HeifCoder();
    }

    private final HeifCoder getAvifCoder() {
        return (HeifCoder) this.avifCoder.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v33, types: [T, java.lang.String] */
    public final ConversionResult convert(File source, OutputFormat requested) {
        List<OutputFormat> listListOf;
        Object objM6626constructorimpl;
        T t;
        File source2 = source;
        Intrinsics.checkNotNullParameter(source2, "source");
        Intrinsics.checkNotNullParameter(requested, "requested");
        long length = source2.length();
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(source2.getPath());
        if (bitmapDecodeFile == null) {
            return failed(length, requested, "Gambar tidak terbaca");
        }
        Bitmap bitmapApplyExifOrientation = applyExifOrientation(bitmapDecodeFile, source2);
        int width = bitmapApplyExifOrientation.getWidth();
        int height = bitmapApplyExifOrientation.getHeight();
        try {
            if (requested == OutputFormat.AVIF) {
                listListOf = CompressionPlanKt.screenshotOutputOrder();
            } else {
                listListOf = CollectionsKt.listOf(requested);
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "Tidak ada output valid";
            for (OutputFormat outputFormat : listListOf) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    ScreenshotMediaConverter screenshotMediaConverter = this;
                    objM6626constructorimpl = Result.m6626constructorimpl(encode(bitmapApplyExifOrientation, outputFormat, 55));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM6626constructorimpl = Result.m6626constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM6629exceptionOrNullimpl = Result.m6629exceptionOrNullimpl(objM6626constructorimpl);
                if (thM6629exceptionOrNullimpl != null) {
                    String label = outputFormat.getLabel();
                    String message = thM6629exceptionOrNullimpl.getMessage();
                    if (message == null) {
                        message = thM6629exceptionOrNullimpl.getClass().getSimpleName();
                    }
                    objectRef.element = label + ": " + message;
                } else {
                    byte[] bArr = (byte[]) objM6626constructorimpl;
                    if (verifyBytes(bArr, outputFormat, width, height)) {
                        ConversionResult conversionResultPublish = publish(source2, length, CompressionPlanKt.SCREENSHOT_TARGET_BYTES, bArr, outputFormat, width, height, requested, outputFormat != requested);
                        if (conversionResultPublish.getStatus() != ConversionResult.Status.SUCCESS) {
                            String message2 = conversionResultPublish.getMessage();
                            if (message2 == null) {
                                t = message2;
                                t = "Gagal menerbitkan output";
                            }
                            t = message2;
                            objectRef.element = t;
                        } else {
                            if (bitmapApplyExifOrientation != bitmapDecodeFile) {
                                bitmapApplyExifOrientation.recycle();
                            }
                            bitmapDecodeFile.recycle();
                            return conversionResultPublish;
                        }
                    } else {
                        objectRef.element = outputFormat.getLabel() + ": verifikasi output gagal";
                    }
                }
                source2 = source;
            }
            ConversionResult conversionResultFailed = failed(length, requested, (String) objectRef.element);
            if (bitmapApplyExifOrientation != bitmapDecodeFile) {
                bitmapApplyExifOrientation.recycle();
            }
            bitmapDecodeFile.recycle();
            return conversionResultFailed;
        } catch (Throwable th2) {
            if (bitmapApplyExifOrientation != bitmapDecodeFile) {
                bitmapApplyExifOrientation.recycle();
            }
            bitmapDecodeFile.recycle();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x01f3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:108:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:111:0x0208  */
    /* JADX WARN: Code duplicated, block: B:114:0x020f  */
    private final ConversionResult publish(File source, long sourceBytes, long target, byte[] bytes, OutputFormat format, int width, int height, OutputFormat requested, boolean usedFallback) throws Throwable {
        boolean z;
        boolean z2;
        File file;
        File parentFile = source.getParentFile();
        if (parentFile == null) {
            return failed(sourceBytes, requested, "Folder sumber tidak tersedia");
        }
        File file2 = new File(parentFile, FilesKt.getNameWithoutExtension(source) + "." + format.getExtension());
        if (Intrinsics.areEqual(file2, source) || (file2.exists() && !file2.isFile())) {
            return failed(sourceBytes, requested, "Tujuan bukan file");
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        File file3 = new File(parentFile, "." + file2.getName() + "." + string + ".tmp");
        File file4 = new File(parentFile, "." + file2.getName() + "." + string + ".bak");
        boolean z3 = false;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            try {
                fileOutputStream.write(bytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
                try {
                    if (!verify(file3, format, width, height)) {
                        ConversionResult conversionResultFailed = failed(sourceBytes, requested, "Verifikasi temporary output gagal");
                        file3.delete();
                        file4.delete();
                        return conversionResultFailed;
                    }
                    z = true;
                    if (!file2.exists()) {
                        z2 = false;
                    } else {
                        if (!moveWithoutReplacement(file2, file4)) {
                            ConversionResult conversionResultFailed2 = failed(sourceBytes, requested, "Output lama tidak bisa diamankan");
                            file3.delete();
                            file4.delete();
                            return conversionResultFailed2;
                        }
                        z2 = true;
                    }
                    try {
                        if (moveWithoutReplacement(file3, file2)) {
                            try {
                                try {
                                    if (!verify(file2, format, width, height)) {
                                        ConversionResult conversionResultFailed3 = failed(sourceBytes, requested, "Verifikasi akhir gagal");
                                        file2.delete();
                                        if (z2 && file4.isFile()) {
                                            moveWithoutReplacement(file4, file2);
                                        }
                                        file3.delete();
                                        file4.delete();
                                        return conversionResultFailed3;
                                    }
                                    if (!source.delete()) {
                                        ConversionResult conversionResultFailed4 = failed(sourceBytes, requested, "Sumber tidak bisa dihapus");
                                        file2.delete();
                                        if (z2 && file4.isFile()) {
                                            moveWithoutReplacement(file4, file2);
                                        }
                                        file3.delete();
                                        file4.delete();
                                        return conversionResultFailed4;
                                    }
                                    if (z2) {
                                        file4.delete();
                                    }
                                    try {
                                        ConversionResult.Status status = ConversionResult.Status.SUCCESS;
                                        try {
                                            long length = file2.length();
                                            Integer numValueOf = Integer.valueOf(width);
                                            Integer numValueOf2 = Integer.valueOf(height);
                                            String absolutePath = source.getAbsolutePath();
                                            file2 = file2;
                                            file3 = file3;
                                            try {
                                                ConversionResult conversionResult = new ConversionResult(status, sourceBytes, length, target, numValueOf, numValueOf2, absolutePath, file2.getAbsolutePath(), null, requested, format, usedFallback, file2.length() <= target, 256, null);
                                                file3.delete();
                                                return conversionResult;
                                            } catch (Throwable th) {
                                                th = th;
                                                z3 = true;
                                                if (z3) {
                                                    file = file4;
                                                } else {
                                                    if (z) {
                                                        file2.delete();
                                                    }
                                                    if (z2) {
                                                        file = file4;
                                                    } else {
                                                        file = file4;
                                                    }
                                                }
                                                file3.delete();
                                                if (!z3) {
                                                    file.delete();
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            file2 = file2;
                                            file3 = file3;
                                            z3 = true;
                                            if (z3) {
                                                file = file4;
                                            } else {
                                                if (z) {
                                                    file2.delete();
                                                }
                                                if (z2) {
                                                    file = file4;
                                                } else {
                                                    file = file4;
                                                }
                                            }
                                            file3.delete();
                                            if (!z3) {
                                                file.delete();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        file2 = file2;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    file2 = file2;
                                    file3 = file3;
                                    file4 = file4;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } else {
                            try {
                                ConversionResult conversionResultFailed5 = failed(sourceBytes, requested, "Gagal menerbitkan output");
                                if (z2 && file4.isFile()) {
                                    moveWithoutReplacement(file4, file2);
                                }
                                file3.delete();
                                file4.delete();
                                return conversionResultFailed5;
                            } catch (Throwable th6) {
                                th = th6;
                                z = false;
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        file2 = file2;
                        file3 = file3;
                        file4 = file4;
                        z = false;
                    }
                    file2 = file2;
                    file3 = file3;
                    file4 = file4;
                    if (z3) {
                        file = file4;
                    } else {
                        if (z) {
                            file2.delete();
                        }
                        if (z2 || !file4.isFile()) {
                            file = file4;
                        } else {
                            file = file4;
                            moveWithoutReplacement(file, file2);
                        }
                    }
                    file3.delete();
                    if (!z3) {
                        file.delete();
                    }
                    throw th;
                } catch (Throwable th8) {
                    th = th8;
                    z = false;
                    z2 = false;
                }
            } catch (Throwable th9) {
                try {
                    throw th9;
                } catch (Throwable th10) {
                    try {
                        CloseableKt.closeFinally(fileOutputStream, th9);
                        throw th10;
                    } catch (Throwable th11) {
                        th = th11;
                        z3 = false;
                    }
                }
            }
        } catch (Throwable th12) {
            th = th12;
        }
        z = z3;
        z2 = z;
        if (z3) {
            file = file4;
        } else {
            if (z) {
                file2.delete();
            }
            if (z2) {
                file = file4;
            } else {
                file = file4;
            }
        }
        file3.delete();
        if (!z3) {
            file.delete();
        }
        throw th;
    }

    private final byte[] encode(Bitmap bitmap, OutputFormat format, int quality) {
        byte[] bArrInvoke;
        byte[] bArrInvoke2;
        int i = WhenMappings.$EnumSwitchMapping$0[format.ordinal()];
        if (i == 1) {
            Function2<Bitmap, Integer, byte[]> function2 = this.avifEncoderOverride;
            return (function2 == null || (bArrInvoke = function2.invoke(bitmap, Integer.valueOf(quality))) == null) ? getAvifCoder().encodeAvif(bitmap, quality, AvifSpeed.SEVEN, PreciseMode.LOSSY, AvifSurfaceMode.AUTO, AvifChromaSubsampling.AUTO) : bArrInvoke;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        Function2<Bitmap, Integer, byte[]> function3 = this.webpEncoderOverride;
        return (function3 == null || (bArrInvoke2 = function3.invoke(bitmap, Integer.valueOf(quality))) == null) ? buildWebp(bitmap, quality) : bArrInvoke2;
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
        Object objM6626constructorimpl;
        if (!file.isFile()) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            ScreenshotMediaConverter screenshotMediaConverter = this;
            objM6626constructorimpl = Result.m6626constructorimpl(Boolean.valueOf(verifyBytes(FilesKt.readBytes(file), format, width, height)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM6626constructorimpl = Result.m6626constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m6632isFailureimpl(objM6626constructorimpl)) {
            objM6626constructorimpl = false;
        }
        return ((Boolean) objM6626constructorimpl).booleanValue();
    }

    private final boolean verifyBytes(byte[] bytes, OutputFormat format, int width, int height) {
        Object objM6626constructorimpl;
        Bitmap bitmapDecode$default;
        try {
            Result.Companion companion = Result.INSTANCE;
            ScreenshotMediaConverter screenshotMediaConverter = this;
            int i = WhenMappings.$EnumSwitchMapping$0[format.ordinal()];
            if (i == 1) {
                bitmapDecode$default = HeifCoder.decode$default(getAvifCoder(), bytes, null, 2, null);
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                bitmapDecode$default = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            }
            objM6626constructorimpl = Result.m6626constructorimpl(bitmapDecode$default);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM6626constructorimpl = Result.m6626constructorimpl(ResultKt.createFailure(th));
        }
        Bitmap bitmap = (Bitmap) (Result.m6632isFailureimpl(objM6626constructorimpl) ? null : objM6626constructorimpl);
        if (bitmap == null) {
            return false;
        }
        try {
            return bitmap.getWidth() == width && bitmap.getHeight() == height;
        } finally {
            bitmap.recycle();
        }
    }

    private final boolean moveWithoutReplacement(File source, File destination) {
        try {
            Files.move(source.toPath(), destination.toPath(), StandardCopyOption.ATOMIC_MOVE);
            return true;
        } catch (AtomicMoveNotSupportedException unused) {
            if (destination.exists() || !source.renameTo(destination)) {
                return false;
            }
            return true;
        } catch (Exception unused2) {
            if (destination.exists() || !source.renameTo(destination)) {
                return false;
            }
            return true;
        }
    }

    private final Bitmap applyExifOrientation(Bitmap bitmap, File source) {
        Object objM6626constructorimpl;
        Bitmap bitmap2;
        Object objM6626constructorimpl2;
        try {
            Result.Companion companion = Result.INSTANCE;
            ScreenshotMediaConverter screenshotMediaConverter = this;
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
            ScreenshotMediaConverter screenshotMediaConverter2 = this;
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

    private final ConversionResult failed(long sourceBytes, OutputFormat requested, String message) {
        return new ConversionResult(ConversionResult.Status.FAILED, sourceBytes, 0L, CompressionPlanKt.SCREENSHOT_TARGET_BYTES, null, null, null, null, message, requested, requested, false, false, 6388, null);
    }
}
