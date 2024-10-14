package com.example.List_and_Sets.service;

import com.example.List_and_Sets.Employee;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(int departmentId) {
        return this.getStreamEmployeeByDepartment(departmentId)
                .toList();
    }

    @Override
    public long getSumOfSalaryByDepartment(int departmentId) {
        return this.getStreamEmployeeByDepartment(departmentId)
                .mapToLong(Employee::getSalary)
                .sum();
    }

    @Override
    public long getMaxOfSalaryByDepartment(int departmentId) {
        return this.getStreamEmployeeByDepartment(departmentId)
                .mapToLong(Employee::getSalary)
                .max()
                .orElseThrow();
    }

    @Override
    public long getMinOfSalaryByDepartment(int departmentId) {
        return this.getStreamEmployeeByDepartment(departmentId)
                .mapToLong(Employee::getSalary)
                .min()
                .orElseThrow();
    }

    @Override
    public Map<Integer, List<Employee>> getDepartamentEmployeesBySalary() {
        return employeeService.getAllEmployees()
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Employee::getDepartament));
    }

    private Stream<Employee> getStreamEmployeeByDepartment(int departmentId) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getDepartament() == departmentId);
    }
}
