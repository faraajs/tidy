package id.eska.screenshotwebp;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.BatteryManager;
import android.os.PersistableBundle;
import android.os.PowerManager;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/** One persisted charging-only job; no daytime timers or file observation. */
final class NightBatchScheduler {
    static final int JOB_ID = 23103;

    static boolean inWindow(long now, ZoneId zone) {
        int hour = Instant.ofEpochMilli(now).atZone(zone).getHour();
        return hour >= 3 && hour < 6;
    }

    static boolean allowed(long now, ZoneId zone, boolean charging) {
        return charging && inWindow(now, zone);
    }

    static String day(long now, ZoneId zone) {
        return Instant.ofEpochMilli(now).atZone(zone).toLocalDate().toString();
    }

    static long nextStart(long now, ZoneId zone, String attemptedDay) {
        ZonedDateTime local = Instant.ofEpochMilli(now).atZone(zone);
        ZonedDateTime start = local.toLocalDate().atTime(3, 0).atZone(zone);
        boolean attempted = local.toLocalDate().toString().equals(attemptedDay);
        if (inWindow(now, zone) && !attempted) return now;
        if (now >= start.toInstant().toEpochMilli() || attempted) start = start.plusDays(1);
        return start.toInstant().toEpochMilli();
    }

    static boolean mayRun(Context context) {
        BatteryManager battery = context.getSystemService(BatteryManager.class);
        PowerManager power = context.getSystemService(PowerManager.class);
        return battery != null && power != null && !power.isInteractive()
                && allowed(System.currentTimeMillis(), ZoneId.systemDefault(), battery.isCharging());
    }

    static synchronized void schedule(Context context, boolean replace) {
        JobScheduler jobs = context.getSystemService(JobScheduler.class);
        if (jobs == null) throw new IllegalStateException("Android scheduler unavailable");
        AppStateStore state = new AppStateStore(context);
        if (!state.monitoringRequested()
                || (!state.config(MediaCategory.SCREENSHOTS).enabled
                && !state.config(MediaCategory.PHOTOS).enabled)) {
            jobs.cancel(JOB_ID);
            return;
        }
        if (!replace && jobs.getPendingJob(JOB_ID) != null) return;
        long now = System.currentTimeMillis();
        long start = nextStart(now, ZoneId.systemDefault(), state.lastBatchDay());
        PersistableBundle extras = new PersistableBundle();
        extras.putLong("scheduled_for", start);
        JobInfo job = new JobInfo.Builder(JOB_ID, new ComponentName(context, NightBatchJobService.class))
                .setMinimumLatency(Math.max(0L, start - now))
                .setRequiresCharging(true)
                .setRequiresDeviceIdle(true)
                .setPersisted(true)
                .setExtras(extras)
                .build();
        if (jobs.schedule(job) != JobScheduler.RESULT_SUCCESS) {
            throw new IllegalStateException("Android did not accept the night batch schedule");
        }
    }

    static void cancel(Context context) {
        JobScheduler jobs = context.getSystemService(JobScheduler.class);
        if (jobs != null) jobs.cancel(JOB_ID);
    }
}
