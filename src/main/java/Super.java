import java.time.Instant;

/*Construtor call super */

public class Super {

    public Super() {
        overrideMe();
    }

    public void overrideMe() {

    }

}

class Sub extends Super {
    private final Instant instant;

    public Sub() {
        instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
