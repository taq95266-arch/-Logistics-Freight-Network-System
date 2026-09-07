package com.cl.Logistics.Freight.Network.DTO;

import com.cl.Logistics.Freight.Network.entities.DeliveryStop;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class DeliveryStopDTO {

    private Integer sequence;
    private String address;
    private String status;
    private LocalDateTime eta;

    public DeliveryStopDTO(Integer sequence, String address, String status, LocalDateTime eta) {
        this.sequence = sequence;
        this.address = address;
        this.status = status;
        this.eta = eta;
    }

    public static DeliveryStopDTO converToDTO (DeliveryStop deliveryStop){
        return DeliveryStopDTO.builder()
                .sequence(deliveryStop.getSequence())
                .address(deliveryStop.getAddress())
                .status(deliveryStop.getStatus())
                .eta(deliveryStop.getEta())
                .build();
    }

    public static List<DeliveryStopDTO> convertToDTO(List<DeliveryStop> deliveryStops){
        return deliveryStops.stream().map(DeliveryStopDTO::converToDTO).toList();
    }

}
