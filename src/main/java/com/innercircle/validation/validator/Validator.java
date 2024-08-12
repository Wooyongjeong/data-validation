package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.BaseValidation;
import com.innercircle.validation.exception.ValidatorException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Validator {
    public static void validate(Object obj) throws ValidatorException, IllegalAccessException {
        if (obj == null) {
            return;
        }

        for (Field field : obj.getClass().getDeclaredFields()) {
            for (Annotation annotation : field.getAnnotations()) {
                if (annotation.annotationType().isAnnotationPresent(BaseValidation.class)) {
                    field.setAccessible(true);
                    String value = (String) field.get(obj);
                    BaseValidation baseValidation = annotation.annotationType().getAnnotation(BaseValidation.class);

                    if (value == null || !value.matches(baseValidation.pattern())) {
                        throw new ValidatorException(baseValidation.message());
                    }
                }
            }
        }

    }
}
