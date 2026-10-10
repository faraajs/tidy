.class public final Lid/eska/screenshotwebp/PathPolicy;
.super Ljava/lang/Object;
.source "PathPolicy.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nPathPolicy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathPolicy.kt\nid/eska/screenshotwebp/PathPolicy\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,46:1\n1#2:47\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u00c7\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002\u00a2\u0006\u0004\u0008\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0016\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0014\u0010\u001a\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0008\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u0007R\u0017\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00050\r\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"
    }
    d2 = {
        "Lid/eska/screenshotwebp/PathPolicy;",
        "",
        "<init>",
        "()V",
        "storageRoot",
        "Ljava/io/File;",
        "getStorageRoot",
        "()Ljava/io/File;",
        "screenshotRoot",
        "getScreenshotRoot",
        "cameraRoot",
        "getCameraRoot",
        "photoRoots",
        "",
        "getPhotoRoots",
        "()Ljava/util/List;",
        "inputExtensions",
        "",
        "",
        "technicalDirectoryNames",
        "isInputImage",
        "",
        "file",
        "categoryFor",
        "Lid/eska/screenshotwebp/MediaCategory;",
        "hasHiddenOrTechnicalParent",
        "isDescendantOf",
        "root",
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

.field public static final INSTANCE:Lid/eska/screenshotwebp/PathPolicy;

.field private static final cameraRoot:Ljava/io/File;

.field private static final inputExtensions:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final photoRoots:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation
.end field

.field private static final screenshotRoot:Ljava/io/File;

.field private static final storageRoot:Ljava/io/File;

.field private static final technicalDirectoryNames:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 6

    new-instance v0, Lid/eska/screenshotwebp/PathPolicy;

    invoke-direct {v0}, Lid/eska/screenshotwebp/PathPolicy;-><init>()V

    sput-object v0, Lid/eska/screenshotwebp/PathPolicy;->INSTANCE:Lid/eska/screenshotwebp/PathPolicy;

    .line 6
    new-instance v0, Ljava/io/File;

    const-string v1, "/sdcard"

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    sput-object v0, Lid/eska/screenshotwebp/PathPolicy;->storageRoot:Ljava/io/File;

    .line 7
    new-instance v0, Ljava/io/File;

    const-string v1, "/sdcard/DCIM/Screenshots"

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    sput-object v0, Lid/eska/screenshotwebp/PathPolicy;->screenshotRoot:Ljava/io/File;

    .line 8
    new-instance v0, Ljava/io/File;

    const-string v1, "/sdcard/DCIM/Camera"

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    sput-object v0, Lid/eska/screenshotwebp/PathPolicy;->cameraRoot:Ljava/io/File;

    .line 9
    invoke-static {v0}, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lid/eska/screenshotwebp/PathPolicy;->photoRoots:Ljava/util/List;

    const/4 v0, 0x3

    .line 13
    new-array v1, v0, [Ljava/lang/String;

    const-string v2, "jpg"

    const/4 v3, 0x0

    aput-object v2, v1, v3

    const-string v2, "jpeg"

    const/4 v4, 0x1

    aput-object v2, v1, v4

    const-string v2, "png"

    const/4 v5, 0x2

    aput-object v2, v1, v5

    invoke-static {v1}, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;

    move-result-object v1

    sput-object v1, Lid/eska/screenshotwebp/PathPolicy;->inputExtensions:Ljava/util/Set;

    const/4 v1, 0x5

    .line 14
    new-array v1, v1, [Ljava/lang/String;

    const-string v2, "android"

    aput-object v2, v1, v3

    const-string v2, "thumbnails"

    aput-object v2, v1, v4

    const-string v2, "cache"

    aput-object v2, v1, v5

    const-string v2, "caches"

    aput-object v2, v1, v0

    const/4 v0, 0x4

    const-string v2, ".thumbnails"

    aput-object v2, v1, v0

    invoke-static {v1}, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;

    move-result-object v0

    sput-object v0, Lid/eska/screenshotwebp/PathPolicy;->technicalDirectoryNames:Ljava/util/Set;

    const/16 v0, 0x8

    sput v0, Lid/eska/screenshotwebp/PathPolicy;->$stable:I

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private final hasHiddenOrTechnicalParent(Ljava/io/File;)Z
    .locals 4

    .line 31
    invoke-virtual {p1}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object p0

    :goto_0
    const/4 p1, 0x0

    if-eqz p0, :cond_2

    .line 32
    invoke-virtual {p0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v0

    const-string v1, "/"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 33
    invoke-virtual {p0}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "getName(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    sget-object v1, Ljava/util/Locale;->ROOT:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "toLowerCase(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x2

    const/4 v2, 0x0

    .line 34
    const-string v3, "."

    invoke-static {v0, v3, p1, v1, v2}, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_1

    sget-object p1, Lid/eska/screenshotwebp/PathPolicy;->technicalDirectoryNames:Ljava/util/Set;

    invoke-interface {p1, v0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_0

    goto :goto_1

    .line 35
    :cond_0
    invoke-virtual {p0}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object p0

    goto :goto_0

    :cond_1
    :goto_1
    const/4 p0, 0x1

    return p0

    :cond_2
    return p1
.end method

.method private final isDescendantOf(Ljava/io/File;Ljava/io/File;)Z
    .locals 4

    .line 41
    invoke-virtual {p2}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object p0

    const-string p2, "getPath(...)"

    invoke-static {p0, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x1

    new-array v1, v0, [C

    const/4 v2, 0x0

    const/16 v3, 0x2f

    aput-char v3, v1, v2

    invoke-static {p0, v1}, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String;[C)Ljava/lang/String;

    move-result-object p0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string v1, "/"

    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    .line 42
    invoke-virtual {p1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    new-array p2, v0, [C

    aput-char v3, p2, v2

    invoke-static {p1, p2}, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String;[C)Ljava/lang/String;

    move-result-object p1

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const/4 p2, 0x2

    const/4 v0, 0x0

    .line 43
    invoke-static {p1, p0, v2, p2, v0}, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z

    move-result p0

    return p0
.end method


# virtual methods
.method public final categoryFor(Ljava/io/File;)Lid/eska/screenshotwebp/MediaCategory;
    .locals 4

    const-string v0, "file"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 20
    invoke-virtual {p0, p1}, Lid/eska/screenshotwebp/PathPolicy;->isInputImage(Ljava/io/File;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_0

    return-object v1

    .line 21
    :cond_0
    :try_start_0
    sget-object v0, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    move-object v0, p0

    check-cast v0, Lid/eska/screenshotwebp/PathPolicy;

    invoke-virtual {p1}, Ljava/io/File;->getCanonicalFile()Ljava/io/File;

    move-result-object p1

    invoke-static {p1}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception p1

    sget-object v0, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {p1}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object p1

    invoke-static {p1}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    :goto_0
    invoke-static {p1}, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    move-object p1, v1

    :cond_1
    check-cast p1, Ljava/io/File;

    if-nez p1, :cond_2

    return-object v1

    .line 22
    :cond_2
    invoke-direct {p0, p1}, Lid/eska/screenshotwebp/PathPolicy;->hasHiddenOrTechnicalParent(Ljava/io/File;)Z

    move-result v0

    if-eqz v0, :cond_3

    return-object v1

    .line 23
    :cond_3
    :try_start_1
    sget-object v0, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    move-object v0, p0

    check-cast v0, Lid/eska/screenshotwebp/PathPolicy;

    sget-object v0, Lid/eska/screenshotwebp/PathPolicy;->storageRoot:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->getCanonicalFile()Ljava/io/File;

    move-result-object v0

    invoke-static {v0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    :catchall_1
    move-exception v0

    sget-object v2, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {v0}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :goto_1
    invoke-static {v0}, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    move-object v0, v1

    :cond_4
    check-cast v0, Ljava/io/File;

    if-nez v0, :cond_5

    return-object v1

    .line 24
    :cond_5
    :try_start_2
    sget-object v2, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    move-object v2, p0

    check-cast v2, Lid/eska/screenshotwebp/PathPolicy;

    sget-object v2, Lid/eska/screenshotwebp/PathPolicy;->cameraRoot:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->getCanonicalFile()Ljava/io/File;

    move-result-object v2

    invoke-static {v2}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    goto :goto_2

    :catchall_2
    move-exception v2

    sget-object v3, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {v2}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    :goto_2
    invoke-static {v2}, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    move-object v2, v1

    :cond_6
    check-cast v2, Ljava/io/File;

    if-nez v2, :cond_7

    return-object v1

    .line 25
    :cond_7
    invoke-direct {p0, p1, v0}, Lid/eska/screenshotwebp/PathPolicy;->isDescendantOf(Ljava/io/File;Ljava/io/File;)Z

    move-result v0

    if-nez v0, :cond_8

    return-object v1

    .line 26
    :cond_8
    invoke-direct {p0, p1, v2}, Lid/eska/screenshotwebp/PathPolicy;->isDescendantOf(Ljava/io/File;Ljava/io/File;)Z

    move-result p0

    if-eqz p0, :cond_9

    sget-object p0, Lid/eska/screenshotwebp/MediaCategory;->PHOTOS:Lid/eska/screenshotwebp/MediaCategory;

    return-object p0

    .line 27
    :cond_9
    sget-object p0, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    return-object p0
.end method

.method public final getCameraRoot()Ljava/io/File;
    .locals 0

    .line 8
    sget-object p0, Lid/eska/screenshotwebp/PathPolicy;->cameraRoot:Ljava/io/File;

    return-object p0
.end method

.method public final getPhotoRoots()Ljava/util/List;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    .line 9
    sget-object p0, Lid/eska/screenshotwebp/PathPolicy;->photoRoots:Ljava/util/List;

    return-object p0
.end method

.method public final getScreenshotRoot()Ljava/io/File;
    .locals 0

    .line 7
    sget-object p0, Lid/eska/screenshotwebp/PathPolicy;->screenshotRoot:Ljava/io/File;

    return-object p0
.end method

.method public final getStorageRoot()Ljava/io/File;
    .locals 0

    .line 6
    sget-object p0, Lid/eska/screenshotwebp/PathPolicy;->storageRoot:Ljava/io/File;

    return-object p0
.end method

.method public final isInputImage(Ljava/io/File;)Z
    .locals 4

    const-string p0, "file"

    invoke-static {p1, p0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 17
    invoke-virtual {p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object p0

    const-string v0, "getName(...)"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x2

    const/4 v1, 0x0

    const-string v2, "."

    const/4 v3, 0x0

    invoke-static {p0, v2, v3, v0, v1}, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_0

    sget-object p0, Lid/eska/screenshotwebp/PathPolicy;->inputExtensions:Ljava/util/Set;

    invoke-static {p1}, Lkotlin/io/FilesKt;->getExtension(Ljava/io/File;)Ljava/lang/String;

    move-result-object p1

    sget-object v0, Ljava/util/Locale;->ROOT:Ljava/util/Locale;

    invoke-virtual {p1, v0}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object p1

    const-string v0, "toLowerCase(...)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-interface {p0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_0

    const/4 p0, 0x1

    return p0

    :cond_0
    return v3
.end method
