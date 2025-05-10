package ru.m1rrox.reportingGeneration.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.m1rrox.reportingGeneration.dto.ExceptionDto;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String PROBLEM_DELIMITER = "problem: ";

    @ExceptionHandler(UnsupportedFormatException.class)
    public ExceptionDto handleUnsupportedFormatException(UnsupportedFormatException exception) {
        return new ExceptionDto(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ExceptionDto handleHttpMessageNotReadable(HttpMessageNotReadableException exception) {

        Throwable rootCause = exception.getMostSpecificCause();
        if (rootCause instanceof UnsupportedFormatException) {
            String message = exception.getMessage().split(PROBLEM_DELIMITER, 2)[1];
            return new ExceptionDto(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, message);
        }

        throw exception;
    }
}
