# UI: authored 2.3 dashboard and historical 2.2 evidence

The maintained 2.3 UI is implemented in [`MainActivity.java`](../app/src/main/java/id/eska/screenshotwebp/MainActivity.java), an Android `Activity` with programmatic **platform Views**, not Jetpack Compose/Material3. It is a newly authored reconstruction, not recovery of the old Kotlin UI or a claim of visual parity with the historical APK. Application ID: `id.eska.tidy`; namespace: `id.eska.screenshotwebp`; minimum Android API 30, target API 36.

The signed 2.3 release was visually exercised on an API 30 full AOSP x86_64 emulator: dark/light dashboard rendering, committed theme persistence after cold relaunch, explicit monitoring controls, counters, serial screenshot burst, category isolation, pause/resume, restart deduplication and actual opt-in/no-consent boot behavior. Earlier Android 36 ATD conversion checks are separate from this surface evidence. The emulator's System UI stalled during reboot and was recovered. This is not exhaustive accessibility, physical-arm64 or all-OEM certification; see the [release record](../releases/v2.3.0/RELEASE-NOTES.md) and [architecture](ARCHITECTURE.md).

## Authored 2.3 dashboard structure

One scrollable dashboard remains available whether monitoring is active or paused; there is no recovered `AppState.getAnyActive()` setup/dashboard branch. Content is centered with a maximum 720 dp width and rounded cards. English labels describe actual actions and state.

| Area | Implemented controls and information |
| --- | --- |
| Branding/theme | Authored vector mark, “Tidy”, “Local image conversion”, and explicit **Dark theme** switch. |
| Conversion summary | Screenshots/photos converted, **Reclaimed storage**, codec fallback count, queued/processing counts, service/request status, Start/Pause, last result and last error. |
| Screenshots / Photos | Independent category switches, exact folder paths, AVIF/WebP buttons with selected-state descriptions, codec-fallback explanation and separate Delete originals switches. |
| Before you convert | Future-media/activation policy, pause/in-flight limits, lossy conversion, possible photo resizing, metadata stripping, nonguaranteed targets and backup warning. |
| Android permissions | Actual All files/notifications/battery status, OS permission/settings actions; battery exemption is optional. |
| Privacy and version | Installed version, Android 11 minimum, release/device architectures, local-only processing and Open source licenses dialog. |

The category folder text is produced by `PathPolicy.roots`: screenshots only under shared-storage `Pictures/Screenshots` and `DCIM/Screenshots`; photos only under `DCIM/Camera`, including eligible descendants. It is not the historical “all non-camera shared storage” policy. Only JPEG/JPG/PNG inputs qualify; generated AVIF/WebP outputs are excluded. Enabling creates an activation epoch; Start after pause renews enabled epochs, ignoring the pause backlog. Eligibility uses millisecond file modification time from `Os.stat`/`st_mtim`, not verified camera capture time; Android 11 File/NIO readers truncate that precision.

## Authored 2.3 theme, icons and insets

`AppStateStore.darkMode()` reads device-protected `tidy_ui/dark_mode`, default **true**; the unlocked migration can import the historical activity preference. The switch persists the boolean and recreates the Activity. True selects `Theme.Tidy.Dark` and explicit dark View colors; false selects `Theme.Tidy.Light` and explicit light colors. It is a **dark/light choice**, not “Follow system”. The Activity preserves scroll position across recreation and refreshes if the saved theme changes while away.

The current [`res/`](../app/src/main/res/) contains newly authored `ic_tidy` and launcher foreground vectors, API-26 adaptive normal/round launcher icons, and drawable-backed mipmap aliases for the nonadaptive names. The header actually renders `R.drawable.ic_tidy` in a 56 dp ImageView; the decorative image is excluded from accessibility announcements beside the text name. No recovered supplied artwork or historical density PNG is compiled into the new UI.

For API-36 edge-to-edge behavior, the root applies `systemBars`, `displayCutout` and IME insets as padding, with dark/light status/navigation-bar appearance and navigation-bar contrast enforcement. Scrollable content, accessibility headings, textual format state descriptions, scalable text sizes, buttons at least 52 dp high and switches at least 56 dp high are implemented. These provisions are not a substitute for observed text-scaling, contrast, screen-reader or OEM rendering checks.

## Authored 2.3 consent and lifecycle

Fresh state has categories disabled, AVIF selected, deletion off and monitoring unrequested. Migration preserves supported formats and nonnegative historical counts/fallbacks, but requires new category/monitoring/deletion consent. Changing settings alone does not imply a running service.

