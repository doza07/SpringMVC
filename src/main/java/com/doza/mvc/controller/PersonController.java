package com.doza.mvc.controller;

import com.doza.mvc.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class PersonController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${programmingLanguages}")
    private List<String> languages;


    @GetMapping("/showForm")
    public String showForm(Model model) {

        Person thePerson = new Person();

        model.addAttribute("person", thePerson);
        model.addAttribute("countries", countries);
        model.addAttribute("languages", languages);

        return "person-show-form";
    }

    @PostMapping("/processPersonForm")
    public String processPersonForm(@ModelAttribute("person") Person person) {

        System.out.println("Person : " + person.getFirstName() + " " + person.getLastName() + "!");

        return "person-confirmation";
    }
}
