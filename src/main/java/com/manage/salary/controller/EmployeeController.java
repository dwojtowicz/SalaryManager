package com.manage.salary.controller;


import com.manage.salary.employee.Employee;
import com.manage.salary.employee.EmployeeService;

import com.manage.salary.employee.detail.EmployeeDetail;
import com.manage.salary.salary.Salary;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import java.util.List;


@Controller
@RequestMapping("/employee")
public class EmployeeController {




    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String employees(Model theModel){

        List<Employee> employees = employeeService.getEmployees();

        theModel.addAttribute("employees", employees);
        return "employees-list";
    }


    @GetMapping("/addEmployee")
    public String addEmployee(Model theModel){

        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "add-employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        employeeService.saveEmployee(theEmployee);


        return "redirect:/employee/";
    }

    @GetMapping("/deleteEmployeeForm")
    public String deleteEmployeeForm(Model theModel){

        theModel.addAttribute("employees", employeeService.getEmployees());

        return "delete-employee";
    }


    @PostMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") Long employeeId){

        employeeService.deleteEmployee(employeeId);

        return "redirect:/employee/";
    }

    @GetMapping("/updateEmployee/{employeeId}")
    public String updateEmployee(@PathVariable("employeeId") Long employeeId, Model theModel){

        Employee employee = employeeService.getEmployeeById(employeeId);
        List<Salary> salary = employeeService.getEmployeeById(employeeId).getSalary();
        EmployeeDetail employeeDetail = employeeService.getEmployeeById(employeeId).getEmployeeDetail();
        employee.setSalary(salary);
        employee.setEmployeeDetail(employeeDetail);


        theModel.addAttribute("employee", employee);



        return "add-employee";
    }


}
