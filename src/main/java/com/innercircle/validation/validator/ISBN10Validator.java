package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.ISBN10;
import com.innercircle.validation.exception.ValidatorException;
import com.innercircle.validation.util.StringValidationUtil;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class ISBN10Validator implements Validator {
    private static final Pattern PATTERN = Pattern.compile(
            "^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$"
    );

    @Override
    public void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException {
        ISBN10 annotation = field.getAnnotation(ISBN10.class);
        StringValidationUtil.validate(field, obj, PATTERN, annotation.message());
    }
}
