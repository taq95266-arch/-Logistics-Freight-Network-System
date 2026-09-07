package com.cl.Logistics.Freight.Network.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
class Carrier extends BaseClass{
    private String name;
    private String contactEmail;
    private String phoneNumber;
    private String country;

    @OneToMany(mappedBy = "carrier")
    private List<Shipment>shipments;

    @OneToMany(mappedBy = "carrier")
    private List<Vehicle>vehicles;

    @OneToMany(mappedBy = "carrier")
    private List<Driver>drivers;


}