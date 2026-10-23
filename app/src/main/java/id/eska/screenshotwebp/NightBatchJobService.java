package id.eska.screenshotwebp;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.Looper;
import java.time.Instant;
import java.time.ZoneId;

/** Android owns the job lifetime. An interrupted session never starts another file. */
public final class NightBatchJobService extends JobService {
    private static volatile boolean running;
    private final Handler main = new Handler(Looper.getMainLooper());
    private MediaMonitor monitor;

    static boolean isRunning() { return running; }

    @Override public boolean onStartJob(JobParameters params) {
        if (monitor != null) return true;
        AppStateStore state = new AppStateStore(this);
        ZoneId zone = ZoneId.systemDefault();
        long now = System.currentTimeMillis();
        boolean attempted = NightBatchScheduler.day(now, zone).equals(state.lastBatchDay());
        // A denied night attempt must not reschedule immediately in a failure loop.
        if (!attempted && state.monitoringRequested() && NightBatchScheduler.inWindow(now, zone)) {
            state.markBatchDay(NightBatchScheduler.day(now, zone));
        }
        if (MonitorService.unavailableReason(this, state) != null
                || !NightBatchScheduler.mayRun(this)
                || attempted) {
            restoreSchedule();
            return false;
        }
        // Consent and category activation timestamps are NOT toggled for each nightly session.
        monitor = new MediaMonitor(this, state, new MediaMonitor.Callback() {
            @Override public void onProgress(int pending, int processing) { state.setProgress(pending, processing); }
            @Override public void onResult(MediaConverter.Result result) { state.recordSuccess(result); }
            @Override public void onError(MediaCategory category, String message) { state.recordFailure(category, message); }
            @Override public void onFinished() { main.post(() -> finish(params)); }
        });
        running = true;
        long end = Instant.ofEpochMilli(now).atZone(zone).toLocalDate().atTime(6, 0)
                .atZone(zone).toInstant().toEpochMilli();
        main.postDelayed(() -> {
            if (monitor != null) monitor.close();
        }, Math.max(0, end - now));
        monitor.start();
        return true;
    }

    private void finish(JobParameters params) {
        if (monitor == null) return;
        monitor = null;
        running = false;
        main.removeCallbacksAndMessages(null);
        jobFinished(params, false);
        restoreSchedule();
    }

    private void restoreSchedule() {
        try { NightBatchScheduler.schedule(this, true); }
        catch (RuntimeException failure) {
            new AppStateStore(this).recordFailure(null, "Night schedule unavailable. Open Tidy to retry.");
        }
    }

    @Override public boolean onStopJob(JobParameters params) {
        stopSession();
        restoreSchedule();
        return false;
    }

    private void stopSession() {
        MediaMonitor previous = monitor;
        monitor = null;
        running = false;
        main.removeCallbacksAndMessages(null);
        if (previous != null) previous.close();
    }

    @Override public void onDestroy() {
        stopSession();
        super.onDestroy();
    }
}
