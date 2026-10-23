# Changelog

Current authored releases and historical recovery records are separated below. The original 2.2.0 release date is unknown; its recovery revisions retained version name `2.2.0` and were not separate published releases. Historical evidence remains in [Recovery notes](docs/RECOVERY-NOTES.md).

## 2.3.1-night.1 — 2026-10-23 (prerelease)

- Preserve the original 2.3.1 compression and file-safety behavior; replace continuous monitoring with one persisted charging/idle night job targeting 03:00–06:00 local time, with a screen-off check.
- Remove folder observers, recurring scans and the foreground monitor. Missed or unfinished batches wait for another night; there is no daytime catch-up.
- Preserve activation boundaries and durable opt-in so daytime media remains eligible. Restore scheduling after boot/unlock/update/time changes without scanning immediately.
- Publish the same signed ARM64 APK installed on the developer phone. 24 host tests and 42 physical-device checks passed; actual overnight execution and daily battery savings remain unmeasured.
- Add the [author's note, usage and verification limits](releases/v2.3.1-night.1/RELEASE-NOTES.md). This release addresses battery drain observed during personal use of 2.3.1, without claiming a measured battery-saving percentage.

## 2.3.1 — 2026-10-12

- Fixed disappearance from Gallery when original deletion was enabled: explicitly scan the replacement and require a complete image row, readable matching bytes and platform-decoded dimensions before deleting anything.
- Retain the valid output and unchanged original when Gallery indexing or platform decoding is unavailable. Unknown MediaStore dimensions are not mistaken for an invalid bitmap.
- Pause monitoring and revoke both original-deletion consents once on upgrade, preserving 2.3 category settings, formats, counters, actual reclaimed-byte accounting, theme and processed history.
- Removed redundant full-image decoding and published-output hashing while preserving exact-byte, source-identity and live-consent checks.
- Enabled baseline ARM64 NEON in source-built AOM for AVIF. Optional newer ARM extensions remain off; x86_64 remains generic. WebP still uses Android's platform codec, and screenshot quality/resolution are unchanged.
- Added isolated generated-image Gallery checks and a consent-migration regression; see [release evidence](releases/v2.3.1/RELEASE-NOTES.md).

## 2.3.0 — 2026-10-11

Newly authored reconstruction, not recovery of the original Kotlin/Gradle checkout or a byte-identical 2.2.0 rebuild. This entry records source changes, not a completed GitHub upload.

- Added a working Java 17/Android Gradle project targeting Android 36, supporting Android 11+ and `arm64-v8a`/`x86_64`; historical `sources/`, `bytecode/`, and `resources/` are not compiled.
- Replaced opaque recovered codec binaries with source-built libavif 1.4.2 and libaom 3.14.1, pinned source identities, matching source/license materials, and native/Java dependency notices available in the app.
- Authored a native View dashboard, dark/light preference, separate category/format controls, permission controls, Start/Pause, status/counters/errors, and new vector icons.
- Restricted input to JPEG/JPG/PNG below `Pictures/Screenshots`, `DCIM/Screenshots`, and `DCIM/Camera`, with canonical-path exclusions and activation-time boundaries renewed on Start/resume. Older untouched media and pause backlog are not swept.
- Replaced Android 11's subsecond-truncating File/NIO modification-time reads with `Os.stat`/`st_mtim` milliseconds for activation gates, stable metadata and durable fingerprints.
- Fixed real-observer `CLOSE_WRITE`/`MOVED_TO` handling to refresh pending CREATE snapshots and bypass empty/unstable-file cooldown without replacing running conversions. The empty-CREATE regression timed out after 12 seconds before the fix and produced output 659 ms after close-write with the fix; this is not a promised latency.
- Defaulted category enablement, monitoring, and original deletion to off. Original retention adds outputs rather than reclaiming space; reclaimed-byte accounting requires actual successful deletion.
- Added collision-safe publication, output verification, source-change checks, explicit per-category deletion consent, and recoverable backup handling. These measures do not eliminate external-writer/process-death risks; independent backups remain necessary.
- Implemented lossy AVIF/WebP conversion and category-specific fallback, oriented pixel output, photo resizing/size search, and deliberate EXIF/XMP/GPS removal. Size targets and savings are not guaranteed.
- Added scoped monitoring, persistent deduplication, live configuration checks, opt-in restart handling, and special-use foreground service. No network permission, telemetry, or uploads.
- Migrated available legacy formats/counters while resetting monitoring/category/deletion consent and excluding unproven historical savings.
- Added conservative NDK runtime preferred sources via `native/compiler-runtime-sources.json`: immutable LLVM runtime/support inputs, exact Android recipes and 71 selected original patches, with 21 projected runtime/support patches applied by the source reconstruction procedure. This is not a byte-identical compiler/runtime rebuild or a requirement to bundle the full compiler/SDK.
- Introduced a **new release signing certificate**, not the historical debug key. Different-certificate installations require backup and manual uninstall before installation.
- Verified both ABI builds, 12 host tests and all 19 Android conversion/state scenarios against the signed API 30 x86_64 release, plus real unavailable-codec fallback and close-write checks. Exercised dashboard/theme persistence, scoped serial burst/moved-to handling, pause/resume, durable restart deduplication and actual opt-in/no-consent boot behavior. Signature and APK/ELF 16 KiB alignment passed. No physical arm64, all-OEM or byte-for-byte reproducibility claim.
- Removed invalid drawable-to-mipmap aliases; minimum API 30 uses the authored adaptive launcher icons, and release vital lint passes without suppressing the resource error.

Publication is gated on final verification and delivery of `tidy-v2.3.0-universal.apk`, `tidy-v2.3.0-corresponding-source.tar.gz`, and `SHA256SUMS.txt` together at the [v2.3.0 release page](https://github.com/faraajs/tidy/releases/tag/v2.3.0). The historical 2.2.0 APK remains withheld independently of this new release.

## 2.2.0 — recovered changes

### Screenshot selection recovery

- Restored visible AVIF/WebP screenshot format chips.
- Persisted the screenshot format selection and passed it to the converter.
- Kept AVIF as the default. Added a one-time migration from the old forced-AVIF build's legacy `screenshot_format=WEBP` value to AVIF, before a fresh user choice.
- Fixed the first recovery build's launch `VerifyError` in `AppStateStore.migrateLegacyState()`: preserved `p0` as the store object and used `v0` for the migration editor.

The historical patch left the existing screenshot converter, AVIF-to-WebP fallback, serial screenshot queue, orientation handling, output verification/replacement path, and photo/48MP pipeline unchanged. This records patch scope, not proof that the historical replacement path was safe; see [historical safety limits](docs/ARCHITECTURE.md#orientation-publication-and-deletion-limits).

### arm64 packaging and UI

- Removed `armeabi-v7a`, `x86`, and `x86_64` native library copies for the arm64-only variant, reducing the package from approximately 74 MiB to 30 MiB while retaining the arm64 libraries and other contents.
- Added a persisted dark/light preference controlled from the dashboard header.
- Applied the Tidy artwork to adaptive and legacy launcher icons.
- In UI revision r2, restored `.locals 7` in the patched `MainActivity.onCreate` lambda to stop parameter/working-register aliasing. Static checks passed, but the user still reported a launch crash; r2 was not considered a working release.
- In UI revision r3, fixed the remaining `MainActivity.Header` verifier fault by saving integer flags in `v26` around the theme-button invocation and restoring `v0` before the generated `updateScope` path.

Historical evidence records an r3 launch on SM-G770F with `Status: ok`, a live process, and no new app crash. This is not a current device check or a comprehensive conversion/compatibility test.

## Recovery repository publication

- Preserved the final r3 application's 92 smali files and decoded resources using apktool 2.10.0.
- Documented Java recovery with jadx 1.5.6; see [decompilation status and limitations](docs/DECOMPILATION.md).
- Recorded artifact identity, checksum, debug-signing continuity, installation risks, architecture, and source-build limitations.
- Licensed application-owned recovered code and documentation under GPL-3.0-only, without overriding third-party licenses.
- Prepared release notes and the checksum for the local r3 APK only. The original signing key and original Kotlin/Gradle project remain missing.

**The historical 2.2.0 APK remains withheld.** Recovered application Java is not necessarily its preferred form for modification, and matching native source/patch/build provenance for that binary remains unresolved. The current source-buildable 2.3.0 app is a separate artifact and does not resolve those historical obligations. See [third-party provenance](docs/THIRD-PARTY-NOTICES.md) and [historical release notes](releases/v2.2.0/RELEASE-NOTES.md).
