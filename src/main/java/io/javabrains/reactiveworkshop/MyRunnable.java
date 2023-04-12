package io.javabrains.reactiveworkshop;

public class MyRunnable implements Runnable {
    Integer testInt = 1;

    public void run() {
        methodOne();
    }

    public void methodOne() {
        int localVariable1 = 45;
        testInt++;
        MySharedObject localVariable2 =
                MySharedObject.sharedInstance;
        // System.out.println("method one local variable 2" + localVariable2.hashCode() + " " + Thread.currentThread().getName());
        System.out.println("shared Instance variable  object1 :" + localVariable2.object2.hashCode());
        System.out.println("shared object long " + ++localVariable2.member1);
        int a = localVariable2.get();
        a++;
        System.out.println("shared object get" + a);


        //... do more with local variables.

        methodTwo();
    }

    public void methodTwo() {
        Integer localVariable1 = new Integer(99);
        localVariable1++;
        testInt++;
        // System.out.println("method 2 localVariable1 " + localVariable1.hashCode() + " " + Thread.currentThread().getName());

        //System.out.println("testInt " + testInt);
        //... do more with local variable.
    }
}