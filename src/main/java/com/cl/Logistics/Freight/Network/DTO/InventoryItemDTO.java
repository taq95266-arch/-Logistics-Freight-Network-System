package com.cl.Logistics.Freight.Network.DTO;

import com.cl.Logistics.Freight.Network.entities.InventoryItem;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
public class InventoryItemDTO {

    public InventoryItemDTO(Integer quantity, String shelfLocation) {
        this.quantity = quantity;
        this.shelfLocation = shelfLocation;
    }

    private Integer quantity;
    private String shelfLocation;



    public static InventoryItemDTO convertToDTO(InventoryItem inventoryItem){
        return InventoryItemDTO.builder()
                .quantity(inventoryItem.getQuantity())
                .shelfLocation(inventoryItem.getShelfLocation())
                .build();
    }

    public static List<InventoryItemDTO> convertToDTO(List<InventoryItem>inventoryItems){
        return inventoryItems.stream().map(InventoryItemDTO::convertToDTO).toList();
    }
}
