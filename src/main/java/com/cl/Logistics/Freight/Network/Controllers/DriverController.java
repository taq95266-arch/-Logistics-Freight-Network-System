package com.cl.Logistics.Freight.Network.Controllers;

import com.cl.Logistics.Freight.Network.Services.DriverService;
import com.cl.Logistics.Freight.Network.entities.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("drivers")
public class DriverController {

    DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public Long addDriver(@RequestParam String name,
                          @RequestParam String licenseNumber,
                          @RequestParam String phoneNumber,
                          @RequestParam String status) {

        return driverService.addDriver(
                name,
                licenseNumber,
                phoneNumber,
                status
        );
    }

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDriver();
    }

    @GetMapping("/{id}")
    public Driver getById(@PathVariable Long id) {
        return driverService.getById(id);
    }

    @PutMapping("/{id}")
    public Driver updateDriver(@PathVariable Long id,
                               @RequestParam String name,
                               @RequestParam String licenseNumber,
                               @RequestParam String phoneNumber,
                               @RequestParam String status) {

        return driverService.updateDriver(
                id,
                name,
                licenseNumber,
                phoneNumber,
                status
        );
    }

    @DeleteMapping("/{id}")
    public Boolean deleteDriver(@PathVariable Long id) {
        return driverService.deleteById(id);
    }
}