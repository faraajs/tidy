.class public final Lid/eska/screenshotwebp/AppStateStore;
.super Ljava/lang/Object;
.source "AppStateStore.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lid/eska/screenshotwebp/AppStateStore$Companion;,
        Lid/eska/screenshotwebp/AppStateStore$WhenMappings;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nAppStateStore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppStateStore.kt\nid/eska/screenshotwebp/AppStateStore\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,234:1\n1807#2,3:235\n1#3:238\n*S KotlinDebug\n*F\n+ 1 AppStateStore.kt\nid/eska/screenshotwebp/AppStateStore\n*L\n150#1:235,3\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\u0008\u0004\u0010\u0005J\r\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\u0015\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000c\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\nJ\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000c\u001a\u00020\rJ\u0016\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000c\u001a\u00020\rJ\u0016\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nJ8\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0015J\u0016\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"J\u001e\u0010 \u001a\u00020\u00102\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\u0015J\u0008\u0010\'\u001a\u00020\u0010H\u0002J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u0010\u0010)\u001a\u00020\"2\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u0010\u0010*\u001a\u00020\"2\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u0010\u0010+\u001a\u00020\"2\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u0010\u0010,\u001a\u00020\"2\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u0010\u0010-\u001a\u00020\"2\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u0010\u0010.\u001a\u00020\"2\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u0010\u0010/\u001a\u00020\"2\u0006\u0010\u000c\u001a\u00020\rH\u0002R\u0016\u0010\u0006\u001a\n \u0008*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"
    }
    d2 = {
        "Lid/eska/screenshotwebp/AppStateStore;",
        "",
        "context",
        "Landroid/content/Context;",
        "<init>",
        "(Landroid/content/Context;)V",
        "prefs",
        "Landroid/content/SharedPreferences;",
        "kotlin.jvm.PlatformType",
        "activationEpochSeconds",
        "",
        "()Ljava/lang/Long;",
        "category",
        "Lid/eska/screenshotwebp/MediaCategory;",
        "(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/Long;",
        "markActivated",
        "",
        "epochSeconds",
        "markCategoryActivated",
        "setCategoryActive",
        "active",
        "",
        "format",
        "Lid/eska/screenshotwebp/OutputFormat;",
        "setFormat",
        "categoryConfig",
        "Lid/eska/screenshotwebp/CategoryConfig;",
        "recordSuccess",
        "sourceBytes",
        "outputBytes",
        "fallback",
        "targetMet",
        "recordFailure",
        "path",
        "",
        "message",
        "snapshot",
        "Lid/eska/screenshotwebp/AppState;",
        "hasAnyActivation",
        "migrateLegacyState",
        "readFormat",
        "activationKey",
        "activationMarkerKey",
        "formatKey",
        "countKey",
        "savedKey",
        "resultKey",
        "errorKey",
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

.field private static final Companion:Lid/eska/screenshotwebp/AppStateStore$Companion;

.field public static final KEY_ACTIVATION:Ljava/lang/String; = "activation"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_COUNT:Ljava/lang/String; = "count"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_ERROR:Ljava/lang/String; = "error"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_FALLBACKS:Ljava/lang/String; = "fallback_count"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_PHOTO_ACTIVATION:Ljava/lang/String; = "photo_activation"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_PHOTO_BASELINE:Ljava/lang/String; = "photo_baseline"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_PHOTO_COUNT:Ljava/lang/String; = "photo_count"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_PHOTO_ERROR:Ljava/lang/String; = "photo_error"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_PHOTO_FORMAT:Ljava/lang/String; = "photo_format"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_PHOTO_RESULT:Ljava/lang/String; = "photo_result"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_PHOTO_SAVED:Ljava/lang/String; = "photo_saved"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_RESULT:Ljava/lang/String; = "result"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_SAVED:Ljava/lang/String; = "saved"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_SCREENSHOT_ACTIVATION:Ljava/lang/String; = "screenshot_activation"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_SCREENSHOT_BASELINE:Ljava/lang/String; = "screenshot_baseline"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_SCREENSHOT_COUNT:Ljava/lang/String; = "screenshot_count"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_SCREENSHOT_ERROR:Ljava/lang/String; = "screenshot_error"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_SCREENSHOT_FORMAT:Ljava/lang/String; = "screenshot_format"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_SCREENSHOT_RESULT:Ljava/lang/String; = "screenshot_result"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_SCREENSHOT_SAVED:Ljava/lang/String; = "screenshot_saved"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field


# instance fields
.field private final prefs:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lid/eska/screenshotwebp/AppStateStore$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lid/eska/screenshotwebp/AppStateStore$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lid/eska/screenshotwebp/AppStateStore;->Companion:Lid/eska/screenshotwebp/AppStateStore$Companion;

    const/16 v0, 0x8

    sput v0, Lid/eska/screenshotwebp/AppStateStore;->$stable:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    invoke-virtual {p1}, Landroid/content/Context;->createDeviceProtectedStorageContext()Landroid/content/Context;

    move-result-object p1

    .line 28
    const-string v0, "state"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object p1

    iput-object p1, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    .line 31
    invoke-direct {p0}, Lid/eska/screenshotwebp/AppStateStore;->migrateLegacyState()V

    return-void
.end method

.method private final activationKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;
    .locals 0

    .line 189
    sget-object p0, Lid/eska/screenshotwebp/AppStateStore$WhenMappings;->$EnumSwitchMapping$0:[I

    invoke-virtual {p1}, Lid/eska/screenshotwebp/MediaCategory;->ordinal()I

    move-result p1

    aget p0, p0, p1

    const/4 p1, 0x1

    if-eq p0, p1, :cond_1

    const/4 p1, 0x2

    if-ne p0, p1, :cond_0

    .line 191
    const-string p0, "photo_activation"

    return-object p0

    .line 189
    :cond_0
    new-instance p0, Lkotlin/NoWhenBranchMatchedException;

    invoke-direct {p0}, Lkotlin/NoWhenBranchMatchedException;-><init>()V

    throw p0

    .line 190
    :cond_1
    const-string p0, "screenshot_activation"

    return-object p0
.end method

.method private final activationMarkerKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;
    .locals 0

    .line 194
    sget-object p0, Lid/eska/screenshotwebp/AppStateStore$WhenMappings;->$EnumSwitchMapping$0:[I

    invoke-virtual {p1}, Lid/eska/screenshotwebp/MediaCategory;->ordinal()I

    move-result p1

    aget p0, p0, p1

    const/4 p1, 0x1

    if-eq p0, p1, :cond_1

    const/4 p1, 0x2

    if-ne p0, p1, :cond_0

    .line 196
    const-string p0, "photo_baseline"

    return-object p0

    .line 194
    :cond_0
    new-instance p0, Lkotlin/NoWhenBranchMatchedException;

    invoke-direct {p0}, Lkotlin/NoWhenBranchMatchedException;-><init>()V

    throw p0

    .line 195
    :cond_1
    const-string p0, "screenshot_baseline"

    return-object p0
.end method

.method private final countKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;
    .locals 0

    .line 204
    sget-object p0, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    if-ne p1, p0, :cond_0

    const-string p0, "screenshot_count"

    return-object p0

    :cond_0
    const-string p0, "photo_count"

    return-object p0
.end method

.method private final errorKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;
    .locals 0

    .line 207
    sget-object p0, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    if-ne p1, p0, :cond_0

    const-string p0, "screenshot_error"

    return-object p0

    :cond_0
    const-string p0, "photo_error"

    return-object p0
.end method

.method private final formatKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;
    .locals 0

    .line 199
    sget-object p0, Lid/eska/screenshotwebp/AppStateStore$WhenMappings;->$EnumSwitchMapping$0:[I

    invoke-virtual {p1}, Lid/eska/screenshotwebp/MediaCategory;->ordinal()I

    move-result p1

    aget p0, p0, p1

    const/4 p1, 0x1

    if-eq p0, p1, :cond_1

    const/4 p1, 0x2

    if-ne p0, p1, :cond_0

    .line 201
    const-string p0, "photo_format"

    return-object p0

    .line 199
    :cond_0
    new-instance p0, Lkotlin/NoWhenBranchMatchedException;

    invoke-direct {p0}, Lkotlin/NoWhenBranchMatchedException;-><init>()V

    throw p0

    .line 200
    :cond_1
    const-string p0, "screenshot_format"

    return-object p0
.end method

.method private final migrateLegacyState()V
    .locals 8

    .line 153
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    const-string v1, "screenshot_activation"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    const-wide/16 v2, 0x0

    if-nez v0, :cond_0

    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    const-string v4, "activation"

    invoke-interface {v0, v4}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 154
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    iget-object v5, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v5, v4, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v4

    invoke-interface {v0, v1, v4, v5}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 156
    :cond_0
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    const-string v4, "screenshot_count"

    invoke-interface {v0, v4}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    const-string v5, "count"

    invoke-interface {v0, v5}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 157
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 158
    iget-object v6, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    const/4 v7, 0x0

    invoke-interface {v6, v5, v7}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v5

    invoke-interface {v0, v4, v5}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 159
    iget-object v4, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    const-string v5, "saved"

    invoke-interface {v4, v5, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v2

    const-string v4, "screenshot_saved"

    invoke-interface {v0, v4, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 160
    iget-object v2, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    const-string v3, "result"

    const-string v4, "Belum ada konversi"

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "screenshot_result"

    invoke-interface {v0, v3, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 161
    iget-object v2, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    const-string v3, "error"

    const-string v4, ""

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "screenshot_error"

    invoke-interface {v0, v3, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 162
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 164
    :cond_1
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    const-string v2, "screenshot_format"

    invoke-interface {v0, v2}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 165
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v3, "AVIF"

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 169
    :cond_2
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    const-string v1, "AVIF"

    const-string v2, "photo_format"

    if-eqz v0, :cond_3

    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    const-string v3, "photo_activation"

    invoke-interface {v0, v3}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 170
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    const/16 v0, 0x3e8

    int-to-long v6, v0

    div-long/2addr v4, v6

    .line 171
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 172
    invoke-interface {v0, v3, v4, v5}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 173
    const-string v3, "photo_baseline"

    invoke-interface {v0, v3, v4, v5}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 174
    invoke-interface {v0, v2, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 175
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 177
    :cond_3
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0, v2}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 178
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0, v2, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    :cond_4
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    const-string v2, "screenshot_format_migration_v2"

    invoke-interface {v0, v2}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v3, "screenshot_format"

    const-string v4, "AVIF"

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const/4 v3, 0x1

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    :cond_5
    return-void
.end method

.method private final readFormat(Lid/eska/screenshotwebp/MediaCategory;)Lid/eska/screenshotwebp/OutputFormat;
    .locals 3

    .line 183
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    invoke-direct {p0, p1}, Lid/eska/screenshotwebp/AppStateStore;->formatKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 185
    :try_start_0
    sget-object v1, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    check-cast p0, Lid/eska/screenshotwebp/AppStateStore;

    invoke-static {v0}, Lid/eska/screenshotwebp/OutputFormat;->valueOf(Ljava/lang/String;)Lid/eska/screenshotwebp/OutputFormat;

    move-result-object p0

    invoke-static {p0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception p0

    sget-object v0, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {p0}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object p0

    invoke-static {p0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    :goto_0
    invoke-static {p0}, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_1

    :cond_0
    move-object v2, p0

    :goto_1
    check-cast v2, Lid/eska/screenshotwebp/OutputFormat;

    if-eqz v2, :cond_1

    goto :goto_2

    .line 186
    :cond_1
    sget-object p0, Lid/eska/screenshotwebp/CategoryConfig;->Companion:Lid/eska/screenshotwebp/CategoryConfig$Companion;

    invoke-virtual {p0, p1}, Lid/eska/screenshotwebp/CategoryConfig$Companion;->defaults(Lid/eska/screenshotwebp/MediaCategory;)Lid/eska/screenshotwebp/CategoryConfig;

    move-result-object p0

    invoke-virtual {p0}, Lid/eska/screenshotwebp/CategoryConfig;->getFormat()Lid/eska/screenshotwebp/OutputFormat;

    move-result-object v2

    :goto_2
    return-object v2
.end method

.method public static synthetic recordSuccess$default(Lid/eska/screenshotwebp/AppStateStore;Lid/eska/screenshotwebp/MediaCategory;JJLid/eska/screenshotwebp/OutputFormat;ZZILjava/lang/Object;)V
    .locals 10

    and-int/lit8 v0, p9, 0x20

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    move v9, v0

    goto :goto_0

    :cond_0
    move/from16 v9, p8

    :goto_0
    move-object v1, p0

    move-object v2, p1

    move-wide v3, p2

    move-wide v5, p4

    move-object/from16 v7, p6

    move/from16 v8, p7

    .line 88
    invoke-virtual/range {v1 .. v9}, Lid/eska/screenshotwebp/AppStateStore;->recordSuccess(Lid/eska/screenshotwebp/MediaCategory;JJLid/eska/screenshotwebp/OutputFormat;ZZ)V

    return-void
.end method

.method private final resultKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;
    .locals 0

    .line 206
    sget-object p0, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    if-ne p1, p0, :cond_0

    const-string p0, "screenshot_result"

    return-object p0

    :cond_0
    const-string p0, "photo_result"

    return-object p0
.end method

.method private final savedKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;
    .locals 0

    .line 205
    sget-object p0, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    if-ne p1, p0, :cond_0

    const-string p0, "screenshot_saved"

    return-object p0

    :cond_0
    const-string p0, "photo_saved"

    return-object p0
.end method


# virtual methods
.method public final declared-synchronized activationEpochSeconds()Ljava/lang/Long;
    .locals 1

    monitor-enter p0

    .line 35
    :try_start_0
    sget-object v0, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    invoke-virtual {p0, v0}, Lid/eska/screenshotwebp/AppStateStore;->activationEpochSeconds(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/Long;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public final declared-synchronized activationEpochSeconds(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/Long;
    .locals 3

    monitor-enter p0

    :try_start_0
    const-string v0, "category"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 39
    invoke-direct {p0, p1}, Lid/eska/screenshotwebp/AppStateStore;->activationKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object p1

    .line 40
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    const-wide/16 v1, 0x0

    invoke-interface {v0, p1, v1, v2}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    :goto_0
    monitor-exit p0

    return-object p1

    :catchall_0
    move-exception p1

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p1
.end method

.method public final declared-synchronized categoryConfig(Lid/eska/screenshotwebp/MediaCategory;)Lid/eska/screenshotwebp/CategoryConfig;
    .locals 3

    monitor-enter p0

    :try_start_0
    const-string v0, "category"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 77
    new-instance v0, Lid/eska/screenshotwebp/CategoryConfig;

    .line 79
    invoke-virtual {p0, p1}, Lid/eska/screenshotwebp/AppStateStore;->activationEpochSeconds(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/Long;

    move-result-object v1

    .line 80
    invoke-direct {p0, p1}, Lid/eska/screenshotwebp/AppStateStore;->readFormat(Lid/eska/screenshotwebp/MediaCategory;)Lid/eska/screenshotwebp/OutputFormat;

    move-result-object v2

    .line 77
    invoke-direct {v0, p1, v1, v2}, Lid/eska/screenshotwebp/CategoryConfig;-><init>(Lid/eska/screenshotwebp/MediaCategory;Ljava/lang/Long;Lid/eska/screenshotwebp/OutputFormat;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 81
    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception p1

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p1
.end method

.method public final declared-synchronized format(Lid/eska/screenshotwebp/MediaCategory;)Lid/eska/screenshotwebp/OutputFormat;
    .locals 1

    monitor-enter p0

    :try_start_0
    const-string v0, "category"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 68
    invoke-direct {p0, p1}, Lid/eska/screenshotwebp/AppStateStore;->readFormat(Lid/eska/screenshotwebp/MediaCategory;)Lid/eska/screenshotwebp/OutputFormat;

    move-result-object p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object p1

    :catchall_0
    move-exception p1

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p1
.end method

.method public final declared-synchronized hasAnyActivation()Z
    .locals 3

    monitor-enter p0

    .line 150
    :try_start_0
    invoke-static {}, Lid/eska/screenshotwebp/MediaCategory;->getEntries()Lkotlin/enums/EnumEntries;

    move-result-object v0

    check-cast v0, Ljava/lang/Iterable;

    .line 235
    instance-of v1, v0, Ljava/util/Collection;

    const/4 v2, 0x0

    if-eqz v1, :cond_0

    move-object v1, v0

    check-cast v1, Ljava/util/Collection;

    invoke-interface {v1}, Ljava/util/Collection;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    goto :goto_0

    .line 236
    :cond_0
    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lid/eska/screenshotwebp/MediaCategory;

    .line 150
    invoke-virtual {p0, v1}, Lid/eska/screenshotwebp/AppStateStore;->activationEpochSeconds(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/Long;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_1

    const/4 v2, 0x1

    :cond_2
    :goto_0
    monitor-exit p0

    return v2

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public final declared-synchronized markActivated(J)V
    .locals 1

    monitor-enter p0

    .line 44
    :try_start_0
    sget-object v0, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    invoke-virtual {p0, v0, p1, p2}, Lid/eska/screenshotwebp/AppStateStore;->markCategoryActivated(Lid/eska/screenshotwebp/MediaCategory;J)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception p1

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p1
.end method

.method public final declared-synchronized markCategoryActivated(Lid/eska/screenshotwebp/MediaCategory;J)V
    .locals 2

    monitor-enter p0

    :try_start_0
    const-string v0, "category"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 48
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 49
    invoke-direct {p0, p1}, Lid/eska/screenshotwebp/AppStateStore;->activationKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p2, p3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 50
    invoke-direct {p0, p1}, Lid/eska/screenshotwebp/AppStateStore;->activationMarkerKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object p1

    invoke-interface {v0, p1, p2, p3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    .line 51
    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->apply()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 52
    monitor-exit p0

    return-void

    :catchall_0
    move-exception p1

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p1
.end method

.method public final declared-synchronized recordFailure(Lid/eska/screenshotwebp/MediaCategory;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    monitor-enter p0

    :try_start_0
    const-string v0, "category"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "path"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "message"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 114
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-direct {p0, p1}, Lid/eska/screenshotwebp/AppStateStore;->errorKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object p1

    const/16 v1, 0x2f

    const/4 v2, 0x2

    const/4 v3, 0x0

    invoke-static {p2, v1, v3, v2, v3}, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String;CLjava/lang/String;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    const-string v1, ": "

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->apply()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 115
    monitor-exit p0

    return-void

    :catchall_0
    move-exception p1

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p1
.end method

.method public final declared-synchronized recordFailure(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    monitor-enter p0

    :try_start_0
    const-string v0, "path"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "message"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 110
    sget-object v0, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    invoke-virtual {p0, v0, p1, p2}, Lid/eska/screenshotwebp/AppStateStore;->recordFailure(Lid/eska/screenshotwebp/MediaCategory;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception p1

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p1
.end method

.method public final declared-synchronized recordSuccess(JJ)V
    .locals 12

    monitor-enter p0

    .line 85
    :try_start_0
    sget-object v2, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    sget-object v7, Lid/eska/screenshotwebp/OutputFormat;->WEBP:Lid/eska/screenshotwebp/OutputFormat;

    const/16 v10, 0x20

    const/4 v11, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    move-object v1, p0

    move-wide v3, p1

    move-wide v5, p3

    invoke-static/range {v1 .. v11}, Lid/eska/screenshotwebp/AppStateStore;->recordSuccess$default(Lid/eska/screenshotwebp/AppStateStore;Lid/eska/screenshotwebp/MediaCategory;JJLid/eska/screenshotwebp/OutputFormat;ZZILjava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    move-object p1, v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p1
.end method

.method public final declared-synchronized recordSuccess(Lid/eska/screenshotwebp/MediaCategory;JJLid/eska/screenshotwebp/OutputFormat;ZZ)V
    .locals 14

    move-wide/from16 v1, p2

    move-wide/from16 v3, p4

    monitor-enter p0

    :try_start_0
    const-string v0, "category"

    move-object v5, p1

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "format"

    move-object/from16 v6, p6

    invoke-static {v6, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 96
    invoke-direct/range {p0 .. p1}, Lid/eska/screenshotwebp/AppStateStore;->countKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object v0

    .line 97
    invoke-direct/range {p0 .. p1}, Lid/eska/screenshotwebp/AppStateStore;->savedKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object v7

    .line 98
    invoke-direct/range {p0 .. p1}, Lid/eska/screenshotwebp/AppStateStore;->resultKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object v8

    .line 99
    iget-object v9, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v9}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v9

    .line 100
    iget-object v10, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    const/4 v11, 0x0

    invoke-interface {v10, v0, v11}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v10

    add-int/lit8 v10, v10, 0x1

    invoke-interface {v9, v0, v10}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 101
    iget-object v9, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    const-wide/16 v12, 0x0

    invoke-interface {v9, v7, v12, v13}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v9

    sub-long v5, v1, v3

    invoke-static {v5, v6, v12, v13}, Lkotlin/ranges/RangesKt;->coerceAtLeast(JJ)J

    move-result-wide v5

    add-long/2addr v9, v5

    invoke-interface {v0, v7, v9, v10}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 102
    invoke-virtual/range {p6 .. p6}, Lid/eska/screenshotwebp/OutputFormat;->getLabel()Ljava/lang/String;

    move-result-object v5

    if-eqz p8, :cond_0

    const-string v6, ""

    goto :goto_0

    :cond_0
    const-string v6, " (target belum tercapai)"

    :goto_0
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v7, ": "

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " \u2192 "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " byte"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v8, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 103
    invoke-direct/range {p0 .. p1}, Lid/eska/screenshotwebp/AppStateStore;->errorKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object v1

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 104
    const-string v1, "fallback_count"

    iget-object v2, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    const-string v3, "fallback_count"

    invoke-interface {v2, v3, v11}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    add-int v2, v2, p7

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 105
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 106
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public final declared-synchronized setCategoryActive(Lid/eska/screenshotwebp/MediaCategory;Z)V
    .locals 5

    monitor-enter p0

    :try_start_0
    const-string v0, "category"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 56
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    if-eqz p2, :cond_0

    .line 58
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    const/16 p2, 0x3e8

    int-to-long v3, p2

    div-long/2addr v1, v3

    .line 59
    invoke-direct {p0, p1}, Lid/eska/screenshotwebp/AppStateStore;->activationKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object p2

    invoke-interface {v0, p2, v1, v2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object p2

    .line 60
    invoke-direct {p0, p1}, Lid/eska/screenshotwebp/AppStateStore;->activationMarkerKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object p1

    invoke-interface {p2, p1, v1, v2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    goto :goto_0

    .line 62
    :cond_0
    invoke-direct {p0, p1}, Lid/eska/screenshotwebp/AppStateStore;->activationKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object p1

    invoke-interface {v0, p1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 64
    :goto_0
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 65
    monitor-exit p0

    return-void

    :catchall_0
    move-exception p1

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p1
.end method

.method public final declared-synchronized setFormat(Lid/eska/screenshotwebp/MediaCategory;Lid/eska/screenshotwebp/OutputFormat;)V
    .locals 1

    monitor-enter p0

    :try_start_0
    const-string v0, "category"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "format"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 72
    iget-object v0, p0, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-direct {p0, p1}, Lid/eska/screenshotwebp/AppStateStore;->formatKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p2}, Lid/eska/screenshotwebp/OutputFormat;->name()Ljava/lang/String;

    move-result-object p2

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->apply()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 74
    monitor-exit p0

    return-void

    :catchall_0
    move-exception p1

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p1
.end method

.method public final declared-synchronized snapshot()Lid/eska/screenshotwebp/AppState;
    .locals 24

    move-object/from16 v1, p0

    monitor-enter p0

    .line 119
    :try_start_0
    sget-object v0, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    invoke-virtual {v1, v0}, Lid/eska/screenshotwebp/AppStateStore;->categoryConfig(Lid/eska/screenshotwebp/MediaCategory;)Lid/eska/screenshotwebp/CategoryConfig;

    move-result-object v9

    .line 120
    sget-object v0, Lid/eska/screenshotwebp/MediaCategory;->PHOTOS:Lid/eska/screenshotwebp/MediaCategory;

    invoke-virtual {v1, v0}, Lid/eska/screenshotwebp/AppStateStore;->categoryConfig(Lid/eska/screenshotwebp/MediaCategory;)Lid/eska/screenshotwebp/CategoryConfig;

    move-result-object v10

    .line 121
    iget-object v0, v1, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    sget-object v2, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    invoke-direct {v1, v2}, Lid/eska/screenshotwebp/AppStateStore;->countKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v11

    .line 122
    iget-object v0, v1, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    sget-object v2, Lid/eska/screenshotwebp/MediaCategory;->PHOTOS:Lid/eska/screenshotwebp/MediaCategory;

    invoke-direct {v1, v2}, Lid/eska/screenshotwebp/AppStateStore;->countKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v12

    .line 123
    iget-object v0, v1, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    sget-object v2, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    invoke-direct {v1, v2}, Lid/eska/screenshotwebp/AppStateStore;->savedKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object v2

    const-wide/16 v4, 0x0

    invoke-interface {v0, v2, v4, v5}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v13

    .line 124
    iget-object v0, v1, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    sget-object v2, Lid/eska/screenshotwebp/MediaCategory;->PHOTOS:Lid/eska/screenshotwebp/MediaCategory;

    invoke-direct {v1, v2}, Lid/eska/screenshotwebp/AppStateStore;->savedKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2, v4, v5}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v15

    .line 125
    iget-object v0, v1, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    sget-object v2, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    invoke-direct {v1, v2}, Lid/eska/screenshotwebp/AppStateStore;->resultKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object v2

    const-string v4, "Belum ada konversi"

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v0, "Belum ada konversi"

    :cond_0
    move-object/from16 v17, v0

    .line 126
    iget-object v0, v1, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    sget-object v2, Lid/eska/screenshotwebp/MediaCategory;->PHOTOS:Lid/eska/screenshotwebp/MediaCategory;

    invoke-direct {v1, v2}, Lid/eska/screenshotwebp/AppStateStore;->resultKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object v2

    const-string v4, "Belum ada konversi"

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    const-string v0, "Belum ada konversi"

    :cond_1
    move-object/from16 v18, v0

    .line 127
    iget-object v0, v1, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    sget-object v2, Lid/eska/screenshotwebp/MediaCategory;->SCREENSHOTS:Lid/eska/screenshotwebp/MediaCategory;

    invoke-direct {v1, v2}, Lid/eska/screenshotwebp/AppStateStore;->errorKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object v2

    const-string v4, ""

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_2

    const-string v0, ""

    :cond_2
    move-object/from16 v19, v0

    .line 128
    iget-object v0, v1, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    sget-object v2, Lid/eska/screenshotwebp/MediaCategory;->PHOTOS:Lid/eska/screenshotwebp/MediaCategory;

    invoke-direct {v1, v2}, Lid/eska/screenshotwebp/AppStateStore;->errorKey(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/String;

    move-result-object v2

    const-string v4, ""

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_3

    const-string v0, ""

    :cond_3
    move-object/from16 v20, v0

    .line 129
    new-instance v2, Lid/eska/screenshotwebp/AppState;

    .line 130
    invoke-virtual {v9}, Lid/eska/screenshotwebp/CategoryConfig;->getActivationEpochSeconds()Ljava/lang/Long;

    move-result-object v0

    add-int v4, v11, v12

    add-long v5, v13, v15

    if-lez v12, :cond_4

    move-object/from16 v7, v18

    goto :goto_0

    :cond_4
    move-object/from16 v7, v17

    .line 134
    :goto_0
    move-object/from16 v8, v20

    check-cast v8, Ljava/lang/CharSequence;

    invoke-static {v8}, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_5

    move-object/from16 v8, v20

    goto :goto_1

    :cond_5
    move-object/from16 v8, v19

    .line 145
    :goto_1
    iget-object v3, v1, Lid/eska/screenshotwebp/AppStateStore;->prefs:Landroid/content/SharedPreferences;

    move-object/from16 v22, v0

    const-string v0, "fallback_count"

    move-object/from16 v23, v2

    const/4 v2, 0x0

    invoke-interface {v3, v0, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v21

    move-object/from16 v3, v22

    move-object/from16 v2, v23

    .line 129
    invoke-direct/range {v2 .. v21}, Lid/eska/screenshotwebp/AppState;-><init>(Ljava/lang/Long;IJLjava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/CategoryConfig;Lid/eska/screenshotwebp/CategoryConfig;IIJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v2

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method
