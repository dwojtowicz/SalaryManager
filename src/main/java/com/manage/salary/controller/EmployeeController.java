package com.manage.salary.controller;


import com.manage.salary.employee.Employee;
import com.manage.salary.employee.EmployeeService;
import com.manage.salary.salary.Salary;
import com.manage.salary.salary.SalaryService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class EmployeeController {




    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public String employees(Model theModel){

        List<Employee> employees = employeeService.getEmployees();


        theModel.addAttribute("employees", employees);
        return "employees-list";
    }

    @GetMapping ("employees/{id}")
    public String employeesById(@PathVariable(value = "id") Long employeeId){

        Employee employee = employeeService.getEmployeeById(employeeId);

        return "employees-list";
    }

    @GetMapping("addEmployee")
    public String addEmployee(Model theModel){

        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "add-employee";
    }

    @PostMapping("saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        employeeService.saveEmployee(theEmployee);


        return "redirect:/employees";
    }


}
