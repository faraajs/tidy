# Architecture: authored 2.3 and historical 2.2 evidence

The maintained application is the **newly authored 2.3.0 reconstruction**, not recovered Kotlin source or a byte-identical replacement for 2.2. Its application ID is `id.eska.tidy`, namespace `id.eska.screenshotwebp`, minimum Android API 30 and target/compile API 36. Java 17 platform Views and source-built native code are compiled from [`app/`](../app/); `sources/`, `bytecode/` and `resources/` are historical references, not build inputs. Release builds target `arm64-v8a` and `x86_64`.

This document describes implemented source paths. It does not certify physical-arm64 or all-OEM compatibility, UI accessibility or crash-proof recovery. Build and device evidence belongs in the [source-build record](BUILD-FROM-SOURCE.md) and release notes. The original 2.2 APK remains withheld; authoring 2.3 does not resolve its missing corresponding source or native provenance.

Both configured ABIs built successfully. Final verification passed 12 host tests; the signed release passed 19 Android conversion/state scenarios on API 30 full AOSP x86_64, plus real unavailable-codec fallback and close-write checks. Actual surface/monitoring smoke covered theme persistence, serial burst/moved-to delivery, scoped/category exclusion, pause-backlog exclusion, restart deduplication and actual opt-in boot restoration; paused monitoring did not start after another reboot. Signature and APK/ELF 16 KiB alignment passed. Earlier Android 36 ATD checks are separate evidence. No physical-arm64 or all-OEM result is claimed.

## Authored 2.3 component flow

All Java components below are in [`app/src/main/java/id/eska/screenshotwebp/`](../app/src/main/java/id/eska/screenshotwebp/).

| Component | Implemented responsibility |
| --- | --- |
| `MainActivity extends Activity` | Programmatic native-View dashboard; permission controls, category/format/deletion consent, Start/Pause, theme and real snapshot rendering. |
| `AppStateStore` | Synchronized device-protected preferences, safe migration, category `Config`, counters/result/error `Snapshot`, bounded durable processed history and process-local queue counts. |
| `PathPolicy` | Exact canonical folder scope, input/epoch eligibility and SHA-256 discovery fingerprints. |
| `BootReceiver` | Requests service restoration for boot, locked boot, user unlock or package replacement; never grants consent or permissions. |
| `MonitorService` | Validates saved consent/storage, owns foreground notification and `MediaMonitor`; callbacks record progress, successes and failures. |
| `MediaMonitor implements AutoCloseable` | Directory `FileObserver`s plus reconciliation; stability checks, canonical-path reservations, durable-history lookup and bounded worker concurrency. |
| `MediaConverter` | Both category policies, sampling/orientation, verified codec candidates, exclusive output publication and guarded opt-in source deletion. |
| `NativeAvif` / `tidyavif.cpp` | JNI AVIF encode/decode and no-replacement source-backup rename. |

`MediaMonitor.Callback` exposes `onProgress(int pending, int processing)`, `onResult(MediaConverter.Result)` and `onError(MediaCategory, String)`. `MediaConverter.Result` carries output file, category, actual format, source/output bytes, width/height, fallback, target-met and original-deleted flags. There is no authored `ScreenshotMediaConverter`, Compose dashboard, Room database or WorkManager job store.

## Authored 2.3 state and accounting

`AppStateStore` uses device-protected SharedPreferences `state` and `tidy_ui`; `dark_mode` defaults to true. The one-time schema marker is `v23_safe_state`. When unlocked, the theme can be imported from the older credential-protected `tidy_ui`. State writes use checked synchronous commits.

Fresh installation: both categories disabled, monitoring unrequested, deletion off independently for each category, AVIF selected, zero counters and an empty-result message. Migration preserves supported format choices, nonnegative category counts and fallback count, but **does not carry over category activation, deletion or monitoring consent**. Historical saved-byte totals are not imported into reclaimed-storage accounting. Consequently a migrated conversion count can include historical successes while reclaimed bytes start at zero.

