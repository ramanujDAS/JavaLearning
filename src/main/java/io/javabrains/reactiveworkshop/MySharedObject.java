package io.javabrains.reactiveworkshop;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MySharedObject {

    //static variable pointing to instance of MySharedObject

    public static final MySharedObject sharedInstance =
            new MySharedObject();


    //member variables pointing to two objects on the heap

    public String object2 = new String("22");
    public String object4 = new String("44");

    public int get() {
        int x = 10;
        BlockingQueue blockingQueue = new LinkedBlockingQueue();

        return x;


    }

    public long member1 = 12345;
    public long member2 = 67890;
}
