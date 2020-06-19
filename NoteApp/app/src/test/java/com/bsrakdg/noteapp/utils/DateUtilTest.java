package com.bsrakdg.noteapp.utils;

import static com.bsrakdg.noteapp.utils.DateUtil.GET_MONTH_ERROR;
import static com.bsrakdg.noteapp.utils.DateUtil.getMonthFromNumber;
import static com.bsrakdg.noteapp.utils.DateUtil.monthNumbers;
import static com.bsrakdg.noteapp.utils.DateUtil.months;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

class DateUtilTest {
    private static final String today = "06-2020";

    @ParameterizedTest // short, byte, vs...
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11})
        // different months
    void getMonthFromNumber_returnSuccess(int monthNumber,
                                          TestInfo testInfo, // look at this
                                          TestReporter testReporter) {
        assertEquals(months[monthNumber], DateUtil.getMonthFromNumber(monthNumbers[monthNumber]));
        System.out.println(monthNumbers[monthNumber] + " : " + months[monthNumber]);
    }

    @ParameterizedTest // short, byte, vs...
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11})
    void getMonthFromNumber_returnError(int monthNumber,
                                        TestInfo testInfo,
                                        TestReporter testReporter) {
        int randomInt = new Random().nextInt(90) + 13;
        assertEquals(getMonthFromNumber(String.valueOf(monthNumber * randomInt)), GET_MONTH_ERROR);
    }

    @Test
    void test_getCurrentTimeStamp_returnedTimeStamp() {
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                assertEquals(today, DateUtil.getCurrentTimeStamp());
                System.out.println("Timestamp is generated");
            }
        });
    }
}