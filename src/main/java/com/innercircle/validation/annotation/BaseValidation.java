package com.innercircle.validation.annotation;

public @interface BaseValidation {
    String pattern() default "";
    String message() default "Invalid format";
}
