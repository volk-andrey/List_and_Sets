package com.example.List_and_Sets.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Список сотрудников полон")
public class EmployeeStorageFullListExeption extends RuntimeException{
    public EmployeeStorageFullListExeption() {
        super("Список сотрудников полон");
    }
}
