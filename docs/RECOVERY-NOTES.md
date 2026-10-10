# Recovery notes

## Scope and provenance

Tidy's original Kotlin/Gradle checkout was lost. The earlier 2.2.0 recovery patched a preserved installed APK rather than rebuilding the original project. This repository documents that recovery and preserves application code and resources from the final r3 artifact; it does not reconstruct the original build environment or change recovered application behavior.

The historical record below is transcribed from the prior recovery workspace's `RECOVERY-NOTES.md`. Artifact names identify the sequence, not additional public releases. The patch revisions retained version name `2.2.0`; no earlier release history or original release date has been reconstructed.

### Preserved final artifact

| Field | Value |
| --- | --- |
| Local repository location | `releases/v2.2.0/tidy-v2.2.0-ui-dark-arm64-r3.apk` |
| SHA-256 | `65d0ac7a45ed45181d7fd8f43fc7b9e9dec88f7f13f58371c1dbf365dfa6ed65` |
| Size | 31,140,384 bytes |
| Application ID | `id.eska.tidy` |
| Implementation namespace | `id.eska.screenshotwebp` |
| Version name / code | `2.2.0` / `2` |
| Minimum / target SDK | API 30 / API 33 |
| Packaged ABI | `arm64-v8a` only |
| Signing certificate | Android Debug |
| Certificate SHA-256 | `56b7a02543a0f7f6d8fe300e5b90c51d779d3d4246a0397e04f1a26781c3523f` |

The APK is Git-ignored and is not supplied by cloning the public repository. Its relative-name checksum is recorded in [SHA256SUMS.txt](../releases/v2.2.0/SHA256SUMS.txt). No private signing material is included.

## Historical 2.2.0 recovery sequence

### Screenshot format selection

The initial patch restored the screenshot AVIF/WebP selection chips, persisted the selected format, and passed that selection to the converter. AVIF remained the default. A one-time migration changed the old forced-AVIF build's legacy `screenshot_format=WEBP` setting to AVIF before the user made a new selection; it was not intended to keep overwriting subsequent choices.

The historical notes report that the screenshot converter, AVIF-to-WebP fallback, serial screenshot queue, orientation handling, output verification, safe replacement, and photo/48MP pipeline were not changed. A RED regression test reproduced the forced-AVIF/hidden-chip behavior; the patched APK passed `tests/format_selection_test.sh` and an apktool decode/redecode check.

### State migration verifier crash

The first repacked build crashed on launch with a Dalvik `VerifyError` in `AppStateStore.migrateLegacyState()`. A migration branch reused `p0` for `SharedPreferences`, then accessed it as an `AppStateStore`. The fix kept `p0` typed as the store and used `v0` for the migration editor.

The corrected artifact was `tidy-v2.2.0-webp-selection-crashfix.apk`. The historical notes report re-decoding, a passing format-selection regression test, installation over the debug-signed 2.2.0 build without uninstalling, and a smoke launch on an SM-G770F: the process remained alive and `MainActivity` was resumed.

### arm64 package pruning

`tidy-v2.2.0-webp-selection-arm64.apk` removed only the `armeabi-v7a`, `x86`, and `x86_64` native library copies. The historical record says the DEX, resources, assets, manifest, and arm64 libraries were retained unchanged. Package size dropped from approximately 74 MiB to 30 MiB. This made the optimized variant suitable only for 64-bit ARM devices.

The earlier notes mentioned a universal crashfix artifact for other ABIs. That is historical context, not an available download or a binary supplied by this repository.

### Theme and launcher icon

`tidy-v2.2.0-ui-dark-arm64.apk` added a persisted dark/light theme control in the dashboard header and registered the supplied Tidy artwork as the adaptive and legacy launcher icon. The historical record says converter, monitor, orientation, and safe-replacement fingerprints remained unchanged. The APK was zipaligned and signed with the same local debug certificate, and static regression checks passed. No ADB device was enumerated during two checks, so that revision had no recorded device launch check.

### UI verifier fix, r2

The first UI revision could fail immediately because the patched `MainActivity.onCreate` lambda declared `.locals 4` instead of the recovered method's `.locals 7`. This aliased `p0`/`p1`/`p2` with working registers for theme/composer values and caused verifier-unsafe type reuse.

`tidy-v2.2.0-ui-dark-arm64-r2.apk` restored `.locals 7`. The historical notes report passing register-safety and format-selection tests, protected converter/monitor fingerprints, zipalign, and package verification. Nevertheless, the user still reported a launch crash. ADB was empty during that follow-up, so those static checks did not establish that r2 worked on a device. The notes explicitly treated r2 as untrusted and retained the known-good arm64 rollback.

### Remaining UI verifier fix, r3

