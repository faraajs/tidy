package id.eska.screenshotwebp;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.UserManager;

/** Monitoring requested by the user; Android may still stop the process. */
public final class MonitorService extends Service {
    private static final String CHANNEL = "tidy_monitoring";
    private static final int NOTIFICATION_ID = 230;
    private static volatile boolean running;
    private static volatile MonitorService activeInstance;
    private final Handler main = new Handler(Looper.getMainLooper());
    private AppStateStore store;
    private MediaMonitor monitor;
    private volatile boolean destroyed;
    private boolean notificationScheduled;

    public static boolean isRunning() {
        return running;
    }

    public static void start(Context context) {
        Context app = context.getApplicationContext();
        AppStateStore state;
        try {
            state = new AppStateStore(app);
            String unavailable = unavailableReason(app, state);
            if (unavailable != null) {
                if (state.monitoringRequested()) reportStartFailure(app, state, unavailable);
                return;
            }
        } catch (RuntimeException failure) {
            reportStartFailure(app, null, "Monitoring cannot load saved consent. Open Tidy and check storage.");
            return;
        }
        try {
            app.startForegroundService(new Intent(app, MonitorService.class));
        } catch (RuntimeException failure) {
            reportStartFailure(app, state,
                    "Android did not allow background monitoring to start. Open Tidy and press Start monitoring.");
        }
    }

    public static void stop(Context context) {
        Context app = context.getApplicationContext();
        // Persist first: queued work and converters recheck this before changing sources.
        try {
            new AppStateStore(app).setMonitoringRequested(false);
        } catch (RuntimeException failure) {
            reportStartFailure(app, null, "Monitoring could not save pause state. Check available app storage.");
        }
        running = false;
        try {
            app.stopService(new Intent(app, MonitorService.class));
        } catch (RuntimeException failure) {
            reportStartFailure(app, null,
                    "Android could not immediately close monitoring. Open Tidy and check pause state.");
        }
    }

