package com.example.List_and_Sets;
import com.example.List_and_Sets.exeption.BadRequestExeption;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String serName;
    private final int departament;
    private final long salary;


    public Employee(String firstName, String lastName, String serName, int departament, long salary) {
        this.firstName = checkInput(firstName);
        this.lastName = checkInput(lastName);
        this.serName = checkInput(serName);
        this.departament = departament;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSerName() {
        return serName;
    }

    public int getDepartament() {
        return departament;
    }

    public long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", serName='" + serName + '\'' +
                ", salary=" + salary + '\'' +
                ", departament=" + departament + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && departament == employee.departament && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(serName, employee.serName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, serName, salary, departament);
    }

    private String checkInput(String string){
        if (StringUtils.containsAny(string,"0123456789!@#$%&*()_+-=")){
            throw new BadRequestExeption();
        }
        return StringUtils.capitalize(StringUtils.lowerCase(string));
    }
}

