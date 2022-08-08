package pro.sky.homework_collections_3.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework_collections_3.service.DepartmentService;
import pro.sky.homework_collections_3.Employee;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/max-salary", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee salaryCounterMax(@RequestParam("departmentId") int department) {
        return departmentService.salaryCounterMax(department);
    }

    @GetMapping(value = "/min-salary", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee salaryCounterMin(@RequestParam("departmentId") int department) {
        return departmentService.salaryCounterMin(department);
    }

    @GetMapping(value = "/all", params = "departmentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> findEmployeesFromDepartment(@RequestParam("departmentId") int department) {
        return departmentService.findEmployeesFromDepartment(department);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Integer, List<Employee>> findEmployees() {
        return departmentService.findEmployees();
    }

}
