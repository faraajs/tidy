package id.eska.screenshotwebp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.UserManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

public final class AppStateStore {
    private static final Object LOCK = new Object();
    private static final String SCHEMA = "v23_safe_state";
    private static final String GALLERY_CONSENT = "v231_gallery_consent";
    private static final String HISTORY_PREFIX = "v23_processed_";
    private static final String HISTORY_SEQUENCE = "v23_history_sequence";
    static final int HISTORY_LIMIT = 10_000;
    private static final Map<SharedPreferences, RuntimeState> RUNTIMES = new WeakHashMap<>();

    private final SharedPreferences prefs;
    private final SharedPreferences ui;
    private final RuntimeState runtime;

    public static final class Config {
        public final MediaCategory category;
        public final boolean enabled;
        public final long activatedAtMillis;
        public final OutputFormat format;
        public final boolean deleteOriginals;

        public Config(MediaCategory category, boolean enabled, long activatedAtMillis,
                OutputFormat format, boolean deleteOriginals) {
            this.category = Objects.requireNonNull(category, "category");
            this.enabled = enabled;
            this.activatedAtMillis = activatedAtMillis;
            this.format = Objects.requireNonNull(format, "format");
            this.deleteOriginals = deleteOriginals;
        }
    }

    public static final class Snapshot {
        public final long screenshotCount;
        public final long photoCount;
        public final long savedBytes;
        public final long fallbackCount;
        public final String lastResult;
        public final String lastError;
        public final boolean monitoringRequested;
        public final int pending;
        public final int processing;

        private Snapshot(long screenshotCount, long photoCount, long savedBytes, long fallbackCount,
                String lastResult, String lastError, boolean monitoringRequested,
                int pending, int processing) {
            this.screenshotCount = screenshotCount;
            this.photoCount = photoCount;
            this.savedBytes = savedBytes;
            this.fallbackCount = fallbackCount;
            this.lastResult = lastResult;
            this.lastError = lastError;
            this.monitoringRequested = monitoringRequested;
            this.pending = pending;
            this.processing = processing;
        }
    }

    private static final class RuntimeState {
        final LinkedHashMap<String, Long> history = new LinkedHashMap<>();
        long sequence;
        // Queue state belongs to this process; persisting it would show phantom work after restart.
        int pending;
        int processing;
    }

    public AppStateStore(Context context) {
        Context device = Objects.requireNonNull(context, "context")
                .createDeviceProtectedStorageContext();
        prefs = device.getSharedPreferences("state", Context.MODE_PRIVATE);
        ui = device.getSharedPreferences("tidy_ui", Context.MODE_PRIVATE);
        synchronized (LOCK) {
            UserManager users = context.getSystemService(UserManager.class);
            Context credential = context.getApplicationContext();
            if (credential == null) {
                credential = context;
            }
            if (!ui.contains("v23_theme_migrated") && users != null && users.isUserUnlocked()
                    && !credential.isDeviceProtectedStorage()) {
                SharedPreferences legacyUi = credential.getSharedPreferences("tidy_ui", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = ui.edit();
                if (!ui.contains("dark_mode") && legacyUi.getAll().get("dark_mode") instanceof Boolean) {
                    edit.putBoolean("dark_mode", legacyUi.getBoolean("dark_mode", true));
                }
                commit(edit.putBoolean("v23_theme_migrated", true));
            }
            migrate();
            runtime = runtimeFor(prefs);
        }
    }

    AppStateStore(SharedPreferences prefs, SharedPreferences ui) {
        this.prefs = Objects.requireNonNull(prefs, "prefs");
        this.ui = Objects.requireNonNull(ui, "ui");
        synchronized (LOCK) {
            migrate();
            runtime = runtimeFor(prefs);
        }
    }

    private void migrate() {
        if (!prefs.getBoolean(GALLERY_CONSENT, false)) {
            // The Gallery publication fix requires renewed deletion and monitoring consent.
            SharedPreferences.Editor edit = prefs.edit()
                    .putBoolean(GALLERY_CONSENT, true).putBoolean("v23_requested", false);
            for (MediaCategory category : MediaCategory.values()) {
                edit.putBoolean(key(category, "delete"), false);
            }
            commit(edit);
        }
        if (prefs.getBoolean(SCHEMA, false)) {
            return;
        }
        SharedPreferences.Editor edit = prefs.edit();
        for (Map.Entry<String, Object> entry : migrationValues(prefs.getAll()).entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Boolean) {
                edit.putBoolean(entry.getKey(), (Boolean) value);
            } else if (value instanceof Long) {
                edit.putLong(entry.getKey(), (Long) value);
            } else {
                edit.putString(entry.getKey(), (String) value);
            }
        }
        commit(edit.putBoolean(SCHEMA, true));
    }

