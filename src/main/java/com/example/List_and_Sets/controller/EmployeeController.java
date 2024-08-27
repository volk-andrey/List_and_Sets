package com.example.List_and_Sets.controller;

import com.example.List_and_Sets.Employee;
import com.example.List_and_Sets.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
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
        @RequestParam("lastName") String lastname,
        @RequestParam("serName") String sername,
        @RequestParam("salary") long salary,
        @RequestParam("department") int department

    ){
        return employeeService.addEmployee(firstname,lastname,sername,salary,department);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(
            @RequestParam("firstName") String firstname,
            @RequestParam("lastName") String lastname,
            @RequestParam("serName") String sername
    ){
        return employeeService.removeEmployee(firstname,lastname,sername);
    }
    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstname,
            @RequestParam("lastName") String lastname,
            @RequestParam("serName") String sername
    ){
        return employeeService.findEmployee(firstname,lastname,sername);
    }

    @GetMapping("/allEmployees")
    public List<Employee> allEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/department/min-salary")
    public Employee getDepartamentMinSalary(@RequestParam("department") int department){
        return employeeService.getDepartamentMinSalary(department);
    }
    @GetMapping("/department/max-salary")
    public Employee getDepartamentMaxSalary(@RequestParam("department") int department){
        return employeeService.getDepartamentMaxSalary(department);
    }
    @GetMapping("/department/all")
    public List<Employee> getDepartamentAll(@RequestParam(defaultValue = "125") int department){
        if (department == 125){
            return employeeService.getDepartamentAllSorted();
        } else {
            return employeeService.getDepartamentAll(department);
        }
    }
}
