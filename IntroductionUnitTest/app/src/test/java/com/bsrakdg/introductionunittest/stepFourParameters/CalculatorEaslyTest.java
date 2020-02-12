package com.bsrakdg.introductionunittest.stepFourParameters;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

/**
 * https://github.com/Pragmatists/JUnitParams
 */

@RunWith(JUnitParamsRunner.class)
public class CalculatorEaslyTest {

    private Calculator calculator = new Calculator();

    @Test
    @Parameters("10,2,20")
    public void testCalculateField(int width, int height, int calculatedField) {
        assertEquals(calculatedField, calculator.calculateField(width, height));
    }

    @Test
    @Parameters({"10,2,20", "3,5,15"})
    public void testCalculateMultipleField(int width, int height, int calculatedField) {
        assertEquals(calculatedField, calculator.calculateField(width, height));
    }
}