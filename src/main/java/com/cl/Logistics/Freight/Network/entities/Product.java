package com.cl.Logistics.Freight.Network.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
 public class Product  extends BaseClass{
    private String name;
    private String sku;
    private Double weightKg;
    private String category;

    @OneToMany(mappedBy = "product")
    private List<InventoryItem>inventoryItems;

    @OneToMany(mappedBy = "product")
    private List<ShipmentItem>shipmentItems;
}