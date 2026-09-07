package com.cl.Logistics.Freight.Network.Services;

import com.cl.Logistics.Freight.Network.Repositories.AddressRepositories;
import com.cl.Logistics.Freight.Network.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    AddressRepositories addressRepository;

    @Autowired
    public AddressService(AddressRepositories addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Long addAddress(String street,
                           String city,
                           String postalCode,
                           String country) {

        if (street == null) {
            return null;
        }

        Address address = new Address();

        address.setStreet(street);
        address.setCity(city);
        address.setPostalCode(postalCode);
        address.setCountry(country);
        address.setIsActive(true);

        return addressRepository.save(address).getId();
    }

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public Address getById(Long id) {

        Optional<Address> address =
                addressRepository.findById(id);

        if (address.isPresent()
                && address.get().getIsActive()) {

            return address.get();
        }

        return new Address();
    }

    public Address updateAddress(Long id,
                                 String street,
                                 String city,
                                 String postalCode,
                                 String country) {

        Address address =
                addressRepository.findById(id).orElse(null);

        if (address == null
                || !address.getIsActive()) {

            return new Address();
        }

        address.setStreet(street);
        address.setCity(city);
        address.setPostalCode(postalCode);
        address.setCountry(country);

        return addressRepository.save(address);
    }

    public Boolean deleteById(Long id) {

        Address address =
                addressRepository.findById(id).orElse(null);

        if (address == null
                || !address.getIsActive()) {

            return false;
        }

        address.setIsActive(false);

        addressRepository.save(address);

        return true;
    }
}