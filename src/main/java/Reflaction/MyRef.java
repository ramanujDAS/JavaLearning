package Reflaction;

import java.lang.reflect.Method;

public class MyRef {

    public void fun() {

    }

    private void fun2() {

    }

    public static void main(String[] args) {
        Class<?> claz = MyRef.class;
        Method[] methods = claz.getMethods();

        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