A later connected-device logcat identified the remaining r2 fault: `MainActivity.Header` left `v0` holding `MainActivity$$ExternalSyntheticLambda28`, while the generated `updateScope` path needed the original integer flags. The r3 patch saved the integer in `v26`, invoked the theme button, and restored `v0`.

The historical notes report that `tidy-v2.2.0-ui-dark-arm64-r3.apk` was installed over r2 on an SM-G770F. `am start -W` returned `Status: ok`, the process stayed alive, and no new `id.eska.tidy` crash appeared. At that stage the notes recorded retaining r3 and the known-good arm64 rollback. This repository's preserved release record concerns r3 only.

## Repository extraction and Java recovery

- **apktool 2.10.0** decoded the final r3 APK. `bytecode/id/eska/screenshotwebp/` preserves the 92 application smali files, and `resources/` preserves the decoded manifest, Android resources, and assets from that artifact. Dependency resources are present too; the directory is not exclusively application-authored material.
- **jadx 1.5.6** is the Java recovery tool. Its output belongs in `sources/`; generation status, warnings, and incomplete-method limitations are recorded in [DECOMPILATION.md](DECOMPILATION.md). Do not infer that readable Java is complete or recompilable from the existence of the directory.
- Where Java recovery is incomplete, the matching smali from the final APK is the authoritative recovered application representation. Decompiler-generated exception bodies are not evidence that the original application threw those exceptions.
- The package ID and implementation namespace differ intentionally; they describe one application, not separate packages to install.

For example, with the stated tool versions and the local APK available, extraction can be performed into separate working directories:

```sh
apktool d -f releases/v2.2.0/tidy-v2.2.0-ui-dark-arm64-r3.apk -o decoded-r3
jadx -d jadx-r3 releases/v2.2.0/tidy-v2.2.0-ui-dark-arm64-r3.apk
```

These commands describe extraction, not a supported source build, and do not by themselves reproduce this repository's selected application-only Java/smali layout. They are not verification results. See the [build-from-source limitations](BUILD-FROM-SOURCE.md) and [architecture](ARCHITECTURE.md).

## Signing and installation continuity

The recovered baseline used the original `Screenshot WebP` signing certificate. Its private keystore was no longer present after cleanup. The repacked artifacts therefore used a local Android debug keystore; the original signing key has not been recovered and no private key is published.

Android rejects an in-place update when the installed application and APK have different signing certificates. Unless the original key is recovered, switching from the original-signed baseline requires uninstalling it first, which removes local app settings. Historical updates between same-debug-certificate recovery revisions did not require uninstalling. See the [installation instructions](../README.md#local-download-and-installation). Back up important media: conversion is lossy and can replace originals.

## Evidence boundaries and current verification

The launch results and regression checks above are **historical evidence from the earlier recovery**, not checks repeated for the current public-source preparation. The SM-G770F is the only device named by that historical record; no current device compatibility sweep is claimed.

Current source-publication preparation observed:

- The original APK and local release copy match the recorded SHA-256; `sha256sum -c SHA256SUMS.txt` returns `OK`.
- Android `apksigner verify --verbose --print-certs` verifies the preserved APK's v3 signature and the Android Debug certificate fingerprint recorded above.
- Android `aapt dump badging` reports the application/version/SDK metadata recorded above and `arm64-v8a` as the sole native ABI.
- Packaged assets match their extracted bytes; the recovered manifest declares no Internet permission and disables Android backup.
- Signing-material, local-property, native-binary and APK paths are excluded by `.gitignore`; commits use the public GitHub username and a GitHub noreply address rather than a personal email.

These are artifact and publication checks, not a new app launch, conversion test, or source build. Final source/decompiler results are recorded in [DECOMPILATION.md](DECOMPILATION.md); do not infer warning-free Java recovery from file existence.

## Public binary release gate

The approved publication path is **safe recovered source and documentation only if corresponding-source obligations remain unresolved**. Application-owned recovered code and documentation are licensed GPL-3.0-only; third-party components retain their own terms. That license choice is not proof that the APK can be redistributed compliantly.

Recovered application Java is not necessarily the preferred form for modifying the program. The original Kotlin/Gradle project is missing. In addition, no pinned native source/patch/build bundle matching the packaged libraries has yet been proven. Decompiled application code, upstream project links, library names, and a checksum alone do not establish complete corresponding source.

**No APK is to be publicly uploaded unless complete corresponding-source obligations for the exact binary can be established**, including the application's appropriate preferred source, the native components' matching source and patches, build/install materials, and required license notices. If that gate remains unresolved, retain the APK locally and publish only safe recovery source/docs. See [third-party provenance](THIRD-PARTY-NOTICES.md) and the [local-only release notes](../releases/v2.2.0/RELEASE-NOTES.md). There is no current public APK download promised by this repository.
