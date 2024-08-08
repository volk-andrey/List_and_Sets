package com.example.List_and_Sets.service;

import com.example.List_and_Sets.Employee;
import com.example.List_and_Sets.exeption.EmployeeAlreadeyAddedInListExeption;
import com.example.List_and_Sets.exeption.EmployeeNotFoundInListExeption;
import com.example.List_and_Sets.exeption.EmployeeStorageFullListExeption;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final int STORAGE_SIZE = 5;
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("John", "Smith"),
            new Employee("Jane", "Doe"),
            new Employee("Mary", "Jones"),
            new Employee("Bob", "Smith"),
            new Employee("Jim", "Smith")
    ));

    @Override
    public Employee addEmployee(String firstName, String lastName) throws EmployeeAlreadeyAddedInListExeption, EmployeeStorageFullListExeption {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() > STORAGE_SIZE) {
            throw new EmployeeStorageFullListExeption();
        }

        if (employees.contains(employee)) {
            throw new EmployeeAlreadeyAddedInListExeption();

        }

        employees.add(employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundInListExeption {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundInListExeption();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundInListExeption {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundInListExeption();
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

}
