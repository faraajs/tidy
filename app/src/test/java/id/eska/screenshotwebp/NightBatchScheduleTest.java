package id.eska.screenshotwebp;

import org.junit.Test;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import static org.junit.Assert.*;

public final class NightBatchScheduleTest {
    private static final ZoneId ZONE = ZoneId.of("Asia/Jakarta");
    private long at(String local) { return ZonedDateTime.parse(local + "+07:00[Asia/Jakarta]").toInstant().toEpochMilli(); }

    @Test public void rejectsBeforeThree() {
        assertFalse(NightBatchScheduler.inWindow(at("2026-10-24T02:59:59"), ZONE));
    }
    @Test public void acceptsThree() {
        assertTrue(NightBatchScheduler.inWindow(at("2026-10-24T03:00:00"), ZONE));
    }
    @Test public void acceptsBeforeSix() {
        assertTrue(NightBatchScheduler.inWindow(at("2026-10-24T05:59:59"), ZONE));
    }
    @Test public void rejectsSixAndDaytimeCharging() {
        assertFalse(NightBatchScheduler.inWindow(at("2026-10-24T06:00:00"), ZONE));
        assertFalse(NightBatchScheduler.inWindow(at("2026-10-24T12:00:00"), ZONE));
    }
    @Test public void requiresPowerAndNightTogether() {
        assertFalse(NightBatchScheduler.allowed(at("2026-10-24T04:00:00"), ZONE, false));
        assertFalse(NightBatchScheduler.allowed(at("2026-10-24T12:00:00"), ZONE, true));
        assertTrue(NightBatchScheduler.allowed(at("2026-10-24T04:00:00"), ZONE, true));
    }
    @Test public void beforeWindowSchedulesToday() {
        assertEquals(at("2026-10-24T03:00:00"), NightBatchScheduler.nextStart(at("2026-10-24T02:00:00"), ZONE, ""));
    }
    @Test public void lateChargingCanUseRemainingWindow() {
        long now = at("2026-10-24T04:00:00");
        assertEquals(now, NightBatchScheduler.nextStart(now, ZONE, ""));
    }
    @Test public void attemptedDayNeverScansAgain() {
        assertEquals(at("2026-10-25T03:00:00"), NightBatchScheduler.nextStart(at("2026-10-24T04:00:00"), ZONE, "2026-10-24"));
    }
    @Test public void missedWindowWaitsUntilNextNight() {
        assertEquals(at("2026-10-25T03:00:00"), NightBatchScheduler.nextStart(at("2026-10-24T06:00:00"), ZONE, ""));
    }
    @Test public void nextDateCrossesYearBoundary() {
        assertEquals(at("2027-01-01T03:00:00"), NightBatchScheduler.nextStart(at("2026-12-31T22:00:00"), ZONE, ""));
    }
    @Test public void usesPhoneZoneAndCalendarRatherThanTwentyFourHours() {
        ZoneId newYork = ZoneId.of("America/New_York");
        long now = ZonedDateTime.of(2026, 3, 7, 22, 0, 0, 0, newYork).toInstant().toEpochMilli();
        long expected = ZonedDateTime.of(2026, 3, 8, 3, 0, 0, 0, newYork).toInstant().toEpochMilli();
        assertEquals(expected, NightBatchScheduler.nextStart(now, newYork, ""));
    }
}
