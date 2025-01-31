package sample;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestCutoff {
    public static void main(String[] args) {
        DateInfo dateInfo = new DateInfo();
        dateInfo.setPlannedShipDate(1729646157);
        String timeZone = "America/Los_Angeles";
        long plannedShipDay = dateInfo.getPlannedShipDate();
        long cutOffTime = calculateCutOffTime(timeZone, plannedShipDay, 18, 0);
        System.out.println("Input: 1729646157");
        if (plannedShipDay > cutOffTime) {
            plannedShipDay = addDateForTimezone(timeZone, plannedShipDay, 1);
        }
        System.out.println("Output: " + plannedShipDay);
        System.out.println("Final dateInfo - PSD: " + dateInfo.getPlannedShipDate());
    }

    public static long calculateCutOffTime(String timezone, long date, int hours, int minute) {
        return ZonedDateTime.ofInstant(Instant.ofEpochSecond(date), ZoneId.of(timezone))
                .withHour(hours)
                .withMinute(minute)
                .withSecond(0)
                .toEpochSecond();
    }

    public static long addDateForTimezone(String timezone, long date, int daysToAdd) {
        ZonedDateTime zonedDateTime = Instant.ofEpochSecond(date).atZone(ZoneId.of(timezone)).plusDays(daysToAdd);
//        zonedDateTime = zonedDateTime.with(LocalTime.MIDNIGHT).withMinute(10);
        return zonedDateTime.toInstant().getEpochSecond();
    }
}

class DateInfo {
    public long getPlannedShipDate() {
        return plannedShipDate;
    }

    public void setPlannedShipDate(long plannedShipDate) {
        this.plannedShipDate = plannedShipDate;
    }

    public long plannedShipDate;
}
