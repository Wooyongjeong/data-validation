package com.innercircle.validation.annotation;

import java.lang.annotation.Inherited;

@Inherited
public @interface BaseValidation {
    String pattern() default "";
    String message() default "Invalid format";
}
