# Decompilation record

## Provenance and status

These references were generated from `tidy-v2.2.0-ui-dark-arm64-r3.apk`, the preserved Tidy 2.2.0 r3 APK:

- SHA-256: `65d0ac7a45ed45181d7fd8f43fc7b9e9dec88f7f13f58371c1dbf365dfa6ed65`.
- Artifact size supplied with the recovery: 31,140,384 bytes.
- Application ID: `id.eska.tidy`; implementation namespace: `id.eska.screenshotwebp`.
- Decompiler: **JADX 1.5.6**, as reported by `jadx --version`.

**This is generated read-only reference, not recovered original Kotlin, a buildable checkout, or complete corresponding source for the APK.** No application behavior has been rewritten to make decompiler output compile. The APK was used only as input. Application smali remains authoritative when Java reconstruction is incomplete or misleading.

## Exact transformation options

The following commands express the actual options, substituting portable relative artifact names and scratch-directory variables for machine-local paths. Scratch locations are not deliverables. There was no quiet mode, Gradle export, dependency-source import, or application-code repair.

```sh
APK=releases/v2.2.0/tidy-v2.2.0-ui-dark-arm64-r3.apk
JADX_OUT=$(mktemp -d)
jadx --no-res --threads-count 4 --show-bad-code -d "$JADX_OUT" "$APK"
```

The main process **returned exit code 3**, and the captured output ended with **`ERROR - finished with errors, count: 240`**. The last progress message was `4405 of 4406 (99%)`; the command then terminated with errors, rather than reporting a clean 100% success. The default log did not enumerate the 240 errors individually. Failure details embedded in the application Java are inventoried below. The aggregate includes the entire APK, not just retained application files; its value must not be described as 240 application failures.

Selected captured log lines, omitting repeated progress messages only:

```text
INFO  - loading ...
INFO  - processing ...
INFO  - progress: 4405 of 4406 (99%)
ERROR - finished with errors, count: 240
```

The legacy screenshot converter failed to reconstruct. A separate targeted simple-mode attempt used:

```sh
SIMPLE_OUT=$(mktemp -d)
jadx --no-res --threads-count 4 --show-bad-code \
  --decompilation-mode simple \
  --single-class id.eska.screenshotwebp.ScreenshotConverter \
  --single-class-output "$SIMPLE_OUT/ScreenshotConverter.java" "$APK"
```

That process also **returned exit code 3**, with `ERROR - finished with errors, count: 2`. Its generated method contained both the type-inference failure and a simple-mode code-generation failure (`NullPointerException`: `type` was null during `ArgType.getPrimitiveType()`). It still emitted a method-not-decompiled exception body. This unsuccessful extra output is not substituted for the main Java reference.

Raw-instruction fallback mode recovered a separate readable instruction listing:

```sh
FALLBACK_OUT=$(mktemp -d)
jadx --no-res --threads-count 4 --show-bad-code \
  --decompilation-mode fallback \
  --single-class id.eska.screenshotwebp.ScreenshotConverter \
  --single-class-output "$FALLBACK_OUT/ScreenshotConverter.java" "$APK"
```

This targeted fallback process **returned exit code 0** (`INFO  - done`). Its output is preserved as [`ScreenshotConverter.fallback.java.txt`](../sources/instructions/id/eska/screenshotwebp/ScreenshotConverter.fallback.java.txt), not as runnable Java and not as a claimed correction of the main failed decompilation.

The active monitor's structured `process(...)` also contains unresolved types and a decompiler type-inference warning stack trace, so a separate fallback reference was generated:

```sh
MONITOR_OUT=$(mktemp -d)
jadx --no-res --threads-count 4 --show-bad-code \
  --decompilation-mode fallback \
  --single-class id.eska.screenshotwebp.MediaMonitor \
  --single-class-output "$MONITOR_OUT/MediaMonitor.java" "$APK"
```

This targeted fallback process **returned exit code 0** (`INFO  - done`). Its full-class instruction output is [`MediaMonitor.fallback.java.txt`](../sources/instructions/id/eska/screenshotwebp/MediaMonitor.fallback.java.txt). Fallback output preserves register operations, jumps, and exception-handler targets rather than restoring Kotlin structure. Cross-check it with smali; successful fallback generation does not prove the structured Java is correct.

A fresh full resource/smali transformation was also generated for the integration owner's comparison, without overwriting the repository copies:

