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
    public void saveOrUpdateEmployeeDetail(EmployeeDetail employeeDetail) {

        if (employeeDetail.getId() != null){
            EmployeeDetail empDtl = employeeDetailRepository.getOne(employeeDetail.getId());
            empDtl.setCity(employeeDetail.getCity());
            empDtl.setStreet(employeeDetail.getStreet());
            employeeDetailRepository.save(empDtl);
        } else {
            employeeDetailRepository.save(employeeDetail);
        }
    }

    @Override
    @Transactional
    public EmployeeDetail getEmployeeDetailById(Long employeeDetailId) {
        return employeeDetailRepository.findById(employeeDetailId).orElse(null);
    }


}
