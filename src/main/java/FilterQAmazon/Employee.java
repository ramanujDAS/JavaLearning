package FilterQAmazon;

import java.util.Objects;

public class Employee {
    private String name;
    private String org;
    private int exp;
    private boolean isManager;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public boolean isManager() {
        return isManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(org, employee.org);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, org, exp, isManager);
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", org='" + org + '\'' +
                ", exp=" + exp +
                ", isManager=" + isManager +
                '}';
    }


}
