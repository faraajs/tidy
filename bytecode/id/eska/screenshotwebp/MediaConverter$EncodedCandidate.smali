.class final Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;
.super Ljava/lang/Object;
.source "MediaConverter.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lid/eska/screenshotwebp/MediaConverter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "EncodedCandidate"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0015\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\u0008\u000b\u0010\u000cJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\nH\u00c6\u0003J;\u0010\u001b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0014\u0010\u001c\u001a\u00020\n2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0007H\u00d6\u0081\u0004J\n\u0010\u001f\u001a\u00020 H\u00d6\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0008\u001a\u00020\u0007\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\u00a8\u0006!"
    }
    d2 = {
        "Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;",
        "",
        "bytes",
        "",
        "format",
        "Lid/eska/screenshotwebp/OutputFormat;",
        "width",
        "",
        "height",
        "usedFallback",
        "",
        "<init>",
        "([BLid/eska/screenshotwebp/OutputFormat;IIZ)V",
        "getBytes",
        "()[B",
        "getFormat",
        "()Lid/eska/screenshotwebp/OutputFormat;",
        "getWidth",
        "()I",
        "getHeight",
        "getUsedFallback",
        "()Z",
        "component1",
        "component2",
        "component3",
        "component4",
        "component5",
        "copy",
        "equals",
        "other",
        "hashCode",
        "toString",
        "",
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


# instance fields
.field private final bytes:[B

.field private final format:Lid/eska/screenshotwebp/OutputFormat;

.field private final height:I

.field private final usedFallback:Z

.field private final width:I


# direct methods
.method public constructor <init>([BLid/eska/screenshotwebp/OutputFormat;IIZ)V
    .locals 1

    const-string v0, "bytes"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "format"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 258
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 259
    iput-object p1, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->bytes:[B

    .line 260
    iput-object p2, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->format:Lid/eska/screenshotwebp/OutputFormat;

    .line 261
    iput p3, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->width:I

    .line 262
    iput p4, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->height:I

    .line 263
    iput-boolean p5, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->usedFallback:Z

    return-void
.end method

.method public static synthetic copy$default(Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;[BLid/eska/screenshotwebp/OutputFormat;IIZILjava/lang/Object;)Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;
    .locals 0

    and-int/lit8 p7, p6, 0x1

    if-eqz p7, :cond_0

    iget-object p1, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->bytes:[B

    :cond_0
    and-int/lit8 p7, p6, 0x2

    if-eqz p7, :cond_1

    iget-object p2, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->format:Lid/eska/screenshotwebp/OutputFormat;

    :cond_1
    and-int/lit8 p7, p6, 0x4

    if-eqz p7, :cond_2

    iget p3, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->width:I

    :cond_2
    and-int/lit8 p7, p6, 0x8

    if-eqz p7, :cond_3

    iget p4, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->height:I

    :cond_3
    and-int/lit8 p6, p6, 0x10

    if-eqz p6, :cond_4

    iget-boolean p5, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->usedFallback:Z

    :cond_4
    move p6, p4

    move p7, p5

    move-object p4, p2

    move p5, p3

    move-object p2, p0

    move-object p3, p1

    invoke-virtual/range {p2 .. p7}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->copy([BLid/eska/screenshotwebp/OutputFormat;IIZ)Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public final component1()[B
    .locals 0

    iget-object p0, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->bytes:[B

    return-object p0
.end method

.method public final component2()Lid/eska/screenshotwebp/OutputFormat;
    .locals 0

    iget-object p0, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->format:Lid/eska/screenshotwebp/OutputFormat;

    return-object p0
.end method

.method public final component3()I
    .locals 0

    iget p0, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->width:I

    return p0
.end method

.method public final component4()I
    .locals 0

    iget p0, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->height:I

    return p0
.end method

.method public final component5()Z
    .locals 0

    iget-boolean p0, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->usedFallback:Z

    return p0
.end method

.method public final copy([BLid/eska/screenshotwebp/OutputFormat;IIZ)Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;
    .locals 6

    const-string p0, "bytes"

    invoke-static {p1, p0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p0, "format"

    invoke-static {p2, p0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    invoke-direct/range {v0 .. v5}, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;-><init>([BLid/eska/screenshotwebp/OutputFormat;IIZ)V

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    return v0

    :cond_0
    instance-of v1, p1, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;

    const/4 v2, 0x0

    if-nez v1, :cond_1

    return v2

    :cond_1
    check-cast p1, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;

    iget-object v1, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->bytes:[B

    iget-object v3, p1, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->bytes:[B

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    return v2

    :cond_2
    iget-object v1, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->format:Lid/eska/screenshotwebp/OutputFormat;

    iget-object v3, p1, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->format:Lid/eska/screenshotwebp/OutputFormat;

    if-eq v1, v3, :cond_3

    return v2

    :cond_3
    iget v1, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->width:I

    iget v3, p1, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->width:I

    if-eq v1, v3, :cond_4

    return v2

    :cond_4
    iget v1, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->height:I

    iget v3, p1, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->height:I

    if-eq v1, v3, :cond_5

    return v2

    :cond_5
    iget-boolean p0, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->usedFallback:Z

    iget-boolean p1, p1, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->usedFallback:Z

    if-eq p0, p1, :cond_6

    return v2

    :cond_6
    return v0
.end method

.method public final getBytes()[B
    .locals 0

    .line 259
    iget-object p0, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->bytes:[B

    return-object p0
.end method

.method public final getFormat()Lid/eska/screenshotwebp/OutputFormat;
    .locals 0

    .line 260
    iget-object p0, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->format:Lid/eska/screenshotwebp/OutputFormat;

    return-object p0
.end method

.method public final getHeight()I
    .locals 0

    .line 262
    iget p0, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->height:I

    return p0
.end method

.method public final getUsedFallback()Z
    .locals 0

    .line 263
    iget-boolean p0, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->usedFallback:Z

    return p0
.end method

.method public final getWidth()I
    .locals 0

    .line 261
    iget p0, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->width:I

    return p0
.end method

.method public hashCode()I
    .locals 2

    iget-object v0, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->bytes:[B

    invoke-static {v0}, Ljava/util/Arrays;->hashCode([B)I

    move-result v0

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->format:Lid/eska/screenshotwebp/OutputFormat;

    invoke-virtual {v1}, Lid/eska/screenshotwebp/OutputFormat;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget v1, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->width:I

    invoke-static {v1}, Ljava/lang/Integer;->hashCode(I)I

    move-result v1

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget v1, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->height:I

    invoke-static {v1}, Ljava/lang/Integer;->hashCode(I)I

    move-result v1

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-boolean p0, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->usedFallback:Z

    invoke-static {p0}, Ljava/lang/Boolean;->hashCode(Z)I

    move-result p0

    add-int/2addr v0, p0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 6

    iget-object v0, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->bytes:[B

    invoke-static {v0}, Ljava/util/Arrays;->toString([B)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->format:Lid/eska/screenshotwebp/OutputFormat;

    iget v2, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->width:I

    iget v3, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->height:I

    iget-boolean p0, p0, Lid/eska/screenshotwebp/MediaConverter$EncodedCandidate;->usedFallback:Z

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "EncodedCandidate(bytes="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ", format="

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", width="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", height="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", usedFallback="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string v0, ")"

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method
