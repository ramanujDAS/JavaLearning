import java.time.Instant;

/*Construtor call super */

public class Super extends Parent {

    public Super() {
        overrideMe();
    }

    public void overrideMe() {
        System.out.println("Super");
    }

}

class Sub extends Super {
    private final Instant instant;

    public Sub() {
        instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        System.out.println("sub");
    }

    public static void main(String[] args) {
        Parent sub = new Sub();
        sub.overrideMe();
    }
}

class Parent {
    
    public void overrideMe() {
        System.out.println("parent");
    }
}

