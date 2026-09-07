package com.cl.Logistics.Freight.Network.Controllers;

import com.cl.Logistics.Freight.Network.Services.VehicleService;
import com.cl.Logistics.Freight.Network.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicles")
public class VehicleController {

    VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public Long addVehicle(@RequestParam String plateNumber,
                           @RequestParam String type,
                           @RequestParam Double capacityKg,
                           @RequestParam String status) {

        return vehicleService.addVehicle(
                plateNumber,
                type,
                capacityKg,
                status
        );
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicle();
    }

    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return vehicleService.getById(id);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id,
                                 @RequestParam String plateNumber,
                                 @RequestParam String type,
                                 @RequestParam Double capacityKg,
                                 @RequestParam String status) {

        return vehicleService.updateVehicle(
                id,
                plateNumber,
                type,
                capacityKg,
                status
        );
    }

    @DeleteMapping("/{id}")
    public Boolean deleteVehicle(@PathVariable Long id) {
        return vehicleService.deleteById(id);
    }
}