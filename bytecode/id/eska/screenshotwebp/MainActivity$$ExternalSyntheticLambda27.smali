.class public final synthetic Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda27;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# instance fields
.field public final synthetic f$0:Lid/eska/screenshotwebp/MainActivity;

.field public final synthetic f$1:I


# direct methods
.method public synthetic constructor <init>(Lid/eska/screenshotwebp/MainActivity;I)V
    .locals 0

    .line 0
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda27;->f$0:Lid/eska/screenshotwebp/MainActivity;

    iput p2, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda27;->f$1:I

    return-void
.end method


# virtual methods
.method public final invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .line 0
    iget-object v0, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda27;->f$0:Lid/eska/screenshotwebp/MainActivity;

    iget p0, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda27;->f$1:I

    check-cast p1, Landroidx/compose/runtime/Composer;

    check-cast p2, Ljava/lang/Integer;

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result p2

    invoke-static {v0, p0, p1, p2}, Lid/eska/screenshotwebp/MainActivity;->$r8$lambda$a2A1Bi3pXxENQr4y2_4P6wb_wwA(Lid/eska/screenshotwebp/MainActivity;ILandroidx/compose/runtime/Composer;I)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method
