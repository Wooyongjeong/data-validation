package com.innercircle.validation.annotation;

import com.innercircle.validation.exception.ValidatorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {
    static class Data {
        @Time
        String time;

        public Data(String time) {
            this.time = time;
        }
    }

    @Test
    void time() {
        Data data2 = new Data("오후 11:00:01");
        Data data1 = new Data("1:0");
        Data data3 = new Data("AM 09:56:27");
        Data data4 = new Data("10:1:3 PM");
        Data data5 = new Data("19:32:22");

        assertAll(
//                () -> assertDoesNotThrow(() -> ValidatorManager.validate(data1)),
//                () -> assertDoesNotThrow(() -> ValidatorManager.validate(data2)),
//                () -> assertDoesNotThrow(() -> ValidatorManager.validate(data3)),
//                () -> assertDoesNotThrow(() -> ValidatorManager.validate(data4)),
//                () -> assertDoesNotThrow(() -> ValidatorManager.validate(data5))
        );
    }

    @Test
    void timeFail() {
        Data data1 = new Data("오후 23:59:00");
        Data data2 = new Data("QM 09:56:27");
        Data data3 = new Data("08:11:32:56");

        assertAll(
//                () -> assertThrows(ValidatorException.class, () -> ValidatorManager.validate(data1)),
//                () -> assertThrows(ValidatorException.class, () -> ValidatorManager.validate(data2)),
//                () -> assertThrows(ValidatorException.class, () -> ValidatorManager.validate(data3))
        );
    }
}
