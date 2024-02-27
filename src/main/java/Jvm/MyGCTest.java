package Jvm;

import java.util.ArrayList;
import java.util.List;

public class MyGCTest {

    //decreaase -Xmx to 10MB then GC will run automatically
    public static void main(String[] args) throws InterruptedException {

        Runtime runtime = Runtime.getRuntime();
        long availableByte = runtime.freeMemory();
        System.out.println("free available free memory : " + availableByte / 1024 / 1024);

        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            customers.add(new Customer("john " + i));
        }


        long availableBytes = runtime.freeMemory();
        System.out.println("free available memory after object creation : " + availableBytes / 1024 / 1024);

        System.gc();
        // Thread.sleep(2000);
        availableByte = runtime.freeMemory();
        System.out.println("free memory after GC : " + availableByte / 1024 / 1024);
        //derefercne memory

        customers = new ArrayList<>();
        System.gc();
        Thread.sleep(2000);
        availableByte = runtime.freeMemory();
        System.out.println("free memory after  dereference GC : " + availableByte / 1024 / 1024);

        Thread.sleep(10000);
        System.out.println("free memory after  dereference GC after 4s: " + availableByte / 1024 / 1024);


    }
}