**Start monitoring** requires an enabled category and All files access. It saves the monitoring request before dispatching `MonitorService.start`. The service further validates user-unlocked/writable-mounted storage and saved consent; status distinguishes active monitoring, missing access/category, a request with service not running, and pause. The process-local `MonitorService.isRunning()` plus current prerequisites are used for the active label; it is not proof that every observer/OEM background guarantee is healthy.

**Pause monitoring** saves request=false and stops the service. Pending work/observers are cleared during close; executing workers are not forcibly interrupted. In-flight work may finish a safe output or retain its source, with live configuration checked before publication/deletion. Disabling the final category or losing All files access stops requested monitoring. Returning from settings can resume an already requested monitor if prerequisites are satisfied; it does not grant a new request. The one-second dashboard refresh runs only while the Activity is resumed.

Enabling deletion opens a category-specific AlertDialog; the switch remains off until **Enable deletion** is confirmed. **Keep originals** or cancellation leaves it off. The dialog warns about permanent deletion, irreversible lossy/photo resizing, stripped GPS/EXIF/camera metadata, external-storage/other-app failure and the need for a separate backup. Turning deletion off needs no confirmation. Consent is independent for screenshots/photos.

The permission buttons use Android's All files settings; notification permission on Android 13+ or notification settings; and battery-optimization request/settings. Permission callbacks and Activity resume refresh displayed status. Settings fallbacks report when a device exposes no suitable screen. Notification/battery permission controls do not guarantee Android or an OEM will allow uninterrupted foreground operation. Boot/package/unlock restoration requires the existing request and service prerequisites, never silent new consent.

## Authored 2.3 data and safety honesty

