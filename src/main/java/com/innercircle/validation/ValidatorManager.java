package com.innercircle.validation;

import com.innercircle.validation.annotation.Email;
import com.innercircle.validation.annotation.PhoneNumber;
import com.innercircle.validation.annotation.ResidentRegistrationNumber;
import com.innercircle.validation.validator.EmailValidator;
import com.innercircle.validation.validator.PhoneNumberValidator;
import com.innercircle.validation.validator.ResidentRegistrationNumberValidator;
import com.innercircle.validation.validator.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ValidatorManager {
    private static final Map<Class<? extends Annotation>, Validator> validators = new HashMap<>();

    static {
        validators.put(Email.class, new EmailValidator());
        validators.put(PhoneNumber.class, new PhoneNumberValidator());
        validators.put(ResidentRegistrationNumber.class, new ResidentRegistrationNumberValidator());
    }

    public static void validate(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            for (Class<? extends Annotation> annotationClass : validators.keySet()) {
                if (!field.isAnnotationPresent(annotationClass)) {
                    continue;
                }
                validators.get(annotationClass).validate(field, obj);
            }
        }
    }
}
