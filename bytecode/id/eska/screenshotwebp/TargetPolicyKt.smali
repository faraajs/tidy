.class public final Lid/eska/screenshotwebp/TargetPolicyKt;
.super Ljava/lang/Object;
.source "TargetPolicy.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u00a8\u0006\u0004"
    }
    d2 = {
        "targetBucket",
        "Lid/eska/screenshotwebp/TargetBucket;",
        "originalBytes",
        "",
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
.method public static final targetBucket(J)Lid/eska/screenshotwebp/TargetBucket;
    .locals 3

    const-wide/32 v0, 0x300000

    cmp-long v0, p0, v0

    if-lez v0, :cond_0

    .line 6
    new-instance p0, Lid/eska/screenshotwebp/TargetBucket;

    const-wide/32 v0, 0xbb800

    invoke-direct {p0, v0, v1}, Lid/eska/screenshotwebp/TargetBucket;-><init>(J)V

    return-object p0

    :cond_0
    const-wide/32 v0, 0x100000

    cmp-long v0, p0, v0

    const-wide/32 v1, 0x7d000

    if-lez v0, :cond_1

    .line 7
    new-instance p0, Lid/eska/screenshotwebp/TargetBucket;

    invoke-direct {p0, v1, v2}, Lid/eska/screenshotwebp/TargetBucket;-><init>(J)V

    return-object p0

    :cond_1
    cmp-long p0, p0, v1

    if-lez p0, :cond_2

    .line 8
    new-instance p0, Lid/eska/screenshotwebp/TargetBucket;

    const-wide/32 v0, 0x3e800

    invoke-direct {p0, v0, v1}, Lid/eska/screenshotwebp/TargetBucket;-><init>(J)V

    return-object p0

    .line 9
    :cond_2
    new-instance p0, Lid/eska/screenshotwebp/TargetBucket;

    const-wide/32 v0, 0x19000

    invoke-direct {p0, v0, v1}, Lid/eska/screenshotwebp/TargetBucket;-><init>(J)V

    return-object p0
.end method
