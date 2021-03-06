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


    @GetMapping("/{employeeId}")
    public String employeeIdSalary(@PathVariable("employeeId") Long employeeId, Model theModel){

        Employee employee = employeeService.getEmployeeById(employeeId);
        List<Salary> salaries = employee.getSalary();
        employee.setTotalNet(salaryService.netTotal(employee));

        theModel.addAttribute("salaries", salaries);
        theModel.addAttribute("employee", employee);

        return "salary-list";
        }

    @GetMapping("/addSalary/{employeeId}")
    public String addSalary(@PathVariable("employeeId") Long employeeId, Model theModel){



        theModel.addAttribute(new Salary());
        theModel.addAttribute("employees", employeeService.getEmployeeById(employeeId));
        return "add-salary";
        }

    @PostMapping("/saveSalary/{employeeId}")
    public String saveSalary(@Valid @ModelAttribute("salary") Salary salary, BindingResult bindingResult, @PathVariable("employeeId") Long employeeId){

        if (bindingResult.hasErrors()){
            return "add-salary";
        } else {
            Employee employee = employeeService.getEmployeeById(employeeId);
            salaryService.calculateNet(salary, employee);
            salaryService.save(salary);
            return "redirect:/salary/{employeeId}";
        }
        }

    @GetMapping("/{employeeId}/deleteSalary/{salaryId}")
    public String deleteEmployee(@PathVariable("salaryId") Long salaryId, @PathVariable("employeeId") Long employeeId){
        salaryService.deleteSalary(salaryId);

        return "redirect:/salary/{employeeId}";
        }

    }

