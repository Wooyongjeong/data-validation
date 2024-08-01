package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.IPv6;
import com.innercircle.validation.exception.ValidatorException;
import com.innercircle.validation.util.StringValidationUtil;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class IPv6Validator implements Validator {
    private static final Pattern PATTERN = Pattern.compile(
            "^(([0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4}|([0-9A-Fa-f]{1,4}:){1,7}:|([0-9A-Fa-f]{1,4}:){1,6}:[0-9A-Fa-f]{1,4}|([0-9A-Fa-f]{1,4}:){1,5}(:[0-9A-Fa-f]{1,4}){1,2}|([0-9A-Fa-f]{1,4}:){1,4}(:[0-9A-Fa-f]{1,4}){1,3}|([0-9A-Fa-f]{1,4}:){1,3}(:[0-9A-Fa-f]{1,4}){1,4}|([0-9A-Fa-f]{1,4}:){1,2}(:[0-9A-Fa-f]{1,4}){1,5}|[0-9A-Fa-f]{1,4}:((:[0-9A-Fa-f]{1,4}){1,6})|:((:[0-9A-Fa-f]{1,4}){1,7}|:)|fe80:(:[0-9A-Fa-f]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9A-Fa-f]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))$"
    );

    @Override
    public void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException {
        IPv6 annotation = field.getAnnotation(IPv6.class);
        StringValidationUtil.validate(field, obj, PATTERN, annotation.message());
    }
}
