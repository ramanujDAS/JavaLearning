package io.javabrains.reactiveworkshop;

class Person {
    String name = "No name";

    public Person(String nm) {
        name = nm;
    }
}

public class Emp extends Person {
    public String empid;

    public Emp(String id) {
        super(id);
        empid = id;
    }

    public static void main(String[] args) {
        Person p = new Emp("1234");
        System.out.println(p.name);
    }
}
