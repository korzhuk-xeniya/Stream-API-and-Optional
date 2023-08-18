package pro.sky.service;


import pro.sky.dto.Employee;

public interface EmployeeService {
        void addEmployee(Employee employee);

        void removeEmployee(Employee employee);

        void findEmployee(Employee employee);

        String outputEmployee();
    }

