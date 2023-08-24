package interviewQ;

public class mainClass {
    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        Thread thread1 = new Thread(new OddEvenThreads(10, printer, false));
        Thread thread2 = new Thread(new OddEvenThreads(10, printer, true));
        thread1.start();
        thread2.start();


    }
}
