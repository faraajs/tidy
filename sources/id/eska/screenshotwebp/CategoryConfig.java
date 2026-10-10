package id.eska.screenshotwebp;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J.\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lid/eska/screenshotwebp/CategoryConfig;", "", "category", "Lid/eska/screenshotwebp/MediaCategory;", "activationEpochSeconds", "", "format", "Lid/eska/screenshotwebp/OutputFormat;", "<init>", "(Lid/eska/screenshotwebp/MediaCategory;Ljava/lang/Long;Lid/eska/screenshotwebp/OutputFormat;)V", "getCategory", "()Lid/eska/screenshotwebp/MediaCategory;", "getActivationEpochSeconds", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFormat", "()Lid/eska/screenshotwebp/OutputFormat;", "active", "", "getActive", "()Z", "component1", "component2", "component3", "copy", "(Lid/eska/screenshotwebp/MediaCategory;Ljava/lang/Long;Lid/eska/screenshotwebp/OutputFormat;)Lid/eska/screenshotwebp/CategoryConfig;", "equals", "other", "hashCode", "", "toString", "", "Companion", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CategoryConfig {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long activationEpochSeconds;
    private final MediaCategory category;
    private final OutputFormat format;

    public static /* synthetic */ CategoryConfig copy$default(CategoryConfig categoryConfig, MediaCategory mediaCategory, Long l, OutputFormat outputFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            mediaCategory = categoryConfig.category;
        }
        if ((i & 2) != 0) {
            l = categoryConfig.activationEpochSeconds;
        }
        if ((i & 4) != 0) {
            outputFormat = categoryConfig.format;
        }
        return categoryConfig.copy(mediaCategory, l, outputFormat);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MediaCategory getCategory() {
        return this.category;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getActivationEpochSeconds() {
        return this.activationEpochSeconds;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final OutputFormat getFormat() {
        return this.format;
    }

    public final CategoryConfig copy(MediaCategory category, Long activationEpochSeconds, OutputFormat format) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(format, "format");
        return new CategoryConfig(category, activationEpochSeconds, format);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CategoryConfig)) {
            return false;
        }
        CategoryConfig categoryConfig = (CategoryConfig) other;
        return this.category == categoryConfig.category && Intrinsics.areEqual(this.activationEpochSeconds, categoryConfig.activationEpochSeconds) && this.format == categoryConfig.format;
    }

    public int hashCode() {
        int iHashCode = this.category.hashCode() * 31;
        Long l = this.activationEpochSeconds;
        return ((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + this.format.hashCode();
    }

    public String toString() {
        return "CategoryConfig(category=" + this.category + ", activationEpochSeconds=" + this.activationEpochSeconds + ", format=" + this.format + ")";
    }

    public CategoryConfig(MediaCategory category, Long l, OutputFormat format) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(format, "format");
        this.category = category;
        this.activationEpochSeconds = l;
        this.format = format;
    }

    public final MediaCategory getCategory() {
        return this.category;
    }

    public final Long getActivationEpochSeconds() {
        return this.activationEpochSeconds;
    }

    public final OutputFormat getFormat() {
        return this.format;
    }

    public final boolean getActive() {
        return this.activationEpochSeconds != null;
    }

    /* JADX INFO: compiled from: MediaModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lid/eska/screenshotwebp/CategoryConfig$Companion;", "", "<init>", "()V", "defaults", "Lid/eska/screenshotwebp/CategoryConfig;", "category", "Lid/eska/screenshotwebp/MediaCategory;", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CategoryConfig defaults(MediaCategory category) {
            Intrinsics.checkNotNullParameter(category, "category");
            return new CategoryConfig(category, null, OutputFormat.AVIF);
        }
    }
}
