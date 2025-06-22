package com.bazar.bazarbooks.repository;

import com.bazar.bazarbooks.model.Address;
import com.bazar.bazarbooks.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByUser(User user);
    Optional<Address> findByIdAddressAndUser(Integer idAddress, User user);
}