package com.cl.Logistics.Freight.Network.Repositories;

import com.cl.Logistics.Freight.Network.entities.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;

public interface CarrierRepositories extends JpaRepository<Carrier,Long> {
}
