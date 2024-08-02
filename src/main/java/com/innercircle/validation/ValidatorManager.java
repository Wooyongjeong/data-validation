package com.innercircle.validation;

import com.innercircle.validation.annotation.*;
import com.innercircle.validation.validator.*;

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
        validators.put(IPv6.class, new IPv6Validator());
        validators.put(URL.class, new UrlValidator());
        validators.put(CustomRegex.class, new CustomRegexValidator());
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
