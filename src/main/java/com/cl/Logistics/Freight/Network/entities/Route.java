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

class Route extends BaseClass{
    private LocalDate routeDate;
    private String origin;
    private String destination;
    private String status;

    @ManyToOne
    private  Vehicle vehicle;

    @ManyToOne
    private  Driver driver;
    @OneToMany(mappedBy = "route")
    private List<DeliveryStop>deliveryStops;
}