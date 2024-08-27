package com.example.List_and_Sets.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Сотрудник не найден в списке")
public class EmployeeNotFoundExeption extends RuntimeException{
    public EmployeeNotFoundExeption() {
        super("Сотрудник не найден в списке");
    }
}
