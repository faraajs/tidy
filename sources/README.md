# Recovered application reference

This directory contains **generated, read-only Java reference**, not the original Kotlin source and not a buildable Android project. It was recovered from the preserved Tidy 2.2.0 r3 APK with JADX 1.5.6. Do not compile it, edit it as if it were maintained application source, or treat it as complete corresponding source for the APK.

- `id/eska/screenshotwebp/`: all 26 Java files generated for the application implementation namespace. Other dependency namespaces are deliberately excluded. Imports referring to Android, Compose, Kotlin, and codec dependencies are retained; those dependencies are not vendored here.
- `instructions/id/eska/screenshotwebp/ScreenshotConverter.fallback.java.txt`: a separate JADX fallback/raw-instruction reference for the failed legacy `ScreenshotConverter.convert(File, File)` method. Register names, `goto` labels, and raw instructions make this deliberately non-Java text; it is not a replacement implementation.
- `instructions/id/eska/screenshotwebp/MediaMonitor.fallback.java.txt`: an additional raw-instruction reference for the active monitor, whose structured `process(...)` output contains unresolved types and a type-inference warning stack trace.
- [`../bytecode/id/eska/screenshotwebp/`](../bytecode/id/eska/screenshotwebp/): the authoritative application smali from the same APK, covering 92 class files. Nested classes and anonymous/synthetic classes merge into fewer Java files. The complete class-by-class accounting is in [DECOMPILATION.md](../docs/DECOMPILATION.md#application-class-accounting).

## Read with the smali alongside

The main JADX run **exited 3 with 240 errors across the APK**, not successfully without errors. Within the retained application Java, there is one `JADX ERROR` marker and one generated `throw new UnsupportedOperationException("Method not decompiled: ...")`, both for `ScreenshotConverter.convert(File, File)`. There are also 47 `JADX WARN` markers across seven other application files. These diagnostics are preserved, not suppressed or repaired by inventing source.

Decompiler-generated exception bodies are **not actual application failures**. They mean JADX could not reconstruct a method. Likewise, output such as `??` types, `0 == true ? 1 : 0`, missing synthetic captured-field declarations, moved superclass calls, or removed/duplicated blocks can be misleading or invalid Java. A method without an error marker is not proof that its reconstruction is correct. Follow the authoritative smali when understanding control flow, resource cleanup, publication, and source-file deletion.

The original Kotlin/Gradle project, build configuration, and dependency/native build inputs remain missing. No Gradle scaffold or substituted runnable implementation is supplied. Application-owned recovered code is covered by the repository's GPL-3.0-only license; this reference tree does not establish complete corresponding-source obligations for the bundled binary.

See [decompiler commands, counts, and failures](../docs/DECOMPILATION.md), [architecture](../docs/ARCHITECTURE.md), and the [build-from-source limitations](../docs/BUILD-FROM-SOURCE.md).
