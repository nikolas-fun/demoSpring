package com.example.demo.service;

import com.example.demo.dto.mapper.PersonMapping;
import com.example.demo.dto.request.PersonCreateRequestDTO;
import com.example.demo.dto.request.UpdatePersonRequestDTO;
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


    public PersonDetailsResponseDTO findById(Long id) {
        Person person = personRepository.findById(id).get();

        return PersonMapping.mapToPersonDetailsResponseDTO(person);
    }

    public void save(PersonCreateRequestDTO dto) {
        Person person = PersonMapping.mapToPerson(dto);

        personRepository.save(person);
    }

    /*
     * Вызови метод findById в контроллере и измени шаблон
     * Создай метод для сохранения нового пользователя, чтобы на форме были все поля кроме даты создания
     * Создай метод который будет обновлять только такие данные как (имя, возраст)
     * Создай метод который будет изменять только логин и пароль без всех остальных полей *
     *
     * Для всех методов реализуй правильный функционал в контроллере и шаблонах
     *
     *
     * По итогу, добавь новый функционал на стартовое меню с кнопочками
     * 1. Работа с DTO

	1.1 Создай кастомный метод который будет искать пользователей по возрасту
	1.2 Для этого метода создай дто в которой будет три поля (id,name, nickName)
	1.3 Сделай правильный маппинг для этой дто
	1.4 Вызови метод в сервисе и в контроллере и не забудь про шаблон

	1.5 Создай новую сущность Product с полями (id, name, price, count, index)
	1.6 Создай базовый репозиторий для сущности Product и сервисный класс, а также контроллер
	*/
    public void updateLoginAndPassword(UpdatePersonRequestDTO dto) {
        Person updatePerson = personRepository.findById(dto.getId()).get();
        PersonMapping.mapToUpdatePersonRequestDTO(updatePerson, dto);
        personRepository.save(updatePerson);
    }

    public Person updateNameAndAge(Person person) {

        Person updatePerson = personRepository.findById(person.getId()).get();

        updatePerson.setName(person.getName());
        updatePerson.setAge(person.getAge());

        return personRepository.save(person);
    }
}
