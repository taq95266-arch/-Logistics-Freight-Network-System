package com.cl.Logistics.Freight.Network.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity

class Shipment extends BaseClass {
    private LocalDate shipmentDate;
    private String status;
    private Double totalWeight;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "shipment")
    private List<ShipmentItem>shipmentItems;

    @OneToMany(mappedBy = "shipment")
    private List<TrackingEvent>trackingEvents;

    @ManyToOne
    private Carrier carrier;
}