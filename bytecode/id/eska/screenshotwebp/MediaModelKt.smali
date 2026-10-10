.class public final Lid/eska/screenshotwebp/MediaModelKt;
.super Ljava/lang/Object;
.source "MediaModel.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lid/eska/screenshotwebp/MediaModelKt$WhenMappings;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u00a8\u0006\u0005"
    }
    d2 = {
        "fallbackFormat",
        "Lid/eska/screenshotwebp/OutputFormat;",
        "requested",
        "screenshotFormat",
        "selected",
        "app_release"
    }
    k = 0x2
    mv = {
        0x2,
        0x3,
        0x0
    }
    xi = 0x30
.end annotation


# direct methods
.method public static final fallbackFormat(Lid/eska/screenshotwebp/OutputFormat;)Lid/eska/screenshotwebp/OutputFormat;
    .locals 1

    const-string v0, "requested"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 36
    sget-object v0, Lid/eska/screenshotwebp/MediaModelKt$WhenMappings;->$EnumSwitchMapping$0:[I

    invoke-virtual {p0}, Lid/eska/screenshotwebp/OutputFormat;->ordinal()I

    move-result p0

    aget p0, v0, p0

    const/4 v0, 0x1

    if-eq p0, v0, :cond_1

    const/4 v0, 0x2

    if-ne p0, v0, :cond_0

    .line 38
    sget-object p0, Lid/eska/screenshotwebp/OutputFormat;->WEBP:Lid/eska/screenshotwebp/OutputFormat;

    return-object p0

    .line 36
    :cond_0
    new-instance p0, Lkotlin/NoWhenBranchMatchedException;

    invoke-direct {p0}, Lkotlin/NoWhenBranchMatchedException;-><init>()V

    throw p0

    .line 37
    :cond_1
    sget-object p0, Lid/eska/screenshotwebp/OutputFormat;->AVIF:Lid/eska/screenshotwebp/OutputFormat;

    return-object p0
.end method

.method public static final screenshotFormat(Lid/eska/screenshotwebp/OutputFormat;)Lid/eska/screenshotwebp/OutputFormat;
    .locals 1

    const-string v0, "selected"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 41
    sget-object p0, Lid/eska/screenshotwebp/OutputFormat;->AVIF:Lid/eska/screenshotwebp/OutputFormat;

    return-object p0
.end method
