package MThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread {

    public static void main(String[] args) {
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000000000; i++) {
            threadPoolExecutor.execute(new My());
        }


    }

    static void exe() throws InterruptedException {
        System.out.println("waiting for 2 s " + Thread.currentThread().getName());
        Thread.sleep(2000);
        System.out.println("waiting done for 2sec " + Thread.currentThread().getName());

    }


}

class My implements Runnable {

    public void method() {
        System.out.println("X");
    }

    @Override
    public void run() {
        method();
    }
}
