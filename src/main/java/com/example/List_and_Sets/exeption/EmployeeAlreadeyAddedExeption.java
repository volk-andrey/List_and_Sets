package com.example.List_and_Sets.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Сотрудник уже добавлен в список")
public class EmployeeAlreadeyAddedExeption extends RuntimeException{
    public EmployeeAlreadeyAddedExeption(){
        super("Сотрудник уже добавлен в список");
    }
}
