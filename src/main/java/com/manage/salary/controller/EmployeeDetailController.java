package com.manage.salary.controller;


import com.manage.salary.employee.Employee;
import com.manage.salary.employee.EmployeeService;
import com.manage.salary.employee.detail.EmployeeDetail;
import com.manage.salary.employee.detail.EmployeeDetailService;
import com.manage.salary.salary.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/detail")
public class EmployeeDetailController {


    EmployeeService employeeService;
    EmployeeDetailService employeeDetailService;


    @Autowired
    public EmployeeDetailController(EmployeeService employeeService, EmployeeDetailService employeeDetailService) {
        this.employeeService = employeeService;
        this.employeeDetailService = employeeDetailService;
    }


    @GetMapping("/{employeeId}")
    public String employeeDetail(@PathVariable("employeeId")Long employeeId, Model theModel){

        Employee theEmployee = employeeService.getEmployeeById(employeeId);
        EmployeeDetail employeeDetail = theEmployee.getEmployeeDetail();
        theModel.addAttribute("employeeDetails", employeeDetail);

        return "employee-detail";
    }

    @GetMapping("/addDetail")
    public String addDetail(Model theModel){

        EmployeeDetail employeeDetail = new EmployeeDetail();

        theModel.addAttribute(employeeDetail);

        theModel.addAttribute("employees", employeeService.getEmployees());

        return "add-detail";
    }

    @PostMapping("/saveDetail")
    public String saveDetail(@ModelAttribute EmployeeDetail employeeDetail,
                                @RequestParam Long employeeId){

        Employee employee = employeeService.getEmployeeById(employeeId);
        employee.setEmployeeDetail(employeeDetail);
        employeeDetailService.save(employeeDetail);

        return "redirect:/employee/";
    }

}
