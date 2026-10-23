package id.eska.screenshotwebp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/** Restores a night schedule only; never starts a scan or continuous monitoring. */
public final class BootReceiver extends BroadcastReceiver {
    @Override public void onReceive(Context context, Intent intent) {
        if (intent == null) return;
        String action = intent.getAction();
        if (!Intent.ACTION_BOOT_COMPLETED.equals(action)
                && !Intent.ACTION_LOCKED_BOOT_COMPLETED.equals(action)
                && !Intent.ACTION_USER_UNLOCKED.equals(action)
                && !Intent.ACTION_MY_PACKAGE_REPLACED.equals(action)
                && !Intent.ACTION_TIME_CHANGED.equals(action)
                && !Intent.ACTION_TIMEZONE_CHANGED.equals(action)) return;
        try {
            NightBatchScheduler.schedule(context, true);
        } catch (RuntimeException failure) {
            // Retry unavailable storage on unlock or app open.
        }
    }
}
