.class public final synthetic Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda18;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Lkotlin/jvm/functions/Function3;


# instance fields
.field public final synthetic f$0:Lid/eska/screenshotwebp/MediaCategory;

.field public final synthetic f$1:I

.field public final synthetic f$2:J

.field public final synthetic f$3:Ljava/lang/String;

.field public final synthetic f$4:Lid/eska/screenshotwebp/CategoryConfig;

.field public final synthetic f$5:Lid/eska/screenshotwebp/MainActivity;


# direct methods
.method public synthetic constructor <init>(Lid/eska/screenshotwebp/MediaCategory;IJLjava/lang/String;Lid/eska/screenshotwebp/CategoryConfig;Lid/eska/screenshotwebp/MainActivity;)V
    .locals 0

    .line 0
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda18;->f$0:Lid/eska/screenshotwebp/MediaCategory;

    iput p2, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda18;->f$1:I

    iput-wide p3, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda18;->f$2:J

    iput-object p5, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda18;->f$3:Ljava/lang/String;

    iput-object p6, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda18;->f$4:Lid/eska/screenshotwebp/CategoryConfig;

    iput-object p7, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda18;->f$5:Lid/eska/screenshotwebp/MainActivity;

    return-void
.end method


# virtual methods
.method public final invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 10

    .line 0
    iget-object v0, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda18;->f$0:Lid/eska/screenshotwebp/MediaCategory;

    iget v1, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda18;->f$1:I

    iget-wide v2, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda18;->f$2:J

    iget-object v4, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda18;->f$3:Ljava/lang/String;

    iget-object v5, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda18;->f$4:Lid/eska/screenshotwebp/CategoryConfig;

    iget-object v6, p0, Lid/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda18;->f$5:Lid/eska/screenshotwebp/MainActivity;

    move-object v7, p1

    check-cast v7, Landroidx/compose/foundation/layout/ColumnScope;

    move-object v8, p2

    check-cast v8, Landroidx/compose/runtime/Composer;

    check-cast p3, Ljava/lang/Integer;

    invoke-virtual {p3}, Ljava/lang/Integer;->intValue()I

    move-result v9

    invoke-static/range {v0 .. v9}, Lid/eska/screenshotwebp/MainActivity;->$r8$lambda$2xP0SF0_VpRqi3T-MWys0VwI5tg(Lid/eska/screenshotwebp/MediaCategory;IJLjava/lang/String;Lid/eska/screenshotwebp/CategoryConfig;Lid/eska/screenshotwebp/MainActivity;Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/runtime/Composer;I)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method
