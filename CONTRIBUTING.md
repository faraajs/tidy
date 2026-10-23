# Contributing to Tidy

The maintained 2.3 app is authored source under `app/src/main/`, built with Gradle and pinned native dependencies. `sources/`, `bytecode/`, and `resources/` preserve **historical 2.2.0 recovery references**; they are not compiled and are not the original preferred source. Preserve that distinction.

## Useful contributions

- Improve the current scoped monitoring, source-retention/publication safety, conversion correctness, accessibility, or Android lifecycle behavior with focused changes and regression evidence.
- Add policy/state unit tests and synthetic conversion fixtures for the custom Android instrumentation runner.
- Review exact dependency source identities, build configurations, licenses/notices, and corresponding-source packaging. An upstream homepage alone is not source provenance.
- Correct documentation using current authored methods and observed runtime evidence. Label historical findings explicitly.
- Recover the original 2.2.0 project or matching native source/build materials as historical evidence; do not substitute current dependency sources for proof about the old APK.

## Before proposing a change

1. Read [build instructions](docs/BUILD-FROM-SOURCE.md), [architecture](docs/ARCHITECTURE.md), [third-party provenance](docs/THIRD-PARTY-NOTICES.md), and, for historical claims, [recovery notes](docs/RECOVERY-NOTES.md).
2. Identify the source revision and app version. For runtime evidence, record APK hash, Android/API version, ABI, runner/commands, and observed results. Distinguish facts from inference and compilation from device verification.
3. Keep handwritten source separate from recovery output. Preserve historical anchors/artifact identity and do not silently rewrite decompiler failures or claim exact recovery.
4. For behavioral changes, provide a failing-before/passing-after scenario using synthetic/disposable images. Cover the affected orientation, dimensions, metadata removal, codec/fallback, publication collisions, source mutation, retention, deletion consent, or pause behavior. Do not weaken safety checks merely to make a fixture pass.
5. Never commit signing keys/keystores, credentials, tokens, personal media, private logs, machine/device identifiers, or local absolute paths. Keep SDKs, emulators, build products, caches, and the withheld historical APK outside tracked release inputs.

Public release/commit identity uses **faraajs** and a GitHub noreply address, not a personal name/email. Do not import private workstation paths or identities into public documentation, attribution or source-archive metadata.

## Review expectations

Keep changes focused. Explain intentional policy, migration, Android compatibility, or dependency changes. Preserve default original retention and explicit deletion consent. Treat lossy encoding, photo resizing, metadata removal, and process-death/external-writer limits as documented behavior, not guarantees. Do not claim universal hardware compatibility, archival fidelity, legal immunity, or reproducible builds from a successful compile.

### Build and host tests

Use Java 17, Android SDK 36, NDK `27.1.12297006`, and CMake `3.22.1`; the wrapper pins Gradle `9.4.1` and AGP `9.2.1`.

```sh
./gradlew assembleDebug testDebugUnitTest assembleDebugAndroidTest
```

Host tests in `app/src/test/` cover Android-independent state/path logic; stat-dependent activation/fingerprint checks belong in `app/src/androidTest/` because Android 11's File and NIO readers truncate subsecond precision. Production uses `Os.stat`/`st_mtim` milliseconds for eligibility, stability and fingerprints; a host filesystem result cannot prove that behavior on Android. Compilation alone does not exercise native Android image conversion. Native dependencies use pinned sources/digests, not recovered `.so` files. See the build guide for dependency archives and unsigned-by-default release builds. Signing configuration and protected/offline key backups must remain outside the checkout; never include private signing material in source bundles or issue reports.

### Night-batch verification (2.3.1-night.1)

The `monitor` and `battery` scenarios below exercise the retired continuous-monitoring contract. They are historical evidence, not acceptance tests for this branch. Use the host schedule tests and `nightBatch` / `nightBatchLifecycle` instrumentation instead; see [night-batch behavior](docs/BATTERY-PATCH.md).

