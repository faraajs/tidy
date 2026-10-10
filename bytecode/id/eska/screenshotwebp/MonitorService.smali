.class public final Lid/eska/screenshotwebp/MonitorService;
.super Landroid/app/Service;
.source "MonitorService.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lid/eska/screenshotwebp/MonitorService$Companion;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nMonitorService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MonitorService.kt\nid/eska/screenshotwebp/MonitorService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,107:1\n1#2:108\n37#3,2:109\n*S KotlinDebug\n*F\n+ 1 MonitorService.kt\nid/eska/screenshotwebp/MonitorService\n*L\n40#1:109,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\u0008\u0002\u0010\u0003J\u0008\u0010\u0008\u001a\u00020\tH\u0016J\"\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0008\u0010\u0010\u001a\u00020\tH\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0016J\u0008\u0010\u0013\u001a\u00020\tH\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"
    }
    d2 = {
        "Lid/eska/screenshotwebp/MonitorService;",
        "Landroid/app/Service;",
        "<init>",
        "()V",
        "state",
        "Lid/eska/screenshotwebp/AppStateStore;",
        "monitor",
        "Lid/eska/screenshotwebp/MediaMonitor;",
        "onCreate",
        "",
        "onStartCommand",
        "",
        "intent",
        "Landroid/content/Intent;",
        "flags",
        "startId",
        "onDestroy",
        "onBind",
        "Landroid/os/IBinder;",
        "createNotificationChannel",
        "notification",
        "Landroid/app/Notification;",
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

.field public static final CHANNEL_ID:Ljava/lang/String; = "screenshot_monitor"

.field public static final Companion:Lid/eska/screenshotwebp/MonitorService$Companion;

.field public static final NOTIFICATION_ID:I = 0xfa1


# instance fields
.field private monitor:Lid/eska/screenshotwebp/MediaMonitor;

.field private state:Lid/eska/screenshotwebp/AppStateStore;


# direct methods
.method public static synthetic $r8$lambda$D8U6RdN01E2m-J8g6urxbxFZSiU(Lid/eska/screenshotwebp/MonitorService;Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/ConversionResult;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2}, Lid/eska/screenshotwebp/MonitorService;->onStartCommand$lambda$0(Lid/eska/screenshotwebp/MonitorService;Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/ConversionResult;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$sN_AibUZ_pgai1A7p0IRSqw3OSA(Lid/eska/screenshotwebp/MonitorService;Lid/eska/screenshotwebp/MediaCategory;Ljava/io/File;Lid/eska/screenshotwebp/ConversionResult;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2, p3}, Lid/eska/screenshotwebp/MonitorService;->onStartCommand$lambda$1(Lid/eska/screenshotwebp/MonitorService;Lid/eska/screenshotwebp/MediaCategory;Ljava/io/File;Lid/eska/screenshotwebp/ConversionResult;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lid/eska/screenshotwebp/MonitorService$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lid/eska/screenshotwebp/MonitorService$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lid/eska/screenshotwebp/MonitorService;->Companion:Lid/eska/screenshotwebp/MonitorService$Companion;

    const/16 v0, 0x8

    sput v0, Lid/eska/screenshotwebp/MonitorService;->$stable:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 17
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    return-void
.end method

.method private final createNotificationChannel()V
    .locals 4

    .line 65
    const-class v0, Landroid/app/NotificationManager;

    invoke-virtual {p0, v0}, Lid/eska/screenshotwebp/MonitorService;->getSystemService(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 66
    new-instance v1, Landroid/app/NotificationChannel;

    sget v2, Lid/eska/screenshotwebp/R$string;->notification_channel_name:I

    invoke-virtual {p0, v2}, Lid/eska/screenshotwebp/MonitorService;->getString(I)Ljava/lang/String;

    move-result-object p0

    check-cast p0, Ljava/lang/CharSequence;

    const/4 v2, 0x2

    const-string v3, "screenshot_monitor"

    invoke-direct {v1, v3, p0, v2}, Landroid/app/NotificationChannel;-><init>(Ljava/lang/String;Ljava/lang/CharSequence;I)V

    const/4 p0, 0x0

    .line 67
    invoke-virtual {v1, p0, p0}, Landroid/app/NotificationChannel;->setSound(Landroid/net/Uri;Landroid/media/AudioAttributes;)V

    const/4 p0, 0x0

    .line 68
    invoke-virtual {v1, p0}, Landroid/app/NotificationChannel;->enableVibration(Z)V

    .line 69
    invoke-virtual {v1, p0}, Landroid/app/NotificationChannel;->enableLights(Z)V

    .line 65
    invoke-virtual {v0, v1}, Landroid/app/NotificationManager;->createNotificationChannel(Landroid/app/NotificationChannel;)V

    return-void
.end method

.method private final notification()Landroid/app/Notification;
    .locals 6

    .line 76
    iget-object v0, p0, Lid/eska/screenshotwebp/MonitorService;->state:Lid/eska/screenshotwebp/AppStateStore;

    if-nez v0, :cond_0

    const-string v0, "state"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    :cond_0
    invoke-virtual {v0}, Lid/eska/screenshotwebp/AppStateStore;->snapshot()Lid/eska/screenshotwebp/AppState;

    move-result-object v0

    .line 77
    invoke-virtual {v0}, Lid/eska/screenshotwebp/AppState;->getProcessedCount()I

    move-result v1

    invoke-virtual {v0}, Lid/eska/screenshotwebp/AppState;->getSavedBytes()J

    move-result-wide v2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " berhasil, hemat "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " byte"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 79
    move-object v1, p0

    check-cast v1, Landroid/content/Context;

    .line 81
    new-instance v2, Landroid/content/Intent;

    const-class v3, Lid/eska/screenshotwebp/MainActivity;

    invoke-direct {v2, v1, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const/high16 v3, 0xc000000

    const/4 v4, 0x0

    .line 78
    invoke-static {v1, v4, v2, v3}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v2

    .line 84
    new-instance v3, Landroid/app/Notification$Builder;

    const-string v5, "screenshot_monitor"

    invoke-direct {v3, v1, v5}, Landroid/app/Notification$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    const v1, 0x108004e

    .line 85
    invoke-virtual {v3, v1}, Landroid/app/Notification$Builder;->setSmallIcon(I)Landroid/app/Notification$Builder;

    move-result-object v1

    .line 86
    sget v3, Lid/eska/screenshotwebp/R$string;->notification_active:I

    invoke-virtual {p0, v3}, Lid/eska/screenshotwebp/MonitorService;->getString(I)Ljava/lang/String;

    move-result-object p0

    check-cast p0, Ljava/lang/CharSequence;

    invoke-virtual {v1, p0}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object p0

    .line 87
    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {p0, v0}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object p0

    .line 88
    invoke-virtual {p0, v2}, Landroid/app/Notification$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object p0

    const/4 v0, 0x1

    .line 89
    invoke-virtual {p0, v0}, Landroid/app/Notification$Builder;->setOngoing(Z)Landroid/app/Notification$Builder;

    move-result-object p0

    .line 90
    invoke-virtual {p0, v4}, Landroid/app/Notification$Builder;->setDefaults(I)Landroid/app/Notification$Builder;

    move-result-object p0

    const v0, -0xffff01

    .line 91
    invoke-virtual {p0, v0}, Landroid/app/Notification$Builder;->setColor(I)Landroid/app/Notification$Builder;

    move-result-object p0

    .line 92
    invoke-virtual {p0}, Landroid/app/Notification$Builder;->build()Landroid/app/Notification;

    move-result-object p0

    const-string v0, "build(...)"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object p0
.end method

.method private static final onStartCommand$lambda$0(Lid/eska/screenshotwebp/MonitorService;Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/ConversionResult;)Lkotlin/Unit;
    .locals 11

    const-string v0, "category"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "result"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 39
    iget-object v0, p0, Lid/eska/screenshotwebp/MonitorService;->state:Lid/eska/screenshotwebp/AppStateStore;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    const-string v0, "state"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v1

    goto :goto_0

    :cond_0
    move-object v2, v0

    :goto_0
    invoke-virtual {p2}, Lid/eska/screenshotwebp/ConversionResult;->getSourceBytes()J

    move-result-wide v4

    invoke-virtual {p2}, Lid/eska/screenshotwebp/ConversionResult;->getOutputBytes()J

    move-result-wide v6

    invoke-virtual {p2}, Lid/eska/screenshotwebp/ConversionResult;->getActualFormat()Lid/eska/screenshotwebp/OutputFormat;

    move-result-object v8

    invoke-virtual {p2}, Lid/eska/screenshotwebp/ConversionResult;->getUsedFallback()Z

    move-result v9

    invoke-virtual {p2}, Lid/eska/screenshotwebp/ConversionResult;->getTargetMet()Z

    move-result v10

    move-object v3, p1

    invoke-virtual/range {v2 .. v10}, Lid/eska/screenshotwebp/AppStateStore;->recordSuccess(Lid/eska/screenshotwebp/MediaCategory;JJLid/eska/screenshotwebp/OutputFormat;ZZ)V

    const/4 p1, 0x2

    .line 40
    new-array p1, p1, [Ljava/lang/String;

    invoke-virtual {p2}, Lid/eska/screenshotwebp/ConversionResult;->getDestinationPath()Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x0

    aput-object v0, p1, v2

    invoke-virtual {p2}, Lid/eska/screenshotwebp/ConversionResult;->getSourcePath()Ljava/lang/String;

    move-result-object p2

    const/4 v0, 0x1

    aput-object p2, p1, v0

    invoke-static {p1}, Lkotlin/collections/CollectionsKt;->listOfNotNull([Ljava/lang/Object;)Ljava/util/List;

    move-result-object p1

    check-cast p1, Ljava/util/Collection;

    .line 110
    new-array p2, v2, [Ljava/lang/String;

    invoke-interface {p1, p2}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p1

    .line 40
    check-cast p1, [Ljava/lang/String;

    .line 41
    array-length p2, p1

    if-nez p2, :cond_1

    move v2, v0

    :cond_1
    if-nez v2, :cond_2

    .line 42
    move-object p2, p0

    check-cast p2, Landroid/content/Context;

    invoke-static {p2, p1, v1, v1}, Landroid/media/MediaScannerConnection;->scanFile(Landroid/content/Context;[Ljava/lang/String;[Ljava/lang/String;Landroid/media/MediaScannerConnection$OnScanCompletedListener;)V

    .line 44
    :cond_2
    const-class p1, Landroid/app/NotificationManager;

    invoke-virtual {p0, p1}, Lid/eska/screenshotwebp/MonitorService;->getSystemService(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/app/NotificationManager;

    const/16 p2, 0xfa1

    invoke-direct {p0}, Lid/eska/screenshotwebp/MonitorService;->notification()Landroid/app/Notification;

    move-result-object p0

    invoke-virtual {p1, p2, p0}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 45
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final onStartCommand$lambda$1(Lid/eska/screenshotwebp/MonitorService;Lid/eska/screenshotwebp/MediaCategory;Ljava/io/File;Lid/eska/screenshotwebp/ConversionResult;)Lkotlin/Unit;
    .locals 2

    const-string v0, "category"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "source"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "result"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 47
    iget-object v0, p0, Lid/eska/screenshotwebp/MonitorService;->state:Lid/eska/screenshotwebp/AppStateStore;

    if-nez v0, :cond_0

    const-string v0, "state"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    :cond_0
    invoke-virtual {p2}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object p2

    const-string v1, "getPath(...)"

    invoke-static {p2, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p3}, Lid/eska/screenshotwebp/ConversionResult;->getMessage()Ljava/lang/String;

    move-result-object p3

    if-nez p3, :cond_1

    const-string p3, "Konversi gagal"

    :cond_1
    invoke-virtual {v0, p1, p2, p3}, Lid/eska/screenshotwebp/AppStateStore;->recordFailure(Lid/eska/screenshotwebp/MediaCategory;Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    const-class p1, Landroid/app/NotificationManager;

    invoke-virtual {p0, p1}, Lid/eska/screenshotwebp/MonitorService;->getSystemService(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/app/NotificationManager;

    const/16 p2, 0xfa1

    invoke-direct {p0}, Lid/eska/screenshotwebp/MonitorService;->notification()Landroid/app/Notification;

    move-result-object p0

    invoke-virtual {p1, p2, p0}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 49
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 0

    const/4 p0, 0x0

    return-object p0
.end method

.method public onCreate()V
    .locals 2

    .line 22
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 23
    new-instance v0, Lid/eska/screenshotwebp/AppStateStore;

    move-object v1, p0

    check-cast v1, Landroid/content/Context;

    invoke-direct {v0, v1}, Lid/eska/screenshotwebp/AppStateStore;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lid/eska/screenshotwebp/MonitorService;->state:Lid/eska/screenshotwebp/AppStateStore;

    .line 24
    invoke-direct {p0}, Lid/eska/screenshotwebp/MonitorService;->createNotificationChannel()V

    const/16 v0, 0xfa1

    .line 25
    invoke-direct {p0}, Lid/eska/screenshotwebp/MonitorService;->notification()Landroid/app/Notification;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lid/eska/screenshotwebp/MonitorService;->startForeground(ILandroid/app/Notification;)V

    return-void
.end method

.method public onDestroy()V
    .locals 1

    .line 56
    iget-object v0, p0, Lid/eska/screenshotwebp/MonitorService;->monitor:Lid/eska/screenshotwebp/MediaMonitor;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lid/eska/screenshotwebp/MediaMonitor;->stop()V

    :cond_0
    const/4 v0, 0x0

    .line 57
    iput-object v0, p0, Lid/eska/screenshotwebp/MonitorService;->monitor:Lid/eska/screenshotwebp/MediaMonitor;

    .line 58
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 6

    .line 29
    iget-object p1, p0, Lid/eska/screenshotwebp/MonitorService;->monitor:Lid/eska/screenshotwebp/MediaMonitor;

    if-nez p1, :cond_4

    .line 30
    iget-object p1, p0, Lid/eska/screenshotwebp/MonitorService;->state:Lid/eska/screenshotwebp/AppStateStore;

    const-string p2, "state"

    const/4 p3, 0x0

    if-nez p1, :cond_0

    invoke-static {p2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, p3

    :cond_0
    invoke-virtual {p1}, Lid/eska/screenshotwebp/AppStateStore;->hasAnyActivation()Z

    move-result p1

    if-eqz p1, :cond_3

    invoke-static {}, Landroid/os/Environment;->isExternalStorageManager()Z

    move-result p1

    if-nez p1, :cond_1

    goto :goto_1

    .line 34
    :cond_1
    new-instance v0, Lid/eska/screenshotwebp/MediaMonitor;

    .line 35
    iget-object p1, p0, Lid/eska/screenshotwebp/MonitorService;->state:Lid/eska/screenshotwebp/AppStateStore;

    if-nez p1, :cond_2

    invoke-static {p2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v1, p3

    goto :goto_0

    :cond_2
    move-object v1, p1

    .line 36
    :goto_0
    new-instance v2, Lid/eska/screenshotwebp/MediaConverter;

    invoke-direct {v2}, Lid/eska/screenshotwebp/MediaConverter;-><init>()V

    .line 37
    new-instance v3, Lid/eska/screenshotwebp/ScreenshotMediaConverter;

    const/4 p1, 0x3

    invoke-direct {v3, p3, p3, p1, p3}, Lid/eska/screenshotwebp/ScreenshotMediaConverter;-><init>(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 50
    new-instance v4, Lid/eska/screenshotwebp/MonitorService$$ExternalSyntheticLambda0;

    invoke-direct {v4, p0}, Lid/eska/screenshotwebp/MonitorService$$ExternalSyntheticLambda0;-><init>(Lid/eska/screenshotwebp/MonitorService;)V

    new-instance v5, Lid/eska/screenshotwebp/MonitorService$$ExternalSyntheticLambda1;

    invoke-direct {v5, p0}, Lid/eska/screenshotwebp/MonitorService$$ExternalSyntheticLambda1;-><init>(Lid/eska/screenshotwebp/MonitorService;)V

    .line 34
    invoke-direct/range {v0 .. v5}, Lid/eska/screenshotwebp/MediaMonitor;-><init>(Lid/eska/screenshotwebp/AppStateStore;Lid/eska/screenshotwebp/MediaConverter;Lid/eska/screenshotwebp/ScreenshotMediaConverter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V

    .line 50
    invoke-virtual {v0}, Lid/eska/screenshotwebp/MediaMonitor;->start()V

    .line 34
    iput-object v0, p0, Lid/eska/screenshotwebp/MonitorService;->monitor:Lid/eska/screenshotwebp/MediaMonitor;

    goto :goto_2

    .line 31
    :cond_3
    :goto_1
    invoke-virtual {p0}, Lid/eska/screenshotwebp/MonitorService;->stopSelf()V

    const/4 p0, 0x2

    return p0

    :cond_4
    :goto_2
    const/4 p0, 0x1

    return p0
.end method
