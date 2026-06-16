package com.example.demo.service;

import com.example.demo.dto.mapper.ProductMapping;
import com.example.demo.dto.responce.ProductInfoResponseDTO;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    public ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public ProductInfoResponseDTO findById (Long id) {
        Product product = productRepository.findById(id).get();

        return ProductMapping.mapToProductInfoResponseDTO(product);
    }

    public List<Product> findAllByIds(List<Long> ids){
        return productRepository.findBYIds(ids);
    }
}