```sh
APKTOOL_JAR=apktool_2.10.0.jar
DECODE_PARENT=$(mktemp -d)
java -jar "$APKTOOL_JAR" d -o "$DECODE_PARENT/decoded" "$APK"
```

Apktool reported **2.10.0**, decoded both `classes.dex` and `classes2.dex`, and **returned exit code 0**. Byte-for-byte comparison of that fresh decode against the checked-in resources and application smali is a separate integration verification; it is not claimed by this transformation record.

## Output inventory

| Item | Count |
| --- | ---: |
| Java files emitted into the main scratch `sources/` tree, across all APK namespaces | 5,840 |
| Java files retained under `sources/id/eska/screenshotwebp/` | 26 |
| Main generated Java files outside the app namespace, deliberately not copied | 5,814 |
| Retained application Java, UTF-8 bytes | 314,614 |
| Retained application Java, lines | 5,166 |
| Authoritative application smali class files | 92 |
| Standalone Java declarations corresponding to those smali classes | 26 |
| Nested Java declarations corresponding to those smali classes | 13 |
| Anonymous Java declarations corresponding to those smali classes | 53 |
| Application smali classes lacking a corresponding Java declaration | 0 |
| Separate raw-instruction reference files | 2 |
| `ScreenshotConverter` raw reference, UTF-8 bytes / lines | 19,823 / 435 |
| `MediaMonitor` raw reference, UTF-8 bytes / lines | 45,426 / 852 |
| `JADX ERROR` markers in the retained main application Java | 1 |
| `JADX WARN` markers in the retained main application Java | 47 |
| Generated method-not-decompiled exception bodies in retained main application Java | 1 |

The progress denominator of 4,406 is JADX's processing count, **not** a Java-file count or this repository's application-class count. Nested merging and synthetic/anonymous inlining explain the 92-to-26 application-file difference. The extra two `.java.txt` instruction references are not additional application classes. References to third-party APIs and names that originated in inlined Kotlin/Compose code remain within generated app classes; unrelated dependency Java trees are excluded.

## Application-specific failures and warnings

### Failed method

[`ScreenshotConverter.java`](../sources/id/eska/screenshotwebp/ScreenshotConverter.java), `convert(File, File)`:

- `JADX ERROR: Type inference failed`.
- `JadxOverflowException`: type-inference updates reached the limit at `updateSeq = 7461`.
- The generated method comment says the dump was skipped at **746 instruction units** and suggests `--comments-level debug` to see the dump.
- The emitted `throw new UnsupportedOperationException("Method not decompiled: ...")` is **a decompiler placeholder, not an exception body recovered from the app**.
- Read the separate [fallback instructions](../sources/instructions/id/eska/screenshotwebp/ScreenshotConverter.fallback.java.txt) and [authoritative smali](../bytecode/id/eska/screenshotwebp/ScreenshotConverter.smali) instead of inferring that this converter always throws at runtime.

### Warning inventory

These are counts of literal diagnostic markers, not counts of known application bugs or affected methods. All original diagnostic comments remain in the generated references.

| Generated file | Warning markers | Affected areas / warning categories |
| --- | ---: | --- |
| `MainActivity$Dashboard$lambda$0$0$$inlined$items$default$2.java` | 1 | Superclass call moved in the synthetic constructor; JADX explicitly warns that this can break semantics. |
| `MainActivity.java` | 7 | Four mutable-state getters with failed multi-variable inference; two inlined lazy-item constructors with moved superclass calls; `CategoryCard$lambda$0` with an unreachable block removed (39 instructions). |
| `MediaConverter.java` | 2 | `convert(...)`: duplicated blocks during cleanup/publication reconstruction. |
| `MediaMonitor.java` | 24 | Constructors, `observeTree(...)` and its anonymous observer constructor, and `process(...)`: failed inference, unresolved types, duplicated code, moved superclass call. The `process(...)` warning includes an `UnsupportedOperationException` **inside a decompiler stack trace**, not an app throw. |
| `MonitorService.java` | 1 | `onStartCommand(...)`: failed multi-variable inference and misleading synthetic-default-argument reconstruction. |
| `ScreenshotMediaConverter.java` | 10 | Constructors and `convert(...)`: failed inference; `publish(...)`: duplicated blocks. |
| `ScreenshotMonitor.java` | 2 | Constructor multi-variable inference and unresolved anonymous observer type in `start()`. |
| **Total** | **47** | |

