package id.eska.screenshotwebp;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0004"}, d2 = {"formatBytes", "", "bytes", "", "app_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MainActivityKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatBytes(long j) {
        if (j >= 1048576) {
            String str = String.format("%.1f MB", Arrays.copyOf(new Object[]{Float.valueOf(j / 1048576.0f)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        if (j >= 1024) {
            String str2 = String.format("%.0f KB", Arrays.copyOf(new Object[]{Float.valueOf(j / 1024.0f)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            return str2;
        }
        return j + " B";
    }
}
