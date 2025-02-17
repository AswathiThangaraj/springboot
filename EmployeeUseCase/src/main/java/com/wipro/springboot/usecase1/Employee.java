package com.wipro.springboot.usecase1;

import jakarta.persistence.Entity; // Jakarta Persistence API for defining entity classes, replacing javax.persistence in the newer Jakarta EE.
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Marks this class as a JPA entity, meaning it is mapped to a database table.
public class Employee {
    @Id // Marks the 'id' field as the primary key in the database.
    
 // Specifies that the ID should be automatically generated using the identity strategy.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;

    // Getters and Setters
    public Long getId() {
        return id; // Returns the employee's ID.
    }

    public void setId(Long id) {
        this.id = id; // Sets the employee's ID.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}