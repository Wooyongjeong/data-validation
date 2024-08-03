package com.innercircle.validation.annotation;

import com.innercircle.validation.ValidatorManager;
import com.innercircle.validation.exception.ValidatorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
    @Test
    void email() {
        class Data {
            @Email
            String email;

            public Data(String email) {
                this.email = email;
            }
        }
        Data data = new Data("email@email.com");
        assertDoesNotThrow(() -> ValidatorManager.validate(data));
    }

    @Test
    void emailFail() {
        class Data {
            @Email
            String email;

            public Data(String email) {
                this.email = email;
            }
        }
        Data data = new Data("email");
        assertThrows(ValidatorException.class, () -> ValidatorManager.validate(data));
    }
}