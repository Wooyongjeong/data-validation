package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.IPv4;
import com.innercircle.validation.exception.ValidatorException;
import com.innercircle.validation.util.StringValidationUtil;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class IPv4Validator implements Validator {
    private static Pattern pattern = null;

    @Override
    public void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException {
        IPv4 annotation = field.getAnnotation(IPv4.class);
        if(pattern == null) {
            pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})\\."
                    + "(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})\\."
                    + "(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})\\."
                    + "(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2}))$");
        }
        StringValidationUtil.validate(field, obj, pattern, annotation.invalidFormatMessage());
    }
}
