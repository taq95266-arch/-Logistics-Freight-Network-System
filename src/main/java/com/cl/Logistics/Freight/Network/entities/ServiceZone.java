package com.cl.Logistics.Freight.Network.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@Entity

class ServiceZone extends BaseClass{
    private String name;
    private String region;
    private BigDecimal baseRate;
}