package com.example.demo.service;

import com.example.demo.dto.mapper.OrderMapping;
import com.example.demo.dto.request.UpdateOrderRequestDTO;
import com.example.demo.dto.responce.UpdateOrderResponseDTO;
import com.example.demo.dto.responce.OrdersResponseDTO;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findById(Long id){
        return orderRepository.findById(id).get();
    }

    public  List<OrdersResponseDTO> findAll(){
        return orderRepository.findAll()
                .stream()
                .map(OrderMapping::mapToOrdersResponseDTO)
                .toList();
    }
    public  Order findByName(String name){
        return orderRepository.findOrderByName(name);
    }
    public List<Order> findByPrice(double price){
        return orderRepository.findExpensiveOrder(price);
    }
    public long countByDeliveryAddress(String deliveryAddress){
        return orderRepository.countByDeliveryAddress(deliveryAddress);
    }
    public Order findOrderByDeliveryAddressOrPrice(String deliveryAddress, double price){
        return orderRepository.findOrderByDeliveryAddressOrPrice(deliveryAddress,price);
    }
    public void save(Order order) {
        orderRepository.save(order);
    }

    public void deleteById(Long id){
        orderRepository.deleteById(id);
    }

    public void deleteOrderByUniqueCode (String uniqueCode){
        orderRepository.deleteOrderByUniqueCode(uniqueCode);
    }

    public UpdateOrderResponseDTO findForUpdate(Long id){
        Order order = orderRepository.findById(id).get();

       return OrderMapping.mapToUpdateOrderResponcetDTO(order);

    }


    public void update(UpdateOrderRequestDTO dto){
        Order updatedOrder = orderRepository.findById(dto.getId()).get();

        OrderMapping.mapToUpdateOrderRequestDTO(updatedOrder,dto);

        orderRepository.save(updatedOrder);
    }
    public void updateNameAndPrice(Order order){
        Order updareOrder = orderRepository.findById(order.getId()).get();
        updareOrder.setName(order.getName());
        updareOrder.setPrice(order.getPrice());

        orderRepository.save(updareOrder);

    }

}
