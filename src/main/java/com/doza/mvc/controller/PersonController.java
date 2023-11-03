package com.doza.mvc.controller;

import com.doza.mvc.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PersonController {


    @GetMapping("/showForm")
    public String showForm(Model model) {

        Person thePerson = new Person();

        model.addAttribute("person", thePerson);

        return "person-show-form";
    }

    @PostMapping("/processPersonForm")
    public String processPersonForm(@ModelAttribute("person") Person person) {

        System.out.println("Person : " + person.getFirstName() + " " + person.getLastName() + "!");

        return "person-confirmation";
    }
}
