package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.CustomRegex;
import com.innercircle.validation.exception.ValidatorException;
import com.innercircle.validation.util.StringValidationUtil;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class CustomRegexValidator implements Validator {
    private static Pattern pattern = null;
    @Override
    public void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException {
        CustomRegex annotation = field.getAnnotation(CustomRegex.class);
        if(pattern == null) {
            pattern = Pattern.compile(annotation.regex());
        }
        StringValidationUtil.validate(field, obj, pattern, annotation.invalidFormatMessage());
    }
}
