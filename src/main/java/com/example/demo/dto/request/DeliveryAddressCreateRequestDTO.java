package com.example.demo.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryAddressCreateRequestDTO {

    private String country;
    private String city;
    private String street;
    private String houseNumber;

    private String comment;
}