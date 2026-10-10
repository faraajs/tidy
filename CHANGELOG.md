# Changelog

This is the recovered 2.2.0 history, not a reconstruction of earlier releases. The original release date is unknown. The recovery artifact revisions below retained version name `2.2.0` and are not separate published releases. Details and historical evidence are in [Recovery notes](docs/RECOVERY-NOTES.md).

## 2.2.0 — recovered changes

### Screenshot selection recovery

- Restored visible AVIF/WebP screenshot format chips.
- Persisted the screenshot format selection and passed it to the converter.
- Kept AVIF as the default. Added a one-time migration from the old forced-AVIF build's legacy `screenshot_format=WEBP` value to AVIF, before a fresh user choice.
- Fixed the first recovery build's launch `VerifyError` in `AppStateStore.migrateLegacyState()`: preserved `p0` as the store object and used `v0` for the migration editor.

The historical patch left the existing screenshot converter, AVIF-to-WebP fallback, serial screenshot queue, orientation handling, output verification, safe replacement, and photo/48MP pipeline unchanged.

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

**No public APK is published by this recovery.** Recovered application Java is not necessarily the preferred form for modification, and no pinned matching native source/patch/build bundle has yet been proven. Complete corresponding-source obligations for the exact binary must be established before any public APK upload; if unresolved, the approved path is safe source/docs-only publication. See [third-party provenance](docs/THIRD-PARTY-NOTICES.md) and [release notes](releases/v2.2.0/RELEASE-NOTES.md).