    // Pure migration policy keeps old unverified compression savings out of reclaimed-space totals.
    static Map<String, Object> migrationValues(Map<String, ?> old) {
        Map<String, Object> values = new HashMap<>();
        for (MediaCategory category : MediaCategory.values()) {
            String legacy = category == MediaCategory.SCREENSHOTS ? "screenshot" : "photo";
            values.put(key(category, "format"), readFormat(old.get(legacy + "_format")).name());
            Object count = old.get(legacy + "_count");
            if (count == null && category == MediaCategory.SCREENSHOTS) {
                count = old.get("count");
            }
            values.put(key(category, "count"), nonnegativeNumber(count));
            values.put(key(category, "enabled"), false);
            values.put(key(category, "activation"), 0L);
            values.put(key(category, "delete"), false);
        }
        values.put("v23_requested", false);
        values.put("v23_saved_bytes", 0L);
        values.put("v23_fallback_count", nonnegativeNumber(old.get("fallback_count")));
        values.put("v23_result", "No conversions yet");
        values.put("v23_error", "");
        return values;
    }

    private static long nonnegativeNumber(Object value) {
        return value instanceof Number ? Math.max(0L, ((Number) value).longValue()) : 0L;
    }

    private static OutputFormat readFormat(Object value) {
        if (value instanceof String) {
            try {
                return OutputFormat.valueOf(((String) value).toUpperCase(Locale.ROOT));
            } catch (IllegalArgumentException ignored) {
                // Unsupported legacy formats require a real supported encoder, never an alias.
            }
        }
        return OutputFormat.AVIF;
    }

    private static String key(MediaCategory category, String suffix) {
        Objects.requireNonNull(category, "category");
        return "v23_" + (category == MediaCategory.SCREENSHOTS ? "screenshot_" : "photo_") + suffix;
    }

    public Config config(MediaCategory category) {
        synchronized (LOCK) {
            return new Config(category, prefs.getBoolean(key(category, "enabled"), false),
                    prefs.getLong(key(category, "activation"), 0L),
                    readFormat(prefs.getString(key(category, "format"), "AVIF")),
                    prefs.getBoolean(key(category, "delete"), false));
        }
    }

    public void setEnabled(MediaCategory category, boolean enabled) {
        synchronized (LOCK) {
            if (prefs.getBoolean(key(category, "enabled"), false) == enabled) {
                return;
            }
            commit(prefs.edit().putBoolean(key(category, "enabled"), enabled)
                    .putLong(key(category, "activation"), enabled ? System.currentTimeMillis() : 0L));
        }
    }

    public void setFormat(MediaCategory category, OutputFormat format) {
        synchronized (LOCK) {
            Objects.requireNonNull(format, "format");
            if (config(category).format != format) {
                commit(prefs.edit().putString(key(category, "format"), format.name()));
            }
        }
    }

    public void setDeleteOriginals(MediaCategory category, boolean deleteOriginals) {
        synchronized (LOCK) {
            if (prefs.getBoolean(key(category, "delete"), false) != deleteOriginals) {
                commit(prefs.edit().putBoolean(key(category, "delete"), deleteOriginals));
            }
        }
    }

