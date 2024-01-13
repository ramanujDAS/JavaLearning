package Jvm;

public class MyMainStringPool {
    public static void main(String[] args) {
        //-XX:+PrintStringTableStatistics
        //-XX:StringTableSize=120121
        System.out.println("ramanuj");
        long timeStart = System.currentTimeMillis();
        for (Integer i = 0; i < 1000000000; i++) {
            System.out.println(i.toString().intern());
        }
        System.out.println((System.currentTimeMillis() - timeStart) / 1000);
    }
}
