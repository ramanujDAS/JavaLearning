import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Test2 {
    public static int SIB_BPI_CUT_OFF_DATE = 4;

    public static void main(String[] args) {
        LocalDate date = LocalDate.parse("2024-03-02");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        LocalDate today = LocalDate.now();
        LocalDate nextMonth = date.withDayOfMonth(5);
        System.out.println(nextMonth);
        Date dateEmi = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("date :" + date);
        System.out.println("bpi date: " + getBpiDate(5));
        System.out.println("emi date: " + getEmiDate(5));

        System.out.println(LocalDate.now().getDayOfMonth());

    }

    public static String getBpiDate(LocalDate date, int day) {
        LocalDate today = date;
        LocalDate nextMonth = today.withDayOfMonth(day);
        if (isBrokenPeriodRequired(today)) {
            if (today.getDayOfMonth() >= 1 && today.getDayOfMonth() <= SIB_BPI_CUT_OFF_DATE) {
                return nextMonth.format(DateTimeFormatter.ISO_LOCAL_DATE);
            }
            return nextMonth.plusMonths(1).format(DateTimeFormatter.ISO_LOCAL_DATE);
        }

        return null;
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
