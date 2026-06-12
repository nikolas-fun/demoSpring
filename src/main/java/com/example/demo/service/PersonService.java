package com.example.demo.service;

import com.example.demo.dto.mapper.PersonMapping;
import com.example.demo.dto.request.PersonCreateRequestDTO;
import com.example.demo.dto.request.PersonUpdateLoginAndPasswordRequestDTO;
import com.example.demo.dto.request.PersonUpdateNameAndAgeRequestDTO;
import com.example.demo.dto.request.UpdatePersonRequestDTO;
import com.example.demo.dto.responce.PersonAgeResponseDTO;
import com.example.demo.dto.responce.PersonDetailsResponseDTO;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.dto.mapper.PersonMapping.mapToUpdateLoginAndPassword;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonAgeResponseDTO findByAge(int age){
        Person person = personRepository.findPersonByAge(age);

        return PersonMapping.mapToPersonAgeResponseDTO(person);
    }

    public PersonDetailsResponseDTO findById(Long id) {
        Person person = personRepository.findById(id).get();

        return PersonMapping.mapToPersonDetailsResponseDTO(person);
    }

    public void save(PersonCreateRequestDTO dto) {
        Person person = PersonMapping.mapToPerson(dto);

        if (personRepository.existsPersonByEmail(dto.getEmail())) {
            throw new RuntimeException("User with this email already exists");
        }
        else {
        personRepository.save(person);}
    }
    // сделай проверку существует ли пользователь с мылом в базе данных,
    // если нет то пропускай на регистрацию если нет отображай исключение на странице

    /*
     * Вызови метод findById в контроллере и измени шаблон
     * Создай метод для сохранения нового пользователя, чтобы на форме были все поля кроме даты создания
     * Создай метод который будет обновлять только такие данные как (имя, возраст)
     * Создай метод который будет изменять только логин и пароль без всех остальных полей *
     *
     * Для всех методов реализуй правильный функционал в контроллере и шаблонах
     *

	*/
    public void updateLoginAndPassword(PersonUpdateLoginAndPasswordRequestDTO dto) {
        Person updatePerson = personRepository.findById(dto.getId()).get();

        String oldPassword = updatePerson.getPassword();
        String newPassword = dto.getPassword();

        if(personRepository.existsPersonByNickName(dto.getNickName())){
            throw new RuntimeException("Nick already exists");
        }
        else if(oldPassword.equals(newPassword)){
            throw new RuntimeException("New password must be different from old password");
        }

        else{
            personRepository.save(mapToUpdateLoginAndPassword(updatePerson,dto));
        }
    }// передай правильно на фронтенд исключения через модель

   /* public Person updateNameAndAge(PersonUpdateNameAndAgeRequestDTO dto) {
        Person updatePerson = personRepository.findById(dto.getId()).get();



*/
}
