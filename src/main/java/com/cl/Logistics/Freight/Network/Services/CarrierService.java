package com.cl.Logistics.Freight.Network.Services;

import com.cl.Logistics.Freight.Network.Repositories.CarrierRepositories;
import com.cl.Logistics.Freight.Network.entities.Carrier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrierService {

    CarrierRepositories carrierRepository;

    @Autowired
    public CarrierService(CarrierRepositories carrierRepository) {
        this.carrierRepository = carrierRepository;
    }

    public Long addCarrier(String name,
                           String contactEmail,
                           String phoneNumber,
                           String country) {

        Carrier carrier = new Carrier();

        carrier.setName(name);
        carrier.setContactEmail(contactEmail);
        carrier.setPhoneNumber(phoneNumber);
        carrier.setCountry(country);
        carrier.setIsActive(true);

        return carrierRepository.save(carrier).getId();
    }

    public List<Carrier> getAllCarrier() {
        return carrierRepository.findAll();
    }

    public Carrier getById(Long id) {
        Carrier carrier = carrierRepository.findById(id).orElse(null);

        if (carrier == null || !carrier.getIsActive()) {
            return new Carrier();
        }

        return carrier;
    }

    public Carrier updateCarrier(Long id, String name,
                                 String contactEmail,
                                 String phoneNumber,
                                 String country) {

        Carrier carrier = carrierRepository.findById(id).orElse(null);

        if (carrier == null || !carrier.getIsActive()) {
            return new Carrier();
        }

        carrier.setName(name);
        carrier.setContactEmail(contactEmail);
        carrier.setPhoneNumber(phoneNumber);
        carrier.setCountry(country);

        return carrierRepository.save(carrier);
    }

    public Boolean deleteById(Long id) {

        Carrier carrier = carrierRepository.findById(id).orElse(null);

        if (carrier == null || !carrier.getIsActive()) {
            return false;
        }

        carrier.setIsActive(false);

        carrierRepository.save(carrier);

        return true;
    }
}