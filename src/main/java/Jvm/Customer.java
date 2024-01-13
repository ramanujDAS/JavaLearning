package Jvm;

public class Customer {
    int age;

    public Customer(String name) {
        this.name = name;
    }

    String name;
    int expense;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    @Override
    protected void finalize() throws Throwable {
        //whenever Gc called this
        System.out.println("being garbage collected :" + this.name);

    }
}
