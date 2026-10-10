# Contributing to Tidy recovery

This is an APK recovery repository. The Java tree is a readable reference, not a working Android source project. Preserve that distinction in patches and documentation.

## Useful contributions

- Recover the original Kotlin/Gradle checkout or verifiable dependency/version records.
- Identify decompiler failures by comparing the Java with the same method in `bytecode/id/eska/screenshotwebp/`; explain the control flow rather than editing generated output until it looks compilable.
- Recover the exact native source revisions, local patches, compiler configuration, build/link scripts, and license notices for the preserved APK.
- Implement the [buildable-source roadmap](docs/BUILD-FROM-SOURCE.md) with explicit evidence for behavior parity.
- Correct documentation with references to recovered classes or verified runtime observations.

## Before proposing a change

1. Read [recovery notes](docs/RECOVERY-NOTES.md), [architecture](docs/ARCHITECTURE.md), and [third-party provenance](docs/THIRD-PARTY-NOTICES.md).
2. State which APK/hash, method, and device/Android version your evidence concerns. Distinguish observed facts from assumptions.
3. Preserve the reference artifacts. Keep future handwritten application source separate from decompiler output; do not silently rewrite history or hide JADX warnings.
4. For behavioral work, show a failing-before/passing-after scenario. Use disposable media and verify orientation, supported EXIF fields, output validity, fallback, selected format, and replacement behavior as applicable.
5. Never add a signing keystore, password, token, personal media, local absolute path, or private device log. APK/native binaries stay excluded until redistribution requirements are met.

## Review expectations

Keep changes focused. Explain any intentional behavior change, migration, Android compatibility limit, or native dependency change. Do not claim reproducible builds, full source recovery, or broad metadata preservation without proving it.

There is no source-build or automated application-test command for this reference tree. Check documentation links and the prepared artifact checksum when changing recovery/release records. Once a runnable project exists, document its exact build and runtime verification commands before treating compilation alone as success.

## Licensing

Contributions to application-owned code/documentation are under GPL-3.0-only, consistent with [LICENSE](LICENSE). Preserve third-party notices and identify the origin/license of imported material. Confirm that you have the right to contribute it. An upstream URL without an exact revision and matching build materials is not evidence of complete corresponding source for the bundled binary.

## Reporting an issue

Include the affected category, selected output format, Android version, device ABI, installation/signature history, and minimal reproduction using non-private images. Include a sanitized error message or relevant method reference. Never attach personal screenshots or unredacted filesystem/device identifiers by default.
