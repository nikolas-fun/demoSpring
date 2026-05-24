package com.example.demo.repository;

import com.example.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    // SELECT o FROM order WHERE name = name
    // find --- select
    /* Order --- from
        ByName --- WHERE name = name
    * */



    Order findOrderByName(String name);

    @Query("SELECT o FROM Order o WHERE o.price > 100")
    List<Order> findExpensiveOrder(double price);

    long countByDeliveryAddress(String deliveryAddress);

  //  String findOrderByDeliveryAddress(String deliveryAddress);

    Order findOrderByDeliveryAddressOrPrice(String deliveryAddress, double price);

    Order deleteOrderByUniqueCode(String uniqueCode);
/*
    Order findOrdersByDeliveryAddress(String deliveryAddress);
*/
/*
@Query("SELECT o.price, o.deliveryAddress FROM Order o WHERE o.price > 100, o.deliveryAddress ON o.price = o.deliveryAddress")
    List<Order> findOrder(double price, String deliveryAddress);*/





}