Examples to inspect before reasoning from Java:

- `MediaMonitor.process(...)` starts with `??` variable types. Its fallback listing retains the active path's stability checks, converter selection, and callbacks without pretending these are valid Java local declarations. The retained retry constant is not evidence of an implemented retry loop.
- `MediaMonitor.observeTree(...)` and `ScreenshotMonitor.start()` show `??` observer variables; their anonymous classes are nonetheless accounted for and their smali is preserved.
- Synthetic constructors in `ScreenshotMediaConverter`, `MediaMonitor`, and `MonitorService` can contain output such as `0 == true ? 1 : 0` or comparisons of inferred arrays with booleans. These are reconstruction artifacts, not trustworthy source expressions.
- Decompiled anonymous lambdas can refer to captured `this.f$0` fields without a valid recoverable declaration. No fields were fabricated to make them compile.
- Warnings about duplicated/removed blocks matter around resource cleanup and publication. Absence of an error marker does not establish semantic equivalence.

## Application class accounting

Each row links an authoritative smali class to its standalone, nested, or anonymous declaration in the retained Java. Anonymous entries use JADX's `from class:` marker; `ScreenshotMonitor$start$1` is rendered as `ScreenshotMonitor.start.1`. Kotlin companion/enum/switch-mapping classes are nested in their owner file. Synthetic lambda classes remain represented as anonymous declarations rather than separate Java files.

