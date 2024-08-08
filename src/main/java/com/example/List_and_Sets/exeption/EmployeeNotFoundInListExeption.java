package com.example.List_and_Sets.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Сотрудник не найден в списке")
public class EmployeeNotFoundInListExeption extends RuntimeException{
    public EmployeeNotFoundInListExeption() {
        super("Сотрудник не найден в списке");
    }
}
