package com.cl.Logistics.Freight.Network.Controllers;

import com.cl.Logistics.Freight.Network.Services.StaffService;
import com.cl.Logistics.Freight.Network.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("staff")
public class StaffController {

    StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping
    public Long addStaff(@RequestParam String name,
                         @RequestParam String role,
                         @RequestParam String phoneNumber) {

        return staffService.addStaff(
                name,
                role,
                phoneNumber
        );
    }

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public Staff getById(@PathVariable Long id) {
        return staffService.getById(id);
    }

    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable Long id,
                             @RequestParam String name,
                             @RequestParam String role,
                             @RequestParam String phoneNumber) {

        return staffService.updateStaff(
                id,
                name,
                role,
                phoneNumber
        );
    }

    @DeleteMapping("/{id}")
    public Boolean deleteStaff(@PathVariable Long id) {
        return staffService.deleteById(id);
    }
}