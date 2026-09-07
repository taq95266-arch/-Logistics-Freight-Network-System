package com.cl.Logistics.Freight.Network.Services;

import com.cl.Logistics.Freight.Network.Repositories.ProductRepositories;
import com.cl.Logistics.Freight.Network.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    ProductRepositories productRepository;

    @Autowired
    public ProductServices(ProductRepositories productRepository) {
        this.productRepository = productRepository;
    }

    public Long addProduct(String name,
                           String sku,
                           Double weightKg,
                           String category) {

        if (name == null) {
            return null;
        }

        Product product = new Product();

        product.setName(name);
        product.setSku(sku);
        product.setWeightKg(weightKg);
        product.setCategory(category);
        product.setIsActive(true);

        return productRepository.save(product).getId();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {

        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent() && product.get().getIsActive()) {
            return product.get();
        }

        return new Product();
    }

    public Product updateProduct(Long id,
                                 String name,
                                 String sku,
                                 Double weightKg,
                                 String category) {

        Product product = productRepository.findById(id).orElse(null);

        if (product == null || !product.getIsActive()) {
            return new Product();
        }

        product.setName(name);
        product.setSku(sku);
        product.setWeightKg(weightKg);
        product.setCategory(category);

        return productRepository.save(product);
    }

    public Boolean deleteById(Long id) {

        Product product = productRepository.findById(id).orElse(null);

        if (product == null || !product.getIsActive()) {
            return false;
        }

        product.setIsActive(false);

        productRepository.save(product);

        return true;
    }
}