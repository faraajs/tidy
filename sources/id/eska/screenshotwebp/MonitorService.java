package id.eska.screenshotwebp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.os.IBinder;
import androidx.core.content.ContextCompat;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MonitorService.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\"\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lid/eska/screenshotwebp/MonitorService;", "Landroid/app/Service;", "<init>", "()V", "state", "Lid/eska/screenshotwebp/AppStateStore;", "monitor", "Lid/eska/screenshotwebp/MediaMonitor;", "onCreate", "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "onDestroy", "onBind", "Landroid/os/IBinder;", "createNotificationChannel", "notification", "Landroid/app/Notification;", "Companion", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MonitorService extends Service {
    public static final String CHANNEL_ID = "screenshot_monitor";
    public static final int NOTIFICATION_ID = 4001;
    private MediaMonitor monitor;
    private AppStateStore state;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.state = new AppStateStore(this);
        createNotificationChannel();
        startForeground(NOTIFICATION_ID, notification());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        AppStateStore appStateStore;
        if (this.monitor != null) {
            return 1;
        }
        AppStateStore appStateStore2 = this.state;
        Function2 function2 = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (appStateStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("state");
            appStateStore2 = null;
        }
        if (!appStateStore2.hasAnyActivation() || !Environment.isExternalStorageManager()) {
            stopSelf();
            return 2;
        }
        AppStateStore appStateStore3 = this.state;
        if (appStateStore3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("state");
            appStateStore = null;
        } else {
            appStateStore = appStateStore3;
        }
        MediaMonitor mediaMonitor = new MediaMonitor(appStateStore, new MediaConverter(), new ScreenshotMediaConverter(function2, objArr2 == true ? 1 : 0, 3, objArr == true ? 1 : 0), new Function2() { // from class: id.eska.screenshotwebp.MonitorService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MonitorService.onStartCommand$lambda$0(this.f$0, (MediaCategory) obj, (ConversionResult) obj2);
            }
        }, new Function3() { // from class: id.eska.screenshotwebp.MonitorService$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MonitorService.onStartCommand$lambda$1(this.f$0, (MediaCategory) obj, (File) obj2, (ConversionResult) obj3);
            }
        });
        mediaMonitor.start();
        this.monitor = mediaMonitor;
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onStartCommand$lambda$0(MonitorService monitorService, MediaCategory category, ConversionResult result) {
        AppStateStore appStateStore;
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(result, "result");
        AppStateStore appStateStore2 = monitorService.state;
        if (appStateStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("state");
            appStateStore = null;
        } else {
            appStateStore = appStateStore2;
        }
        appStateStore.recordSuccess(category, result.getSourceBytes(), result.getOutputBytes(), result.getActualFormat(), result.getUsedFallback(), result.getTargetMet());
        String[] strArr = (String[]) CollectionsKt.listOfNotNull((Object[]) new String[]{result.getDestinationPath(), result.getSourcePath()}).toArray(new String[0]);
        if (!(strArr.length == 0)) {
            MediaScannerConnection.scanFile(monitorService, strArr, null, null);
        }
        ((NotificationManager) monitorService.getSystemService(NotificationManager.class)).notify(NOTIFICATION_ID, monitorService.notification());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onStartCommand$lambda$1(MonitorService monitorService, MediaCategory category, File source, ConversionResult result) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(result, "result");
        AppStateStore appStateStore = monitorService.state;
        if (appStateStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("state");
            appStateStore = null;
        }
        String path = source.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        String message = result.getMessage();
        if (message == null) {
            message = "Konversi gagal";
        }
        appStateStore.recordFailure(category, path, message);
        ((NotificationManager) monitorService.getSystemService(NotificationManager.class)).notify(NOTIFICATION_ID, monitorService.notification());
        return Unit.INSTANCE;
    }

    @Override // android.app.Service
    public void onDestroy() {
        MediaMonitor mediaMonitor = this.monitor;
        if (mediaMonitor != null) {
            mediaMonitor.stop();
        }
        this.monitor = null;
        super.onDestroy();
    }

    private final void createNotificationChannel() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, getString(R.string.notification_channel_name), 2);
        notificationChannel.setSound(null, null);
        notificationChannel.enableVibration(false);
        notificationChannel.enableLights(false);
        notificationManager.createNotificationChannel(notificationChannel);
    }

    private final Notification notification() {
        AppStateStore appStateStore = this.state;
        if (appStateStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("state");
            appStateStore = null;
        }
        AppState appStateSnapshot = appStateStore.snapshot();
        String str = appStateSnapshot.getProcessedCount() + " berhasil, hemat " + appStateSnapshot.getSavedBytes() + " byte";
        MonitorService monitorService = this;
        Notification notificationBuild = new Notification.Builder(monitorService, CHANNEL_ID).setSmallIcon(android.R.drawable.ic_menu_save).setContentTitle(getString(R.string.notification_active)).setContentText(str).setContentIntent(PendingIntent.getActivity(monitorService, 0, new Intent(monitorService, (Class<?>) MainActivity.class), 201326592)).setOngoing(true).setDefaults(0).setColor(-16776961).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        return notificationBuild;
    }

    /* JADX INFO: compiled from: MonitorService.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lid/eska/screenshotwebp/MonitorService$Companion;", "", "<init>", "()V", "CHANNEL_ID", "", "NOTIFICATION_ID", "", "shouldStartForState", "", "hasActivation", "hasExternalStorageAccess", "start", "", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean shouldStartForState(boolean hasActivation, boolean hasExternalStorageAccess) {
            return hasActivation && hasExternalStorageAccess;
        }

        private Companion() {
        }

        public final void start(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ContextCompat.startForegroundService(context, new Intent(context, (Class<?>) MonitorService.class));
        }
    }
}
