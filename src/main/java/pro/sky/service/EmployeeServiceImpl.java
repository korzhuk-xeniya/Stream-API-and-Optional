package pro.sky.service;

import org.springframework.stereotype.Service;
import pro.sky.dto.Employee;
import pro.sky.exceptions.EmployeeAlreadyAddedException;
import pro.sky.exceptions.EmployeeNotFoundException;
import pro.sky.exceptions.EmployeeStoragelsFullException;

import java.util.HashMap;
import java.util.Map;


@Service


    public class EmployeeServiceImpl implements EmployeeService {

        private Map<String, Employee> employees;

        private static final int MAX_NUMBER_OF_EMPLOYEE = 11;

        public String EmployeeServiceImpl() {
            this.employees = new HashMap<>();

//            @Override
//            public void addEmployee (String firstName, String lastName){
//                Employee employee = new Employee(firstName, lastName);
////
////                if (MAX_NUMBER_OF_EMPLOYEE == employees.size()) {
////                    throw new EmployeeStoragelsFullException();
////                }
////
////                if (employees.containsKey(employee.getFullName())) {
////                    throw new EmployeeAlreadyAddedException();
////                }
////                employees.put(employee.getFullName(), employee);
//            }
//
//            @Override
//            public void removeEmployee (String firstName, String lastName){
//                Employee employee = new Employee(firstName, lastName);
////                if (!employees.containsKey(employee.getFullName())) {
////                    throw new EmployeeNotFoundException();
////                }
////                employees.remove(employee.getFullName());
//            }
//
//            @Override
//            public void findEmployee (String firstName, String lastName){
//                Employee employee = new Employee(firstName, lastName);
//
////                if (!employees.containsKey(employee.getFullName())) {
////                    throw new EmployeeNotFoundException();
////                }
////                employees.get(employee.getFullName());
//            }
//            @Override
//            public String outputEmployee () {
////                return employees.toString();
//            }


    @Override
    public void addEmployee(Employee employee) {

        if (MAX_NUMBER_OF_EMPLOYEE == employees.size()) {
            throw new EmployeeStoragelsFullException();
        }

        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);

    }

    @Override
    public void removeEmployee(Employee employee) {
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getFullName());
    }

    @Override
    public void findEmployee(Employee employee) {
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        employees.get(employee.getFullName());
    }

    @Override
    public String outputEmployee() {
        return  employees.toString();
    }
}

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public void removeEmployee(Employee employee) {

    }

    @Override
    public void findEmployee(Employee employee) {

    }

    @Override
    public String outputEmployee() {
        return null;
    }
}
