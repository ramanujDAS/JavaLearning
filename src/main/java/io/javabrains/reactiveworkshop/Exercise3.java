package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise3 {
    static int size = 0;

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here

        ReactiveSources.intNumbersFlux().subscribe(x -> {
            System.out.println(x);
            size++;
        });


        System.out.println("Press a key to end");
        System.in.read();
        System.out.println(size);
    }

}
