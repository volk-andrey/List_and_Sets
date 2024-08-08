package com.example.List_and_Sets.exeption;

public class EmployeeNotFoundInListExeption extends RuntimeException{
    public EmployeeNotFoundInListExeption(String message) {
        super(message);
    }
}
