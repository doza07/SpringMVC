package com.doza.mvc.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/hello")
    public String showForm() {
        return "hello-form";
    }

    @GetMapping("/home")
    public String demo(@RequestParam("name") String theName,
                       Model model) {

        theName = theName.toUpperCase();
        String result = "Yo! " + theName;

        model.addAttribute("theDate", new Date());
        model.addAttribute("message", result);
        return "home";
    }


}
