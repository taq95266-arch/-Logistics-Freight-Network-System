package com.cl.Logistics.Freight.Network.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
class ShipmentItem extends BaseClass{
    private Integer quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Shipment shipment;
}