package StringDeduplication;

public class MyClass {
    public static void main(String[] args) {
        String name = new String("Ram");
        System.out.println(name.hashCode());
        fun();
    }

    public static void fun() {
        String name1 = new String("Ram");
        System.out.println(name1.hashCode());
    }

}

