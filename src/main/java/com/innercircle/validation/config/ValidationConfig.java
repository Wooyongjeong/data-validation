package com.innercircle.validation.config;

import com.innercircle.validation.aspect.ValidationAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationConfig {
    @Bean
    public ValidationAspect validationAspect() {
        return new ValidationAspect();
    }
}
