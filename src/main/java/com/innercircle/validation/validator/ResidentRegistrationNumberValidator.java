package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.ResidentRegistrationNumber;
import com.innercircle.validation.exception.ValidatorException;

import java.lang.reflect.Field;

public class ResidentRegistrationNumberValidator implements Validator {
    private static final String TYPE_ERROR_MESSAGE = "Resident Registration Number should be a string.";
    private static final String PATTERN = "^\\d{2}([0]\\d|[1][0-2])([0][1-9]|[1-2]\\d|[3][0-1])[-]*[1-4]\\d{6}$";

    @Override
    public void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException {
        if (!(field.get(obj) instanceof String value)) {
            throw new ValidatorException(TYPE_ERROR_MESSAGE);
        }
        ResidentRegistrationNumber annotation = field.getAnnotation(ResidentRegistrationNumber.class);
        if (!value.matches(PATTERN)) {
            throw new ValidatorException(annotation.message());
        }
    }
}
