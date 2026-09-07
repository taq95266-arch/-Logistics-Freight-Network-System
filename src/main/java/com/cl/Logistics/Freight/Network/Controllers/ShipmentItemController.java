package com.cl.Logistics.Freight.Network.Controllers;

import com.cl.Logistics.Freight.Network.Services.ShipmentItemService;
import com.cl.Logistics.Freight.Network.entities.ShipmentItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shipment-items")
public class ShipmentItemController {

    ShipmentItemService shipmentItemService;

    @Autowired
    public ShipmentItemController(ShipmentItemService shipmentItemService) {
        this.shipmentItemService = shipmentItemService;
    }

    @PostMapping
    public Long addShipmentItem(@RequestParam Integer quantity) {

        return shipmentItemService.addShipmentItem(
                quantity
        );
    }

    @GetMapping
    public List<ShipmentItem> getAllShipmentItems() {
        return shipmentItemService.getAllShipmentItems();
    }

    @GetMapping("/{id}")
    public ShipmentItem getById(@PathVariable Long id) {
        return shipmentItemService.getById(id);
    }

    @PutMapping("/{id}")
    public ShipmentItem updateShipmentItem(@PathVariable Long id,
                                           @RequestParam Integer quantity) {

        return shipmentItemService.updateShipmentItem(
                id,
                quantity
        );
    }

    @DeleteMapping("/{id}")
    public Boolean deleteShipmentItem(@PathVariable Long id) {
        return shipmentItemService.deleteById(id);
    }
}