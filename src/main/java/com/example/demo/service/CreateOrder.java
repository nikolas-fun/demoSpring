package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.model.Person;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class CreateOrder {

    private PersonService personService;
    private OrderService  orderService;
    private ProductService productService;


    @Autowired
    public CreateOrder(PersonService personService, OrderService orderService, ProductService productService) {
        this.personService = personService;
        this.orderService = orderService;
        this.productService = productService;
    }

    public void execute(Long personId, List<Long> productIds){

        Person person = personService.findPersonById(personId);

        List<Product> products = productService.findAllByIds(productIds);

        double totalPrice = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        String uniqueCode = new Random()
                .ints(8,1,101)
                .mapToObj(String:: valueOf)
                .reduce("",( a,b) -> (a+b));

        Order order = new Order();
        order.setUniqueCode(uniqueCode);
        order.setPrice(totalPrice);
        order.setProducts(products);
        order.setPerson(person);

        orderService.save(order);
    }
}
