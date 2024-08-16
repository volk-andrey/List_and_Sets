package com.example.List_and_Sets;
import java.util.List;
import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String serName;


    public Employee(String firstName, String lastName, String serName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.serName = serName;
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

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", serName='" + serName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(serName, employee.serName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, serName);
    }
}

