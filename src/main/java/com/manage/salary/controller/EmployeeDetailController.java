package com.manage.salary.controller;


import com.manage.salary.employee.Employee;
import com.manage.salary.employee.EmployeeService;
import com.manage.salary.employee.detail.EmployeeDetail;
import com.manage.salary.employee.detail.EmployeeDetailService;
import com.manage.salary.salary.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractAuditable_;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.validation.Valid;
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

        theModel.addAttribute("employeeDetails", theEmployee.getEmployeeDetail());
        if(theEmployee.getEmployeeDetail() != null){
            return "employee-detail";
        } else {
            return "redirect:/detail/addDetail/{employeeId}";
        }

    }

    @GetMapping("/addDetail/{employeeId}")
    public String addDetail(@PathVariable("employeeId") Long employeeId, Model theModel){
        EmployeeDetail theEmployeeDetail = new EmployeeDetail();
        theModel.addAttribute(theEmployeeDetail);
        theModel.addAttribute("employees", employeeService.getEmployeeById(employeeId));
        return "add-detail";
    }


    @GetMapping("/updateDetail/{employeeDetailId}")
    public String updateEmployeeDetail(@PathVariable("employeeDetailId") Long employeeDetailId, Model theModel){

        EmployeeDetail employeeDetail = employeeDetailService.getEmployeeDetailById(employeeDetailId);

        employeeDetailService.saveOrUpdateEmployeeDetail(employeeDetail);

        theModel.addAttribute("employeeDetail", employeeDetail);

        return "update-detail";
    }


    @PostMapping("/updateDetail/{employeeDetailId}")
    public String updateDetail(@Valid @ModelAttribute EmployeeDetail employeeDetail, BindingResult theBindingResult,
                               @PathVariable("employeeDetailId") Long employeeDetailId){

        if (theBindingResult.hasErrors()){
            return "update-detail";
        } else {
            employeeDetailService.saveOrUpdateEmployeeDetail(employeeDetail);
        }


        return "redirect:/employee/";
    }

    @PostMapping("/saveDetail/{employeeId}")
    public String saveDetail(@Valid @ModelAttribute EmployeeDetail employeeDetail, BindingResult theBindingResult,
                                @PathVariable("employeeId") Long employeeId){

        if (theBindingResult.hasErrors()){
            return "add-detail";
        }   else {
            Employee employee = employeeService.getEmployeeById(employeeId);
            employee.setEmployeeDetail(employeeDetail);
            employeeDetailService.saveOrUpdateEmployeeDetail(employeeDetail);

            return "redirect:/employee/";
        }
    }

}
