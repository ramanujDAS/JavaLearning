package MyGenerics;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> {
    private final T[] choiceArray;

    public Chooser(Collection<T> choices) {
        choiceArray = (T[]) choices.toArray();  // unchecked warning  compile time warning
        //choiceArray = new ArrayList<>().toArray();
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }

    @Override
    public String toString() {
        return "" + choiceArray;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Chooser chooser = new Chooser(list);
        chooser.choose();
        int c = (int) chooser.choose();  // needed to type cast

        Chooser<Integer> chooser1 = new Chooser<Integer>(list);
        int c1 = chooser1.choose();
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Collection<Integer> set = Chooser.union(s1, s2);

        /**
         * why we use bounded wildcard check below problem
         */
//        Set<String> guys = Set.of("Tom", "Dick", "Harry");
//        Set<String> stooges = Set.of("Larry", "Moe", "Curly");
//        Set<String> aflCio = union(guys, stooges);
//
//        System.out.println(aflCio);
        /**
         * now it work only for String generics
         * chnage the function  with bounded wildcard
         */

        // Set<Integer> integers = Set.of(1, 3, 5);
        // Set<Double> doubles = Set.of(2.0, 4.0, 6.0);
        // Set<Number> numbers = union(integers, doubles);
        //  System.out.println(numbers);

    }

    //non generics throw uncheck error
    //to make any generic method

    /**
     * The type parameter list, which declares the type parameters, goes between a method’s modifiers and its return type
     **/
    public static <T> Set<T> union(Set<? extends T> s1, Set<? extends T> s2) {
        Set<T> result = new HashSet<>(s1);
        result.addAll(s2);

        return result;
    }
}