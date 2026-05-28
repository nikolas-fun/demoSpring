package com.example.demo.service;

import com.example.demo.dto.mapper.PersonMapping;
import com.example.demo.dto.responce.PersonDetailsResponseDTO;
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


    public PersonDetailsResponseDTO findById(Long id){
       Person person = personRepository.findById(id).get();

        return PersonMapping.mapToPersonDetailsResponseDTO(person);
    }

    /*
    * Вызови метод findById в контроллере и измени шаблон
    * Создай метод для сохранения нового пользователя, чтобы на форме были все поля кроме даты создания
    * Создай метод который будет обновлять только такие данные как (имя, возраст)
    * Создай метод который будет изменять только логин и пароль без всех остальных полей *
    *
    * Для всех методов реализуй правильный функционал в контроллере и шаблонах
    *
    * По итогу, добавь новый функционал на стартовое меню с кнопочками
    * */

}
