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
        this.name = StringUtils.capitalize(StringUtils.lowerCase(name));
    }

    public void setLastName(String lastName) {
        this.lastName = StringUtils.capitalize(StringUtils.lowerCase(lastName));
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
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
