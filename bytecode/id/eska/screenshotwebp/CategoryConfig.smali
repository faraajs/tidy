.class public final Lid/eska/screenshotwebp/CategoryConfig;
.super Ljava/lang/Object;
.source "MediaModel.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lid/eska/screenshotwebp/CategoryConfig$Companion;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u0000  2\u00020\u0001:\u0001 B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\u0008\u0008\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J.\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u00122\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dH\u00d6\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fH\u00d6\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014\u00a8\u0006!"
    }
    d2 = {
        "Lid/eska/screenshotwebp/CategoryConfig;",
        "",
        "category",
        "Lid/eska/screenshotwebp/MediaCategory;",
        "activationEpochSeconds",
        "",
        "format",
        "Lid/eska/screenshotwebp/OutputFormat;",
        "<init>",
        "(Lid/eska/screenshotwebp/MediaCategory;Ljava/lang/Long;Lid/eska/screenshotwebp/OutputFormat;)V",
        "getCategory",
        "()Lid/eska/screenshotwebp/MediaCategory;",
        "getActivationEpochSeconds",
        "()Ljava/lang/Long;",
        "Ljava/lang/Long;",
        "getFormat",
        "()Lid/eska/screenshotwebp/OutputFormat;",
        "active",
        "",
        "getActive",
        "()Z",
        "component1",
        "component2",
        "component3",
        "copy",
        "(Lid/eska/screenshotwebp/MediaCategory;Ljava/lang/Long;Lid/eska/screenshotwebp/OutputFormat;)Lid/eska/screenshotwebp/CategoryConfig;",
        "equals",
        "other",
        "hashCode",
        "",
        "toString",
        "",
        "Companion",
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


# static fields
.field public static final $stable:I

.field public static final Companion:Lid/eska/screenshotwebp/CategoryConfig$Companion;


# instance fields
.field private final activationEpochSeconds:Ljava/lang/Long;

.field private final category:Lid/eska/screenshotwebp/MediaCategory;

.field private final format:Lid/eska/screenshotwebp/OutputFormat;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lid/eska/screenshotwebp/CategoryConfig$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lid/eska/screenshotwebp/CategoryConfig$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lid/eska/screenshotwebp/CategoryConfig;->Companion:Lid/eska/screenshotwebp/CategoryConfig$Companion;

    return-void
.end method

.method public constructor <init>(Lid/eska/screenshotwebp/MediaCategory;Ljava/lang/Long;Lid/eska/screenshotwebp/OutputFormat;)V
    .locals 1

    const-string v0, "category"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "format"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p1, p0, Lid/eska/screenshotwebp/CategoryConfig;->category:Lid/eska/screenshotwebp/MediaCategory;

    .line 22
    iput-object p2, p0, Lid/eska/screenshotwebp/CategoryConfig;->activationEpochSeconds:Ljava/lang/Long;

    .line 23
    iput-object p3, p0, Lid/eska/screenshotwebp/CategoryConfig;->format:Lid/eska/screenshotwebp/OutputFormat;

    return-void
.end method

.method public static synthetic copy$default(Lid/eska/screenshotwebp/CategoryConfig;Lid/eska/screenshotwebp/MediaCategory;Ljava/lang/Long;Lid/eska/screenshotwebp/OutputFormat;ILjava/lang/Object;)Lid/eska/screenshotwebp/CategoryConfig;
    .locals 0

    and-int/lit8 p5, p4, 0x1

    if-eqz p5, :cond_0

    iget-object p1, p0, Lid/eska/screenshotwebp/CategoryConfig;->category:Lid/eska/screenshotwebp/MediaCategory;

    :cond_0
    and-int/lit8 p5, p4, 0x2

    if-eqz p5, :cond_1

    iget-object p2, p0, Lid/eska/screenshotwebp/CategoryConfig;->activationEpochSeconds:Ljava/lang/Long;

    :cond_1
    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_2

    iget-object p3, p0, Lid/eska/screenshotwebp/CategoryConfig;->format:Lid/eska/screenshotwebp/OutputFormat;

    :cond_2
    invoke-virtual {p0, p1, p2, p3}, Lid/eska/screenshotwebp/CategoryConfig;->copy(Lid/eska/screenshotwebp/MediaCategory;Ljava/lang/Long;Lid/eska/screenshotwebp/OutputFormat;)Lid/eska/screenshotwebp/CategoryConfig;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public final component1()Lid/eska/screenshotwebp/MediaCategory;
    .locals 0

    iget-object p0, p0, Lid/eska/screenshotwebp/CategoryConfig;->category:Lid/eska/screenshotwebp/MediaCategory;

    return-object p0
.end method

.method public final component2()Ljava/lang/Long;
    .locals 0

    iget-object p0, p0, Lid/eska/screenshotwebp/CategoryConfig;->activationEpochSeconds:Ljava/lang/Long;

    return-object p0
.end method

.method public final component3()Lid/eska/screenshotwebp/OutputFormat;
    .locals 0

    iget-object p0, p0, Lid/eska/screenshotwebp/CategoryConfig;->format:Lid/eska/screenshotwebp/OutputFormat;

    return-object p0
.end method

.method public final copy(Lid/eska/screenshotwebp/MediaCategory;Ljava/lang/Long;Lid/eska/screenshotwebp/OutputFormat;)Lid/eska/screenshotwebp/CategoryConfig;
    .locals 0

    const-string p0, "category"

    invoke-static {p1, p0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p0, "format"

    invoke-static {p3, p0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance p0, Lid/eska/screenshotwebp/CategoryConfig;

    invoke-direct {p0, p1, p2, p3}, Lid/eska/screenshotwebp/CategoryConfig;-><init>(Lid/eska/screenshotwebp/MediaCategory;Ljava/lang/Long;Lid/eska/screenshotwebp/OutputFormat;)V

    return-object p0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    return v0

    :cond_0
    instance-of v1, p1, Lid/eska/screenshotwebp/CategoryConfig;

    const/4 v2, 0x0

    if-nez v1, :cond_1

    return v2

    :cond_1
    check-cast p1, Lid/eska/screenshotwebp/CategoryConfig;

    iget-object v1, p0, Lid/eska/screenshotwebp/CategoryConfig;->category:Lid/eska/screenshotwebp/MediaCategory;

    iget-object v3, p1, Lid/eska/screenshotwebp/CategoryConfig;->category:Lid/eska/screenshotwebp/MediaCategory;

    if-eq v1, v3, :cond_2

    return v2

    :cond_2
    iget-object v1, p0, Lid/eska/screenshotwebp/CategoryConfig;->activationEpochSeconds:Ljava/lang/Long;

    iget-object v3, p1, Lid/eska/screenshotwebp/CategoryConfig;->activationEpochSeconds:Ljava/lang/Long;

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    return v2

    :cond_3
    iget-object p0, p0, Lid/eska/screenshotwebp/CategoryConfig;->format:Lid/eska/screenshotwebp/OutputFormat;

    iget-object p1, p1, Lid/eska/screenshotwebp/CategoryConfig;->format:Lid/eska/screenshotwebp/OutputFormat;

    if-eq p0, p1, :cond_4

    return v2

    :cond_4
    return v0
.end method

.method public final getActivationEpochSeconds()Ljava/lang/Long;
    .locals 0

    .line 22
    iget-object p0, p0, Lid/eska/screenshotwebp/CategoryConfig;->activationEpochSeconds:Ljava/lang/Long;

    return-object p0
.end method

.method public final getActive()Z
    .locals 0

    .line 25
    iget-object p0, p0, Lid/eska/screenshotwebp/CategoryConfig;->activationEpochSeconds:Ljava/lang/Long;

    if-eqz p0, :cond_0

    const/4 p0, 0x1

    return p0

    :cond_0
    const/4 p0, 0x0

    return p0
.end method

.method public final getCategory()Lid/eska/screenshotwebp/MediaCategory;
    .locals 0

    .line 21
    iget-object p0, p0, Lid/eska/screenshotwebp/CategoryConfig;->category:Lid/eska/screenshotwebp/MediaCategory;

    return-object p0
.end method

.method public final getFormat()Lid/eska/screenshotwebp/OutputFormat;
    .locals 0

    .line 23
    iget-object p0, p0, Lid/eska/screenshotwebp/CategoryConfig;->format:Lid/eska/screenshotwebp/OutputFormat;

    return-object p0
.end method

.method public hashCode()I
    .locals 2

    iget-object v0, p0, Lid/eska/screenshotwebp/CategoryConfig;->category:Lid/eska/screenshotwebp/MediaCategory;

    invoke-virtual {v0}, Lid/eska/screenshotwebp/MediaCategory;->hashCode()I

    move-result v0

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lid/eska/screenshotwebp/CategoryConfig;->activationEpochSeconds:Ljava/lang/Long;

    if-nez v1, :cond_0

    const/4 v1, 0x0

    goto :goto_0

    :cond_0
    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    :goto_0
    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-object p0, p0, Lid/eska/screenshotwebp/CategoryConfig;->format:Lid/eska/screenshotwebp/OutputFormat;

    invoke-virtual {p0}, Lid/eska/screenshotwebp/OutputFormat;->hashCode()I

    move-result p0

    add-int/2addr v0, p0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    iget-object v0, p0, Lid/eska/screenshotwebp/CategoryConfig;->category:Lid/eska/screenshotwebp/MediaCategory;

    iget-object v1, p0, Lid/eska/screenshotwebp/CategoryConfig;->activationEpochSeconds:Ljava/lang/Long;

    iget-object p0, p0, Lid/eska/screenshotwebp/CategoryConfig;->format:Lid/eska/screenshotwebp/OutputFormat;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "CategoryConfig(category="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ", activationEpochSeconds="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", format="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string v0, ")"

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method
