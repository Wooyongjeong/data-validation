package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.MACAddress;
import com.innercircle.validation.exception.ValidatorException;
import com.innercircle.validation.util.StringValidationUtil;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class MACAddressValidator implements Validator {

    private static Pattern pattern = Pattern.compile(
            "^([0-9a-fA-F]{2}:){5}[0-9a-fA-F]{2}$"
    );

    @Override
    public void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException {
        MACAddress annotation = field.getAnnotation(MACAddress.class);
        StringValidationUtil.validate(field, obj, pattern, annotation.message());
    }
}
