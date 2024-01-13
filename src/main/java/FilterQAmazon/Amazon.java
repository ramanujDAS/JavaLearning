package FilterQAmazon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Amazon {

    public static void main(String[] args) {

        Predicate<Employee> condition = e -> "FPL".equals(e.getOrg());

        Employee employee = new Employee();
        employee.setExp(10);
        employee.setManager(false);
        employee.setName("Ramanuj");
        employee.setOrg("FPL");
        System.out.println(employee);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        List<String> result = new ArrayList<>();

        for (Employee e : employees) {
            if (condition.test(e)) {
                result.add(e.getName());
            }
        }

        System.out.println(result);
    }
}
