package com.cl.Logistics.Freight.Network.DTO;

import com.cl.Logistics.Freight.Network.entities.Driver;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class DriverDTO {
    public DriverDTO(String name, String licenseNumber, String phoneNumber, String status) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    private String name;
    private String licenseNumber;
    private String phoneNumber;
    private String status;

    public static DriverDTO convertTDO(Driver driver){
        return DriverDTO.builder()
                .name(driver.getName())
                .licenseNumber(driver.getLicenseNumber())
                .phoneNumber(driver.getPhoneNumber())
                .status(driver.getStatus())
                .build();
    }

    public static List<DriverDTO> convertToDTO(List<Driver>drivers){
        return drivers.stream().map(DriverDTO::convertTDO).toList();
    }
}