    public boolean darkMode() {
        synchronized (LOCK) {
            return ui.getBoolean("dark_mode", true);
        }
    }

    public void setDarkMode(boolean darkMode) {
        synchronized (LOCK) {
            if (darkMode() != darkMode) {
                commit(ui.edit().putBoolean("dark_mode", darkMode));
            }
        }
    }

    public boolean monitoringRequested() {
        synchronized (LOCK) {
            return prefs.getBoolean("v23_requested", false);
        }
    }

    public void setMonitoringRequested(boolean requested) {
        synchronized (LOCK) {
            if (monitoringRequested() != requested) {
                SharedPreferences.Editor edit = prefs.edit().putBoolean("v23_requested", requested);
                if (requested) {
                    long now = System.currentTimeMillis();
                    for (MediaCategory category : MediaCategory.values()) {
                        if (prefs.getBoolean(key(category, "enabled"), false)) {
                            edit.putLong(key(category, "activation"), now);
                        }
                    }
                }
                commit(edit);
            }
        }
    }

    String lastBatchDay() {
        synchronized (LOCK) { return prefs.getString("night_batch_day", ""); }
    }

    void markBatchDay(String day) {
        synchronized (LOCK) { commit(prefs.edit().putString("night_batch_day", day)); }
    }

    public Snapshot snapshot() {
        synchronized (LOCK) {
            return new Snapshot(prefs.getLong(key(MediaCategory.SCREENSHOTS, "count"), 0L),
                    prefs.getLong(key(MediaCategory.PHOTOS, "count"), 0L),
                    prefs.getLong("v23_saved_bytes", 0L), prefs.getLong("v23_fallback_count", 0L),
                    prefs.getString("v23_result", "No conversions yet"),
                    prefs.getString("v23_error", ""), monitoringRequested(),
                    runtime.pending, runtime.processing);
        }
    }

    public void setProgress(int pending, int processing) {
        synchronized (LOCK) {
            runtime.pending = Math.max(0, pending);
            runtime.processing = Math.max(0, processing);
        }
    }

    public void recordSuccess(MediaConverter.Result result) {
        Objects.requireNonNull(result, "result");
        synchronized (LOCK) {
            String countKey = key(result.category, "count");
            long reclaimed = reclaimedBytes(result.sourceBytes, result.outputBytes, result.originalDeleted);
            String summary = result.category.label() + ": " + result.format.name() + ", "
                    + result.width + " × " + result.height + ", " + result.outputBytes + " bytes; "
                    + (result.originalDeleted ? "original deleted, " + reclaimed + " bytes reclaimed"
                    : "original retained, no space reclaimed")
                    + (result.fallback ? "; codec fallback" : "")
                    + (result.targetMet ? "" : "; size target not met")
                    + (result.galleryPublished ? "" : "; Gallery unavailable; original retained");
            SharedPreferences.Editor edit = prefs.edit()
                    .putLong(countKey, add(prefs.getLong(countKey, 0L), 1L))
                    .putLong("v23_saved_bytes", add(prefs.getLong("v23_saved_bytes", 0L), reclaimed))
                    .putString("v23_result", summary).putString("v23_error", "");
            if (result.fallback) {
                edit.putLong("v23_fallback_count", add(prefs.getLong("v23_fallback_count", 0L), 1L));
            }
            commit(edit);
        }
    }

    static long reclaimedBytes(long sourceBytes, long outputBytes, boolean originalDeleted) {
        return originalDeleted && sourceBytes > 0 && outputBytes >= 0 && outputBytes < sourceBytes
                ? sourceBytes - outputBytes : 0L;
    }

    private static long add(long current, long increment) {
        current = Math.max(0L, current);
        return current > Long.MAX_VALUE - increment ? Long.MAX_VALUE : current + increment;
    }

