package com.innercircle.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@BaseValidation(
        pattern = "^(01[016789]-\\d{3,4}-\\d{4}|01[016789]\\d{7,8})$",
        message = "Invalid phone number format"
)
public @interface PhoneNumber {
}
