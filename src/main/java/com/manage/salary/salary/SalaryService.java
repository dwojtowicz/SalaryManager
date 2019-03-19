package com.manage.salary.salary;


import com.manage.salary.employee.Employee;

import java.util.List;

public interface SalaryService {

    void save(Salary theSalary);

    List<Salary> getSalaries();

    Salary calculateNet(Salary salary, Employee employee);

    Double netTotal(Employee employee);

    void deleteSalary(Long salaryId);
}
