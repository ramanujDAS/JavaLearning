package ThreadOddEven;

import java.util.concurrent.Semaphore;

public class ThreadCall {

    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        Thread thread1 = new Thread(new A(printer));
        Thread thread2 = new Thread(new B(printer));

        thread1.start();
        thread2.start();
        Thread.sleep(2000);

    }
}


class A implements Runnable {
    Printer printer;
    int num = 1;
    public Semaphore semaphore = new Semaphore(1);


    public A(Printer printer) {
        this.printer = printer;
    }


    @Override
    public void run() {
       
        if (printer.isOdd) {
            try {
                semaphore.acquire();
                num = num + 2;
                printer.print(num);
                printer.isOdd = false;
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B extends A implements Runnable {

    Printer printer;
    int num = 0;

    public B(Printer printer) {
        super(printer);
        this.printer = printer;
    }

    @Override
    public void run() {
        if (!printer.isOdd) {
            num = num + 2;

            try {
                semaphore.acquire();
                printer.print(num);
                printer.isOdd = true;
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}