package com.innercircle.validation.exception;

public class ValidatorException extends RuntimeException {
    public ValidatorException(String message) {
        super("Data validation failed : " + message);
    }
}
