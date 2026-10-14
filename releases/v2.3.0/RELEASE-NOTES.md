# Tidy 2.3.0 release notes

## Identity and distribution

This is a newly authored, source-built reconstruction, not recovered original Kotlin or a byte-identical 2.2.0 rebuild. The old 2.2.0 APK remains withheld because its preferred source and native provenance were not established.

| Field | Value |
| --- | --- |
| Application ID / namespace | `id.eska.tidy` / `id.eska.screenshotwebp` |
| Version name / code | `2.3.0` / `3` |
| Minimum / target SDK | API 30 / API 36 |
| APK ABIs | `arm64-v8a`, `x86_64` |
| Certificate identity | `CN=Tidy Release, O=Tidy` |
| Certificate SHA-256 | `27c165f0a6f13f8b01ed6628bd1a2e8f61daeb3b33438c6808f41f331aa45389` |

Published release: [v2.3.0](https://github.com/faraajs/tidy/releases/tag/v2.3.0). Assets are [`tidy-v2.3.0-arm64-x86_64.apk`](https://github.com/faraajs/tidy/releases/download/v2.3.0/tidy-v2.3.0-arm64-x86_64.apk), `tidy-v2.3.0-corresponding-source.tar.gz` and `SHA256SUMS.txt`. Download the APK, source archive and checksum file from that same release, then run in their directory:

```sh
sha256sum -c SHA256SUMS.txt
apksigner verify --verbose --print-certs tidy-v2.3.0-arm64-x86_64.apk
```

Both downloaded asset hashes must match the published checksum file; compare the signer SHA-256 with the fingerprint above. Checksums identify bytes, not legal clearance. Build/install materials and full notices are delivered with corresponding source; see [build instructions](../../docs/BUILD-FROM-SOURCE.md) and [third-party notices](../../docs/THIRD-PARTY-NOTICES.md).

The APK was originally published as `tidy-v2.3.0-universal.apk`; its current filename explicitly identifies the two supported ABIs. Relabeling the asset does not change its bytes or the observed APK digest recorded below. Historical source bundles and release evidence may retain the original name.

## Installation and safe defaults

Android rejects installation over the old differently signed package. The historical 2.2.0 debug certificate was `56b7a02543a0f7f6d8fe300e5b90c51d779d3d4246a0397e04f1a26781c3523f`; neither it nor the original signing key is reused. Back up media/settings first, then manually uninstall the old package if switching, and install the new APK through Android's installer (allow installation from that chosen source when prompted). Uninstalling removes local app settings; Tidy does not uninstall anything itself. Recipients can build/sign modifications with their own key using the same uninstall/install route; official private keys are not distributed.

Fresh installations start with **both media categories disabled, monitoring stopped, original deletion off, AVIF selected and dark theme enabled**. Migrated formats/counters may remain, but category, deletion and monitoring consent are disabled; unproven historical savings are not imported. Choose categories, grant requested OS permissions and explicitly Start monitoring. Pause clears pending work; restarting renews activation epochs so the paused backlog is ignored.

Only readable JPEG/JPG/PNG files newly created or modified after category activation are eligible, inside `Pictures/Screenshots`, `DCIM/Screenshots` or `DCIM/Camera`. Canonical path checks reject redirected roots, escapes, hidden/cache/Android subtrees; AVIF/WebP outputs are not inputs. Keeping originals is the default and therefore adds output files rather than reclaiming their storage. Optional deletion is guarded by a verified smaller output and unchanged source, but loss is still possible through device/filesystem failures; keep independent backups.

## Changes and limitations

- Authored Java platform-View dashboard, persistent dark/light theme, explicit Start/Pause, permission/status/error controls and a full Licenses view.
- Source-built AVIF using pinned libavif 1.4.2/AOM 3.14.1; Android platform WebP. No old codec binaries or HEVC-linked chain, and new authored vector artwork rather than uncertain historical art.
- Conservative NDK runtime preferred-source inputs in `native/compiler-runtime-sources.json`: immutable LLVM base and Android recipes, all 71 selected original patches, full runtime/support sources and reconstruction with 21 projected patches. The source archive also includes full matching native sources and Java preferred-source JARs/notices; it does not contain the original 2.2.0 APK or a full compiler/SDK. Source reconstruction is not a byte-identical compiler/runtime rebuild; see the [GPL System Libraries/compiler boundary](../../docs/THIRD-PARTY-NOTICES.md#gpl-notices-and-installation-of-modifications).
- Android 11 activation, stability and fingerprint timestamps use `Os.stat`/`st_mtim` milliseconds, replacing File **and NIO** readers observed to truncate subsecond precision. `CLOSE_WRITE`/`MOVED_TO` refreshes pending CREATE metadata and bypasses empty/unstable-file cooldown without replacing an executing conversion.
- Bounded workers, durable processed-file fingerprints, collision-safe outputs and checks before publication/deletion. No promise of atomicity against arbitrary external writers or power loss.
- All eight EXIF orientation transforms normalize pixels. Outputs strip original EXIF/XMP/GPS/camera identity. Conversion is lossy and photos may be resized; size targets are goals, not guarantees. Codec fallback may change the actual output format.
- No INTERNET permission, telemetry, uploads or Android app backup. Continuous user-enabled local monitoring uses a `specialUse` foreground service. Permissions, locked storage, Android background policy, battery restrictions and OEM behavior can prevent or stop monitoring; optional battery exemption does not guarantee survival.
- AVIF inputs are limited to 16,384 pixels per dimension, 16,777,216 total pixels and 64 MiB encoded bytes; oversized inputs are refused safely. Native encoding is 8-bit RGB/YUV444 with alpha and one codec thread per call.

## Evidence and release boundary

Both ABIs built successfully. **12/12 host policy/state tests passed; the signed release passed 19/19 Android conversion/state scenarios on an isolated API 30 full AOSP x86_64 emulator.** These exercise real AVIF/WebP pixels/alpha, all eight EXIF orientations, metadata removal, bounded targets, collisions, source/output-change guards, smaller-output deletion/larger-output retention, rollback conflicts, live consent, migration and millisecond activation/fingerprints. Earlier Android 36 ATD instrumentation is separate evidence, not the final suite.

A real `FileObserver` regression held an empty CREATE beyond the 350 ms stability interval before writing/closing synthetic PNG. It failed its 12-second wait before correction; the final signed release published verified WebP **440 ms after close-write**, retaining the original and reclaiming zero bytes. A separate private native-library-omitted fixture verified actual WebP fallback for screenshots and photos; it is not a distributed release asset.

Actual dashboard smoke verified dark/light rendering and cold-relaunch theme persistence. Scoped monitoring processed a serial three-screenshot burst and moved-to file, excluded old/disabled-category/download inputs, ignored a paused backlog, preserved originals and maintained deduplication after process restart. Photo activation processed a new camera image without sweeping old camera media. Actual reboot restored the opted-in foreground service and converted a new screenshot before the Activity opened; explicit Pause stayed stopped after a second reboot. The emulator's System UI stalled during boot and was recovered.

The delivered corresponding-source archive was extracted outside the checkout; `assembleRelease` built both ABIs successfully with 52 tasks executed using the documented external SDK/tooling cache. All three public assets were downloaded without authentication; both published hashes, the APK signature and 16 KiB ZIP alignment passed. A clean installation of that downloaded APK on the isolated API 30 emulator exercised actual Android all-files access settings and explicit monitoring consent, then produced verified 128 × 96 AVIF (408 bytes) from synthetic PNG (330 bytes), retaining the unchanged original and reclaiming zero bytes. Monitoring was paused afterward. This post-publication documentation update leaves the immutable release tag and APK/source assets unchanged.

The APK is non-debuggable, backup-disabled and contains no INTERNET permission. `apksigner` verified its v3 signature and the certificate above; `zipalign -c -P 16 4` passed, and every load segment in both native ELFs has 16,384-byte alignment. APK SHA-256: `5db3d943d2c45a795b589e7d1b5fb6986ba9e89e49b533a1a68c1d122bc38f03`. Matching full notices are bundled; source/history/APK privacy checks found no workstation paths, personal Git email or private signing material in the publication payload. No physical arm64, all-OEM compatibility, exhaustive accessibility, byte-identical historical recovery or app/compiler/runtime reproducibility is claimed.

GPL-3.0-only application rights and third-party notices accompany this release's source and APK asset. License conditions, source delivery and patent grants do not promise legal immunity or universal copyright/patent/trademark/privacy/consumer/export clearance. This is not legal advice or certification, and warranty/liability exclusions apply only where applicable law permits; they do not override nonwaivable law. See the [primary-license discussion](../../docs/THIRD-PARTY-NOTICES.md#legal-boundary).
