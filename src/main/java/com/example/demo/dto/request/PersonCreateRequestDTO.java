package com.example.demo.dto.request;

import lombok.Data;

@Data
public class PersonCreateRequestDTO {

    private Long id;

    private String name;
    private int age;
    private String password;
    private String nickName;
    private String email;

    private DeliveryAddressCreateRequestDTO deliveryAddressCreateRequestDTO;
}
