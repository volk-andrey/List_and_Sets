package com.example.List_and_Sets.service;

import com.example.List_and_Sets.Employee;
import com.example.List_and_Sets.exeption.EmployeeAlreadeyAddedExeption;
import com.example.List_and_Sets.exeption.EmployeeNotFoundExeption;
import com.example.List_and_Sets.exeption.EmployeeStorageFullExeption;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService  {
    Employee addEmployee(String firstName, String lastName, String serName, long salary, int department) throws EmployeeAlreadeyAddedExeption, EmployeeStorageFullExeption;

    Employee findEmployee(String firstName, String lastName, String serName) throws EmployeeNotFoundExeption;

    Employee removeEmployee(String firstname, String lastname, String serName);

    List<Employee> getAllEmployees();

    Employee getDepartamentMinSalary(int department);

    Employee getDepartamentMaxSalary(int department);

    List<Employee> getDepartamentAll(int department);

    List<Employee> getDepartamentAllSorted();
}
