package com.cl.Logistics.Freight.Network.Controllers;

import com.cl.Logistics.Freight.Network.Services.WarehouseService;
import com.cl.Logistics.Freight.Network.entities.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("warehouses")
public class WarehouseController {

    WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping
    public Long addWarehouse(@RequestParam String name,
                             @RequestParam String location,
                             @RequestParam Integer capacity) {

        return warehouseService.addWarehouse(
                name,
                location,
                capacity
        );
    }

    @GetMapping
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouse();
    }

    @GetMapping("/{id}")
    public Warehouse getById(@PathVariable Long id) {
        return warehouseService.getById(id);
    }

    @PutMapping("/{id}")
    public Warehouse updateWarehouse(@PathVariable Long id,
                                     @RequestParam String name,
                                     @RequestParam String location,
                                     @RequestParam Integer capacity) {

        return warehouseService.updateWarehouse(
                id,
                name,
                location,
                capacity
        );
    }

    @DeleteMapping("/{id}")
    public Boolean deleteWarehouse(@PathVariable Long id) {
        return warehouseService.deleteById(id);
    }
}