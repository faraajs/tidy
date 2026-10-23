package id.eska.screenshotwebp;

import android.content.Context;
import android.os.Environment;
import android.os.UserManager;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

/** One scan followed by a finite batch. No file observers or recurring tasks. */
public final class MediaMonitor implements AutoCloseable {
    public interface Callback {
        void onProgress(int pending, int processing);
        void onResult(MediaConverter.Result result);
        void onError(MediaCategory category, String message);
        default void onFinished() {}
    }

    private static final long STABLE_MILLIS = 350;
    private static final Object WORKER_LOCK = new Object();
    private static final Set<String> converting = new HashSet<>();
    private static int activeScreenshots;
    private static int activePhotos;
    private final Context context;
    private final AppStateStore store;
    private final PathPolicy policy;
    private final MediaConverter converter;
    private final Callback callback;
    private final Object lock = new Object();
    private final ScheduledExecutorService coordinator = Executors.newSingleThreadScheduledExecutor();
    private final ExecutorService screenshots = Executors.newSingleThreadExecutor();
    private final ExecutorService photos = Executors.newFixedThreadPool(2);
    private final LinkedHashMap<String, Pending> pending = new LinkedHashMap<>();
    private final Set<String> inFlight = new HashSet<>();
    private final BooleanSupplier allowed;
    private boolean scanFinished;
    private boolean finished;
    private volatile boolean closed;
    private boolean started;
    private volatile long scanCount;
    private volatile long inspectedFiles;

    private static final class Pending {
        final File file;
        final String key;
        final MediaCategory category;
        final long modified;
        final long length;
        ScheduledFuture<?> stability;
        boolean ready;

        Pending(File file, String key, MediaCategory category) throws IOException {
            this.file = file;
            this.key = key;
            this.category = category;
            modified = PathPolicy.modifiedMillis(file);
            length = file.length();
        }
    }

    public MediaMonitor(Context context, AppStateStore store, Callback callback) {
        this(context, store, callback, new PathPolicy(context));
    }

    // Owned test roots never inspect personal media.
    MediaMonitor(Context context, AppStateStore store, Callback callback, PathPolicy policy) {
        this(context, store, callback, policy, () -> NightBatchScheduler.mayRun(context));
    }

    MediaMonitor(Context context, AppStateStore store, Callback callback, PathPolicy policy,
            BooleanSupplier allowed) {
        this.allowed = allowed;
        this.context = context.getApplicationContext();
        this.store = store;
        this.callback = callback;
        this.policy = policy;
        converter = new MediaConverter(this.context, policy);
    }

    public void start() {
        synchronized (lock) {
            if (closed) return;
            if (started) return;
            started = true;
            execute(() -> {
                try { reconcile(); }
                catch (RuntimeException failure) {
                    error(null, "Unable to inspect batch folders; check storage access.");
                } finally {
                    synchronized (lock) { scanFinished = true; progress(); }
                }
            });
        }
    }

