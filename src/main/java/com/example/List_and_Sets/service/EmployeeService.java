package com.example.List_and_Sets.service;

import com.example.List_and_Sets.Employee;
import com.example.List_and_Sets.exeption.EmployeeAlreadeyAddedInListExeption;
import com.example.List_and_Sets.exeption.EmployeeNotFoundInListExeption;
import com.example.List_and_Sets.exeption.EmployeeStorageFullListExeption;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService  {
    Employee addEmployee(String firstName, String lastName) throws EmployeeAlreadeyAddedInListExeption, EmployeeStorageFullListExeption;

    Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundInListExeption;

    Employee removeEmployee(String firstname, String lastname);

    List<Employee> getAllEmployees();
}
