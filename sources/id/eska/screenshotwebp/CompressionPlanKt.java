package id.eska.screenshotwebp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: CompressionPlan.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u001a\u0006\u0010\u0007\u001a\u00020\b\u001a\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u001a\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u001a\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u001a \u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"SCREENSHOT_QUALITY", "", "SCREENSHOT_TARGET_BYTES", "", "screenshotOutputOrder", "", "Lid/eska/screenshotwebp/OutputFormat;", "screenshotScale", "", "compressionScales", "initialQualityCandidates", "compressionCandidates", "Lid/eska/screenshotwebp/CompressionCandidate;", "sampleSizeFor", "width", "height", "maxLongEdge", "app_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CompressionPlanKt {
    public static final int SCREENSHOT_QUALITY = 55;
    public static final long SCREENSHOT_TARGET_BYTES = 102400;

    public static final float screenshotScale() {
        return 1.0f;
    }

    public static final List<OutputFormat> screenshotOutputOrder() {
        return CollectionsKt.listOf((Object[]) new OutputFormat[]{OutputFormat.AVIF, OutputFormat.WEBP});
    }

    public static final List<Float> compressionScales() {
        return CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(1.0f), Float.valueOf(0.75f), Float.valueOf(0.5f), Float.valueOf(0.25f)});
    }

    public static final List<Integer> initialQualityCandidates() {
        return CollectionsKt.listOf((Object[]) new Integer[]{85, 55, 25});
    }

    public static final List<CompressionCandidate> compressionCandidates() {
        List<Float> listCompressionScales = compressionScales();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listCompressionScales.iterator();
        while (it.hasNext()) {
            float fFloatValue = ((Number) it.next()).floatValue();
            List<Integer> listInitialQualityCandidates = initialQualityCandidates();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listInitialQualityCandidates, 10));
            Iterator<T> it2 = listInitialQualityCandidates.iterator();
            while (it2.hasNext()) {
                arrayList2.add(new CompressionCandidate(((Number) it2.next()).intValue(), fFloatValue));
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        return arrayList;
    }

    public static /* synthetic */ int sampleSizeFor$default(int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2560;
        }
        return sampleSizeFor(i, i2, i3);
    }

    public static final int sampleSizeFor(int i, int i2, int i3) {
        int i4 = 1;
        while (Math.max(i, i2) / i4 > i3) {
            i4 *= 2;
        }
        return i4;
    }
}
