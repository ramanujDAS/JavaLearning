package Jvm;

import java.util.ArrayList;
import java.util.List;

public class MyGCTest {
    public static void main(String[] args) throws InterruptedException {

        Runtime runtime = Runtime.getRuntime();

        long availableByte = runtime.freeMemory();
        System.out.println("free available free memory : " + availableByte / 1024);

        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            customers.add(new Customer("john"));
        }
        long availableBytes = runtime.freeMemory();
        System.out.println("free available memory after object creation : " + availableBytes / 1024);

        System.gc();
        Thread.sleep(2000);
        availableByte = runtime.freeMemory();
        System.out.println("fere memory after GC : " + availableByte / 1024);
        //derefercne memory

        customers = new ArrayList<>();
        // System.gc();
        Thread.sleep(2000);
        availableByte = runtime.freeMemory();
        System.out.println("free memory after  derefrence GC : " + availableByte / 1024);

        Thread.sleep(2000);
        System.out.println("free memory after  derefrence GC after 4s: " + availableByte / 1024);


    }
}
