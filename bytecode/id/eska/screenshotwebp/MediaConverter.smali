.class public final Lid/eska/screenshotwebp/MediaConverter;
.super Ljava/lang/Object;
.source "MediaConverter.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;,
        Lid/eska/screenshotwebp/MediaConverter$WhenMappings;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nMediaConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaConverter.kt\nid/eska/screenshotwebp/MediaConverter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,267:1\n1#2:268\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\u0008\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J(\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001bH\u0002J(\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001bH\u0002J\u001a\u0010$\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J(\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\'\u001a\u00020(H\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u0018\u0010*\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000c\u001a\u00020\rH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\u0006\u0010\u0007\u00a8\u0006,"
    }
    d2 = {
        "Lid/eska/screenshotwebp/MediaConverter;",
        "",
        "<init>",
        "()V",
        "avifCoder",
        "Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;",
        "getAvifCoder",
        "()Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;",
        "avifCoder$delegate",
        "Lkotlin/Lazy;",
        "convert",
        "Lid/eska/screenshotwebp/ConversionResult;",
        "source",
        "Ljava/io/File;",
        "requested",
        "Lid/eska/screenshotwebp/OutputFormat;",
        "findCandidate",
        "Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;",
        "decoded",
        "Landroid/graphics/Bitmap;",
        "format",
        "target",
        "",
        "encode",
        "",
        "bitmap",
        "quality",
        "",
        "buildWebp",
        "verify",
        "",
        "file",
        "width",
        "height",
        "verifyBytes",
        "bytes",
        "allocateDestination",
        "failed",
        "sourceBytes",
        "message",
        "",
        "decodeSource",
        "applyExifOrientation",
        "EncodedCandidate",
        "app_release"
    }
    k = 0x1
    mv = {
        0x2,
        0x3,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final $stable:I = 0x8


# instance fields
.field private final avifCoder$delegate:Lkotlin/Lazy;


# direct methods
.method public static synthetic $r8$lambda$uP6iLmTo7dF2PbP-gQ1Ilg29Zzs()Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;
    .locals 1

    invoke-static {}, Lid/eska/screenshotwebp/MediaConverter;->avifCoder_delegate$lambda$0()Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;

    move-result-object v0

    return-object v0
.end method

.method static constructor <clinit>()V
    .locals 0

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    new-instance v0, Lid/eska/screenshotwebp/MediaConverter$$ExternalSyntheticLambda0;

    invoke-direct {v0}, Lid/eska/screenshotwebp/MediaConverter$$ExternalSyntheticLambda0;-><init>()V

    invoke-static {v0}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v0

    iput-object v0, p0, Lid/eska/screenshotwebp/MediaConverter;->avifCoder$delegate:Lkotlin/Lazy;

    return-void
.end method

.method private final allocateDestination(Ljava/io/File;Lid/eska/screenshotwebp/OutputFormat;)Ljava/io/File;
    .locals 6

    .line 190
    invoke-virtual {p1}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object p0

    const/4 v0, 0x0

    if-nez p0, :cond_0

    return-object v0

    .line 191
    :cond_0
    invoke-static {p1}, Lkotlin/io/FilesKt;->getNameWithoutExtension(Ljava/io/File;)Ljava/lang/String;

    move-result-object p1

    .line 192
    invoke-virtual {p2}, Lid/eska/screenshotwebp/OutputFormat;->getExtension()Ljava/lang/String;

    move-result-object p2

    .line 193
    new-instance v1, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, p0, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    const/4 v2, 0x1

    move v3, v2

    .line 195
    :cond_1
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 196
    new-instance v1, Ljava/io/File;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " ("

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ")."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, p0, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    add-int/2addr v3, v2

    const/16 v4, 0x2710

    if-le v3, v4, :cond_1

    return-object v0

    :cond_2
    return-object v1
.end method

.method private final applyExifOrientation(Landroid/graphics/Bitmap;Ljava/io/File;)Landroid/graphics/Bitmap;
    .locals 9

    const/4 v1, 0x1

    .line 224
    :try_start_0
    sget-object v0, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    move-object v0, p0

    check-cast v0, Lid/eska/screenshotwebp/MediaConverter;

    .line 225
    new-instance v0, Landroidx/exifinterface/media/ExifInterface;

    invoke-virtual {p2}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object p2

    invoke-direct {v0, p2}, Landroidx/exifinterface/media/ExifInterface;-><init>(Ljava/lang/String;)V

    .line 226
    const-string p2, "Orientation"

    .line 225
    invoke-virtual {v0, p2, v1}, Landroidx/exifinterface/media/ExifInterface;->getAttributeInt(Ljava/lang/String;I)I

    move-result p2

    .line 228
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    .line 224
    invoke-static {p2}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    move-object p2, v0

    sget-object v0, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {p2}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object p2

    invoke-static {p2}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    .line 229
    :goto_0
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {p2}, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    move-object p2, v0

    :cond_0
    check-cast p2, Ljava/lang/Number;

    invoke-virtual {p2}, Ljava/lang/Number;->intValue()I

    move-result p2

    if-eqz p2, :cond_2

    if-eq p2, v1, :cond_2

    .line 235
    new-instance v7, Landroid/graphics/Matrix;

    invoke-direct {v7}, Landroid/graphics/Matrix;-><init>()V

    const/high16 v0, 0x43870000    # 270.0f

    const/high16 v1, 0x42b40000    # 90.0f

    const/high16 v2, 0x3f800000    # 1.0f

    const/high16 v3, -0x40800000    # -1.0f

    packed-switch p2, :pswitch_data_0

    goto :goto_5

    .line 249
    :pswitch_0
    invoke-virtual {v7, v0}, Landroid/graphics/Matrix;->postRotate(F)Z

    goto :goto_1

    .line 246
    :pswitch_1
    invoke-virtual {v7, v0}, Landroid/graphics/Matrix;->postRotate(F)Z

    .line 247
    invoke-virtual {v7, v3, v2}, Landroid/graphics/Matrix;->postScale(FF)Z

    goto :goto_1

    .line 244
    :pswitch_2
    invoke-virtual {v7, v1}, Landroid/graphics/Matrix;->postRotate(F)Z

    goto :goto_1

    .line 241
    :pswitch_3
    invoke-virtual {v7, v1}, Landroid/graphics/Matrix;->postRotate(F)Z

    .line 242
    invoke-virtual {v7, v3, v2}, Landroid/graphics/Matrix;->postScale(FF)Z

    goto :goto_1

    .line 239
    :pswitch_4
    invoke-virtual {v7, v2, v3}, Landroid/graphics/Matrix;->postScale(FF)Z

    goto :goto_1

    :pswitch_5
    const/high16 p2, 0x43340000    # 180.0f

    .line 238
    invoke-virtual {v7, p2}, Landroid/graphics/Matrix;->postRotate(F)Z

    goto :goto_1

    .line 237
    :pswitch_6
    invoke-virtual {v7, v3, v2}, Landroid/graphics/Matrix;->postScale(FF)Z

    .line 253
    :goto_1
    :try_start_1
    sget-object p2, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    check-cast p0, Lid/eska/screenshotwebp/MediaConverter;

    .line 254
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v5

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    const/4 v8, 0x1

    const/4 v3, 0x0

    const/4 v4, 0x0

    move-object v2, p1

    :try_start_2
    invoke-static/range {v2 .. v8}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;

    move-result-object p0

    .line 253
    invoke-static {p0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_3

    :catchall_1
    move-exception v0

    goto :goto_2

    :catchall_2
    move-exception v0

    move-object v2, p1

    :goto_2
    move-object p0, v0

    sget-object p1, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {p0}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object p0

    invoke-static {p0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    .line 255
    :goto_3
    invoke-static {p0}, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_1

    move-object p1, v2

    goto :goto_4

    :cond_1
    move-object p1, p0

    :goto_4
    check-cast p1, Landroid/graphics/Bitmap;

    return-object p1

    :cond_2
    :goto_5
    move-object v2, p1

    return-object v2

    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static final avifCoder_delegate$lambda$0()Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;
    .locals 1

    .line 17
    new-instance v0, Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;

    invoke-direct {v0}, Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;-><init>()V

    return-object v0
.end method

.method private final buildWebp(Landroid/graphics/Bitmap;I)[B
    .locals 2

    .line 163
    new-instance p0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {p0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 165
    sget-object v0, Landroid/graphics/Bitmap$CompressFormat;->WEBP_LOSSY:Landroid/graphics/Bitmap$CompressFormat;

    .line 170
    move-object v1, p0

    check-cast v1, Ljava/io/OutputStream;

    invoke-virtual {p1, v0, p2, v1}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    move-result p1

    if-eqz p1, :cond_0

    .line 171
    invoke-virtual {p0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object p0

    const-string p1, "toByteArray(...)"

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object p0

    .line 170
    :cond_0
    new-instance p0, Ljava/lang/IllegalStateException;

    const-string p1, "Check failed."

    invoke-direct {p0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private final decodeSource(Ljava/io/File;)Landroid/graphics/Bitmap;
    .locals 5

    .line 214
    new-instance p0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {p0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 215
    invoke-virtual {p1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p0}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 216
    iget v0, p0, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    const/4 v1, 0x0

    if-lez v0, :cond_1

    iget v0, p0, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    if-gtz v0, :cond_0

    goto :goto_0

    .line 217
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object p1

    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 218
    iget v2, p0, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    iget p0, p0, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    const/4 v3, 0x0

    const/4 v4, 0x4

    invoke-static {v2, p0, v3, v4, v1}, Lid/eska/screenshotwebp/CompressionPlanKt;->sampleSizeFor$default(IIIILjava/lang/Object;)I

    move-result p0

    iput p0, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 219
    sget-object p0, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    iput-object p0, v0, Landroid/graphics/BitmapFactory$Options;->inPreferredConfig:Landroid/graphics/Bitmap$Config;

    .line 217
    invoke-static {p1, v0}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0

    :cond_1
    :goto_0
    return-object v1
.end method

.method private final encode(Landroid/graphics/Bitmap;Lid/eska/screenshotwebp/OutputFormat;I)[B
    .locals 8

    .line 150
    sget-object v0, Lid/eska/screenshotwebp/MediaConverter$WhenMappings;->$EnumSwitchMapping$0:[I

    invoke-virtual {p2}, Lid/eska/screenshotwebp/OutputFormat;->ordinal()I

    move-result p2

    aget p2, v0, p2

    const/4 v0, 0x1

    if-eq p2, v0, :cond_1

    const/4 v0, 0x2

    if-ne p2, v0, :cond_0

    .line 152
    invoke-direct {p0}, Lid/eska/screenshotwebp/MediaConverter;->getAvifCoder()Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;

    move-result-object v1

    .line 155
    sget-object v4, Lcom/radzivon/bartoshyk/avif/coder/AvifSpeed;->SEVEN:Lcom/radzivon/bartoshyk/avif/coder/AvifSpeed;

    .line 156
    sget-object v5, Lcom/radzivon/bartoshyk/avif/coder/PreciseMode;->LOSSY:Lcom/radzivon/bartoshyk/avif/coder/PreciseMode;

    .line 157
    sget-object v6, Lcom/radzivon/bartoshyk/avif/coder/AvifSurfaceMode;->AUTO:Lcom/radzivon/bartoshyk/avif/coder/AvifSurfaceMode;

    .line 158
    sget-object v7, Lcom/radzivon/bartoshyk/avif/coder/AvifChromaSubsampling;->AUTO:Lcom/radzivon/bartoshyk/avif/coder/AvifChromaSubsampling;

    move-object v2, p1

    move v3, p3

    .line 152
    invoke-virtual/range {v1 .. v7}, Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;->encodeAvif(Landroid/graphics/Bitmap;ILcom/radzivon/bartoshyk/avif/coder/AvifSpeed;Lcom/radzivon/bartoshyk/avif/coder/PreciseMode;Lcom/radzivon/bartoshyk/avif/coder/AvifSurfaceMode;Lcom/radzivon/bartoshyk/avif/coder/AvifChromaSubsampling;)[B

    move-result-object p0

    return-object p0

    .line 150
    :cond_0
    new-instance p0, Lkotlin/NoWhenBranchMatchedException;

    invoke-direct {p0}, Lkotlin/NoWhenBranchMatchedException;-><init>()V

    throw p0

    :cond_1
    move-object v2, p1

    move v3, p3

    .line 151
    invoke-direct {p0, v2, v3}, Lid/eska/screenshotwebp/MediaConverter;->buildWebp(Landroid/graphics/Bitmap;I)[B

    move-result-object p0

    return-object p0
.end method

.method private final failed(JJLid/eska/screenshotwebp/OutputFormat;Ljava/lang/String;)Lid/eska/screenshotwebp/ConversionResult;
    .locals 19

    .line 204
    new-instance v0, Lid/eska/screenshotwebp/ConversionResult;

    .line 205
    sget-object v1, Lid/eska/screenshotwebp/ConversionResult$Status;->FAILED:Lid/eska/screenshotwebp/ConversionResult$Status;

    const/16 v17, 0x18f4

    const/16 v18, 0x0

    const-wide/16 v4, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    move-object/from16 v14, p5

    move-wide/from16 v2, p1

    move-wide/from16 v6, p3

    move-object/from16 v13, p5

    move-object/from16 v12, p6

    .line 204
    invoke-direct/range {v0 .. v18}, Lid/eska/screenshotwebp/ConversionResult;-><init>(Lid/eska/screenshotwebp/ConversionResult$Status;JJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/OutputFormat;Lid/eska/screenshotwebp/OutputFormat;ZZILkotlin/jvm/internal/DefaultConstructorMarker;)V

    return-object v0
.end method

.method private final findCandidate(Landroid/graphics/Bitmap;Lid/eska/screenshotwebp/OutputFormat;J)Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;
    .locals 13

    .line 85
    invoke-static {}, Lid/eska/screenshotwebp/CompressionPlanKt;->compressionScales()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    const/4 v8, 0x0

    move-object v9, v8

    :cond_0
    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_10

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    invoke-virtual {v0}, Ljava/lang/Number;->floatValue()F

    move-result v0

    .line 86
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v1, v0

    float-to-int v1, v1

    const/4 v3, 0x1

    invoke-static {v1, v3}, Lkotlin/ranges/RangesKt;->coerceAtLeast(II)I

    move-result v4

    .line 87
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v1, v0

    float-to-int v0, v1

    invoke-static {v0, v3}, Lkotlin/ranges/RangesKt;->coerceAtLeast(II)I

    move-result v5

    .line 88
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    if-ne v4, v0, :cond_1

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v0

    if-ne v5, v0, :cond_1

    move-object v10, p1

    goto :goto_1

    .line 89
    :cond_1
    invoke-static {p1, v4, v5, v3}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v0

    const-string v1, "createScaledBitmap(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    move-object v10, v0

    .line 95
    :goto_1
    :try_start_0
    sget-object v0, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    move-object v0, p0

    check-cast v0, Lid/eska/screenshotwebp/MediaConverter;

    const/16 v0, 0x14

    invoke-direct {p0, v10, p2, v0}, Lid/eska/screenshotwebp/MediaConverter;->encode(Landroid/graphics/Bitmap;Lid/eska/screenshotwebp/OutputFormat;I)[B

    move-result-object v0

    invoke-static {v0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_2

    :catchall_0
    move-exception v0

    :try_start_1
    sget-object v1, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {v0}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :goto_2
    invoke-static {v0}, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    move-object v0, v8

    :cond_2
    check-cast v0, [B

    if-eqz v0, :cond_e

    .line 96
    invoke-direct {p0, v0, p2, v4, v5}, Lid/eska/screenshotwebp/MediaConverter;->verifyBytes([BLid/eska/screenshotwebp/OutputFormat;II)Z

    move-result v1

    if-nez v1, :cond_3

    goto/16 :goto_8

    .line 98
    :cond_3
    new-instance v1, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;

    const/4 v6, 0x0

    move-object v3, p2

    move-object v2, v0

    invoke-direct/range {v1 .. v6}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;-><init>([BLid/eska/screenshotwebp/OutputFormat;IIZ)V

    move-object v6, v1

    move v3, v4

    move v4, v5

    if-nez v9, :cond_4

    move-object v9, v6

    .line 101
    :cond_4
    array-length v0, v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_3

    int-to-long v0, v0

    cmp-long v0, v0, p3

    if-lez v0, :cond_5

    if-eq v10, p1, :cond_0

    .line 144
    :goto_3
    invoke-virtual {v10}, Landroid/graphics/Bitmap;->recycle()V

    goto/16 :goto_0

    .line 107
    :cond_5
    :try_start_2
    sget-object v0, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    move-object v0, p0

    check-cast v0, Lid/eska/screenshotwebp/MediaConverter;

    const/16 v0, 0x55

    invoke-direct {p0, v10, p2, v0}, Lid/eska/screenshotwebp/MediaConverter;->encode(Landroid/graphics/Bitmap;Lid/eska/screenshotwebp/OutputFormat;I)[B

    move-result-object v0

    invoke-static {v0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_4

    :catchall_1
    move-exception v0

    :try_start_3
    sget-object v1, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {v0}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :goto_4
    invoke-static {v0}, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    move-object v0, v8

    :cond_6
    move-object v1, v0

    check-cast v1, [B

    if-eqz v1, :cond_8

    .line 108
    invoke-direct {p0, v1, p2, v3, v4}, Lid/eska/screenshotwebp/MediaConverter;->verifyBytes([BLid/eska/screenshotwebp/OutputFormat;II)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 109
    new-instance v0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;

    const/4 v5, 0x0

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;-><init>([BLid/eska/screenshotwebp/OutputFormat;IIZ)V

    .line 111
    array-length v1, v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    int-to-long v11, v1

    cmp-long v1, v11, p3

    if-gtz v1, :cond_8

    if-eq v10, p1, :cond_7

    .line 144
    invoke-virtual {v10}, Landroid/graphics/Bitmap;->recycle()V

    :cond_7
    return-object v0

    :cond_8
    const/16 v0, 0x15

    const/16 v1, 0x54

    move v7, v1

    move-object v9, v6

    move v6, v0

    :goto_5
    if-gt v6, v7, :cond_c

    add-int v0, v6, v7

    .line 122
    :try_start_4
    div-int/lit8 v11, v0, 0x2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    .line 123
    :try_start_5
    sget-object v0, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    move-object v0, p0

    check-cast v0, Lid/eska/screenshotwebp/MediaConverter;

    invoke-direct {p0, v10, p2, v11}, Lid/eska/screenshotwebp/MediaConverter;->encode(Landroid/graphics/Bitmap;Lid/eska/screenshotwebp/OutputFormat;I)[B

    move-result-object v0

    invoke-static {v0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    goto :goto_6

    :catchall_2
    move-exception v0

    :try_start_6
    sget-object v1, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {v0}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :goto_6
    invoke-static {v0}, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    move-object v0, v8

    :cond_9
    move-object v1, v0

    check-cast v1, [B

    if-eqz v1, :cond_b

    .line 125
    invoke-direct {p0, v1, p2, v3, v4}, Lid/eska/screenshotwebp/MediaConverter;->verifyBytes([BLid/eska/screenshotwebp/OutputFormat;II)Z

    move-result v0

    if-nez v0, :cond_a

    goto :goto_7

    .line 130
    :cond_a
    new-instance v0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;

    const/4 v5, 0x0

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;-><init>([BLid/eska/screenshotwebp/OutputFormat;IIZ)V

    .line 133
    array-length v1, v1
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_3

    int-to-long v1, v1

    cmp-long v1, v1, p3

    if-gtz v1, :cond_b

    add-int/lit8 v6, v11, 0x1

    move-object v9, v0

    goto :goto_5

    :cond_b
    :goto_7
    add-int/lit8 v7, v11, -0x1

    goto :goto_5

    :cond_c
    if-eq v10, p1, :cond_d

    .line 144
    invoke-virtual {v10}, Landroid/graphics/Bitmap;->recycle()V

    :cond_d
    return-object v9

    :cond_e
    :goto_8
    if-eq v10, p1, :cond_0

    goto/16 :goto_3

    :catchall_3
    move-exception v0

    move-object p0, v0

    if-eq v10, p1, :cond_f

    invoke-virtual {v10}, Landroid/graphics/Bitmap;->recycle()V

    :cond_f
    throw p0

    :cond_10
    return-object v9
.end method

.method private final getAvifCoder()Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;
    .locals 0

    .line 17
    iget-object p0, p0, Lid/eska/screenshotwebp/MediaConverter;->avifCoder$delegate:Lkotlin/Lazy;

    invoke-interface {p0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;

    return-object p0
.end method

.method private final verify(Ljava/io/File;Lid/eska/screenshotwebp/OutputFormat;II)Z
    .locals 1

    .line 175
    invoke-virtual {p1}, Ljava/io/File;->isFile()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p1}, Lkotlin/io/FilesKt;->readBytes(Ljava/io/File;)[B

    move-result-object p1

    invoke-direct {p0, p1, p2, p3, p4}, Lid/eska/screenshotwebp/MediaConverter;->verifyBytes([BLid/eska/screenshotwebp/OutputFormat;II)Z

    move-result p0

    if-eqz p0, :cond_0

    const/4 p0, 0x1

    return p0

    :cond_0
    const/4 p0, 0x0

    return p0
.end method

.method private final verifyBytes([BLid/eska/screenshotwebp/OutputFormat;II)Z
    .locals 4

    const/4 v0, 0x1

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 178
    :try_start_0
    sget-object v3, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    move-object v3, p0

    check-cast v3, Lid/eska/screenshotwebp/MediaConverter;

    .line 179
    sget-object v3, Lid/eska/screenshotwebp/MediaConverter$WhenMappings;->$EnumSwitchMapping$0:[I

    invoke-virtual {p2}, Lid/eska/screenshotwebp/OutputFormat;->ordinal()I

    move-result p2

    aget p2, v3, p2

    if-eq p2, v0, :cond_1

    const/4 v3, 0x2

    if-ne p2, v3, :cond_0

    .line 181
    invoke-direct {p0}, Lid/eska/screenshotwebp/MediaConverter;->getAvifCoder()Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;

    move-result-object p0

    invoke-static {p0, p1, v2, v3, v2}, Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;->decode$default(Lcom/radzivon/bartoshyk/avif/coder/HeifCoder;[BLcom/radzivon/bartoshyk/avif/coder/PreferredColorConfig;ILjava/lang/Object;)Landroid/graphics/Bitmap;

    move-result-object p0

    goto :goto_0

    .line 179
    :cond_0
    new-instance p0, Lkotlin/NoWhenBranchMatchedException;

    invoke-direct {p0}, Lkotlin/NoWhenBranchMatchedException;-><init>()V

    throw p0

    .line 180
    :cond_1
    array-length p0, p1

    invoke-static {p1, v1, p0}, Landroid/graphics/BitmapFactory;->decodeByteArray([BII)Landroid/graphics/Bitmap;

    move-result-object p0

    .line 178
    :goto_0
    invoke-static {p0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception p0

    sget-object p1, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {p0}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object p0

    invoke-static {p0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    .line 183
    :goto_1
    invoke-static {p0}, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_2

    goto :goto_2

    :cond_2
    move-object v2, p0

    :goto_2
    check-cast v2, Landroid/graphics/Bitmap;

    if-nez v2, :cond_3

    return v1

    .line 184
    :cond_3
    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result p0

    if-ne p0, p3, :cond_4

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result p0

    if-ne p0, p4, :cond_4

    goto :goto_3

    :cond_4
    move v0, v1

    .line 185
    :goto_3
    invoke-virtual {v2}, Landroid/graphics/Bitmap;->recycle()V

    return v0
.end method


# virtual methods
.method public final convert(Ljava/io/File;Lid/eska/screenshotwebp/OutputFormat;)Lid/eska/screenshotwebp/ConversionResult;
    .locals 25

    move-object/from16 v0, p1

    move-object/from16 v5, p2

    const-string v1, "."

    const-string v2, "source"

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v2, "requested"

    invoke-static {v5, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 20
    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v2

    .line 21
    invoke-static {v2, v3}, Lid/eska/screenshotwebp/TargetPolicyKt;->targetBucket(J)Lid/eska/screenshotwebp/TargetBucket;

    move-result-object v4

    invoke-virtual {v4}, Lid/eska/screenshotwebp/TargetBucket;->getMaxBytes()J

    move-result-wide v6

    .line 22
    invoke-direct/range {p0 .. p1}, Lid/eska/screenshotwebp/MediaConverter;->decodeSource(Ljava/io/File;)Landroid/graphics/Bitmap;

    move-result-object v8

    if-nez v8, :cond_0

    move-wide v1, v2

    move-wide v3, v6

    .line 23
    const-string v6, "Gambar tidak terbaca"

    move-object/from16 v0, p0

    invoke-direct/range {v0 .. v6}, Lid/eska/screenshotwebp/MediaConverter;->failed(JJLid/eska/screenshotwebp/OutputFormat;Ljava/lang/String;)Lid/eska/screenshotwebp/ConversionResult;

    move-result-object v0

    return-object v0

    :cond_0
    move-wide v9, v6

    move-object v6, v1

    move-object/from16 v1, p0

    .line 24
    invoke-direct {v1, v8, v0}, Lid/eska/screenshotwebp/MediaConverter;->applyExifOrientation(Landroid/graphics/Bitmap;Ljava/io/File;)Landroid/graphics/Bitmap;

    move-result-object v7

    .line 26
    :try_start_0
    invoke-direct {v1, v7, v5, v9, v10}, Lid/eska/screenshotwebp/MediaConverter;->findCandidate(Landroid/graphics/Bitmap;Lid/eska/screenshotwebp/OutputFormat;J)Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;

    move-result-object v4

    if-nez v4, :cond_2

    .line 27
    invoke-static {v5}, Lid/eska/screenshotwebp/MediaModelKt;->fallbackFormat(Lid/eska/screenshotwebp/OutputFormat;)Lid/eska/screenshotwebp/OutputFormat;

    move-result-object v4

    invoke-direct {v1, v7, v4, v9, v10}, Lid/eska/screenshotwebp/MediaConverter;->findCandidate(Landroid/graphics/Bitmap;Lid/eska/screenshotwebp/OutputFormat;J)Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;

    move-result-object v11

    if-eqz v11, :cond_1

    const/16 v17, 0xf

    const/16 v18, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x1

    .line 28
    invoke-static/range {v11 .. v18}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->copy$default(Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;[BLid/eska/screenshotwebp/OutputFormat;IIZILjava/lang/Object;)Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;

    move-result-object v4

    goto :goto_0

    :cond_1
    const/4 v4, 0x0

    :cond_2
    :goto_0
    if-nez v4, :cond_4

    .line 31
    const-string v6, "Tidak ada kandidat yang memenuhi batas ukuran"

    move-object v0, v1

    move-wide v1, v2

    move-wide v3, v9

    invoke-direct/range {v0 .. v6}, Lid/eska/screenshotwebp/MediaConverter;->failed(JJLid/eska/screenshotwebp/OutputFormat;Ljava/lang/String;)Lid/eska/screenshotwebp/ConversionResult;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_5

    if-eq v7, v8, :cond_3

    .line 74
    invoke-virtual {v7}, Landroid/graphics/Bitmap;->recycle()V

    .line 75
    :cond_3
    invoke-virtual {v8}, Landroid/graphics/Bitmap;->recycle()V

    return-object v0

    .line 34
    :cond_4
    :try_start_1
    invoke-virtual {v4}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->getFormat()Lid/eska/screenshotwebp/OutputFormat;

    move-result-object v5

    invoke-direct {v1, v0, v5}, Lid/eska/screenshotwebp/MediaConverter;->allocateDestination(Ljava/io/File;Lid/eska/screenshotwebp/OutputFormat;)Ljava/io/File;

    move-result-object v5

    if-nez v5, :cond_6

    .line 35
    const-string v6, "Tidak bisa membuat nama output"

    move-object/from16 v5, p2

    move-object v0, v1

    move-wide v1, v2

    move-wide v3, v9

    invoke-direct/range {v0 .. v6}, Lid/eska/screenshotwebp/MediaConverter;->failed(JJLid/eska/screenshotwebp/OutputFormat;Ljava/lang/String;)Lid/eska/screenshotwebp/ConversionResult;

    move-result-object v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_5

    if-eq v7, v8, :cond_5

    .line 74
    invoke-virtual {v7}, Landroid/graphics/Bitmap;->recycle()V

    .line 75
    :cond_5
    invoke-virtual {v8}, Landroid/graphics/Bitmap;->recycle()V

    return-object v0

    .line 36
    :cond_6
    :try_start_2
    new-instance v11, Ljava/io/File;

    invoke-virtual {v5}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v12

    invoke-virtual {v5}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v13

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v14

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v15, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v13, ".tmp"

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v11, v12, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_5

    .line 39
    :try_start_3
    invoke-virtual {v4}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->getBytes()[B

    move-result-object v6

    invoke-static {v11, v6}, Lkotlin/io/FilesKt;->writeBytes(Ljava/io/File;[B)V

    .line 40
    invoke-virtual {v4}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->getFormat()Lid/eska/screenshotwebp/OutputFormat;

    move-result-object v6

    invoke-virtual {v4}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->getWidth()I

    move-result v12

    invoke-virtual {v4}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->getHeight()I

    move-result v13

    invoke-direct {v1, v11, v6, v12, v13}, Lid/eska/screenshotwebp/MediaConverter;->verify(Ljava/io/File;Lid/eska/screenshotwebp/OutputFormat;II)Z

    move-result v6

    if-nez v6, :cond_7

    .line 42
    const-string v6, "Verifikasi output gagal"

    move-object/from16 v5, p2

    move-object v0, v1

    move-wide v1, v2

    move-wide v3, v9

    invoke-direct/range {v0 .. v6}, Lid/eska/screenshotwebp/MediaConverter;->failed(JJLid/eska/screenshotwebp/OutputFormat;Ljava/lang/String;)Lid/eska/screenshotwebp/ConversionResult;

    move-result-object v0

    :goto_1
    move-object/from16 v22, v7

    move-object/from16 v21, v8

    move-object/from16 v20, v11

    goto/16 :goto_3

    :cond_7
    move-wide v1, v2

    .line 43
    invoke-virtual {v11, v5}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    move-result v3

    if-nez v3, :cond_8

    .line 44
    const-string v6, "Gagal menerbitkan output"

    move-object/from16 v0, p0

    move-object/from16 v5, p2

    move-wide v3, v9

    invoke-direct/range {v0 .. v6}, Lid/eska/screenshotwebp/MediaConverter;->failed(JJLid/eska/screenshotwebp/OutputFormat;Ljava/lang/String;)Lid/eska/screenshotwebp/ConversionResult;

    move-result-object v0

    goto :goto_1

    :cond_8
    move-wide v2, v1

    move-object/from16 v1, p0

    .line 46
    invoke-virtual {v4}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->getFormat()Lid/eska/screenshotwebp/OutputFormat;

    move-result-object v6

    invoke-virtual {v4}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->getWidth()I

    move-result v12

    invoke-virtual {v4}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->getHeight()I

    move-result v13

    invoke-direct {v1, v5, v6, v12, v13}, Lid/eska/screenshotwebp/MediaConverter;->verify(Ljava/io/File;Lid/eska/screenshotwebp/OutputFormat;II)Z

    move-result v6

    if-nez v6, :cond_9

    .line 48
    invoke-virtual {v5}, Ljava/io/File;->delete()Z

    .line 49
    const-string v6, "Verifikasi akhir gagal"

    move-object/from16 v5, p2

    move-object v0, v1

    move-wide v1, v2

    move-wide v3, v9

    invoke-direct/range {v0 .. v6}, Lid/eska/screenshotwebp/MediaConverter;->failed(JJLid/eska/screenshotwebp/OutputFormat;Ljava/lang/String;)Lid/eska/screenshotwebp/ConversionResult;

    move-result-object v0

    goto :goto_1

    :cond_9
    move-wide v1, v2

    .line 50
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    move-result v3

    if-nez v3, :cond_a

    .line 51
    invoke-virtual {v5}, Ljava/io/File;->delete()Z

    .line 52
    const-string v6, "Sumber tidak bisa dihapus"

    move-object/from16 v0, p0

    move-object/from16 v5, p2

    move-wide v3, v9

    invoke-direct/range {v0 .. v6}, Lid/eska/screenshotwebp/MediaConverter;->failed(JJLid/eska/screenshotwebp/OutputFormat;Ljava/lang/String;)Lid/eska/screenshotwebp/ConversionResult;

    move-result-object v0

    goto :goto_1

    .line 55
    :cond_a
    sget-object v3, Lid/eska/screenshotwebp/ConversionResult$Status;->SUCCESS:Lid/eska/screenshotwebp/ConversionResult$Status;

    move-object v6, v4

    move-object v12, v5

    .line 57
    invoke-virtual {v12}, Ljava/io/File;->length()J

    move-result-wide v4

    .line 59
    invoke-virtual {v12}, Ljava/io/File;->length()J

    move-result-wide v13

    cmp-long v13, v13, v9

    if-gtz v13, :cond_b

    const/4 v13, 0x1

    goto :goto_2

    :cond_b
    const/4 v13, 0x0

    :goto_2
    move/from16 v16, v13

    .line 60
    invoke-virtual {v6}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->getWidth()I

    move-result v13

    .line 61
    invoke-virtual {v6}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->getHeight()I

    move-result v14

    .line 62
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    .line 63
    invoke-virtual {v12}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    move v15, v14

    .line 65
    invoke-virtual {v6}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->getFormat()Lid/eska/screenshotwebp/OutputFormat;

    move-result-object v14

    .line 66
    invoke-virtual {v6}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->getUsedFallback()Z

    move-result v6
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    move/from16 v17, v15

    move v15, v6

    move-wide/from16 v23, v9

    move-object v10, v0

    move-object v9, v7

    move-wide/from16 v6, v23

    .line 54
    :try_start_4
    new-instance v0, Lid/eska/screenshotwebp/ConversionResult;

    .line 60
    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    .line 61
    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    move-object/from16 v18, v9

    move-object/from16 v9, v17

    const/16 v17, 0x100

    move-object/from16 v19, v18

    const/16 v18, 0x0

    move-object/from16 v20, v11

    move-object v11, v12

    const/4 v12, 0x0

    move-wide/from16 v21, v1

    move-object v1, v3

    move-wide/from16 v2, v21

    move-object/from16 v21, v8

    move-object v8, v13

    move-object/from16 v22, v19

    move-object/from16 v13, p2

    .line 54
    :try_start_5
    invoke-direct/range {v0 .. v18}, Lid/eska/screenshotwebp/ConversionResult;-><init>(Lid/eska/screenshotwebp/ConversionResult$Status;JJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/OutputFormat;Lid/eska/screenshotwebp/OutputFormat;ZZILkotlin/jvm/internal/DefaultConstructorMarker;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 71
    :goto_3
    :try_start_6
    invoke-virtual/range {v20 .. v20}, Ljava/io/File;->delete()Z
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    move-object/from16 v1, v21

    move-object/from16 v9, v22

    if-eq v9, v1, :cond_c

    .line 74
    invoke-virtual {v9}, Landroid/graphics/Bitmap;->recycle()V

    .line 75
    :cond_c
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->recycle()V

    return-object v0

    :catchall_0
    move-exception v0

    move-object/from16 v1, v21

    move-object/from16 v9, v22

    goto :goto_6

    :catchall_1
    move-exception v0

    move-object/from16 v1, v21

    move-object/from16 v9, v22

    goto :goto_5

    :catchall_2
    move-exception v0

    goto :goto_4

    :catchall_3
    move-exception v0

    move-object v9, v7

    :goto_4
    move-object v1, v8

    move-object/from16 v20, v11

    .line 71
    :goto_5
    :try_start_7
    invoke-virtual/range {v20 .. v20}, Ljava/io/File;->delete()Z

    throw v0
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_4

    :catchall_4
    move-exception v0

    goto :goto_6

    :catchall_5
    move-exception v0

    move-object v9, v7

    move-object v1, v8

    :goto_6
    if-eq v9, v1, :cond_d

    .line 74
    invoke-virtual {v9}, Landroid/graphics/Bitmap;->recycle()V

    .line 75
    :cond_d
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->recycle()V

    throw v0
.end method
