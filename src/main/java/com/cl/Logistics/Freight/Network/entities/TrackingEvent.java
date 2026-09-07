package com.cl.Logistics.Freight.Network.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity

class TrackingEvent extends BaseClass{
    private LocalDateTime eventTime;
    private String location;
    private String status;
    private String note;

    @ManyToOne
    private Shipment shipment;
}