package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
class Customer {
    @Id
    private Long id;
    @NotBlank(message = "Name must be not blank")
    private String name;
    @NotBlank(message = "Password must be not blank")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Email(message = "email must be valid")
    private String email;

    Customer(String name, String password, String email) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return id != null && Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
