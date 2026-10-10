package id.eska.screenshotwebp;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: MediaModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lid/eska/screenshotwebp/MediaCategory;", "", "title", "", "shortTitle", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getShortTitle", "SCREENSHOTS", "PHOTOS", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum MediaCategory {
    SCREENSHOTS("Screenshot", "Screenshot"),
    PHOTOS("Foto", "Foto");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String shortTitle;
    private final String title;

    public static EnumEntries<MediaCategory> getEntries() {
        return $ENTRIES;
    }

    MediaCategory(String str, String str2) {
        this.title = str;
        this.shortTitle = str2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getShortTitle() {
        return this.shortTitle;
    }
}
