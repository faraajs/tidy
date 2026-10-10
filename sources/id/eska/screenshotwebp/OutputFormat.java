package id.eska.screenshotwebp;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: MediaModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lid/eska/screenshotwebp/OutputFormat;", "", "label", "", "extension", "mimeType", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getExtension", "getMimeType", "WEBP", "AVIF", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum OutputFormat {
    WEBP("WebP", "webp", "image/webp"),
    AVIF("AVIF", "avif", "image/avif");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String extension;
    private final String label;
    private final String mimeType;

    public static EnumEntries<OutputFormat> getEntries() {
        return $ENTRIES;
    }

    OutputFormat(String str, String str2, String str3) {
        this.label = str;
        this.extension = str2;
        this.mimeType = str3;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getExtension() {
        return this.extension;
    }

    public final String getMimeType() {
        return this.mimeType;
    }
}
