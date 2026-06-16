package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String uniqueCode;
    private String deliveryAddress;

    @ManyToMany
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}

