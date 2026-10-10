package id.eska.screenshotwebp;

import android.os.FileObserver;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ScreenshotMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\tJ\u0006\u0010 \u001a\u00020\tJ\b\u0010!\u001a\u00020\tH\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\fH\u0002J\u0010\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0012\u001a&\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u0014 \u0015*\u0012\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u0014\u0018\u00010\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lid/eska/screenshotwebp/ScreenshotMonitor;", "", "activationEpochSeconds", "", "converter", "Lid/eska/screenshotwebp/ScreenshotConverter;", "onSuccess", "Lkotlin/Function1;", "Lid/eska/screenshotwebp/ConversionResult;", "", "onFailure", "Lkotlin/Function2;", "Ljava/io/File;", "<init>", "(JLid/eska/screenshotwebp/ScreenshotConverter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "root", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "seen", "", "", "kotlin.jvm.PlatformType", "", "observer", "Landroid/os/FileObserver;", "accepts", "", "path", "modifiedEpochSeconds", "retryLimit", "", "start", "stop", "reconcile", "enqueue", "source", "process", "Companion", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ScreenshotMonitor {
    public static final int MAX_RETRIES = 3;
    private final long activationEpochSeconds;
    private final ScreenshotConverter converter;
    private final ScheduledExecutorService executor;
    private FileObserver observer;
    private final Function2<File, ConversionResult, Unit> onFailure;
    private final Function1<ConversionResult, Unit> onSuccess;
    private final File root;
    private final Set<String> seen;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final File SCREENSHOT_DIR = new File("/sdcard/DCIM/Screenshots");

    public final int retryLimit() {
        return 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScreenshotMonitor(long j, ScreenshotConverter converter, Function1<? super ConversionResult, Unit> onSuccess, Function2<? super File, ? super ConversionResult, Unit> onFailure) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        this.activationEpochSeconds = j;
        this.converter = converter;
        this.onSuccess = onSuccess;
        this.onFailure = onFailure;
        this.root = SCREENSHOT_DIR;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(2);
        Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewScheduledThreadPool, "newScheduledThreadPool(...)");
        this.executor = scheduledExecutorServiceNewScheduledThreadPool;
        this.seen = Collections.synchronizedSet(new LinkedHashSet());
    }

    public /* synthetic */ ScreenshotMonitor(long j, ScreenshotConverter screenshotConverter, Function1 function1, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, screenshotConverter, (i & 4) != 0 ? new Function1() { // from class: id.eska.screenshotwebp.ScreenshotMonitor$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScreenshotMonitor._init_$lambda$0((ConversionResult) obj);
            }
        } : function1, (i & 8) != 0 ? new Function2() { // from class: id.eska.screenshotwebp.ScreenshotMonitor$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ScreenshotMonitor._init_$lambda$1((File) obj, (ConversionResult) obj2);
            }
        } : function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(ConversionResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(File file, ConversionResult conversionResult) {
        Intrinsics.checkNotNullParameter(file, "<unused var>");
        Intrinsics.checkNotNullParameter(conversionResult, "<unused var>");
        return Unit.INSTANCE;
    }

    public final boolean accepts(File path, long modifiedEpochSeconds) {
        Object objM6626constructorimpl;
        File parentFile;
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            Result.Companion companion = Result.INSTANCE;
            ScreenshotMonitor screenshotMonitor = this;
            objM6626constructorimpl = Result.m6626constructorimpl(path.getCanonicalFile());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM6626constructorimpl = Result.m6626constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m6632isFailureimpl(objM6626constructorimpl)) {
            objM6626constructorimpl = null;
        }
        File file = (File) objM6626constructorimpl;
        if (file == null || (parentFile = file.getParentFile()) == null || !Intrinsics.areEqual(parentFile, this.root.getCanonicalFile()) || modifiedEpochSeconds <= this.activationEpochSeconds) {
            return false;
        }
        Set of = SetsKt.setOf((Object[]) new String[]{"jpg", "jpeg"});
        String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return of.contains(lowerCase);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [id.eska.screenshotwebp.ScreenshotMonitor$start$1] */
    public final void start() {
        this.root.mkdirs();
        ?? r1 = new FileObserver(this.root) { // from class: id.eska.screenshotwebp.ScreenshotMonitor.start.1
            @Override // android.os.FileObserver
            public void onEvent(int event, String path) {
                if (path == null) {
                    return;
                }
                ScreenshotMonitor.this.enqueue(new File(ScreenshotMonitor.this.root, path));
            }
        };
        r1.startWatching();
        this.observer = (FileObserver) r1;
        reconcile();
        this.executor.scheduleWithFixedDelay(new Runnable() { // from class: id.eska.screenshotwebp.ScreenshotMonitor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.reconcile();
            }
        }, 5L, 30L, TimeUnit.SECONDS);
    }

    public final void stop() {
        FileObserver fileObserver = this.observer;
        if (fileObserver != null) {
            fileObserver.stopWatching();
        }
        this.observer = null;
        this.executor.shutdownNow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reconcile() {
        File[] fileArrListFiles = this.root.listFiles();
        if (fileArrListFiles != null) {
            ArrayList<File> arrayList = new ArrayList();
            for (File file : fileArrListFiles) {
                if (file.isFile()) {
                    arrayList.add(file);
                }
            }
            for (File file2 : arrayList) {
                Intrinsics.checkNotNull(file2);
                enqueue(file2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueue(final File source) {
        Object objM6626constructorimpl;
        long jLastModified = source.lastModified() / ((long) 1000);
        if (accepts(source, jLastModified)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                ScreenshotMonitor screenshotMonitor = this;
                objM6626constructorimpl = Result.m6626constructorimpl(source.getCanonicalPath() + ":" + jLastModified + ":" + source.length());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM6626constructorimpl = Result.m6626constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m6632isFailureimpl(objM6626constructorimpl)) {
                objM6626constructorimpl = null;
            }
            String str = (String) objM6626constructorimpl;
            if (str == null) {
                return;
            }
            Set<String> seen = this.seen;
            Intrinsics.checkNotNullExpressionValue(seen, "seen");
            synchronized (seen) {
                if (this.seen.add(str)) {
                    Unit unit = Unit.INSTANCE;
                    this.executor.execute(new Runnable() { // from class: id.eska.screenshotwebp.ScreenshotMonitor$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() throws InterruptedException {
                            this.f$0.process(source);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void process(File source) throws InterruptedException {
        File file = new File(source.getParentFile(), FilesKt.getNameWithoutExtension(source) + ".webp");
        ConversionResult conversionResult = new ConversionResult(ConversionResult.Status.FAILED, source.length(), 0L, TargetPolicyKt.targetBucket(source.length()).getMaxBytes(), null, null, null, null, null, null, null, false, false, 8180, null);
        for (int i = 0; i < 3; i++) {
            if (!source.exists()) {
                return;
            }
            long length = source.length();
            Thread.sleep(RangesKt.coerceAtMost(((long) i) * 500, 1000L));
            if (length == source.length()) {
                ConversionResult conversionResultConvert = this.converter.convert(source, file);
                if (conversionResultConvert.getStatus() == ConversionResult.Status.SUCCESS) {
                    this.onSuccess.invoke(conversionResultConvert);
                    return;
                }
                conversionResult = conversionResultConvert;
            }
        }
        this.onFailure.invoke(source, conversionResult);
    }

    /* JADX INFO: compiled from: ScreenshotMonitor.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lid/eska/screenshotwebp/ScreenshotMonitor$Companion;", "", "<init>", "()V", "MAX_RETRIES", "", "SCREENSHOT_DIR", "Ljava/io/File;", "getSCREENSHOT_DIR", "()Ljava/io/File;", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final File getSCREENSHOT_DIR() {
            return ScreenshotMonitor.SCREENSHOT_DIR;
        }
    }
}
