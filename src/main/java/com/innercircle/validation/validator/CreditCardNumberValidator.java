package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.CreditCardNumber;
import com.innercircle.validation.exception.ValidatorException;
import com.innercircle.validation.util.StringValidationUtil;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class CreditCardNumberValidator implements Validator {
    private static Pattern pattern = null;
    @Override
    public void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException {
        CreditCardNumber annotation = field.getAnnotation(CreditCardNumber.class);
        if(pattern == null) {
            pattern = Pattern.compile("^(\\d{4}-\\d{4}-\\d{4}-\\d{4}|\\d{16})$");
        }
        StringValidationUtil.validate(field, obj, pattern, annotation.invalidFormatMessage());
    }
}
