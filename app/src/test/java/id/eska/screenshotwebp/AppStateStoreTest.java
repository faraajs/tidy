package id.eska.screenshotwebp;

import android.content.SharedPreferences;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public final class AppStateStoreTest {
    @Test public void unsafeLegacyActivationAndDeletionNeverCarryForward() {
        Map<String, Object> legacy = new HashMap<>();
        legacy.put("screenshot_format", "WEBP");
        legacy.put("photo_format", "AVIF");
        legacy.put("screenshot_count", 13);
        legacy.put("photo_count", 7);
        legacy.put("fallback_count", 2);
        legacy.put("screenshot_activation", 123L);
        legacy.put("photo_activation", 123L);
        legacy.put("monitoring_requested", true);
        legacy.put("delete_originals", true);
        legacy.put("saved", 900_000L);
        legacy.put("screenshot_saved", 500_000L);
        legacy.put("photo_saved", 400_000L);
        Map<String, Object> migrated = AppStateStore.migrationValues(legacy);
        assertEquals("WEBP", migrated.get("v23_screenshot_format"));
        assertEquals(13L, migrated.get("v23_screenshot_count"));
        assertEquals(7L, migrated.get("v23_photo_count"));
        assertEquals(2L, migrated.get("v23_fallback_count"));
        assertEquals(false, migrated.get("v23_screenshot_enabled"));
        assertEquals(false, migrated.get("v23_photo_enabled"));
        assertEquals(0L, migrated.get("v23_screenshot_activation"));
        assertEquals(0L, migrated.get("v23_photo_activation"));
        assertEquals(false, migrated.get("v23_requested"));
        assertEquals(false, migrated.get("v23_screenshot_delete"));
        assertEquals(false, migrated.get("v23_photo_delete"));
        assertEquals(0L, migrated.get("v23_saved_bytes"));
    }

    @Test public void olderCountAndUnsupportedFormatMigrateWithoutInventedSavings() {
        Map<String, Object> legacy = Map.of("count", 8, "photo_count", -4,
                "screenshot_format", "HEIC", "photo_format", "webp");
        Map<String, Object> migrated = AppStateStore.migrationValues(legacy);
        assertEquals(8L, migrated.get("v23_screenshot_count"));
        assertEquals(0L, migrated.get("v23_photo_count"));
        assertEquals("AVIF", migrated.get("v23_screenshot_format"));
        assertEquals("WEBP", migrated.get("v23_photo_format"));
        assertEquals(0L, migrated.get("v23_saved_bytes"));
    }

    @Test public void retainedOriginalsAndLargerOutputsNeverReportReclaimedSpace() {
        assertEquals(0L, AppStateStore.reclaimedBytes(1_000L, 100L, false));
        assertEquals(0L, AppStateStore.reclaimedBytes(1_000L, 1_001L, true));
        assertEquals(0L, AppStateStore.reclaimedBytes(1_000L, 1_000L, true));
        assertEquals(0L, AppStateStore.reclaimedBytes(1_000L, -1L, true));
        assertEquals(900L, AppStateStore.reclaimedBytes(1_000L, 100L, true));
    }

    @Test public void historySurvivesRestartAndPrunesOldestWithoutRewritingList() {
        MemoryPreferences prefs = new MemoryPreferences();
        AppStateStore store = new AppStateStore(prefs, new MemoryPreferences());
        String first = fingerprint(1);
        for (int i = 1; i <= AppStateStore.HISTORY_LIMIT + 1; i++) {
            store.markProcessed(fingerprint(i));
            assertTrue("Only new entry, sequence, and optional prune are written", prefs.lastWrites <= 3);
        }
        assertFalse(store.wasProcessed(first));
        assertTrue(store.wasProcessed(fingerprint(2)));
        assertEquals(AppStateStore.HISTORY_LIMIT, prefs.values.keySet().stream()
                .filter(key -> key.startsWith("v23_processed_")).count());
        int commits = prefs.commits;
        store.markProcessed(fingerprint(2));
        store.wasProcessed(fingerprint(2));
        assertEquals("Read/duplicate scan must not rewrite preferences", commits, prefs.commits);
        AppStateStore restarted = new AppStateStore(new MemoryPreferences(prefs.values), new MemoryPreferences());
        assertFalse(restarted.wasProcessed(first));
        assertTrue(restarted.wasProcessed(fingerprint(2)));
        assertTrue(restarted.wasProcessed(fingerprint(AppStateStore.HISTORY_LIMIT + 1)));
    }

    @Test public void startupPruneUsesFingerprintTieBreakAndNeverRepeatsSafetyMigration() {
        MemoryPreferences prefs = new MemoryPreferences();
        prefs.values.put("v23_safe_state", true);
        prefs.values.put("v23_screenshot_enabled", true);
        prefs.values.put("v23_screenshot_activation", 1_000L);
        for (int i = AppStateStore.HISTORY_LIMIT + 2; i >= 1; i--) {
            prefs.values.put("v23_processed_" + fingerprint(i), 1L);
        }
        AppStateStore store = new AppStateStore(prefs, new MemoryPreferences());
        assertFalse(store.wasProcessed(fingerprint(1)));
        assertFalse(store.wasProcessed(fingerprint(2)));
        assertTrue(store.wasProcessed(fingerprint(3)));
        assertTrue(store.config(MediaCategory.SCREENSHOTS).enabled);
        assertEquals(1_000L, store.config(MediaCategory.SCREENSHOTS).activatedAtMillis);
    }

    @Test public void separateStoresShareQueueAndCountersButRestartHasNoPhantomWork() {
        MemoryPreferences prefs = new MemoryPreferences();
        MemoryPreferences ui = new MemoryPreferences();
        ui.values.put("dark_mode", false);
        AppStateStore first = new AppStateStore(prefs, ui);
        AppStateStore second = new AppStateStore(prefs, ui);
        first.setProgress(4, 2);
        assertEquals(4, second.snapshot().pending);
        assertEquals(2, second.snapshot().processing);
        assertFalse(second.darkMode());
        AppStateStore restarted = new AppStateStore(new MemoryPreferences(prefs.values), ui);
        assertEquals(0, restarted.snapshot().pending);
        assertEquals(0, restarted.snapshot().processing);
        assertFalse(restarted.darkMode());
    }

    @Test public void monitoringFailuresAllowNoCategoryAndPreserveOnlyPathFreeDetails() {
        AppStateStore store = new AppStateStore(new MemoryPreferences(), new MemoryPreferences());
        store.recordFailure(null, "Shared storage unavailable");
        assertEquals("Monitoring: Shared storage unavailable", store.snapshot().lastError);
        store.recordFailure(MediaCategory.PHOTOS, "Unable to read /private/user/photo.jpg");
        assertFalse(store.snapshot().lastError.contains("/private"));
        assertFalse(store.snapshot().lastError.contains("original retained"));
        store.recordFailure(null, null);
        assertTrue(store.snapshot().lastError.startsWith("Monitoring: "));
    }

    private static String fingerprint(int value) {
        return String.format(java.util.Locale.ROOT, "%064x", value);
    }

    // Test-only preference backend: restart copies durable keys but not process state.
    private static final class MemoryPreferences implements SharedPreferences {
        final Map<String, Object> values = new HashMap<>();
        int commits;
        int lastWrites;

        MemoryPreferences() {}
        MemoryPreferences(Map<String, ?> source) { values.putAll(source); }
        @Override public Map<String, ?> getAll() { return new HashMap<>(values); }
        @Override public String getString(String key, String fallback) {
            return (String) values.getOrDefault(key, fallback);
        }
        @Override @SuppressWarnings("unchecked")
        public Set<String> getStringSet(String key, Set<String> fallback) {
            return (Set<String>) values.getOrDefault(key, fallback);
        }
        @Override public int getInt(String key, int fallback) {
            return (Integer) values.getOrDefault(key, fallback);
        }
        @Override public long getLong(String key, long fallback) {
            return (Long) values.getOrDefault(key, fallback);
        }
        @Override public float getFloat(String key, float fallback) {
            return (Float) values.getOrDefault(key, fallback);
        }
        @Override public boolean getBoolean(String key, boolean fallback) {
            return (Boolean) values.getOrDefault(key, fallback);
        }
        @Override public boolean contains(String key) { return values.containsKey(key); }
        @Override public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {}
        @Override public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {}
        @Override public Editor edit() { return new MemoryEditor(); }

        private final class MemoryEditor implements Editor {
            final Map<String, Object> puts = new HashMap<>();
            final Set<String> removes = new HashSet<>();
            boolean clear;
            @Override public Editor putString(String key, String value) { puts.put(key, value); return this; }
            @Override public Editor putStringSet(String key, Set<String> value) { puts.put(key, value); return this; }
            @Override public Editor putInt(String key, int value) { puts.put(key, value); return this; }
            @Override public Editor putLong(String key, long value) { puts.put(key, value); return this; }
            @Override public Editor putFloat(String key, float value) { puts.put(key, value); return this; }
            @Override public Editor putBoolean(String key, boolean value) { puts.put(key, value); return this; }
            @Override public Editor remove(String key) { removes.add(key); return this; }
            @Override public Editor clear() { clear = true; return this; }
            @Override public boolean commit() {
                if (clear) { values.clear(); }
                for (String key : removes) { values.remove(key); }
                values.putAll(puts);
                lastWrites = puts.size() + removes.size();
                commits++;
                return true;
            }
            @Override public void apply() { commit(); }
        }
    }
}
