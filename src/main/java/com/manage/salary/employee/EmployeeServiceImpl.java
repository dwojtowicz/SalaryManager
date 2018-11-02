package com.manage.salary.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class EmployeeServiceImpl implements EmployeeService {

   @Autowired
   EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }


}
