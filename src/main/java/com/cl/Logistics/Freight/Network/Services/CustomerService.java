package com.cl.Logistics.Freight.Network.Services;

import com.cl.Logistics.Freight.Network.Repositories.CustomerRepositories;
import com.cl.Logistics.Freight.Network.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    CustomerRepositories customerRepository;

    @Autowired
    public CustomerService(CustomerRepositories customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Long addCustomer(String name, String email,
                            String phoneNumber, String type) {

        Customer customer = new Customer();

        customer.setName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customer.setType(type);
        customer.setIsActive(true);

        return customerRepository.save(customer).getId();
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer getById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);

        if (customer == null || !customer.getIsActive()) {
            return new Customer();
        }

        return customer;
    }

    public Customer updateCustomer(Long id, String name,
                                   String email, String phoneNumber,
                                   String type) {

        Customer customer = customerRepository.findById(id).orElse(null);

        if (customer == null || !customer.getIsActive()) {
            return new Customer();
        }

        customer.setName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customer.setType(type);

        return customerRepository.save(customer);
    }

    public Boolean deleteById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);

        if (customer == null || !customer.getIsActive()) {
            return false;
        }

        customer.setIsActive(false);

        customerRepository.save(customer);

        return true;
    }
}