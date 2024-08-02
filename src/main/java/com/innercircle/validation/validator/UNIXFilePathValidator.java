package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.UNIXFilePath;
import com.innercircle.validation.exception.ValidatorException;
import com.innercircle.validation.util.StringValidationUtil;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class UNIXFilePathValidator implements Validator {
    private static final Pattern PATTERN = Pattern.compile(
            "^(/|~/|\\./|\\.\\./)(([a-zA-Z0-9_-]+/?)|(.{1,2})+/?)*$"
    );

    @Override
    public void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException {
        UNIXFilePath annotation = field.getAnnotation(UNIXFilePath.class);
        StringValidationUtil.validate(field, obj, PATTERN, annotation.message());
    }
}
