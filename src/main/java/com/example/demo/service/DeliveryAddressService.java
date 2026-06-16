package com.example.demo.service;

import com.example.demo.model.DeliveryAddress;
import com.example.demo.repository.DeliveryAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryAddressService {
    public DeliveryAddressRepository deliveryAddressRepository;

    @Autowired
    public DeliveryAddressService(DeliveryAddressRepository deliveryAddressRepository){
        this.deliveryAddressRepository = deliveryAddressRepository;
    }
}
