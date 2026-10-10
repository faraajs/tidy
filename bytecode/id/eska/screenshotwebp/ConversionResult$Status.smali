.class public final enum Lid/eska/screenshotwebp/ConversionResult$Status;
.super Ljava/lang/Enum;
.source "ScreenshotConverter.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lid/eska/screenshotwebp/ConversionResult;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Status"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lid/eska/screenshotwebp/ConversionResult$Status;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0006\u0008\u0086\u0081\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\t\u0008\u0002\u00a2\u0006\u0004\u0008\u0002\u0010\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006\u00a8\u0006\u0007"
    }
    d2 = {
        "Lid/eska/screenshotwebp/ConversionResult$Status;",
        "",
        "<init>",
        "(Ljava/lang/String;I)V",
        "SUCCESS",
        "EXISTING_OUTPUT",
        "FAILED",
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

.field private static final synthetic $VALUES:[Lid/eska/screenshotwebp/ConversionResult$Status;

.field public static final enum EXISTING_OUTPUT:Lid/eska/screenshotwebp/ConversionResult$Status;

.field public static final enum FAILED:Lid/eska/screenshotwebp/ConversionResult$Status;

.field public static final enum SUCCESS:Lid/eska/screenshotwebp/ConversionResult$Status;


# direct methods
.method private static final synthetic $values()[Lid/eska/screenshotwebp/ConversionResult$Status;
    .locals 3

    sget-object v0, Lid/eska/screenshotwebp/ConversionResult$Status;->SUCCESS:Lid/eska/screenshotwebp/ConversionResult$Status;

    sget-object v1, Lid/eska/screenshotwebp/ConversionResult$Status;->EXISTING_OUTPUT:Lid/eska/screenshotwebp/ConversionResult$Status;

    sget-object v2, Lid/eska/screenshotwebp/ConversionResult$Status;->FAILED:Lid/eska/screenshotwebp/ConversionResult$Status;

    filled-new-array {v0, v1, v2}, [Lid/eska/screenshotwebp/ConversionResult$Status;

    move-result-object v0

    return-object v0
.end method

.method static constructor <clinit>()V
    .locals 3

    .line 24
    new-instance v0, Lid/eska/screenshotwebp/ConversionResult$Status;

    const-string v1, "SUCCESS"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lid/eska/screenshotwebp/ConversionResult$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lid/eska/screenshotwebp/ConversionResult$Status;->SUCCESS:Lid/eska/screenshotwebp/ConversionResult$Status;

    new-instance v0, Lid/eska/screenshotwebp/ConversionResult$Status;

    const-string v1, "EXISTING_OUTPUT"

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lid/eska/screenshotwebp/ConversionResult$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lid/eska/screenshotwebp/ConversionResult$Status;->EXISTING_OUTPUT:Lid/eska/screenshotwebp/ConversionResult$Status;

    new-instance v0, Lid/eska/screenshotwebp/ConversionResult$Status;

    const-string v1, "FAILED"

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2}, Lid/eska/screenshotwebp/ConversionResult$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lid/eska/screenshotwebp/ConversionResult$Status;->FAILED:Lid/eska/screenshotwebp/ConversionResult$Status;

    invoke-static {}, Lid/eska/screenshotwebp/ConversionResult$Status;->$values()[Lid/eska/screenshotwebp/ConversionResult$Status;

    move-result-object v0

    sput-object v0, Lid/eska/screenshotwebp/ConversionResult$Status;->$VALUES:[Lid/eska/screenshotwebp/ConversionResult$Status;

    check-cast v0, [Ljava/lang/Enum;

    invoke-static {v0}, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;

    move-result-object v0

    sput-object v0, Lid/eska/screenshotwebp/ConversionResult$Status;->$ENTRIES:Lkotlin/enums/EnumEntries;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 24
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static getEntries()Lkotlin/enums/EnumEntries;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lkotlin/enums/EnumEntries<",
            "Lid/eska/screenshotwebp/ConversionResult$Status;",
            ">;"
        }
    .end annotation

    sget-object v0, Lid/eska/screenshotwebp/ConversionResult$Status;->$ENTRIES:Lkotlin/enums/EnumEntries;

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lid/eska/screenshotwebp/ConversionResult$Status;
    .locals 1

    const-class v0, Lid/eska/screenshotwebp/ConversionResult$Status;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lid/eska/screenshotwebp/ConversionResult$Status;

    return-object p0
.end method

.method public static values()[Lid/eska/screenshotwebp/ConversionResult$Status;
    .locals 1

    sget-object v0, Lid/eska/screenshotwebp/ConversionResult$Status;->$VALUES:[Lid/eska/screenshotwebp/ConversionResult$Status;

    invoke-virtual {v0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lid/eska/screenshotwebp/ConversionResult$Status;

    return-object v0
.end method
