package org.example.data;

import org.example.core.Employee;
import org.example.logging.LoggerUtil;

public class EmployeeRepository {
    private Employee[] employees = new Employee[100]; // Array to store employees
    private int count = 0; // Tracks the number of employees added

    // ADD EMPLOYEE
    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
            LoggerUtil.log("INFO", "Employee added: " + employee);
        } else {
            LoggerUtil.log("ERROR", "Cannot add employee. Repository is full.", new Exception("Repository Full"));
        }
    }

    // GET EMPLOYEE BY NAME
    public Employee getEmployeeByName(String name) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getName().equalsIgnoreCase(name)) {
                LoggerUtil.log("INFO", "Employee retrieved by Name: " + name);
                return employees[i];
            }
        }
        LoggerUtil.log("ERROR", "Employee not found with Name: " + name, new Exception("Employee Not Found"));
        return null;
    }

    // GET EMPLOYEE BY ID
    //overloading
    public Employee getEmployeeById(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getId() == id) {
                LoggerUtil.log("INFO", "Employee retrieved by ID: " + id);
                return employees[i];
            }
        }
        LoggerUtil.log("ERROR", "Employee not found with ID: " + id, new Exception("Employee Not Found"));
        return null;
    }

    // UPDATE EMPLOYEE BY ID
    public boolean updateEmployeeById(int id, String name, int age, String department) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employee.setName(name);
            employee.setAge(age);
            employee.setDepartment(department);
            LoggerUtil.log("INFO", "Employee updated with ID: " + id);
            return true;
        }
        LoggerUtil.log("ERROR", "Employee not found with ID: " + id, new Exception("Update Failed"));
        return false;
    }

    // UPDATE EMPLOYEE BY NAME
    //overloading
    public boolean updateEmployeeByName(String oldName, String newName, int newAge, String newDepartment) {
        Employee employee = getEmployeeByName(oldName);
        if (employee != null) {
            employee.setName(newName);
            employee.setAge(newAge);
            employee.setDepartment(newDepartment);
            LoggerUtil.log("INFO", "Employee updated with Name: " + oldName);
            return true;
        }
        LoggerUtil.log("ERROR", "Employee not found with Name: " + oldName, new Exception("Update Failed"));
        return false;
    }
}
