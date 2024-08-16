package com.example.List_and_Sets.service;

import com.example.List_and_Sets.Employee;
import com.example.List_and_Sets.exeption.EmployeeAlreadeyAddedExeption;
import com.example.List_and_Sets.exeption.EmployeeNotFoundExeption;
import com.example.List_and_Sets.exeption.EmployeeStorageFullExeption;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface EmployeeService  {
    Employee addEmployee(String firstName, String lastName, String serName) throws EmployeeAlreadeyAddedExeption, EmployeeStorageFullExeption;

    Employee findEmployee(String firstName, String lastName, String serName) throws EmployeeNotFoundExeption;

    Employee removeEmployee(String firstname, String lastname, String serName);

    List<Employee> getAllEmployees();
}
