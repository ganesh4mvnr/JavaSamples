package test;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

public class SampleLocalDate {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate d1 = LocalDate.parse("2024-09-27");
        LocalDate lastSunday = today.with(TemporalAdjusters.lastInMonth(java.time.DayOfWeek.SUNDAY));

        System.out.println("lastSunday = " + lastSunday);

        LocalDate expirationDate1 = LocalDate.parse("2024-09-27");
        LocalDate effectiveDate1 = LocalDate.parse("2024-09-26");
        LocalDate effectiveDate2 = LocalDate.parse("2024-09-28");
        LocalDate expirationDate2 = LocalDate.parse("2024-10-29");

        List<File> myFiles = List.of(
                new File(expirationDate1, effectiveDate1),
                new File(expirationDate2, effectiveDate2)
        );

        for (int i=0; i < myFiles.size(); i++) {
            LocalDate expirationDate = myFiles.get(i).expirationDate;
            LocalDate effectiveDate = myFiles.get(i).effectiveDate;

            if (expirationDate.isEqual(today) || expirationDate.isBefore(today)) {
                System.out.println("Record: " + i + " | expiration: will be deactivated - " + expirationDate);
            } else if (effectiveDate.isEqual(today) && expirationDate.isAfter(today)) {
                System.out.println("Record: " + i + " | effectiveDate: will be activated - " + effectiveDate);
            }
        }
    }
}

class File {
    public LocalDate expirationDate;
    public LocalDate effectiveDate;

    public File(LocalDate exp, LocalDate eff) {
        this.expirationDate = exp;
        this.effectiveDate = eff;
    }
}