`Config` contains `category`, `enabled`, `activatedAtMillis`, `format` and `deleteOriginals`. Enabling establishes the current epoch; disabling clears it. A false-to-true monitoring request renews epochs for enabled categories, so Start/resume ignores the pause backlog. Format/deletion edits do not themselves renew the epoch.

`Snapshot` exposes `screenshotCount`, `photoCount`, `savedBytes`, `fallbackCount`, `lastResult`, `lastError`, `monitoringRequested`, `pending` and `processing`. A success adds one category conversion and, if applicable, one fallback. **Reclaimed bytes are `sourceBytes - outputBytes` only when the original was actually deleted and the output was smaller; otherwise zero.** Retaining originals adds another file, not free space. This is accumulated conversion accounting, not a fresh disk-space measurement. Results report actual format/dimensions/bytes, source retention/deletion and target misses; diagnostics avoid personal paths.

Processed fingerprints hash canonical path, millisecond mtime from `Os.stat`/`st_mtim`, length and **requested** format; they are not content hashes. `markProcessed` commits successful fingerprints under `v23_processed_`, ordered by sequence and bounded to 10,000 entries. Restart restores this ledger, unlike the historical in-flight-only deduplication. Eviction, a changed fingerprint or a crash before history commit can allow reconsideration. History, result counters and filesystem changes are not one atomic transaction. Pending/processing counts and queues are intentionally process-local, so a restart does not display persisted phantom jobs.

## Authored 2.3 discovery and lifecycle

Only regular readable JPEG/JPG/PNG inputs (case-insensitive) below these shared-storage roots are eligible:

| Category | Exact roots, including eligible descendants |
| --- | --- |
| `SCREENSHOTS` | `Pictures/Screenshots`, `DCIM/Screenshots` |
| `PHOTOS` | `DCIM/Camera` |

Both lexical and canonical paths must remain descendants with separator-safe boundaries. A redirected root, symlink escape, hidden component, or `Android`/`cache` component is rejected. The root itself is not an input. There is **no traversal of arbitrary shared storage**, downloads or messaging folders. Generated `.avif`/`.webp` files cannot feed back into either pipeline. Both categories require enabled consent and `mtime >= activatedAtMillis`: this is an mtime rule for new/newly modified media, not proof of capture time.

`start()` schedules immediate reconciliation followed by a 20-second fixed delay. Scans attach observers to eligible directory trees; creation, close-write and moved-to events offer files, while directory/self changes request reconciliation. Offered files wait 350 ms and must retain length/mtime before dispatch. `CLOSE_WRITE` or `MOVED_TO` replaces a pending CREATE snapshot and clears that file's empty/unstable-file cooldown; it never replaces an executing conversion. Busy/failed files otherwise have a 20-second cooldown, not a tight retry loop.

Android 11's `File.lastModified()` **and NIO modification-time readers** were observed to truncate subsecond timestamps. `PathPolicy.modifiedMillis` uses `android.system.Os.stat` and `st_mtim.tv_sec * 1000 + st_mtim.tv_nsec / 1_000_000` instead, preserving milliseconds for the activation gate, pending stable metadata and durable fingerprints. Source identity checks also retain `st_mtim` precision. This cannot restore precision that the underlying filesystem does not store; eligibility remains an mtime policy, not capture-time proof.

The real-observer regression held an empty CREATE open beyond the stability interval before writing and closing a synthetic PNG. Before the cooldown fix it failed the 12-second wait; with the fix a real WebP output arrived 659 ms after close-write, without waiting for periodic reconciliation, and the source was retained. This measured scenario is not a general latency or OEM guarantee.

Canonical reservations prevent simultaneous conversion of one path; durable history prevents repeat processing of unchanged successful inputs within its retained window. Worker limits are **one screenshot and at most two photos**, including overlap during service restart in the same process. Dispatch and worker entry read fresh settings rather than trusting an enqueue-time configuration. Conversion rechecks consent/settings before publication and before source deletion.

The service requires a saved monitoring request, an enabled category, unlocked user, writable mounted storage and All files access, including on null/redelivered intents. It uses the manifest's **`specialUse`** foreground-service type and ongoing notification, not the historical `dataSync` type. `START_STICKY` is returned only on the valid running path. Boot/package/unlock handling may restore an existing request; it does not enable categories or start while locked storage is unavailable. Android/OEM restrictions can still prevent startup or stop the process.

