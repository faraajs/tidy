.class public final synthetic Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda23;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# instance fields
.field public final synthetic f$0:Lid/eska/screenshotwebp/MainActivity;

.field public final synthetic f$1:Lid/eska/screenshotwebp/MediaCategory;


# direct methods
.method public synthetic constructor <init>(Lid/eska/screenshotwebp/MainActivity;Lid/eska/screenshotwebp/MediaCategory;)V
    .locals 0

    .line 0
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda23;->f$0:Lid/eska/screenshotwebp/MainActivity;

    iput-object p2, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda23;->f$1:Lid/eska/screenshotwebp/MediaCategory;

    return-void
.end method


# virtual methods
.method public final invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .line 0
    iget-object v0, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda23;->f$0:Lid/eska/screenshotwebp/MainActivity;

    iget-object p0, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda23;->f$1:Lid/eska/screenshotwebp/MediaCategory;

    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p1

    invoke-static {v0, p0, p1}, Lid/eska/screenshotwebp/MainActivity;->$r8$lambda$4p9WDbvkgCCeLRMy-DOsUAeubKg(Lid/eska/screenshotwebp/MainActivity;Lid/eska/screenshotwebp/MediaCategory;Z)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method
