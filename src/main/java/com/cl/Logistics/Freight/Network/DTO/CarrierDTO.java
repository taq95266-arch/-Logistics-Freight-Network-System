package com.cl.Logistics.Freight.Network.DTO;

import com.cl.Logistics.Freight.Network.entities.Carrier;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class CarrierDTO {
    public CarrierDTO(String country, String phoneNumber, String contactEmail, String name) {
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.contactEmail = contactEmail;
        this.name = name;
    }

    private String name;
    private String contactEmail;
    private String phoneNumber;
    private String country;

    public static CarrierDTO convertODTO(Carrier carrier) {
        return CarrierDTO.builder().name(carrier.getName())
                .contactEmail(carrier.getContactEmail())
                .phoneNumber(carrier.getPhoneNumber())
                .country(carrier.getCountry())
                .build();
    }

    public static List<CarrierDTO> convertToTDO(List<Carrier> carriers){
        return carriers.stream().map(CarrierDTO::convertODTO)
                .toList();
    }
}
