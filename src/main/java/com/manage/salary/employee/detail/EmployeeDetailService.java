package com.manage.salary.employee.detail;

public interface EmployeeDetailService {

    void saveOrUpdateEmployeeDetail(EmployeeDetail employeeDetail);

    EmployeeDetail getEmployeeDetailById(Long employeeDetailId);
}
