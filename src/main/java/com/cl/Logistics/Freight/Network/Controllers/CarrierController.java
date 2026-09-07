

import com.cl.Logistics.Freight.Network.Services.CarrierService;
import com.cl.Logistics.Freight.Network.entities.Carrier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carriers")
public class CarrierController {

    CarrierService carrierService;

    @Autowired
    public CarrierController(CarrierService carrierService) {
        this.carrierService = carrierService;
    }

    @PostMapping
    public Long addCarrier(@RequestParam String name,
                           @RequestParam String contactEmail,
                           @RequestParam String phoneNumber,
                           @RequestParam String country) {

        return carrierService.addCarrier(
                name,
                contactEmail,
                phoneNumber,
                country
        );
    }

    @GetMapping
    public List<Carrier> getAllCarriers() {
        return carrierService.getAllCarrier();
    }

    @GetMapping("/{id}")
    public Carrier getById(@PathVariable Long id) {
        return carrierService.getById(id);
    }

    @PutMapping("/{id}")
    public Carrier updateCarrier(@PathVariable Long id,
                                 @RequestParam String name,
                                 @RequestParam String contactEmail,
                                 @RequestParam String phoneNumber,
                                 @RequestParam String country) {

        return carrierService.updateCarrier(
                id,
                name,
                contactEmail,
                phoneNumber,
                country
        );
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCarrier(@PathVariable Long id) {
        return carrierService.deleteById(id);
    }
}