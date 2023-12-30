import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) {

        HashMap<Integer[], Integer> uset = new HashMap<>();
        Integer[] array = new Integer[2];
        array[0] = 0;
        array[1] = 1;
        uset.put(array, 0);
        Integer[] array1 = new Integer[2];
        array1[0] = 0;
        array[1] = 1;
        System.out.println(array1 + " " + array);
    }

    public static String getImmediateNextMonth(int date) {
        LocalDate today = LocalDate.now();

        HashMap<Character, Integer> freq = new HashMap<>();

        LocalDate nextMonth = today.withDayOfMonth(date);
        if (today.getDayOfMonth() >= date) {
            nextMonth = nextMonth.plusMonths(1);
            return nextMonth.format(DateTimeFormatter.ISO_LOCAL_DATE);
        } else {
            return nextMonth.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }


    }
}
