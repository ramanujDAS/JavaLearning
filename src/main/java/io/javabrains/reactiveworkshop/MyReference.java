package io.javabrains.reactiveworkshop;

public class MyReference {
    public static void main(String[] args) {

        Integer a = new Integer(2);
        Integer b = new Integer(2);
        MyClazz obj = new MyClazz();
        b = 4;
        // System.out.println(a == b);

        System.out.println(a.hashCode() + " " + b.hashCode());
    }

    public static void myRef(Integer x, Integer y) {
        x = 5;
        y = 6;

        System.out.println(x.hashCode() + " " + y.hashCode());

    }
}

