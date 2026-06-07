package com.example.demo.dto.responce;

import lombok.Data;

@Data
public class OrderDetailsResponseDTO {

    private Long id;
    private String name;
    private double price;
    private String uniqueCode;
    private String deliveryAddress;

    private String productName;
    private String index;

}
