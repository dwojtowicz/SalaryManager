package com.manage.salary.service;

import com.manage.salary.dao.EmployeeDao;
import com.manage.salary.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

   @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Override
    public void saveEmployee(Employee theEmployee) {
        employeeDao.saveEmployee(theEmployee);
    }


}
