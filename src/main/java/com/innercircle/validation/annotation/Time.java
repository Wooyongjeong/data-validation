package com.innercircle.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@BaseValidation(
        pattern = "^(?:(?:오전|오후|AM|PM)\\s)?(?:(?:0?[1-9]|1[0-2])(?::([0-5]?[0-9])(?::([0-5]?[0-9]))?)?|(?:2[0-3]|[01]?[0-9])(?::([0-5]?[0-9])(?::([0-5]?[0-9]))?)?)(?:\\s?(?:오전|오후|AM|PM))?$",
        message = "Invalid Time format"
)
public @interface Time {
}