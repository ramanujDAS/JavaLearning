package MThread;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyThread {

    public static void main(String[] args) {
        String template = "Hello, @{(name :: ramanuj)}! Today is @{(day)}.";
        Map<String, Object> variables = new HashMap<>();
        variables.put("name", "World");
        variables.put("day", "Tuesday");


        // String result = eval(template, variables);
        System.out.println(eval(template, variables));


    }

    static void exe() throws InterruptedException {
        System.out.println("waiting for 2 s " + Thread.currentThread().getName());
        Thread.sleep(2000);
        System.out.println("waiting done for 2sec " + Thread.currentThread().getName());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

    }

    public static String eval(String template, Map<String, Object> variables) {
        Pattern pattern = Pattern.compile("\\@\\{\\((\\w+)\\)\\}");
        Matcher matcher = pattern.matcher(template);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String variable = matcher.group(1);
            Object value = variables.get(variable);
            if (value != null) {
                matcher.appendReplacement(buffer, value.toString());
            } else {
                matcher.appendReplacement(buffer, matcher.group(0));
            }
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

}

class My implements Runnable {

    public void method() {
        System.out.println("X");
    }

    @Override
    public void run() {
        method();
    }
}