    public void recordFailure(MediaCategory category, String message) {
        synchronized (LOCK) {
            String detail = message == null ? "" : message.trim();
            // Exception text may contain personal paths; only retain path-free diagnostics.
            if (detail.isEmpty() || detail.indexOf('/') >= 0 || detail.indexOf('\\') >= 0) {
                detail = "Operation failed. Check access and available storage.";
            }
            commit(prefs.edit().putString("v23_error",
                    (category == null ? "Monitoring" : category.label()) + ": " + detail));
        }
    }

    public boolean wasProcessed(String fingerprint) {
        synchronized (LOCK) {
            return runtime.history.containsKey(Objects.requireNonNull(fingerprint, "fingerprint"));
        }
    }

    public void markProcessed(String fingerprint) {
        if (!validFingerprint(fingerprint)) {
            throw new IllegalArgumentException("A SHA-256 fingerprint is required");
        }
        synchronized (LOCK) {
            if (runtime.history.containsKey(fingerprint)) {
                return;
            }
            SharedPreferences.Editor edit = prefs.edit();
            if (runtime.sequence == Long.MAX_VALUE) {
                long sequence = 0;
                for (String item : runtime.history.keySet()) {
                    edit.putLong(HISTORY_PREFIX + item, ++sequence);
                }
                runtime.sequence = sequence;
            }
            long sequence = runtime.sequence + 1;
            edit.putLong(HISTORY_SEQUENCE, sequence).putLong(HISTORY_PREFIX + fingerprint, sequence);
            String oldest = runtime.history.size() >= HISTORY_LIMIT
                    ? runtime.history.keySet().iterator().next() : null;
            if (oldest != null) {
                edit.remove(HISTORY_PREFIX + oldest);
            }
            commit(edit);
            if (oldest != null) {
                runtime.history.remove(oldest);
            }
            runtime.history.put(fingerprint, sequence);
            runtime.sequence = sequence;
        }
    }

    private static RuntimeState runtimeFor(SharedPreferences prefs) {
        RuntimeState existing = RUNTIMES.get(prefs);
        if (existing != null) {
            return existing;
        }
        RuntimeState state = new RuntimeState();
        List<Map.Entry<String, Long>> entries = new ArrayList<>();
        for (Map.Entry<String, ?> entry : prefs.getAll().entrySet()) {
            if (entry.getKey().startsWith(HISTORY_PREFIX)
                    && validFingerprint(entry.getKey().substring(HISTORY_PREFIX.length()))
                    && entry.getValue() instanceof Long && (Long) entry.getValue() > 0) {
                entries.add(Map.entry(entry.getKey().substring(HISTORY_PREFIX.length()),
                        (Long) entry.getValue()));
            }
        }
        entries.sort(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue)
                .thenComparing(Map.Entry::getKey));
        state.sequence = Math.max(0L, prefs.getLong(HISTORY_SEQUENCE, 0L));
        SharedPreferences.Editor prune = prefs.edit();
        int remove = Math.max(0, entries.size() - HISTORY_LIMIT);
        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<String, Long> entry = entries.get(i);
            state.sequence = Math.max(state.sequence, entry.getValue());
            if (i < remove) {
                prune.remove(HISTORY_PREFIX + entry.getKey());
            } else {
                state.history.put(entry.getKey(), entry.getValue());
            }
        }
        if (remove > 0) {
            commit(prune);
        }
        RUNTIMES.put(prefs, state);
        return state;
    }

    private static boolean validFingerprint(String fingerprint) {
        if (fingerprint == null || fingerprint.length() != 64) {
            return false;
        }
        for (int i = 0; i < fingerprint.length(); i++) {
            char value = fingerprint.charAt(i);
            if (!((value >= '0' && value <= '9') || (value >= 'a' && value <= 'f'))) {
                return false;
            }
        }
        return true;
    }

    private static void commit(SharedPreferences.Editor editor) {
        if (!editor.commit()) {
            throw new IllegalStateException("Tidy settings could not be saved");
        }
    }
}
