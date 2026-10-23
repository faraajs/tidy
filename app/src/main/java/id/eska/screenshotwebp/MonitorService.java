package id.eska.screenshotwebp;

import android.content.Context;
import android.os.Environment;
import android.os.UserManager;

/** Compatibility entry points now schedule batches; there is no continuous service. */
public final class MonitorService {
    public static boolean isRunning() { return NightBatchJobService.isRunning(); }

    public static void start(Context context) {
        NightBatchScheduler.schedule(context.getApplicationContext(), false);
    }

    public static void stop(Context context) {
        new AppStateStore(context).setMonitoringRequested(false);
        NightBatchScheduler.cancel(context);
    }

    static String unavailableReason(Context context, AppStateStore state) {
        if (!state.monitoringRequested()) return "Night batch is paused.";
        if (!state.config(MediaCategory.SCREENSHOTS).enabled
                && !state.config(MediaCategory.PHOTOS).enabled) return "Enable Screenshot or Photos.";
        UserManager users = context.getSystemService(UserManager.class);
        if (users != null && !users.isUserUnlocked()) return "Waiting for unlocked storage.";
        if (!Environment.isExternalStorageManager()) return "All files access is required.";
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) return "Waiting for writable storage.";
        return null;
    }
}
