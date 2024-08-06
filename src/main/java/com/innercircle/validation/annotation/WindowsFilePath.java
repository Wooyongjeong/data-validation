package com.innercircle.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@BaseValidation(
        pattern = "^[a-zA-Z]:\\\\(?:[^\\\\/:*?\"<>|\\r\\n]{1,255}\\\\)*[^\\\\/:*?\"<>|\\r\\n]{1,255}$",
        message = "Invalid windows file path format"
)
public @interface WindowsFilePath {
}
