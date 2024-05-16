/*Construtor call super */

import java.time.Duration;

public class Super {

    public Super() {
        overrideMe();
    }

    public void overrideMe() {
        System.out.println("Super");
    }

}

class Sub extends Super {

    @Override
    public void overrideMe() {
        System.out.println("sub");
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();

        Duration duration = Duration.ofSeconds(1000);
        System.out.println(duration.toMinutes());

    }
}

class Parent {
    public Parent() {
        System.out.println("parent");
        overrideMe();
    }

    public void overrideMe() {
        System.out.println("parent");
    }
}


class A {
    public int var1;
}

class B extends A {

    public static void main(String[] args) {
        Integer x = 10;
        int y = 11111;

        int[] r = new int[3];
        System.out.println(x);
        System.out.println(y);

        fun(x, y, r);
        System.out.println(x);
        System.out.println(y);
        System.out.println(r[0]);

    }

    public static void fun(int x, Integer y, int[] r) {
        x++;
        y++;
        r[0] = 115;
        System.out.println(x);
        System.out.println(y);


    }
}

