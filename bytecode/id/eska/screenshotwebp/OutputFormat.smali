.class public final enum Lid/eska/screenshotwebp/OutputFormat;
.super Ljava/lang/Enum;
.source "MediaModel.kt"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lid/eska/screenshotwebp/OutputFormat;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000b\u0008\u0086\u0081\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B!\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tj\u0002\u0008\u000cj\u0002\u0008\r\u00a8\u0006\u000e"
    }
    d2 = {
        "Lid/eska/screenshotwebp/OutputFormat;",
        "",
        "label",
        "",
        "extension",
        "mimeType",
        "<init>",
        "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V",
        "getLabel",
        "()Ljava/lang/String;",
        "getExtension",
        "getMimeType",
        "WEBP",
        "AVIF",
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
.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;

.field private static final synthetic $VALUES:[Lid/eska/screenshotwebp/OutputFormat;

.field public static final enum AVIF:Lid/eska/screenshotwebp/OutputFormat;

.field public static final enum WEBP:Lid/eska/screenshotwebp/OutputFormat;


# instance fields
.field private final extension:Ljava/lang/String;

.field private final label:Ljava/lang/String;

.field private final mimeType:Ljava/lang/String;


# direct methods
.method private static final synthetic $values()[Lid/eska/screenshotwebp/OutputFormat;
    .locals 2

    sget-object v0, Lid/eska/screenshotwebp/OutputFormat;->WEBP:Lid/eska/screenshotwebp/OutputFormat;

    sget-object v1, Lid/eska/screenshotwebp/OutputFormat;->AVIF:Lid/eska/screenshotwebp/OutputFormat;

    filled-new-array {v0, v1}, [Lid/eska/screenshotwebp/OutputFormat;

    move-result-object v0

    return-object v0
.end method

.method static constructor <clinit>()V
    .locals 7

    .line 16
    new-instance v0, Lid/eska/screenshotwebp/OutputFormat;

    const-string v4, "webp"

    const-string v5, "image/webp"

    const-string v1, "WEBP"

    const/4 v2, 0x0

    const-string v3, "WebP"

    invoke-direct/range {v0 .. v5}, Lid/eska/screenshotwebp/OutputFormat;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lid/eska/screenshotwebp/OutputFormat;->WEBP:Lid/eska/screenshotwebp/OutputFormat;

    .line 17
    new-instance v1, Lid/eska/screenshotwebp/OutputFormat;

    const-string v5, "avif"

    const-string v6, "image/avif"

    const-string v2, "AVIF"

    const/4 v3, 0x1

    const-string v4, "AVIF"

    invoke-direct/range {v1 .. v6}, Lid/eska/screenshotwebp/OutputFormat;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v1, Lid/eska/screenshotwebp/OutputFormat;->AVIF:Lid/eska/screenshotwebp/OutputFormat;

    invoke-static {}, Lid/eska/screenshotwebp/OutputFormat;->$values()[Lid/eska/screenshotwebp/OutputFormat;

    move-result-object v0

    sput-object v0, Lid/eska/screenshotwebp/OutputFormat;->$VALUES:[Lid/eska/screenshotwebp/OutputFormat;

    check-cast v0, [Ljava/lang/Enum;

    invoke-static {v0}, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;

    move-result-object v0

    sput-object v0, Lid/eska/screenshotwebp/OutputFormat;->$ENTRIES:Lkotlin/enums/EnumEntries;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .line 11
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 12
    iput-object p3, p0, Lid/eska/screenshotwebp/OutputFormat;->label:Ljava/lang/String;

    .line 13
    iput-object p4, p0, Lid/eska/screenshotwebp/OutputFormat;->extension:Ljava/lang/String;

    .line 14
    iput-object p5, p0, Lid/eska/screenshotwebp/OutputFormat;->mimeType:Ljava/lang/String;

    return-void
.end method

.method public static getEntries()Lkotlin/enums/EnumEntries;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lkotlin/enums/EnumEntries<",
            "Lid/eska/screenshotwebp/OutputFormat;",
            ">;"
        }
    .end annotation

    sget-object v0, Lid/eska/screenshotwebp/OutputFormat;->$ENTRIES:Lkotlin/enums/EnumEntries;

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lid/eska/screenshotwebp/OutputFormat;
    .locals 1

    const-class v0, Lid/eska/screenshotwebp/OutputFormat;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lid/eska/screenshotwebp/OutputFormat;

    return-object p0
.end method

.method public static values()[Lid/eska/screenshotwebp/OutputFormat;
    .locals 1

    sget-object v0, Lid/eska/screenshotwebp/OutputFormat;->$VALUES:[Lid/eska/screenshotwebp/OutputFormat;

    invoke-virtual {v0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lid/eska/screenshotwebp/OutputFormat;

    return-object v0
.end method


# virtual methods
.method public final getExtension()Ljava/lang/String;
    .locals 0

    .line 13
    iget-object p0, p0, Lid/eska/screenshotwebp/OutputFormat;->extension:Ljava/lang/String;

    return-object p0
.end method

.method public final getLabel()Ljava/lang/String;
    .locals 0

    .line 12
    iget-object p0, p0, Lid/eska/screenshotwebp/OutputFormat;->label:Ljava/lang/String;

    return-object p0
.end method

.method public final getMimeType()Ljava/lang/String;
    .locals 0

    .line 14
    iget-object p0, p0, Lid/eska/screenshotwebp/OutputFormat;->mimeType:Ljava/lang/String;

    return-object p0
.end method
