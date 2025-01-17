package com.example.demo.customer;

import java.util.Arrays;
import java.util.List;

//@Repository(value = "fake")
public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "James Bond", "password123", "jamesbond@email.com"),
                new Customer(2L, "Jamila Abad", "123password", "jamilaabad@email.com")
        );
    }
}
