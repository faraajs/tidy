package id.eska.screenshotwebp;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.Gravity;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.EnumMap;
import java.util.Locale;

/** A local-only dashboard: persisted preferences and real service/conversion state. */
public final class MainActivity extends Activity {
    private static final int NOTIFICATIONS_REQUEST = 23;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final EnumMap<MediaCategory, CategoryViews> categoryViews =
            new EnumMap<>(MediaCategory.class);
    private AppStateStore store;
    private PathPolicy paths;
    private ScrollView scroll;
    private Switch themeSwitch;
    private TextView summary;
    private TextView progress;
    private TextView status;
    private TextView lastResult;
    private TextView lastError;
    private TextView accessStatus;
    private Button monitorButton;
    private Button notificationButton;
    private boolean refreshing;
    private boolean dark;
    private int foreground;
    private int muted;
    private int cardColor;
    private int accent;
    private int background;

    private final Runnable refreshTick = new Runnable() {
        @Override public void run() {
            refresh();
            handler.postDelayed(this, 1000L);
        }
    };

    @Override public void onCreate(Bundle savedInstanceState) {
        store = new AppStateStore(this);
        dark = store.darkMode();
        setTheme(dark ? R.style.Theme_Tidy_Dark : R.style.Theme_Tidy_Light);
        super.onCreate(savedInstanceState);
        paths = new PathPolicy(this);
        buildDashboard();
        if (savedInstanceState != null) {
            int position = savedInstanceState.getInt("scroll_position", 0);
            scroll.post(() -> scroll.scrollTo(0, position));
        }
        refresh();
    }

    @Override protected void onResume() {
        super.onResume();
        if (store.darkMode() != dark) {
            recreate();
            return;
        }
        // Restore only the schedule; opening the app never scans or starts conversion.
        if (store.monitoringRequested() && Environment.isExternalStorageManager()
                && anyCategoryEnabled() && !MonitorService.isRunning()) {
            dispatchStart();
        }
        handler.removeCallbacks(refreshTick);
        handler.post(refreshTick);
    }

    @Override protected void onPause() {
        handler.removeCallbacks(refreshTick);
        super.onPause();
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("scroll_position", scroll.getScrollY());
        super.onSaveInstanceState(outState);
    }

    private void buildDashboard() {
        foreground = Color.parseColor(dark ? "#F2F5F8" : "#17252D");
        muted = Color.parseColor(dark ? "#BAC8D0" : "#465B66");
        cardColor = Color.parseColor(dark ? "#192A34" : "#FFFFFF");
        accent = Color.parseColor(dark ? "#77E1D2" : "#006C60");
        background = Color.parseColor(dark ? "#0D1921" : "#EDF3F5");
        getWindow().setDecorFitsSystemWindows(false);
        getWindow().setNavigationBarContrastEnforced(true);
        int appearance = dark ? 0 : android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                | android.view.WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS;

        FrameLayout root = new FrameLayout(this);
        root.setBackgroundColor(background);
        root.setOnApplyWindowInsetsListener((view, insets) -> {
            android.graphics.Insets safe = insets.getInsets(WindowInsets.Type.systemBars()
                    | WindowInsets.Type.displayCutout() | WindowInsets.Type.ime());
            view.setPadding(safe.left, safe.top, safe.right, safe.bottom);
            android.view.WindowInsetsController controller = view.getWindowInsetsController();
            if (controller != null) {
                controller.setSystemBarsAppearance(appearance,
                        android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                                | android.view.WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS);
            }
            return insets;
        });
        scroll = new ScrollView(this);
        scroll.setId(View.generateViewId());
        scroll.setFillViewport(true);
        scroll.setClipToPadding(false);
        FrameLayout centered = new FrameLayout(this);
        LinearLayout content = column();
        content.setPadding(dp(16), dp(20), dp(16), dp(28));
        FrameLayout.LayoutParams contentParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT,
                Gravity.TOP | Gravity.CENTER_HORIZONTAL);
        centered.addView(content, contentParams);
        centered.addOnLayoutChangeListener((view, left, top, right, bottom,
                oldLeft, oldTop, oldRight, oldBottom) -> {
            int width = right - left > dp(720) ? dp(720) : FrameLayout.LayoutParams.MATCH_PARENT;
            if (contentParams.width != width) {
                contentParams.width = width;
                content.setLayoutParams(contentParams);
            }
        });
        scroll.addView(centered, new ScrollView.LayoutParams(-1, -2));
        root.addView(scroll, new FrameLayout.LayoutParams(-1, -1));
        setContentView(root);
        root.requestApplyInsets();

