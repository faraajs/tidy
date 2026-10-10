.class public final synthetic Lid/eska/screenshotwebp/ScreenshotMonitor$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# direct methods
.method public synthetic constructor <init>()V
    .locals 0

    .line 0
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 0
    check-cast p1, Ljava/io/File;

    check-cast p2, Lid/eska/screenshotwebp/ConversionResult;

    invoke-static {p1, p2}, Lid/eska/screenshotwebp/ScreenshotMonitor;->$r8$lambda$1UylQs2ioxAs82rN-gUzBlD0pz8(Ljava/io/File;Lid/eska/screenshotwebp/ConversionResult;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method
