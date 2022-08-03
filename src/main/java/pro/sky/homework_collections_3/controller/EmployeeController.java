package pro.sky.homework_collections_3.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework_collections_3.service.Employee;
import pro.sky.homework_collections_3.service.EmployeeService;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee add(@RequestParam("firstName") String name,
                        @RequestParam("lastName") String lastName,
                        @RequestParam double salary,
                        @RequestParam int department) {
        if (Objects.isNull(name) || Objects.isNull(lastName)) {
            System.out.println("Неправильно переданы параметры!");
        }
        return employeeService.addEmployee(name, lastName, salary, department);
    }

    @GetMapping(value = "/remove", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee remove(@RequestParam("firstName") String name,
                        @RequestParam("lastName") String lastName) {
        if (Objects.isNull(name) || Objects.isNull(lastName)) {
            System.out.println("Неправильно переданы параметры!");
        }
        return employeeService.removeEmployee(name, lastName);
    }

    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee find(@RequestParam("firstName") String name,
                           @RequestParam("lastName") String lastName) {
        if (Objects.isNull(name) || Objects.isNull(lastName)) {
            System.out.println("Неправильно переданы параметры!");
        }
        return employeeService.searchEmployee(name, lastName);
    }

    @GetMapping("/")
    public Set<Employee> staffList() {
        return employeeService.staffList();
    }
}
