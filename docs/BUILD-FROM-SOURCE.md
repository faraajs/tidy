# Building from source: current status and reconstruction roadmap

## Current status

**This repository is a recovery reference, not a buildable Android Gradle project.** The original Kotlin sources, Gradle configuration, dependency lockfiles and native build project were not recovered. The [readable Java files](../sources/README.md) are decompiler output, not the original authored Java/Kotlin and not a claim that they compile. Compiler-generated Compose code, Kotlin metadata, synthetic callbacks and reconstructed control flow require deliberate rewriting. Some decompiled methods may be incomplete or unsuitable as implementation source; consult the [application bytecode](../bytecode/id/eska/screenshotwebp/) as the behavior evidence.

There is no supported `./gradlew assembleRelease` command here. No source build or new device verification was performed as part of this recovery. Decoding/reassembling an existing APK is not building the app and its native dependencies from corresponding source.

Local inputs are preserved separately:

| Input | Purpose and limits |
| --- | --- |
| [Readable Java references](../sources/README.md) | Recover names and explain logic; do not treat as a drop-in source tree. |
| [Application smali](../bytecode/id/eska/screenshotwebp/) | Authoritative recovered app behavior, including the final UI patch. Not a replacement for original Kotlin or native source. |
| [Manifest](../resources/AndroidManifest.xml), [resources](../resources/res/), [assets](../resources/assets/) | Extracted Android declarations/assets. Resource IDs and APK-generated files must be integrated into a new source project, not assumed to be original project configuration. |
| [Recovery notes](RECOVERY-NOTES.md) | Recovery provenance and boundaries. |
| [Third-party notices](THIRD-PARTY-NOTICES.md) | Dependency/native provenance findings and unresolved licensing/source requirements. |
| [Local release notes](../releases/v2.2.0/RELEASE-NOTES.md), [checksums](../releases/v2.2.0/SHA256SUMS.txt) | Identity of the preserved binary, not a reproducible-build result. |

The preserved artifact is `tidy-v2.2.0-ui-dark-arm64-r3.apk`, SHA-256 `65d0ac7a45ed45181d7fd8f43fc7b9e9dec88f7f13f58371c1dbf365dfa6ed65`. Its application ID is **`id.eska.tidy`**, implementation namespace **`id.eska.screenshotwebp`**, version name **2.2.0**, version code **2**, minSdk **30**, targetSdk **33**, and native ABI **arm64-v8a only**. The manifest's compile-platform metadata is not enough to recover the original AGP, Kotlin, Compose or NDK versions. Do not infer those versions from minSdk/targetSdk either.

## Native corresponding source and license gate

Application licensing is GPL-3.0; this does not erase third-party license obligations or recover missing source. Before publishing an APK as a complete GPL-compliant source release, resolve the native components actually bundled in that binary:

- `libcoder.so` and its `HeifCoder` JNI wrapper;
- `libheif.so`, `libaom.so`, `libdav1d.so`, `libde265.so` and `libx265.so`;
- `libandroidx.graphics.path.so` and any further linked/embedded components identified by the provenance review.

For each applicable component, establish the exact upstream revision/version, license text and notices, local modifications, configuration flags, compiler/NDK toolchain and linkage/dependency graph. Obtain the source and scripts needed to rebuild that shipped implementation and satisfy its particular source/notice obligations. GPL-covered corresponding source includes relevant build/install scripts; an upstream homepage, a generic current release, an isolated Java wrapper, or the `.so` itself is not enough to identify the source of the shipped binary.

`HeifCoder` loads `coder` via `System.loadLibrary` and has native encode/decode declarations. The application invokes AVIF; the wrapper also contains HEIC capabilities. That does not establish HEIC as an app feature, nor make unused bundled native components irrelevant to distribution provenance. Consult [third-party notices](THIRD-PARTY-NOTICES.md) for evidence and unresolved findings rather than assuming exact versions from library filenames.

**Gate remains unresolved until corresponding-source/license evidence is obtained.** A runnable build using copied prebuilts would still not establish a complete source-built release. Do not publish the preserved APK or a new binary merely because the recovered application references are publicly readable. Source-reference publication and binary-release compliance are distinct decisions.

## Concrete reconstruction sequence

The following is a roadmap, not an existing build recipe or a claim that the work below is complete.

### 1. Establish a new Android source project

Create and pin a Gradle wrapper, Android Gradle Plugin, Kotlin and Compose toolchain with compatible versions, repositories and dependency declarations. Record why each dependency/version was selected and what evidence matches the recovered implementation; do not present guesses as recovered build metadata.

