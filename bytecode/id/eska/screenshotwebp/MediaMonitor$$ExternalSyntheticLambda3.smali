.class public final synthetic Lid/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Lkotlin/jvm/functions/Function3;


# direct methods
.method public synthetic constructor <init>()V
    .locals 0

    .line 0
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 0
    check-cast p1, Lid/eska/screenshotwebp/MediaCategory;

    check-cast p2, Ljava/io/File;

    check-cast p3, Lid/eska/screenshotwebp/ConversionResult;

    invoke-static {p1, p2, p3}, Lid/eska/screenshotwebp/MediaMonitor;->$r8$lambda$YdVd1TB2rzPF2wbSYI5cYdsJedw(Lid/eska/screenshotwebp/MediaCategory;Ljava/io/File;Lid/eska/screenshotwebp/ConversionResult;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method
