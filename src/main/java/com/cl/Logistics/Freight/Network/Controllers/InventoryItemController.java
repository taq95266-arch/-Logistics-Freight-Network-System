package com.cl.Logistics.Freight.Network.Controllers;

import com.cl.Logistics.Freight.Network.Services.InventoryItemService;
import com.cl.Logistics.Freight.Network.entities.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventory-items")
public class InventoryItemController {

    InventoryItemService inventoryItemService;

    @Autowired
    public InventoryItemController(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    @PostMapping
    public Long addInventoryItem(@RequestParam Integer quantity,
                                 @RequestParam String shelfLocation) {

        return inventoryItemService.addInventoryItem(
                quantity,
                shelfLocation
        );
    }

    @GetMapping
    public List<InventoryItem> getAllInventoryItems() {
        return inventoryItemService.getAllInventoryItem();
    }

    @GetMapping("/{id}")
    public InventoryItem getById(@PathVariable Long id) {
        return inventoryItemService.getById(id);
    }

    @PutMapping("/{id}")
    public InventoryItem updateInventoryItem(@PathVariable Long id,
                                             @RequestParam Integer quantity,
                                             @RequestParam String shelfLocation) {

        return inventoryItemService.updateInventoryItem(
                id,
                quantity,
                shelfLocation
        );
    }

    @DeleteMapping("/{id}")
    public Boolean deleteInventoryItem(@PathVariable Long id) {
        return inventoryItemService.deleteById(id);
    }
}