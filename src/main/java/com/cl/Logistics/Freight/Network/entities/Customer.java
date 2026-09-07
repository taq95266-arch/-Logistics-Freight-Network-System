package com.cl.Logistics.Freight.Network.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Customer extends BaseClass {
    private String name;
    private String email;
    private String phoneNumber;
    private String type;

    @OneToMany(mappedBy = "customer")
    private List<Shipment>shipments;

    @OneToMany(mappedBy = "customer")
    private List<Address>addresses;
}