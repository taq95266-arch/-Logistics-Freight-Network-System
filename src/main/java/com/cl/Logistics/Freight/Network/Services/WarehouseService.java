package com.cl.Logistics.Freight.Network.Services;

import com.cl.Logistics.Freight.Network.Repositories.WarehouseRepositories;
import com.cl.Logistics.Freight.Network.entities.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    WarehouseRepositories warehouseRepository;

    @Autowired
    public WarehouseService(WarehouseRepositories warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public Long addWarehouse(String name, String location, Integer capacity) {

        Warehouse warehouse = new Warehouse();
        warehouse.setName(name);
        warehouse.setLocation(location);
        warehouse.setCapacity(capacity);
        warehouse.setIsActive(true);

        return warehouseRepository.save(warehouse).getId();
    }

    public List<Warehouse> getAllWarehouse() {
        return warehouseRepository.findAll();
    }

    public Warehouse getById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id).orElse(null);

        if (warehouse == null || !warehouse.getIsActive()) {
            return new Warehouse();
        }

        return warehouse;
    }

    public Warehouse updateWarehouse(Long id, String name,
                                     String location, Integer capacity) {

        Warehouse warehouse = warehouseRepository.findById(id).orElse(null);

        if (warehouse == null || !warehouse.getIsActive()) {
            return new Warehouse();
        }

        warehouse.setName(name);
        warehouse.setLocation(location);
        warehouse.setCapacity(capacity);

        return warehouseRepository.save(warehouse);
    }

    public Boolean deleteById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id).orElse(null);

        if (warehouse == null || !warehouse.getIsActive()) {
            return false;
        }

        warehouse.setIsActive(false);
        warehouseRepository.save(warehouse);

        return true;
    }
}