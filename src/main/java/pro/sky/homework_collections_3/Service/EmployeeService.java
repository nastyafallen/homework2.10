package pro.sky.homework_collections_3.service;

import org.springframework.stereotype.Service;
import pro.sky.homework_collections_3.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework_collections_3.exceptions.EmployeeNotFoundException;
import java.util.*;

@Service
public class EmployeeService {

    private Map<Employee, Integer> staff = new HashMap(Map.of(
            new Employee("Кот", "Федя"), 0,
            new Employee("Кот", "Тимофей"), 1,
            new Employee("Кот", "Барсик"), 2,
            new Employee("Кошка", "Даша"), 3,
            new Employee("Кошка", "Клёпа"), 4,
            new Employee("Кошка", "Багира"), 5,
            new Employee("Кошка", "Люся"), 6,
            new Employee("Кот Марк", "Шагал"), 7,
            new Employee("Кот", "Джек"), 8,
            new Employee("Кошка", "Джинни"), 9
    ));

    public static Integer randomNumber() {
        int a = 0;
        int b = 100;
        return a + (int) (Math.random() * b);
    }

    public Employee addEmployee(String name, String lastName) throws EmployeeAlreadyAddedException {
        Employee employee = new Employee(name, lastName);
        if (!staff.containsKey(employee)) {
            staff.put(employee, randomNumber());
        } else {
            throw new EmployeeAlreadyAddedException("Employee is already added");
        }
        return employee;
    }

    public Employee removeEmployee(String name, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(name, lastName);
        if (!staff.containsKey(employee)) {
            throw new EmployeeNotFoundException("Employee is not found");
        }
        staff.remove(employee);
        return employee;
    }

    public Employee searchEmployee(String name, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(name, lastName);
        if (!staff.containsKey(employee)) {
            throw new EmployeeNotFoundException("Employee is not found");
        }
        return employee;
    }

    public Set<Employee> staffList() {
        return new HashSet<>(staff.keySet());
    }

}
