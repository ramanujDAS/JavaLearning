package io.javabrains.reactiveworkshop.reactive;

import io.javabrains.reactiveworkshop.ReactiveSources;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // TODO: Write code here

        // ReactiveSources.intNumbersFlux().subscribe(x -> System.out.println(x));

        // Print all users in the ReactiveSources.userFlux stream
        // TODO: Write code here
        ReactiveSources.userFlux().flatMap(user -> ReactiveSources.userFlux().filter(user1 -> user.getId() == user1.getId())).subscribe(x -> System.out.println(x));
        // System.out.println(id);
        System.out.println("Press a key to end");
        System.in.read();
    }

}
