package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CustomerServiceTest {
    @Autowired
    private CustomerRepository repository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(repository);
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void getCustomers(){
        Customer jamila = new Customer(1L,
                "Jamila",
                "hello",
                "jamila@example.com");
        Customer ali = new Customer(2L,
                "Ali",
                "hello",
                "ali@example.com");
        repository.saveAll(List.of(jamila, ali));

        List<Customer> customers = underTest.getCustomers();

        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer(){
        long id = 1L;
        String name = "Jamila";
        String password = "hello";
        String email = "jamila@example.com";
        Customer jamila = new Customer(id,
                name,
                password,
                email);
        repository.save(jamila);

        Customer actual = underTest.getCustomer(id);

        assertEquals(id, actual.getId());
        assertEquals(name, actual.getName());
        assertEquals(password, actual.getPassword());
        assertEquals(email, actual.getEmail());
    }
}

