package stream;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Frequency {
    public static void main(String[] args) {
        String s = "this is name name";
        HashSet<Character> set = new HashSet<>();
        s.chars()
                .filter(x -> !set.add((char) x))
                .findFirst()
                .ifPresent(x -> System.out.println((char) x));

        s.chars()
                .mapToObj(s1 -> Character.toLowerCase(Character.valueOf((char) s1)))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1L)
                .findFirst().ifPresent(x -> System.out.println(" repaea" + (char) x.getKey()));


        HashMap<String, Integer> freq = new HashMap<>();
        Stream.of(s.split(" ")).forEach(i -> freq.put(i, freq.getOrDefault(i, 0) + 1));

        // Map<String, Long> stringLongMap = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(s1 -> s1), Collectors.counting());
        Map<String, Long> stringIntegerMap = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(s1 -> s1, Collectors.counting()));
        ArrayList<String> list = new ArrayList<>();
        list.add("ramanuj");
        list.add("singh");

        //  for (Map.Entry<String, Long> l : stringLongMap.entrySet()) {

        // }
        System.out.println(list.stream().collect(Collectors.joining(",")));

        System.out.println(" " + stringIntegerMap);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate localDate1 = LocalDate.of(2024, 03, 20);
        System.out.println(localDate1);
        localDate.withYear(1995);
        System.out.println(localDate.withYear(1995));
        LocalDate localDate2 = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(localDate2);

        Date date = new Date();

        date.toInstant().atZone(ZoneId.of("Asia/Kolkata")).toLocalDate();
        Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.of("Asia/Kolkata")).toLocalDate();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-DD-mm");

        date = java.sql.Date.valueOf(localDate);
        LocalDate localDate3 = LocalDate.now();
        System.out.println(localDate3);
        //format.format(localDate3);
        LocalTime localTime = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(localTime);

        Calendar calendar = Calendar.getInstance();

        System.out.println("calendar :" + calendar.getTime());

        System.out.println(calendar.getTime().getTime());
        Duration duration = Duration.ofSeconds(23);
        System.out.println(duration.toMinutes());


        // Map<String, Long> stringLongMap = Stream.of(s.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting()));


    }

}
