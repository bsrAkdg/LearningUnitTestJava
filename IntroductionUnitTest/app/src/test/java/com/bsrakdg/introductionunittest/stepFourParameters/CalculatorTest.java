package com.bsrakdg.introductionunittest.stepFourParameters;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorTest {

    private Calculator calculator = new Calculator();
    private int width;
    private int height;
    private int calculatedField;

    public CalculatorTest(int width, int height, int calculatedField) {
        this.width = width;
        this.height = height;
        this.calculatedField = calculatedField;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10, 2, 20},
                {10, 3, 30},
                {5, 2, 10},
                {5, 5, 25}
        });
    }

    @Test
    public void testCalculatorFieldTrueUsing() throws Exception {
        // Below code execute for each item of data()
        assertEquals(calculatedField, calculator.calculateField(width, height));
    }

    @Test
    public void testCalculatorFieldWrongUsing() throws Exception {
        // The following usage is not recommended
        // You should use Parameters instead (testCalculatorFieldTrueUsing)
        // Define width-height-calculatedField fields and data() method added
        assertEquals(20, calculator.calculateField(10, 2));
        assertEquals(30, calculator.calculateField(10, 3));
        assertEquals(10, calculator.calculateField(5, 2));
        assertEquals(25, calculator.calculateField(5, 5));
    }
}