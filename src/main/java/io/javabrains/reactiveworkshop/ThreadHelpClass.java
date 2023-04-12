package io.javabrains.reactiveworkshop;

import java.util.List;


public class ThreadHelpClass {

    Object object = new Object();
    Object object1 = new Object();
    int x = 1;

    public void myMethod(List<Integer> list) throws InterruptedException {
//        int x = 1;
//        Integer y = 1;

        int y = 1;
//        System.out.println(Thread.activeCount() + " :" + ++x + " :" + ++y);
        synchronized (object) {
            System.out.println(Thread.activeCount() + " :" + ++x + " :" + ++y);
            List<Integer> localList = list;
            localList.add(1);
            localList.add(2);

            System.out.println(localList + " " + Thread.currentThread().getName());
            //this.myMethod(localList)
            Thread.sleep(2000);

        }
        //
        // System.out.println(Thread.currentThread().getName());


    }

    public void myMethod2(List<Integer> list) throws InterruptedException {
        // Thread.sleep(1000);
        synchronized (object) {
            System.out.println(Thread.activeCount() + " 2nd:" + ++x + " :");
            List<Integer> localList = list;
            localList.add(1);
            localList.add(2);
            System.out.println(localList + "2nd " + Thread.currentThread().getName());
        }
    }

}
