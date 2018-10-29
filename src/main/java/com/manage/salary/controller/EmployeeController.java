package com.manage.salary.controller;


import com.manage.salary.entity.Employee;
import com.manage.salary.service.EmployeeService;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping
public class EmployeeController {



    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/menu")
    public String menu(Model theModel){

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

}
