package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.PhoneNumber;
import com.innercircle.validation.exception.ValidatorException;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements Validator {
    Pattern pattern = null;
    @Override
    public void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException {
        PhoneNumber annotation = field.getAnnotation(PhoneNumber.class);
        if(this.pattern == null) {
            pattern = Pattern.compile("^(01[016789]-\\d{3,4}-\\d{4}|01[016789]\\d{7,8})$");
        }

        Object value =  field.get(obj);
        if(!(value instanceof String)) {
            throw new ValidatorException(annotation.invalidFieldTypeMessage());
        }

        if (!pattern.matcher((String)value).matches()) {
            throw new ValidatorException(annotation.invalidFormatMessage());
        }
    }
}
