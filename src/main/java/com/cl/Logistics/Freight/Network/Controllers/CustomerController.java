package com.cl.Logistics.Freight.Network.Controllers;

import com.cl.Logistics.Freight.Network.Services.CustomerService;
import com.cl.Logistics.Freight.Network.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Long addCustomer(@RequestParam String name,
                            @RequestParam String email,
                            @RequestParam String phoneNumber,
                            @RequestParam String type) {

        return customerService.addCustomer(
                name,
                email,
                phoneNumber,
                type
        );
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id,
                                   @RequestParam String name,
                                   @RequestParam String email,
                                   @RequestParam String phoneNumber,
                                   @RequestParam String type) {

        return customerService.updateCustomer(
                id,
                name,
                email,
                phoneNumber,
                type
        );
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCustomer(@PathVariable Long id) {
        return customerService.deleteById(id);
    }
}