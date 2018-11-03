package com.manage.salary.controller;

import com.manage.salary.employee.Employee;
import com.manage.salary.employee.EmployeeService;
import com.manage.salary.salary.Salary;
import com.manage.salary.salary.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/employeeId")
    public String SalaryList(Model theModel){

        theModel.addAttribute("salaries", salaryService.getSalaries());

        return "salary-list";
    }


    @GetMapping("/employeeId/{employeeId}")
    public String employeeIdSalary(@RequestParam Long employeeId, Model theModel){

        Employee employee = employeeService.getEmployeeById(employeeId);
        List<Salary> salaries = employee.getSalary();
        theModel.addAttribute("salaries", salaries);


        return "salary-list";
    }

    @GetMapping("/addSalary")
    public String addSalary(Model theModel){

        Salary salary = new Salary();

        theModel.addAttribute("salary", salary);
        theModel.addAttribute("employee", employeeService.getEmployees());
        return "add-salary";
    }

    @PostMapping("/saveSalary")
    public String saveSalary(@ModelAttribute Salary theSalary, @RequestParam Long employeeId){

        int tax = 10;
        theSalary.setTax(tax);
        Double taxedMoney = theSalary.getGrossMonth()/theSalary.getTax();
        theSalary.setNetMonth(theSalary.getGrossMonth() - taxedMoney);


        Employee employee = employeeService.getEmployeeById(employeeId);
        theSalary.setEmployee(employee);
        salaryService.save(theSalary);
        return "redirect:/salary/employeeId/{employeeId}";
    }
}
