package com.cl.Logistics.Freight.Network.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
class Staff extends BaseClass{
    private String name;
    private String role;
    private String phoneNumber;

    @ManyToOne
    private Warehouse warehouse;
}