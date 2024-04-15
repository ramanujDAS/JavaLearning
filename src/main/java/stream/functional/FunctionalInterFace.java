package stream.functional;

@FunctionalInterface
public interface FunctionalInterFace {
    int randomCal(int a, int b);

    default void print(int res) {
        System.out.println(res);
    }
}
