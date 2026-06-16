package com.example.demo.dto.responce;

import lombok.Data;

import java.util.List;

@Data
public class OrderInfoResponseDTO {
    private Long id;
    private String name;
    private double price;

    private List<ProductInfoResponseDTO> products;
}

