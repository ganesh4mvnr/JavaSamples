import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class TestDateFormat {
    public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/dd/MM HH:mm:ss");
        System.out.println(String.format("Now = %s", sdf.format(now)));

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E, dd-MMM yyyy, QQQ G");
        DateTimeFormatter localizedFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println("Date format == " + date.format(dtf));

        System.out.println("localizedFormat == " + date.format(localizedFormat));

        LocalDate todayDate = LocalDate.now(); //LocalDate.parse("2024-09-29 00:00:00.000");
        System.out.println("todayDate = " + todayDate);
        LocalDate expDate = todayDate.plusDays(1);
        long noOfDays = todayDate.until(expDate, ChronoUnit.DAYS);
        System.out.println("expDate = " + expDate);
        if (noOfDays == 0)
            System.out.println("Zero Days = " + noOfDays);
        else
            System.out.println("noOfDays = " + noOfDays);
    }
}
