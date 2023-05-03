package io.javabrains.reactiveworkshop;

import io.javabrains.reactiveworkshop.reactive.type;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class FlywightDP {

    public static void main(String[] args) {

        boolean b = Boolean.valueOf("true");

        System.out.println(b);

        EnumSet<type> types = EnumSet.allOf(type.class);
        List<Integer> list = new ArrayList<>();

        System.out.println(types);
    }
}

class myclass extends ArrayList {


}
