package com.example.List_and_Sets.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Неверный запрос")
public class BadRequestExeption extends RuntimeException {
    public BadRequestExeption() {
        super("Неверный запрос");
    }
}
