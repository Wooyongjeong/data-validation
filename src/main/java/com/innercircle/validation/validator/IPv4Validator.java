package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.IPv4;
import com.innercircle.validation.exception.ValidatorException;
import com.innercircle.validation.util.StringValidationUtil;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class IPv4Validator implements Validator {
    private static final Pattern PATTERN = Pattern.compile(
            "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]).){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$"
    );

    @Override
    public void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException {
        IPv4 annotation = field.getAnnotation(IPv4.class);
        StringValidationUtil.validate(field, obj, PATTERN, annotation.message());
    }
}
