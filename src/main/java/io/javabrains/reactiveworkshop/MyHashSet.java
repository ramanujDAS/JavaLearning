package io.javabrains.reactiveworkshop;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

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
        s.addAll(List.of("Ramanuj", "Navin", "Sunny"));
        System.out.println(s.getAddCount());
    }
}


