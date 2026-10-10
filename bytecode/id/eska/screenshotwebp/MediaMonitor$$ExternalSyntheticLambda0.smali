.class public final synthetic Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# instance fields
.field public final synthetic f$0:Lid/eska/screenshotwebp/MediaMonitor;

.field public final synthetic f$1:Lid/eska/screenshotwebp/MediaCategory;


# direct methods
.method public synthetic constructor <init>(Lid/eska/screenshotwebp/MediaMonitor;Lid/eska/screenshotwebp/MediaCategory;)V
    .locals 0

    .line 0
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda0;->f$0:Lid/eska/screenshotwebp/MediaMonitor;

    iput-object p2, p0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda0;->f$1:Lid/eska/screenshotwebp/MediaCategory;

    return-void
.end method


# virtual methods
.method public final invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .line 0
    iget-object v0, p0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda0;->f$0:Lid/eska/screenshotwebp/MediaMonitor;

    iget-object p0, p0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda0;->f$1:Lid/eska/screenshotwebp/MediaCategory;

    check-cast p1, Ljava/io/File;

    invoke-static {v0, p0, p1}, Lid/eska/screenshotwebp/MediaMonitor;->$r8$lambda$HG5ELUiTKvyf-2854bnKOfsJvSM(Lid/eska/screenshotwebp/MediaMonitor;Lid/eska/screenshotwebp/MediaCategory;Ljava/io/File;)Z

    move-result p0

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p0

    return-object p0
.end method
