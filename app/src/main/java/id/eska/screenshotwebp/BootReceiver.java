package id.eska.screenshotwebp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/** Restores only explicitly requested monitoring, never enables categories or permissions. */
public final class BootReceiver extends BroadcastReceiver {
    @Override public void onReceive(Context context, Intent intent) {
        if (intent == null) return;
        String action = intent.getAction();
        if (!Intent.ACTION_BOOT_COMPLETED.equals(action)
                && !Intent.ACTION_LOCKED_BOOT_COMPLETED.equals(action)
                && !Intent.ACTION_USER_UNLOCKED.equals(action)
                && !Intent.ACTION_MY_PACKAGE_REPLACED.equals(action)) return;
        // start validates enabled categories, unlocked storage and access before attempting
        // a foreground service; failures are stored and notified only when Android permits.
        MonitorService.start(context);
    }
}
