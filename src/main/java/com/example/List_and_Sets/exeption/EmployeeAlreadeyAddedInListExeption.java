package com.example.List_and_Sets.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Сотрудник уже добавлен в список")
public class EmployeeAlreadeyAddedInListExeption extends RuntimeException{
    public EmployeeAlreadeyAddedInListExeption(){
        super("Сотрудник уже добавлен в список");
    }
}
