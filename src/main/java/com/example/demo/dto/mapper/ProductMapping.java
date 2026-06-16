package com.example.demo.dto.mapper;

import com.example.demo.dto.responce.OrderInfoResponseDTO;
import com.example.demo.dto.responce.PersonInfoResponseDTO;
import com.example.demo.dto.responce.ProductInfoResponseDTO;
import com.example.demo.dto.responce.ProductResponseDTO;
import com.example.demo.model.Product;

import java.util.List;

public class ProductMapping {

    public static ProductResponseDTO mapToProductResponseDTO(Product product) {

        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setProductName(product.getName());
        dto.setIndex(product.getIndex());

        return dto;
    }
    public static ProductInfoResponseDTO mapToProductInfoResponseDTO(Product product) {
        ProductInfoResponseDTO dto = new ProductInfoResponseDTO();
        dto.setName(product.getName());
        dto.setIndex(product.getIndex());

        return dto;
    }

}
