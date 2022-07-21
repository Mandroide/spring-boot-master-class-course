package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

class Customer {
    private final Long id;
    @NotBlank(message = "Name must be not blank")
    private final String name;
    @NotBlank(message = "Password must be not blank")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private final String password;

    @Email(message = "email must be valid")
    private final String email;

    Customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @JsonProperty("customerId")
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
