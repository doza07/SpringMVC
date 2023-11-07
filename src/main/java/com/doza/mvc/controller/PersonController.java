package com.doza.mvc.controller;

import com.doza.mvc.model.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class PersonController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${programmingLanguages}")
    private List<String> languages;
    @Value("${systems}")
    private List<String> systems;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @GetMapping("/showForm")
    public String showForm(Model model) {

        Person thePerson = new Person();

        model.addAttribute("person", thePerson);
//        model.addAttribute("countries", countries);
//        model.addAttribute("languages", languages);
//        model.addAttribute("systems", systems);

        return "person-show-form";
    }

    @PostMapping("/processPersonForm")
    public String processPersonForm(@Valid @ModelAttribute("person") Person person,
                                    BindingResult bindingResult) {

        System.out.println("Person : " + person.getFirstName() + " " + person.getLastName() + "!");
        System.out.println("Binding result: " + bindingResult.toString());
        System.out.println("\n\n\n\n");

        if(bindingResult.hasErrors()) {
          return "person-show-form";
        } else {
            return "person-confirmation";
        }
    }
}
