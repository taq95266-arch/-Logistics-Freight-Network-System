package com.cl.Logistics.Freight.Network.Services;

import com.cl.Logistics.Freight.Network.Repositories.VehicleRepositories;
import com.cl.Logistics.Freight.Network.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    VehicleRepositories vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepositories vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Long addVehicle(String plateNumber,
                           String type,
                           Double capacityKg,
                           String status) {

        if (plateNumber == null) {
            return null;
        }

        Vehicle vehicle = new Vehicle();

        vehicle.setPlateNumber(plateNumber);
        vehicle.setType(type);
        vehicle.setCapacityKg(capacityKg);
        vehicle.setStatus(status);
        vehicle.setIsActive(true);

        return vehicleRepository.save(vehicle).getId();
    }

    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }

    public Vehicle getById(Long id) {

        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        if (vehicle.isPresent() && vehicle.get().getIsActive()) {
            return vehicle.get();
        }

        return new Vehicle();
    }

    public Vehicle updateVehicle(Long id,
                                 String plateNumber,
                                 String type,
                                 Double capacityKg,
                                 String status) {

        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);

        if (vehicle == null || !vehicle.getIsActive()) {
            return new Vehicle();
        }

        vehicle.setPlateNumber(plateNumber);
        vehicle.setType(type);
        vehicle.setCapacityKg(capacityKg);
        vehicle.setStatus(status);

        return vehicleRepository.save(vehicle);
    }

    public Boolean deleteById(Long id) {

        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);

        if (vehicle == null || !vehicle.getIsActive()) {
            return false;
        }

        vehicle.setIsActive(false);

        vehicleRepository.save(vehicle);

        return true;
    }
}