package pro.sky.homework_collections_3.service;

import org.springframework.stereotype.Service;
import pro.sky.homework_collections_3.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework_collections_3.exceptions.EmployeeNotFoundException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class EmployeeService {

    private Map<Employee, Integer> staff = new HashMap(Map.of(
            new Employee("Кот", "Федя", 35000, 1), 0,
            new Employee("Кот", "Тимофей", 34500, 1), 1,
            new Employee("Кот", "Барсик", 33000, 1), 2,
            new Employee("Кошка", "Даша", 37100, 2), 3,
            new Employee("Кошка", "Клёпа", 29300, 2), 4,
            new Employee("Кошка", "Багира", 31100, 3), 5,
            new Employee("Кошка", "Люся", 52000, 4), 6,
            new Employee("Кот Марк", "Шагал", 27700, 4), 7,
            new Employee("Кот", "Джек", 39000, 5), 8,
            new Employee("Кошка", "Джинни", 34000, 5), 9
    ));

    public static Integer randomNumber() {
        int a = 0;
        int b = 100;
        return a + (int) (Math.random() * b);
    }

    int randomNumber2 = Stream.generate(() -> generateRandomNumber());



    public Employee addEmployee(String name, String lastName, int salary, int department) throws EmployeeAlreadyAddedException {
        Employee employee = new Employee(name, lastName, salary, department);
        if (!staff.containsKey(employee)) {
            staff.put(employee, randomNumber());
        } else {
            throw new EmployeeAlreadyAddedException("Employee is already added");
        }
        return employee;
    }

    public Employee removeEmployee(String name, String lastName, int salary, int department) throws EmployeeNotFoundException {
        Employee employee = new Employee(name, lastName, salary, department);
        if (!staff.containsKey(employee)) {
            throw new EmployeeNotFoundException("Employee is not found");
        }
        staff.remove(employee);
        return employee;
    }

    public Employee searchEmployee(String name, String lastName, int salary, int department) throws EmployeeNotFoundException {
        Employee employee = new Employee(name, lastName, salary, department);
        if (!staff.containsKey(employee)) {
            throw new EmployeeNotFoundException("Employee is not found");
        }
        return employee;
    }

    public Set<Employee> staffList() {
        return new HashSet<>(staff.keySet());
    }

    public static void sum(Employee[] employee) {
        int amount = 0;
        for (int i = 0; i < employee.length; i++) {
            amount += employee[i].getSalary();
            if (i == employee.length - 1) {
                System.out.print(employee[i].getSalary());
            } else {
                System.out.print(employee[i].getSalary() + " + ");
            }
        }
        float amountAverage = amount/10F;
        System.out.println();
        System.out.println("Сумма трат на зарплаты за месяц составила " + amount + " рублей");
        System.out.println("Средняя зарплата составила " + amountAverage + " рублей");
        System.out.println();
    }


    public static void salaryCounter(Employee[] employee) {
        int minNumber = employee[0].getSalary();
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() < minNumber) {
                minNumber = employee[i].getSalary();
            }
        }
        System.out.println("Минимальная зарплата составила = " + minNumber + " рублей");
        int maxNumber = employee[employee.length-1].getSalary();
        for (int i = employee.length - 1; i >= 0; i--) {
            if (employee[i].getSalary() > maxNumber) {
                maxNumber = employee[i].getSalary();
            }
        }
        System.out.println("Максимальная зарплата составила = " + maxNumber + " рублей");
        System.out.println();
    }

}