Use `applicationId = "id.eska.tidy"`, namespace `id.eska.screenshotwebp`, minSdk 30 and targetSdk 33 for the initial behavior-matching reconstruction. A future targetSdk change requires a separate review of storage permissions, boot restrictions and foreground-service rules. Start with arm64-v8a to match the preserved APK; additional ABIs require actual native builds and acceptance evidence. Keep signing credentials outside version control.

Integrate the extracted manifest/resources/assets into normal source sets. Reconcile resource names and references using generated `R`, not hard-coded decompiler resource IDs. Retain app entry points and permissions only where supported by the recovered behavior. Review which extracted assets are generated/tooling artifacts before carrying them into a new build.

### 2. Reconstruct state and filesystem policies first

Translate the recovered models and policies into ordinary maintainable source: `OutputFormat`, `MediaCategory`, `CategoryConfig`, `AppState`, `ConversionResult`, target buckets and `PathPolicy`. Implement the synchronized device-protected `state` preferences and legacy migrations with the existing key meanings. Keep the UI `tidy_ui/dark_mode` preference separate if matching the current patch.

Explicitly preserve or deliberately document changes to the surprising behaviors in [architecture](ARCHITECTURE.md): broad non-camera screenshot scope, screenshot activation-age bypass, photo strict activation boundary, informational targets, and non-negative saved-byte accounting. Do not silently narrow the media policy to make a test pass.

### 3. Rebuild the active conversion path

Reimplement `MediaConverter` and `ScreenshotMediaConverter` against their actual smali methods, not solely the readable Java or older `ScreenshotConverter`. Preserve photo sampling/search, screenshot full-dimension quality 55, format-specific fallback order, EXIF pixel transforms, temporary/final decode verification and distinct publication strategies.

Complete the native gate above. Integrate native source through an appropriate pinned CMake/NDK or upstream build path, preserving JNI class/method signatures and encoder options; maintain auditable source/build correspondence. Android Bitmap compression supplies the observed WebP path. Do not substitute a different codec or fabricate an AVIF fallback while claiming behavior-equivalent reconstruction.

### 4. Reconstruct lifecycle, monitoring and presentation

Implement `MediaMonitor` observers/reconciliation and executor queues, canonical-path reservations/signatures and the 350 ms stability check. Preserve the single screenshot worker and two photo workers, and the current limits of in-memory deduplication. Reimplement `MonitorService` foreground notification, converter construction, outcome persistence and media scans, then `BootReceiver` startup conditions and activity permission/restart wiring.

Rewrite Compose screens as authored composables, not generated `Composer`/mask/inlined-lambda code. Follow [UI-DESIGN.md](UI-DESIGN.md), which distinguishes the intended system-theme/full-logo design from the observed boolean toggle and text header. Choosing the original intention instead of observed behavior is a product change that must be named, not called exact recovery.

### 5. Establish acceptance evidence before release

Once there is a real build, add and run policy/state tests for bucket boundaries, classification/exclusions, activation/migrations, independent formats, target-miss accounting and persisted theme semantics. Use fixture images for photo/screenshot fallback, large-image sampling, all EXIF orientation cases, decode failure and metadata behavior.

Exercise filesystem publication separately: existing destinations, temporary verification failure, failed final verification, refused source deletion, failed backup restoration, source mutation during encoding and process death. Treat observed rollback/durability limitations as facts; any hardening is a separately documented behavior change.

Run the resulting APK on compatible arm64 Android hardware using expendable media copies. Cover first-run permissions, notification/service startup, boot/unlock/package-replacement behavior, background operation, screenshot bursts, concurrent photos, category toggles, relaunch persistence and icon/theme rendering. Record exact source revision, dependency/native revisions, tool versions, commands, artifact hash and observed results. Then document the now-working build commands and remaining differences from the preserved artifact.

## Signing and reproducibility boundaries

A rebuilt app signed with a different certificate is not automatically an in-place update of the preserved installation. Matching package/version alone does not establish upgrade compatibility. The recovery does not supply or promise the original signing private key. Any future install plan must state certificate/package/version implications and avoid exposing private keys in the repository or docs.

A successful source build would establish source buildability, not byte-for-byte reproducibility of the original APK. Reproducibility requires the matching toolchain, dependencies, native inputs, packaging/signing conditions and a recorded comparison. Until then, describe the original binary as **preserved**, the Java as **readable recovery references**, and a future reconstructed build as a **separate artifact**.
