package io.javabrains.reactiveworkshop;

public class ArraySubType {

    public static void main(String[] args) {
        test2[] t = new test2[2];
        t[0] = new test2(1);
        t[1] = new test2(2);
        coVariant(t);
    }

    public static void coVariant(Object[] t) {
        for (Object x : t)
            System.out.println(x);
    }
}


class test1 {
    int x;

    test1(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "" + x;
    }
}

class test2 extends test1 {


    test2(int x) {
        super(x);
    }

    @Override
    public String toString() {
        return "" + x;
    }
}
