# Tidy

Automatic screenshot and photo conversion to AVIF or WebP on Android.

![License: GPL-3.0-only](https://img.shields.io/badge/license-GPL--3.0--only-blue)
![Android 11+](https://img.shields.io/badge/Android-11%2B-green)
![64-bit ABIs](https://img.shields.io/badge/ABI-arm64--v8a%20%7C%20x86__64-blue)

**2.3.1-night.1 is the charging-only night-batch prerelease**, built on the original Gallery-safe 2.3.1 compression. It replaces continuous monitoring with a fixed 03:00–06:00 local schedule, charging and screen-off checks. See the [author's note](releases/v2.3.1-night.1/RELEASE-NOTES.md#catatan-pembuat--faraajs) for why this version was made after battery drain during personal use.

**Release assets:** get the signed **ARM64-only** APK, complete corresponding-source archive and `SHA256SUMS.txt` from the [v2.3.1-night.1 release](https://github.com/faraajs/tidy/releases/tag/v2.3.1-night.1). The previous [2.3.1 stable release](https://github.com/faraajs/tidy/releases/tag/v2.3.1) remains available. Native compression and quality settings are unchanged; a full overnight run and daily battery savings have not yet been measured. The original 2.2.0 APK remains withheld; see [historical recovery notes](docs/RECOVERY-NOTES.md).

**Upgrade from 2.3.0:** that version could delete an original before its replacement was ready in Gallery. Pause it and leave original deletion off. A converted `.tidy.webp`/`.tidy.avif` file may still exist even if Gallery does not show it; do not assume the original PNG can be recovered. The 2.3.1 upgrade pauses monitoring and resets deletion consent while preserving category settings, formats, counters, theme and processed history.

## What it does

- Separate screenshot and photo controls, with AVIF selected by default and WebP available; category-specific fallback can select another format when the requested codec cannot produce a verified candidate.
- Converts eligible JPEG/JPG/PNG files in **only** `Pictures/Screenshots` and `DCIM/Screenshots` for screenshots, and `DCIM/Camera` for photos, beneath shared storage. Hidden, cache, Android, and escaping/redirected paths are excluded; generated AVIF/WebP files are not inputs.
- Processes files whose modification time is at or after category activation. Enabling/resuming automation renews that boundary; scheduled nights keep it unchanged so eligible media accumulated during the day can be processed later. Older untouched media and the explicitly paused backlog are not swept. Android `Os.stat` supplies millisecond timestamps for the gate, stability checks and fingerprints; Android 11's File and NIO readers were observed to truncate subsecond precision. A later modification can make an older file eligible; this is a timestamp policy, not proof of when a picture was taken.
- Uses one screenshot worker and at most two photo workers in a finite night batch, with persistent processed-file fingerprints. No folder observers, periodic scans or continuous foreground service run during the day. The native Android job requires charging and idle; each new conversion also checks the 03:00–06:00 window and screen-off state.
- Provides a native dashboard with persisted dark/light mode, counters, progress, last result/error, Enable/Pause night batch, permission controls, and dependency licenses.
- Restores the schedule after boot/unlock/package replacement and clock changes when automation was requested and a category is enabled. Storage/access must be available before work starts. Android may delay or stop a batch; missed or unfinished work waits until another night, with no daytime catch-up.

### Safety and conversion limits

**Both categories, monitoring, and original deletion start disabled. Originals are retained by default.** Keeping the original adds another file; it does not reclaim storage. The saved-byte counter records actual positive savings from successful original deletion, not a prediction.

Conversion is **lossy**. Screenshots retain their oriented dimensions; photos can be resized, with a nominal 2560-pixel long-edge bound and further reductions during size search. File-size targets are not guarantees. EXIF orientation is applied to pixels, but outputs deliberately omit GPS, EXIF/XMP, timestamps, camera identity, and other original metadata. Do not use Tidy as an archival or lossless workflow.

Deletion requires a separate confirmation for each category. It is permitted only after a verified smaller output is indexed as an image and readable/decodable through Android's Gallery content URI, unchanged source checks, and a fresh consent check. If indexing or platform decoding is unavailable, the output and original are retained with zero reclaimed bytes. Existing output files are not overwritten. Errors retain the source or its recoverable backup; an interrupted or contested restore may leave a hidden `.<original>.tidy-source-backup-<UUID>` beside it. These checks are not a transaction or backup guarantee. **Keep an independent backup before enabling monitoring or irreversible deletion.** Pause stops new dispatch; in-flight work may finish or preserve its source. See [conversion safety limits](docs/ARCHITECTURE.md#authored-23-publication-and-source-safety).

## Download and installation

Requirements: **Android 11/API 30+** and **`arm64-v8a`** for the published APK. Source still supports `x86_64`, but this prerelease has no x86_64 or universal binary. 32-bit ARM/x86 are unsupported.

Download these assets together from the [night-batch release](https://github.com/faraajs/tidy/releases/tag/v2.3.1-night.1):

- `tidy-2.3.1-night.1-arm64.apk`
- `tidy-v2.3.1-night.1-corresponding-source.tar.gz`
- `SHA256SUMS.txt`

1. In the directory containing the downloaded assets, verify both file hashes:
   ```sh
   sha256sum -c SHA256SUMS.txt
   ```
   A checksum detects changed bytes but does not authenticate the publisher if the APK and checksum are both replaced. Compare with the official release record.
2. Using Android SDK Build Tools, verify the APK signature:
   ```sh
   apksigner verify --verbose --print-certs tidy-2.3.1-night.1-arm64.apk
   ```
   The **official release certificate**, unchanged since 2.3.0 (`CN=Tidy Release, O=Tidy`), has SHA-256:
   ```text
   27c165f0a6f13f8b01ed6628bd1a2e8f61daeb3b33438c6808f41f331aa45389
   ```
   Stop if verification fails or the certificate differs from the official release record. This is not the historical 2.2.0 debug certificate or the lost original signing key.
3. **Back up images independently.** Official 2.3.1 installations can update to 2.3.1-night.1 without uninstalling; settings, counters, consent and processed history are preserved. The earlier 2.3.0-to-2.3.1 consent migration still applies if applicable. Android cannot update an app signed with a different certificate: back up media/settings before manually uninstalling such a package, then install the new APK. Uninstalling removes local settings. Tidy never uninstalls anything itself; same-certificate installation remains subject to Android's installer checks.
4. Enable **Install unknown apps** for the browser/file manager you use, open the APK, and follow Android's installer. Turn that permission off afterward if unnecessary.
5. Open Tidy, grant all-files access and notification permission as applicable, choose a category/format, and enable the category. Leave **Delete originals** off. Choose **Enable night batch** once and check for **Scheduled — 03:00–06:00 · charging, screen off**. Existing opted-in automation is restored after updating. Leave the phone charging with the screen off while asleep; Tidy need not stay open. Battery-optimization exemption is optional and does not override vendor restrictions.
6. Create a disposable JPEG/PNG in one of the listed folders **after enabling**. It waits for an eligible night. Inspect its output and original retention afterward. Unplugging, waking the screen, pausing, or reaching 06:00 prevents new conversions; an already running file may finish safely. Avoid force-stop or revoking file access if you want automatic scheduling.

Optional ADB installation after the same checks:

```sh
adb -s <device-serial> install tidy-2.3.1-night.1-arm64.apk
```

Use `install -r` only when an existing installation has a compatible certificate; it cannot bypass a signature mismatch. The repository and corresponding-source bundle do not include private signing keys.

### Verification limits

For **2.3.1-night.1**, 24 host tests and 42 physical Android 13 ARM64 checks passed: 16 night-batch, 3 lifecycle, 20 converter and 3 Gallery checks. Controlled night tests inject time/power conditions; lifecycle checks exercise real Android job registration. Four deterministic compression outputs and the ARM64 native library match original 2.3.1. Signing and 16 KiB alignment passed. Lint reported 0 errors and 10 warnings per variant.

The same APK was installed in place on the developer phone; the job survived ordinary process reclamation with no foreground monitor. **Actual overnight 03:00 execution and daily battery savings have not yet been observed.** No absolute 0 mAh or all-OEM automation guarantee is claimed. See the [current release notes](releases/v2.3.1-night.1/RELEASE-NOTES.md) and [night-batch behavior](docs/BATTERY-PATCH.md). Earlier dual-ABI/emulator evidence remains specific to [2.3.1](releases/v2.3.1/RELEASE-NOTES.md) and [2.3.0](releases/v2.3.0/RELEASE-NOTES.md).

## Permissions

| Manifest permission | Why it is declared |
| --- | --- |
| `MANAGE_EXTERNAL_STORAGE` | Scan/read the listed shared-storage folders during a night batch and publish outputs; delete originals only with explicit consent. This is broad OS access even though app policy narrows the folders. |
| `POST_NOTIFICATIONS` | Retained notification access on Android 13+; no continuous foreground monitoring notification is used. |
| `RECEIVE_BOOT_COMPLETED` | Persist/restore the opted-in night schedule after boot; also handles package replacement, unlock and clock changes. |
| `REQUEST_IGNORE_BATTERY_OPTIMIZATIONS` | Offer an optional exemption for background operation. |

The authored app declares **no `INTERNET` permission** and implements no uploads, analytics, or telemetry. Processing is local. `allowBackup` is false; do not rely on Android backup for settings. These facts are not a complete security audit or a promise against all privacy/data-loss risks.

## Repository map

| Path | Contents |
| --- | --- |
| `app/src/main/java/id/eska/screenshotwebp/` | Maintained 2.3 application source. Application ID remains `id.eska.tidy`; the older namespace is intentional, not a second app. |
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

This builds the authored project, not `sources/` or `bytecode/`. For the published ARM64-only release, pass `-Pandroid.injected.build.abi=arm64-v8a -Pandroid.injected.testOnly=false` to `assembleRelease`; default builds still select both ABIs. Release builds are unsigned unless external signing configuration is supplied. See [build instructions](docs/BUILD-FROM-SOURCE.md) for pinned source inputs and release signing, and [CONTRIBUTING](CONTRIBUTING.md) for disposable-emulator instrumentation. The corresponding-source release asset includes build scripts, full matching native sources, Java preferred-source JARs, and conservative NDK runtime sources/Android recipes and patches with notices, not just decompiler references. It does not contain the original 2.2.0 APK or a full compiler/SDK installation.

## License and third-party components

Application-owned code/documentation is **GPL-3.0-only**; see [LICENSE](LICENSE) and the [GNU GPL v3 text](https://www.gnu.org/licenses/gpl-3.0.en.html). Third-party components retain their own licenses and notices, available in the app and [THIRD-PARTY-NOTICES](docs/THIRD-PARTY-NOTICES.md). Distribution must satisfy corresponding-source, notice, and applicable patent-license conditions; the new source-built codec path does not clear the unresolved old APK for redistribution.

There is **no warranty or legal immunity**. GPL warranty/liability exclusions apply only to the extent permitted by applicable law; they do not bind unrelated claimants or override nonwaivable rights. Auditing reduces risk, not the possibility of copyright, patent, trademark, privacy, data-loss, export, or consumer claims. This is not legal advice, legal certification, or a claim of universal AV1 patent clearance.
