package io.javabrains.reactiveworkshop;

public class MyThreadExecute {

    public static void main(String[] args) {
        Runnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);

        thread1.start();
        ;
        thread2.start();

    }
}
