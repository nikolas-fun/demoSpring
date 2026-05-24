package com.example.demo.dto.request;

import lombok.Data;

@Data
public class UpdateOrderRequestDTO {

    private Long id;
    private String name;
    private String deliveryAddress;

}
