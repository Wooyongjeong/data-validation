package com.innercircle.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@BaseValidation(
        pattern = "^([0-9a-fA-F]{2}:){5}[0-9a-fA-F]{2}$",
        message = "Invalid MAC Address format"
)
public @interface MACAddress {
}