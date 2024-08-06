package com.innercircle.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@BaseValidation(
        pattern = "^[A-za-z0-9+_.-]{2,20}@[A-Za-z0-9.-]{2,20}.[a-z]{2,3}$",
        message = "Invalid email format"
)
public @interface Email {
}