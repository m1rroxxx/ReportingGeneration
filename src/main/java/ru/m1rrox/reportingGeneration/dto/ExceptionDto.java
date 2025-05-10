package ru.m1rrox.reportingGeneration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ExceptionDto {
    private int code;
    private HttpStatus status;
    private String message;
}
