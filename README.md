# Tidy

Automatic screenshot and photo conversion to AVIF or WebP on Android.

![License: GPL-3.0-only](https://img.shields.io/badge/license-GPL--3.0--only-blue)
![Android 11+](https://img.shields.io/badge/Android-11%2B-green)
![64-bit ABIs](https://img.shields.io/badge/ABI-arm64--v8a%20%7C%20x86__64-blue)

**2.3.0 is a newly authored, source-buildable Android app**, not the recovered original project or a byte-identical rebuild of 2.2.0. It uses Java/platform Views and source-built libavif/libaom. Historical `sources/`, `bytecode/`, and `resources/` are references only and are not compiled into the app.

**Publication status:** [Tidy 2.3.0 is published](https://github.com/faraajs/tidy/releases/tag/v2.3.0) with the signed universal APK, complete corresponding-source archive and `SHA256SUMS.txt`. The original 2.2.0 APK remains withheld because its preferred source and matching native provenance are unresolved. See [historical recovery notes](docs/RECOVERY-NOTES.md) and [2.2.0 release notes](releases/v2.2.0/RELEASE-NOTES.md).

## What it does

- Separate screenshot and photo controls, with AVIF selected by default and WebP available; category-specific fallback can select another format when the requested codec cannot produce a verified candidate.
- Converts eligible JPEG/JPG/PNG files in **only** `Pictures/Screenshots` and `DCIM/Screenshots` for screenshots, and `DCIM/Camera` for photos, beneath shared storage. Hidden, cache, Android, and escaping/redirected paths are excluded; generated AVIF/WebP files are not inputs.
- Processes files whose modification time is at or after category activation. Starting/resuming monitoring renews that boundary, so existing media and the pause backlog are not swept. Android `Os.stat` supplies millisecond timestamps for the gate, stability checks and fingerprints; Android 11's File and NIO readers were observed to truncate subsecond precision. A later modification can make an older file eligible; this is a timestamp policy, not proof of when a picture was taken.
- Uses one screenshot worker and at most two photo workers, folder observers, periodic reconciliation, and persistent processed-file fingerprints. A completed `CLOSE_WRITE`/`MOVED_TO` refreshes pending stability work and bypasses an empty/unstable CREATE cooldown, without replacing an executing conversion.
- Provides a native dashboard with persisted dark/light mode, counters, progress, last result/error, Start/Pause, permission controls, and dependency licenses.
- Resumes monitoring after boot/unlock/package replacement only when previously requested, an eligible category is enabled, storage is unlocked, and access is available. Android/OEM restrictions can still stop it.

### Safety and conversion limits

**Both categories, monitoring, and original deletion start disabled. Originals are retained by default.** Keeping the original adds another file; it does not reclaim storage. The saved-byte counter records actual positive savings from successful original deletion, not a prediction.

Conversion is **lossy**. Screenshots retain their oriented dimensions; photos can be resized, with a nominal 2560-pixel long-edge bound and further reductions during size search. File-size targets are not guarantees. EXIF orientation is applied to pixels, but outputs deliberately omit GPS, EXIF/XMP, timestamps, camera identity, and other original metadata. Do not use Tidy as an archival or lossless workflow.

Deletion requires a separate confirmation for each category. It is permitted only after a verified smaller output, unchanged source checks, and a fresh consent check. Existing output files are not overwritten. Errors retain the source or its recoverable backup; an interrupted or contested restore may leave a hidden `.<original>.tidy-source-backup-<UUID>` file beside the source. External writers and process death still create limits: these checks are not a transaction or a backup guarantee. **Keep an independent backup before enabling monitoring, especially before opting into irreversible original deletion.** Pause stops new dispatch; in-flight work may finish or preserve its source. Read [conversion safety limits](docs/ARCHITECTURE.md#authored-23-publication-and-source-safety).

## Download and installation

Requirements: **Android 11/API 30+** and a **64-bit `arm64-v8a` or `x86_64`** device. The universal APK means these two ABIs, not every CPU or device; 32-bit ARM/x86 are unsupported.

Download these assets together from the [official v2.3.0 page](https://github.com/faraajs/tidy/releases/tag/v2.3.0), not an untrusted mirror:

- `tidy-v2.3.0-universal.apk`
- `tidy-v2.3.0-corresponding-source.tar.gz`
- `SHA256SUMS.txt`

1. In the directory containing the downloaded assets, verify both file hashes:
   ```sh
   sha256sum -c SHA256SUMS.txt
   ```
   A checksum detects changed bytes but does not authenticate the publisher if the APK and checksum are both replaced. Compare with the official release record.
2. Using Android SDK Build Tools, verify the APK signature:
   ```sh
   apksigner verify --verbose --print-certs tidy-v2.3.0-universal.apk
   ```
   The **new 2.3.0 release certificate** (`CN=Tidy Release, O=Tidy`) has SHA-256:
   ```text
   27c165f0a6f13f8b01ed6628bd1a2e8f61daeb3b33438c6808f41f331aa45389
   ```
   Stop if verification fails or the certificate differs from the official release record. This is not the historical 2.2.0 debug certificate or the lost original signing key.
3. **Back up images independently and record existing settings before migration.** Android cannot update an app signed with a different certificate. In that case, manually uninstall the old app only after backing up, then install 2.3.0; uninstalling removes local app settings. Tidy does not uninstall anything for you. Matching package name/version does not promise an in-place update, and a same-certificate update is still subject to Android's installer checks. Where legacy settings are present, formats/counters may migrate but category enablement, monitoring, and deletion consent are reset; unproven historical savings are not imported.
4. Enable **Install unknown apps** for the browser/file manager you use, open the APK, and follow Android's installer. Turn that permission off afterward if unnecessary.
5. Open Tidy, grant all-files access and notification permission as applicable, choose a category/format, and enable the category. Leave **Delete originals** off. Start monitoring explicitly and check the dashboard and ongoing notification. Battery-optimization exemption is optional and does not override vendor restrictions.
6. Create a disposable JPEG/PNG in one of the listed folders **after starting**. Inspect output pixels, orientation, dimensions, metadata removal, and original retention before using important media.

Optional ADB installation after the same checks:

```sh
adb -s <device-serial> install tidy-v2.3.0-universal.apk
```

Use `install -r` only when an existing installation has a compatible certificate; it cannot bypass a signature mismatch. The repository and corresponding-source bundle do not include private signing keys.

### Verification limits

Both ABIs have been source-built. **12 host policy/state tests passed; the signed release passed all 19 Android conversion/state scenarios on an API 30 full AOSP x86_64 emulator.** These exercised real AVIF/WebP, alpha, all eight EXIF pixel orientations, metadata removal, bounded targets, collisions, guarded deletion/retention, rollback conflicts, live consent, migration and millisecond activation/fingerprint boundaries. A separate private native-library-omitted fixture proved real WebP fallback for both categories. The empty-CREATE regression failed its 12-second wait before correction and produced verified WebP **440 ms after close-write** on the final release; this is an observation, not a latency guarantee.

Actual dashboard smoke covered dark/light rendering and cold-relaunch theme persistence, a serial screenshot burst, moved-to input, old-media/category exclusion, pause-backlog exclusion, durable restart deduplication, photo activation and actual boot restoration before opening the Activity. Explicit Pause remained stopped after another real reboot. The APK signature and APK/ELF **16 KiB** alignment passed; artifact identity is recorded in [release notes](releases/v2.3.0/RELEASE-NOTES.md). Earlier Android 36 ATD codec checks are separate evidence. There is **no physical arm64 or all-OEM runtime verification claim**, background-survival guarantee, exhaustive accessibility certification or byte-for-byte app/compiler/runtime reproducibility claim.

The corresponding-source archive was extracted outside the checkout and `assembleRelease` completed successfully for both ABIs (52 tasks executed). All three published assets were downloaded without authentication; both checksums, the APK signature and 16 KiB ZIP alignment passed. A clean installation of that downloaded APK on the isolated API 30 emulator followed the actual Android all-files permission flow and converted a new synthetic screenshot to verified 128 × 96 AVIF, retaining the unchanged original with zero reclaimed bytes.

## Permissions

| Manifest permission | Why it is declared |
| --- | --- |
| `MANAGE_EXTERNAL_STORAGE` | Watch/read the listed shared-storage folders and publish outputs; delete originals only with explicit consent. This is broad OS access even though app policy narrows the folders. |
| `POST_NOTIFICATIONS` | Monitoring notifications on Android 13+. |
| `FOREGROUND_SERVICE`, `FOREGROUND_SERVICE_SPECIAL_USE` | User-enabled continuous local monitoring with an ongoing notification. |
| `RECEIVE_BOOT_COMPLETED` | Resume opted-in monitoring after boot; also handles package replacement and unlock. |
| `REQUEST_IGNORE_BATTERY_OPTIMIZATIONS` | Offer an optional exemption for background operation. |

The authored app declares **no `INTERNET` permission** and implements no uploads, analytics, or telemetry. Processing is local. `allowBackup` is false; do not rely on Android backup for settings. These facts are not a complete security audit or a promise against all privacy/data-loss risks.

## Repository map

| Path | Contents |
| --- | --- |
| `app/src/main/java/id/eska/screenshotwebp/` | Maintained 2.3.0 application source. Application ID remains `id.eska.tidy`; the older namespace is intentional, not a second app. |
| `app/src/main/cpp/` | Authored JNI and pinned libavif/libaom source-build configuration, not recovered native binaries. |
| `app/src/main/res/`, `app/src/main/assets/` | Current app resources, newly authored vector icons, and bundled dependency notices. |
| `app/src/test/`, `app/src/androidTest/` | Host policy/state tests and custom Android conversion instrumentation. |
| `native/dependencies.json`, `native/java-dependencies.json`, `native/compiler-runtime-sources.json` | Exact native/Java source identities, conservative NDK runtime preferred-source inputs, digests, recipes/patch records, and licenses. |
| [`docs/BUILD-FROM-SOURCE.md`](docs/BUILD-FROM-SOURCE.md) | Current toolchain, build, signing, and source-bundle instructions. |
| [`docs/ARCHITECTURE.md`](docs/ARCHITECTURE.md), [`docs/UI-DESIGN.md`](docs/UI-DESIGN.md) | Current behavior/UI and explicitly separated historical comparisons. |
| [`sources/`](sources/README.md), `bytecode/id/eska/screenshotwebp/`, `resources/` | **Historical 2.2.0 references, not compiled**: decompiled Java, smali, and decoded APK resources. |
| [`docs/RECOVERY-NOTES.md`](docs/RECOVERY-NOTES.md), [`releases/v2.2.0/`](releases/v2.2.0/RELEASE-NOTES.md) | Historical recovery/artifact evidence; the old APK remains withheld. |

## Build and contribute

Use Java 17, Android SDK 36, NDK `27.1.12297006`, and CMake `3.22.1`. The wrapper pins Gradle `9.4.1`; the Android Gradle Plugin is `9.2.1`.

```sh
./gradlew assembleDebug testDebugUnitTest assembleDebugAndroidTest
```

This builds the authored project, not `sources/` or `bytecode/`. Release builds are unsigned unless external signing configuration is supplied. See [build instructions](docs/BUILD-FROM-SOURCE.md) for pinned source inputs and release signing, and [CONTRIBUTING](CONTRIBUTING.md) for disposable-emulator instrumentation. The corresponding-source release asset includes build scripts, full matching native sources, Java preferred-source JARs, and conservative NDK runtime sources/Android recipes and patches with notices, not just decompiler references. It does not contain the original 2.2.0 APK or a full compiler/SDK installation.

## License and third-party components

Application-owned code/documentation is **GPL-3.0-only**; see [LICENSE](LICENSE) and the [GNU GPL v3 text](https://www.gnu.org/licenses/gpl-3.0.en.html). Third-party components retain their own licenses and notices, available in the app and [THIRD-PARTY-NOTICES](docs/THIRD-PARTY-NOTICES.md). Distribution must satisfy corresponding-source, notice, and applicable patent-license conditions; the new source-built codec path does not clear the unresolved old APK for redistribution.

There is **no warranty or legal immunity**. GPL warranty/liability exclusions apply only to the extent permitted by applicable law; they do not bind unrelated claimants or override nonwaivable rights. Auditing reduces risk, not the possibility of copyright, patent, trademark, privacy, data-loss, export, or consumer claims. This is not legal advice, legal certification, or a claim of universal AV1 patent clearance.
