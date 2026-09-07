package com.cl.Logistics.Freight.Network.Services;

import com.cl.Logistics.Freight.Network.Repositories.ShipmentItemRepositories;
import com.cl.Logistics.Freight.Network.entities.ShipmentItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentItemService {

    ShipmentItemRepositories shipmentItemRepository;

    @Autowired
    public ShipmentItemService(ShipmentItemRepositories shipmentItemRepository) {
        this.shipmentItemRepository = shipmentItemRepository;
    }

    public Long addShipmentItem(Integer quantity) {

        if (quantity == null) {
            return null;
        }

        ShipmentItem shipmentItem = new ShipmentItem();

        shipmentItem.setQuantity(quantity);
        shipmentItem.setIsActive(true);

        return shipmentItemRepository.save(shipmentItem).getId();
    }

    public List<ShipmentItem> getAllShipmentItems() {
        return shipmentItemRepository.findAll();
    }

    public ShipmentItem getById(Long id) {

        Optional<ShipmentItem> shipmentItem =
                shipmentItemRepository.findById(id);

        if (shipmentItem.isPresent()
                && shipmentItem.get().getIsActive()) {

            return shipmentItem.get();
        }

        return new ShipmentItem();
    }

    public ShipmentItem updateShipmentItem(Long id,
                                           Integer quantity) {

        ShipmentItem shipmentItem =
                shipmentItemRepository.findById(id).orElse(null);

        if (shipmentItem == null
                || !shipmentItem.getIsActive()) {

            return new ShipmentItem();
        }

        shipmentItem.setQuantity(quantity);

        return shipmentItemRepository.save(shipmentItem);
    }

    public Boolean deleteById(Long id) {

        ShipmentItem shipmentItem =
                shipmentItemRepository.findById(id).orElse(null);

        if (shipmentItem == null
                || !shipmentItem.getIsActive()) {

            return false;
        }

        shipmentItem.setIsActive(false);

        shipmentItemRepository.save(shipmentItem);

        return true;
    }
}
