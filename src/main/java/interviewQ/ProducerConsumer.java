package interviewQ;

import java.util.concurrent.TimeUnit;

public class ProducerConsumer {

    public static void main(String[] args) {
        final int[] messages = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 101};


        MyElement myElement = new MyElement(5);

        Thread producer = new Thread(() -> {
            for (int value : messages) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                    myElement.produce(value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    TimeUnit.MILLISECONDS.sleep(2000);
                    System.out.println(myElement.consume());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        producer.start();
        consumer.start();


    }
}

