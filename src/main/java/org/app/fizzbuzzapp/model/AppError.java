package org.app.fizzbuzzapp.model;

public record AppError(
        String message,
        int code
){}