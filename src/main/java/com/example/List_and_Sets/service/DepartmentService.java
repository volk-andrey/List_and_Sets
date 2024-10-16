package com.example.List_and_Sets.service;

import com.example.List_and_Sets.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Employee> getEmployeesByDepartment(int departmentId);

    long getSumOfSalaryByDepartment(int departmentId);

    long getMaxOfSalaryByDepartment(int departmentId);

    long getMinOfSalaryByDepartment(int departmentId);

    Map<Integer, List<Employee>> getDepartamentEmployeesBySalary();
}
