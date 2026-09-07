package com.cl.Logistics.Freight.Network.DTO;

import com.cl.Logistics.Freight.Network.entities.Customer;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class CustomerDTO {
    private String name;
    private String email;

    public CustomerDTO(String name, String email, String phoneNumber, String type) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    private String phoneNumber;
    private String type;

    public static CustomerDTO convertToDTO(Customer customer){
        return CustomerDTO.builder()
                .name((customer.getName()))
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .type(customer.getType())
                .build();
    }

    public static List<CustomerDTO> converToDTO(List<Customer>customers){
        return customers.stream().map(CustomerDTO::convertToDTO).toList();
    }
}
