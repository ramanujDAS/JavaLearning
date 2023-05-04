package MyGenerics;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> {
    private final T[] choiceArray;

    public Chooser(Collection<T> choices) {
        choiceArray = (T[]) choices.toArray();  // unchecked warning  compile time warning
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
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Collection<Integer> set = Chooser.union(s1, s2);
    }

    //non generics throw uncheck error
    //to make any generic method

    /**
     * Thetypeparameter list, which declares the type parameters, goesbetween a method’s modifiers and its return type
     **/
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
}