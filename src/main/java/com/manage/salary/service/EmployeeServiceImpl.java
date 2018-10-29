package com.manage.salary.service;

import com.manage.salary.dao.EmployeeDao;
import com.manage.salary.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

   @Autowired
    EmployeeDao employeeDao;

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }
}