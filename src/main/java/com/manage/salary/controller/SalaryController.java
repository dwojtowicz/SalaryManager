package com.manage.salary.controller;

import com.manage.salary.employee.Employee;
import com.manage.salary.employee.EmployeeService;
import com.manage.salary.salary.Salary;
import com.manage.salary.salary.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/salary")
public class SalaryController {

    private SalaryService salaryService;
    private EmployeeService employeeService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @Autowired
    public SalaryController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(name = "/{employeeId}")
    public String salary(@PathVariable(value = "employeeId") Long employeeId,  Model theModel){

        //theModel.addAttribute("salary", );

        return "salary-page";
    }

    @GetMapping(name = "/addSalary")
    public String addSalary(Model theModel){

        Salary salary = new Salary();

        theModel.addAttribute("salary", salary);
        theModel.addAttribute("employee", employeeService.getEmployees());
        return "add-salary";
    }

    @PostMapping(name = "/saveSalary")
    public String saveSalary(@ModelAttribute Salary newSalary, @RequestParam Long employeeId, Model theModel){

        Employee employee = employeeService.getEmployeeById(employeeId);
        newSalary.setEmployee(employee);
        employeeService.saveEmployee(employee);
        return "salary-list";
    }
}
