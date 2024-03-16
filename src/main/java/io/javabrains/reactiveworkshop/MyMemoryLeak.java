package io.javabrains.reactiveworkshop;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.WeakHashMap;

public class MyMemoryLeak {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public MyMemoryLeak() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) throws FileNotFoundException {
        ensureCapacity();
        elements[size++] = e;

        Stack<Integer> stack = new Stack<>();
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];  // memory leak
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        Stack<Integer> stack = new Stack<>();
        WeakHashMap<String, Integer> stringIntegerWeakHashMap = new WeakHashMap<>();
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
