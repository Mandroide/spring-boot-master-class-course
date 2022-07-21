package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo repository;

    @Autowired
    public CustomerService(CustomerRepo repository) {
        this.repository = repository;
    }

    public List<Customer> getCustomers(){
        return repository.getCustomers();
    }

    Customer getCustomer(Long id){
        return getCustomers().stream().filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Customer with " + id + " not found"));
    }
}
