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
            throw new EmployeeStorageFullListExeption("Хранилище заполнено");
        }

        if (employees.contains(employee)) {
            throw new EmployeeAlreadeyAddedInListExeption("Сотрудник уже добавлен в хранилище");
        }

        employees.add(employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundInListExeption {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundInListExeption("Сотрудник не найден в хранилище");
        }

        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundInListExeption {
        Employee employeeFind = new Employee(firstName, lastName);
        if (employees.contains(employeeFind)) {
            throw new EmployeeNotFoundInListExeption("Сотрудник не найден в хранилище");
        }
        for (Employee employee : employees) {
            if (employee.equals(employeeFind)){
                return employee;
            }
        }
        return employeeFind;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

}