Pause first persists `monitoringRequested=false`, then stops the service. `close()` clears pending stability work/observers and shuts executors down without interrupting encoding or restoration. In-flight work may finish a safe output or retain the source; pause is not synchronous cancellation of an already executing filesystem operation. Disabling a category and format/deletion edits are also checked against live state. Process termination is different from graceful shutdown and has the limits below.

The [authored manifest](../app/src/main/AndroidManifest.xml) declares All files access, notifications, boot, optional battery-exemption requests and foreground-service permissions. It has no Internet permission and disables Android app backup. No network upload, analytics or telemetry path is implemented.

## Authored 2.3 codec and image policy

WebP uses Android `Bitmap.compress(WEBP_LOSSY, ...)`. AVIF uses real `NativeAvif.encode(Bitmap, int)` and `decode(byte[])`, loading `libtidyavif.so` built from pinned **libavif 1.4.2 + libaom 3.14.1**. [`CMakeLists.txt`](../app/src/main/cpp/CMakeLists.txt) verifies immutable source archives before extraction; libavif/AOM are statically linked into the JNI library. No recovered codec binaries, libheif/HEVC/x265, external dav1d decoder, external libyuv or libsharpyuv are linked. Libavif's embedded scalar libyuv sources and dav1d-origin `obu.c` retain their upstream notices. Pins/source digests and licenses are recorded in [`native/dependencies.json`](../native/dependencies.json), [`native/java-dependencies.json`](../native/java-dependencies.json) and [third-party notices](THIRD-PARTY-NOTICES.md).

Decode reads bounds first, then uses software ARGB_8888/sRGB. Screenshots keep their full oriented dimensions and encode quality **55**, with an informational **100 KiB** target. Photos select a power-of-two sample whose nominal long edge is at most **2,560**, then search scales **1, 0.75, 0.5, 0.25** and qualities **85, 55, 25** in that order. Search stops with a valid fitting candidate; if none fits, the smallest verified candidate is retained. This is not the historical quality-20/binary-search algorithm.

| Original photo bytes | Target |
| --- | ---: |
| At most 500 KiB | 100 KiB |
| More than 500 KiB through 1 MiB | 250 KiB |
| More than 1 MiB through 3 MiB | 500 KiB |
| More than 3 MiB | 750 KiB |

Fallback occurs when the selected codec yields no valid encoded candidate, not simply when its target is missed. Screenshots allow AVIF → WebP; selected WebP screenshots have no fallback. Photos allow either direction. Output-write/publication failure is an error, not a second-codec publication retry. Size targets and storage savings are not guaranteed; a valid larger output can be kept **without deleting its source**.

EXIF orientations **1–8** are normalized in pixels, including transpose/transverse and mirrored rotations; unreadable EXIF can fail conversion, and transform failure is not silently replaced by untransformed pixels. Input metadata is not copied: output loses source GPS, EXIF/XMP, capture/camera identity and original ICC/HDR information. Orientation normalization is not lossless compression or metadata preservation. Native AVIF encodes 8-bit YUV444 with lossless alpha, explicit color signaling and one codec thread; decode is bounded to an 8-bit still image without unapplied container transforms.

Java/native bounds limit bitmap dimensions to **16,384 per axis**, total pixels to **16,777,216**, and encoded candidates to **64 MiB**; source capture also rejects empty/nonregular inputs and files over **256 MiB**. Bitmaps, native images, byte buffers and bitmap locks are released on success/failure paths. These bounds reduce exposure, not a guarantee that every bounded image fits available memory; memory failure becomes a conversion error with source retention.

