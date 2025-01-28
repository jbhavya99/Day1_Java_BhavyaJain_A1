package org.example;

import org.example.core.Employee;
import org.example.data.EmployeeRepository;
import org.example.logging.LoggerUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static void clearLogFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("logs/application.log"))) {
            writer.write(""); // Overwrite the file with an empty string
        } catch (IOException e) {
            System.err.println("Error clearing the log file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        clearLogFile(); // Clear the log file at the start
        // Create an instance of EmployeeRepository
        EmployeeRepository repository = new EmployeeRepository();

        // Add employees
        Employee emp1 = new Employee(1, "Ram", 28, "Engineering");
        Employee emp2 = new Employee(2, "Shyam", 35, "Marketing");
        Employee emp3 = new Employee(3, "Kirti", 30, "Sales");

        repository.addEmployee(emp1);
        repository.addEmployee(emp2);
        repository.addEmployee(emp3);

        LoggerUtil.log("INFO", "Initial employees added to the repository.");

        // Retrieve employee by ID
        Employee retrievedById = repository.getEmployeeById(2);
        if (retrievedById != null) {
            LoggerUtil.log("INFO", "Retrieved Employee by ID: " + retrievedById);
        }

        // Retrieve employee by name
        Employee retrievedByName = repository.getEmployeeByName("Ram");
        if (retrievedByName != null) {
            LoggerUtil.log("INFO", "Retrieved Employee by Name: " + retrievedByName);
        }

        // Update employee by ID
        boolean isUpdatedById = repository.updateEmployeeById(3, "Kirti", 31, "Customer Service");
        if (isUpdatedById) {
            LoggerUtil.log("INFO", "Updated Employee with ID 3.");
        }

        // Update employee by name
        boolean isUpdatedByName = repository.updateEmployeeByName("Shyam", "ROBERTMKILLY", 36, "Digital Marketing");
        if (isUpdatedByName) {
            LoggerUtil.log("INFO", "Updated Employee with Name 'Shyam'.");
        }

        // Attempt to retrieve a non-existent employee
        Employee nonExistentEmployee = repository.getEmployeeByName("DogaRam");
        if (nonExistentEmployee == null) {
            LoggerUtil.log("ERROR", "Attempted to retrieve a non-existent employee.");
        }

        // Attempt to add more employees to exceed the repository limit
        for (int i = 4; i <= 105; i++) {
            repository.addEmployee(new Employee(i, "Employee" + i, 25 + i % 10, "Department" + i));
        }

        LoggerUtil.log("INFO", "Main operations completed. Check the logs for details.");
    }
}
