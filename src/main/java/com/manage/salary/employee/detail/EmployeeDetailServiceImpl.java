package com.manage.salary.employee.detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeDetailServiceImpl implements EmployeeDetailService{

    private EmployeeDetailRepository employeeDetailRepository;

    @Autowired
    public EmployeeDetailServiceImpl(EmployeeDetailRepository employeeDetailRepository) {
        this.employeeDetailRepository = employeeDetailRepository;
    }

    @Override
    @Transactional
    public void save(EmployeeDetail employeeDetail) {
        employeeDetailRepository.save(employeeDetail);
    }

    @Override
    @Transactional
    public EmployeeDetail getEmployeeDetailById(Long employeeDetailId) {
        return employeeDetailRepository.findById(employeeDetailId).get();
    }


}
