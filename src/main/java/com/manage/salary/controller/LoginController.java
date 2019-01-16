package com.manage.salary.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String loginPage() {

        return "login-page";
    }

    @GetMapping("loginError")
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        return "login-page";
    }


}
