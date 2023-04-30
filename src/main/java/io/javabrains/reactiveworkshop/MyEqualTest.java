package io.javabrains.reactiveworkshop;

import java.util.ArrayList;

public class MyEqualTest extends MyEqualTest2 {
    private final int id;

    public MyEqualTest(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        MyEqualTest obj1 = new MyEqualTest(1);
        MyEqualTest obj2 = new MyEqualTest(1);
        MyEqualTest2 obj3 = new MyEqualTest2();
        System.out.println(obj1.equals(obj2));
        System.out.println(obj3 instanceof MyEqualTest);

        ArrayList<MyEqualTest> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        System.out.println(obj1.toString());
        System.out.println(list.indexOf(obj1));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MyEqualTest)) return false;
        if (obj == this) return true;
        MyEqualTest o = (MyEqualTest) obj;
        return o.id == this.id;
    }
}
