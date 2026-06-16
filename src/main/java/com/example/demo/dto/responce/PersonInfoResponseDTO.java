package com.example.demo.dto.responce;

import lombok.Data;

import java.util.List;

@Data
public class PersonInfoResponseDTO {
    private Long id;
    private String name;
    private String nickName;
    private int age;

    private List<OrderInfoResponseDTO> orders;
}
