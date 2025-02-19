package com.wipro.springboot.usecase1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	// Autowire the EmployeeService to handle business logic
    @Autowired
    private EmployeeService employeeService;

    // Endpoint to add a new employee
    // POST request to '/employee/add' with the employee details in the request body
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
    	// Check if the role is provided, throw an exception if not
        if (employee.getRole() == null || employee.getRole().isEmpty()) {
            throw new IllegalArgumentException("Role is required");
        }
        // Save the new employee using the employeeService
        return employeeService.saveEmployee(employee);
    }


    // Endpoint to update an employee by ID
    // PUT request to '/employee/update/{id}' with the updated employee details in the request body
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
    	// Update the employee using the service and return the updated employee
        return employeeService.updateEmployee(id, employeeDetails);
    }

    // Endpoint to get an employee by ID
    // GET request to '/employee/{id}' to retrieve the employee details by their ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Endpoint to get all employees
    // GET request to '/employee/all' to retrieve a list of all employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
    	// Return the list of all employees from the service
        return employeeService.getAllEmployees();
    }
    
    // Endpoint to delete an employee by ID
    // DELETE request to '/employee/delete/{id}' to remove the employee by their ID
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
    	// Delete the employee by ID using the service
        employeeService.deleteEmployee(id);
       // Return a message confirming the employee has been deleted
        return "Employee with ID " + id + " has been deleted";
    }
}
