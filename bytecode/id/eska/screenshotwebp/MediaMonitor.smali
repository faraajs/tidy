.class public final Lid/eska/screenshotwebp/MediaMonitor;
.super Ljava/lang/Object;
.source "MediaMonitor.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lid/eska/screenshotwebp/MediaMonitor$Companion;,
        Lid/eska/screenshotwebp/MediaMonitor$WhenMappings;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nMediaMonitor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaMonitor.kt\nid/eska/screenshotwebp/MediaMonitor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,168:1\n1915#2,2:169\n1642#2,10:171\n1915#2:181\n1916#2:184\n1652#2:185\n1915#2:186\n1915#2:187\n1916#2:190\n1916#2:191\n1#3:182\n1#3:183\n1342#4,2:188\n1342#4,2:192\n*S KotlinDebug\n*F\n+ 1 MediaMonitor.kt\nid/eska/screenshotwebp/MediaMonitor\n*L\n33#1:169,2\n46#1:171,10\n46#1:181\n46#1:184\n46#1:185\n49#1:186\n55#1:187\n55#1:190\n49#1:191\n46#1:183\n61#1:188,2\n71#1:192,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 52\u00020\u0001:\u00015B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u001a\u0008\u0002\u0010\u0008\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c0\t\u0012 \u0008\u0002\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c0\u000e\u00a2\u0006\u0004\u0008\u0010\u0010\u0011J\u0006\u0010 \u001a\u00020\u000cJ\u0006\u0010!\u001a\u00020\u000cJ&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\n2\u0006\u0010(\u001a\u00020&J\u0008\u0010)\u001a\u00020\u000cH\u0002J\u0018\u0010*\u001a\u00020\u000c2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010\'\u001a\u00020\nH\u0002J\u0018\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010\'\u001a\u00020\nH\u0002J \u0010.\u001a\u00020\u000c2\u0006\u0010/\u001a\u00020\u000f2\u0006\u0010\'\u001a\u00020\n2\u0006\u00100\u001a\u000201H\u0002J \u00102\u001a\u00020\u000c2\u0006\u0010/\u001a\u00020\u000f2\u0006\u0010\'\u001a\u00020\n2\u0006\u00103\u001a\u000204H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0008\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u0018\u001a&\u0012\u000c\u0012\n \u0016*\u0004\u0018\u00010\u001a0\u001a \u0016*\u0012\u0012\u000c\u0012\n \u0016*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u001b0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u001c\u001a&\u0012\u000c\u0012\n \u0016*\u0004\u0018\u00010\u001a0\u001a \u0016*\u0012\u0012\u000c\u0012\n \u0016*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u001b0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00066"
    }
    d2 = {
        "Lid/eska/screenshotwebp/MediaMonitor;",
        "",
        "state",
        "Lid/eska/screenshotwebp/AppStateStore;",
        "converter",
        "Lid/eska/screenshotwebp/MediaConverter;",
        "screenshotConverter",
        "Lid/eska/screenshotwebp/ScreenshotMediaConverter;",
        "onSuccess",
        "Lkotlin/Function2;",
        "Lid/eska/screenshotwebp/MediaCategory;",
        "Lid/eska/screenshotwebp/ConversionResult;",
        "",
        "onFailure",
        "Lkotlin/Function3;",
        "Ljava/io/File;",
        "<init>",
        "(Lid/eska/screenshotwebp/AppStateStore;Lid/eska/screenshotwebp/MediaConverter;Lid/eska/screenshotwebp/ScreenshotMediaConverter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V",
        "scheduler",
        "Ljava/util/concurrent/ScheduledExecutorService;",
        "processor",
        "Ljava/util/concurrent/ExecutorService;",
        "kotlin.jvm.PlatformType",
        "screenshotProcessor",
        "seen",
        "",
        "",
        "",
        "processingPaths",
        "observers",
        "Ljava/util/concurrent/ConcurrentHashMap;",
        "Landroid/os/FileObserver;",
        "start",
        "stop",
        "accepts",
        "",
        "path",
        "modifiedEpochSeconds",
        "",
        "category",
        "activationEpochSeconds",
        "reconcile",
        "observeTree",
        "root",
        "shouldDescend",
        "directory",
        "enqueue",
        "source",
        "config",
        "Lid/eska/screenshotwebp/CategoryConfig;",
        "process",
        "requested",
        "Lid/eska/screenshotwebp/OutputFormat;",
        "Companion",
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

.field public static final Companion:Lid/eska/screenshotwebp/MediaMonitor$Companion;

.field public static final MAX_RETRIES:I = 0x1

.field public static final SCREENSHOT_WORKER_COUNT:I = 0x1

.field public static final STABILITY_DELAY_MS:J = 0x15eL

.field private static final TAG:Ljava/lang/String; = "TidyMonitor"


# instance fields
.field private final converter:Lid/eska/screenshotwebp/MediaConverter;

.field private final observers:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap<",
            "Ljava/lang/String;",
            "Landroid/os/FileObserver;",
            ">;"
        }
    .end annotation
.end field

.field private final onFailure:Lkotlin/jvm/functions/Function3;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/jvm/functions/Function3<",
            "Lid/eska/screenshotwebp/MediaCategory;",
            "Ljava/io/File;",
            "Lid/eska/screenshotwebp/ConversionResult;",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation
.end field

.field private final onSuccess:Lkotlin/jvm/functions/Function2;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/jvm/functions/Function2<",
            "Lid/eska/screenshotwebp/MediaCategory;",
            "Lid/eska/screenshotwebp/ConversionResult;",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation
