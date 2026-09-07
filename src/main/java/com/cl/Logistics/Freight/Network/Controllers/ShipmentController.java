package com.cl.Logistics.Freight.Network.Controllers;

import com.cl.Logistics.Freight.Network.Services.ShipmentService;
import com.cl.Logistics.Freight.Network.entities.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shipments")
public class ShipmentController {

    ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public Long addShipment(@RequestParam String status,
                            @RequestParam Double totalWeight) {

        return shipmentService.addShipment(
                status,
                totalWeight
        );
    }

    @GetMapping
    public List<Shipment> getAllShipments() {
        return shipmentService.getAllShipment();
    }

    @GetMapping("/{id}")
    public Shipment getById(@PathVariable Long id) {
        return shipmentService.getById(id);
    }

    @PutMapping("/{id}")
    public Shipment updateShipment(@PathVariable Long id,
                                   @RequestParam String status,
                                   @RequestParam Double totalWeight) {

        return shipmentService.updateShipment(
                id,
                status,
                totalWeight
        );
    }

    @DeleteMapping("/{id}")
    public Boolean deleteShipment(@PathVariable Long id) {
        return shipmentService.deleteById(id);
    }
}