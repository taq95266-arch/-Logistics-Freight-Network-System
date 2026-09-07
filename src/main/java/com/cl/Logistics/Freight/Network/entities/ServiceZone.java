package com.cl.Logistics.Freight.Network.entities;
import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity

public class ServiceZone extends BaseClass{
    private String name;
    private String region;
    private BigDecimal baseRate;

    @OneToMany(mappedBy = "serviceZone")
    private List<Address>addresses;


}