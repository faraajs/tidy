# Third-party notices and binary provenance

## Scope and publication status

Tidy 2.3.1 is a newly authored GPL-3.0-only application with source-built native AVIF, not a relabeling of the recovered 2.2.0 APK. The original APK remains withheld. Historical findings below do not describe the current runtime and are not retroactively cleared by the reconstruction. No rights in unrelated historical artwork, extracted assets or third-party code are asserted by the root license.

The [2.3.1 release](https://github.com/faraajs/tidy/releases/tag/v2.3.1) pairs `tidy-v2.3.1-universal.apk` with `tidy-v2.3.1-corresponding-source.tar.gz` and `SHA256SUMS.txt`. Download matching assets together; see [build instructions](BUILD-FROM-SOURCE.md).

### Current source-built components

[`native/dependencies.json`](../native/dependencies.json) pins libavif 1.4.2 at `c5240fc79fe5c2407e10afd35f5505ef6333ea49` and AOM 3.14.1 at `03087864cf4bea6abb0d28f95cf7843511413d8f`, with immutable archive SHA-256 values, configuration and notice hashes. The current `tidyavif` JNI library includes BSD-licensed libavif/AOM and their embedded components. Libavif includes scalar libyuv code and a VideoLAN/dav1d-author notice in `src/obu.c`; disabling external libyuv does not remove those obligations. AOM includes fastfeat and vector notices. The complete upstream LICENSE files and AOM PATENTS, not abbreviated license labels, are retained. No recovered HeifCoder, libheif, dav1d shared library, libde265 or x265/HEVC chain is compiled.

The native library also statically contains the NDK C++ compiler runtime, distinct from Android platform/system libraries supplied by the device. Its LLVM Apache-2.0-with-LLVM-exception and legacy runtime notices are included in the full APK license asset. [`native/compiler-runtime-sources.json`](../native/compiler-runtime-sources.json), referenced by `native/dependencies.json`, conservatively records preferred-source inputs for libc++, ABI, unwinder and compiler-rt portions selected by the native link.

Those materials retain immutable LLVM base `3c92011b600bdf70424e2547594dd461fe411a41`, the exact Android recipes/patch revision `2a4ee244d6dd0dcb8365590b898f7a40ec3cb87a`, full runtime/support subtrees, source information, inventories and all **71 selected original patches**. The bundled reconstruction procedure projects complete runtime/support diff sections and applies **21 patches** in metadata-array order with zero fuzz; see [reconstruction instructions](BUILD-FROM-SOURCE.md#conservative-ndk-runtime-preferred-sources). This is preferred-source provenance and source reconstruction, **not an independently byte-identical compiler/runtime rebuild**, a full LLVM compiler-source bundle or certification of the original NDK build environment.

[`native/java-dependencies.json`](../native/java-dependencies.json) records exact source JAR URLs/digests for AndroidX ExifInterface 1.4.2, annotation-jvm 1.8.1, JSpecify 1.0.0, Kotlin stdlib 2.2.10 and JetBrains annotations 13.0. These have Apache-2.0 notices; Kotlin additionally retains BSD-3-Clause ThreeTenBP and BSL-1.0 Boost excerpts from its [matching license tree](https://github.com/JetBrains/kotlin/tree/v2.2.10/license). The app uses Java platform Views, but AGP resolves the listed Kotlin runtime transitively. Android's platform WebP and framework/system libraries are supplied by the device, not copied from the old APK.

Full application GPL, native copyright/license/patent texts and Java notices are bundled in [`app/src/main/assets/third-party-notices.txt`](../app/src/main/assets/third-party-notices.txt), accessible through the app's Licenses screen. The corresponding-source bundle includes authored source/build scripts, exact native archives/full sources, Java preferred-source JARs with original per-file notices, POM/Gradle metadata, conservative runtime base/patched sources, original Android recipes/patches and reconstruction inputs, and full license materials. The original 2.2.0 APK, SDK/AVD installation and private signing material are excluded. BSD source and binary notices must accompany redistribution. The build-tool Gradle wrapper is Apache-2.0; retain its copyright/attribution notices and the [full Apache text](licenses/Apache-2.0.txt). Build-tool licensing is distinct from app-runtime inventory.

### GPL, notices and installation of modifications

Preserve copyright notices and the full [GPL version 3](https://www.gnu.org/licenses/gpl-3.0.en.html), including warranty notices. GPL-3.0-only is the application's licensing election, not a relicensing of third-party works. For modified covered files, provide prominent notices of modification and relevant dates; the 2.3.0 cutover is newly authored reconstruction, not recovered original preferred source. Keep applicable upstream notices and identify modifications to third-party materials rather than inventing ownership.

When distributing object code, satisfy GPL section 6 with the exact Corresponding Source and its required interface/build/install scripts, using a permitted delivery method; the release uses accompanying downloadable source, not merely an upstream link. If the User Product provisions apply, supply required Installation Information so recipients can install/run modified covered software. Android recipients can build/sign their own APK and, after backing up media/settings, uninstall the differently signed package and install their build. No private official signing key is needed for this documented route; do not impose additional restrictions inconsistent with GPL. See GPL sections 4–6, 7, 10–12 and 15–17 for the actual conditions, patent provisions and disclaimers.

GPLv3's Corresponding Source definition excludes qualifying **System Libraries** and general-purpose tools used unmodified that are not part of the work; its System Libraries definition includes certain compiler-associated libraries under the stated conditions. See the primary [GPL text](https://www.gnu.org/licenses/gpl-3.0.en.html) and [GNU FAQ on the System Library exception](https://www.gnu.org/licenses/gpl-faq.html#SystemLibraryException). That boundary is not a blanket exemption for everything statically linked, nor a definitive legal classification supplied by this inventory. The NDK runtime preferred-source materials are an **additional conservative disclosure**; they are not a claim that shipping/rebuilding the entire Android SDK or compiler is a GPL requirement. Device-provided Android libc/libm/libdl and OS/JNI interfaces are not copied into the APK by this disclosure. The public-release verification/packaging gates are project acceptance controls, not independently invented legal conditions or a promise of legal immunity.

### Patent and Apache conditions

The exact pinned AOM [LICENSE](https://aomedia.googlesource.com/aom/+/03087864cf4bea6abb0d28f95cf7843511413d8f/LICENSE) and [PATENTS](https://aomedia.googlesource.com/aom/+/03087864cf4bea6abb0d28f95cf7843511413d8f/PATENTS) are primary texts. AOM Patent License 1.0 covers the licensors' defined Necessary Claims subject to its conditions, including reproduction of the text with implementations (source root for source distributions; accompanying written/legal materials for non-source distributions), and its defensive termination provisions. It is not a license to every possible third-party patent or a universal AV1 patent-clearance certificate.

Under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0), preserve the license and applicable notices, mark modified files, and reproduce relevant upstream NOTICE attributions when supplied. Its section 3 patent grant is limited to the stated contributor claims and terminates for the specified patent litigation. Section 6 does not grant general trademark rights. Read the exact license rather than treating a permissive copyright label as unlimited patent permission.

### Legal boundary

This inventory and source delivery reduce identified risks; they are not legal advice, a lawyer's opinion, certification, a promise never to be sued, or universal copyright/patent/trademark clearance. They do not settle privacy, data-loss, consumer-protection or export-law obligations. Local-only operation and absence of telemetry do not supply rights to unrelated content. License warranty/liability disclaimers operate only to the extent applicable law allows; they do not bind strangers or override nonwaivable law. No additional restrictive terms are imposed on GPL rights.

### Historical 2.2.0 record

The remaining sections concern only local-only `tidy-v2.2.0-ui-dark-arm64-r3.apk`, SHA-256 `65d0ac7a45ed45181d7fd8f43fc7b9e9dec88f7f13f58371c1dbf365dfa6ed65`. Its original preferred application source and matching native source/patch/build bundle were not recovered. See its [local release record](../releases/v2.2.0/RELEASE-NOTES.md), [checksums](../releases/v2.2.0/SHA256SUMS.txt) and [recovery notes](RECOVERY-NOTES.md). A checksum establishes identity, not license clearance.

## Evidence and its limits

The APK archive contains exactly these seven native library files under `lib/arm64-v8a/`:

- `libcoder.so`
- `libheif.so`
- `libaom.so`
- `libdav1d.so`
- `libde265.so`
- `libx265.so`
- `libandroidx.graphics.path.so`

The inspected dependency wrapper is **`com.radzivon.bartoshyk.avif.coder.HeifCoder`**. It loads `coder` through `System.loadLibrary` and declares native encode/decode methods. Application converters invoke its AVIF path. Its HEIC capabilities and the presence of HEVC libraries do not establish an exposed HEIC application feature; nor does an unused capability exempt a bundled component from redistribution obligations.

The [architecture's native-boundary evidence](ARCHITECTURE.md#native-boundary-and-unresolved-provenance) records the observed ELF `DT_NEEDED` edges:

| Bundled library | Observed dependencies on other bundled libraries |
| --- | --- |
| `libcoder.so` | `libheif.so`, `libaom.so`, `libdav1d.so`, `libde265.so`, `libx265.so` |
| `libheif.so` | `libde265.so`, `libx265.so` |
| `libaom.so`, `libdav1d.so`, `libde265.so`, `libx265.so` | No other bundled library in the observed dynamic dependency lists |
| `libandroidx.graphics.path.so` | No other bundled library in the observed dynamic dependency list; separately bundled from the codec chain |

Android system libraries also occur in those dependency lists. The table is not a complete software bill of materials: dynamic edges do not reveal all statically embedded source, patches, runtime plugin behavior or which encoder actually executes for an image. In particular, this binary's `libheif.so` does not list AOM or dav1d as dynamic dependencies; both are direct `libcoder.so` dependencies.

Read-only inspection of printable strings in the preserved APK found the following version clues. These are **observed binary text, not a source-match or unmodified-upstream claim**:

| Library | Observed version text / limit |
| --- | --- |
| `libaom.so` | `3.10.0` |
| `libheif.so` | `1.21.2` |
| `libdav1d.so` | `1.5.1-0-g42b2b24` |
| `libde265.so` | `1.0.16` |
| `libx265.so` | An encoder build annotation identifies Clang 19.0.0, 64-bit, no assembly, 8-bit. No exact upstream release/revision was established. |
| `libcoder.so` | No wrapper version was established. A `1.1.1` string and mentions of other codec versions are not sufficient to assign a `HeifCoder` dependency version. |
| `libandroidx.graphics.path.so` | An Android Clang 14.0.7 annotation is present; no exact AndroidX artifact version/revision was established. |

A compiler annotation alone does not recover the complete NDK/toolchain, build options or source used. Even the dav1d revision-shaped suffix must be matched against its actual source and local changes before claiming corresponding source.

The bounded local provenance search covered the recovery workspace, likely project/source locations and dependency/tool caches. It found recovered bytecode/resources and native prebuilts, but **no complete, pinned source/patch/build bundle demonstrated to match these packaged libraries**. Unrelated locally installed native packages were not treated as source for this APK. This is a scoped search result, not proof that the original source cannot exist elsewhere.

## Candidate upstream origins and primary license references

The references below describe upstream projects and the license texts inspected there. They are not proof of the exact packaged origin, release, licensing election or terms of each recovered variant. Moving upstream branches may change; a future release must archive the license and source files from the matching revision.

| Packaged component | Upstream identification and primary references | Candidate upstream terms; packaged provenance limit |
| --- | --- | --- |
| `libcoder.so` / `HeifCoder` | Likely [awxkee/avif-coder](https://github.com/awxkee/avif-coder), based on the JNI package and native target names. [Current LICENSE](https://github.com/awxkee/avif-coder/blob/master/LICENSE); [inspected historical LICENSE](https://github.com/awxkee/avif-coder/blob/fb5dd8eceb1eb86d0bcb5c36f4f36548c80ef50d/LICENSE); [historical native CMake recipe](https://github.com/awxkee/avif-coder/blob/fb5dd8eceb1eb86d0bcb5c36f4f36548c80ef50d/avif-coder/src/main/cpp/CMakeLists.txt). | Both inspected wrapper LICENSE files say **MIT**, copyright (c) 2023 Radzivon Bartoshyk, not BSD. Neither inspected revision has been matched to this APK. The wrapper's license does not cover all linked or embedded third-party code. |
| `libheif.so` | [strukturag/libheif](https://github.com/strukturag/libheif); [COPYING](https://github.com/strukturag/libheif/blob/master/COPYING); [explicit source-header grant](https://github.com/strukturag/libheif/blob/master/libheif/context.h). | Library: **LGPL-3.0-or-later** in the inspected upstream header; COPYING includes LGPL v3 and GPL v3. Upstream sample applications and Go/C++ wrappers are separately MIT, not a basis for treating `libheif.so` as MIT. The exact packaged revision and its notices remain unestablished. |
| `libaom.so` | [AOM reference source](https://aomedia.googlesource.com/aom/); [LICENSE](https://aomedia.googlesource.com/aom/+/refs/heads/main/LICENSE); [PATENTS](https://aomedia.googlesource.com/aom/+/refs/heads/main/PATENTS). | Inspected copyright license: **BSD-2-Clause**, copyright (c) 2016 Alliance for Open Media. Separate **Alliance for Open Media Patent License 1.0** accompanies it. Exact revision and embedded third-party notices remain to be matched. |
| `libdav1d.so` | [VideoLAN/dav1d](https://code.videolan.org/videolan/dav1d); [COPYING](https://code.videolan.org/videolan/dav1d/-/blob/master/COPYING). | **BSD-2-Clause**. Inspected current notice credits VideoLAN and dav1d authors, 2018–2025; use the matching revision's copyright notice for a release, not a guessed date range. |
| `libde265.so` | [strukturag/libde265](https://github.com/strukturag/libde265); [library COPYING](https://github.com/strukturag/libde265/blob/master/libde265/COPYING); [explicit source-header grant](https://github.com/strukturag/libde265/blob/master/libde265/de265.h). | **LGPL-3.0-or-later** in the inspected upstream library header. Match the exact packaged revision and preserve its library notices; other project files or tools can have different terms. |
| `libx265.so` | [VideoLAN/x265](https://github.com/videolan/x265); [source/x265.h license declaration](https://github.com/videolan/x265/blob/master/source/x265.h); [COPYING](https://github.com/videolan/x265/blob/master/COPYING); [upstream licensing information](https://www.x265.org/legal.html). | The inspected source header explicitly permits **GPL version 2 or any later version (GPL-2.0-or-later)** and mentions an alternative commercial license. No commercial agreement or exact packaged-source match was established. |
| `libandroidx.graphics.path.so` | [AndroidX graphics-path](https://github.com/androidx/androidx/tree/androidx-main/graphics/graphics-path); [native module declaration](https://github.com/androidx/androidx/blob/androidx-main/graphics/graphics-path/build.gradle); [AndroidX LICENSE.txt](https://github.com/androidx/androidx/blob/androidx-main/LICENSE.txt). | Known AndroidX project origin, **Apache-2.0** upstream. The module uses the `androidx.graphics.path` namespace/native target. Exact artifact version, source revision, native subcomponent notices and packaged modifications remain unestablished. |

The historical avif-coder recipe is a provenance lead, **not the recovered build recipe**. It references additional static/imported components, including libyuv, sharpyuv, CPU feature support and avif-related code. Their presence, exact versions and notices in this particular binary must be established independently. Do not label the entire `libcoder.so` MIT, BSD or GPL merely from its wrapper project, and do not assume the seven shared-library names exhaust its dependencies.

### x265 and the application's GPL choice

GPL-2.0-or-later is not GPL-2.0-only. If the packaged x265 is covered by that upstream grant, the later-version option permits exercising GPL v3 for a compatible GPL v3 combined distribution. The application's **GPL-3.0-only** choice does not retroactively change x265's upstream grant to GPL-3.0-only and does not excuse its notices or corresponding-source requirements. This compatibility route is conditional on establishing the actual packaged terms and satisfying all relevant obligations; it is not a finding of legal compliance for the recovered APK. No alternative commercial license is assumed.

### LGPL libraries and relinking

For the matching libheif/libde265 variants, preserve the LGPL copyright/license notices and provide their covered source, modifications and relevant build materials under the applicable grant. LGPL v3 incorporates GPL v3, so accompanying license materials must include both texts where required. For a combined work distributed under LGPL v3 section 4, address the applicable notices and either a suitable shared-library mechanism or the necessary Minimal Corresponding Source and Corresponding Application Code that enable recombination/relinking with a modified library; provide Installation Information where required. Distribution terms must not prohibit the modifications or reverse engineering for debugging those modifications allowed by that section. See the [upstream LGPL text](https://github.com/strukturag/libde265/blob/master/libde265/COPYING) and [GNU LGPL v3](https://www.gnu.org/licenses/lgpl-3.0.html).

A `.so` filename, observed dynamic linkage or `android:extractNativeLibs` setting alone does not establish that recipients can replace/relink the library in a functional Android package. If relying instead on a permitted GPL route for the combined work, document that choice and satisfy the corresponding GPL requirements; do not silently drop the libraries' upstream notices.

### Permissive and patent notices

- **MIT wrapper:** retain the matching copyright and permission notice, including its disclaimer, in copies or substantial portions. Its permissive license does not eliminate copyleft obligations arising from other linked components.
- **BSD-2-Clause dav1d/AOM:** retain the matching copyright, conditions and disclaimer in source redistributions and reproduce them in documentation or other materials accompanying binaries.
- **AOM PATENTS:** retain the separate applicable patent license. The inspected text requires reproduction with implementations: in the source root for source distribution, and in documentation/legal notices or other written materials for non-source distribution. Review its Necessary Claims conditions and defensive-termination provisions; the BSD copyright license alone does not replace it or establish universal freedom from patent claims.
- **Apache-2.0:** provide the license, retain applicable copyright/patent/trademark/attribution notices, mark modified files where required and carry forward relevant NOTICE contents if supplied by the matched upstream distribution. Apache-2.0 does not grant trademark rights. URLs in this document are provenance references, not a replacement for required accompanying license texts in a future binary/source bundle.

## Extracted AndroidX resources in this repository

`resources/` contains merged dependency resources as well as application-owned material. These dependency resources are **not blanket-relicensed under the root GPL license**. The manifest identifies AndroidX Core, Startup, Emoji2, Lifecycle and ProfileInstaller integrations; that identifies dependency families, not exact versions or ownership of every merged resource.

Known AndroidX Core resource examples include `resources/res/layout/notification_action.xml`, `notification_action_tombstone.xml`, notification template layouts and notification drawables/strings. The [upstream Core layout directory](https://github.com/androidx/androidx/tree/androidx-main/core/core/src/main/res/layout) contains the matching resource names; [upstream notification_action.xml](https://github.com/androidx/androidx/blob/androidx-main/core/core/src/main/res/layout/notification_action.xml) explicitly carries **Copyright (C) 2016 The Android Open Source Project** and Apache-2.0 terms. The upstream graphics-path module carries **Copyright (C) 2022 The Android Open Source Project**. These established notices are acknowledged here; they are not attribution for unrelated application assets.

A canonical [Apache License 2.0 text](licenses/Apache-2.0.txt) accompanies the preserved AndroidX resources, with the [upstream AndroidX text](https://github.com/androidx/androidx/blob/androidx-main/LICENSE.txt) as the primary reference. apktool-decoded XML is not the original preferred-source resource file and can lose comments. A future source release must map the retained files to their exact originating artifacts/revisions, restore applicable original notices and identify any modifications. Retrieve and preserve any applicable NOTICE contents from those artifacts; no claim is made that all relevant notices were recovered from the APK.

Do not infer that every extracted image, asset, localized string or generated resource belongs to AndroidX or the application author. Keep uncertain provenance explicit until individually resolved. Native upstream links above likewise do not license arbitrary third-party material in this tree.

## Privacy is a separate question

No private application data was observed in the inspected recovery material. This is a bounded inspection statement, not a guarantee covering uninspected files. Packaged code/resources are distinct from runtime preferences, private databases and user media. Conversely, absence of observed private data does **not** establish copyright ownership, exact dependency provenance, licensing compatibility or complete corresponding source. A privacy review cannot clear the binary's legal/source gate.

## Required release checklist

The following work remains necessary before publicly distributing the historical 2.2.0 APK. It is not a current-runtime inventory or a claim that these steps have passed.

1. **Tie the record to the exact artifact.** Record the APK hash and a complete inventory of its DEX/resources/native files. Record each packaged native file's hash, ABI, revision evidence and actual dynamic and statically embedded dependencies. Identify every bundled component even if the app does not call its exposed feature.
2. **Establish provenance, not just names.** For each of the seven shared libraries and any embedded components, identify the exact supplier/upstream revision, applicable copyright/license files, build configuration and local patches. Resolve wrapper artifact coordinates/version and the source behind the JNI package. Binary version strings and a candidate upstream tag are leads, not proof of a match.
3. **Obtain the appropriate application source.** Recover the original preferred-for-modification Kotlin/application sources and project configuration, or otherwise establish the complete source legally appropriate to this exact artifact. Decompiled Java and smali alone have not been demonstrated to satisfy that requirement. A new authored reconstruction is a separate artifact, not retroactive proof of the old binary's source.
4. **Assemble matching native corresponding source.** Include required C/C++ source, generated inputs where necessary, submodules, patches, dependency revisions, configure/CMake/Meson scripts, build/install scripts and required interface definitions. Pin and document the relevant NDK/compiler/toolchain and feature flags. Determine whether statically linked libyuv/sharpyuv/avif or other code adds further source/notice requirements. Do not import arbitrary current upstream source or copied prebuilts and describe them as matching this APK.
5. **Resolve the actual licensing route.** Confirm x265's GPL-2.0-or-later grant or any documented alternative; maintain the application's GPL-3.0-only scope without changing third-party grants. Satisfy the applicable GPL corresponding-source delivery requirements and the LGPL source/relinking/installation requirements. Document any covered combined-work licensing election and required Installation Information, without publishing private signing keys.
6. **Package complete accompanying notices.** Include the matched copyright notices and full required license texts, including applicable GPL/LGPL texts, MIT/BSD notices, AOM PATENTS, Apache-2.0 and upstream NOTICE contents. Restore resource attributions and mark relevant modifications. Links and the root application license are not a substitute for this package.
7. **Establish source-to-binary correspondence and delivery.** Have the release owner review the matching source/build evidence and document a lawful, accessible source-delivery method for that exact binary under the applicable license sections. Record the commands, revisions and resulting artifact identities. A build that simply copies the old `.so` files does not establish native corresponding source. A successful new build alone does not prove byte-for-byte reproduction of the old APK.
8. **Apply the gate to publication.** Publish the APK only after all applicable source/license obligations for the exact artifact are established. If they remain unresolved, keep it local and publish only safe recovered references/documentation with accurate third-party scopes. Do not attach the APK to a public release or promise a binary download.

No build, test, formatter or release-gate execution was performed for this notices update. [Current build instructions](BUILD-FROM-SOURCE.md) cover the separate authored reconstruction; the [local-only 2.2.0 release notes](../releases/v2.2.0/RELEASE-NOTES.md#mandatory-public-binary-release-gate) remain the historical binary-publication warning.
