package com.innercircle.validation.validator;

import com.innercircle.validation.annotation.WindowsFilePath;
import com.innercircle.validation.exception.ValidatorException;
import com.innercircle.validation.util.StringValidationUtil;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class WindowsFilePathValidator implements Validator {
    private static Pattern pattern = null;
    @Override
    public void validate(Field field, Object obj) throws ValidatorException, IllegalAccessException {
        WindowsFilePath annotation = field.getAnnotation(WindowsFilePath.class);
        if(pattern == null) {
            pattern = Pattern.compile("^[a-zA-Z]:\\\\(?:[^\\\\/:*?\"<>|\\r\\n]{1,255}\\\\)*[^\\\\/:*?\"<>|\\r\\n]{1,255}$");
        }
        StringValidationUtil.validate(field, obj, pattern, annotation.invalidFormatMessage());
    }
}
