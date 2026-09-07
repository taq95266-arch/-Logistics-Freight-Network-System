package com.cl.Logistics.Freight.Network.Controllers;

import com.cl.Logistics.Freight.Network.Services.DeliveryStopService;
import com.cl.Logistics.Freight.Network.entities.DeliveryStop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("delivery-stops")
public class DeliveryStopController {

    DeliveryStopService deliveryStopService;

    @Autowired
    public DeliveryStopController(DeliveryStopService deliveryStopService) {
        this.deliveryStopService = deliveryStopService;
    }

    @PostMapping
    public Long addDeliveryStop(@RequestParam Integer sequence,
                                @RequestParam String address,
                                @RequestParam String status,
                                @RequestParam LocalDateTime eta) {

        return deliveryStopService.addDeliveryStop(
                sequence,
                address,
                status,
                eta
        );
    }

    @GetMapping
    public List<DeliveryStop> getAllDeliveryStops() {
        return deliveryStopService.getAllDeliveryStop();
    }

    @GetMapping("/{id}")
    public DeliveryStop getById(@PathVariable Long id) {
        return deliveryStopService.getById(id);
    }

    @PutMapping("/{id}")
    public DeliveryStop updateDeliveryStop(@PathVariable Long id,
                                           @RequestParam Integer sequence,
                                           @RequestParam String address,
                                           @RequestParam String status,
                                           @RequestParam LocalDateTime eta) {

        return deliveryStopService.updateDeliveryStop(
                id,
                sequence,
                address,
                status,
                eta
        );
    }

    @DeleteMapping("/{id}")
    public Boolean deleteDeliveryStop(@PathVariable Long id) {
        return deliveryStopService.deleteById(id);
    }
}
