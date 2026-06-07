package com.example.demo.dto.responce;

import lombok.Data;

@Data
public class PersonUpdateNameAndAgeResponseDTO {
    private Long id;

    private String name;
    private int age;
}
