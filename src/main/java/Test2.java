import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Test2 {
    public static int SIB_BPI_CUT_OFF_DATE = 4;

    public static void main(String[] args) {

        try {
            getBpiDate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String getBpiDate() throws Exception {
        throw new RuntimeException("fhhd");
    }

    public static boolean isBrokenPeriodRequired(LocalDate date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(java.sql.Date.valueOf(date));
        if (calendar.get(Calendar.DATE) >= 5 && calendar.get(Calendar.DATE) <= 15) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


    /**
     * used in manage loan screen
     *
     * @param date
     * @param day
     * @return
     */
    public static LocalDate getEmiDate(Date date, int day) {
        Instant instant = date.toInstant();
        LocalDate currentDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate nextMonth = currentDate.withDayOfMonth(day);
        if (isBrokenPeriodRequired(currentDate) && currentDate.getDayOfMonth() > SIB_BPI_CUT_OFF_DATE) {
            return nextMonth.plusMonths(2);
        } else {
            return nextMonth.plusMonths(1);
        }
    }

    public static boolean isBrokenPeriodRequired() {
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(Calendar.DATE) >= 5 && calendar.get(Calendar.DATE) <= 15) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static String getBpiDate(int date) {
        LocalDate today = LocalDate.now();
        LocalDate nextMonth = today.withDayOfMonth(date);
        if (isBrokenPeriodRequired()) {
            if (today.getDayOfMonth() >= 1 && today.getDayOfMonth() <= SIB_BPI_CUT_OFF_DATE) {
                return nextMonth.format(DateTimeFormatter.ISO_LOCAL_DATE);
            }
            return nextMonth.plusMonths(1).format(DateTimeFormatter.ISO_LOCAL_DATE);
        }

        return null;
    }

    public static String getEmiDate(int date) {
        LocalDate today = LocalDate.now();
        LocalDate nextMonth = today.withDayOfMonth(date);
        if (isBrokenPeriodRequired() && today.getDayOfMonth() > SIB_BPI_CUT_OFF_DATE) {
            return nextMonth.plusMonths(2).format(DateTimeFormatter.ISO_LOCAL_DATE);
        } else {
            return nextMonth.plusMonths(1).format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
    }

}
