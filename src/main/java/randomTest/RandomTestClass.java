package randomTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomTestClass {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            list.add(0);

        long intTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            Random random = new Random();
            int val = random.nextInt(10);
            list.set(val, list.get(val) + 1);
        }
        System.out.println((System.nanoTime() - intTime) / 1000);
        System.out.println(list);


    }


}
