package id.eska.screenshotwebp;

import android.os.FileObserver;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MediaMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t\u0012 \b\u0002\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010 \u001a\u00020\fJ\u0006\u0010!\u001a\u00020\fJ&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020&J\b\u0010)\u001a\u00020\fH\u0002J\u0018\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\nH\u0002J\u0018\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\nH\u0002J \u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\n2\u0006\u00100\u001a\u000201H\u0002J \u00102\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\n2\u0006\u00103\u001a\u000204H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0018\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u001a0\u001a \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u001c\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u001a0\u001a \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lid/eska/screenshotwebp/MediaMonitor;", "", "state", "Lid/eska/screenshotwebp/AppStateStore;", "converter", "Lid/eska/screenshotwebp/MediaConverter;", "screenshotConverter", "Lid/eska/screenshotwebp/ScreenshotMediaConverter;", "onSuccess", "Lkotlin/Function2;", "Lid/eska/screenshotwebp/MediaCategory;", "Lid/eska/screenshotwebp/ConversionResult;", "", "onFailure", "Lkotlin/Function3;", "Ljava/io/File;", "<init>", "(Lid/eska/screenshotwebp/AppStateStore;Lid/eska/screenshotwebp/MediaConverter;Lid/eska/screenshotwebp/ScreenshotMediaConverter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "scheduler", "Ljava/util/concurrent/ScheduledExecutorService;", "processor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "screenshotProcessor", "seen", "", "", "", "processingPaths", "observers", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/os/FileObserver;", "start", "stop", "accepts", "", "path", "modifiedEpochSeconds", "", "category", "activationEpochSeconds", "reconcile", "observeTree", "root", "shouldDescend", "directory", "enqueue", "source", "config", "Lid/eska/screenshotwebp/CategoryConfig;", "process", "requested", "Lid/eska/screenshotwebp/OutputFormat;", "Companion", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MediaMonitor {
    public static final int MAX_RETRIES = 1;
    public static final int SCREENSHOT_WORKER_COUNT = 1;
    public static final long STABILITY_DELAY_MS = 350;
    private static final String TAG = "TidyMonitor";
    private final MediaConverter converter;
    private final ConcurrentHashMap<String, FileObserver> observers;
    private final Function3<MediaCategory, File, ConversionResult, Unit> onFailure;
    private final Function2<MediaCategory, ConversionResult, Unit> onSuccess;
    private final Set<String> processingPaths;
    private final ExecutorService processor;
    private final ScheduledExecutorService scheduler;
    private final ScreenshotMediaConverter screenshotConverter;
    private final ExecutorService screenshotProcessor;
    private final Set<String> seen;
    private final AppStateStore state;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MediaMonitor.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaCategory.values().length];
            try {
                iArr[MediaCategory.SCREENSHOTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaCategory.PHOTOS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MediaMonitor(AppStateStore state, MediaConverter converter, ScreenshotMediaConverter screenshotConverter, Function2<? super MediaCategory, ? super ConversionResult, Unit> onSuccess, Function3<? super MediaCategory, ? super File, ? super ConversionResult, Unit> onFailure) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(screenshotConverter, "screenshotConverter");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        this.state = state;
        this.converter = converter;
        this.screenshotConverter = screenshotConverter;
        this.onSuccess = onSuccess;
        this.onFailure = onFailure;
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor(...)");
        this.scheduler = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        this.processor = Executors.newFixedThreadPool(2);
        this.screenshotProcessor = Executors.newSingleThreadExecutor();
        this.seen = Collections.synchronizedSet(new LinkedHashSet());
        this.processingPaths = Collections.synchronizedSet(new LinkedHashSet());
        this.observers = new ConcurrentHashMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ MediaMonitor(AppStateStore appStateStore, MediaConverter mediaConverter, ScreenshotMediaConverter screenshotMediaConverter, Function2 function2, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            screenshotMediaConverter = new ScreenshotMediaConverter(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }
        this(appStateStore, mediaConverter, screenshotMediaConverter, (i & 8) != 0 ? new Function2() { // from class: id.eska.screenshotwebp.MediaMonitor$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MediaMonitor._init_$lambda$0((MediaCategory) obj, (ConversionResult) obj2);
            }
        } : function2, (i & 16) != 0 ? new Function3() { // from class: id.eska.screenshotwebp.MediaMonitor$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MediaMonitor._init_$lambda$1((MediaCategory) obj, (File) obj2, (ConversionResult) obj3);
            }
        } : function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(MediaCategory mediaCategory, ConversionResult conversionResult) {
        Intrinsics.checkNotNullParameter(mediaCategory, "<unused var>");
        Intrinsics.checkNotNullParameter(conversionResult, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(MediaCategory mediaCategory, File file, ConversionResult conversionResult) {
        Intrinsics.checkNotNullParameter(mediaCategory, "<unused var>");
        Intrinsics.checkNotNullParameter(file, "<unused var>");
        Intrinsics.checkNotNullParameter(conversionResult, "<unused var>");
        return Unit.INSTANCE;
    }

    public final void start() {
        reconcile();
        this.scheduler.scheduleWithFixedDelay(new Runnable() { // from class: id.eska.screenshotwebp.MediaMonitor$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.reconcile();
            }
        }, 5L, 20L, TimeUnit.SECONDS);
    }

    public final void stop() {
        Collection<FileObserver> collectionValues = this.observers.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((FileObserver) it.next()).stopWatching();
        }
        this.observers.clear();
        this.scheduler.shutdownNow();
        this.processor.shutdownNow();
        this.screenshotProcessor.shutdownNow();
    }

    public final boolean accepts(File path, long modifiedEpochSeconds, MediaCategory category, long activationEpochSeconds) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(category, "category");
        if (PathPolicy.INSTANCE.categoryFor(path) == category) {
            return category == MediaCategory.SCREENSHOTS || modifiedEpochSeconds > activationEpochSeconds;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reconcile() {
        List<File> listListOf;
        EnumEntries<MediaCategory> entries = MediaCategory.getEntries();
        ArrayList<Pair> arrayList = new ArrayList();
        for (MediaCategory mediaCategory : entries) {
            CategoryConfig categoryConfig = this.state.categoryConfig(mediaCategory);
            if (!categoryConfig.getActive()) {
                categoryConfig = null;
            }
            Pair pair = categoryConfig != null ? TuplesKt.to(mediaCategory, categoryConfig) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        for (Pair pair2 : arrayList) {
            final MediaCategory mediaCategory2 = (MediaCategory) pair2.component1();
            CategoryConfig categoryConfig2 = (CategoryConfig) pair2.component2();
            int i = WhenMappings.$EnumSwitchMapping$0[mediaCategory2.ordinal()];
            if (i == 1) {
                listListOf = CollectionsKt.listOf(PathPolicy.INSTANCE.getScreenshotRoot());
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                listListOf = PathPolicy.INSTANCE.getPhotoRoots();
            }
            if (mediaCategory2 == MediaCategory.SCREENSHOTS) {
                listListOf = CollectionsKt.listOf(PathPolicy.INSTANCE.getStorageRoot());
            }
            for (File file : listListOf) {
                file.mkdirs();
                observeTree(file, mediaCategory2);
                Iterator it = SequencesKt.filter(FilesKt.walkTopDown(file).onEnter(new Function1() { // from class: id.eska.screenshotwebp.MediaMonitor$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(MediaMonitor.reconcile$lambda$1$0$0(this.f$0, mediaCategory2, (File) obj));
                    }
                }), new Function1() { // from class: id.eska.screenshotwebp.MediaMonitor$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(MediaMonitor.reconcile$lambda$1$0$1((File) obj));
                    }
                }).iterator();
                while (it.hasNext()) {
                    enqueue((File) it.next(), mediaCategory2, categoryConfig2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reconcile$lambda$1$0$0(MediaMonitor mediaMonitor, MediaCategory mediaCategory, File directory) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        return mediaMonitor.shouldDescend(directory, mediaCategory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reconcile$lambda$1$0$1(File it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.isFile();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [id.eska.screenshotwebp.MediaMonitor$observeTree$3$observer$1, java.lang.Object] */
    private final void observeTree(File root, final MediaCategory category) {
        if (root.isDirectory()) {
            for (final File file : SequencesKt.filter(FilesKt.walkTopDown(root).onEnter(new Function1() { // from class: id.eska.screenshotwebp.MediaMonitor$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(MediaMonitor.observeTree$lambda$0(this.f$0, category, (File) obj));
                }
            }), new Function1() { // from class: id.eska.screenshotwebp.MediaMonitor$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(MediaMonitor.observeTree$lambda$1((File) obj));
                }
            })) {
                String absolutePath = file.getAbsolutePath();
                if (!this.observers.containsKey(absolutePath)) {
                    ?? r2 = new FileObserver(file, this, category) { // from class: id.eska.screenshotwebp.MediaMonitor$observeTree$3$observer$1
                        final /* synthetic */ MediaCategory $category;
                        final /* synthetic */ File $directory;
                        final /* synthetic */ MediaMonitor this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(file, 392);
                            this.$directory = file;
                            this.this$0 = this;
                            this.$category = category;
                        }

                        @Override // android.os.FileObserver
                        public void onEvent(int event, String path) {
                            if (path == null) {
                                return;
                            }
                            File file2 = new File(this.$directory, path);
                            if (file2.isDirectory()) {
                                if ((event & 384) != 0) {
                                    this.this$0.reconcile();
                                }
                            } else if (MediaMonitor.INSTANCE.isCompletedFileEvent(event)) {
                                CategoryConfig categoryConfig = this.this$0.state.categoryConfig(this.$category);
                                if (categoryConfig.getActive()) {
                                    this.this$0.enqueue(file2, this.$category, categoryConfig);
                                }
                            }
                        }
                    };
                    this.observers.put(absolutePath, r2);
                    r2.startWatching();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean observeTree$lambda$0(MediaMonitor mediaMonitor, MediaCategory mediaCategory, File directory) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        return mediaMonitor.shouldDescend(directory, mediaCategory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean observeTree$lambda$1(File it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.isDirectory();
    }

    private final boolean shouldDescend(File directory, MediaCategory category) throws IOException {
        String name = directory.getName();
        Intrinsics.checkNotNull(name);
        if (StringsKt.startsWith$default(name, ".", false, 2, (Object) null)) {
            return false;
        }
        Set of = SetsKt.setOf((Object[]) new String[]{"android", "thumbnails", "cache", "caches"});
        String lowerCase = name.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (of.contains(lowerCase)) {
            return false;
        }
        String canonicalPath = directory.getCanonicalPath();
        String canonicalPath2 = PathPolicy.INSTANCE.getCameraRoot().getCanonicalPath();
        if (category == MediaCategory.SCREENSHOTS) {
            if (!Intrinsics.areEqual(canonicalPath, canonicalPath2)) {
                Intrinsics.checkNotNull(canonicalPath);
                if (StringsKt.startsWith$default(canonicalPath, canonicalPath2 + File.separator, false, 2, (Object) null)) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueue(final File source, final MediaCategory category, final CategoryConfig config) {
        Object objM6626constructorimpl;
        Object objM6626constructorimpl2;
        if (source.isFile()) {
            String name = source.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (StringsKt.startsWith$default(name, ".", false, 2, (Object) null)) {
                return;
            }
            long jLastModified = source.lastModified() / ((long) 1000);
            Long activationEpochSeconds = config.getActivationEpochSeconds();
            if (activationEpochSeconds == null || !accepts(source, jLastModified, category, activationEpochSeconds.longValue())) {
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                MediaMonitor mediaMonitor = this;
                objM6626constructorimpl = Result.m6626constructorimpl(category.name() + ":" + source.getCanonicalPath() + ":" + jLastModified + ":" + source.length() + ":" + config.getFormat().name());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM6626constructorimpl = Result.m6626constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m6632isFailureimpl(objM6626constructorimpl)) {
                objM6626constructorimpl = null;
            }
            final String str = (String) objM6626constructorimpl;
            if (str == null) {
                return;
            }
            try {
                Result.Companion companion3 = Result.INSTANCE;
                MediaMonitor mediaMonitor2 = this;
                objM6626constructorimpl2 = Result.m6626constructorimpl(source.getCanonicalPath());
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM6626constructorimpl2 = Result.m6626constructorimpl(ResultKt.createFailure(th2));
            }
            final String str2 = (String) (Result.m6632isFailureimpl(objM6626constructorimpl2) ? null : objM6626constructorimpl2);
            if (str2 == null) {
                return;
            }
            Set<String> processingPaths = this.processingPaths;
            Intrinsics.checkNotNullExpressionValue(processingPaths, "processingPaths");
            synchronized (processingPaths) {
                if (this.processingPaths.add(str2)) {
                    Unit unit = Unit.INSTANCE;
                    Set<String> seen = this.seen;
                    Intrinsics.checkNotNullExpressionValue(seen, "seen");
                    synchronized (seen) {
                        if (!this.seen.add(str)) {
                            this.processingPaths.remove(str2);
                        } else {
                            Unit unit2 = Unit.INSTANCE;
                            (category == MediaCategory.SCREENSHOTS ? this.screenshotProcessor : this.processor).execute(new Runnable() { // from class: id.eska.screenshotwebp.MediaMonitor$$ExternalSyntheticLambda4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    MediaMonitor.enqueue$lambda$4(category, config, source, this, str2, str);
                                }
                            });
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$4(MediaCategory mediaCategory, CategoryConfig categoryConfig, File file, MediaMonitor mediaMonitor, String str, String str2) {
        try {
            Log.d(TAG, "queued " + mediaCategory.name() + " " + categoryConfig.getFormat().name() + ": " + file.getName());
            mediaMonitor.process(file, mediaCategory, categoryConfig.getFormat());
        } finally {
            mediaMonitor.processingPaths.remove(str);
            mediaMonitor.seen.remove(str2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00f3  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [T] */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, id.eska.screenshotwebp.ConversionResult] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v5, types: [long] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void process(File source, MediaCategory category, OutputFormat requested) throws InterruptedException {
        ?? r5;
        ?? r6;
        Object objM6626constructorimpl;
        ConversionResult conversionResultConvert;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ConversionResult(ConversionResult.Status.FAILED, source.length(), 0L, category == MediaCategory.SCREENSHOTS ? CompressionPlanKt.SCREENSHOT_TARGET_BYTES : TargetPolicyKt.targetBucket(source.length()).getMaxBytes(), null, null, null, null, null, requested, requested, false, false, 6644, null);
        if (source.exists()) {
            long length = source.length();
            long jLastModified = source.lastModified();
            Thread.sleep(350L);
            if (length == source.length()) {
                ?? LastModified = source.lastModified();
                if (jLastModified != LastModified) {
                    r5 = source;
                } else {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        MediaMonitor mediaMonitor = this;
                        try {
                            if (category == MediaCategory.SCREENSHOTS) {
                                File file = source;
                                conversionResultConvert = this.screenshotConverter.convert(file, requested);
                                LastModified = file;
                            } else {
                                File file2 = source;
                                conversionResultConvert = this.converter.convert(file2, requested);
                                LastModified = file2;
                            }
                            objM6626constructorimpl = Result.m6626constructorimpl(conversionResultConvert);
                            r6 = LastModified;
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.INSTANCE;
                            objM6626constructorimpl = Result.m6626constructorimpl(ResultKt.createFailure(th));
                            r6 = LastModified;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        LastModified = source;
                    }
                    Throwable thM6629exceptionOrNullimpl = Result.m6629exceptionOrNullimpl(objM6626constructorimpl);
                    ?? Copy$default = objM6626constructorimpl;
                    if (thM6629exceptionOrNullimpl != null) {
                        ConversionResult conversionResult = (ConversionResult) objectRef.element;
                        String message = thM6629exceptionOrNullimpl.getMessage();
                        if (message == null) {
                            message = thM6629exceptionOrNullimpl.getClass().getSimpleName();
                        }
                        Copy$default = ConversionResult.copy$default(conversionResult, null, 0L, 0L, 0L, null, null, null, null, message, null, null, false, false, 7935, null);
                    }
                    objectRef.element = Copy$default;
                    r5 = r6;
                    if (((ConversionResult) objectRef.element).getStatus() == ConversionResult.Status.SUCCESS) {
                        this.onSuccess.invoke(category, objectRef.element);
                        return;
                    }
                }
            } else {
                r5 = source;
            }
            Log.w(TAG, "failed " + category.name() + " " + requested.name() + ": " + r5.getName() + ": " + ((ConversionResult) objectRef.element).getMessage());
            this.onFailure.invoke(category, r5, objectRef.element);
        }
    }

    /* JADX INFO: compiled from: MediaMonitor.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lid/eska/screenshotwebp/MediaMonitor$Companion;", "", "<init>", "()V", "SCREENSHOT_WORKER_COUNT", "", "MAX_RETRIES", "STABILITY_DELAY_MS", "", "TAG", "", "isCompletedFileEvent", "", NotificationCompat.CATEGORY_EVENT, "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isCompletedFileEvent(int event) {
            return (event & 136) != 0;
        }

        private Companion() {
        }
    }
}
