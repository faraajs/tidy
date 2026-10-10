package id.eska.screenshotwebp;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AppStateStore.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0015\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\nJ\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u0018\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nJ8\u0010\u001b\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00152\b\b\u0002\u0010\u001f\u001a\u00020\u0015J\u0016\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"J\u001e\u0010 \u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\u0015J\b\u0010'\u001a\u00020\u0010H\u0002J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010)\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010*\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010+\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010,\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010-\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010.\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010/\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lid/eska/screenshotwebp/AppStateStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "activationEpochSeconds", "", "()Ljava/lang/Long;", "category", "Lid/eska/screenshotwebp/MediaCategory;", "(Lid/eska/screenshotwebp/MediaCategory;)Ljava/lang/Long;", "markActivated", "", "epochSeconds", "markCategoryActivated", "setCategoryActive", "active", "", "format", "Lid/eska/screenshotwebp/OutputFormat;", "setFormat", "categoryConfig", "Lid/eska/screenshotwebp/CategoryConfig;", "recordSuccess", "sourceBytes", "outputBytes", "fallback", "targetMet", "recordFailure", "path", "", "message", "snapshot", "Lid/eska/screenshotwebp/AppState;", "hasAnyActivation", "migrateLegacyState", "readFormat", "activationKey", "activationMarkerKey", "formatKey", "countKey", "savedKey", "resultKey", "errorKey", "Companion", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AppStateStore {

    @Deprecated
    public static final String KEY_ACTIVATION = "activation";

    @Deprecated
    public static final String KEY_COUNT = "count";

    @Deprecated
    public static final String KEY_ERROR = "error";

    @Deprecated
    public static final String KEY_FALLBACKS = "fallback_count";

    @Deprecated
    public static final String KEY_PHOTO_ACTIVATION = "photo_activation";

    @Deprecated
    public static final String KEY_PHOTO_BASELINE = "photo_baseline";

    @Deprecated
    public static final String KEY_PHOTO_COUNT = "photo_count";

    @Deprecated
    public static final String KEY_PHOTO_ERROR = "photo_error";

    @Deprecated
    public static final String KEY_PHOTO_FORMAT = "photo_format";

    @Deprecated
    public static final String KEY_PHOTO_RESULT = "photo_result";

    @Deprecated
    public static final String KEY_PHOTO_SAVED = "photo_saved";

    @Deprecated
    public static final String KEY_RESULT = "result";

    @Deprecated
    public static final String KEY_SAVED = "saved";

    @Deprecated
    public static final String KEY_SCREENSHOT_ACTIVATION = "screenshot_activation";

    @Deprecated
    public static final String KEY_SCREENSHOT_BASELINE = "screenshot_baseline";

    @Deprecated
    public static final String KEY_SCREENSHOT_COUNT = "screenshot_count";

    @Deprecated
    public static final String KEY_SCREENSHOT_ERROR = "screenshot_error";

    @Deprecated
    public static final String KEY_SCREENSHOT_FORMAT = "screenshot_format";

    @Deprecated
    public static final String KEY_SCREENSHOT_RESULT = "screenshot_result";

    @Deprecated
    public static final String KEY_SCREENSHOT_SAVED = "screenshot_saved";
    private final SharedPreferences prefs;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: AppStateStore.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaCategory.values().length];
            try {
                iArr[MediaCategory.SCREENSHOTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaCategory.PHOTOS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AppStateStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.prefs = context.createDeviceProtectedStorageContext().getSharedPreferences("state", 0);
        migrateLegacyState();
    }

    public final synchronized Long activationEpochSeconds() {
        return activationEpochSeconds(MediaCategory.SCREENSHOTS);
    }

    public final synchronized Long activationEpochSeconds(MediaCategory category) {
        String strActivationKey;
        Intrinsics.checkNotNullParameter(category, "category");
        strActivationKey = activationKey(category);
        return this.prefs.contains(strActivationKey) ? Long.valueOf(this.prefs.getLong(strActivationKey, 0L)) : null;
    }

    public final synchronized void markActivated(long epochSeconds) {
        markCategoryActivated(MediaCategory.SCREENSHOTS, epochSeconds);
    }

    public final synchronized void markCategoryActivated(MediaCategory category, long epochSeconds) {
        Intrinsics.checkNotNullParameter(category, "category");
        this.prefs.edit().putLong(activationKey(category), epochSeconds).putLong(activationMarkerKey(category), epochSeconds).apply();
    }

    public final synchronized void setCategoryActive(MediaCategory category, boolean active) {
        Intrinsics.checkNotNullParameter(category, "category");
        SharedPreferences.Editor editorEdit = this.prefs.edit();
        if (active) {
            long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
            editorEdit.putLong(activationKey(category), jCurrentTimeMillis).putLong(activationMarkerKey(category), jCurrentTimeMillis);
        } else {
            editorEdit.remove(activationKey(category));
        }
        editorEdit.apply();
    }

    public final synchronized OutputFormat format(MediaCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        return readFormat(category);
    }

    public final synchronized void setFormat(MediaCategory category, OutputFormat format) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(format, "format");
        this.prefs.edit().putString(formatKey(category), format.name()).apply();
    }

    public final synchronized CategoryConfig categoryConfig(MediaCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        return new CategoryConfig(category, activationEpochSeconds(category), readFormat(category));
    }

    public final synchronized void recordSuccess(long sourceBytes, long outputBytes) {
        recordSuccess$default(this, MediaCategory.SCREENSHOTS, sourceBytes, outputBytes, OutputFormat.WEBP, false, false, 32, null);
    }

    public static /* synthetic */ void recordSuccess$default(AppStateStore appStateStore, MediaCategory mediaCategory, long j, long j2, OutputFormat outputFormat, boolean z, boolean z2, int i, Object obj) {
        appStateStore.recordSuccess(mediaCategory, j, j2, outputFormat, z, (i & 32) != 0 ? true : z2);
    }

    public final synchronized void recordSuccess(MediaCategory category, long sourceBytes, long outputBytes, OutputFormat format, boolean fallback, boolean targetMet) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(format, "format");
        String strCountKey = countKey(category);
        String strSavedKey = savedKey(category);
        this.prefs.edit().putInt(strCountKey, this.prefs.getInt(strCountKey, 0) + 1).putLong(strSavedKey, this.prefs.getLong(strSavedKey, 0L) + RangesKt.coerceAtLeast(sourceBytes - outputBytes, 0L)).putString(resultKey(category), format.getLabel() + ": " + sourceBytes + " → " + outputBytes + " byte" + (targetMet ? "" : " (target belum tercapai)")).putString(errorKey(category), "").putInt(KEY_FALLBACKS, this.prefs.getInt(KEY_FALLBACKS, 0) + (fallback ? 1 : 0)).apply();
    }

    public final synchronized void recordFailure(String path, String message) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(message, "message");
        recordFailure(MediaCategory.SCREENSHOTS, path, message);
    }

    public final synchronized void recordFailure(MediaCategory category, String path, String message) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(message, "message");
        this.prefs.edit().putString(errorKey(category), StringsKt.substringAfterLast$default(path, '/', (String) null, 2, (Object) null) + ": " + message).apply();
    }

    public final synchronized AppState snapshot() {
        CategoryConfig categoryConfig;
        CategoryConfig categoryConfig2;
        int i;
        int i2;
        long j;
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        categoryConfig = categoryConfig(MediaCategory.SCREENSHOTS);
        categoryConfig2 = categoryConfig(MediaCategory.PHOTOS);
        i = this.prefs.getInt(countKey(MediaCategory.SCREENSHOTS), 0);
        i2 = this.prefs.getInt(countKey(MediaCategory.PHOTOS), 0);
        j = this.prefs.getLong(savedKey(MediaCategory.SCREENSHOTS), 0L);
        j2 = this.prefs.getLong(savedKey(MediaCategory.PHOTOS), 0L);
        String string = this.prefs.getString(resultKey(MediaCategory.SCREENSHOTS), "Belum ada konversi");
        if (string == null) {
            string = "Belum ada konversi";
        }
        str = string;
        String string2 = this.prefs.getString(resultKey(MediaCategory.PHOTOS), "Belum ada konversi");
        if (string2 == null) {
            string2 = "Belum ada konversi";
        }
        str2 = string2;
        String string3 = this.prefs.getString(errorKey(MediaCategory.SCREENSHOTS), "");
        if (string3 == null) {
            string3 = "";
        }
        str3 = string3;
        String string4 = this.prefs.getString(errorKey(MediaCategory.PHOTOS), "");
        if (string4 == null) {
            string4 = "";
        }
        str4 = string4;
        return new AppState(categoryConfig.getActivationEpochSeconds(), i + i2, j + j2, i2 > 0 ? str2 : str, !StringsKt.isBlank(str4) ? str4 : str3, categoryConfig, categoryConfig2, i, i2, j, j2, str, str2, str3, str4, this.prefs.getInt(KEY_FALLBACKS, 0));
    }

    public final synchronized boolean hasAnyActivation() {
        boolean z;
        EnumEntries<MediaCategory> entries = MediaCategory.getEntries();
        z = false;
        if (!(entries instanceof Collection) || !entries.isEmpty()) {
            Iterator<MediaCategory> it = entries.iterator();
            while (it.hasNext()) {
                if (activationEpochSeconds(it.next()) != null) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    private final void migrateLegacyState() {
        if (!this.prefs.contains(KEY_SCREENSHOT_ACTIVATION) && this.prefs.contains(KEY_ACTIVATION)) {
            this.prefs.edit().putLong(KEY_SCREENSHOT_ACTIVATION, this.prefs.getLong(KEY_ACTIVATION, 0L)).apply();
        }
        if (!this.prefs.contains(KEY_SCREENSHOT_COUNT) && this.prefs.contains(KEY_COUNT)) {
            this.prefs.edit().putInt(KEY_SCREENSHOT_COUNT, this.prefs.getInt(KEY_COUNT, 0)).putLong(KEY_SCREENSHOT_SAVED, this.prefs.getLong(KEY_SAVED, 0L)).putString(KEY_SCREENSHOT_RESULT, this.prefs.getString(KEY_RESULT, "Belum ada konversi")).putString(KEY_SCREENSHOT_ERROR, this.prefs.getString(KEY_ERROR, "")).apply();
        }
        if (!this.prefs.contains(KEY_SCREENSHOT_FORMAT)) {
            this.prefs.edit().putString(KEY_SCREENSHOT_FORMAT, "AVIF").apply();
        }
        if (this.prefs.contains(KEY_SCREENSHOT_ACTIVATION) && !this.prefs.contains(KEY_PHOTO_ACTIVATION)) {
            long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
            this.prefs.edit().putLong(KEY_PHOTO_ACTIVATION, jCurrentTimeMillis).putLong(KEY_PHOTO_BASELINE, jCurrentTimeMillis).putString(KEY_PHOTO_FORMAT, "AVIF").apply();
        }
        if (!this.prefs.contains(KEY_PHOTO_FORMAT)) {
            this.prefs.edit().putString(KEY_PHOTO_FORMAT, "AVIF").apply();
        }
        if (this.prefs.contains("screenshot_format_migration_v2")) {
            return;
        }
        this.prefs.edit().putString(KEY_SCREENSHOT_FORMAT, "AVIF").putBoolean("screenshot_format_migration_v2", true).apply();
    }

    private final OutputFormat readFormat(MediaCategory category) {
        Object objM6626constructorimpl;
        String string = this.prefs.getString(formatKey(category), null);
        if (string != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                AppStateStore appStateStore = this;
                objM6626constructorimpl = Result.m6626constructorimpl(OutputFormat.valueOf(string));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM6626constructorimpl = Result.m6626constructorimpl(ResultKt.createFailure(th));
            }
            OutputFormat outputFormat = (OutputFormat) (Result.m6632isFailureimpl(objM6626constructorimpl) ? null : objM6626constructorimpl);
            if (outputFormat != null) {
                return outputFormat;
            }
        }
        return CategoryConfig.INSTANCE.defaults(category).getFormat();
    }

    private final String activationKey(MediaCategory category) {
        int i = WhenMappings.$EnumSwitchMapping$0[category.ordinal()];
        if (i == 1) {
            return KEY_SCREENSHOT_ACTIVATION;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return KEY_PHOTO_ACTIVATION;
    }

    private final String activationMarkerKey(MediaCategory category) {
        int i = WhenMappings.$EnumSwitchMapping$0[category.ordinal()];
        if (i == 1) {
            return KEY_SCREENSHOT_BASELINE;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return KEY_PHOTO_BASELINE;
    }

    private final String formatKey(MediaCategory category) {
        int i = WhenMappings.$EnumSwitchMapping$0[category.ordinal()];
        if (i == 1) {
            return KEY_SCREENSHOT_FORMAT;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return KEY_PHOTO_FORMAT;
    }

    private final String countKey(MediaCategory category) {
        return category == MediaCategory.SCREENSHOTS ? KEY_SCREENSHOT_COUNT : KEY_PHOTO_COUNT;
    }

    private final String savedKey(MediaCategory category) {
        return category == MediaCategory.SCREENSHOTS ? KEY_SCREENSHOT_SAVED : KEY_PHOTO_SAVED;
    }

    private final String resultKey(MediaCategory category) {
        return category == MediaCategory.SCREENSHOTS ? KEY_SCREENSHOT_RESULT : KEY_PHOTO_RESULT;
    }

    private final String errorKey(MediaCategory category) {
        return category == MediaCategory.SCREENSHOTS ? KEY_SCREENSHOT_ERROR : KEY_PHOTO_ERROR;
    }

    /* JADX INFO: compiled from: AppStateStore.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lid/eska/screenshotwebp/AppStateStore$Companion;", "", "<init>", "()V", "KEY_ACTIVATION", "", "KEY_SCREENSHOT_ACTIVATION", "KEY_PHOTO_ACTIVATION", "KEY_SCREENSHOT_BASELINE", "KEY_PHOTO_BASELINE", "KEY_SCREENSHOT_FORMAT", "KEY_PHOTO_FORMAT", "KEY_SCREENSHOT_COUNT", "KEY_PHOTO_COUNT", "KEY_SCREENSHOT_SAVED", "KEY_PHOTO_SAVED", "KEY_SCREENSHOT_RESULT", "KEY_PHOTO_RESULT", "KEY_SCREENSHOT_ERROR", "KEY_PHOTO_ERROR", "KEY_FALLBACKS", "KEY_COUNT", "KEY_SAVED", "KEY_RESULT", "KEY_ERROR", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
