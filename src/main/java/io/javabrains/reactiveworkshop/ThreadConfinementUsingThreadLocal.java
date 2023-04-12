package io.javabrains.reactiveworkshop;

import java.util.ArrayList;
import java.util.List;

public class ThreadConfinementUsingThreadLocal {
    public static void main(String[] args) throws InterruptedException {
        ThreadHelpClass helper = new ThreadHelpClass();
        int localStack = 3;
        List<Integer> list = new ArrayList<>();
        ThreadLocal<String> stringHolder = new ThreadLocal<>();
        Runnable runnable1 = () -> {
            // stringHolder.set("Thread in runnable1");
            try {
                Thread.sleep(0);
                helper.myMethod(list);

                //helper.myMethod2(list);
                // System.out.println(stringHolder.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //  System.out.println(Arrays.stream(Arrays.stream(Thread.currentThread().getStackTrace()).toArray()));
        };
        Runnable runnable2 = () -> {
            //stringHolder.set("Thread in runnable2");
            try {
                Thread.sleep(0);
                //  stringHolder.set("string in runnable2 changed");
                Thread.sleep(0);
                // helper.myMethod(list);
                //helper.myMethod2(list);
                //System.out.println(stringHolder.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable runnable3 = () -> {
            // stringHolder.set("Thread in runnable3");
            try {
                Thread.sleep(0);
                // helper.myMethod(list);
                // helper.myMethod2(list);
                // System.out.println(stringHolder.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable1);
        Thread thread3 = new Thread(runnable1);
        thread1.start();
        thread2.start();
        thread3.start();
        thread3.join();
        //Thread.sleep(2000);
        System.out.println(Thread.activeCount());
    }


}