    private boolean mayRun() {
        UserManager users = context.getSystemService(UserManager.class);
        return !closed && allowed.getAsBoolean() && store.monitoringRequested()
                && (users == null || users.isUserUnlocked())
                && Environment.isExternalStorageManager()
                && Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    private void reconcile() {
        if (!mayRun()) {
            synchronized (lock) {
                clearPending();
                progress();
            }
            return;
        }
        scanCount++;
        Set<String> directories = new HashSet<>();
        for (MediaCategory category : MediaCategory.values()) {
            if (!store.config(category).enabled) continue;
            for (File root : policy.roots(category)) {
                try {
                    File canonical = root.getCanonicalFile();
                    File shared = Environment.getExternalStorageDirectory().getCanonicalFile();
                    String prefix = shared.getAbsolutePath() + File.separator;
                    String selected = root.getAbsolutePath();
                    if (!selected.startsWith(prefix)
                            || !canonical.equals(new File(shared.getCanonicalFile(),
                                    selected.substring(prefix.length())))) {
                        error(category, "A selected folder is a redirected path; monitoring skipped it.");
                        continue;
                    }
                    scan(canonical, canonical.getPath(), category, directories);
                } catch (IOException | SecurityException failure) {
                    error(category, "A monitored folder is not accessible; check storage access.");
                }
            }
        }
        synchronized (lock) {
            if (closed) return;
            dispatch();
            progress();
        }
    }

    private void scan(File directory, String root, MediaCategory category, Set<String> seen) {
        if (!mayRun() || !store.config(category).enabled || !directory.isDirectory()) return;
        try {
            String canonical = directory.getCanonicalPath();
            if (!canonical.equals(directory.getAbsolutePath())
                    || (!canonical.equals(root) && !canonical.startsWith(root + File.separator))
                    || !seen.add(canonical)) return;
            File[] children = directory.listFiles();
            if (children == null) {
                error(category, "A monitored folder cannot be read; check storage access.");
                return;
            }
            for (File child : children) {
                if (!mayRun()) return;
                String name = child.getName();
                if (name.startsWith(".") || name.equalsIgnoreCase("Android")
                        || name.equalsIgnoreCase("cache")) continue;
                if (child.isDirectory()) scan(child, root, category, seen);
                else {
                    inspectedFiles++;
                    offer(child, category);
                }
            }
        } catch (IOException | SecurityException failure) {
            error(category, "A monitored folder cannot be inspected; check storage access.");
        }
    }

    private void offer(File file, MediaCategory category) {
        if (!mayRun()) return;
        try {
            AppStateStore.Config config = store.config(category);
            if (!policy.accepts(file, config)) return;
            String key = file.getCanonicalPath();
            String fingerprint = policy.fingerprint(file, config.format);
            if (store.wasProcessed(fingerprint)) return;
            synchronized (lock) {
                if (!mayRun()) return;
                Pending previous = pending.get(key);
                if (inFlight.contains(key)) return;
                Pending candidate = new Pending(file, key, category);
                if (previous != null && previous.stability != null) previous.stability.cancel(false);
                pending.put(key, candidate);
                inFlight.add(key);
                candidate.stability = coordinator.schedule(() -> stable(candidate),
                        STABLE_MILLIS, TimeUnit.MILLISECONDS);
                progress();
            }
        } catch (IOException | RuntimeException failure) {
            error(category, "Unable to inspect a new image; original retained.");
        }
    }

    private void stable(Pending candidate) {
        synchronized (lock) {
            if (pending.get(candidate.key) != candidate) return;
            try {
                if (!mayRun() || !policy.accepts(candidate.file, store.config(candidate.category))) {
                    discard(candidate);
                } else if (candidate.file.length() != candidate.length
                        || PathPolicy.modifiedMillis(candidate.file) != candidate.modified || candidate.length == 0) {
                    // An unstable file waits for the next night, never a busy-file loop.
                    discard(candidate);
                } else {
                    candidate.ready = true;
                    dispatch();
                }
            } catch (IOException | RuntimeException failure) {
                if (pending.get(candidate.key) == candidate) discard(candidate);
                error(candidate.category, "Unable to check image stability; original retained.");
            }
            progress();
        }
    }

    private void dispatch() {
        if (!mayRun()) {
            clearPending();
            return;
        }
        Iterator<Pending> it = pending.values().iterator();
        while (it.hasNext()) {
            Pending candidate = it.next();
            AppStateStore.Config fresh = store.config(candidate.category);
            if (!policy.accepts(candidate.file, fresh)) {
                if (candidate.stability != null) candidate.stability.cancel(false);
                it.remove();
                inFlight.remove(candidate.key);
                continue;
            }
            if (!candidate.ready) continue;
            boolean screenshot = candidate.category == MediaCategory.SCREENSHOTS;
            synchronized (WORKER_LOCK) {
                if (converting.contains(candidate.key)
                        || (screenshot ? activeScreenshots >= 1 : activePhotos >= 2)) continue;
                converting.add(candidate.key);
                if (screenshot) activeScreenshots++; else activePhotos++;
            }
            it.remove();
            try {
                (screenshot ? screenshots : photos).execute(() -> convert(candidate));
            } catch (RejectedExecutionException rejected) {
                inFlight.remove(candidate.key);
                releaseWorker(candidate);
            }
        }
    }

    private void convert(Pending candidate) {
        try {
            AppStateStore.Config fresh = store.config(candidate.category);
            if (!mayRun() || !policy.accepts(candidate.file, fresh)
                    || candidate.file.length() != candidate.length
                    || PathPolicy.modifiedMillis(candidate.file) != candidate.modified) return;
            // Capture BEFORE convert: successful conversion may safely delete the source.
            String fingerprint = policy.fingerprint(candidate.file, fresh.format);
            if (store.wasProcessed(fingerprint)) return;
            if (!mayRun()) return;
            MediaConverter.Result result = converter.convert(candidate.file, fresh);
            store.markProcessed(fingerprint);
            callback.onResult(result);
        } catch (IOException | RuntimeException failure) {
            String detail = failure.getMessage();
            if (detail == null || detail.indexOf('/') >= 0 || detail.indexOf('\\') >= 0) {
                detail = "Check image support, storage access and available space.";
            }
            if (detail.length() > 160) detail = detail.substring(0, 160);
            error(candidate.category, "Image operation failed (" + failure.getClass().getSimpleName()
                    + "): " + detail);
        } catch (LinkageError failure) {
            error(candidate.category, "The image codec could not be loaded; original retained.");
        } finally {
            synchronized (lock) {
                inFlight.remove(candidate.key);
                releaseWorker(candidate);
                progress();
            }
            execute(() -> {
                synchronized (lock) {
                    dispatch();
                    progress();
                }
            });
        }
    }

    private void releaseWorker(Pending candidate) {
        synchronized (WORKER_LOCK) {
            converting.remove(candidate.key);
            if (candidate.category == MediaCategory.SCREENSHOTS) activeScreenshots--;
            else activePhotos--;
        }
    }

    private void discard(Pending candidate) {
        pending.remove(candidate.key);
        inFlight.remove(candidate.key);
    }

    private void clearPending() {
        for (Pending candidate : pending.values()) {
            if (candidate.stability != null) candidate.stability.cancel(false);
            inFlight.remove(candidate.key);
        }
        pending.clear();
    }

    private void execute(Runnable action) {
        if (closed) return;
        try {
            coordinator.execute(() -> {
                if (closed) return;
                try { action.run(); }
                catch (RuntimeException failure) {
                    error(null, "Monitoring encountered a storage or state error; check access.");
                }
            });
        } catch (RejectedExecutionException ignored) {
            // Closing a session can race the final worker callback.
        }
    }

    boolean isTerminated() {
        return coordinator.isTerminated() && screenshots.isTerminated() && photos.isTerminated();
    }

    long scanCount() { return scanCount; }
    long inspectedFiles() { return inspectedFiles; }

    private void progress() {
        int processing;
        synchronized (WORKER_LOCK) { processing = activeScreenshots + activePhotos; }
        try { callback.onProgress(pending.size(), processing); }
        catch (RuntimeException ignored) { /* A callback cannot strand queue accounting. */ }
        if (started && (scanFinished || closed) && inFlight.isEmpty() && !finished) {
            finished = true;
            close();
            callback.onFinished();
        }
    }

    private void error(MediaCategory category, String message) {
        try { callback.onError(category, message); }
        catch (RuntimeException ignored) { /* Retain other candidates after a reporting failure. */ }
    }

    @Override public void close() {
        synchronized (lock) {
            if (closed) return;
            closed = true;
            clearPending();
            coordinator.shutdown();
            // Do not interrupt encoding, verified publication or safe source restoration.
            screenshots.shutdown();
            photos.shutdown();
            progress();
        }
    }
}