| Original smali class (within `id.eska.screenshotwebp`) | Java reference | Representation | Authoritative bytecode |
| --- | --- | --- | --- |
| `AppState` | [AppState.java](../sources/id/eska/screenshotwebp/AppState.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/AppState.smali) |
| `AppStateStore$Companion` | [AppStateStore.java](../sources/id/eska/screenshotwebp/AppStateStore.java) | Nested declaration | [smali](../bytecode/id/eska/screenshotwebp/AppStateStore$Companion.smali) |
| `AppStateStore$WhenMappings` | [AppStateStore.java](../sources/id/eska/screenshotwebp/AppStateStore.java) | Nested declaration | [smali](../bytecode/id/eska/screenshotwebp/AppStateStore$WhenMappings.smali) |
| `AppStateStore` | [AppStateStore.java](../sources/id/eska/screenshotwebp/AppStateStore.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/AppStateStore.smali) |
| `BootReceiver` | [BootReceiver.java](../sources/id/eska/screenshotwebp/BootReceiver.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/BootReceiver.smali) |
| `CategoryConfig$Companion` | [CategoryConfig.java](../sources/id/eska/screenshotwebp/CategoryConfig.java) | Nested declaration | [smali](../bytecode/id/eska/screenshotwebp/CategoryConfig$Companion.smali) |
| `CategoryConfig` | [CategoryConfig.java](../sources/id/eska/screenshotwebp/CategoryConfig.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/CategoryConfig.smali) |
| `ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda0` | [ComposableSingletons$MainActivityKt.java](../sources/id/eska/screenshotwebp/ComposableSingletons$MainActivityKt.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda0.smali) |
| `ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda1` | [ComposableSingletons$MainActivityKt.java](../sources/id/eska/screenshotwebp/ComposableSingletons$MainActivityKt.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda1.smali) |
| `ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda2` | [ComposableSingletons$MainActivityKt.java](../sources/id/eska/screenshotwebp/ComposableSingletons$MainActivityKt.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda2.smali) |
| `ComposableSingletons$MainActivityKt` | [ComposableSingletons$MainActivityKt.java](../sources/id/eska/screenshotwebp/ComposableSingletons$MainActivityKt.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/ComposableSingletons$MainActivityKt.smali) |
| `CompressionCandidate` | [CompressionCandidate.java](../sources/id/eska/screenshotwebp/CompressionCandidate.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/CompressionCandidate.smali) |
| `CompressionPlanKt` | [CompressionPlanKt.java](../sources/id/eska/screenshotwebp/CompressionPlanKt.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/CompressionPlanKt.smali) |
| `ConversionResult$Status` | [ConversionResult.java](../sources/id/eska/screenshotwebp/ConversionResult.java) | Nested declaration | [smali](../bytecode/id/eska/screenshotwebp/ConversionResult$Status.smali) |
| `ConversionResult` | [ConversionResult.java](../sources/id/eska/screenshotwebp/ConversionResult.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/ConversionResult.smali) |
| `MainActivity$$ExternalSyntheticLambda0` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda0.smali) |
| `MainActivity$$ExternalSyntheticLambda1` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda1.smali) |
| `MainActivity$$ExternalSyntheticLambda10` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda10.smali) |
| `MainActivity$$ExternalSyntheticLambda11` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda11.smali) |
| `MainActivity$$ExternalSyntheticLambda12` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda12.smali) |
| `MainActivity$$ExternalSyntheticLambda13` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda13.smali) |
| `MainActivity$$ExternalSyntheticLambda14` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda14.smali) |
| `MainActivity$$ExternalSyntheticLambda15` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda15.smali) |
| `MainActivity$$ExternalSyntheticLambda16` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda16.smali) |
| `MainActivity$$ExternalSyntheticLambda17` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda17.smali) |
| `MainActivity$$ExternalSyntheticLambda18` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda18.smali) |
| `MainActivity$$ExternalSyntheticLambda19` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda19.smali) |
| `MainActivity$$ExternalSyntheticLambda2` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda2.smali) |
| `MainActivity$$ExternalSyntheticLambda20` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda20.smali) |
| `MainActivity$$ExternalSyntheticLambda21` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda21.smali) |
| `MainActivity$$ExternalSyntheticLambda22` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda22.smali) |
| `MainActivity$$ExternalSyntheticLambda23` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda23.smali) |
| `MainActivity$$ExternalSyntheticLambda24` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda24.smali) |
| `MainActivity$$ExternalSyntheticLambda25` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda25.smali) |
| `MainActivity$$ExternalSyntheticLambda26` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda26.smali) |
| `MainActivity$$ExternalSyntheticLambda27` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda27.smali) |
| `MainActivity$$ExternalSyntheticLambda28` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda28.smali) |
| `MainActivity$$ExternalSyntheticLambda3` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda3.smali) |
| `MainActivity$$ExternalSyntheticLambda4` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda4.smali) |
| `MainActivity$$ExternalSyntheticLambda5` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda5.smali) |
| `MainActivity$$ExternalSyntheticLambda6` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda6.smali) |
| `MainActivity$$ExternalSyntheticLambda7` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda7.smali) |
| `MainActivity$$ExternalSyntheticLambda8` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda8.smali) |
| `MainActivity$$ExternalSyntheticLambda9` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$$ExternalSyntheticLambda9.smali) |
| `MainActivity$Dashboard$1$1$4$1$1` | [MainActivity$Dashboard$1$1$4$1$1.java](../sources/id/eska/screenshotwebp/MainActivity$Dashboard$1$1$4$1$1.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$Dashboard$1$1$4$1$1.smali) |
| `MainActivity$Dashboard$lambda$0$0$$inlined$items$default$1` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$Dashboard$lambda$0$0$$inlined$items$default$1.smali) |
| `MainActivity$Dashboard$lambda$0$0$$inlined$items$default$2` | [MainActivity$Dashboard$lambda$0$0$$inlined$items$default$2.java](../sources/id/eska/screenshotwebp/MainActivity$Dashboard$lambda$0$0$$inlined$items$default$2.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$Dashboard$lambda$0$0$$inlined$items$default$2.smali) |
| `MainActivity$Dashboard$lambda$0$0$$inlined$items$default$3` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$Dashboard$lambda$0$0$$inlined$items$default$3.smali) |
| `MainActivity$Dashboard$lambda$0$0$$inlined$items$default$4` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$Dashboard$lambda$0$0$$inlined$items$default$4.smali) |
| `MainActivity$SetupScreen$1$1$5$1$1` | [MainActivity$SetupScreen$1$1$5$1$1.java](../sources/id/eska/screenshotwebp/MainActivity$SetupScreen$1$1$5$1$1.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity$SetupScreen$1$1$5$1$1.smali) |
| `MainActivity` | [MainActivity.java](../sources/id/eska/screenshotwebp/MainActivity.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivity.smali) |
| `MainActivityKt` | [MainActivityKt.java](../sources/id/eska/screenshotwebp/MainActivityKt.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/MainActivityKt.smali) |
| `MediaCategory` | [MediaCategory.java](../sources/id/eska/screenshotwebp/MediaCategory.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaCategory.smali) |
| `MediaConverter$$ExternalSyntheticLambda0` | [MediaConverter.java](../sources/id/eska/screenshotwebp/MediaConverter.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaConverter$$ExternalSyntheticLambda0.smali) |
| `MediaConverter$EncodedCandidate` | [MediaConverter.java](../sources/id/eska/screenshotwebp/MediaConverter.java) | Nested declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaConverter$EncodedCandidate.smali) |
| `MediaConverter$WhenMappings` | [MediaConverter.java](../sources/id/eska/screenshotwebp/MediaConverter.java) | Nested declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaConverter$WhenMappings.smali) |
| `MediaConverter` | [MediaConverter.java](../sources/id/eska/screenshotwebp/MediaConverter.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaConverter.smali) |
| `MediaModelKt$WhenMappings` | [MediaModelKt.java](../sources/id/eska/screenshotwebp/MediaModelKt.java) | Nested declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaModelKt$WhenMappings.smali) |
| `MediaModelKt` | [MediaModelKt.java](../sources/id/eska/screenshotwebp/MediaModelKt.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaModelKt.smali) |
| `MediaMonitor$$ExternalSyntheticLambda0` | [MediaMonitor.java](../sources/id/eska/screenshotwebp/MediaMonitor.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda0.smali) |
| `MediaMonitor$$ExternalSyntheticLambda1` | [MediaMonitor.java](../sources/id/eska/screenshotwebp/MediaMonitor.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda1.smali) |
| `MediaMonitor$$ExternalSyntheticLambda2` | [MediaMonitor.java](../sources/id/eska/screenshotwebp/MediaMonitor.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda2.smali) |
| `MediaMonitor$$ExternalSyntheticLambda3` | [MediaMonitor.java](../sources/id/eska/screenshotwebp/MediaMonitor.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda3.smali) |
| `MediaMonitor$$ExternalSyntheticLambda4` | [MediaMonitor.java](../sources/id/eska/screenshotwebp/MediaMonitor.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda4.smali) |
| `MediaMonitor$$ExternalSyntheticLambda5` | [MediaMonitor.java](../sources/id/eska/screenshotwebp/MediaMonitor.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda5.smali) |
| `MediaMonitor$$ExternalSyntheticLambda6` | [MediaMonitor.java](../sources/id/eska/screenshotwebp/MediaMonitor.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda6.smali) |
| `MediaMonitor$$ExternalSyntheticLambda7` | [MediaMonitor.java](../sources/id/eska/screenshotwebp/MediaMonitor.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaMonitor$$ExternalSyntheticLambda7.smali) |
| `MediaMonitor$Companion` | [MediaMonitor.java](../sources/id/eska/screenshotwebp/MediaMonitor.java) | Nested declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaMonitor$Companion.smali) |
| `MediaMonitor$WhenMappings` | [MediaMonitor.java](../sources/id/eska/screenshotwebp/MediaMonitor.java) | Nested declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaMonitor$WhenMappings.smali) |
| `MediaMonitor$observeTree$3$observer$1` | [MediaMonitor.java](../sources/id/eska/screenshotwebp/MediaMonitor.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaMonitor$observeTree$3$observer$1.smali) |
| `MediaMonitor` | [MediaMonitor.java](../sources/id/eska/screenshotwebp/MediaMonitor.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/MediaMonitor.smali) |
| `MonitorService$$ExternalSyntheticLambda0` | [MonitorService.java](../sources/id/eska/screenshotwebp/MonitorService.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MonitorService$$ExternalSyntheticLambda0.smali) |
| `MonitorService$$ExternalSyntheticLambda1` | [MonitorService.java](../sources/id/eska/screenshotwebp/MonitorService.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/MonitorService$$ExternalSyntheticLambda1.smali) |
| `MonitorService$Companion` | [MonitorService.java](../sources/id/eska/screenshotwebp/MonitorService.java) | Nested declaration | [smali](../bytecode/id/eska/screenshotwebp/MonitorService$Companion.smali) |
| `MonitorService` | [MonitorService.java](../sources/id/eska/screenshotwebp/MonitorService.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/MonitorService.smali) |
| `OutputFormat` | [OutputFormat.java](../sources/id/eska/screenshotwebp/OutputFormat.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/OutputFormat.smali) |
| `PathPolicy` | [PathPolicy.java](../sources/id/eska/screenshotwebp/PathPolicy.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/PathPolicy.smali) |
| `R$string` | [R.java](../sources/id/eska/screenshotwebp/R.java) | Nested declaration | [smali](../bytecode/id/eska/screenshotwebp/R$string.smali) |
| `R` | [R.java](../sources/id/eska/screenshotwebp/R.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/R.smali) |
| `ScreenshotConverter` | [ScreenshotConverter.java](../sources/id/eska/screenshotwebp/ScreenshotConverter.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/ScreenshotConverter.smali) |
| `ScreenshotMediaConverter$$ExternalSyntheticLambda0` | [ScreenshotMediaConverter.java](../sources/id/eska/screenshotwebp/ScreenshotMediaConverter.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/ScreenshotMediaConverter$$ExternalSyntheticLambda0.smali) |
| `ScreenshotMediaConverter$WhenMappings` | [ScreenshotMediaConverter.java](../sources/id/eska/screenshotwebp/ScreenshotMediaConverter.java) | Nested declaration | [smali](../bytecode/id/eska/screenshotwebp/ScreenshotMediaConverter$WhenMappings.smali) |
| `ScreenshotMediaConverter` | [ScreenshotMediaConverter.java](../sources/id/eska/screenshotwebp/ScreenshotMediaConverter.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/ScreenshotMediaConverter.smali) |
| `ScreenshotMonitor$$ExternalSyntheticLambda0` | [ScreenshotMonitor.java](../sources/id/eska/screenshotwebp/ScreenshotMonitor.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/ScreenshotMonitor$$ExternalSyntheticLambda0.smali) |
| `ScreenshotMonitor$$ExternalSyntheticLambda1` | [ScreenshotMonitor.java](../sources/id/eska/screenshotwebp/ScreenshotMonitor.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/ScreenshotMonitor$$ExternalSyntheticLambda1.smali) |
| `ScreenshotMonitor$$ExternalSyntheticLambda2` | [ScreenshotMonitor.java](../sources/id/eska/screenshotwebp/ScreenshotMonitor.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/ScreenshotMonitor$$ExternalSyntheticLambda2.smali) |
| `ScreenshotMonitor$$ExternalSyntheticLambda3` | [ScreenshotMonitor.java](../sources/id/eska/screenshotwebp/ScreenshotMonitor.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/ScreenshotMonitor$$ExternalSyntheticLambda3.smali) |
| `ScreenshotMonitor$Companion` | [ScreenshotMonitor.java](../sources/id/eska/screenshotwebp/ScreenshotMonitor.java) | Nested declaration | [smali](../bytecode/id/eska/screenshotwebp/ScreenshotMonitor$Companion.smali) |
| `ScreenshotMonitor$start$1` | [ScreenshotMonitor.java](../sources/id/eska/screenshotwebp/ScreenshotMonitor.java) | Anonymous declaration | [smali](../bytecode/id/eska/screenshotwebp/ScreenshotMonitor$start$1.smali) |
| `ScreenshotMonitor` | [ScreenshotMonitor.java](../sources/id/eska/screenshotwebp/ScreenshotMonitor.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/ScreenshotMonitor.smali) |
| `TargetBucket` | [TargetBucket.java](../sources/id/eska/screenshotwebp/TargetBucket.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/TargetBucket.smali) |
| `TargetPolicyKt` | [TargetPolicyKt.java](../sources/id/eska/screenshotwebp/TargetPolicyKt.java) | Standalone declaration | [smali](../bytecode/id/eska/screenshotwebp/TargetPolicyKt.smali) |

## Privacy and recovery boundaries

Only generated application-namespace references and the two targeted instruction listings are published here; full third-party decompiler output and scratch logs/decoded binaries are not repository deliverables. Generated application text is retained without behavioral edits. No local absolute build roots, scratch locations, credentials, private signing material, or personal media are included in these references or commands. Runtime directory policy and temporary output naming from the app remain part of recovered behavior, not private workstation paths.

The source-generation task ran no builds, tests, linters, formatters, installation, or runtime smoke checks. The integration owner is responsible for artifact hashes, decode comparisons, repository privacy checks, and other publication gates. See [the source README](../sources/README.md), [recovery notes](RECOVERY-NOTES.md), and [build-from-source limitations](BUILD-FROM-SOURCE.md).
