package id.eska.screenshotwebp;

import kotlin.Metadata;

/* JADX INFO: compiled from: CompressionPlan.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lid/eska/screenshotwebp/CompressionCandidate;", "", "quality", "", "scale", "", "<init>", "(IF)V", "getQuality", "()I", "getScale", "()F", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CompressionCandidate {
    public static final int $stable = 0;
    private final int quality;
    private final float scale;

    public static /* synthetic */ CompressionCandidate copy$default(CompressionCandidate compressionCandidate, int i, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = compressionCandidate.quality;
        }
        if ((i2 & 2) != 0) {
            f = compressionCandidate.scale;
        }
        return compressionCandidate.copy(i, f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getQuality() {
        return this.quality;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getScale() {
        return this.scale;
    }

    public final CompressionCandidate copy(int quality, float scale) {
        return new CompressionCandidate(quality, scale);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompressionCandidate)) {
            return false;
        }
        CompressionCandidate compressionCandidate = (CompressionCandidate) other;
        return this.quality == compressionCandidate.quality && Float.compare(this.scale, compressionCandidate.scale) == 0;
    }

    public int hashCode() {
        return (Integer.hashCode(this.quality) * 31) + Float.hashCode(this.scale);
    }

    public String toString() {
        return "CompressionCandidate(quality=" + this.quality + ", scale=" + this.scale + ")";
    }

    public CompressionCandidate(int i, float f) {
        this.quality = i;
        this.scale = f;
    }

    public final int getQuality() {
        return this.quality;
    }

    public final float getScale() {
        return this.scale;
    }
}
