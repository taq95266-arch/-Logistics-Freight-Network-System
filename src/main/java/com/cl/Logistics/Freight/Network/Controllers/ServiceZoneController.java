package com.cl.Logistics.Freight.Network.Controllers;

import com.cl.Logistics.Freight.Network.Services.ServiceZoneService;
import com.cl.Logistics.Freight.Network.entities.ServiceZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service-zones")
public class ServiceZoneController {

    ServiceZoneService serviceZoneService;

    @Autowired
    public ServiceZoneController(ServiceZoneService serviceZoneService) {
        this.serviceZoneService = serviceZoneService;
    }

    @PostMapping
    public Long addServiceZone(@RequestParam String name,
                               @RequestParam String region,
                               @RequestParam Double baseRate) {

        return serviceZoneService.addServiceZone(
                name,
                region,
                baseRate
        );
    }

    @GetMapping
    public List<ServiceZone> getAllServiceZones() {
        return serviceZoneService.getAllServiceZone();
    }

    @GetMapping("/{id}")
    public ServiceZone getById(@PathVariable Long id) {
        return serviceZoneService.getById(id);
    }

    @PutMapping("/{id}")
    public ServiceZone updateServiceZone(@PathVariable Long id,
                                         @RequestParam String name,
                                         @RequestParam String region,
                                         @RequestParam Double baseRate) {

        return serviceZoneService.updateServiceZone(
                id,
                name,
                region,
                baseRate
        );
    }

    @DeleteMapping("/{id}")
    public Boolean deleteServiceZone(@PathVariable Long id) {
        return serviceZoneService.deleteById(id);
    }
}