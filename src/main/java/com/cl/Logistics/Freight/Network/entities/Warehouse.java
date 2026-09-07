package com.cl.Logistics.Freight.Network.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
class Warehouse extends BaseClass {
    private String name;
    private String location;
    private Integer capacity;

    @ManyToOne
    private Warehouse warehouse;

    @OneToMany(mappedBy = "warehouse")
    private List<InventoryItem>inventoryItems;

    @OneToMany(mappedBy = "warehouse")
    private List<Shipment>shipments;

    @OneToMany(mappedBy = "warehouse")
    private List<Staff>staff;


}