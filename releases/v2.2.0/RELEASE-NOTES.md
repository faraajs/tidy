# Tidy 2.2.0 r3 — local-only release record

**Status: prepared locally only. No public APK is published or available from this recovery repository.** APK files are excluded from Git; a source clone does not contain the binary. This document is an artifact record, not an announcement of a GitHub binary release.

Historical recovered Java, smali and decoded resources are preserved on [archive/2.2.0-reference](https://github.com/faraajs/tidy/tree/archive/2.2.0-reference), not main. Relocating these references does not change the artifact identity or resolve the binary's source/provenance gate.

## Artifact identity

| Field | Value |
| --- | --- |
| Filename | `tidy-v2.2.0-ui-dark-arm64-r3.apk` |
| Version name / code | `2.2.0` / `2` |
| Application ID | `id.eska.tidy` |
| Implementation namespace | `id.eska.screenshotwebp` |
| Size | 31,140,384 bytes (approximately 29.7 MiB) |
| SHA-256 | `65d0ac7a45ed45181d7fd8f43fc7b9e9dec88f7f13f58371c1dbf365dfa6ed65` |
| Supported ABI | `arm64-v8a` only |
| Minimum Android | Android 11 / API 30 |
| Target SDK | API 33 |
| Signing certificate | Android Debug |
| Certificate SHA-256 | `56b7a02543a0f7f6d8fe300e5b90c51d779d3d4246a0397e04f1a26781c3523f` |

Use [SHA256SUMS.txt](SHA256SUMS.txt) to check the local APK from this directory. The checksum identifies the artifact; it does not establish license compliance or production-signing trust.

## Recovered changes

- Restored the screenshot AVIF/WebP chips, saved the selected format, and passed it through to conversion.
- Retained AVIF as the default, with a one-time migration of the forced-AVIF build's legacy `screenshot_format=WEBP` setting before a new user selection.
- Fixed the state-migration verifier failure caused by treating `p0` as both a store and shared preferences.
- Removed 32-bit ARM and x86 native library copies, retaining only arm64. This APK does not support 32-bit ARM phones or x86 emulators.
- Added a persisted dark/light preference in the dashboard header and Tidy adaptive/legacy launcher icons.
- Restored the correct lambda register allocation in r2, then fixed the remaining header verifier fault in r3 by preserving integer flags around the theme-button call. r2 still had a user-reported launch crash and is not recommended.

The historical recovery notes say the converter/monitor paths, AVIF-to-WebP fallback, screenshot queue, orientation handling, output verification, safe replacement, and photo/48MP pipeline were not otherwise changed. See [the full recovery sequence](../../docs/RECOVERY-NOTES.md) and [changelog](../../CHANGELOG.md).

## Installation and data safety

Follow the [README installation instructions](../../README.md#local-download-and-installation) for the locally available artifact. **Back up important media first. Conversion is lossy and can replace original files.** Check disposable images, orientation, metadata, and replacement behavior before enabling monitoring on important media.

The original private signing key was lost. This recovered APK uses an Android debug certificate, not the baseline's original `Screenshot WebP` certificate. Android rejects an update over a different-certificate installation. Uninstalling the old application may be necessary and removes its local app settings; note settings and back up media beforehand. A same-certificate recovery installation can generally update without uninstalling. No private signing material is included in the repository.

## Evidence and known limitations

- The earlier recovery record reports installation over r2 and a successful r3 smoke launch on SM-G770F: `am start -W` returned `Status: ok`, the process remained alive, and no new `id.eska.tidy` crash appeared. This is historical evidence, not a current device test or proof of all conversion/background behaviors.
- The original Kotlin/Gradle project is missing. This tree is not a supported buildable Android checkout.
- apktool 2.10.0 supplied decoded resources and application smali from this final APK. Java recovery uses jadx 1.5.6; generation status, warnings, and incomplete-method limitations are in [DECOMPILATION.md](../../docs/DECOMPILATION.md). Generated Java can contain incomplete or misleading method bodies; consult the matching smali, not decompiler exception stubs, for recovered behavior.
- Recovered application Java is not necessarily the program's preferred form for modification. Neither it nor smali alone establishes complete corresponding source.
- No pinned native source/patch/build bundle matching the packaged codec libraries has yet been proven. Names and upstream links do not prove the origin or reproducibility of these exact libraries. See [third-party provenance](../../docs/THIRD-PARTY-NOTICES.md).
- Android permission, battery-management, and vendor background restrictions can affect monitoring. The historical device launch is not a compatibility guarantee.

## Mandatory public-binary release gate

Application-owned recovered code and documentation are GPL-3.0-only; third-party components retain their own licenses. **Do not publicly upload this APK unless complete corresponding-source obligations for the exact binary are established.** That includes the appropriate preferred application source, pinned matching native source and patches, necessary build/install materials, and required notices. Debug signing and a checksum do not satisfy that gate.

The user approved **safe recovery source/docs-only publication if these obligations remain unresolved**. Until the gate is met, retain the APK locally; do not attach it to a public release or promise a download. This record contains no public binary URL.
