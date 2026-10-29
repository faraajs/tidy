# Tidy 2.3.1 release notes

## Gallery disappearance fixed

In 2.3.0, opting into original deletion could remove the PNG/JPEG before its replacement was ready in Android Gallery. The replacement could remain on disk but have a missing or pending MediaStore image entry. Generated-image checks on a physical Android 13 phone reproduced deletion with a still-pending replacement entry.

2.3.1 explicitly scans each verified output with its actual MIME type. Original deletion additionally requires a complete image entry, exact readable output bytes and successful platform decoding at the intended dimensions. Unknown MediaStore width/height is allowed only when actual decoded dimensions are correct. If indexing or platform decoding is unavailable, both the valid output and unchanged original remain; reclaimed storage is zero. The worker's scanner wait is bounded to ten seconds.

Updating from official 2.3.0 uses the same signing certificate and does not require uninstalling. The update **pauses monitoring and resets both original-deletion consents once**, preserving category settings, formats, counters, actual reclaimed-byte totals, theme and processed history. Start explicitly when ready, preferably with **Delete originals off**. This cannot reconstruct PNG/JPEG files already deleted; an existing `.tidy.webp` or `.tidy.avif` replacement may still be recoverable through indexing.

## Processing changes

- Removed redundant full-output decoding and hashing, while retaining exact-byte, source-identity, collision and live-consent checks.
- Enabled baseline ARM64 NEON in AOM built from source for AVIF. Optional CRC32, dot-product, I8MM, SVE and SVE2 extensions remain disabled; x86_64 stays generic.
- WebP still uses Android's platform codec. Screenshot quality 55, oriented full-size dimensions, codec thread limits and queue policy are unchanged. No instant-conversion or uniform speedup is promised.

## Identity and downloads

| Field | Value |
| --- | --- |
| Application ID / namespace | `id.eska.tidy` / `id.eska.screenshotwebp` |
| Version name / code | `2.3.1` / `4` |
| Minimum / target SDK | API 30 / API 36 |
| APK ABIs | `arm64-v8a`, `x86_64` |
| Certificate SHA-256 | `27c165f0a6f13f8b01ed6628bd1a2e8f61daeb3b33438c6808f41f331aa45389` |
| APK SHA-256 | `e8e6bdac4167414a94cee409f77daee6a3a30e56592847c329053dffbbeb7e02` |

Download [`tidy-v2.3.1-arm64-x86_64.apk`](https://github.com/faraajs/tidy/releases/download/v2.3.1/tidy-v2.3.1-arm64-x86_64.apk), `tidy-v2.3.1-corresponding-source.tar.gz` and `SHA256SUMS.txt` together from the [official release](https://github.com/faraajs/tidy/releases/tag/v2.3.1). In their directory:

The APK was originally published as `tidy-v2.3.1-universal.apk`; its current filename explicitly identifies the two supported ABIs. Relabeling the asset does not change its bytes or the recorded APK hash. Historical source bundles and release evidence may retain the original name.

```sh
sha256sum -c SHA256SUMS.txt
apksigner verify --verbose --print-certs tidy-v2.3.1-arm64-x86_64.apk
```

Verify the certificate above. Different-certificate installations still require an independent backup and manual uninstall before switching; uninstalling removes local settings. Official private signing keys are not included. See [build/install instructions](../../docs/BUILD-FROM-SOURCE.md) and [full third-party notices](../../docs/THIRD-PARTY-NOTICES.md).

## Exercised evidence and limits

- Both ABIs were built from source; 13/13 host state/path tests passed, including the one-time Gallery-consent migration and preservation of settings/history/accounting.
- Final signed APK passed 20/20 real conversion/state scenarios on an isolated API 30 full-AOSP x86_64 emulator: native pixels/alpha, all eight EXIF transforms, metadata removal, size boundaries, collision/source/output guards, consent, Gallery-unavailable retention and actual-result accounting. Shared-storage rename refusal was treated as safe retention; physical Gallery checks separately exercised successful deletion.
- Real empty-CREATE/CLOSE_WRITE observation passed, producing verified WebP **1,048 ms after the completed write**. This exercises the actual FileObserver and worker, not a callback echo.
- Final signed APK passed 3/3 isolated Gallery scenarios on a physical Android 13 arm64 phone: real WebP/AVIF publication with readable replacements before opted-in deletion, and exact-original retention without a usable Gallery index. All images/preferences were generated and isolated; no personal image bytes were used.
- On that phone, generated opaque 1080 × 2400 screenshots took **896 ms for WebP** and **1,493 ms for AVIF**, including conversion/publication. Observer stabilization and dashboard refresh are separate. These observations are not comparable-device benchmarks or latency guarantees.
- Actual API 30 full-AOSP dashboard smoke converted a new generated screenshot to WebP, retained its unchanged original with zero reclaimed bytes, and displayed the indexed output in the real Gallery app. Its System UI initially stalled and was recovered.
- Actual phone upgrade preserved counters, format and theme, left monitoring paused and reset original deletion. The final APK signature and ZIP/ELF 16 KiB alignment passed; bundled dependency notices match the source asset exactly.

The tested Android 11 shared-storage filesystem refused kernel no-replacement backup rename. Tidy retained originals rather than using an overwrite-capable fallback; opting into deletion is permission, not a promise that every filesystem can safely perform it. Native AVIF alpha is covered by codec checks, but platform Gallery rendering varies: the tested Android 13 decoder rendered a transparent AVIF pixel opaque. Prefer WebP and keep originals for transparent PNGs.

Conversion remains lossy; photos may be resized, metadata is removed, targets are not guarantees, and Gallery availability is not a backup or a transaction against external writers/process death. No all-OEM, background-survival, exhaustive accessibility or byte-identical app/compiler/runtime rebuild claim is made. Earlier source-bundle rebuild, unavailable-codec, boot and theme checks remain specific to [2.3.0](../v2.3.0/RELEASE-NOTES.md).

Application-owned code is GPL-3.0-only; upstream licenses/notices remain applicable. The matching source archive supplies application/build/install materials and pinned native, Java and conservative runtime preferred-source inputs, not just decompiler references. The historical 2.2.0 APK remains withheld. There is no warranty or legal immunity; applicable license terms and nonwaivable law still apply.
