package com.example.demo.dto.mapper;

import com.example.demo.dto.request.UpdateOrderRequestDTO;
import com.example.demo.dto.responce.*;
import com.example.demo.model.Order;
import com.example.demo.model.Product;

import java.util.List;

public class OrderMapping {

    public static Order mapToUpdateOrderRequestDTO(Order order, UpdateOrderRequestDTO updateOrderRequestDTO){

        order.setId(updateOrderRequestDTO.getId());
        order.setName(updateOrderRequestDTO.getName());
        order.setDeliveryAddress(updateOrderRequestDTO.getDeliveryAddress());

        return order;
    }

    public static UpdateOrderResponseDTO mapToUpdateOrderResponcetDTO(Order order){

        UpdateOrderResponseDTO dto = new UpdateOrderResponseDTO();
        dto.setId(order.getId());
        dto.setName(order.getName());
        dto.setDeliveryAddress(order.getDeliveryAddress());

        return dto;
    }
    public  static OrdersResponseDTO mapToOrdersResponseDTO(Order order){
        OrdersResponseDTO dto = new OrdersResponseDTO();
        dto.setId(order.getId());
        dto.setName(order.getName());
        dto.setPrice(order.getPrice());

        return dto;
    }

    public  static OrderDetailsResponseDTO mapToOrderDetailsResponseDTO(Order order){
        OrderDetailsResponseDTO dto = new OrderDetailsResponseDTO();
        dto.setId(order.getId());
        dto.setName(order.getName());
        dto.setPrice(order.getPrice());
        dto.setUniqueCode(order.getUniqueCode());
        dto.setDeliveryAddress(order.getDeliveryAddress());

        List<ProductResponseDTO> dtoProducts = order.getProducts()
                .stream()
                .map(ProductMapping::mapToProductResponseDTO)
                .toList();

        dto.setProductDto(dtoProducts);

        return dto;
    }

    public  static OrderInfoResponseDTO mapToOrderInfoResponseDTO(Order order){
        OrderInfoResponseDTO dto = new OrderInfoResponseDTO();
        dto.setId(order.getId());
        dto.setName(order.getName());
        dto.setPrice(order.getPrice());

        List<ProductInfoResponseDTO> dtoProducts = order.getProducts()
                .stream()
                .map(ProductMapping::mapToProductInfoResponseDTO)
                .toList();

        dto.setProducts(dtoProducts);

        return dto;
    }



}
