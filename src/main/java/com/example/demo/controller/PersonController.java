package com.example.demo.controller;

import com.example.demo.dto.request.PersonCreateRequestDTO;
import com.example.demo.dto.request.PersonUpdateLoginAndPasswordRequestDTO;
import com.example.demo.dto.request.PersonUpdateNameAndAgeRequestDTO;
import com.example.demo.dto.responce.PersonAgeResponseDTO;
import com.example.demo.dto.responce.PersonDetailsResponseDTO;
import com.example.demo.dto.responce.PersonUpdateNameAndAgeResponseDTO;
import com.example.demo.model.Order;
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

        model.addAttribute("person", personService.findById(id));

        return "/person/person-details";
    }

    @GetMapping("/get/age/{age}")
    public String findByAge(@RequestParam(required = false) Integer age, Model model) {

        model.addAttribute("person", personService.findByAge(age));

        return "/person/person-details-age";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("person", new PersonCreateRequestDTO());

        return "/person/registration";
    }

    @PostMapping("/save")
    public String saveToDB(@ModelAttribute PersonCreateRequestDTO dto, Model model) {
        try {
            personService.save(dto);

            return "redirect:/person/show-all";

        } catch (RuntimeException runtimeException) {
            model.addAttribute("error", runtimeException.getMessage());
        }

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
   /* @PostMapping("/editNameAndPage")
    public String editNameAndPage(@ModelAttribute Person person) {
        personService.updateNameAndAge(person);
        return "redirect:/person/show-all";
    }*/

  /*  @GetMapping("/person/{id}")
    public String updateNameAndAge(@PathVariable Long id, Model model) {
        PersonDetailsResponseDTO person = personService.findById(id);
        model.addAttribute("person", person);

        return "person/edit-name-and-age";
    }*/


    @GetMapping("/password-login/{id}")
    public String pagePasswordTo(@PathVariable Long id, Model model) {
        PersonUpdateLoginAndPasswordRequestDTO dto = new PersonUpdateLoginAndPasswordRequestDTO();
        dto.setId(id);

        model.addAttribute("dto", dto);

        return "/person/edit-password-login";
    }

    @PostMapping("/edit/password-login")
    public String editPasswordAndLogin(@ModelAttribute PersonUpdateLoginAndPasswordRequestDTO dto) {

        personService.updateLoginAndPassword(dto);

        return "redirect:/person/show-all";
    }

}