.end field

.field private final processingPaths:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final processor:Ljava/util/concurrent/ExecutorService;

.field private final scheduler:Ljava/util/concurrent/ScheduledExecutorService;

.field private final screenshotConverter:Lid/eska/screenshotwebp/ScreenshotMediaConverter;

.field private final screenshotProcessor:Ljava/util/concurrent/ExecutorService;

.field private final seen:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final state:Lid/eska/screenshotwebp/AppStateStore;


# direct methods
.method public static synthetic $r8$lambda$-EYwdxQCumFxs1SHhWVnYUvoNnU(Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/ConversionResult;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1}, Lid/eska/screenshotwebp/MediaMonitor;->_init_$lambda$0(Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/ConversionResult;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$7RKyBSpAR65okx45lgAZrrG3h08(Lid/eska/screenshotwebp/MediaMonitor;)V
    .locals 0

    invoke-static {p0}, Lid/eska/screenshotwebp/MediaMonitor;->start$lambda$0(Lid/eska/screenshotwebp/MediaMonitor;)V

    return-void
.end method

.method public static synthetic $r8$lambda$HG5ELUiTKvyf-2854bnKOfsJvSM(Lid/eska/screenshotwebp/MediaMonitor;Lid/eska/screenshotwebp/MediaCategory;Ljava/io/File;)Z
    .locals 0

    invoke-static {p0, p1, p2}, Lid/eska/screenshotwebp/MediaMonitor;->reconcile$lambda$1$0$0(Lid/eska/screenshotwebp/MediaMonitor;Lid/eska/screenshotwebp/MediaCategory;Ljava/io/File;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$PD1bF0x5bR6okedTLZEaPcx5bBM(Ljava/io/File;)Z
    .locals 0

    invoke-static {p0}, Lid/eska/screenshotwebp/MediaMonitor;->observeTree$lambda$1(Ljava/io/File;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$Ups3euL4ZOsNZmxuxug-326XHuk(Lid/eska/screenshotwebp/MediaMonitor;Lid/eska/screenshotwebp/MediaCategory;Ljava/io/File;)Z
    .locals 0

    invoke-static {p0, p1, p2}, Lid/eska/screenshotwebp/MediaMonitor;->observeTree$lambda$0(Lid/eska/screenshotwebp/MediaMonitor;Lid/eska/screenshotwebp/MediaCategory;Ljava/io/File;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$YdVd1TB2rzPF2wbSYI5cYdsJedw(Lid/eska/screenshotwebp/MediaCategory;Ljava/io/File;Lid/eska/screenshotwebp/ConversionResult;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2}, Lid/eska/screenshotwebp/MediaMonitor;->_init_$lambda$1(Lid/eska/screenshotwebp/MediaCategory;Ljava/io/File;Lid/eska/screenshotwebp/ConversionResult;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$n3Fm4ODPsMml94ctuhRcYDh7eTA(Ljava/io/File;)Z
    .locals 0

    invoke-static {p0}, Lid/eska/screenshotwebp/MediaMonitor;->reconcile$lambda$1$0$1(Ljava/io/File;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$usQ1UfD2Lj4_xdcNZC6FeR0RUoc(Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/CategoryConfig;Ljava/io/File;Lid/eska/screenshotwebp/MediaMonitor;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-static/range {p0 .. p5}, Lid/eska/screenshotwebp/MediaMonitor;->enqueue$lambda$4(Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/CategoryConfig;Ljava/io/File;Lid/eska/screenshotwebp/MediaMonitor;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lid/eska/screenshotwebp/MediaMonitor$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lid/eska/screenshotwebp/MediaMonitor$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lid/eska/screenshotwebp/MediaMonitor;->Companion:Lid/eska/screenshotwebp/MediaMonitor$Companion;

    const/16 v0, 0x8

    sput v0, Lid/eska/screenshotwebp/MediaMonitor;->$stable:I

    return-void
.end method

.method public constructor <init>(Lid/eska/screenshotwebp/AppStateStore;Lid/eska/screenshotwebp/MediaConverter;Lid/eska/screenshotwebp/ScreenshotMediaConverter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lid/eska/screenshotwebp/AppStateStore;",
            "Lid/eska/screenshotwebp/MediaConverter;",
            "Lid/eska/screenshotwebp/ScreenshotMediaConverter;",
            "Lkotlin/jvm/functions/Function2<",
            "-",
            "Lid/eska/screenshotwebp/MediaCategory;",
            "-",
            "Lid/eska/screenshotwebp/ConversionResult;",
            "Lkotlin/Unit;",
            ">;",
            "Lkotlin/jvm/functions/Function3<",
            "-",
            "Lid/eska/screenshotwebp/MediaCategory;",
            "-",
            "Ljava/io/File;",
            "-",
            "Lid/eska/screenshotwebp/ConversionResult;",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    const-string v0, "state"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "converter"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "screenshotConverter"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "onSuccess"

    invoke-static {p4, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "onFailure"

    invoke-static {p5, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Lid/eska/screenshotwebp/MediaMonitor;->state:Lid/eska/screenshotwebp/AppStateStore;

    .line 15
    iput-object p2, p0, Lid/eska/screenshotwebp/MediaMonitor;->converter:Lid/eska/screenshotwebp/MediaConverter;

    .line 16
    iput-object p3, p0, Lid/eska/screenshotwebp/MediaMonitor;->screenshotConverter:Lid/eska/screenshotwebp/ScreenshotMediaConverter;

    .line 17
    iput-object p4, p0, Lid/eska/screenshotwebp/MediaMonitor;->onSuccess:Lkotlin/jvm/functions/Function2;

    .line 18
    iput-object p5, p0, Lid/eska/screenshotwebp/MediaMonitor;->onFailure:Lkotlin/jvm/functions/Function3;

    .line 20
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadScheduledExecutor()Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object p1

    const-string p2, "newSingleThreadScheduledExecutor(...)"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lid/eska/screenshotwebp/MediaMonitor;->scheduler:Ljava/util/concurrent/ScheduledExecutorService;

    const/4 p1, 0x2

    .line 21
    invoke-static {p1}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object p1

    iput-object p1, p0, Lid/eska/screenshotwebp/MediaMonitor;->processor:Ljava/util/concurrent/ExecutorService;

    .line 22
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object p1

    iput-object p1, p0, Lid/eska/screenshotwebp/MediaMonitor;->screenshotProcessor:Ljava/util/concurrent/ExecutorService;

    .line 23
    new-instance p1, Ljava/util/LinkedHashSet;

    invoke-direct {p1}, Ljava/util/LinkedHashSet;-><init>()V

    check-cast p1, Ljava/util/Set;

    invoke-static {p1}, Ljava/util/Collections;->synchronizedSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object p1

    iput-object p1, p0, Lid/eska/screenshotwebp/MediaMonitor;->seen:Ljava/util/Set;

    .line 24
    new-instance p1, Ljava/util/LinkedHashSet;

    invoke-direct {p1}, Ljava/util/LinkedHashSet;-><init>()V

    check-cast p1, Ljava/util/Set;

    invoke-static {p1}, Ljava/util/Collections;->synchronizedSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object p1

    iput-object p1, p0, Lid/eska/screenshotwebp/MediaMonitor;->processingPaths:Ljava/util/Set;

    .line 25
    new-instance p1, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {p1}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object p1, p0, Lid/eska/screenshotwebp/MediaMonitor;->observers:Ljava/util/concurrent/ConcurrentHashMap;

    return-void
.end method

.method public synthetic constructor <init>(Lid/eska/screenshotwebp/AppStateStore;Lid/eska/screenshotwebp/MediaConverter;Lid/eska/screenshotwebp/ScreenshotMediaConverter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 7

    and-int/lit8 p7, p6, 0x4

    if-eqz p7, :cond_0

    .line 16
    new-instance p3, Lid/eska/screenshotwebp/ScreenshotMediaConverter;

    const/4 p7, 0x3

    const/4 v0, 0x0

    invoke-direct {p3, v0, v0, p7, v0}, Lid/eska/screenshotwebp/ScreenshotMediaConverter;-><init>(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    :cond_0
    move-object v4, p3

    and-int/lit8 p3, p6, 0x8

    if-eqz p3, :cond_1

    .line 17
    new-instance p4, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda2;

    invoke-direct {p4}, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda2;-><init>()V

    :cond_1
    move-object v5, p4

    and-int/lit8 p3, p6, 0x10

    if-eqz p3, :cond_2

    .line 18
    new-instance p5, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda3;

    invoke-direct {p5}, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda3;-><init>()V

    :cond_2
    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v6, p5

    .line 13
    invoke-direct/range {v1 .. v6}, Lid/eska/screenshotwebp/MediaMonitor;-><init>(Lid/eska/screenshotwebp/AppStateStore;Lid/eska/screenshotwebp/MediaConverter;Lid/eska/screenshotwebp/ScreenshotMediaConverter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V

    return-void
.end method

.method private static final _init_$lambda$0(Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/ConversionResult;)Lkotlin/Unit;
    .locals 1

    const-string v0, "<unused var>"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 17
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final _init_$lambda$1(Lid/eska/screenshotwebp/MediaCategory;Ljava/io/File;Lid/eska/screenshotwebp/ConversionResult;)Lkotlin/Unit;
    .locals 1

    const-string v0, "<unused var>"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 18
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method public static final synthetic access$enqueue(Lid/eska/screenshotwebp/MediaMonitor;Ljava/io/File;Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/CategoryConfig;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1, p2, p3}, Lid/eska/screenshotwebp/MediaMonitor;->enqueue(Ljava/io/File;Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/CategoryConfig;)V

    return-void
.end method

.method public static final synthetic access$getState$p(Lid/eska/screenshotwebp/MediaMonitor;)Lid/eska/screenshotwebp/AppStateStore;
    .locals 0

    .line 13
    iget-object p0, p0, Lid/eska/screenshotwebp/MediaMonitor;->state:Lid/eska/screenshotwebp/AppStateStore;

    return-object p0
.end method

.method public static final synthetic access$reconcile(Lid/eska/screenshotwebp/MediaMonitor;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lid/eska/screenshotwebp/MediaMonitor;->reconcile()V

    return-void
.end method

.method private final enqueue(Ljava/io/File;Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/CategoryConfig;)V
    .locals 10

    .line 102
    invoke-virtual {p1}, Ljava/io/File;->isFile()Z

    move-result v0

    if-nez v0, :cond_0

    goto/16 :goto_4

    .line 103
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "getName(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v1, "."

    const/4 v2, 0x0

    const/4 v3, 0x2

    const/4 v8, 0x0

    invoke-static {v0, v1, v2, v3, v8}, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    goto/16 :goto_4

    .line 104
    :cond_1
    invoke-virtual {p1}, Ljava/io/File;->lastModified()J

    move-result-wide v0

    const/16 v2, 0x3e8

    int-to-long v2, v2

    div-long v3, v0, v2

    .line 105
    invoke-virtual {p3}, Lid/eska/screenshotwebp/CategoryConfig;->getActivationEpochSeconds()Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_a

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    move-object v1, p0

    move-object v2, p1

    move-object v5, p2

    .line 106
    invoke-virtual/range {v1 .. v7}, Lid/eska/screenshotwebp/MediaMonitor;->accepts(Ljava/io/File;JLid/eska/screenshotwebp/MediaCategory;J)Z

    move-result v0

    if-nez v0, :cond_2

    goto/16 :goto_4

    .line 107
    :cond_2
    :try_start_0
    sget-object v0, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    move-object v0, p0

    check-cast v0, Lid/eska/screenshotwebp/MediaMonitor;

    invoke-virtual {p2}, Lid/eska/screenshotwebp/MediaCategory;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Ljava/io/File;->length()J

    move-result-wide v5

    invoke-virtual {p3}, Lid/eska/screenshotwebp/CategoryConfig;->getFormat()Lid/eska/screenshotwebp/OutputFormat;

    move-result-object v7

    invoke-virtual {v7}, Lid/eska/screenshotwebp/OutputFormat;->name()Ljava/lang/String;

    move-result-object v7

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v9, ":"

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    sget-object v2, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {v0}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 108
    :goto_0
    invoke-static {v0}, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    move-object v0, v8

    :cond_3
    move-object v6, v0

    check-cast v6, Ljava/lang/String;

    if-nez v6, :cond_4

    goto/16 :goto_4

    .line 109
    :cond_4
    :try_start_1
    sget-object v0, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    move-object v0, p0

    check-cast v0, Lid/eska/screenshotwebp/MediaMonitor;

    invoke-virtual {p1}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;

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

    if-eqz v2, :cond_5

    goto :goto_2

    :cond_5
    move-object v8, v0

    :goto_2
    move-object v5, v8

    check-cast v5, Ljava/lang/String;

    if-nez v5, :cond_6

    goto :goto_4

    .line 110
    :cond_6
    iget-object v2, p0, Lid/eska/screenshotwebp/MediaMonitor;->processingPaths:Ljava/util/Set;

    const-string v0, "processingPaths"

    invoke-static {v2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    monitor-enter v2

    :try_start_2
    iget-object v0, p0, Lid/eska/screenshotwebp/MediaMonitor;->processingPaths:Ljava/util/Set;

    invoke-interface {v0, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    move-result v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_3

    if-nez v0, :cond_7

    monitor-exit v2

    return-void

    :cond_7
    :try_start_3
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    monitor-exit v2

    .line 111
    iget-object v2, p0, Lid/eska/screenshotwebp/MediaMonitor;->seen:Ljava/util/Set;

    const-string v0, "seen"

    invoke-static {v2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    monitor-enter v2

    .line 112
    :try_start_4
    iget-object v0, p0, Lid/eska/screenshotwebp/MediaMonitor;->seen:Ljava/util/Set;

    invoke-interface {v0, v6}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_8

    .line 113
    iget-object v0, p0, Lid/eska/screenshotwebp/MediaMonitor;->processingPaths:Ljava/util/Set;

    invoke-interface {v0, v5}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 111
    monitor-exit v2

    return-void

    .line 116
    :cond_8
    :try_start_5
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 111
    monitor-exit v2

    .line 117
    sget-object v0, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    if-ne p2, v0, :cond_9

    iget-object v0, p0, Lid/eska/screenshotwebp/MediaMonitor;->screenshotProcessor:Ljava/util/concurrent/ExecutorService;

    goto :goto_3

    :cond_9
    iget-object v0, p0, Lid/eska/screenshotwebp/MediaMonitor;->processor:Ljava/util/concurrent/ExecutorService;

    :goto_3
    move-object v7, v0

    .line 118
    new-instance v0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda4;

    move-object v4, p0

    move-object v3, p1

    move-object v1, p2

    move-object v2, p3

    invoke-direct/range {v0 .. v6}, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda4;-><init>(Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/CategoryConfig;Ljava/io/File;Lid/eska/screenshotwebp/MediaMonitor;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v7, v0}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    return-void

    :catchall_2
    move-exception v0

    .line 111
    monitor-exit v2

    throw v0

    :catchall_3
    move-exception v0

    .line 110
    monitor-exit v2

    throw v0

    :cond_a
    :goto_4
    return-void
.end method

.method private static final enqueue$lambda$4(Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/CategoryConfig;Ljava/io/File;Lid/eska/screenshotwebp/MediaMonitor;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    const-string v0, "queued "

    .line 120
    :try_start_0
    const-string v1, "TidyMonitor"

    invoke-virtual {p0}, Lid/eska/screenshotwebp/MediaCategory;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lid/eska/screenshotwebp/CategoryConfig;->getFormat()Lid/eska/screenshotwebp/OutputFormat;

    move-result-object v3

    invoke-virtual {v3}, Lid/eska/screenshotwebp/OutputFormat;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ": "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 121
    invoke-virtual {p1}, Lid/eska/screenshotwebp/CategoryConfig;->getFormat()Lid/eska/screenshotwebp/OutputFormat;

    move-result-object p1

    invoke-direct {p3, p2, p0, p1}, Lid/eska/screenshotwebp/MediaMonitor;->process(Ljava/io/File;Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/OutputFormat;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 123
    iget-object p0, p3, Lid/eska/screenshotwebp/MediaMonitor;->processingPaths:Ljava/util/Set;

    invoke-interface {p0, p4}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 124
    iget-object p0, p3, Lid/eska/screenshotwebp/MediaMonitor;->seen:Ljava/util/Set;

    invoke-interface {p0, p5}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    return-void

    :catchall_0
    move-exception p0

    .line 123
    iget-object p1, p3, Lid/eska/screenshotwebp/MediaMonitor;->processingPaths:Ljava/util/Set;

    invoke-interface {p1, p4}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 124
    iget-object p1, p3, Lid/eska/screenshotwebp/MediaMonitor;->seen:Ljava/util/Set;

    invoke-interface {p1, p5}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    throw p0
.end method

.method private final observeTree(Ljava/io/File;Lid/eska/screenshotwebp/MediaCategory;)V
    .locals 3

    .line 67
    invoke-virtual {p1}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-nez v0, :cond_0

    goto :goto_1

    .line 68
    :cond_0
    invoke-static {p1}, Lkotlin/io/FilesKt;->walkTopDown(Ljava/io/File;)Lkotlin/io/FileTreeWalk;

    move-result-object p1

    .line 69
    new-instance v0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda6;

    invoke-direct {v0, p0, p2}, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda6;-><init>(Lid/eska/screenshotwebp/MediaMonitor;Lid/eska/screenshotwebp/MediaCategory;)V

    invoke-virtual {p1, v0}, Lkotlin/io/FileTreeWalk;->onEnter(Lkotlin/jvm/functions/Function1;)Lkotlin/io/FileTreeWalk;

    move-result-object p1

    check-cast p1, Lkotlin/sequences/Sequence;

    new-instance v0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda7;

    invoke-direct {v0}, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda7;-><init>()V

    .line 70
    invoke-static {p1, v0}, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;

    move-result-object p1

    .line 192
    invoke-interface {p1}, Lkotlin/sequences/Sequence;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_1
    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/io/File;

    .line 72
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    .line 73
    iget-object v2, p0, Lid/eska/screenshotwebp/MediaMonitor;->observers:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v2, v1}, Ljava/util/concurrent/ConcurrentHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 74
    new-instance v2, Lid/eska/screenshotwebp/MediaMonitor$observeTree$3$observer$1;

    invoke-direct {v2, v0, p0, p2}, Lid/eska/screenshotwebp/MediaMonitor$observeTree$3$observer$1;-><init>(Ljava/io/File;Lid/eska/screenshotwebp/MediaMonitor;Lid/eska/screenshotwebp/MediaCategory;)V

    .line 86
    iget-object v0, p0, Lid/eska/screenshotwebp/MediaMonitor;->observers:Ljava/util/concurrent/ConcurrentHashMap;

    check-cast v0, Ljava/util/Map;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 87
    invoke-virtual {v2}, Lid/eska/screenshotwebp/MediaMonitor$observeTree$3$observer$1;->startWatching()V

    goto :goto_0

    :cond_2
    :goto_1
    return-void
.end method

.method private static final observeTree$lambda$0(Lid/eska/screenshotwebp/MediaMonitor;Lid/eska/screenshotwebp/MediaCategory;Ljava/io/File;)Z
    .locals 1

    const-string v0, "directory"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 69
    invoke-direct {p0, p2, p1}, Lid/eska/screenshotwebp/MediaMonitor;->shouldDescend(Ljava/io/File;Lid/eska/screenshotwebp/MediaCategory;)Z

    move-result p0

    return p0
.end method

.method private static final observeTree$lambda$1(Ljava/io/File;)Z
    .locals 1

    const-string v0, "it"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 70
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result p0

    return p0
.end method

.method private final process(Ljava/io/File;Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/OutputFormat;)V
    .locals 26

    move-object/from16 v1, p0

    move-object/from16 v3, p2

    .line 130
    new-instance v4, Lkotlin/jvm/internal/Ref$ObjectRef;

    invoke-direct {v4}, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V

    move-object v5, v4

    new-instance v4, Lid/eska/screenshotwebp/ConversionResult;

    move-object v6, v5

    .line 131
    sget-object v5, Lid/eska/screenshotwebp/ConversionResult$Status;->FAILED:Lid/eska/screenshotwebp/ConversionResult$Status;

    move-object v8, v6

    .line 132
    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->length()J

    move-result-wide v6

    .line 133
    sget-object v0, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    if-ne v3, v0, :cond_0

    const-wide/32 v9, 0x19000

    goto :goto_0

    :cond_0
    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->length()J

    move-result-wide v9

    invoke-static {v9, v10}, Lid/eska/screenshotwebp/TargetPolicyKt;->targetBucket(J)Lid/eska/screenshotwebp/TargetBucket;

    move-result-object v0

    invoke-virtual {v0}, Lid/eska/screenshotwebp/TargetBucket;->getMaxBytes()J

    move-result-wide v9

    :goto_0
    move-wide v10, v9

    const/16 v21, 0x19f4

    const/16 v22, 0x0

    move-object v12, v8

    const-wide/16 v8, 0x0

    move-object v13, v12

    const/4 v12, 0x0

    move-object v14, v13

    const/4 v13, 0x0

    move-object v15, v14

    const/4 v14, 0x0

    move-object/from16 v16, v15

    const/4 v15, 0x0

    move-object/from16 v17, v16

    const/16 v16, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    move-object/from16 v18, p3

    move-object/from16 v2, v17

    move-object/from16 v17, p3

    .line 130
    invoke-direct/range {v4 .. v22}, Lid/eska/screenshotwebp/ConversionResult;-><init>(Lid/eska/screenshotwebp/ConversionResult$Status;JJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/OutputFormat;Lid/eska/screenshotwebp/OutputFormat;ZZILkotlin/jvm/internal/DefaultConstructorMarker;)V

    move-object v0, v4

    move-object/from16 v4, v17

    iput-object v0, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    .line 138
    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_1

    return-void

    .line 139
    :cond_1
    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->length()J

    move-result-wide v5

    .line 140
    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->lastModified()J

    move-result-wide v7

    const-wide/16 v9, 0x15e

    .line 141
    invoke-static {v9, v10}, Ljava/lang/Thread;->sleep(J)V

    .line 142
    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->length()J

    move-result-wide v9

    cmp-long v0, v5, v9

    if-nez v0, :cond_6

    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->lastModified()J

    move-result-wide v5

    cmp-long v0, v7, v5

    if-eqz v0, :cond_2

    goto/16 :goto_5

    .line 143
    :cond_2
    :try_start_0
    sget-object v0, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    move-object v0, v1

    check-cast v0, Lid/eska/screenshotwebp/MediaMonitor;

    .line 144
    sget-object v0, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    if-ne v3, v0, :cond_3

    iget-object v0, v1, Lid/eska/screenshotwebp/MediaMonitor;->screenshotConverter:Lid/eska/screenshotwebp/ScreenshotMediaConverter;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-object/from16 v5, p1

    :try_start_1
    invoke-virtual {v0, v5, v4}, Lid/eska/screenshotwebp/ScreenshotMediaConverter;->convert(Ljava/io/File;Lid/eska/screenshotwebp/OutputFormat;)Lid/eska/screenshotwebp/ConversionResult;

    move-result-object v0

    goto :goto_1

    :cond_3
    move-object/from16 v5, p1

    .line 145
    iget-object v0, v1, Lid/eska/screenshotwebp/MediaMonitor;->converter:Lid/eska/screenshotwebp/MediaConverter;

    invoke-virtual {v0, v5, v4}, Lid/eska/screenshotwebp/MediaConverter;->convert(Ljava/io/File;Lid/eska/screenshotwebp/OutputFormat;)Lid/eska/screenshotwebp/ConversionResult;

    move-result-object v0

    .line 143
    :goto_1
    invoke-static {v0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_3

    :catchall_0
    move-exception v0

    goto :goto_2

    :catchall_1
    move-exception v0

    move-object/from16 v5, p1

    :goto_2
    sget-object v6, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {v0}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 146
    :goto_3
    invoke-static {v0}, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v6

    if-nez v6, :cond_4

    goto :goto_4

    .line 147
    :cond_4
    iget-object v0, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    move-object v7, v0

    check-cast v7, Lid/eska/screenshotwebp/ConversionResult;

    invoke-virtual {v6}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_5

    invoke-virtual {v6}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    :cond_5
    move-object/from16 v19, v0

    const/16 v24, 0x1eff

    const/16 v25, 0x0

    const/4 v8, 0x0

    const-wide/16 v9, 0x0

    const-wide/16 v11, 0x0

    const-wide/16 v13, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v20, 0x0

    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v23, 0x0

    invoke-static/range {v7 .. v25}, Lid/eska/screenshotwebp/ConversionResult;->copy$default(Lid/eska/screenshotwebp/ConversionResult;Lid/eska/screenshotwebp/ConversionResult$Status;JJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/OutputFormat;Lid/eska/screenshotwebp/OutputFormat;ZZILjava/lang/Object;)Lid/eska/screenshotwebp/ConversionResult;

    move-result-object v0

    .line 143
    :goto_4
    iput-object v0, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    .line 149
    iget-object v0, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    check-cast v0, Lid/eska/screenshotwebp/ConversionResult;

    invoke-virtual {v0}, Lid/eska/screenshotwebp/ConversionResult;->getStatus()Lid/eska/screenshotwebp/ConversionResult$Status;

    move-result-object v0

    sget-object v6, Lid/eska/screenshotwebp/ConversionResult$Status;->SUCCESS:Lid/eska/screenshotwebp/ConversionResult$Status;

    if-ne v0, v6, :cond_7

    .line 150
    iget-object v0, v1, Lid/eska/screenshotwebp/MediaMonitor;->onSuccess:Lkotlin/jvm/functions/Function2;

    iget-object v1, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    invoke-interface {v0, v3, v1}, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void

    :cond_6
    :goto_5
    move-object/from16 v5, p1

    .line 154
    :cond_7
    invoke-virtual {v3}, Lid/eska/screenshotwebp/MediaCategory;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4}, Lid/eska/screenshotwebp/OutputFormat;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v6

    iget-object v7, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    check-cast v7, Lid/eska/screenshotwebp/ConversionResult;

    invoke-virtual {v7}, Lid/eska/screenshotwebp/ConversionResult;->getMessage()Ljava/lang/String;

    move-result-object v7

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "failed "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v8, " "

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ": "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v4, "TidyMonitor"

    invoke-static {v4, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 155
    iget-object v0, v1, Lid/eska/screenshotwebp/MediaMonitor;->onFailure:Lkotlin/jvm/functions/Function3;

    iget-object v1, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    invoke-interface {v0, v3, v5, v1}, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method private final reconcile()V
    .locals 6

    .line 46
    invoke-static {}, Lid/eska/screenshotwebp/MediaCategory;->getEntries()Lkotlin/enums/EnumEntries;

    move-result-object v0

    check-cast v0, Ljava/lang/Iterable;

    .line 171
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    check-cast v1, Ljava/util/Collection;

    .line 181
    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .line 180
    check-cast v2, Lid/eska/screenshotwebp/MediaCategory;

    .line 47
    iget-object v3, p0, Lid/eska/screenshotwebp/MediaMonitor;->state:Lid/eska/screenshotwebp/AppStateStore;

    invoke-virtual {v3, v2}, Lid/eska/screenshotwebp/AppStateStore;->categoryConfig(Lid/eska/screenshotwebp/MediaCategory;)Lid/eska/screenshotwebp/CategoryConfig;

    move-result-object v3

    invoke-virtual {v3}, Lid/eska/screenshotwebp/CategoryConfig;->getActive()Z

    move-result v4

    const/4 v5, 0x0

    if-eqz v4, :cond_1

    goto :goto_1

    :cond_1
    move-object v3, v5

    :goto_1
    if-eqz v3, :cond_2

    invoke-static {v2, v3}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v5

    :cond_2
    if-eqz v5, :cond_0

    .line 180
    invoke-interface {v1, v5}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 185
    :cond_3
    check-cast v1, Ljava/util/List;

    .line 49
    check-cast v1, Ljava/lang/Iterable;

    .line 186
    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_4
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_9

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lkotlin/Pair;

    invoke-virtual {v1}, Lkotlin/Pair;->component1()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lid/eska/screenshotwebp/MediaCategory;

    invoke-virtual {v1}, Lkotlin/Pair;->component2()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lid/eska/screenshotwebp/CategoryConfig;

    .line 50
    sget-object v3, Lid/eska/screenshotwebp/MediaMonitor$WhenMappings;->$EnumSwitchMapping$0:[I

    invoke-virtual {v2}, Lid/eska/screenshotwebp/MediaCategory;->ordinal()I

    move-result v4

    aget v3, v3, v4

    const/4 v4, 0x1

    if-eq v3, v4, :cond_6

    const/4 v4, 0x2

    if-ne v3, v4, :cond_5

    .line 52
    sget-object v3, Lid/eska/screenshotwebp/PathPolicy;->INSTANCE:Lid/eska/screenshotwebp/PathPolicy;

    invoke-virtual {v3}, Lid/eska/screenshotwebp/PathPolicy;->getPhotoRoots()Ljava/util/List;

    move-result-object v3

    goto :goto_2

    .line 50
    :cond_5
    new-instance p0, Lkotlin/NoWhenBranchMatchedException;

    invoke-direct {p0}, Lkotlin/NoWhenBranchMatchedException;-><init>()V

    throw p0

    .line 51
    :cond_6
    sget-object v3, Lid/eska/screenshotwebp/PathPolicy;->INSTANCE:Lid/eska/screenshotwebp/PathPolicy;

    invoke-virtual {v3}, Lid/eska/screenshotwebp/PathPolicy;->getScreenshotRoot()Ljava/io/File;

    move-result-object v3

    invoke-static {v3}, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    .line 54
    :goto_2
    sget-object v4, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    if-ne v2, v4, :cond_7

    sget-object v3, Lid/eska/screenshotwebp/PathPolicy;->INSTANCE:Lid/eska/screenshotwebp/PathPolicy;

    invoke-virtual {v3}, Lid/eska/screenshotwebp/PathPolicy;->getStorageRoot()Ljava/io/File;

    move-result-object v3

    invoke-static {v3}, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    .line 55
    :cond_7
    check-cast v3, Ljava/lang/Iterable;

    .line 187
    invoke-interface {v3}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_8
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/io/File;

    .line 56
    invoke-virtual {v4}, Ljava/io/File;->mkdirs()Z

    .line 57
    invoke-direct {p0, v4, v2}, Lid/eska/screenshotwebp/MediaMonitor;->observeTree(Ljava/io/File;Lid/eska/screenshotwebp/MediaCategory;)V

    .line 58
    invoke-static {v4}, Lkotlin/io/FilesKt;->walkTopDown(Ljava/io/File;)Lkotlin/io/FileTreeWalk;

    move-result-object v4

    .line 59
    new-instance v5, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda0;

    invoke-direct {v5, p0, v2}, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda0;-><init>(Lid/eska/screenshotwebp/MediaMonitor;Lid/eska/screenshotwebp/MediaCategory;)V

    invoke-virtual {v4, v5}, Lkotlin/io/FileTreeWalk;->onEnter(Lkotlin/jvm/functions/Function1;)Lkotlin/io/FileTreeWalk;

    move-result-object v4

    check-cast v4, Lkotlin/sequences/Sequence;

    new-instance v5, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda1;

    invoke-direct {v5}, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda1;-><init>()V

    .line 60
    invoke-static {v4, v5}, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;

    move-result-object v4

    .line 188
    invoke-interface {v4}, Lkotlin/sequences/Sequence;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_3
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_8

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/io/File;

    .line 61
    invoke-direct {p0, v5, v2, v1}, Lid/eska/screenshotwebp/MediaMonitor;->enqueue(Ljava/io/File;Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/CategoryConfig;)V

    goto :goto_3

    :cond_9
    return-void
.end method

.method private static final reconcile$lambda$1$0$0(Lid/eska/screenshotwebp/MediaMonitor;Lid/eska/screenshotwebp/MediaCategory;Ljava/io/File;)Z
    .locals 1

    const-string v0, "directory"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 59
    invoke-direct {p0, p2, p1}, Lid/eska/screenshotwebp/MediaMonitor;->shouldDescend(Ljava/io/File;Lid/eska/screenshotwebp/MediaCategory;)Z

    move-result p0

    return p0
.end method

.method private static final reconcile$lambda$1$0$1(Ljava/io/File;)Z
    .locals 1

    const-string v0, "it"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 60
    invoke-virtual {p0}, Ljava/io/File;->isFile()Z

    move-result p0

    return p0
.end method

.method private final shouldDescend(Ljava/io/File;Lid/eska/screenshotwebp/MediaCategory;)Z
    .locals 7

    .line 92
    invoke-virtual {p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object p0

    .line 93
    invoke-static {p0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    const-string v0, "."

    const/4 v1, 0x0

    const/4 v2, 0x2

    const/4 v3, 0x0

    invoke-static {p0, v0, v1, v2, v3}, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    return v1

    :cond_0
    const/4 v0, 0x4

    .line 94
    new-array v0, v0, [Ljava/lang/String;

    const-string v4, "android"

    aput-object v4, v0, v1

    const-string v4, "thumbnails"

    const/4 v5, 0x1

    aput-object v4, v0, v5

    const-string v4, "cache"

    aput-object v4, v0, v2

    const/4 v4, 0x3

    const-string v6, "caches"

    aput-object v6, v0, v4

    invoke-static {v0}, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;

    move-result-object v0

    sget-object v4, Ljava/util/Locale;->ROOT:Ljava/util/Locale;

    invoke-virtual {p0, v4}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object p0

    const-string v4, "toLowerCase(...)"

    invoke-static {p0, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-interface {v0, p0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_1

    return v1

    .line 95
    :cond_1
    invoke-virtual {p1}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;

    move-result-object p0

    .line 96
    sget-object p1, Lid/eska/screenshotwebp/PathPolicy;->INSTANCE:Lid/eska/screenshotwebp/PathPolicy;

    invoke-virtual {p1}, Lid/eska/screenshotwebp/PathPolicy;->getCameraRoot()Ljava/io/File;

    move-result-object p1

    invoke-virtual {p1}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;

    move-result-object p1

    .line 97
    sget-object v0, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    if-ne p2, v0, :cond_3

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p2

    if-nez p2, :cond_2

    invoke-static {p0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    sget-object p2, Ljava/io/File;->separator:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p0, p1, v1, v2, v3}, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_3

    :cond_2
    return v1

    :cond_3
    return v5
.end method

.method private static final start$lambda$0(Lid/eska/screenshotwebp/MediaMonitor;)V
    .locals 0

    .line 29
    invoke-direct {p0}, Lid/eska/screenshotwebp/MediaMonitor;->reconcile()V

    return-void
.end method


# virtual methods
.method public final accepts(Ljava/io/File;JLid/eska/screenshotwebp/MediaCategory;J)Z
    .locals 0

    const-string p0, "path"

    invoke-static {p1, p0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p0, "category"

    invoke-static {p4, p0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 41
    sget-object p0, Lid/eska/screenshotwebp/PathPolicy;->INSTANCE:Lid/eska/screenshotwebp/PathPolicy;

    invoke-virtual {p0, p1}, Lid/eska/screenshotwebp/PathPolicy;->categoryFor(Ljava/io/File;)Lid/eska/screenshotwebp/MediaCategory;

    move-result-object p0

    if-ne p0, p4, :cond_1

    .line 42
    sget-object p0, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    if-eq p4, p0, :cond_0

    cmp-long p0, p2, p5

    if-lez p0, :cond_1

    :cond_0
    const/4 p0, 0x1

    return p0

    :cond_1
    const/4 p0, 0x0

    return p0
.end method

.method public final start()V
    .locals 7

    .line 28
    invoke-direct {p0}, Lid/eska/screenshotwebp/MediaMonitor;->reconcile()V

    .line 29
    iget-object v0, p0, Lid/eska/screenshotwebp/MediaMonitor;->scheduler:Ljava/util/concurrent/ScheduledExecutorService;

    new-instance v1, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda5;

    invoke-direct {v1, p0}, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda5;-><init>(Lid/eska/screenshotwebp/MediaMonitor;)V

    const-wide/16 v4, 0x14

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v2, 0x5

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleWithFixedDelay(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    return-void
.end method

.method public final stop()V
    .locals 2

    .line 33
    iget-object v0, p0, Lid/eska/screenshotwebp/MediaMonitor;->observers:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v0}, Ljava/util/concurrent/ConcurrentHashMap;->values()Ljava/util/Collection;

    move-result-object v0

    const-string v1, "<get-values>(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Ljava/lang/Iterable;

    .line 169
    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/FileObserver;

    .line 33
    invoke-virtual {v1}, Landroid/os/FileObserver;->stopWatching()V

    goto :goto_0

    .line 34
    :cond_0
    iget-object v0, p0, Lid/eska/screenshotwebp/MediaMonitor;->observers:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v0}, Ljava/util/concurrent/ConcurrentHashMap;->clear()V

    .line 35
    iget-object v0, p0, Lid/eska/screenshotwebp/MediaMonitor;->scheduler:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ScheduledExecutorService;->shutdownNow()Ljava/util/List;

    .line 36
    iget-object v0, p0, Lid/eska/screenshotwebp/MediaMonitor;->processor:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ExecutorService;->shutdownNow()Ljava/util/List;

    .line 37
    iget-object p0, p0, Lid/eska/screenshotwebp/MediaMonitor;->screenshotProcessor:Ljava/util/concurrent/ExecutorService;

    invoke-interface {p0}, Ljava/util/concurrent/ExecutorService;->shutdownNow()Ljava/util/List;

    return-void
.end method
