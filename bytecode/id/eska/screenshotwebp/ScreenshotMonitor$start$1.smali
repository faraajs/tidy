.class public final Lid/eska/screenshotwebp/ScreenshotMonitor$start$1;
.super Landroid/os/FileObserver;
.source "ScreenshotMonitor.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lid/eska/screenshotwebp/ScreenshotMonitor;->start()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0008"
    }
    d2 = {
        "id/eska/screenshotwebp/ScreenshotMonitor$start$1",
        "Landroid/os/FileObserver;",
        "onEvent",
        "",
        "event",
        "",
        "path",
        "",
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


# instance fields
.field final synthetic this$0:Lid/eska/screenshotwebp/ScreenshotMonitor;


# direct methods
.method constructor <init>(Lid/eska/screenshotwebp/ScreenshotMonitor;Ljava/io/File;)V
    .locals 0

    iput-object p1, p0, Lid/eska/screenshotwebp/ScreenshotMonitor$start$1;->this$0:Lid/eska/screenshotwebp/ScreenshotMonitor;

    const/16 p1, 0x88

    .line 33
    invoke-direct {p0, p2, p1}, Landroid/os/FileObserver;-><init>(Ljava/io/File;I)V

    return-void
.end method


# virtual methods
.method public onEvent(ILjava/lang/String;)V
    .locals 1

    if-nez p2, :cond_0

    return-void

    .line 36
    :cond_0
    iget-object p1, p0, Lid/eska/screenshotwebp/ScreenshotMonitor$start$1;->this$0:Lid/eska/screenshotwebp/ScreenshotMonitor;

    new-instance v0, Ljava/io/File;

    iget-object p0, p0, Lid/eska/screenshotwebp/ScreenshotMonitor$start$1;->this$0:Lid/eska/screenshotwebp/ScreenshotMonitor;

    invoke-static {p0}, Lid/eska/screenshotwebp/ScreenshotMonitor;->access$getRoot$p(Lid/eska/screenshotwebp/ScreenshotMonitor;)Ljava/io/File;

    move-result-object p0

    invoke-direct {v0, p0, p2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-static {p1, v0}, Lid/eska/screenshotwebp/ScreenshotMonitor;->access$enqueue(Lid/eska/screenshotwebp/ScreenshotMonitor;Ljava/io/File;)V

    return-void
.end method
