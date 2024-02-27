package ThreadOddEven;

import java.util.concurrent.Semaphore;

public class Printer {

    Integer num = 1;
    volatile boolean isOdd = true;
    Semaphore semaphore = new Semaphore(1);

    public void print(int num) throws InterruptedException {

        Thread.sleep(100);
        System.out.println(num + " " + Thread.currentThread().getName());


    }
}
