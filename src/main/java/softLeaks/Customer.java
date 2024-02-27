package softLeaks;

import java.util.HashMap;
import java.util.Map;

public class Customer implements Comparable {

    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return id + " : " + name;
    }

    public Customer(int id) {
        super();
        this.id = id;
    }


    @Override
    public int compareTo(Object o) {
        Customer cm = (Customer) o;
        if (cm == this) return 0;

        return cm.id > this.id ? 1 : -1;
    }

    public static void main(String[] args) {
        Map<Integer, Customer> customers = new HashMap<>();
        customers.put(1, new Customer(2));
        customers.put(2, new Customer(3));
        customers.put(3, new Customer(4));
        for (Map.Entry<Integer, Customer> e : customers.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        System.out.println(customers);
    }
}

