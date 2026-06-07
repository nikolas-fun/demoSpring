package com.example.demo.dto.request;

import lombok.Data;

@Data
public class PersonUpdateLoginAndPasswordRequestDTO {
    private Long id;

    private String nickName;
    private String password;
}
