package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.CalculationRepository;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public Person findById(Integer id){
        return personRepository.findById(id).get();
    }


}
