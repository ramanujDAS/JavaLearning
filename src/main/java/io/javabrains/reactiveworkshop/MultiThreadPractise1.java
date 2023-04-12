package io.javabrains.reactiveworkshop;

public class MultiThreadPractise1 {
    private static boolean ready;

    private static int number;
// no order maintained in os level to execute threads

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        String x;
        number = 42;
        ready = true;
        new ReaderThread().start();
    }
}
