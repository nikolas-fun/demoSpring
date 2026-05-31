package com.example.demo.controller;

import com.example.demo.dto.request.PersonCreateRequestDTO;
import com.example.demo.dto.responce.PersonDetailsResponseDTO;
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
    public String findById(@PathVariable Long id, Model model) {

        PersonDetailsResponseDTO dto = personService.findById(id);

        model.addAttribute("person", dto);

        return "/person/person-details";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("person", new PersonCreateRequestDTO());

        return "/person/registration";
    }

    @PostMapping("/save")
    public String saveToDB(@ModelAttribute PersonCreateRequestDTO dto) {
        personService.save(dto);

        return "redirect:/person/show-all";
    }

    @GetMapping("/show-all")
    public String getPerson(Model model) {


        model.addAttribute("persons", personRepository.findAll());

        return "/person/details-person";
    }

   /* @GetMapping("/edit")
    public String editLoginAndPassword(@PathVariable Model model) {

    }
    @GetMapping("/edit/{id}")
    public String editPerson(@PathVariable Long id, Model model) {
        Person person = personService.findById(id);
        model.addAttribute("person", person);

        return "/person/edit";
    }*/
    @PostMapping("/editNameAndPage")
    public String editNameAndPage(@ModelAttribute Person person) {
        personService.updateNameAndAge(person);
        return "redirect:/person/show-all";
    }
}
