package org.app.fizzbuzzapp.exception;

import jakarta.validation.ValidationException;
import org.app.fizzbuzzapp.model.AppError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        final var errors = ex.getBindingResult().getAllErrors().stream().map(err-> new AppError(err.getDefaultMessage(), HttpStatus.BAD_REQUEST.value()))
                .collect(Collectors.toUnmodifiableSet());

        return handleExceptionInternal(ex, errors, headers, status, request);
    }
}
