package com.manage.salary.employee.detail;

public interface EmployeeDetailService {

    void save(EmployeeDetail employeeDetail);

    EmployeeDetail getEmployeeDetailById(Long employeeDetailId);
}
