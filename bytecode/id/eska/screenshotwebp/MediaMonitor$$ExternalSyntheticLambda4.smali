.class public final synthetic Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic f$0:Lid/eska/screenshotwebp/MediaCategory;

.field public final synthetic f$1:Lid/eska/screenshotwebp/CategoryConfig;

.field public final synthetic f$2:Ljava/io/File;

.field public final synthetic f$3:Lid/eska/screenshotwebp/MediaMonitor;

.field public final synthetic f$4:Ljava/lang/String;

.field public final synthetic f$5:Ljava/lang/String;


# direct methods
.method public synthetic constructor <init>(Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/CategoryConfig;Ljava/io/File;Lid/eska/screenshotwebp/MediaMonitor;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .line 0
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda4;->f$0:Lid/eska/screenshotwebp/MediaCategory;

    iput-object p2, p0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda4;->f$1:Lid/eska/screenshotwebp/CategoryConfig;

    iput-object p3, p0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda4;->f$2:Ljava/io/File;

    iput-object p4, p0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda4;->f$3:Lid/eska/screenshotwebp/MediaMonitor;

    iput-object p5, p0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda4;->f$4:Ljava/lang/String;

    iput-object p6, p0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda4;->f$5:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 6

    .line 0
    iget-object v0, p0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda4;->f$0:Lid/eska/screenshotwebp/MediaCategory;

    iget-object v1, p0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda4;->f$1:Lid/eska/screenshotwebp/CategoryConfig;

    iget-object v2, p0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda4;->f$2:Ljava/io/File;

    iget-object v3, p0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda4;->f$3:Lid/eska/screenshotwebp/MediaMonitor;

    iget-object v4, p0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda4;->f$4:Ljava/lang/String;

    iget-object v5, p0, Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda4;->f$5:Ljava/lang/String;

    invoke-static/range {v0 .. v5}, Lid/eska/screenshotwebp/MediaMonitor;->$r8$lambda$usQ1UfD2Lj4_xdcNZC6FeR0RUoc(Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/CategoryConfig;Ljava/io/File;Lid/eska/screenshotwebp/MediaMonitor;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
