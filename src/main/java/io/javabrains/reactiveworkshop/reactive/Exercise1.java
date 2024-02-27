package io.javabrains.reactiveworkshop.reactive;

import io.javabrains.reactiveworkshop.StreamSources;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream

//        String list = StreamSources.intNumbersStream().filter(x -> {
//            System.out.println(x);
//            return true;
//        }).toList().toString();
//        System.out.println(list);

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
//        StreamSources.intNumbersStream().filter(x -> x < 5).forEach(x -> {
//            System.out.println(x);
//        });


        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
//        StreamSources.intNumbersStream().filter(x -> x > 5).skip(1).limit(2).forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
//        Integer number = StreamSources.intNumbersStream().filter(x -> x > 5).findFirst().orElse(-1);
//        System.out.println(number);

        // Print first names of all users in userStream
        // TODO: Write code here
        // StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        // List<Integer> userId = StreamSources.intNumbersStream().toList();
        // StreamSources.userStream().filter(user -> userId.contains(user.getId())).map(User::getFirstName).forEach(System.out::println);

        StreamSources.intNumbersStream().flatMap(userId -> StreamSources.userStream().filter(user -> user.getId() == userId))
                .forEach(x -> System.out.println(x.getId()));

    }

}
