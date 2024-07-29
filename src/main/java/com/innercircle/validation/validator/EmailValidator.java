package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.Email;
import com.innercircle.validation.exception.ValidatorException;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class EmailValidator implements Validator {
    @Override
    public void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException {
        String value = (String) field.get(obj);
        Email annotation = field.getAnnotation(Email.class);
        String emailPattern = "^[A-za-z0-9+_.-]{2,20}@[A-Za-z0-9.-]{2,20}.[a-z]{2,3}$";
        if (!Pattern.matches(emailPattern, value)) {
            throw new ValidatorException(annotation.message());
        }
    }
}
