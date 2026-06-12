package com.example.demo.dto.responce;

import lombok.Data;

import java.util.List;

@Data
public class OrderDetailsResponseDTO {

    private Long id;
    private String name;
    private double price;
    private String uniqueCode;
    private String deliveryAddress;

    private List<ProductResponseDTO> productDto;


}
