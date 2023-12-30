package streamTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MyStream {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = "2023-12-26 18:18:51";
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(format.parse(d));
    }

    public static LocalDate getEmiDate(Date date, int day) {
        Instant instant = date.toInstant();
        LocalDate currentDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate nextMonth = currentDate.withDayOfMonth(day);
        if (isBrokenPeriodRequired(currentDate)) {
            return nextMonth.plusMonths(2);
        } else {
            return nextMonth.plusMonths(1);
        }
    }

    public static boolean isBrokenPeriodRequired(LocalDate date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(java.sql.Date.valueOf(date));
        if (calendar.get(Calendar.DATE) >= 5 && calendar.get(Calendar.DATE) <= 15) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
