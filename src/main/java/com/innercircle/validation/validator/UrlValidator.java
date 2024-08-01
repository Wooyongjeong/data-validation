package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.PhoneNumber;
import com.innercircle.validation.annotation.URL;
import com.innercircle.validation.exception.ValidatorException;
import com.innercircle.validation.util.StringValidationUtil;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class UrlValidator implements Validator {

    private static Pattern pattern = null;

    @Override
    public void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException {
        URL annotation = field.getAnnotation(URL.class);
        if(pattern == null) {
            pattern = Pattern.compile("^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$");
        }
        StringValidationUtil.validate(field, obj, pattern, annotation.invalidFormatMessage());
    }
}
