package io.javabrains.reactiveworkshop;

import java.util.Collection;
import java.util.HashSet;

/*
 *inheritance issue over composition
 * */
public class MyHashSet<E> extends HashSet<E> {

    private int addCount = 0;

    public MyHashSet() {

    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    /**
     * @param c collection containing elements to be added to this collection
     * @return
     * @implSpec
     */

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        MyHashSet<String> s = new MyHashSet<>();
//        s.addAll(List.of("Ramanuj", "Navin", "Sunny"));
        System.out.println(s.getAddCount());
    }
}


