package pro.sky.homework_collections_3;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    @JsonProperty("firstName")
    private String name;

    @JsonProperty("lastName")
    private String lastName;

    private final double salary;
    private final int department;

    public Employee(String name, String lastName, double salary, int department) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setName(String name) {
        StringUtils.lowerCase(name);
        StringUtils.capitalize(name);
        this.name = name;
    }

    public void setLastName(String lastName) {
        StringUtils.lowerCase(lastName);
        StringUtils.capitalize(lastName);
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && department == employee.department && name.equals(employee.name) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, salary, department);
    }

    @Override
    public String toString() {
        return "Employee {" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
