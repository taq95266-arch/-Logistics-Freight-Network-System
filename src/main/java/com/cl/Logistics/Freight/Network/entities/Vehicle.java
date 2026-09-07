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
public class Vehicle extends BaseClass{
    private String plateNumber;
    private String type;
    private Double capacityKg;
    private String status;

    @ManyToOne
    private Carrier carrier;

    @OneToMany(mappedBy = "vehicle")
    private List<Route>routes;
}