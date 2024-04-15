package stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyStream {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);


        list.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);

        list.stream()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::print);

        list.stream()
                .map(s -> s + "")
                .filter(x -> x.startsWith("1"))
                .forEach(System.out::print);
        System.out.println();
        HashSet<Integer> set = new HashSet<>();
        list.stream()
                .filter(x -> !set.add(x))
                .forEach(System.out::println);


        list.stream()
                .findFirst()
                .ifPresent(System.out::println);


        List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 1, 2, 3);

        integerList.stream().map(i -> i * i * i).filter(i -> i > 50).forEach(System.out::println);
    }
}
