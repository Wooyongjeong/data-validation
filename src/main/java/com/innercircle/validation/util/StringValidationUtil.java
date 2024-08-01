package com.innercircle.validation.util;

import com.innercircle.validation.exception.ValidatorException;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class StringValidationUtil {

    private static final String INVALID_TYPE_MESSAGE = "Field must be String";

    public static void validate(Field field, Object obj, Pattern pattern, String invalidFormatMessage) throws ValidatorException, IllegalAccessException {
        Object value = field.get(obj);
        if(!(value instanceof String)) {
            throw new ValidatorException(INVALID_TYPE_MESSAGE);
        }
        if (!pattern.matcher((String)value).matches()) {
            throw new ValidatorException(invalidFormatMessage);
        }
    }
}
