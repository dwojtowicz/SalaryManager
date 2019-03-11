package com.manage.salary.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {



    @GetMapping("/loginPage")
    public String loginPage() {

        return "login-page";
    }

    @GetMapping("/loginError")
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        return "login-page";
    }


    @GetMapping("/access-denied")
    public String accessDenied(){

        return "access-denied";
    }


}
