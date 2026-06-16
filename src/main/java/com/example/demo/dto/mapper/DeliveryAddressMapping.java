package com.example.demo.dto.mapper;

import com.example.demo.dto.request.DeliveryAddressCreateRequestDTO;
import com.example.demo.model.DeliveryAddress;

public class DeliveryAddressMapping {

    public static DeliveryAddress mapToDeliveryAddress(DeliveryAddressCreateRequestDTO dto) {

        DeliveryAddress address = new DeliveryAddress();

        address.setCountry(dto.getCountry());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setHouseNumber(dto.getHouseNumber());
        address.setComment(dto.getComment());

        return address;
    }
}
