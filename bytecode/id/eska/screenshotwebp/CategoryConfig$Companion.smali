.class public final Lid/eska/screenshotwebp/CategoryConfig$Companion;
.super Ljava/lang/Object;
.source "MediaModel.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lid/eska/screenshotwebp/CategoryConfig;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Companion"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002\u00a2\u0006\u0004\u0008\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\u0008"
    }
    d2 = {
        "Lid/eska/screenshotwebp/CategoryConfig$Companion;",
        "",
        "<init>",
        "()V",
        "defaults",
        "Lid/eska/screenshotwebp/CategoryConfig;",
        "category",
        "Lid/eska/screenshotwebp/MediaCategory;",
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


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    invoke-direct {p0}, Lid/eska/screenshotwebp/CategoryConfig$Companion;-><init>()V

    return-void
.end method


# virtual methods
.method public final defaults(Lid/eska/screenshotwebp/MediaCategory;)Lid/eska/screenshotwebp/CategoryConfig;
    .locals 2

    const-string p0, "category"

    invoke-static {p1, p0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 28
    new-instance p0, Lid/eska/screenshotwebp/CategoryConfig;

    const/4 v0, 0x0

    .line 31
    sget-object v1, Lid/eska/screenshotwebp/OutputFormat;->AVIF:Lid/eska/screenshotwebp/OutputFormat;

    .line 28
    invoke-direct {p0, p1, v0, v1}, Lid/eska/screenshotwebp/CategoryConfig;-><init>(Lid/eska/screenshotwebp/MediaCategory;Ljava/lang/Long;Lid/eska/screenshotwebp/OutputFormat;)V

    return-object p0
.end method
