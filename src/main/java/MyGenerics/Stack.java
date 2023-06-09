package MyGenerics;

import java.util.Arrays;
import java.util.EmptyStackException;

class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];  // typeecast
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(3);
        stack.push(3);
        Integer x = (int) stack.pop();//before generics
        System.out.println(x);

        Stack<Integer> st = new Stack<>();
        st.push(2);
        st.push(4);


    }
}

