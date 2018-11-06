package com.manage.salary.controller;


import com.manage.salary.employee.EmployeeService;
import com.manage.salary.employee.detail.EmployeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


public class EmployeeDetailController {


    EmployeeService employeeService;
    EmployeeDetailService employeeDetailService;


    public EmployeeDetailController(EmployeeService employeeService, EmployeeDetailService employeeDetailService) {
        this.employeeService = employeeService;
        this.employeeDetailService = employeeDetailService;
    }


 /*   @GetMapping("/")*/

}
