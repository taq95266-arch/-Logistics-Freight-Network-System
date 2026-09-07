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
class Driver extends BaseClass{
    private String name;
    private String licenseNumber;
    private String phoneNumber;
    private String status;

    @ManyToOne
    private Carrier carrier;

    @OneToMany(mappedBy = "driver")
    private List<Route>routes;

}