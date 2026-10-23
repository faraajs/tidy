# Original Tidy 2.3.1: charging-only night batches

Based on official `v2.3.1` (`14959c5`), matching installed APK SHA-256
`e8e6bdac4167414a94cee409f77daee6a3a30e56592847c329053dffbbeb7e02`.

Automatic conversion now uses one persisted Android job, starting around 03:00
local time and only while charging with the screen off. No scan or new conversion
starts at or after 06:00. A late job skips to the next night. Android can delay or
stop a job; unfinished candidates wait for another night. There are no filesystem
observers, recurring recovery sweeps, or continuous foreground monitoring service.

The converter, quality/target selection, photo resizing, native codec code/flags,
source-identity/Gallery checks and original-deletion consent remain from 2.3.1.
The original 350 ms stability check and worker limits are retained. The dashboard
only changes its automatic-work labels to show the fixed night schedule and pause.
No configurable scheduler, network dependency, or compression profile is added.

Version code 6 / name `2.3.1-night.1`, original app ID `id.eska.tidy` and the
original release signing key allow an in-place update without clearing data.
Private credentials stay outside the checkout.

Durable automation consent is not toggled between sessions: doing that would
reset the activation timestamp and miss photos created during daytime. Job state
survives normal process death and reboot. Opening the dashboard only restores the
schedule. Force-stop, revoked permissions, and vendor restrictions can still
prevent automatic work; the OS does not allow an unconditional forever guarantee.

Removing power, waking the screen, pausing, or leaving the time window prevents
new conversions. An already running file may finish safely rather than being
interrupted during publication. Photos therefore remain uncompressed until an
eligible night, and storage savings are delayed too.

Use the `nightBatch` and `nightBatchLifecycle` instrumentation scenarios with
`am instrument -w -r` on the isolated `.batterytest` package. The former uses
owned fixture roots and an injected clock/power gate, without changing the phone
clock or personal media. Four deterministic screenshot/photo x WebP/AVIF hashes
must match the original baseline. The older `monitor` and `battery` scenarios
describe the retired continuous-monitoring contract; they are historical tests.

CPU-time reductions describe avoided work, not a measured daily battery percentage.
See [Android JobScheduler](https://developer.android.com/reference/android/app/job/JobScheduler)
and [AOSP power measurement limits](https://source.android.com/docs/core/power).