        LinearLayout branding = new LinearLayout(this);
        branding.setGravity(Gravity.CENTER_VERTICAL);
        ImageView logo = new ImageView(this);
        logo.setImageResource(R.drawable.ic_tidy);
        logo.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);
        branding.addView(logo, new LinearLayout.LayoutParams(dp(56), dp(56)));
        LinearLayout title = column();
        title.setPadding(dp(12), 0, 0, 0);
        title.addView(text("Tidy", 30, foreground, true));
        title.addView(text("Local image conversion", 15, muted, false));
        branding.addView(title, new LinearLayout.LayoutParams(0, -2, 1));
        content.addView(branding);
        themeSwitch = toggle("Dark theme");
        content.addView(themeSwitch);
        themeSwitch.setOnCheckedChangeListener((button, enabled) -> {
            if (refreshing || store.darkMode() == enabled) return;
            store.setDarkMode(enabled);
            recreate();
        });

        LinearLayout overview = card(content, "Conversion summary");
        summary = text("", 18, foreground, false);
        progress = text("", 16, muted, false);
        status = text("", 16, foreground, false);
        overview.addView(summary);
        overview.addView(progress);
        overview.addView(status);
        overview.addView(text("Reclaimed storage counts only verified conversions whose originals were deleted. "
                + "Retaining originals adds output files and does not reclaim storage.", 14, muted, false));
        monitorButton = button("Enable night batch");
        overview.addView(monitorButton);
        monitorButton.setOnClickListener(view -> toggleMonitoring());
        lastResult = text("", 14, muted, false);
        lastError = text("", 14, Color.parseColor(dark ? "#FFB4AB" : "#A3221A"), false);
        overview.addView(lastResult);
        overview.addView(lastError);

        for (MediaCategory category : MediaCategory.values()) addCategory(content, category);

        LinearLayout safety = card(content, "Before you convert");
        safety.addView(text("Only new or newly modified JPEG and PNG images in enabled folders are eligible. "
                + "Enabling a category establishes a new activation time; existing older media is not swept. "
                + "Pausing stops new work; an in-flight conversion can finish safely.", 15, foreground, false));
        safety.addView(text("Originals are retained by default. Conversion is lossy. Screenshots keep their "
                + "oriented dimensions; photos may be resized to 2560 pixels or smaller. "
                + "Outputs strip GPS, EXIF and camera metadata. File-size targets are not guaranteed. "
                + "Back up your originals before enabling deletion.", 15, foreground, false));

        LinearLayout permissions = card(content, "Android permissions");
        accessStatus = text("", 15, foreground, false);
        permissions.addView(accessStatus);
        Button files = button("Allow all files access");
        files.setOnClickListener(view -> openAllFilesSettings());
        permissions.addView(files);
        notificationButton = button("Allow notifications");
        notificationButton.setOnClickListener(view -> requestNotifications());
        permissions.addView(notificationButton);
        Button battery = button("Battery optimization settings");
        battery.setOnClickListener(view -> openBatterySettings());
        permissions.addView(battery);
        permissions.addView(text("All files access is needed only to read and write the folders listed above. "
                + "Night batches run around 03:00–06:00 only while charging with the screen off. "
                + "Android may delay or skip a night; unfinished files wait for the next night.", 14, muted, false));

        LinearLayout about = card(content, "Privacy and version");
        about.addView(text("Tidy " + versionName() + " · Android 11 or newer\n"
                + "Release architectures: arm64-v8a and x86_64\n"
                + "This device: " + Build.SUPPORTED_ABIS[0], 15, foreground, false));
        about.addView(text("Processing stays on this device. No network permission, uploads, analytics or "
                + "telemetry. Preferences and conversion history are stored locally. "
                + "Tidy is GPL-3.0-only; codec and dependency notices are bundled below.", 15, muted, false));
        Button licenses = button("Open source licenses");
        licenses.setOnClickListener(view -> showLicenses());
        about.addView(licenses);
    }

    private void addCategory(LinearLayout content, MediaCategory category) {
        LinearLayout card = card(content, category.label());
        CategoryViews views = new CategoryViews();
        categoryViews.put(category, views);
        views.enabled = toggle("Enable " + category.label());
        card.addView(views.enabled);
        TextView folderLabel = text("Monitored folders", 14, muted, true);
        card.addView(folderLabel);
        StringBuilder folders = new StringBuilder();
        for (File root : paths.roots(category)) {
            if (folders.length() > 0) folders.append('\n');
            folders.append(root.getAbsolutePath());
        }
        TextView folderPaths = text(folders.toString(), 14, foreground, false);
        folderPaths.setTextIsSelectable(true);
        card.addView(folderPaths);
        card.addView(text(category == MediaCategory.SCREENSHOTS
                ? "Full-size screenshots · quality 55 · 100 KiB target"
                : "Photos · adaptive quality and resolution · 100–750 KiB targets",
                14, muted, false));
        card.addView(text("Output format", 15, foreground, true));
        LinearLayout formats = new LinearLayout(this);
        views.avif = button("AVIF");
        views.webp = button("WebP");
        LinearLayout.LayoutParams left = new LinearLayout.LayoutParams(0, -2, 1);
        left.setMargins(0, dp(4), dp(6), dp(4));
        formats.addView(views.avif, left);
        formats.addView(views.webp, new LinearLayout.LayoutParams(0, -2, 1));
        card.addView(formats);
        views.format = text("", 14, muted, false);
        card.addView(views.format);
        views.delete = toggle("Delete originals for " + category.label());
        card.addView(views.delete);
        card.addView(text("Off keeps both files. On requires a smaller, readable Gallery output "
                + "and an unchanged source; unavailable Gallery output keeps the original.", 14, muted, false));
        views.enabled.setOnCheckedChangeListener((button, enabled) -> {
            if (refreshing) return;
            store.setEnabled(category, enabled);
            settingsChanged();
        });
        views.avif.setOnClickListener(view -> selectFormat(category, OutputFormat.AVIF));
        views.webp.setOnClickListener(view -> selectFormat(category, OutputFormat.WEBP));
        views.delete.setOnCheckedChangeListener((button, delete) -> {
            if (refreshing) return;
            if (!delete) {
                store.setDeleteOriginals(category, false);
                settingsChanged();
                return;
            }
            // Do not expose an enabled deletion preference before explicit confirmation.
            refreshing = true;
            views.delete.setChecked(false);
            refreshing = false;
            new AlertDialog.Builder(this)
                    .setTitle("Delete originals for " + category.label() + "?")
                    .setMessage("This is an opt-in risk. After a smaller output is decoded, verified "
                            + "and readable from Gallery, and the source is checked unchanged, Tidy may permanently delete that original. "
                            + "Lossy compression and photo resizing cannot be reversed. GPS, EXIF and camera "
                            + "metadata are removed from outputs. A verified image is not a backup, and "
                            + "external storage or other apps can still fail. Back up your originals first. "
                            + "Failures keep the original; no output means no deletion.")
                    .setNegativeButton("Keep originals", (dialog, which) -> refresh())
                    .setPositiveButton("Enable deletion", (dialog, which) -> {
                        store.setDeleteOriginals(category, true);
                        settingsChanged();
                    })
                    .setOnCancelListener(dialog -> refresh())
                    .show();
        });
    }

    private void selectFormat(MediaCategory category, OutputFormat format) {
        if (store.config(category).format == format) return;
        store.setFormat(category, format);
        settingsChanged();
    }

    private void settingsChanged() {
        if (store.monitoringRequested()) {
            if (!anyCategoryEnabled() || !Environment.isExternalStorageManager()) {
                MonitorService.stop(this);
            } else {
                dispatchStart();
            }
        }
        refresh();
    }

    private boolean anyCategoryEnabled() {
        for (MediaCategory category : MediaCategory.values()) {
            if (store.config(category).enabled) return true;
        }
        return false;
    }

    private void toggleMonitoring() {
        if (store.monitoringRequested() || MonitorService.isRunning()) {
            MonitorService.stop(this);
        } else if (!anyCategoryEnabled()) {
            message("Enable Screenshots or Photos before enabling night batches.");
        } else if (!Environment.isExternalStorageManager()) {
            message("All files access is required. Night batches have not been enabled.");
            openAllFilesSettings();
        } else {
            store.setMonitoringRequested(true);
            dispatchStart();
        }
        refresh();
    }

    private void dispatchStart() {
        try {
            MonitorService.start(this);
        } catch (RuntimeException error) {
            store.setMonitoringRequested(false);
            message("Android could not save the night schedule. Check permissions and try again.");
        }
    }

    private void refresh() {
        if (summary == null) return;
        AppStateStore.Snapshot snapshot = store.snapshot();
        refreshing = true;
        try {
            themeSwitch.setChecked(store.darkMode());
            for (MediaCategory category : MediaCategory.values()) {
                AppStateStore.Config config = store.config(category);
                CategoryViews views = categoryViews.get(category);
                views.enabled.setChecked(config.enabled);
                views.delete.setChecked(config.deleteOriginals);
                formatButton(views.avif, config.format == OutputFormat.AVIF);
                formatButton(views.webp, config.format == OutputFormat.WEBP);
                String fallback = config.format == OutputFormat.AVIF
                        ? "Codec failure may fall back to WebP."
                        : category == MediaCategory.PHOTOS ? "Codec failure may fall back to AVIF."
                        : "WebP screenshots have no codec fallback.";
                setText(views.format, "Selected: " + (config.format == OutputFormat.AVIF ? "AVIF" : "WebP")
                        + ". " + fallback);
            }
            setText(summary, "Screenshots converted: " + snapshot.screenshotCount
                    + "\nPhotos converted: " + snapshot.photoCount
                    + "\nReclaimed storage: " + bytes(snapshot.savedBytes)
                    + "\nCodec fallbacks: " + snapshot.fallbackCount);
            setText(progress, "Queued: " + snapshot.pending + " · Processing: " + snapshot.processing);
            boolean allFiles = Environment.isExternalStorageManager();
            boolean active = MonitorService.isRunning() && allFiles && anyCategoryEnabled()
                    && snapshot.monitoringRequested;
            String monitorStatus;
            if (active) monitorStatus = "Night batch running — charging, screen off";
            else if (!allFiles) monitorStatus = "Night batch waiting — all files access required";
            else if (!anyCategoryEnabled()) monitorStatus = "Night batch waiting — enable a category";
            else if (snapshot.monitoringRequested) monitorStatus = "Scheduled — 03:00–06:00 · charging, screen off";
            else monitorStatus = "Night batch paused";
            setText(status, monitorStatus);
            setText(monitorButton, snapshot.monitoringRequested || MonitorService.isRunning()
                    ? "Pause night batch" : "Enable night batch");
            setText(lastResult, snapshot.lastResult == null || snapshot.lastResult.isEmpty()
                    ? "Last result: No conversions yet" : "Last result: " + snapshot.lastResult);
            setText(lastError, snapshot.lastError == null || snapshot.lastError.isEmpty()
                    ? "Last error: None recorded" : "Last error: " + snapshot.lastError);
            PowerManager power = (PowerManager) getSystemService(POWER_SERVICE);
            boolean batteryExempt = power != null && power.isIgnoringBatteryOptimizations(getPackageName());
            boolean notifications = notificationsAllowed();
            setText(accessStatus, "All files access: " + (allFiles ? "Allowed" : "Not allowed")
                    + "\nNotifications: " + (notifications ? "Allowed" : "Not allowed")
                    + "\nBattery optimization: " + (batteryExempt ? "Unrestricted" : "Optimized"));
            setText(notificationButton, notifications ? "Notification settings" : "Allow notifications");
        } finally {
            refreshing = false;
        }
    }

    private boolean notificationsAllowed() {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        return manager != null && manager.areNotificationsEnabled()
                && (Build.VERSION.SDK_INT < 33 || checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)
                == PackageManager.PERMISSION_GRANTED);
    }

    private void requestNotifications() {
        boolean requested = getPreferences(MODE_PRIVATE).getBoolean("notifications_requested", false);
        if (Build.VERSION.SDK_INT >= 33 && checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED
                && (!requested || shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS))) {
            getPreferences(MODE_PRIVATE).edit().putBoolean("notifications_requested", true).apply();
            requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS}, NOTIFICATIONS_REQUEST);
        } else {
            openSettings(new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
                    .putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName()),
                    new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageUri()));
        }
    }

    @Override public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == NOTIFICATIONS_REQUEST) refresh();
    }

    private void openAllFilesSettings() {
        openSettings(new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, packageUri()),
                new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION));
    }

    private void openBatterySettings() {
        PowerManager power = (PowerManager) getSystemService(POWER_SERVICE);
        if (power != null && power.isIgnoringBatteryOptimizations(getPackageName())) {
            openSettings(new Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS),
                    new Intent(Settings.ACTION_SETTINGS));
        } else {
            openSettings(new Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS, packageUri()),
                    new Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS));
        }
    }

    private Uri packageUri() {
        return Uri.parse("package:" + getPackageName());
    }

    private void openSettings(Intent intent, Intent fallback) {
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException | SecurityException error) {
            try {
                startActivity(fallback);
            } catch (ActivityNotFoundException | SecurityException missing) {
                message("This Android device does not expose the requested settings screen.");
            }
        }
    }

    private void showLicenses() {
        StringBuilder notices = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getAssets().open("third-party-notices.txt"), StandardCharsets.UTF_8))) {
            char[] buffer = new char[4096];
            int count;
            while ((count = reader.read(buffer)) != -1) notices.append(buffer, 0, count);
        } catch (IOException error) {
            new AlertDialog.Builder(this).setTitle("License asset unavailable")
                    .setMessage("The bundled license notices could not be read. Reinstall the complete "
                            + "source-built release before redistributing this app.")
                    .setPositiveButton("Close", null).show();
            return;
        }
        ScrollView licenseScroll = new ScrollView(this);
        TextView licenseText = text(notices.toString(), 14, foreground, false);
        licenseText.setTextIsSelectable(true);
        licenseText.setPadding(dp(20), dp(12), dp(20), dp(12));
        licenseScroll.addView(licenseText);
        new AlertDialog.Builder(this).setTitle("Open source licenses")
                .setView(licenseScroll).setPositiveButton("Close", null).show();
    }

    private String versionName() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException impossible) {
            throw new IllegalStateException("Installed package metadata unavailable", impossible);
        }
    }

    private LinearLayout column() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        return layout;
    }

    private LinearLayout card(LinearLayout parent, String heading) {
        LinearLayout layout = column();
        layout.setPadding(dp(18), dp(14), dp(18), dp(16));
        GradientDrawable shape = new GradientDrawable();
        shape.setColor(cardColor);
        shape.setCornerRadius(dp(18));
        layout.setBackground(shape);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
        params.setMargins(0, dp(14), 0, 0);
        parent.addView(layout, params);
        layout.addView(text(heading, 21, foreground, true));
        return layout;
    }

    private TextView text(String value, int size, int color, boolean heading) {
        TextView view = new TextView(this);
        view.setText(value);
        view.setTextColor(color);
        view.setTextSize(size);
        view.setPadding(0, dp(5), 0, dp(5));
        if (heading) {
            view.setTypeface(null, android.graphics.Typeface.BOLD);
            view.setAccessibilityHeading(true);
        }
        return view;
    }

    private Button button(String label) {
        Button button = new Button(this);
        button.setText(label);
        button.setAllCaps(false);
        button.setMinHeight(dp(52));
        button.setSingleLine(false);
        button.setTextColor(foreground);
        button.setBackgroundTintList(ColorStateList.valueOf(dark ? Color.parseColor("#304854")
                : Color.parseColor("#D7E8EC")));
        return button;
    }

    private Switch toggle(String label) {
        Switch view = new Switch(this);
        view.setText(label);
        view.setTextSize(16);
        view.setTextColor(foreground);
        view.setMinHeight(dp(56));
        view.setPadding(0, dp(8), 0, dp(8));
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        view.setSwitchPadding(dp(12));
        return view;
    }

    private void formatButton(Button button, boolean selected) {
        if (button.isSelected() == selected && button.getTag() != null) return;
        button.setTag(Boolean.TRUE);
        button.setSelected(selected);
        button.setStateDescription(selected ? "Selected output format" : "Not selected");
        button.setTextColor(selected ? background : foreground);
        button.setBackgroundTintList(ColorStateList.valueOf(selected ? accent
                : dark ? Color.parseColor("#304854") : Color.parseColor("#D7E8EC")));
    }

    private static void setText(TextView view, String value) {
        if (!value.contentEquals(view.getText())) view.setText(value);
    }

    private static String bytes(long value) {
        if (value < 1024) return value + " B";
        if (value < 1024L * 1024) return String.format(Locale.US, "%.1f KiB", value / 1024.0);
        if (value < 1024L * 1024 * 1024) return String.format(Locale.US, "%.1f MiB", value / (1024.0 * 1024));
        return String.format(Locale.US, "%.2f GiB", value / (1024.0 * 1024 * 1024));
    }

    private int dp(int value) {
        return Math.round(value * getResources().getDisplayMetrics().density);
    }

    private void message(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private static final class CategoryViews {
        Switch enabled;
        Switch delete;
        Button avif;
        Button webp;
        TextView format;
    }
}
