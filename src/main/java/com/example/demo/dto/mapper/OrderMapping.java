package com.example.demo.dto.mapper;

import com.example.demo.dto.request.UpdateOrderRequestDTO;
import com.example.demo.dto.responce.OrdersResponseDTO;
import com.example.demo.dto.responce.UpdateOrderResponseDTO;
import com.example.demo.model.Order;

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


}
