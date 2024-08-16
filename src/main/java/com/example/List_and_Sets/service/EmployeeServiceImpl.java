package com.example.List_and_Sets.service;

import com.example.List_and_Sets.Employee;
import com.example.List_and_Sets.exeption.EmployeeAlreadeyAddedExeption;
import com.example.List_and_Sets.exeption.EmployeeNotFoundExeption;
import com.example.List_and_Sets.exeption.EmployeeStorageFullExeption;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final int STORAGE_SIZE = 5;
    private final Map<String, Employee> employees = new HashMap<>(Map.of(
            "ИванИвановИванович",
            new Employee("Иван", "Иванов", "Иванович"),
            "ГорбуновЕмельянСтаниславович",
            new Employee("Горбунов", "Емельян", "Станиславович"),
            "ЩербаковВелорийФедорович",
            new Employee("Щербаков", "Велорий", "Федорович"),
            "ЗиминЮлианМартынович",
            new Employee("Зимин", "Юлиан","Мартынович"),
            "КалашниковГеннадийФедотович",
            new Employee("Калашников", "Геннадий","Федотович")
    ));

    @Override
    public Employee addEmployee(String firstName, String lastName, String serName) throws EmployeeAlreadeyAddedExeption, EmployeeStorageFullExeption {
        Employee employee = new Employee(firstName, lastName, serName);
        String checkEmployee = firstName + lastName + serName;
        if (employees.containsKey(checkEmployee)) {
            System.out.println("Employee already exists");
            throw new EmployeeAlreadeyAddedExeption();
        }
        if (employees.size() == STORAGE_SIZE) {
            System.out.println("Employee storage is full");
            throw new EmployeeStorageFullExeption();
        }
        employees.put(checkEmployee, employee);
        System.out.println("Employee added successfully");
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName, String serName) throws EmployeeNotFoundExeption {
        Employee employee = new Employee(firstName, lastName, serName);
        String checkEmployee = firstName + lastName + serName;
        if (employees.containsKey(checkEmployee)) {
            employees.remove(checkEmployee);
            return employee;
        }
        throw new EmployeeNotFoundExeption();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, String serName) throws EmployeeNotFoundExeption {
        Employee employee = new Employee(firstName, lastName, serName);
        String checkEmployee = firstName + lastName + serName;
        if (employees.containsKey(checkEmployee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundExeption();
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employee = new ArrayList<>(employees.values());
        return  employee;
    }

}