- Summary values come from `AppStateStore.Snapshot`, not fabricated examples. `pending`/`processing` are process-local queue counts, not per-file percentage progress or a durable job list. Last result/error are shared most-recent diagnostics, not a historical per-category log.
- Fresh counters are zero; migrated conversion/fallback counts may include historical events. Unproven historical savings are **not** imported. Reclaimed storage adds only `sourceBytes - outputBytes` for a verified smaller output whose original was actually deleted. Keeping both files reclaims zero and adds output storage; totals are not current free-disk measurement.
- Results show the actual codec, dimensions, bytes, retained/deleted source, codec fallback and missed target. AVIF selection does not promise AVIF output. Screenshots allow AVIF → WebP, selected WebP screenshots have no fallback, and photos allow either direction when a codec yields no valid candidate.
- Screenshots retain oriented dimensions at quality 55/100 KiB informational target. Photos use power-of-two sampling with nominal 2,560-pixel long edge, then bounded scale/quality search and 100–750 KiB buckets. They may be substantially smaller in resolution. Target misses can still yield valid outputs.
- All eight EXIF orientations are normalized in pixels. Outputs do not preserve source GPS/EXIF/XMP/camera identity, original ICC/HDR information or reversible source quality. Native AVIF has bounded resources; large/invalid inputs can fail without conversion.
- Both categories publish collision-safe `stem.tidy[ (n)].avif`/`.webp` without replacing existing outputs. Deletion is only permitted after output verification, strict size reduction, unchanged captured source and matching live consent. A source backup is renamed/restored without replacement; if restore is blocked, it is retained under its hidden backup name rather than overwrite a recreated source. No crash journal, automatic backup restoration, undo or process-death/power-loss guarantee exists. Read the [full safety sequence](ARCHITECTURE.md#authored-23-publication-and-source-safety) before enabling deletion.
- Processing has no network permission, uploads, analytics or telemetry; Android app backup is disabled. Preferences/history are local. The licenses dialog displays selectable bundled [`third-party-notices.txt`](../app/src/main/assets/third-party-notices.txt), including native/Java and NDK runtime notices. Its presence is not legal immunity or a universal patent-clearance claim.

## Historical 2.2 UI evidence

**All sections below are historical.** Existing headings/anchors are retained for references to the inspected `2.2.0` UI-dark arm64 r3 APK; they do not describe the new View dashboard. The old implementation was Compose/Material3 under `id.eska.screenshotwebp`, with largely Indonesian visible strings. Static inspection was not a new launch, screenshot comparison, accessibility audit or conversion device test.

Primary evidence: [MainActivity bytecode](../bytecode/id/eska/screenshotwebp/MainActivity.smali), [button-label composables](../bytecode/id/eska/screenshotwebp/ComposableSingletons$MainActivityKt.smali), [AppState](../bytecode/id/eska/screenshotwebp/AppState.smali), [state store](../bytecode/id/eska/screenshotwebp/AppStateStore.smali), [extracted resources](../resources/res/) and [manifest](../resources/AndroidManifest.xml). See [recovery notes](RECOVERY-NOTES.md).

## Earlier design intention

The historical recovery workspace's `2026-08-16-tidy-dashboard-ui-design.md` specified a UI/theme/icon-only refresh, retaining conversion behavior:

- Dark navy dashboard, rounded cards/chips, accessible contrast and blue-purple accents from the supplied icon.
- Header branding/subtitle, monitoring status/service controls, actual conversion/saved-byte totals, separate category cards with format/settings/result/error.
- Queue/activity only where existing state exposed it; no invented activity/savings.
- Persisted “Always dark” (`Selalu gelap`) or “Follow system” (`Ikuti sistem`), default dark.
- Adaptive mark/light background, legacy density icons and complete supplied image as an in-app logo without loading a large source image during rendering.
- No encoder/converter/fallback/EXIF/deletion changes, database, background worker, network permission, dependency or automatic-reprocessing policy.

These were requirements, not proof of implementation or exercised smoke/static regression tests. They do not constrain the separately authored 2.3 reconstruction to old conversion behavior.

## Observed UI structure

Historical Compose/Material3 uses lazy lists, cards, switches, selectors and permission buttons. `AppState.getAnyActive()` branches to setup if no category is active, dashboard otherwise; it is **not** a running-service check. Activation persists state/starts monitoring; category/format changes update the store; the shared header's `Atur` callback toggles theme/recreates the Activity.

| Historical area | Evidence and limits |
| --- | --- |
| Header | “Tidy”, Indonesian subtitle meaning screenshots/photos organized automatically, and patched theme callback. |
| Setup | Notifications, All files and unrestricted-battery controls plus activation; not an OEM service guarantee. |
| Summary | State-derived saved bytes, successful count and fallback count, not fixed saving percentages. |
| Categories | Separate labels/active-paused switch/format/count/savings/result/error; format keys `screenshot_format`/`photo_format`. |
| Service | Permission statuses and repair/restart; readiness is not measured service health. |
| Queue | Memory-only internal executors, but no observed queue-depth/per-file progress in `AppState` or UI; intended queue/activity card is not established. |

The historical Screenshot label covers eligible non-camera images throughout shared storage, including older files. Historical photo sampling can reduce resolution. Neither broad scope nor old screenshot age bypass is the authored 2.3 policy.

## Theme: the important divergence

The historical patch is a boolean override, not the specified Always dark/Follow system pair:

1. `isDarkMode()` reads ordinary activity `tidy_ui/dark_mode`, default true, separate from device-protected `state`.
2. True uses `createDarkColorScheme()`.
3. False passes no explicit scheme and follows the Material3 default/inherited path; no system-dark query is observed, so “Follow system” is unsupported.
4. Header outlined button is `Atur` (“Set/Configure”), calling `toggleDarkMode()`.
5. Toggle negates the preference, calls `apply()` and `Activity.recreate()`.

That established a static persisted path, not a relaunch result or exact non-dark device colors. The new 2.3 UI instead makes its dark/light semantics explicit.

## Icons and logo

Historical manifest icons are `@mipmap/ic_launcher` and `@mipmap/ic_launcher_round`. Extracted [adaptive](../resources/res/mipmap-anydpi/ic_launcher.xml) and round adaptive icons reference `@color/tidy_icon_background` and `@drawable/tidy_icon_foreground`; legacy density PNGs are preserved as evidence.

The complete supplied in-app logo was an intention. Historical `Header` renders text; no call rendering the complete image was found. A launcher foreground PNG is not proof of the header requirement, cropping or visual parity. These historical assets are not the authored 2.3 icon resources.

## Data honesty and behavioral boundaries

Historical initial counts/saved bytes are zero with no-conversion empty result; there is no basis for invented demonstration totals. Saved bytes add `max(sourceBytes - outputBytes, 0)` on success, not free disk space or output-growth/replacement accounting. Screenshot AVIF has WebP fallback; photos fall back either way. Target miss can be a success without an output-size/deletion guarantee. Orientation handling does not prove general EXIF preservation, losslessness or recoverable deletion; historical failure can fall back to untransformed pixels.

The earlier documentation recovery did not introduce runtime behavior or establish byte-for-byte regression comparisons. Those historical boundaries must not be read as current 2.3 accounting/deletion behavior.

## Future acceptance work, not completed checks

The historical recovery proposed first-run/setup/dashboard, permission, theme/relaunch, category, totals/error, icon, contrast/text scaling and touch-target checks, plus expendable-media burst/scope/sampling/fallback/orientation/metadata/deletion regressions. Those proposals did not establish checks of the old APK. Preserve the [original release identity](../releases/v2.2.0/RELEASE-NOTES.md); the separately authored 2.3 artifact has its own current smoke evidence described above, not retrospective verification of 2.2.
