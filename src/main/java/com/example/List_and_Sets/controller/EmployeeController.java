package com.example.List_and_Sets.controller;

import com.example.List_and_Sets.Employee;
import com.example.List_and_Sets.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee addEmployee(
        @RequestParam("firstName") String firstname,
        @RequestParam("lastName") String lastname
    ){
        return employeeService.addEmployee(firstname,lastname);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(
            @RequestParam("firstName") String firstname,
            @RequestParam("lastName") String lastname
    ){
        return employeeService.removeEmployee(firstname,lastname);
    }
    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstname,
            @RequestParam("lastName") String lastname
    ){
        return employeeService.findEmployee(firstname,lastname);
    }

    @GetMapping("/allEmployees")
    public List<Employee> allEmployees(){
        return employeeService.getAllEmployees();
    }
}
