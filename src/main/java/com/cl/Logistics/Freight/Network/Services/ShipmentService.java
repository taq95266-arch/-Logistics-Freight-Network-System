package com.cl.Logistics.Freight.Network.Services;

import com.cl.Logistics.Freight.Network.Repositories.ShipmentRepositories;
import com.cl.Logistics.Freight.Network.entities.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {

    ShipmentRepositories shipmentRepository;

    @Autowired
    public ShipmentService(ShipmentRepositories shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public Long addShipment(String status,
                            Double totalWeight) {

        Shipment shipment = new Shipment();

        shipment.setStatus(status);
        shipment.setTotalWeight(totalWeight);
        shipment.setIsActive(true);

        return shipmentRepository.save(shipment).getId();
    }

    public List<Shipment> getAllShipment() {
        return shipmentRepository.findAll();
    }

    public Shipment getById(Long id) {

        Optional<Shipment> shipment = shipmentRepository.findById(id);

        if (shipment.isPresent() && shipment.get().getIsActive()) {
            return shipment.get();
        }

        return new Shipment();
    }

    public Shipment updateShipment(Long id,
                                   String status,
                                   Double totalWeight) {

        Shipment shipment = shipmentRepository.findById(id).orElse(null);

        if (shipment == null || !shipment.getIsActive()) {
            return new Shipment();
        }

        shipment.setStatus(status);
        shipment.setTotalWeight(totalWeight);

        return shipmentRepository.save(shipment);
    }

    public Boolean deleteById(Long id) {

        Shipment shipment = shipmentRepository.findById(id).orElse(null);

        if (shipment == null || !shipment.getIsActive()) {
            return false;
        }

        shipment.setIsActive(false);

        shipmentRepository.save(shipment);

        return true;
    }
}