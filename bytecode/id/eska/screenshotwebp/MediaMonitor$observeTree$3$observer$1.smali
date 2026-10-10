.class public final Lid/eska/screenshotwebp/MediaMonitor$observeTree$3$observer$1;
.super Landroid/os/FileObserver;
.source "MediaMonitor.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lid/eska/screenshotwebp/MediaMonitor;->observeTree(Ljava/io/File;Lid/eska/screenshotwebp/MediaCategory;)V
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
        "id/eska/screenshotwebp/MediaMonitor$observeTree$3$observer$1",
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
.field final synthetic $category:Lid/eska/screenshotwebp/MediaCategory;

.field final synthetic $directory:Ljava/io/File;

.field final synthetic this$0:Lid/eska/screenshotwebp/MediaMonitor;


# direct methods
.method constructor <init>(Ljava/io/File;Lid/eska/screenshotwebp/MediaMonitor;Lid/eska/screenshotwebp/MediaCategory;)V
    .locals 0

    iput-object p1, p0, Lid/eska/screenshotwebp/MediaMonitor$observeTree$3$observer$1;->$directory:Ljava/io/File;

    iput-object p2, p0, Lid/eska/screenshotwebp/MediaMonitor$observeTree$3$observer$1;->this$0:Lid/eska/screenshotwebp/MediaMonitor;

    iput-object p3, p0, Lid/eska/screenshotwebp/MediaMonitor$observeTree$3$observer$1;->$category:Lid/eska/screenshotwebp/MediaCategory;

    const/16 p2, 0x188

    .line 74
    invoke-direct {p0, p1, p2}, Landroid/os/FileObserver;-><init>(Ljava/io/File;I)V

    return-void
.end method


# virtual methods
.method public onEvent(ILjava/lang/String;)V
    .locals 2

    if-nez p2, :cond_0

    goto :goto_0

    .line 77
    :cond_0
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lid/eska/screenshotwebp/MediaMonitor$observeTree$3$observer$1;->$directory:Ljava/io/File;

    invoke-direct {v0, v1, p2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 78
    invoke-virtual {v0}, Ljava/io/File;->isDirectory()Z

    move-result p2

    if-eqz p2, :cond_1

    and-int/lit16 p1, p1, 0x180

    if-eqz p1, :cond_2

    .line 79
    iget-object p0, p0, Lid/eska/screenshotwebp/MediaMonitor$observeTree$3$observer$1;->this$0:Lid/eska/screenshotwebp/MediaMonitor;

    invoke-static {p0}, Lid/eska/screenshotwebp/MediaMonitor;->access$reconcile(Lid/eska/screenshotwebp/MediaMonitor;)V

    return-void

    .line 80
    :cond_1
    sget-object p2, Lid/eska/screenshotwebp/MediaMonitor;->Companion:Lid/eska/screenshotwebp/MediaMonitor$Companion;

    invoke-virtual {p2, p1}, Lid/eska/screenshotwebp/MediaMonitor$Companion;->isCompletedFileEvent(I)Z

    move-result p1

    if-eqz p1, :cond_2

    .line 81
    iget-object p1, p0, Lid/eska/screenshotwebp/MediaMonitor$observeTree$3$observer$1;->this$0:Lid/eska/screenshotwebp/MediaMonitor;

    invoke-static {p1}, Lid/eska/screenshotwebp/MediaMonitor;->access$getState$p(Lid/eska/screenshotwebp/MediaMonitor;)Lid/eska/screenshotwebp/AppStateStore;

    move-result-object p1

    iget-object p2, p0, Lid/eska/screenshotwebp/MediaMonitor$observeTree$3$observer$1;->$category:Lid/eska/screenshotwebp/MediaCategory;

    invoke-virtual {p1, p2}, Lid/eska/screenshotwebp/AppStateStore;->categoryConfig(Lid/eska/screenshotwebp/MediaCategory;)Lid/eska/screenshotwebp/CategoryConfig;

    move-result-object p1

    .line 82
    invoke-virtual {p1}, Lid/eska/screenshotwebp/CategoryConfig;->getActive()Z

    move-result p2

    if-eqz p2, :cond_2

    iget-object p2, p0, Lid/eska/screenshotwebp/MediaMonitor$observeTree$3$observer$1;->this$0:Lid/eska/screenshotwebp/MediaMonitor;

    iget-object p0, p0, Lid/eska/screenshotwebp/MediaMonitor$observeTree$3$observer$1;->$category:Lid/eska/screenshotwebp/MediaCategory;

    invoke-static {p2, v0, p0, p1}, Lid/eska/screenshotwebp/MediaMonitor;->access$enqueue(Lid/eska/screenshotwebp/MediaMonitor;Ljava/io/File;Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/CategoryConfig;)V

    :cond_2
    :goto_0
    return-void
.end method
