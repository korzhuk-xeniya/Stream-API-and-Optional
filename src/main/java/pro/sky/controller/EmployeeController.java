package pro.sky.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.dto.Employee;
import pro.sky.exceptions.EmployeeAlreadyAddedException;
import pro.sky.exceptions.EmployeeNotFoundException;
import pro.sky.exceptions.EmployeeStoragelsFullException;
import pro.sky.service.EmployeeService;

@RequestMapping(path = "/employee")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String outputEmployee() {
        return employeeService.outputEmployee();
    }


    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.addEmployee(employee);
        } catch (EmployeeStoragelsFullException | EmployeeAlreadyAddedException ex) {
            return (ex.getMessage());
        }
        return " Employee " + employee + " added ";
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.removeEmployee(employee);
        } catch (EmployeeNotFoundException ex) {
            return (ex.getMessage());
        }
        return " Employee" + employee + " removed ";
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.findEmployee(employee);
        } catch (EmployeeNotFoundException ex) {
            return (ex.getMessage());
        }
        return " Employee " + employee + "found ";
    }
}
