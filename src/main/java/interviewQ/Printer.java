package interviewQ;

import java.util.concurrent.Semaphore;

class Printer {
    private volatile boolean isOdd = true;
    Semaphore semaphore = new Semaphore(1);

    void printEven(int number) {
        try {
            while (!isOdd) ;
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + ":" + number);
            isOdd = false;
            semaphore.release();


        } catch (Exception e) {

        }

    }

    void printOdd(int number) {
        try {
            while (isOdd) ;
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + ":" + number);
            isOdd = true;
            semaphore.release();
        } catch (Exception e) {

        }

    }


    synchronized void printOdd1(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = false;
        notify();

    }

    synchronized void printEven1(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = true;
        notify();

    }
}