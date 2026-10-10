package id.eska.screenshotwebp;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"fallbackFormat", "Lid/eska/screenshotwebp/OutputFormat;", "requested", "screenshotFormat", "selected", "app_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MediaModelKt {

    /* JADX INFO: compiled from: MediaModel.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OutputFormat.values().length];
            try {
                iArr[OutputFormat.WEBP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OutputFormat.AVIF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final OutputFormat fallbackFormat(OutputFormat requested) {
        Intrinsics.checkNotNullParameter(requested, "requested");
        int i = WhenMappings.$EnumSwitchMapping$0[requested.ordinal()];
        if (i == 1) {
            return OutputFormat.AVIF;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return OutputFormat.WEBP;
    }

    public static final OutputFormat screenshotFormat(OutputFormat selected) {
        Intrinsics.checkNotNullParameter(selected, "selected");
        return OutputFormat.AVIF;
    }
}
