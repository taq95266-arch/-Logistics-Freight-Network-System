package com.cl.Logistics.Freight.Network.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
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
}