package com.cl.Logistics.Freight.Network.Repositories;

import com.cl.Logistics.Freight.Network.entities.TrackingEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingEventRepositories extends JpaRepository<TrackingEvent,Long> {
}
