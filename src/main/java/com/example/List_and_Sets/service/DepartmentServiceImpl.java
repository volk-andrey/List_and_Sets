package com.example.List_and_Sets.service;

import com.example.List_and_Sets.Employee;
import com.example.List_and_Sets.exeption.EmployeeNotFoundExeption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
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
        return getStreamEmployeeByDepartment(departmentId)
                .toList();
    }

    @Override
    public long getSumOfSalaryByDepartment(int departmentId) {
        return getStreamEmployeeByDepartment(departmentId)
                .mapToLong(Employee::getSalary)
                .sum();
    }

    @Override
    public long getMaxOfSalaryByDepartment(int departmentId) {
        return getStreamEmployeeByDepartment(departmentId)
                .mapToLong(Employee::getSalary)
                .max()
                .orElseThrow(() -> new EmployeeNotFoundExeption());
    }

    @Override
    public long getMinOfSalaryByDepartment(int departmentId) {
        return getStreamEmployeeByDepartment(departmentId)
                .mapToLong(Employee::getSalary)
                .min()
                .orElseThrow((()-> new EmployeeNotFoundExeption()));
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
