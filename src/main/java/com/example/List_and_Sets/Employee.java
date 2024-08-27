package com.example.List_and_Sets;
import java.util.List;
import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String serName;
    private final int departament;
    private final long salary;


    public Employee(String firstName, String lastName, String serName, int departament, long salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.serName = serName;
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
}

