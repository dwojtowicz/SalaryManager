package com.manage.salary.employee;

import com.manage.salary.employee.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    void saveEmployee(Employee theEmployee);


}
