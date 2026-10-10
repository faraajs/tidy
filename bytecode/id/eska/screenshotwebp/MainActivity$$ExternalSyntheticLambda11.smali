.class public final synthetic Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda11;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# instance fields
.field public final synthetic f$0:Lid/eska/screenshotwebp/MainActivity;

.field public final synthetic f$1:Ljava/lang/String;

.field public final synthetic f$2:Z

.field public final synthetic f$3:Lkotlin/jvm/functions/Function0;

.field public final synthetic f$4:I


# direct methods
.method public synthetic constructor <init>(Lid/eska/screenshotwebp/MainActivity;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;I)V
    .locals 0

    .line 0
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda11;->f$0:Lid/eska/screenshotwebp/MainActivity;

    iput-object p2, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda11;->f$1:Ljava/lang/String;

    iput-boolean p3, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda11;->f$2:Z

    iput-object p4, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda11;->f$3:Lkotlin/jvm/functions/Function0;

    iput p5, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda11;->f$4:I

    return-void
.end method


# virtual methods
.method public final invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 7

    .line 0
    iget-object v0, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda11;->f$0:Lid/eska/screenshotwebp/MainActivity;

    iget-object v1, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda11;->f$1:Ljava/lang/String;

    iget-boolean v2, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda11;->f$2:Z

    iget-object v3, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda11;->f$3:Lkotlin/jvm/functions/Function0;

    iget v4, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda11;->f$4:I

    move-object v5, p1

    check-cast v5, Landroidx/compose/runtime/Composer;

    check-cast p2, Ljava/lang/Integer;

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result v6

    invoke-static/range {v0 .. v6}, Lid/eska/screenshotwebp/MainActivity;->$r8$lambda$zUPaqaVqf2OPAJYM5rLB-CtmoXs(Lid/eska/screenshotwebp/MainActivity;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;ILandroidx/compose/runtime/Composer;I)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method
