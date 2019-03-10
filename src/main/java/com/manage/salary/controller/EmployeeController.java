package com.manage.salary.controller;


import com.manage.salary.employee.Employee;
import com.manage.salary.employee.EmployeeService;

import com.manage.salary.employee.detail.EmployeeDetail;
import com.manage.salary.salary.Salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
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
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee theEmployee, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "add-employee";
        } else {
        employeeService.saveOrUpdateEmployee(theEmployee);
        return "redirect:/employee/";}
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

        employeeService.saveOrUpdateEmployee(employee);

        theModel.addAttribute("employee", employee);

        return "add-employee";
    }

    @GetMapping("/user")
    public String user(){
        return "user";
    }

}
