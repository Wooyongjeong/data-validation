package com.innercircle.validation.validator;

import com.innercircle.validation.exception.ValidatorException;

import java.lang.reflect.Field;

public interface Validator {
    void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException;
}
