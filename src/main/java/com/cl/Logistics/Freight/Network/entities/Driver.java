package com.cl.Logistics.Freight.Network.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
class Driver extends BaseClass{
    private String name;
    private String licenseNumber;
    private String phoneNumber;
    private String status;


}