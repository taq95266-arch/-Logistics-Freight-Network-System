package com.cl.Logistics.Freight.Network.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
class Address extends BaseClass{
    private String street;
    private String city;
    private String postalCode;
    private String country;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private ServiceZone serviceZone;
}