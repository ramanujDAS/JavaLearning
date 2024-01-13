package Explorememory.chapter05;

import java.util.ArrayList;
import java.util.List;

public class HeapStackTest {

    public static void main(String[] args) {

        Customer customer1 = new Customer("Ramanuj", 1, 861783636);
        Customer customer2 = new Customer("Shatadi", 2, 219872);
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        System.out.println(customerList);

        List<Customer> customers = new ArrayList<>(customerList);
        customers.get(0).setName("paresh");
        customers.get(0).setId(10);
        System.out.println(customerList);


    }


}

class Customer {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAadhar() {
        return aadhar;
    }

    public void setAadhar(Integer aadhar) {
        this.aadhar = aadhar;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", aadhar=" + aadhar +
                '}';
    }

    public Customer(String name, int id, Integer aadhar) {
        this.name = name;
        this.id = id;
        this.aadhar = aadhar;
    }

    private String name;
    private int id;
    private Integer aadhar;
}