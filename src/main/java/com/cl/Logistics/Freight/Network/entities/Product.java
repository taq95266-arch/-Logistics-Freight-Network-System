package com.cl.Logistics.Freight.Network.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
class Product  extends BaseClass{
    private String name;
    private String sku;
    private Double weightKg;

    @OneToMany(mappedBy = "product")
    private List<InventoryItem>inventoryItems;

    @OneToMany(mappedBy = "product")
    private List<ShipmentItem>shipmentItems;
}