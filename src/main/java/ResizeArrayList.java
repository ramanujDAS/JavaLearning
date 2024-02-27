import java.util.LinkedList;
import java.util.List;

public class ResizeArrayList {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().freeMemory());
        List<Integer> myList = new LinkedList<>();
        System.out.println(myList.size());

        System.out.println(Runtime.getRuntime().freeMemory());

        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            myList.add(i);
        }
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(System.currentTimeMillis() - time);

    }
}