The JNI library also contains the NDK static C++ runtime. [`native/compiler-runtime-sources.json`](../native/compiler-runtime-sources.json) records conservative preferred-source inputs for libc++, ABI, unwinder and compiler-rt portions selected by the link: immutable LLVM runtime/support sources, exact Android recipes and 71 selected original patches. Its reconstruction procedure applies 21 projected runtime/support patches in metadata order; it does not rebuild or certify byte-identical compiler/runtime binaries. Full NDK LLVM, native and Java notices are bundled in the app. See the [System Libraries/compiler boundary](THIRD-PARTY-NOTICES.md#gpl-notices-and-installation-of-modifications).

## Authored 2.3 publication and source safety

1. Capture source device/inode, length, mtime and SHA-256; check identity again after hashing. Decode/encode/verify candidate bytes, then recheck scoped source identity/content and live consent/settings.
2. Reserve a same-directory `stem.tidy.avif`/`.webp`, then `stem.tidy (n).avif`/`.webp` on collision (up to 10,000 names). `O_CREAT | O_EXCL | O_NOFOLLOW` is an exclusive CREATE_NEW reservation, not an existence-check followed by replacement. Write through the owned descriptor and force its channel; compare identity, exact bytes/hash and decoded dimensions afterward.
3. With deletion off, never rename/delete the source. With deletion on, require a **verified strictly smaller output**, unchanged captured source and matching live settings. A missed informational target does not alone prohibit deletion; being smaller than the source does.
4. Move the source to hidden same-directory `.<name>.tidy-source-backup-<UUID>` via `NativeAvif.renameNoReplace`, which uses the kernel no-replacement rename and declines unsupported filesystems rather than using an unsafe overwrite fallback. Revalidate the actually moved file and output, and consent, before deleting that backup. Never delete a newly recreated source pathname.
5. If deletion/validation fails after moving, restore without replacement. If another writer has occupied the original name or restore fails, retain the named backup rather than overwrite that file. Deletion refusal can return a successful output with `originalDeleted=false` and zero reclaimed bytes. Conversion/publication errors attempt removal only of an output with the reserved device/inode identity.

Verification checks encoded decodability, dimensions and published-byte identity; it is not perceptual-quality approval or equality to the lossy source pixels. Normal failure paths preserve the captured original or its backup, but **there is no transaction with external writers, crash journal, automatic backup recovery, trash or undo**. Output can be visible while being written. Process death can leave an incomplete/new output or hidden source backup, and a crash between filesystem completion and history/counter commits can leave accounting incomplete. Forcing the output file is not a directory-fsync or full power-loss guarantee. Cleanup/restore can fail, and checks cannot lock out every external mutation between operations. Keep independent backups before opting into deletion.

## Historical 2.2 recovery evidence

**Everything below describes the inspected 2.2.0 bytecode/APK, not the authored 2.3 runtime.** Existing section anchors are retained for historical references. The original Kotlin project was not recovered; readable [Java references](../sources/README.md) are decompiler output. The historical APK was version code 2, minSdk 30, targetSdk 33 and arm64-v8a only. See [recovery notes](RECOVERY-NOTES.md), [historical manifest](../resources/AndroidManifest.xml) and [UI evidence](UI-DESIGN.md).

## Responsibilities and entry points

| Historical component | Observed responsibility |
| --- | --- |
| [MainActivity](../bytecode/id/eska/screenshotwebp/MainActivity.smali) | Compose/Material3 setup/dashboard, permissions, category/format changes, monitoring restart and patched theme preference. |
| [AppStateStore](../bytecode/id/eska/screenshotwebp/AppStateStore.smali) / [AppState](../bytecode/id/eska/screenshotwebp/AppState.smali) | Synchronized preferences, legacy migration and category counters/results/errors. |
| [CategoryConfig](../bytecode/id/eska/screenshotwebp/CategoryConfig.smali) | Category, nullable activation epoch and requested format; active derives from non-null activation. |
| [BootReceiver](../bytecode/id/eska/screenshotwebp/BootReceiver.smali) | Boot/package/unlock startup when category active and All files access available. |
| [MonitorService](../bytecode/id/eska/screenshotwebp/MonitorService.smali) | Foreground notification/monitor lifecycle, outcome recording and media rescans. |
| [MediaMonitor](../bytecode/id/eska/screenshotwebp/MediaMonitor.smali) / [PathPolicy](../bytecode/id/eska/screenshotwebp/PathPolicy.smali) | Observers/reconciliation/queues/stability and canonical classification/exclusions. |
| [ScreenshotMediaConverter](../bytecode/id/eska/screenshotwebp/ScreenshotMediaConverter.smali) / [MediaConverter](../bytecode/id/eska/screenshotwebp/MediaConverter.smali) | Active full-size screenshot and sampled-photo pipelines; different publication/rollback policies. |
| [MediaModelKt](../bytecode/id/eska/screenshotwebp/MediaModelKt.smali) | Photo opposite-format fallback; its always-AVIF `screenshotFormat` has no observed app caller and does not override active screenshot requests. |
| [TargetBucket](../bytecode/id/eska/screenshotwebp/TargetBucket.smali) | `maxBytes` result of `TargetPolicyKt.targetBucket`, not a queue/category/deletion rule. |
| [CompressionPlanKt](../bytecode/id/eska/screenshotwebp/CompressionPlanKt.smali), [TargetPolicyKt](../bytecode/id/eska/screenshotwebp/TargetPolicyKt.smali), [ConversionResult](../bytecode/id/eska/screenshotwebp/ConversionResult.smali) | Parameters, targets and status/size/dimension/path/format/fallback results. |
| [ScreenshotMonitor](../bytecode/id/eska/screenshotwebp/ScreenshotMonitor.smali) / [ScreenshotConverter](../bytecode/id/eska/screenshotwebp/ScreenshotConverter.smali) | Older screenshot-only `DCIM/Screenshots` pipeline, not the pair constructed by the historical foreground service. |

Historical `MonitorService.onStartCommand` constructs `MediaMonitor`, `MediaConverter` and `ScreenshotMediaConverter`, not the retained older screenshot pipeline. Its non-exported service uses `dataSync`; direct-boot awareness is not proof of available storage/startup. Notification, All files, foreground-service, boot and battery permissions are declared, but not Internet access.

## Media discovery and queue flow

The historical SCREENSHOTS category is broader than a screenshot folder: eligible canonical JPG/JPEG/PNG descendants throughout shared storage, outside `DCIM/Camera`, enter it. Downloads/messaging images can qualify. Camera descendants are PHOTOS. Hidden/technical parents (Android, thumbnails, cache/caches) are excluded; existing AVIF/WebP outputs are not inputs. Photo scans traverse the camera tree; screenshot scans traverse other shared storage.

Both categories require activation, but only photos require whole-second mtime **strictly newer** than activation. Historical screenshots bypass age filtering and can process pre-existing files. Startup reconciles immediately, then after five seconds and every twenty seconds. `CLOSE_WRITE`/`MOVED_TO` (`0x88`) offer completed files; directory creation/move-in requests reconciliation.

Canonical-path and category/path/mtime-seconds/length/requested-format signatures reserve in-flight work. They are removed on completion or error: **no durable processed-file ledger** is established, so retained inputs can be reconsidered. One screenshot executor and two photo workers perform a 350 ms length/mtime check and one dispatch. The retained `MAX_RETRIES` constant does not establish a retry loop. Queued jobs capture enqueue-time configuration; preference edits are not evidence of cancellation. Queues are memory-only, not WorkManager/database jobs.

## Conversion and fallback

### Screenshot-category path

Historical `ScreenshotMediaConverter.convert` decodes without photo sampling, applies EXIF orientation and encodes full oriented dimensions at quality **55**. AVIF is tried before WebP when encoding, verification or publication fails; selected WebP has one attempt. No scale/quality target search is performed. The **100 KiB** target is reported, not enforced: a published screenshot can replace its source despite being above target or larger than the source.

### Photo path

Historical `MediaConverter.decodeSource` uses ARGB_8888, power-of-two sampling with nominal maximum dimension **2,560**, then orientation correction. Scales are **1, 0.75, 0.5, 0.25**. `findCandidate` verifies quality 20 at each scale; if fitting, it tries 85 then binary-searches 21–84. If nothing fits, the first valid quality-20 candidate may still succeed above target. The recovered `initialQualityCandidates` helper's 85/55/25 is **not** this historical search.

Photo fallback switches either direction only when no valid candidate exists, not on target miss. Historical photo buckets are the same byte thresholds tabulated for 2.3 above (`TargetPolicyKt.targetBucket`), not measured saving percentages. Historical publication flows through hidden temp output, decoded temp verification, destination publication, final dimension verification and attempted source deletion. Failure cleanup/restore differs by category; this bounded format attempt sequence is not unlimited retries.

## Orientation, publication and deletion limits

Historical converters read AndroidX EXIF orientation and transform pixels for 2–8. Unreadable orientation defaults to normal; failed transform can fall back to the untransformed bitmap rather than block deletion. General EXIF is not copied: GPS, capture/camera tags, thumbnails and color/HDR preservation cannot be promised.

- Photos choose the original stem with output extension and collision suffix ` (n)`, write hidden UUID `.tmp`, verify, publish with `File.renameTo`, verify final and delete source. Deletion failure attempts new-output removal and returns failure.
- Screenshots use the original stem/output extension, moving an existing destination to hidden UUID `.bak` before replacement; verify temp/final, delete source, remove old-output backup on success, and attempt cleanup/restoration on failure. Existing output replacement differs from photos and from authored 2.3.
- Screenshot `moveWithoutReplacement` requests `ATOMIC_MOVE` with existence-check/`renameTo` fallback. Neither that name nor photo check-then-rename proves portable race-free no-overwrite semantics.
- Native AVIF or BitmapFactory WebP verification checks decoded dimensions, not source pixels, metadata, checksum identity, perceptual quality or smaller size.
- A 350 ms stability check is not a source lock. Publication/deletion are separate operations with no established crash journal, fsync guarantee, undo or reliable process-death rollback; some cleanup/restore returns are ignored.

Historical verify-before-delete therefore does not guarantee lossless or recoverable replacement.

## State and presentation

Historical device-protected SharedPreferences `state`, not Room, hold category activation/baseline, formats, counts/saved bytes and result/error (`screenshot_*`, `photo_*`). AVIF defaults and legacy migration/deprecated keys are recovery evidence, not current API recommendations.

Success increments count and adds `max(sourceBytes - outputBytes, 0)` regardless of actual storage reclamation, records format/sizes/target miss, clears category error and increments shared fallback count. This cannot reveal output growth or replaced screenshot output space; it is not disk-space measurement. Failures record filename/message. Historical `AppState` has no live queue-depth/progress field. See [historical UI sections](UI-DESIGN.md#observed-ui-structure).

## Native boundary and unresolved provenance

Historical AVIF uses `com.radzivon.bartoshyk.avif.coder.HeifCoder`, lazily created, loading `coder` and JNI `encodeAvifImpl`/`decodeImpl`. The app requests lossy AVIF, speed SEVEN and automatic surface/chroma options. WebP uses Android Bitmap compression.

The historical arm64 APK contains `libcoder.so`, `libheif.so`, `libaom.so`, `libdav1d.so`, `libde265.so`, `libx265.so` and `libandroidx.graphics.path.so`. Wrapper HEIC methods/bundled HEVC libraries do not establish user-facing HEIC support: the output model has AVIF/WebP only.

Inspected ELF `DT_NEEDED` edges: `libcoder.so` directly depends on libheif, libaom, libdav1d, libde265 and libx265, plus libc/libm/libdl and liblog/libjnigraphics/libandroid. `libheif.so` directly lists libde265/libx265 and libc/libm/libdl, **not** libaom/libdav1d. AOM/de265/x265 and the separately bundled AndroidX path library list libc/libm/libdl; dav1d lists libc only. These are linkage observations, not proof of per-image execution or absence of static components. The path library is not an observed codec-chain dependency; Android system libraries are dependencies, not recovered app source.

Library names/JNI declarations do not recover C/C++ source, exact revisions/build flags or license obligations. The historical corresponding-source/provenance gap remains unresolved even though 2.3 uses a separate source-built codec; see [third-party notices](THIRD-PARTY-NOTICES.md).
