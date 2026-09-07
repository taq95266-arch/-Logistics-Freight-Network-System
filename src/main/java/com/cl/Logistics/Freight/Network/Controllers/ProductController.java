package com.cl.Logistics.Freight.Network.Controllers;

import com.cl.Logistics.Freight.Network.Services.ProductServices;
import com.cl.Logistics.Freight.Network.Services.ProductServices;
import com.cl.Logistics.Freight.Network.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    ProductServices productService;

    @Autowired
    public ProductController(ProductServices productService) {
        this.productService = productService;
    }

    @PostMapping
    public Long addProduct(@RequestParam String name,
                           @RequestParam String sku,
                           @RequestParam Double weightKg,
                           @RequestParam String category) {

        return productService.addProduct(
                name,
                sku,
                weightKg,
                category
        );
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestParam String name,
                                 @RequestParam String sku,
                                 @RequestParam Double weightKg,
                                 @RequestParam String category) {

        return productService.updateProduct(
                id,
                name,
                sku,
                weightKg,
                category
        );
    }

    @DeleteMapping("/{id}")
    public Boolean deleteProduct(@PathVariable Long id) {
        return productService.deleteById(id);
    }
}