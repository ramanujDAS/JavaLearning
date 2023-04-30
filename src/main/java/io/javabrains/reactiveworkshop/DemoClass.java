package io.javabrains.reactiveworkshop;


import java.util.HashMap;

public class DemoClass {
    public static void main(String[] args) {

        HashMap<PhoneNumber, String> map = new HashMap<>();
        map.put(new PhoneNumber(707, 867, 5309), "ramanuj");

        System.out.println(map.get(new PhoneNumber(707, 867, 5309)));
    }
}