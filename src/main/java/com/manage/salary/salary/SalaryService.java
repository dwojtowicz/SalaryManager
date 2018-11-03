package com.manage.salary.salary;


import java.util.List;

public interface SalaryService {

    void save(Salary theSalary);

    List<Salary> getSalaries();
}
