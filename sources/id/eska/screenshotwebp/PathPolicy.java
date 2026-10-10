package id.eska.screenshotwebp;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PathPolicy.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0016\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0014\u0010\u001a\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lid/eska/screenshotwebp/PathPolicy;", "", "<init>", "()V", "storageRoot", "Ljava/io/File;", "getStorageRoot", "()Ljava/io/File;", "screenshotRoot", "getScreenshotRoot", "cameraRoot", "getCameraRoot", "photoRoots", "", "getPhotoRoots", "()Ljava/util/List;", "inputExtensions", "", "", "technicalDirectoryNames", "isInputImage", "", "file", "categoryFor", "Lid/eska/screenshotwebp/MediaCategory;", "hasHiddenOrTechnicalParent", "isDescendantOf", "root", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PathPolicy {
    public static final int $stable;
    private static final File cameraRoot;
    private static final Set<String> inputExtensions;
    private static final List<File> photoRoots;
    private static final Set<String> technicalDirectoryNames;
    public static final PathPolicy INSTANCE = new PathPolicy();
    private static final File storageRoot = new File("/sdcard");
    private static final File screenshotRoot = new File("/sdcard/DCIM/Screenshots");

    private PathPolicy() {
    }

    static {
        File file = new File("/sdcard/DCIM/Camera");
        cameraRoot = file;
        photoRoots = CollectionsKt.listOf(file);
        inputExtensions = SetsKt.setOf((Object[]) new String[]{"jpg", "jpeg", "png"});
        technicalDirectoryNames = SetsKt.setOf((Object[]) new String[]{"android", "thumbnails", "cache", "caches", ".thumbnails"});
        $stable = 8;
    }

    public final File getStorageRoot() {
        return storageRoot;
    }

    public final File getScreenshotRoot() {
        return screenshotRoot;
    }

    public final File getCameraRoot() {
        return cameraRoot;
    }

    public final List<File> getPhotoRoots() {
        return photoRoots;
    }

    public final boolean isInputImage(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (!StringsKt.startsWith$default(name, ".", false, 2, (Object) null)) {
            Set<String> set = inputExtensions;
            String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (set.contains(lowerCase)) {
                return true;
            }
        }
        return false;
    }

    public final MediaCategory categoryFor(File file) {
        Object objM6626constructorimpl;
        Object objM6626constructorimpl2;
        Object objM6626constructorimpl3;
        Intrinsics.checkNotNullParameter(file, "file");
        if (!isInputImage(file)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            PathPolicy pathPolicy = this;
            objM6626constructorimpl = Result.m6626constructorimpl(file.getCanonicalFile());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM6626constructorimpl = Result.m6626constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m6632isFailureimpl(objM6626constructorimpl)) {
            objM6626constructorimpl = null;
        }
        File file2 = (File) objM6626constructorimpl;
        if (file2 == null || hasHiddenOrTechnicalParent(file2)) {
            return null;
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            PathPolicy pathPolicy2 = this;
            objM6626constructorimpl2 = Result.m6626constructorimpl(storageRoot.getCanonicalFile());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM6626constructorimpl2 = Result.m6626constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6632isFailureimpl(objM6626constructorimpl2)) {
            objM6626constructorimpl2 = null;
        }
        File file3 = (File) objM6626constructorimpl2;
        if (file3 == null) {
            return null;
        }
        try {
            Result.Companion companion5 = Result.INSTANCE;
            PathPolicy pathPolicy3 = this;
            objM6626constructorimpl3 = Result.m6626constructorimpl(cameraRoot.getCanonicalFile());
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.INSTANCE;
            objM6626constructorimpl3 = Result.m6626constructorimpl(ResultKt.createFailure(th3));
        }
        if (Result.m6632isFailureimpl(objM6626constructorimpl3)) {
            objM6626constructorimpl3 = null;
        }
        File file4 = (File) objM6626constructorimpl3;
        if (file4 != null && isDescendantOf(file2, file3)) {
            return isDescendantOf(file2, file4) ? MediaCategory.PHOTOS : MediaCategory.SCREENSHOTS;
        }
        return null;
    }

    private final boolean hasHiddenOrTechnicalParent(File file) {
        for (File parentFile = file.getParentFile(); parentFile != null && !Intrinsics.areEqual(parentFile.getPath(), "/"); parentFile = parentFile.getParentFile()) {
            String name = parentFile.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            String lowerCase = name.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (StringsKt.startsWith$default(lowerCase, ".", false, 2, (Object) null) || technicalDirectoryNames.contains(lowerCase)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isDescendantOf(File file, File file2) {
        String path = file2.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        String str = StringsKt.trimEnd(path, '/') + "/";
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
        return StringsKt.startsWith$default(StringsKt.trimEnd(path2, '/') + "/", str, false, 2, (Object) null);
    }
}
