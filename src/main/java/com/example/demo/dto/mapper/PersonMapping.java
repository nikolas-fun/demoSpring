package com.example.demo.dto.mapper;

import com.example.demo.dto.request.PersonCreateRequestDTO;
import com.example.demo.dto.request.UpdatePersonRequestDTO;
import com.example.demo.dto.responce.PersonDetailsResponseDTO;
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

    public static Person mapToUpdatePersonRequestDTO(Person person, UpdatePersonRequestDTO updatePersonRequestDTO) {
        person.setId(updatePersonRequestDTO.getId());
        person.setNickName(updatePersonRequestDTO.getLogin());
        person.setPassword(updatePersonRequestDTO.getPassword());

        return person;
    }

    public static Person mapToPerson(PersonCreateRequestDTO dto){

        Person person = new Person();
        person.setId(dto.getId());
        person.setAge(dto.getAge());
        person.setName(dto.getName());
        person.setNickName(dto.getNickName());
        person.setPassword(dto.getPassword());
        person.setEmail(dto.getEmail());

        return person;
    }
}
