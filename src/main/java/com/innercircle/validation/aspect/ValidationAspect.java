package com.innercircle.validation.aspect;

import com.innercircle.validation.validator.Validator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class ValidationAspect {
    @Pointcut("@within(com.innercircle.validation.annotation.Validate)")
    public void validateAnnotatedClass() {}

    @Before("validateAnnotatedClass()")
    public void validateFields(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            Validator.validate(arg);
        }
    }
}
