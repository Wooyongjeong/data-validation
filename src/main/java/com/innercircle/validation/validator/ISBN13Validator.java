package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.ISBN13;
import com.innercircle.validation.exception.ValidatorException;
import com.innercircle.validation.util.StringValidationUtil;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class ISBN13Validator implements Validator {
    private static final Pattern PATTERN = Pattern.compile(
            "^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)97[89][- ]?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9]$"
    );

    @Override
    public void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException {
        ISBN13 annotation = field.getAnnotation(ISBN13.class);
        StringValidationUtil.validate(field, obj, PATTERN, annotation.message());
    }
}
