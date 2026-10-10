package id.eska.screenshotwebp;

import kotlin.Metadata;

/* JADX INFO: compiled from: TargetPolicy.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"targetBucket", "Lid/eska/screenshotwebp/TargetBucket;", "originalBytes", "", "app_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TargetPolicyKt {
    public static final TargetBucket targetBucket(long j) {
        if (j > 3145728) {
            return new TargetBucket(768000L);
        }
        if (j > 1048576) {
            return new TargetBucket(512000L);
        }
        if (j > 512000) {
            return new TargetBucket(256000L);
        }
        return new TargetBucket(CompressionPlanKt.SCREENSHOT_TARGET_BYTES);
    }
}
