package com.bazar.bazarbooks.controller;

import com.bazar.bazarbooks.dto.AddressInput;
import com.bazar.bazarbooks.model.Address;
import com.bazar.bazarbooks.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    @QueryMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @QueryMapping
    public Address getAddressById(@Argument int id) {
        return addressService.getAddressById(id);
    }

    @QueryMapping
    public List<Address> getAddressesByUserId(@Argument int userId) {
        return addressService.getAddressesByUserId(userId);
    }

    @MutationMapping
    public Address createAddress(@Argument AddressInput addressInput) {
        return addressService.createAddress(addressInput);
    }

    @MutationMapping
    public Address updateAddress(@Argument int id, @Argument AddressInput addressInput) {
        return addressService.updateAddress(id, addressInput);
    }

    @MutationMapping
    public String deleteAddress(@Argument int id) {
        boolean deleted = addressService.deleteAddress(id);
        return deleted ? "Endereço apagado com sucesso!" : "Endereço não encontrado.";
    }
}