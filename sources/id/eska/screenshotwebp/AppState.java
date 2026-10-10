package id.eska.screenshotwebp;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppStateStore.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\bHÆ\u0003J\t\u0010>\u001a\u00020\bHÆ\u0003J\t\u0010?\u001a\u00020\bHÆ\u0003J\t\u0010@\u001a\u00020\bHÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J°\u0001\u0010B\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010CJ\u0014\u0010D\u001a\u00020/2\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010F\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010G\u001a\u00020\bHÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0011\u0010\u0012\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0011\u0010\u0014\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0011\u0010.\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u0006H"}, d2 = {"Lid/eska/screenshotwebp/AppState;", "", "activationEpochSeconds", "", "processedCount", "", "savedBytes", "lastResult", "", "lastError", "screenshot", "Lid/eska/screenshotwebp/CategoryConfig;", "photos", "screenshotCount", "photoCount", "screenshotSavedBytes", "photoSavedBytes", "screenshotLastResult", "photoLastResult", "screenshotLastError", "photoLastError", "fallbackCount", "<init>", "(Ljava/lang/Long;IJLjava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/CategoryConfig;Lid/eska/screenshotwebp/CategoryConfig;IIJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getActivationEpochSeconds", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getProcessedCount", "()I", "getSavedBytes", "()J", "getLastResult", "()Ljava/lang/String;", "getLastError", "getScreenshot", "()Lid/eska/screenshotwebp/CategoryConfig;", "getPhotos", "getScreenshotCount", "getPhotoCount", "getScreenshotSavedBytes", "getPhotoSavedBytes", "getScreenshotLastResult", "getPhotoLastResult", "getScreenshotLastError", "getPhotoLastError", "getFallbackCount", "anyActive", "", "getAnyActive", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/Long;IJLjava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/CategoryConfig;Lid/eska/screenshotwebp/CategoryConfig;IIJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lid/eska/screenshotwebp/AppState;", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class AppState {
    public static final int $stable = 0;
    private final Long activationEpochSeconds;
    private final int fallbackCount;
    private final String lastError;
    private final String lastResult;
    private final int photoCount;
    private final String photoLastError;
    private final String photoLastResult;
    private final long photoSavedBytes;
    private final CategoryConfig photos;
    private final int processedCount;
    private final long savedBytes;
    private final CategoryConfig screenshot;
    private final int screenshotCount;
    private final String screenshotLastError;
    private final String screenshotLastResult;
    private final long screenshotSavedBytes;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getActivationEpochSeconds() {
        return this.activationEpochSeconds;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getScreenshotSavedBytes() {
        return this.screenshotSavedBytes;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getPhotoSavedBytes() {
        return this.photoSavedBytes;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getScreenshotLastResult() {
        return this.screenshotLastResult;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getPhotoLastResult() {
        return this.photoLastResult;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getScreenshotLastError() {
        return this.screenshotLastError;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getPhotoLastError() {
        return this.photoLastError;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getFallbackCount() {
        return this.fallbackCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getProcessedCount() {
        return this.processedCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSavedBytes() {
        return this.savedBytes;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLastResult() {
        return this.lastResult;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLastError() {
        return this.lastError;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final CategoryConfig getScreenshot() {
        return this.screenshot;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final CategoryConfig getPhotos() {
        return this.photos;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getScreenshotCount() {
        return this.screenshotCount;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getPhotoCount() {
        return this.photoCount;
    }

    public final AppState copy(Long activationEpochSeconds, int processedCount, long savedBytes, String lastResult, String lastError, CategoryConfig screenshot, CategoryConfig photos, int screenshotCount, int photoCount, long screenshotSavedBytes, long photoSavedBytes, String screenshotLastResult, String photoLastResult, String screenshotLastError, String photoLastError, int fallbackCount) {
        Intrinsics.checkNotNullParameter(lastResult, "lastResult");
        Intrinsics.checkNotNullParameter(lastError, "lastError");
        Intrinsics.checkNotNullParameter(screenshot, "screenshot");
        Intrinsics.checkNotNullParameter(photos, "photos");
        Intrinsics.checkNotNullParameter(screenshotLastResult, "screenshotLastResult");
        Intrinsics.checkNotNullParameter(photoLastResult, "photoLastResult");
        Intrinsics.checkNotNullParameter(screenshotLastError, "screenshotLastError");
        Intrinsics.checkNotNullParameter(photoLastError, "photoLastError");
        return new AppState(activationEpochSeconds, processedCount, savedBytes, lastResult, lastError, screenshot, photos, screenshotCount, photoCount, screenshotSavedBytes, photoSavedBytes, screenshotLastResult, photoLastResult, screenshotLastError, photoLastError, fallbackCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppState)) {
            return false;
        }
        AppState appState = (AppState) other;
        return Intrinsics.areEqual(this.activationEpochSeconds, appState.activationEpochSeconds) && this.processedCount == appState.processedCount && this.savedBytes == appState.savedBytes && Intrinsics.areEqual(this.lastResult, appState.lastResult) && Intrinsics.areEqual(this.lastError, appState.lastError) && Intrinsics.areEqual(this.screenshot, appState.screenshot) && Intrinsics.areEqual(this.photos, appState.photos) && this.screenshotCount == appState.screenshotCount && this.photoCount == appState.photoCount && this.screenshotSavedBytes == appState.screenshotSavedBytes && this.photoSavedBytes == appState.photoSavedBytes && Intrinsics.areEqual(this.screenshotLastResult, appState.screenshotLastResult) && Intrinsics.areEqual(this.photoLastResult, appState.photoLastResult) && Intrinsics.areEqual(this.screenshotLastError, appState.screenshotLastError) && Intrinsics.areEqual(this.photoLastError, appState.photoLastError) && this.fallbackCount == appState.fallbackCount;
    }

    public int hashCode() {
        Long l = this.activationEpochSeconds;
        return ((((((((((((((((((((((((((((((l == null ? 0 : l.hashCode()) * 31) + Integer.hashCode(this.processedCount)) * 31) + Long.hashCode(this.savedBytes)) * 31) + this.lastResult.hashCode()) * 31) + this.lastError.hashCode()) * 31) + this.screenshot.hashCode()) * 31) + this.photos.hashCode()) * 31) + Integer.hashCode(this.screenshotCount)) * 31) + Integer.hashCode(this.photoCount)) * 31) + Long.hashCode(this.screenshotSavedBytes)) * 31) + Long.hashCode(this.photoSavedBytes)) * 31) + this.screenshotLastResult.hashCode()) * 31) + this.photoLastResult.hashCode()) * 31) + this.screenshotLastError.hashCode()) * 31) + this.photoLastError.hashCode()) * 31) + Integer.hashCode(this.fallbackCount);
    }

    public String toString() {
        return "AppState(activationEpochSeconds=" + this.activationEpochSeconds + ", processedCount=" + this.processedCount + ", savedBytes=" + this.savedBytes + ", lastResult=" + this.lastResult + ", lastError=" + this.lastError + ", screenshot=" + this.screenshot + ", photos=" + this.photos + ", screenshotCount=" + this.screenshotCount + ", photoCount=" + this.photoCount + ", screenshotSavedBytes=" + this.screenshotSavedBytes + ", photoSavedBytes=" + this.photoSavedBytes + ", screenshotLastResult=" + this.screenshotLastResult + ", photoLastResult=" + this.photoLastResult + ", screenshotLastError=" + this.screenshotLastError + ", photoLastError=" + this.photoLastError + ", fallbackCount=" + this.fallbackCount + ")";
    }

    public AppState(Long l, int i, long j, String lastResult, String lastError, CategoryConfig screenshot, CategoryConfig photos, int i2, int i3, long j2, long j3, String screenshotLastResult, String photoLastResult, String screenshotLastError, String photoLastError, int i4) {
        Intrinsics.checkNotNullParameter(lastResult, "lastResult");
        Intrinsics.checkNotNullParameter(lastError, "lastError");
        Intrinsics.checkNotNullParameter(screenshot, "screenshot");
        Intrinsics.checkNotNullParameter(photos, "photos");
        Intrinsics.checkNotNullParameter(screenshotLastResult, "screenshotLastResult");
        Intrinsics.checkNotNullParameter(photoLastResult, "photoLastResult");
        Intrinsics.checkNotNullParameter(screenshotLastError, "screenshotLastError");
        Intrinsics.checkNotNullParameter(photoLastError, "photoLastError");
        this.activationEpochSeconds = l;
        this.processedCount = i;
        this.savedBytes = j;
        this.lastResult = lastResult;
        this.lastError = lastError;
        this.screenshot = screenshot;
        this.photos = photos;
        this.screenshotCount = i2;
        this.photoCount = i3;
        this.screenshotSavedBytes = j2;
        this.photoSavedBytes = j3;
        this.screenshotLastResult = screenshotLastResult;
        this.photoLastResult = photoLastResult;
        this.screenshotLastError = screenshotLastError;
        this.photoLastError = photoLastError;
        this.fallbackCount = i4;
    }

    public final Long getActivationEpochSeconds() {
        return this.activationEpochSeconds;
    }

    public final int getProcessedCount() {
        return this.processedCount;
    }

    public final long getSavedBytes() {
        return this.savedBytes;
    }

    public final String getLastResult() {
        return this.lastResult;
    }

    public final String getLastError() {
        return this.lastError;
    }

    public /* synthetic */ AppState(Long l, int i, long j, String str, String str2, CategoryConfig categoryConfig, CategoryConfig categoryConfig2, int i2, int i3, long j2, long j3, String str3, String str4, String str5, String str6, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, i, j, str, str2, (i5 & 32) != 0 ? CategoryConfig.INSTANCE.defaults(MediaCategory.SCREENSHOTS) : categoryConfig, (i5 & 64) != 0 ? CategoryConfig.INSTANCE.defaults(MediaCategory.PHOTOS) : categoryConfig2, (i5 & 128) != 0 ? i : i2, (i5 & 256) != 0 ? 0 : i3, (i5 & 512) != 0 ? j : j2, (i5 & 1024) != 0 ? 0L : j3, (i5 & 2048) != 0 ? str : str3, (i5 & 4096) != 0 ? "Belum ada konversi" : str4, (i5 & 8192) != 0 ? str2 : str5, (i5 & 16384) != 0 ? "" : str6, (i5 & 32768) != 0 ? 0 : i4);
    }

    public final CategoryConfig getScreenshot() {
        return this.screenshot;
    }

    public final CategoryConfig getPhotos() {
        return this.photos;
    }

    public final int getScreenshotCount() {
        return this.screenshotCount;
    }

    public final int getPhotoCount() {
        return this.photoCount;
    }

    public final long getScreenshotSavedBytes() {
        return this.screenshotSavedBytes;
    }

    public final long getPhotoSavedBytes() {
        return this.photoSavedBytes;
    }

    public final String getScreenshotLastResult() {
        return this.screenshotLastResult;
    }

    public final String getPhotoLastResult() {
        return this.photoLastResult;
    }

    public final String getScreenshotLastError() {
        return this.screenshotLastError;
    }

    public final String getPhotoLastError() {
        return this.photoLastError;
    }

    public final int getFallbackCount() {
        return this.fallbackCount;
    }

    public final boolean getAnyActive() {
        return this.screenshot.getActive() || this.photos.getActive();
    }
}
