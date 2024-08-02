package com.innercircle.validation;

import com.innercircle.validation.annotation.*;
import com.innercircle.validation.validator.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ValidatorManager {
    private static final Map<Class<? extends Annotation>, Validator> validators = new HashMap<>();

    static {
        validators.put(Email.class, new EmailValidator());
        validators.put(PhoneNumber.class, new PhoneNumberValidator());
        validators.put(ResidentRegistrationNumber.class, new ResidentRegistrationNumberValidator());
        validators.put(IPv6.class, new IPv6Validator());
        validators.put(IPv4.class, new IPv4Validator());
        validators.put(URL.class, new UrlValidator());
        validators.put(CreditCardNumber.class, new CreditCardNumberValidator());
        validators.put(CustomRegex.class, new CustomRegexValidator());
        validators.put(WindowsFilePath.class, new WindowsFilePathValidator());
        validators.put(UNIXFilePath.class, new UNIXFilePathValidator());
        validators.put(PostalCode.class, new PostalCodeValidator());
        validators.put(MACAddress.class, new MACAddressValidator());
        validators.put(ISBN10.class, new ISBN10Validator());
        validators.put(ISBN13.class, new ISBN13Validator());
    }

    public static void validate(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            for (Class<? extends Annotation> annotationClass : validators.keySet()) {
                if (!field.isAnnotationPresent(annotationClass)) {
                    continue;
                }
                validators.get(annotationClass).validate(field, obj);
            }
        }
    }
}
