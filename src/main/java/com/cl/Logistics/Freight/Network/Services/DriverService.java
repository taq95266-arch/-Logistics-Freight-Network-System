package com.cl.Logistics.Freight.Network.Services;

import com.cl.Logistics.Freight.Network.Repositories.DriverRepositories;
import com.cl.Logistics.Freight.Network.entities.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    DriverRepositories driverRepository;

    @Autowired
    public DriverService(DriverRepositories driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Long addDriver(String name,
                          String licenseNumber,
                          String phoneNumber,
                          String status) {

        Driver driver = new Driver();

        driver.setName(name);
        driver.setLicenseNumber(licenseNumber);
        driver.setPhoneNumber(phoneNumber);
        driver.setStatus(status);
        driver.setIsActive(true);

        return driverRepository.save(driver).getId();
    }

    public List<Driver> getAllDriver() {
        return driverRepository.findAll();
    }

    public Driver getById(Long id) {
        Driver driver = driverRepository.findById(id).orElse(null);

        if (driver == null || !driver.getIsActive()) {
            return new Driver();
        }

        return driver;
    }

    public Driver updateDriver(Long id,
                               String name,
                               String licenseNumber,
                               String phoneNumber,
                               String status) {

        Driver driver = driverRepository.findById(id).orElse(null);

        if (driver == null || !driver.getIsActive()) {
            return new Driver();
        }

        driver.setName(name);
        driver.setLicenseNumber(licenseNumber);
        driver.setPhoneNumber(phoneNumber);
        driver.setStatus(status);

        return driverRepository.save(driver);
    }

    public Boolean deleteById(Long id) {

        Driver driver = driverRepository.findById(id).orElse(null);

        if (driver == null || !driver.getIsActive()) {
            return false;
        }

        driver.setIsActive(false);

        driverRepository.save(driver);

        return true;
    }
}