    static String unavailableReason(Context context, AppStateStore state) {
        if (!state.monitoringRequested()) return "Monitoring is paused.";
        if (!state.config(MediaCategory.SCREENSHOTS).enabled
                && !state.config(MediaCategory.PHOTOS).enabled) {
            return "Enable Screenshot or Photos before starting monitoring.";
        }
        UserManager users = context.getSystemService(UserManager.class);
        if (users != null && !users.isUserUnlocked()) {
            return "Monitoring is waiting for the device to be unlocked.";
        }
        if (!Environment.isExternalStorageManager()) {
            return "Monitoring needs All files access. Open Tidy to grant access.";
        }
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return "Monitoring is waiting for writable shared storage.";
        }
        return null;
    }

    private static void reportStartFailure(Context context, AppStateStore state, String message) {
        try {
            if (state != null) state.recordFailure(null, message);
        } catch (RuntimeException ignored) {
            // A full/unavailable preferences volume cannot safely persist a consent change.
        }
        try {
            notifySafely(context, notification(context, "Monitoring could not start", message));
        } catch (RuntimeException ignored) {
            // Android can deny notifications as well as background starts.
        }
    }

    private static void createChannel(Context context) {
        NotificationManager manager = context.getSystemService(NotificationManager.class);
        if (manager != null) {
            NotificationChannel channel = new NotificationChannel(CHANNEL, "Tidy monitoring",
                    NotificationManager.IMPORTANCE_LOW);
            channel.setDescription("User-enabled local Screenshot and Photos folder monitoring");
            manager.createNotificationChannel(channel);
        }
    }

    private static Notification notification(Context context, String title, String text) {
        createChannel(context);
        Intent open = new Intent(context, MainActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent content = PendingIntent.getActivity(context, 0, open,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        return new Notification.Builder(context, CHANNEL)
                .setSmallIcon(android.R.drawable.stat_notify_sync)
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(new Notification.BigTextStyle().bigText(text))
                .setContentIntent(content)
                .setCategory(Notification.CATEGORY_SERVICE)
                .setOnlyAlertOnce(true)
                .setOngoing(true)
                .setShowWhen(false)
                .build();
    }

    private static void notifySafely(Context context, Notification notification) {
        if (Build.VERSION.SDK_INT >= 33
                && context.checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) return;
        try {
            NotificationManager manager = context.getSystemService(NotificationManager.class);
            if (manager != null) manager.notify(NOTIFICATION_ID, notification);
        } catch (RuntimeException ignored) {
            // Local state still exposes the error when notifications are blocked by Android.
        }
    }

    @Override public void onCreate() {
        super.onCreate();
        try {
            store = new AppStateStore(this);
        } catch (RuntimeException failure) {
            reportStartFailure(this, null, "Monitoring cannot load saved consent. Check available app storage.");
        }
        activeInstance = this;
    }

    @Override public int onStartCommand(Intent intent, int flags, int startId) {
        // This also gates null START_STICKY and redelivered intents: an Intent is not consent.
        String unavailable = store == null ? "Monitoring cannot load saved consent."
                : unavailableReason(this, store);
        try {
            Notification initial = notification(this, "Tidy monitoring",
                    unavailable == null ? "Watching selected folders for new images" : unavailable);
            if (Build.VERSION.SDK_INT >= 34) {
                startForeground(NOTIFICATION_ID, initial,
                        ServiceInfo.FOREGROUND_SERVICE_TYPE_SPECIAL_USE);
            } else {
                startForeground(NOTIFICATION_ID, initial);
            }
        } catch (RuntimeException failure) {
            running = false;
            reportStartFailure(this, store, "Android could not show the required foreground service notification.");
            stopSelf();
            return START_NOT_STICKY;
        }
        if (unavailable != null) {
            running = false;
            if (store != null && store.monitoringRequested()) {
                reportStartFailure(this, store, unavailable);
            }
            if (monitor != null) {
                monitor.close();
                monitor = null;
            }
            stopForeground(STOP_FOREGROUND_REMOVE);
            stopSelf();
            return START_NOT_STICKY;
        }
        if (monitor == null) {
            monitor = new MediaMonitor(this, store, new MediaMonitor.Callback() {
                @Override public void onProgress(int pending, int processing) {
                    MonitorService current = activeInstance;
                    if (current != null && current != MonitorService.this) {
                        current.main.post(() -> {
                            if (!current.destroyed && current.monitor != null) {
                                current.monitor.refreshProgress();
                            }
                        });
                        return;
                    }
                    store.setProgress(pending, processing);
                    requestNotification();
                }

                @Override public void onResult(MediaConverter.Result result) {
                    store.recordSuccess(result);
                    requestNotification();
                }

                @Override public void onError(MediaCategory category, String message) {
                    store.recordFailure(category, message);
                    requestNotification();
                }
            });
        }
        running = true;
        monitor.start();
        requestNotification();
        return START_STICKY;
    }

    private void requestNotification() {
        // Coalesce filesystem bursts on the service thread; never call dashboard Views.
        main.post(() -> {
            if (destroyed || notificationScheduled) return;
            notificationScheduled = true;
            main.postDelayed(this::updateNotification, 250);
        });
    }

    private void updateNotification() {
        notificationScheduled = false;
        if (destroyed) return;
        String unavailable = unavailableReason(this, store);
        if (unavailable != null) {
            running = false;
            if (store.monitoringRequested()) reportStartFailure(this, store, unavailable);
            if (monitor != null) {
                monitor.close();
                monitor = null;
            }
            stopForeground(STOP_FOREGROUND_REMOVE);
            stopSelf();
            return;
        }
        AppStateStore.Snapshot snapshot = store.snapshot();
        String text = snapshot.pending + " pending · " + snapshot.processing + " processing"
                + " · " + (snapshot.screenshotCount + snapshot.photoCount) + " converted";
        if (snapshot.lastError != null && !snapshot.lastError.isEmpty()) {
            text += "\nLast error: " + snapshot.lastError;
        } else if (snapshot.lastResult != null && !snapshot.lastResult.isEmpty()) {
            text += "\n" + snapshot.lastResult;
        }
        notifySafely(this, notification(this, "Tidy monitoring", text));
    }

    @Override public void onDestroy() {
        destroyed = true;
        running = false;
        main.removeCallbacksAndMessages(null);
        if (monitor != null) {
            // Graceful worker shutdown: no interruption during output publication/restoration.
            monitor.close();
            monitor = null;
        }
        if (activeInstance == this) activeInstance = null;
        stopForeground(STOP_FOREGROUND_REMOVE);
        super.onDestroy();
    }

    @Override public IBinder onBind(Intent intent) {
        return null;
    }
}
