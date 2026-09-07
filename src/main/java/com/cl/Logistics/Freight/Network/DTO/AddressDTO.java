package com.cl.Logistics.Freight.Network.DTO;

import com.cl.Logistics.Freight.Network.entities.Address;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class AddressDTO {
    private String stress;
    private  String city;
    private String postalCode;
    private String country;

    public AddressDTO(String country, String postalCode, String city, String stress) {
        this.country = country;
        this.postalCode = postalCode;
        this.city = city;
        this.stress = stress;
    }


    public static AddressDTO convertToDTO(Address address) {
        return AddressDTO.builder().stress(address.getStreet())
                .city(address.getCity())
                .postalCode(address.getPostalCode())
                .country(address.getCountry())
                .build();
    }

    public static List<AddressDTO>convertToDTO(List<Address> addresses){
        return addresses.stream().map(AddressDTO::convertToDTO).toList();
    }
}
