package com.cl.Logistics.Freight.Network.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@Entity
class Invoice extends BaseClass {
    private BigDecimal amount;
    private String status;
    private LocalDate issuedDate;

    @ManyToOne
    private Shipment shipment;

    @ManyToOne
    private Customer customer;
}