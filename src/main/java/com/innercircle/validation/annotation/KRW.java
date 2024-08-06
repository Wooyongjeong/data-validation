package com.innercircle.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@BaseValidation(
        pattern = "^(₩|\\d{1,3}(,\\d{3})*)(₩\\d{1,3}(,\\d{3})*)?\\d+원?$",
        message = "Invalid KRW format")
public @interface KRW {
}
