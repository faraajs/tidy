# Tidy

Automatic screenshot and photo conversion to AVIF or WebP on Android.

![License: GPL-3.0-only](https://img.shields.io/badge/license-GPL--3.0--only-blue)
![Android 11+](https://img.shields.io/badge/Android-11%2B-green)
![arm64](https://img.shields.io/badge/ABI-arm64--v8a-blue)
![Recovered source](https://img.shields.io/badge/source-recovered%20reference-orange)
![APK release withheld](https://img.shields.io/badge/APK%20release-withheld-orange)

**Recovery repository, not a buildable Android project.** The original Kotlin/Gradle checkout is lost. `sources/` contains Java generated from the preserved 2.2.0 r3 APK; `bytecode/` preserves the application smali where decompilation is incomplete. Neither is a replacement for the original preferred source or complete corresponding source.

**No public download is published by this recovery.** The APK is prepared locally, but public binary distribution is gated on recovering the bundled native libraries' corresponding source, build materials, and notices. See [third-party provenance](docs/THIRD-PARTY-NOTICES.md) and [release notes](releases/v2.2.0/RELEASE-NOTES.md).

## What it does

- Watches screenshot and photo directories in the background.
- Lets each category select AVIF or WebP; AVIF is the default.
- Falls back from AVIF to WebP when the recovered conversion path requires it.
- Uses serial processing within the recovered monitoring queues.
- Handles image orientation and checks output before replacing originals. The inspected converters do **not** copy general EXIF metadata; GPS, timestamps, camera tags, and other metadata can be lost.
- Shows category counters, storage saved, last results/errors, and service controls in a Compose dashboard.
- Persists category settings and a dark-mode toggle; the non-dark branch uses the default/inherited Material3 scheme, not an established “follow system” mode.
- Includes boot/package-update receivers to resume activated monitoring, subject to Android and device background restrictions.

Savings depend on the input image, format, quality, and scaling. No measured 60–80% saving is claimed here. Conversion is lossy and can replace original files: back up important media first.

## Local download and installation

**Monitoring scope is broader than the labels suggest:** the screenshot category can process pre-existing eligible non-camera images throughout shared storage, not only new screenshots. Photos can be sampled to lower resolution, and a verified output can replace its source even when it is larger. Read the [conversion safety limits](docs/ARCHITECTURE.md#orientation-publication-and-deletion-limits) before activation.

The prepared asset is `releases/v2.2.0/tidy-v2.2.0-ui-dark-arm64-r3.apk` in the local recovery checkout. APKs are excluded from Git; cloning this source repository will **not** supply that binary. The [GitHub Releases page](https://github.com/faraajs/tidy/releases) currently has no APK download. After redistribution is cleared and a release is actually published, obtain its assets there rather than from an untrusted mirror.

Requirements: Android 11/API 30 or newer and a 64-bit ARM device (`arm64-v8a`). x86 emulators and 32-bit ARM devices are not supported by this APK.

1. Verify the prepared APK before installing:
   ```sh
   cd releases/v2.2.0
   sha256sum -c SHA256SUMS.txt
   ```
2. Back up media and note existing settings. This APK uses an **Android debug certificate**, not the lost original signing key. Android will reject an update over an installation signed with a different certificate. If necessary, uninstall the old application first; this removes its local settings. Same-certificate installations can generally update without uninstalling.
3. On the phone, enable **Install unknown apps** for the file manager/browser you use, open the APK, and follow the installer. Turn that permission off afterward if no longer needed.
4. Open Tidy. Grant all-files access and notification permission when requested, then configure/activate the screenshot and photo categories and start monitoring. Check the persistent notification and dashboard state.
5. Allow the battery-optimization exemption if you want more reliable monitoring. Vendor background limits can still stop the service.
6. Try a disposable image first and check the output, orientation, retained metadata, and original-file handling before using real media.

Optional ADB installation, after the same signature checks:

```sh
adb install -r releases/v2.2.0/tidy-v2.2.0-ui-dark-arm64-r3.apk
```

Debug signing is for this preserved recovery artifact, not a production signing recommendation. The repository contains no private signing key.

## Permissions

| Manifest permission | Why it is declared |
| --- | --- |
| `MANAGE_EXTERNAL_STORAGE` | Access and watch media directories and replace converted files. Broad access: enable only if you trust the app. |
| `POST_NOTIFICATIONS` | Display monitoring notifications on Android 13+. |
| `FOREGROUND_SERVICE` | Run the foreground monitoring service with a visible notification. |
| `RECEIVE_BOOT_COMPLETED` | Resume previously activated monitoring after boot; the receiver also handles package replacement and user unlock. |
| `REQUEST_IGNORE_BATTERY_OPTIMIZATIONS` | Request exemption from battery optimization for background monitoring. |
| `id.eska.tidy.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` | Signature-protected receiver permission generated for internal receiver handling. |

The recovered manifest declares no `INTERNET` permission. This is a manifest observation, not a complete privacy/security audit. `allowBackup` is false, so do not rely on Android backup to preserve app settings.

## Repository map

| Path | Contents |
| --- | --- |
| [`sources/`](sources/README.md) | Readable decompiled application Java, including generated classes. |
| `bytecode/id/eska/screenshotwebp/` | Application smali recovered from the same final APK; reference for incomplete Java methods. |
| `resources/` | Decoded manifest, Android resources, and assets from the final APK. Includes dependency resources; not only app-authored assets. |
| [`docs/ARCHITECTURE.md`](docs/ARCHITECTURE.md) | Components and conversion/monitoring flow. |
| [`docs/RECOVERY-NOTES.md`](docs/RECOVERY-NOTES.md) | Artifact provenance, recovery commands, limitations, and verification evidence. |
| [`docs/UI-DESIGN.md`](docs/UI-DESIGN.md) | Dashboard design and differences between intent and the recovered implementation. |
| [`docs/BUILD-FROM-SOURCE.md`](docs/BUILD-FROM-SOURCE.md) | Why this tree does not build and the concrete recovery roadmap. |
| [`releases/v2.2.0/`](releases/v2.2.0/RELEASE-NOTES.md) | Local release notes and checksum; the APK itself is Git-ignored. |

Package/application ID: `id.eska.tidy`. Recovered implementation namespace: `id.eska.screenshotwebp`. The older namespace is intentional, not a second application.

## Build and contribute

There is no Gradle wrapper, original dependency lockfile, or recovered native build here. Running `./gradlew assembleDebug` is **not** supported. Start with the [build-from-source roadmap](docs/BUILD-FROM-SOURCE.md) and [contribution guide](CONTRIBUTING.md). Do not treat decompiler-generated exception bodies as the application's real behavior.

## License and third-party components

Application-owned recovered code and documentation are licensed under **GPL-3.0-only**; see [LICENSE](LICENSE). Third-party code, resources, and libraries retain their respective terms. GPL licensing this tree does not establish permission to redistribute every component or satisfy binary corresponding-source obligations. The APK contains x265 and other native codec libraries; see [THIRD-PARTY-NOTICES](docs/THIRD-PARTY-NOTICES.md) before distributing any binary.
