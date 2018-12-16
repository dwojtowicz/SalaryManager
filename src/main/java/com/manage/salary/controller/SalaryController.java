package com.manage.salary.controller;

import com.manage.salary.employee.Employee;
import com.manage.salary.employee.EmployeeService;
import com.manage.salary.salary.Salary;
import com.manage.salary.salary.SalaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@Controller
@RequestMapping("/salary")
public class SalaryController {



    private SalaryService salaryService;
    private EmployeeService employeeService;

    @Autowired
    public SalaryController(SalaryService salaryService, EmployeeService employeeService) {
        this.salaryService = salaryService;
        this.employeeService = employeeService;
    }


    @GetMapping("/employeeId/{employeeId}")
    public String employeeIdSalary(@PathVariable("employeeId") Long employeeId, Model theModel){


        Employee employee = employeeService.getEmployeeById(employeeId);
        List<Salary> salaries = employee.getSalary();
        theModel.addAttribute("salaries", salaries);

        return "salary-list";
    }

    @GetMapping("/addSalary/{employeeId]")
    public String addSalary(@PathVariable("employeeId") Long employeeId, Model theModel){



        theModel.addAttribute(new Salary());
        theModel.addAttribute("employees", employeeService.getEmployeeById(employeeId));
        return "add-salary";
    }

    @PostMapping("/saveSalary")
    public String saveSalary(@Valid @ModelAttribute Salary theSalary, BindingResult theBindingResult,
                             @PathVariable Long employeeId){

        if(theBindingResult.hasErrors()){
            return "redirect:/salary/addSalary";
        } else {

            int tax;
            Employee employee = employeeService.getEmployeeById(employeeId);
            theSalary.setEmployee(employee);

            if (employee.getPosition().toLowerCase().equals("manager")) {
                tax = 12;
            } else tax = 10;
            theSalary.setTax(tax);
            Double taxedMoney = theSalary.getGrossMonth() / theSalary.getTax();
            theSalary.setNetMonth(theSalary.getGrossMonth() - taxedMoney);
            salaryService.save(theSalary);
            return "redirect:/employee/";
        }

    }
}
