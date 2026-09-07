package com.cl.Logistics.Freight.Network.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@MappedSuperclass
@Setter
@Setter

public class BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private Boolean isActive;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
