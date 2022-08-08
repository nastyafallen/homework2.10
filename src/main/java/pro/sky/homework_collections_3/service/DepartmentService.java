package pro.sky.homework_collections_3.service;

import org.springframework.stereotype.Service;
import pro.sky.homework_collections_3.Employee;
import pro.sky.homework_collections_3.exceptions.EmployeeNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee salaryCounterMax(int department) {
        return employeeService.staffList().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee is not found"));

    }

    public Employee salaryCounterMin(int department) {
        return employeeService.staffList().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee is not found"));
    }

    public List<Employee> findEmployeesFromDepartment(int department) {
        return employeeService.staffList().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> findEmployees() {
        return employeeService.staffList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}
