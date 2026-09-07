package com.cl.Logistics.Freight.Network.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
public class DeliveryStop extends BaseClass {
    private Integer sequence;
    private String address;
    private String status;
    private LocalDateTime eta;

    @ManyToOne
    private Route route;

    @ManyToOne
    private Shipment shipment;
}