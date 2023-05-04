package MyGenerics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> {
    private final T[] choiceArray;

    public Chooser(Collection<T> choices) {
        // choiceArray =(T[])choices.toArray();  // unchecked warning  compile time warning
        //choiceArray = new ArrayList<>().toArray();
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }

    @Override
    public String toString() {
        return "" + choiceArray;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Chooser chooser = new Chooser(list);
        chooser.choose();
        int c = (int) chooser.choose();  // needed to type cast

        Chooser<Integer> chooser1 = new Chooser<Integer>(list);
        int c1 = chooser1.choose();
    }
}