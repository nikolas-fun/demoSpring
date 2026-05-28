package com.example.demo.dto.responce;

import lombok.Data;

@Data
public class UpdateOrderResponseDTO {

    private Long id;
    private String name;
    private String deliveryAddress;
}
