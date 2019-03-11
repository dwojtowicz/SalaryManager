package com.manage.salary.employee;



import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getEmployees();

    void saveOrUpdateEmployee(Employee theEmployee);

    Employee getEmployeeById(Long theId);

    void deleteEmployee(Long employeeId);


}
