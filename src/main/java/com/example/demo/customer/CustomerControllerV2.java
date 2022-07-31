package com.example.demo.customer;

import com.example.demo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v2/customers")
@lombok.AllArgsConstructor
public class CustomerControllerV2 {
    private final CustomerService service;

    @GetMapping
    List<Customer> getCustomers(){
        return service.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id){
        return service.getCustomer(id);
    }

    @GetMapping(path = "{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId") Long id){
        throw new ApiRequestException(ApiRequestException.class.getSimpleName()+ " for customer " + id);
    }

    @PostMapping
    void createNewCustomer(@RequestBody @Valid Customer customer){
        System.out.println("UPDATE REQUEST...");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer){
        System.out.println("PUT REQUEST...");
        System.out.println(customer);
    }

    @DeleteMapping(path ="{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID " + id);
    }
}
