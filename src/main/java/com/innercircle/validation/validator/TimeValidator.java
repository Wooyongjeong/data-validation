package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.IPv6;
import com.innercircle.validation.annotation.Time;
import com.innercircle.validation.exception.ValidatorException;
import com.innercircle.validation.util.StringValidationUtil;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class TimeValidator implements Validator {
    private static final Pattern PATTERN = Pattern.compile(
            "(?:오전|오후|AM|PM)?\\s*(1[0-2]|0?[1-9]):([0-5]?[0-9])(?::([0-5]?[0-9]))?\\s*(?:오전|오후|AM|PM)?\\b|(?:[01]?[0-9]|2[0-3]):([0-5]?[0-9])(?::([0-5]?[0-9]))?(?:\\s*(?:오전|오후|AM|PM) )?\\b"
    );

    @Override
    public void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException {
        Time annotation = field.getAnnotation(Time.class);
        StringValidationUtil.validate(field, obj, PATTERN, annotation.message());
    }
}
