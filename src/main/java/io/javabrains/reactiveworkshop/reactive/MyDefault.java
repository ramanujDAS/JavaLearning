package io.javabrains.reactiveworkshop.reactive;

import java.util.ArrayList;

public interface MyDefault {

    default void print() {
        System.out.println(this);
    }

    void overRide();

}

class A implements MyDefault {


    public static void main(String[] args) {
        A myDefault = new A();
        myDefault.print();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);

    }

    @Override
    public void overRide() {
        print();
    }

    public void coVariant(A[] x) {
        System.out.println(x);
    }
}
