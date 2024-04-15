package stream.functional;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

public class MyMain {
    public static void main(String[] args) {


        FunctionalInterFace interFace = (a, b) -> {
            return 6;
        };

        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return false;
            }
        };

        Predicate<Integer> predicate1 = x -> x % 2 == 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.poll();
        queue.peek();


    }
}
