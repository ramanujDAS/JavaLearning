package MyEnum;

public interface OprationAction {

    double apply(double x, double y);

    default void dummy() {
        System.out.println(this);
    }
}
