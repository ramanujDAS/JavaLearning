import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {

    public static void main(String[] args) {

        System.out.println(getImmediateNextMonth(5));
    }

    public static String getImmediateNextMonth(int date) {
        LocalDate today = LocalDate.now();
        LocalDate nextMonth = today.withDayOfMonth(date);
        if (today.getDayOfMonth() >= date) {
            nextMonth = nextMonth.plusMonths(1);
            return nextMonth.format(DateTimeFormatter.ISO_LOCAL_DATE);
        } else {
            return nextMonth.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
    }
}
