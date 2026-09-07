package com.cl.Logistics.Freight.Network.Repositories;

import com.cl.Logistics.Freight.Network.entities.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepositories extends JpaRepository<InventoryItem,Long> {
}
