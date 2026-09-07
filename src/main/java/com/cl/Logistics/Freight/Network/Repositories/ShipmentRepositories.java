package com.cl.Logistics.Freight.Network.Repositories;

import com.cl.Logistics.Freight.Network.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepositories extends JpaRepository<Shipment,Long> {
}
