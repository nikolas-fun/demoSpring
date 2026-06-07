package com.example.demo.dto.request;

import lombok.Data;

@Data
public class PersonUpdateNameAndAgeRequestDTO {
    private Long id;

    private String name;
    private Integer age;
}
