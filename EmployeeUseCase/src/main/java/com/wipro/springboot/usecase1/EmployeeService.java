package com.wipro.springboot.usecase1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    // Autowired the EmployeeRepository to interact with the database
    @Autowired
    private EmployeeRepository employeeRepository;

    // Role Map using HashMap to standardize employee roles
    private static final Map<String, String> roleMap = new HashMap<>();

    // Initialize roleMap with predefined roles
    static {
        roleMap.put("developer", "Developer");
        roleMap.put("tester", "Tester");
        roleMap.put("architect", "Architect");
    }

    // Method to save a new employee
    // This method sets a valid role based on the provided role and saves the employee in the database
    public Employee saveEmployee(Employee employee) {
        // Convert the role to lowercase to standardize it
        String role = employee.getRole().toLowerCase();
        // Check if the role exists in the predefined roleMap, and set the role accordingly
        if (roleMap.containsKey(role)) {
            employee.setRole(roleMap.get(role));
        }
        // Save the employee to the database and return the saved employee
        return employeeRepository.save(employee);
    }

    // Method to update an existing employee by ID
    // This method finds the employee by ID and updates their details
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        // Find the employee by ID, or throw an exception if not found
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        
        // Update employee details
        employee.setName(employeeDetails.getName());
        
        // Convert the role to lowercase to standardize it and set the role if it's valid
        String role = employeeDetails.getRole().toLowerCase();
        if (roleMap.containsKey(role)) {
            employee.setRole(roleMap.get(role));
        }
        
        // Save the updated employee to the database and return the updated employee
        return employeeRepository.save(employee);
    }
    
    // Method to retrieve a list of all employees
    // This method returns all employees present in the database
    public List<Employee> getAllEmployees() {
        // Return the list of all employees from the repository
        return employeeRepository.findAll();
    }

    // Method to retrieve an employee by ID
    // This method fetches the employee with the given ID from the database
    public Employee getEmployeeById(Long id) {
        // Find the employee by ID, if not found, throw an exception
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RuntimeException("Employee not found");
        }
    }
    
    // Method to delete an employee by ID
    // This method finds the employee by ID and deletes it from the database
    public void deleteEmployee(Long id) {
        // Find the employee by ID, or throw an exception if not found
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        
        // Delete the employee from the repository
        employeeRepository.delete(employee);
    }
}