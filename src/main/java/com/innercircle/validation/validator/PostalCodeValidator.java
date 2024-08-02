package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.PostalCode;
import com.innercircle.validation.exception.ValidatorException;
import com.innercircle.validation.util.StringValidationUtil;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class PostalCodeValidator implements Validator {
    private static Pattern pattern = null;
    @Override
    public void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException {
        PostalCode annotation = field.getAnnotation(PostalCode.class);
        if(pattern == null) {
            pattern = Pattern.compile("^[0-9]{5}$");
        }
        StringValidationUtil.validate(field, obj, pattern, annotation.invalidFormatMessage());
    }
}
