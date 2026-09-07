package com.cl.Logistics.Freight.Network.Services;

import com.cl.Logistics.Freight.Network.Repositories.InventoryItemRepositories;
import com.cl.Logistics.Freight.Network.entities.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryItemService {

    InventoryItemRepositories inventoryItemRepository;

    @Autowired
    public InventoryItemService(InventoryItemRepositories inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public Long addInventoryItem(Integer quantity,
                                 String shelfLocation) {

        if (quantity == null) {
            return null;
        }

        InventoryItem inventoryItem = new InventoryItem();

        inventoryItem.setQuantity(quantity);
        inventoryItem.setShelfLocation(shelfLocation);
        inventoryItem.setIsActive(true);

        return inventoryItemRepository.save(inventoryItem).getId();
    }

    public List<InventoryItem> getAllInventoryItem() {
        return inventoryItemRepository.findAll();
    }

    public InventoryItem getById(Long id) {

        Optional<InventoryItem> inventoryItem =
                inventoryItemRepository.findById(id);

        if (inventoryItem.isPresent()
                && inventoryItem.get().getIsActive()) {

            return inventoryItem.get();
        }

        return new InventoryItem();
    }

    public InventoryItem updateInventoryItem(Long id,
                                             Integer quantity,
                                             String shelfLocation) {

        InventoryItem inventoryItem =
                inventoryItemRepository.findById(id).orElse(null);

        if (inventoryItem == null
                || !inventoryItem.getIsActive()) {

            return new InventoryItem();
        }

        inventoryItem.setQuantity(quantity);
        inventoryItem.setShelfLocation(shelfLocation);

        return inventoryItemRepository.save(inventoryItem);
    }

    public Boolean deleteById(Long id) {

        InventoryItem inventoryItem =
                inventoryItemRepository.findById(id).orElse(null);

        if (inventoryItem == null
                || !inventoryItem.getIsActive()) {

            return false;
        }

        inventoryItem.setIsActive(false);

        inventoryItemRepository.save(inventoryItem);

        return true;
    }
}