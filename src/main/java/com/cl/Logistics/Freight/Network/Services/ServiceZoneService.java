package com.cl.Logistics.Freight.Network.Services;

import com.cl.Logistics.Freight.Network.Repositories.ServiceZoneRepositories;
import com.cl.Logistics.Freight.Network.entities.ServiceZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceZoneService {

    ServiceZoneRepositories serviceZoneRepository;

    @Autowired
    public ServiceZoneService(ServiceZoneRepositories serviceZoneRepository) {
        this.serviceZoneRepository = serviceZoneRepository;
    }

    public Long addServiceZone(String name,
                               String region,
                               Double baseRate) {

        if (name == null) {
            return null;
        }

        ServiceZone serviceZone = new ServiceZone();

        serviceZone.setName(name);
        serviceZone.setRegion(region);
        serviceZone.setBaseRate(BigDecimal.valueOf(baseRate));
        serviceZone.setIsActive(true);

        return serviceZoneRepository.save(serviceZone).getId();
    }

    public List<ServiceZone> getAllServiceZone() {
        return serviceZoneRepository.findAll();
    }

    public ServiceZone getById(Long id) {

        Optional<ServiceZone> serviceZone =
                serviceZoneRepository.findById(id);

        if (serviceZone.isPresent()
                && serviceZone.get().getIsActive()) {

            return serviceZone.get();
        }

        return new ServiceZone();
    }

    public ServiceZone updateServiceZone(Long id,
                                         String name,
                                         String region,
                                         Double baseRate) {

        ServiceZone serviceZone =
                serviceZoneRepository.findById(id).orElse(null);

        if (serviceZone == null
                || !serviceZone.getIsActive()) {

            return new ServiceZone();
        }

        serviceZone.setName(name);
        serviceZone.setRegion(region);
        serviceZone.setBaseRate(BigDecimal.valueOf(baseRate));

        return serviceZoneRepository.save(serviceZone);
    }

    public Boolean deleteById(Long id) {

        ServiceZone serviceZone =
                serviceZoneRepository.findById(id).orElse(null);

        if (serviceZone == null
                || !serviceZone.getIsActive()) {

            return false;
        }

        serviceZone.setIsActive(false);

        serviceZoneRepository.save(serviceZone);

        return true;
    }
}