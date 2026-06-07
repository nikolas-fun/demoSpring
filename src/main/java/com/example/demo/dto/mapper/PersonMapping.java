package com.example.demo.dto.mapper;

import com.example.demo.dto.request.PersonCreateRequestDTO;
import com.example.demo.dto.request.PersonUpdateLoginAndPasswordRequestDTO;
import com.example.demo.dto.request.PersonUpdateNameAndAgeRequestDTO;
import com.example.demo.dto.request.UpdatePersonRequestDTO;
import com.example.demo.dto.responce.PersonAgeResponseDTO;
import com.example.demo.dto.responce.PersonDetailsResponseDTO;
import com.example.demo.dto.responce.PersonUpdateLoginAndPasswordResponseDTO;
import com.example.demo.dto.responce.PersonUpdateNameAndAgeResponseDTO;
import com.example.demo.model.Person;

public class PersonMapping {
    public static PersonDetailsResponseDTO mapToPersonDetailsResponseDTO(Person person) {
        PersonDetailsResponseDTO dto = new PersonDetailsResponseDTO();
        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setNickName(person.getNickName());
        dto.setAge(person.getAge());

        return dto;
    }

    public static PersonAgeResponseDTO mapToPersonAgeResponseDTO(Person person) {
        PersonAgeResponseDTO dto = new PersonAgeResponseDTO();
        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setNickName(dto.getNickName());

        return dto;
    }

    public static Person mapToUpdatePersonRequestDTO(Person person,
                                                     UpdatePersonRequestDTO updatePersonRequestDTO) {
        person.setId(updatePersonRequestDTO.getId());
        person.setNickName(updatePersonRequestDTO.getNickName());
        person.setPassword(updatePersonRequestDTO.getPassword());

        return person;
    }

    public static Person mapToPerson(PersonCreateRequestDTO dto) {

        Person person = new Person();
        person.setId(dto.getId());
        person.setAge(dto.getAge());
        person.setName(dto.getName());
        person.setNickName(dto.getNickName());
        person.setPassword(dto.getPassword());
        person.setEmail(dto.getEmail());

        return person;
    }

    public static PersonUpdateNameAndAgeResponseDTO
    mapToPersonUpdateNameAndAgeResponseDTO(Person person) {

        PersonUpdateNameAndAgeResponseDTO dto =
                new PersonUpdateNameAndAgeResponseDTO();

        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setAge(person.getAge());

        return dto;
    }

    public static Person mapToUpdateNameAndAge(Person person,
                                               PersonUpdateNameAndAgeRequestDTO dto) {

        person.setName(dto.getName());
        person.setAge(dto.getAge());

        return person;
    }

    public static PersonUpdateLoginAndPasswordResponseDTO
    mapToPersonUpdateLoginAndPasswordResponseDTO(Person person) {

        PersonUpdateLoginAndPasswordResponseDTO dto =
                new PersonUpdateLoginAndPasswordResponseDTO();

        dto.setId(person.getId());
        dto.setNickName(person.getNickName());

        return dto;
    }

    public static Person mapToUpdateLoginAndPassword(Person person,
                                                     PersonUpdateLoginAndPasswordRequestDTO dto
    ) {

        person.setId(dto.getId());
        person.setNickName(dto.getNickName());
        person.setPassword(dto.getPassword());

        return person;
    }
}
