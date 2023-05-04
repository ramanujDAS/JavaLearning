package MyGenerics;

import java.util.Collections;
import java.util.Stack;

public class test1 {
    private static Collections list;

    public test1(Collections list) {
        this.list = list;
    }

    public static void main(String[] args) {
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in";  // runtime error

        Object[] intArray = new Integer[5];
        intArray[0] = "adbjcadjbc";

        // List<String>[] stringLists = new List<String>[1];
        Stack<Integer> st = new Stack<>();
        // List<Object> ol = new ArrayList<Long>(); // compile time
        //ol.add("I don't fit in");
    }


}
