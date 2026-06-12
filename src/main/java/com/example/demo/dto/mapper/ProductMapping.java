package com.example.demo.dto.mapper;

import com.example.demo.dto.responce.ProductResponseDTO;
import com.example.demo.model.Product;

public class ProductMapping {

    public static ProductResponseDTO mapToProductResponseDTO(Product product) {

        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setProductName(product.getName());
        dto.setIndex(product.getIndex());

        return dto;
    }
}
