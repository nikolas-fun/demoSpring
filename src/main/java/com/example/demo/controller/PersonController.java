package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {

    public PersonRepository personRepository;

    private PersonService personService;

    @Autowired
    public PersonController(PersonRepository personRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.personService = personService;
    }

    @GetMapping("/get/{id}")// http://localhost:8080/person/get/1
    public String findById(@PathVariable Integer id, Model model){
        Person person = personService.findById(id);
        model.addAttribute("person", person);

        return "/person/person-details";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("person", new Person());

        return "/person/registration";
    }

    @PostMapping("/save")
    public String saveToDB(@ModelAttribute Person person) {
        personRepository.save(person);

        return "redirect:/person/show-all";
    }

    @GetMapping("/show-all")
    public String getPerson(Model model) {


        model.addAttribute("persons", personRepository.findAll());

        return "details-person";
    }
}
