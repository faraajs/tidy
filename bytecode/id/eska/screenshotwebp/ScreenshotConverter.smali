.class public final Lid/eska/screenshotwebp/ScreenshotConverter;
.super Ljava/lang/Object;
.source "ScreenshotConverter.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\u0008\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007\u00a8\u0006\t"
    }
    d2 = {
        "Lid/eska/screenshotwebp/ScreenshotConverter;",
        "",
        "<init>",
        "()V",
        "convert",
        "Lid/eska/screenshotwebp/ConversionResult;",
        "source",
        "Ljava/io/File;",
        "destination",
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
.field public static final $stable:I


# direct methods
.method static constructor <clinit>()V
    .locals 0

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final convert(Ljava/io/File;Ljava/io/File;)Lid/eska/screenshotwebp/ConversionResult;
    .locals 28

    move-object/from16 v1, p2

    const-string v0, "source"

    move-object/from16 v2, p1

    invoke-static {v2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "destination"

    invoke-static {v1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 29
    invoke-virtual {v2}, Ljava/io/File;->length()J

    move-result-wide v3

    .line 30
    invoke-static {v3, v4}, Lid/eska/screenshotwebp/TargetPolicyKt;->targetBucket(J)Lid/eska/screenshotwebp/TargetBucket;

    move-result-object v0

    invoke-virtual {v0}, Lid/eska/screenshotwebp/TargetBucket;->getMaxBytes()J

    move-result-wide v7

    .line 31
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 32
    invoke-virtual {v1}, Ljava/io/File;->isFile()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 33
    new-instance v1, Lid/eska/screenshotwebp/ConversionResult;

    sget-object v2, Lid/eska/screenshotwebp/ConversionResult$Status;->EXISTING_OUTPUT:Lid/eska/screenshotwebp/ConversionResult$Status;

    const/16 v18, 0x1ff4

    const/16 v19, 0x0

    const-wide/16 v5, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    invoke-direct/range {v1 .. v19}, Lid/eska/screenshotwebp/ConversionResult;-><init>(Lid/eska/screenshotwebp/ConversionResult$Status;JJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/OutputFormat;Lid/eska/screenshotwebp/OutputFormat;ZZILkotlin/jvm/internal/DefaultConstructorMarker;)V

    return-object v1

    .line 35
    :cond_0
    new-instance v1, Lid/eska/screenshotwebp/ConversionResult;

    .line 36
    sget-object v2, Lid/eska/screenshotwebp/ConversionResult$Status;->FAILED:Lid/eska/screenshotwebp/ConversionResult$Status;

    const/16 v18, 0x1ef4

    const/16 v19, 0x0

    const-wide/16 v5, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    .line 35
    const-string v13, "Destination path is not a file"

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    invoke-direct/range {v1 .. v19}, Lid/eska/screenshotwebp/ConversionResult;-><init>(Lid/eska/screenshotwebp/ConversionResult$Status;JJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/OutputFormat;Lid/eska/screenshotwebp/OutputFormat;ZZILkotlin/jvm/internal/DefaultConstructorMarker;)V

    return-object v1

    .line 43
    :cond_1
    invoke-virtual {v2}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v5

    if-nez v5, :cond_2

    .line 44
    new-instance v1, Lid/eska/screenshotwebp/ConversionResult;

    sget-object v2, Lid/eska/screenshotwebp/ConversionResult$Status;->FAILED:Lid/eska/screenshotwebp/ConversionResult$Status;

    const/16 v18, 0x1ef4

    const/16 v19, 0x0

    const-wide/16 v5, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const-string v13, "Unreadable image"

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    invoke-direct/range {v1 .. v19}, Lid/eska/screenshotwebp/ConversionResult;-><init>(Lid/eska/screenshotwebp/ConversionResult$Status;JJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/OutputFormat;Lid/eska/screenshotwebp/OutputFormat;ZZILkotlin/jvm/internal/DefaultConstructorMarker;)V

    return-object v1

    .line 45
    :cond_2
    new-instance v6, Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v0

    invoke-virtual {v1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v10

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "."

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v11, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ".tmp"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v6, v0, v9}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 47
    :try_start_0
    invoke-static {}, Lid/eska/screenshotwebp/CompressionPlanKt;->compressionCandidates()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v22

    :goto_0
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->hasNext()Z

    move-result v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_b

    if-eqz v0, :cond_10

    :try_start_1
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lid/eska/screenshotwebp/CompressionCandidate;

    .line 48
    invoke-virtual {v5}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v9

    int-to-float v9, v9

    invoke-virtual {v0}, Lid/eska/screenshotwebp/CompressionCandidate;->getScale()F

    move-result v10

    mul-float/2addr v9, v10

    float-to-int v9, v9

    const/4 v10, 0x1

    invoke-static {v9, v10}, Lkotlin/ranges/RangesKt;->coerceAtLeast(II)I

    move-result v9

    .line 49
    invoke-virtual {v5}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    int-to-float v11, v11

    invoke-virtual {v0}, Lid/eska/screenshotwebp/CompressionCandidate;->getScale()F

    move-result v12

    mul-float/2addr v11, v12

    float-to-int v11, v11

    invoke-static {v11, v10}, Lkotlin/ranges/RangesKt;->coerceAtLeast(II)I

    move-result v11

    .line 50
    invoke-virtual {v5}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v12
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_8

    if-ne v9, v12, :cond_3

    :try_start_2
    invoke-virtual {v5}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v12
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_b

    if-ne v11, v12, :cond_3

    move-object v12, v5

    goto :goto_1

    .line 51
    :cond_3
    :try_start_3
    invoke-static {v5, v9, v11, v10}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v12

    const-string v13, "createScaledBitmap(...)"

    invoke-static {v12, v13}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_8

    .line 53
    :goto_1
    :try_start_4
    new-instance v13, Ljava/io/FileOutputStream;

    invoke-direct {v13, v6}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    check-cast v13, Ljava/io/Closeable;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_5

    :try_start_5
    move-object v14, v13

    check-cast v14, Ljava/io/FileOutputStream;

    .line 55
    sget-object v15, Landroid/graphics/Bitmap$CompressFormat;->WEBP_LOSSY:Landroid/graphics/Bitmap$CompressFormat;

    .line 60
    invoke-virtual {v0}, Lid/eska/screenshotwebp/CompressionCandidate;->getQuality()I

    move-result v0

    check-cast v14, Ljava/io/OutputStream;

    invoke-virtual {v12, v15, v0, v14}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 61
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_3

    const/4 v0, 0x0

    .line 53
    :try_start_6
    invoke-static {v13, v0}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    .line 62
    invoke-virtual {v6}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    if-eqz v0, :cond_b

    .line 63
    invoke-virtual {v6}, Ljava/io/File;->length()J

    move-result-wide v13

    cmp-long v13, v13, v7

    if-gtz v13, :cond_b

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v13

    if-ne v13, v9, :cond_b

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v13

    if-ne v13, v11, :cond_b

    .line 64
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 65
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_a

    invoke-virtual {v6, v1}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    move-result v0

    if-nez v0, :cond_4

    goto/16 :goto_5

    .line 68
    :cond_4
    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    if-eqz v0, :cond_5

    .line 69
    invoke-virtual {v1}, Ljava/io/File;->length()J

    move-result-wide v13

    cmp-long v13, v13, v7

    if-gtz v13, :cond_5

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v13

    if-ne v13, v9, :cond_5

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v13

    if-ne v13, v11, :cond_5

    goto :goto_2

    :cond_5
    const/4 v10, 0x0

    :goto_2
    if-eqz v0, :cond_6

    .line 70
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    :cond_6
    if-nez v10, :cond_8

    .line 72
    invoke-virtual {v1}, Ljava/io/File;->delete()Z
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_4
    .catchall {:try_start_6 .. :try_end_6} :catchall_5

    move-object v9, v6

    move-wide/from16 v26, v3

    move-object v4, v5

    move-wide/from16 v5, v26

    .line 73
    :try_start_7
    new-instance v3, Lid/eska/screenshotwebp/ConversionResult;
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    move-object v10, v4

    :try_start_8
    sget-object v4, Lid/eska/screenshotwebp/ConversionResult$Status;->FAILED:Lid/eska/screenshotwebp/ConversionResult$Status;

    const-string v15, "Final verification failed"
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_0
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    const/16 v20, 0x1ef4

    const/16 v21, 0x0

    move-object v13, v9

    move-object v11, v10

    move-wide v9, v7

    const-wide/16 v7, 0x0

    move-object v14, v11

    const/4 v11, 0x0

    move-object/from16 v16, v12

    const/4 v12, 0x0

    move-object/from16 v17, v13

    const/4 v13, 0x0

    move-object/from16 v18, v14

    const/4 v14, 0x0

    move-object/from16 v19, v16

    const/16 v16, 0x0

    move-object/from16 v23, v17

    const/16 v17, 0x0

    move-object/from16 v24, v18

    const/16 v18, 0x0

    move-object/from16 v25, v19

    const/16 v19, 0x0

    move-object/from16 v1, v24

    move-object/from16 v2, v25

    :try_start_9
    invoke-direct/range {v3 .. v21}, Lid/eska/screenshotwebp/ConversionResult;-><init>(Lid/eska/screenshotwebp/ConversionResult$Status;JJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/OutputFormat;Lid/eska/screenshotwebp/OutputFormat;ZZILkotlin/jvm/internal/DefaultConstructorMarker;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_2
    .catchall {:try_start_9 .. :try_end_9} :catchall_6

    if-eq v2, v1, :cond_7

    .line 85
    :try_start_a
    invoke-virtual {v2}, Landroid/graphics/Bitmap;->recycle()V

    .line 86
    :cond_7
    :goto_3
    invoke-virtual/range {v23 .. v23}, Ljava/io/File;->delete()Z
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_7

    .line 91
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->recycle()V

    .line 92
    invoke-virtual/range {v23 .. v23}, Ljava/io/File;->delete()Z

    return-object v3

    :catchall_0
    move-exception v0

    move-object/from16 v23, v9

    move-object v1, v10

    goto/16 :goto_8

    :catch_0
    move-object/from16 v23, v9

    move-object v1, v10

    goto :goto_4

    :catchall_1
    move-exception v0

    move-object v1, v4

    move-object/from16 v23, v9

    goto/16 :goto_8

    :catch_1
    move-object v1, v4

    move-object/from16 v23, v9

    :goto_4
    move-object v2, v12

    goto/16 :goto_6

    :cond_8
    move-object v1, v5

    move-object/from16 v23, v6

    move-object v2, v12

    .line 75
    :try_start_b
    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->delete()Z

    move-result v0

    if-nez v0, :cond_9

    .line 76
    invoke-virtual/range {p2 .. p2}, Ljava/io/File;->delete()Z
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_5
    .catchall {:try_start_b .. :try_end_b} :catchall_6

    move-wide v5, v3

    .line 77
    :try_start_c
    new-instance v3, Lid/eska/screenshotwebp/ConversionResult;

    sget-object v4, Lid/eska/screenshotwebp/ConversionResult$Status;->FAILED:Lid/eska/screenshotwebp/ConversionResult$Status;

    const-string v15, "Source delete failed"
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_3
    .catchall {:try_start_c .. :try_end_c} :catchall_6

    const/16 v20, 0x1ef4

    const/16 v21, 0x0

    move-wide v9, v7

    const-wide/16 v7, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    :try_start_d
    invoke-direct/range {v3 .. v21}, Lid/eska/screenshotwebp/ConversionResult;-><init>(Lid/eska/screenshotwebp/ConversionResult$Status;JJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/OutputFormat;Lid/eska/screenshotwebp/OutputFormat;ZZILkotlin/jvm/internal/DefaultConstructorMarker;)V
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_2
    .catchall {:try_start_d .. :try_end_d} :catchall_6

    if-eq v2, v1, :cond_7

    .line 85
    :try_start_e
    invoke-virtual {v2}, Landroid/graphics/Bitmap;->recycle()V
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_7

    goto :goto_3

    :cond_9
    move-wide v5, v3

    .line 79
    :try_start_f
    new-instance v3, Lid/eska/screenshotwebp/ConversionResult;

    sget-object v4, Lid/eska/screenshotwebp/ConversionResult$Status;->SUCCESS:Lid/eska/screenshotwebp/ConversionResult$Status;
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_f} :catch_3
    .catchall {:try_start_f .. :try_end_f} :catchall_6

    move v0, v9

    move-wide v9, v7

    :try_start_10
    invoke-virtual/range {p2 .. p2}, Ljava/io/File;->length()J

    move-result-wide v7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v13

    invoke-virtual/range {p2 .. p2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v14

    const/16 v20, 0x1f00

    const/16 v21, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    move-object v11, v0

    invoke-direct/range {v3 .. v21}, Lid/eska/screenshotwebp/ConversionResult;-><init>(Lid/eska/screenshotwebp/ConversionResult$Status;JJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/OutputFormat;Lid/eska/screenshotwebp/OutputFormat;ZZILkotlin/jvm/internal/DefaultConstructorMarker;)V
    :try_end_10
    .catch Ljava/lang/Exception; {:try_start_10 .. :try_end_10} :catch_2
    .catchall {:try_start_10 .. :try_end_10} :catchall_6

    if-eq v2, v1, :cond_7

    .line 85
    :try_start_11
    invoke-virtual {v2}, Landroid/graphics/Bitmap;->recycle()V
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_7

    goto/16 :goto_3

    :cond_a
    :goto_5
    move-object v1, v5

    move-object/from16 v23, v6

    move-object v2, v12

    move-wide v5, v3

    .line 66
    :try_start_12
    new-instance v3, Lid/eska/screenshotwebp/ConversionResult;

    sget-object v4, Lid/eska/screenshotwebp/ConversionResult$Status;->EXISTING_OUTPUT:Lid/eska/screenshotwebp/ConversionResult$Status;
    :try_end_12
    .catch Ljava/lang/Exception; {:try_start_12 .. :try_end_12} :catch_3
    .catchall {:try_start_12 .. :try_end_12} :catchall_6

    const/16 v20, 0x1ff4

    const/16 v21, 0x0

    move-wide v9, v7

    const-wide/16 v7, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    :try_start_13
    invoke-direct/range {v3 .. v21}, Lid/eska/screenshotwebp/ConversionResult;-><init>(Lid/eska/screenshotwebp/ConversionResult$Status;JJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/OutputFormat;Lid/eska/screenshotwebp/OutputFormat;ZZILkotlin/jvm/internal/DefaultConstructorMarker;)V
    :try_end_13
    .catch Ljava/lang/Exception; {:try_start_13 .. :try_end_13} :catch_2
    .catchall {:try_start_13 .. :try_end_13} :catchall_6

    if-eq v2, v1, :cond_7

    .line 85
    :try_start_14
    invoke-virtual {v2}, Landroid/graphics/Bitmap;->recycle()V
    :try_end_14
    .catchall {:try_start_14 .. :try_end_14} :catchall_7

    goto/16 :goto_3

    :catch_2
    move-wide v3, v5

    move-wide v7, v9

    goto :goto_9

    :catch_3
    :goto_6
    move-wide v3, v5

    goto :goto_9

    :cond_b
    move-object v1, v5

    move-object/from16 v23, v6

    move-object v2, v12

    if-eqz v0, :cond_c

    .line 81
    :try_start_15
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;
    :try_end_15
    .catch Ljava/lang/Exception; {:try_start_15 .. :try_end_15} :catch_5
    .catchall {:try_start_15 .. :try_end_15} :catchall_6

    :cond_c
    if-eq v2, v1, :cond_e

    .line 85
    :try_start_16
    invoke-virtual {v2}, Landroid/graphics/Bitmap;->recycle()V
    :try_end_16
    .catchall {:try_start_16 .. :try_end_16} :catchall_7

    goto :goto_a

    :cond_d
    move-object v1, v5

    move-object/from16 v23, v6

    move-object v2, v12

    .line 60
    :try_start_17
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v5, "Check failed."

    invoke-direct {v0, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_17
    .catchall {:try_start_17 .. :try_end_17} :catchall_2

    :catchall_2
    move-exception v0

    goto :goto_7

    :catchall_3
    move-exception v0

    move-object v1, v5

    move-object/from16 v23, v6

    move-object v2, v12

    :goto_7
    move-object v5, v0

    .line 53
    :try_start_18
    throw v5
    :try_end_18
    .catchall {:try_start_18 .. :try_end_18} :catchall_4

    :catchall_4
    move-exception v0

    :try_start_19
    invoke-static {v13, v5}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    throw v0
    :try_end_19
    .catch Ljava/lang/Exception; {:try_start_19 .. :try_end_19} :catch_5
    .catchall {:try_start_19 .. :try_end_19} :catchall_6

    :catchall_5
    move-exception v0

    move-object v1, v5

    move-object/from16 v23, v6

    :goto_8
    move-object v2, v12

    goto :goto_b

    :catch_4
    move-object v1, v5

    move-object/from16 v23, v6

    move-object v2, v12

    .line 82
    :catch_5
    :goto_9
    :try_start_1a
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;
    :try_end_1a
    .catchall {:try_start_1a .. :try_end_1a} :catchall_6

    if-eq v2, v1, :cond_e

    .line 85
    :try_start_1b
    invoke-virtual {v2}, Landroid/graphics/Bitmap;->recycle()V

    .line 86
    :cond_e
    :goto_a
    invoke-virtual/range {v23 .. v23}, Ljava/io/File;->delete()Z

    move-object/from16 v2, p1

    move-object v5, v1

    move-object/from16 v6, v23

    move-object/from16 v1, p2

    goto/16 :goto_0

    :catchall_6
    move-exception v0

    :goto_b
    if-eq v2, v1, :cond_f

    .line 85
    invoke-virtual {v2}, Landroid/graphics/Bitmap;->recycle()V

    .line 86
    :cond_f
    invoke-virtual/range {v23 .. v23}, Ljava/io/File;->delete()Z

    throw v0
    :try_end_1b
    .catchall {:try_start_1b .. :try_end_1b} :catchall_7

    :catchall_7
    move-exception v0

    goto :goto_c

    :catchall_8
    move-exception v0

    move-object v1, v5

    move-object/from16 v23, v6

    :goto_c
    move-object/from16 v24, v1

    goto :goto_d

    :cond_10
    move-object v14, v5

    move-object/from16 v23, v6

    .line 89
    :try_start_1c
    new-instance v1, Lid/eska/screenshotwebp/ConversionResult;

    sget-object v2, Lid/eska/screenshotwebp/ConversionResult$Status;->FAILED:Lid/eska/screenshotwebp/ConversionResult$Status;

    const-string v13, "No candidate met target"
    :try_end_1c
    .catchall {:try_start_1c .. :try_end_1c} :catchall_a

    const/16 v18, 0x1ef4

    const/16 v19, 0x0

    const-wide/16 v5, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    move-object/from16 v24, v14

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    :try_start_1d
    invoke-direct/range {v1 .. v19}, Lid/eska/screenshotwebp/ConversionResult;-><init>(Lid/eska/screenshotwebp/ConversionResult$Status;JJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/OutputFormat;Lid/eska/screenshotwebp/OutputFormat;ZZILkotlin/jvm/internal/DefaultConstructorMarker;)V
    :try_end_1d
    .catchall {:try_start_1d .. :try_end_1d} :catchall_9

    .line 91
    invoke-virtual/range {v24 .. v24}, Landroid/graphics/Bitmap;->recycle()V

    .line 92
    invoke-virtual/range {v23 .. v23}, Ljava/io/File;->delete()Z

    return-object v1

    :catchall_9
    move-exception v0

    goto :goto_d

    :catchall_a
    move-exception v0

    move-object/from16 v24, v14

    goto :goto_d

    :catchall_b
    move-exception v0

    move-object/from16 v24, v5

    move-object/from16 v23, v6

    .line 91
    :goto_d
    invoke-virtual/range {v24 .. v24}, Landroid/graphics/Bitmap;->recycle()V

    .line 92
    invoke-virtual/range {v23 .. v23}, Ljava/io/File;->delete()Z

    throw v0
.end method
