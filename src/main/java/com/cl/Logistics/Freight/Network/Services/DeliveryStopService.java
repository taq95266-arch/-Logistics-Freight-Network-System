package com.cl.Logistics.Freight.Network.Services;

import com.cl.Logistics.Freight.Network.Repositories.DeliveryStopRepositories;
import com.cl.Logistics.Freight.Network.entities.DeliveryStop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryStopService {

    DeliveryStopRepositories deliveryStopRepository;

    @Autowired
    public DeliveryStopService(DeliveryStopRepositories deliveryStopRepository) {
        this.deliveryStopRepository = deliveryStopRepository;
    }

    public Long addDeliveryStop(Integer sequence,
                                String address,
                                String status,
                                LocalDateTime eta) {

        if (sequence == null) {
            return null;
        }

        DeliveryStop deliveryStop = new DeliveryStop();

        deliveryStop.setSequence(sequence);
        deliveryStop.setAddress(address);
        deliveryStop.setStatus(status);
        deliveryStop.setEta(eta);
        deliveryStop.setIsActive(true);

        return deliveryStopRepository.save(deliveryStop).getId();
    }

    public List<DeliveryStop> getAllDeliveryStop() {
        return deliveryStopRepository.findAll();
    }

    public DeliveryStop getById(Long id) {

        Optional<DeliveryStop> deliveryStop =
                deliveryStopRepository.findById(id);

        if (deliveryStop.isPresent()
                && deliveryStop.get().getIsActive()) {

            return deliveryStop.get();
        }

        return new DeliveryStop();
    }

    public DeliveryStop updateDeliveryStop(Long id,
                                           Integer sequence,
                                           String address,
                                           String status,
                                           LocalDateTime eta) {

        DeliveryStop deliveryStop =
                deliveryStopRepository.findById(id).orElse(null);

        if (deliveryStop == null
                || !deliveryStop.getIsActive()) {

            return new DeliveryStop();
        }

        deliveryStop.setSequence(sequence);
        deliveryStop.setAddress(address);
        deliveryStop.setStatus(status);
        deliveryStop.setEta(eta);

        return deliveryStopRepository.save(deliveryStop);
    }

    public Boolean deleteById(Long id) {

        DeliveryStop deliveryStop =
                deliveryStopRepository.findById(id).orElse(null);

        if (deliveryStop == null
                || !deliveryStop.getIsActive()) {

            return false;
        }

        deliveryStop.setIsActive(false);

        deliveryStopRepository.save(deliveryStop);

        return true;
    }
}