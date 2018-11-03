package com.manage.salary.employee;



import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getEmployees();

    void saveEmployee(Employee theEmployee);

    Employee getEmployeeById(Long theId);
}
