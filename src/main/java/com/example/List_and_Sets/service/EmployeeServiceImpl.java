package com.example.List_and_Sets.service;

import com.example.List_and_Sets.Employee;
import com.example.List_and_Sets.exeption.EmployeeAlreadeyAddedExeption;
import com.example.List_and_Sets.exeption.EmployeeNotFoundExeption;
import com.example.List_and_Sets.exeption.EmployeeStorageFullExeption;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private static final int STORAGE_SIZE = 10;
    private final Map<String, Employee> employees = new HashMap<>(Map.of(
//            "ИванИвановИванович",
//            new Employee("Иван", "Иванов", "Иванович", 1, 100_000),
//            "ГорбуновЕмельянСтаниславович",
//            new Employee("Горбунов", "Емельян", "Станиславович", 2, 200_000),
//            "ЩербаковВелорийФедорович",
//            new Employee("Щербаков", "Велорий", "Федорович", 3, 300_000),
//            "ЗиминЮлианМартынович",
//            new Employee("Зимин", "Юлиан","Мартынович",3, 400_000),
//            "КалашниковГеннадийФедотович",
//            new Employee("Калашников", "Геннадий","Федотович",5, 500_000)
    ));

    @Override
    public Employee addEmployee(String firstName, String lastName, String serName, long salary, int department) throws EmployeeAlreadeyAddedExeption, EmployeeStorageFullExeption {
        Employee employee = new Employee(firstName, lastName, serName, department, salary);
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
        String checkEmployee = firstName + lastName + serName;
        if (employees.containsKey(checkEmployee)) {
            Employee e = employees.get(checkEmployee);
            employees.remove(checkEmployee);
            System.out.println("Employee removed successfully");
            return e;
        }
        throw new EmployeeNotFoundExeption();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, String serName) throws EmployeeNotFoundExeption {
//        Employee employee = new Employee(firstName, lastName, serName);
        String checkEmployee = firstName + lastName + serName;
        if (employees.containsKey(checkEmployee)) {
            return employees.get(checkEmployee);
        } else {
            throw new EmployeeNotFoundExeption();
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employee = new ArrayList<>(employees.values());
        return  employee;
    }

    @Override
    public Employee getDepartamentMinSalary(int department) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartament() == department)
                .min(Comparator.comparingLong(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundExeption());
    }

    @Override
    public Employee getDepartamentMaxSalary(int department) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartament() == department)
                .max(Comparator.comparingLong(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundExeption());
    }

    @Override
    public List<Employee> getDepartamentAll(int department){
        return employees.values().stream()
                .filter(employee -> employee.getDepartament() == department)
                .collect(Collectors.toList());
    }
    @Override
    public List<Employee> getDepartamentAllSorted(){
        List<Employee> e = new ArrayList<>(employees.values());
        e.sort(Comparator.comparing(Employee::getDepartament));
        return e;
    }

}
