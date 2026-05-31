package com.example.demo.dto.request;

import lombok.Data;

@Data
public class UpdatePersonRequestDTO {
    private Long id;

    private String password;
    private String login;
}
