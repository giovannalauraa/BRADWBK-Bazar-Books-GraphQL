package com.bazar.bazarbooks.service;

import com.bazar.bazarbooks.dto.AddressInput;
import com.bazar.bazarbooks.model.Address;
import com.bazar.bazarbooks.model.User;
import com.bazar.bazarbooks.repository.AddressRepository;
import com.bazar.bazarbooks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(int id) {
        return addressRepository.findById(id).orElse(null);
    }

    public List<Address> getAddressesByUserId(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário com ID " + userId + " não encontrado"));
        return addressRepository.findByUser(user);
    }

    public Address createAddress(AddressInput addressInput) {
        User user = userRepository.findById(addressInput.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário com ID " + addressInput.getUserId() + " não encontrado"));

        Address address = new Address();
        address.setStreet(addressInput.getStreet());
        address.setNumber(addressInput.getNumber());
        address.setComplement(addressInput.getComplement());
        address.setDistrict(addressInput.getDistrict());
        address.setCity(addressInput.getCity());
        address.setState(addressInput.getState());
        address.setPostalCode(addressInput.getPostalCode());
        address.setLatitude(addressInput.getLatitude());
        address.setLongitude(addressInput.getLongitude());
        address.setUser(user);
        return addressRepository.save(address);
    }

    public Address updateAddress(int id, AddressInput addressInput) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            User user = userRepository.findById(addressInput.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("Usuário com ID " + addressInput.getUserId() + " não encontrado"));

            address.setStreet(addressInput.getStreet());
            address.setNumber(addressInput.getNumber());
            address.setComplement(addressInput.getComplement());
            address.setDistrict(addressInput.getDistrict());
            address.setCity(addressInput.getCity());
            address.setState(addressInput.getState());
            address.setPostalCode(addressInput.getPostalCode());
            address.setLatitude(addressInput.getLatitude());
            address.setLongitude(addressInput.getLongitude());
            address.setUser(user); 
            return addressRepository.save(address);
        }
        return null;
    }

    public boolean deleteAddress(int id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return true;
        }
        return false;
    }
}