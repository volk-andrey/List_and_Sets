package com.example.List_and_Sets.controller;

import com.example.List_and_Sets.Employee;
import com.example.List_and_Sets.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable("id") int id) {
        return departmentService.getEmployeesByDepartment(id);
    }

    @GetMapping("/{id}/salary/sum")
    public long getSumOfSalaryByDepartment(@PathVariable("id") int id) {
        return departmentService.getSumOfSalaryByDepartment(id);
    }
    @GetMapping("/{id}/salary/max")
    public long getMaxOfSalaryByDepartment(@PathVariable("id") int id) {
        return departmentService.getMaxOfSalaryByDepartment(id);
    }
    @GetMapping("/{id}/salary/min")
    public long getMinOfSalaryByDepartment(@PathVariable("id") int id) {
        return departmentService.getMinOfSalaryByDepartment(id);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getDepartamentEmployeesBySalary() {
        return departmentService.getDepartamentEmployeesBySalary();
    }
}