For explicitly authorized physical-device testing, build with `-PisolatedDeviceTest=true -Pandroid.injected.build.abi=arm64-v8a` so the debug app uses `id.eska.tidy.batterytest`, with a matching `.test` package. Select the exact device serial and use `am instrument -w -r` to retain custom result fields. `nightBatch` uses owned generated media, isolated preferences and injected time/power gates without changing the device clock or reading personal media. `nightBatchLifecycle` exercises the actual job/dashboard and is restricted to outside the real night window. The `full` scenario additionally requires `-e physicalFixtures true` and the isolated package on a physical device; it uses generated fixtures. Do not run broad instrumentation against the primary installed app. Remove only temporary test packages afterward, never clear primary app data.

### Custom Android instrumentation

**Use only an isolated, disposable emulator with synthetic media. Never run this workflow on personal devices or media.** Explicitly target its serial; do not rely on whichever device ADB happens to select. Earlier codec/state checks used Android 36 AOSP ATD x86_64. Use a full AOSP image such as API 30 for OS settings/dashboard and Android 11 timestamp/observer checks; the minimal ATD image is not a substitute for OS-settings smoke. Record API/ABI and final artifact-specific results separately, without implying physical-arm64 or OEM coverage.

After building, install the matching debug app and test APK on that emulator:

```sh
adb -s <emulator-serial> install -r app/build/outputs/apk/debug/app-debug.apk
adb -s <emulator-serial> install -r app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk
adb -s <emulator-serial> shell am instrument -w -r id.eska.tidy.test/id.eska.screenshotwebp.ConversionInstrumentation
```

This is a custom runner, not an AndroidJUnitRunner/Compose test suite. Use its reported results, not installation success, as evidence. It exercises real native AVIF and conversion behavior with disposable fixtures. Debug instrumentation targets the matching debug build; it is not proof that a signed release APK was installed/tested. Release verification must separately identify and exercise the final signed artifact. Sanitize any excerpts before sharing; do not publish raw private device logs.

The separate `-e scenario gallery` mode may run on an explicitly selected physical device: it uses isolated preferences and uniquely owned generated Pictures/cache fixtures, and never starts monitoring or accesses personal image bytes. Do not run the broad emulator-only suite on a personal device. A smaller output alone is insufficient for deletion: exercise a complete, readable platform-decoded Gallery image and exact-original retention when indexing is unavailable. MediaStore width/height can legitimately be unknown; decoded dimensions, not incidental metadata defaults, are the pixel oracle.

For monitoring regressions, exercise the real `FileObserver`, not a synthetic callback alone: hold an empty CREATE open longer than the 350 ms stability interval, write a disposable image, then close it. `CLOSE_WRITE` must refresh pending metadata and bypass that file's empty/unstable CREATE cooldown while preserving reservations for executing conversions. The observed regression timed out after 12 seconds before the fix and produced output 659 ms after close-write with the fix; timing is evidence, not an SLA. Test both sides of a same-second activation boundary and subsecond fingerprint changes on Android.

## Licensing

Contributions to application-owned code/documentation are under **GPL-3.0-only**, consistent with [LICENSE](LICENSE). Confirm your right to contribute; identify the origin/license of imported material and preserve third-party notices. Native/Java/runtime dependency changes must update their exact source/digest records and matching source/license materials, including `native/compiler-runtime-sources.json` for the conservative NDK runtime disclosure. Retain immutable base inputs, original Android patches/recipes, reconstruction procedure and all per-file notices; do not imply a byte-identical compiler/runtime rebuild or that a full compiler/SDK must be shipped. See the [GPL System Libraries boundary](docs/THIRD-PARTY-NOTICES.md#gpl-notices-and-installation-of-modifications). Keep dated modification records in [CHANGELOG](CHANGELOG.md). License text and patent grants have conditions; neither an audit nor GPL licensing grants immunity from unrelated legal claims.

The original 2.2.0 APK remains withheld until its own source/provenance obligations are resolved; publishing a new source-built app does not clear it. New binary distribution must include its matching corresponding-source and notices, not just historical Java references.

## Reporting an issue

Include the app/source version, affected category, requested and actual output format, Android version, ABI, relevant installation/signature history, and minimal reproduction with non-private synthetic JPEG/PNG files. State whether originals were retained and whether monitoring/deletion was enabled. Include only a sanitized error message and relevant method/test reference; never attach personal screenshots, keys, unredacted paths, or private device logs. Data-loss reports should preserve independent backups and any hidden Tidy source-backup file rather than repeating the operation on the only copy.
