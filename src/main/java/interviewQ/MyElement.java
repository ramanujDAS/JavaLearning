package interviewQ;

import java.util.LinkedList;
import java.util.Queue;

public class MyElement {
    private Queue<Integer> buffer;
    private final int capacity;

    public MyElement(int capacity) {
        this.buffer = new LinkedList<>();
        this.capacity = capacity;
    }

    synchronized void produce(int element) {
        if (buffer.size() == capacity) {
            try {
                wait();
                System.out.println("waiting in producer");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        buffer.add(element);
        notify();
        System.out.println("message published ::" + element);
        System.out.println("queue :: " + buffer);

    }

    synchronized int consume() throws Exception {
        if (buffer.isEmpty()) {
            System.out.println("no element");
            wait();
        }
        int popEle = buffer.remove();
        System.out.println("popped element :: " + popEle);
        System.out.println("queue element ::" + buffer);
        notify();
        return popEle;
    }
}
