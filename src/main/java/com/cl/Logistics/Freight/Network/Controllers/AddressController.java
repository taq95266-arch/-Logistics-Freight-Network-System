package com.cl.Logistics.Freight.Network.Controllers;

import com.cl.Logistics.Freight.Network.Services.AddressService;
import com.cl.Logistics.Freight.Network.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("addresses")
public class AddressController {



    AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping

    public  Long  address(@RequestParam String street,@RequestParam String city,@RequestParam String postalCode,@RequestParam String country){
        return addressService.addAddress(street,city,postalCode,country);
    }


        @GetMapping
        public List<Address> getAllAddress(){
        return addressService.getAllAddress();
        }

        @GetMapping("/id")
        public Address getById(@PathVariable Long id){
        return addressService.getById(id);
        }

        @PutMapping("/id")
        public Address updateAddress(@PathVariable Long id,@RequestParam String street,
                                     @RequestParam String city,@RequestParam String postalCode,
                                     @RequestParam String country){
        return addressService.updateAddress(id,street,city,postalCode,country);
        }

        @DeleteMapping("/id")
    public Boolean deleteAddress(@PathVariable Long id){
        return addressService.deleteById(id);

        }
}
