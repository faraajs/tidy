package id.eska.screenshotwebp;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenshotConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b,\b\u0087\b\u0018\u00002\u00020\u0001:\u0001>B\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00100\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00104\u001a\u00020\u0010HÆ\u0003J\t\u00105\u001a\u00020\u0010HÆ\u0003J\t\u00106\u001a\u00020\u0013HÆ\u0003J\t\u00107\u001a\u00020\u0013HÆ\u0003J\u009a\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013HÆ\u0001¢\u0006\u0002\u00109J\u0014\u0010:\u001a\u00020\u00132\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010<\u001a\u00020\tHÖ\u0081\u0004J\n\u0010=\u001a\u00020\fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)¨\u0006?"}, d2 = {"Lid/eska/screenshotwebp/ConversionResult;", "", NotificationCompat.CATEGORY_STATUS, "Lid/eska/screenshotwebp/ConversionResult$Status;", "sourceBytes", "", "outputBytes", "targetBytes", "width", "", "height", "sourcePath", "", "destinationPath", "message", "requestedFormat", "Lid/eska/screenshotwebp/OutputFormat;", "actualFormat", "usedFallback", "", "targetMet", "<init>", "(Lid/eska/screenshotwebp/ConversionResult$Status;JJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/OutputFormat;Lid/eska/screenshotwebp/OutputFormat;ZZ)V", "getStatus", "()Lid/eska/screenshotwebp/ConversionResult$Status;", "getSourceBytes", "()J", "getOutputBytes", "getTargetBytes", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getSourcePath", "()Ljava/lang/String;", "getDestinationPath", "getMessage", "getRequestedFormat", "()Lid/eska/screenshotwebp/OutputFormat;", "getActualFormat", "getUsedFallback", "()Z", "getTargetMet", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Lid/eska/screenshotwebp/ConversionResult$Status;JJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/eska/screenshotwebp/OutputFormat;Lid/eska/screenshotwebp/OutputFormat;ZZ)Lid/eska/screenshotwebp/ConversionResult;", "equals", "other", "hashCode", "toString", "Status", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ConversionResult {
    public static final int $stable = 0;
    private final OutputFormat actualFormat;
    private final String destinationPath;
    private final Integer height;
    private final String message;
    private final long outputBytes;
    private final OutputFormat requestedFormat;
    private final long sourceBytes;
    private final String sourcePath;
    private final Status status;
    private final long targetBytes;
    private final boolean targetMet;
    private final boolean usedFallback;
    private final Integer width;

    /* JADX INFO: compiled from: ScreenshotConverter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lid/eska/screenshotwebp/ConversionResult$Status;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "EXISTING_OUTPUT", "FAILED", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum Status {
        SUCCESS,
        EXISTING_OUTPUT,
        FAILED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }
    }

    public static /* synthetic */ ConversionResult copy$default(ConversionResult conversionResult, Status status, long j, long j2, long j3, Integer num, Integer num2, String str, String str2, String str3, OutputFormat outputFormat, OutputFormat outputFormat2, boolean z, boolean z2, int i, Object obj) {
        Status status2 = (i & 1) != 0 ? conversionResult.status : status;
        return conversionResult.copy(status2, (i & 2) != 0 ? conversionResult.sourceBytes : j, (i & 4) != 0 ? conversionResult.outputBytes : j2, (i & 8) != 0 ? conversionResult.targetBytes : j3, (i & 16) != 0 ? conversionResult.width : num, (i & 32) != 0 ? conversionResult.height : num2, (i & 64) != 0 ? conversionResult.sourcePath : str, (i & 128) != 0 ? conversionResult.destinationPath : str2, (i & 256) != 0 ? conversionResult.message : str3, (i & 512) != 0 ? conversionResult.requestedFormat : outputFormat, (i & 1024) != 0 ? conversionResult.actualFormat : outputFormat2, (i & 2048) != 0 ? conversionResult.usedFallback : z, (i & 4096) != 0 ? conversionResult.targetMet : z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final OutputFormat getRequestedFormat() {
        return this.requestedFormat;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final OutputFormat getActualFormat() {
        return this.actualFormat;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getUsedFallback() {
        return this.usedFallback;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getTargetMet() {
        return this.targetMet;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getSourceBytes() {
        return this.sourceBytes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getOutputBytes() {
        return this.outputBytes;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getTargetBytes() {
        return this.targetBytes;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSourcePath() {
        return this.sourcePath;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDestinationPath() {
        return this.destinationPath;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final ConversionResult copy(Status status, long sourceBytes, long outputBytes, long targetBytes, Integer width, Integer height, String sourcePath, String destinationPath, String message, OutputFormat requestedFormat, OutputFormat actualFormat, boolean usedFallback, boolean targetMet) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(requestedFormat, "requestedFormat");
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        return new ConversionResult(status, sourceBytes, outputBytes, targetBytes, width, height, sourcePath, destinationPath, message, requestedFormat, actualFormat, usedFallback, targetMet);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversionResult)) {
            return false;
        }
        ConversionResult conversionResult = (ConversionResult) other;
        return this.status == conversionResult.status && this.sourceBytes == conversionResult.sourceBytes && this.outputBytes == conversionResult.outputBytes && this.targetBytes == conversionResult.targetBytes && Intrinsics.areEqual(this.width, conversionResult.width) && Intrinsics.areEqual(this.height, conversionResult.height) && Intrinsics.areEqual(this.sourcePath, conversionResult.sourcePath) && Intrinsics.areEqual(this.destinationPath, conversionResult.destinationPath) && Intrinsics.areEqual(this.message, conversionResult.message) && this.requestedFormat == conversionResult.requestedFormat && this.actualFormat == conversionResult.actualFormat && this.usedFallback == conversionResult.usedFallback && this.targetMet == conversionResult.targetMet;
    }

    public int hashCode() {
        int iHashCode = ((((((this.status.hashCode() * 31) + Long.hashCode(this.sourceBytes)) * 31) + Long.hashCode(this.outputBytes)) * 31) + Long.hashCode(this.targetBytes)) * 31;
        Integer num = this.width;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.height;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.sourcePath;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.destinationPath;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.message;
        return ((((((((iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.requestedFormat.hashCode()) * 31) + this.actualFormat.hashCode()) * 31) + Boolean.hashCode(this.usedFallback)) * 31) + Boolean.hashCode(this.targetMet);
    }

    public String toString() {
        return "ConversionResult(status=" + this.status + ", sourceBytes=" + this.sourceBytes + ", outputBytes=" + this.outputBytes + ", targetBytes=" + this.targetBytes + ", width=" + this.width + ", height=" + this.height + ", sourcePath=" + this.sourcePath + ", destinationPath=" + this.destinationPath + ", message=" + this.message + ", requestedFormat=" + this.requestedFormat + ", actualFormat=" + this.actualFormat + ", usedFallback=" + this.usedFallback + ", targetMet=" + this.targetMet + ")";
    }

    public ConversionResult(Status status, long j, long j2, long j3, Integer num, Integer num2, String str, String str2, String str3, OutputFormat requestedFormat, OutputFormat actualFormat, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(requestedFormat, "requestedFormat");
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        this.status = status;
        this.sourceBytes = j;
        this.outputBytes = j2;
        this.targetBytes = j3;
        this.width = num;
        this.height = num2;
        this.sourcePath = str;
        this.destinationPath = str2;
        this.message = str3;
        this.requestedFormat = requestedFormat;
        this.actualFormat = actualFormat;
        this.usedFallback = z;
        this.targetMet = z2;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final long getSourceBytes() {
        return this.sourceBytes;
    }

    public final long getOutputBytes() {
        return this.outputBytes;
    }

    public final long getTargetBytes() {
        return this.targetBytes;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getSourcePath() {
        return this.sourcePath;
    }

    public final String getDestinationPath() {
        return this.destinationPath;
    }

    public final String getMessage() {
        return this.message;
    }

    public /* synthetic */ ConversionResult(Status status, long j, long j2, long j3, Integer num, Integer num2, String str, String str2, String str3, OutputFormat outputFormat, OutputFormat outputFormat2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(status, j, (i & 4) != 0 ? 0L : j2, j3, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : str, (i & 128) != 0 ? null : str2, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? OutputFormat.WEBP : outputFormat, (i & 1024) != 0 ? OutputFormat.WEBP : outputFormat2, (i & 2048) != 0 ? false : z, (i & 4096) != 0 ? false : z2);
    }

    public final OutputFormat getRequestedFormat() {
        return this.requestedFormat;
    }

    public final OutputFormat getActualFormat() {
        return this.actualFormat;
    }

    public final boolean getUsedFallback() {
        return this.usedFallback;
    }

    public final boolean getTargetMet() {
        return this.targetMet;
    }
}
