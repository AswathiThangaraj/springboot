package com.wipro.springboot.usecase1;

import org.springframework.data.jpa.repository.JpaRepository; // Importing JpaRepository interface from Spring Data JPA to provide CRUD operations for the entity.
import org.springframework.stereotype.Repository; // Importing Repository annotation to indicate that this interface is a repository bean.

@Repository // Marks this interface as a Spring Data JPA repository, making it available for Spring's dependency injection.

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
// JpaRepository provides default methods for performing CRUD operations (create, read, update, delete) on the Employee entity.
    
    // Custom query method to find an employee by their name.
    Employee findByName(String name); // Finds and returns an Employee by the given name.
}