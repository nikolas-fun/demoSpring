package com.example.demo.dto.mapper;

import com.example.demo.dto.request.UpdateOrderRequestDTO;
import com.example.demo.dto.responce.UpdateOrderResponceDTO;
import com.example.demo.model.Order;

public class OrderMapping {

    public static Order mapToUpdateOrderRequestDTO(Order order, UpdateOrderRequestDTO updateOrderRequestDTO){

        order.setId(updateOrderRequestDTO.getId());
        order.setName(updateOrderRequestDTO.getName());
        order.setDeliveryAddress(updateOrderRequestDTO.getDeliveryAddress());

        return order;
    }

    public static UpdateOrderResponceDTO mapToUpdateOrderResponcetDTO(Order order){

        UpdateOrderResponceDTO dto = new UpdateOrderResponceDTO();
        dto.setId(order.getId());
        dto.setName(order.getName());
        dto.setDeliveryAddress(order.getDeliveryAddress());

        return dto;
    }
}
