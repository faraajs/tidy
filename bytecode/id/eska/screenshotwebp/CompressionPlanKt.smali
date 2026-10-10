.class public final Lid/eska/screenshotwebp/CompressionPlanKt;
.super Ljava/lang/Object;
.source "CompressionPlan.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nCompressionPlan.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompressionPlan.kt\nid/eska/screenshotwebp/CompressionPlanKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,26:1\n1391#2:27\n1480#2,2:28\n1586#2:30\n1661#2,3:31\n1482#2,3:34\n*S KotlinDebug\n*F\n+ 1 CompressionPlan.kt\nid/eska/screenshotwebp/CompressionPlanKt\n*L\n16#1:27\n16#1:28,2\n17#1:30\n17#1:31,3\n16#1:34,3\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000(\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u001a\u0006\u0010\u0007\u001a\u00020\u0008\u001a\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0005\u001a\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0005\u001a\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0005\u001a \u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"
    }
    d2 = {
        "SCREENSHOT_QUALITY",
        "",
        "SCREENSHOT_TARGET_BYTES",
        "",
        "screenshotOutputOrder",
        "",
        "Lid/eska/screenshotwebp/OutputFormat;",
        "screenshotScale",
        "",
        "compressionScales",
        "initialQualityCandidates",
        "compressionCandidates",
        "Lid/eska/screenshotwebp/CompressionCandidate;",
        "sampleSizeFor",
        "width",
        "height",
        "maxLongEdge",
        "app_release"
    }
    k = 0x2
    mv = {
        0x2,
        0x3,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final SCREENSHOT_QUALITY:I = 0x37

.field public static final SCREENSHOT_TARGET_BYTES:J = 0x19000L


# direct methods
.method public static final compressionCandidates()Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lid/eska/screenshotwebp/CompressionCandidate;",
            ">;"
        }
    .end annotation

    .line 16
    invoke-static {}, Lid/eska/screenshotwebp/CompressionPlanKt;->compressionScales()Ljava/util/List;

    move-result-object v0

    check-cast v0, Ljava/lang/Iterable;

    .line 27
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    check-cast v1, Ljava/util/Collection;

    .line 28
    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .line 29
    check-cast v2, Ljava/lang/Number;

    invoke-virtual {v2}, Ljava/lang/Number;->floatValue()F

    move-result v2

    .line 17
    invoke-static {}, Lid/eska/screenshotwebp/CompressionPlanKt;->initialQualityCandidates()Ljava/util/List;

    move-result-object v3

    check-cast v3, Ljava/lang/Iterable;

    .line 30
    new-instance v4, Ljava/util/ArrayList;

    const/16 v5, 0xa

    invoke-static {v3, v5}, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable;I)I

    move-result v5

    invoke-direct {v4, v5}, Ljava/util/ArrayList;-><init>(I)V

    check-cast v4, Ljava/util/Collection;

    .line 31
    invoke-interface {v3}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    .line 32
    check-cast v5, Ljava/lang/Number;

    invoke-virtual {v5}, Ljava/lang/Number;->intValue()I

    move-result v5

    .line 17
    new-instance v6, Lid/eska/screenshotwebp/CompressionCandidate;

    invoke-direct {v6, v5, v2}, Lid/eska/screenshotwebp/CompressionCandidate;-><init>(IF)V

    .line 32
    invoke-interface {v4, v6}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 33
    :cond_0
    check-cast v4, Ljava/util/List;

    .line 30
    check-cast v4, Ljava/lang/Iterable;

    .line 34
    invoke-static {v1, v4}, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection;Ljava/lang/Iterable;)Z

    goto :goto_0

    .line 36
    :cond_1
    check-cast v1, Ljava/util/List;

    return-object v1
.end method

.method public static final compressionScales()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/Float;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x4

    .line 12
    new-array v0, v0, [Ljava/lang/Float;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    const/4 v2, 0x0

    aput-object v1, v0, v2

    const/high16 v1, 0x3f400000    # 0.75f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    const/4 v2, 0x1

    aput-object v1, v0, v2

    const/high16 v1, 0x3f000000    # 0.5f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    const/4 v2, 0x2

    aput-object v1, v0, v2

    const/high16 v1, 0x3e800000    # 0.25f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    const/4 v2, 0x3

    aput-object v1, v0, v2

    invoke-static {v0}, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static final initialQualityCandidates()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x3

    .line 14
    new-array v0, v0, [Ljava/lang/Integer;

    const/16 v1, 0x55

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const/4 v2, 0x0

    aput-object v1, v0, v2

    const/16 v1, 0x37

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const/4 v2, 0x1

    aput-object v1, v0, v2

    const/16 v1, 0x19

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const/4 v2, 0x2

    aput-object v1, v0, v2

    invoke-static {v0}, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static final sampleSizeFor(III)I
    .locals 2

    const/4 v0, 0x1

    .line 23
    :goto_0
    invoke-static {p0, p1}, Ljava/lang/Math;->max(II)I

    move-result v1

    div-int/2addr v1, v0

    if-le v1, p2, :cond_0

    mul-int/lit8 v0, v0, 0x2

    goto :goto_0

    :cond_0
    return v0
.end method

.method public static synthetic sampleSizeFor$default(IIIILjava/lang/Object;)I
    .locals 0

    and-int/lit8 p3, p3, 0x4

    if-eqz p3, :cond_0

    const/16 p2, 0xa00

    .line 21
    :cond_0
    invoke-static {p0, p1, p2}, Lid/eska/screenshotwebp/CompressionPlanKt;->sampleSizeFor(III)I

    move-result p0

    return p0
.end method

.method public static final screenshotOutputOrder()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lid/eska/screenshotwebp/OutputFormat;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x2

    .line 8
    new-array v0, v0, [Lid/eska/screenshotwebp/OutputFormat;

    const/4 v1, 0x0

    sget-object v2, Lid/eska/screenshotwebp/OutputFormat;->AVIF:Lid/eska/screenshotwebp/OutputFormat;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    sget-object v2, Lid/eska/screenshotwebp/OutputFormat;->WEBP:Lid/eska/screenshotwebp/OutputFormat;

    aput-object v2, v0, v1

    invoke-static {v0}, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static final screenshotScale()F
    .locals 1

    const/high16 v0, 0x3f800000    # 1.0f

    return v0
.end method
