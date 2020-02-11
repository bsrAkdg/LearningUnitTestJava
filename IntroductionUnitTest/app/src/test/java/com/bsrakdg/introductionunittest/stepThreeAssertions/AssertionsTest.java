package com.bsrakdg.introductionunittest.stepThreeAssertions;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class AssertionsTest {

    @Test
    public void testEqualsError() {
        // don't override equals method in object
        Dummy dummyOne = new Dummy(5);
        Dummy dummyTwo = new Dummy(5);

        assertEquals(dummyOne, dummyTwo);
    }

    @Test
    public void testEqualsSuccess() {
        DummyOverrideEquals dummyOne = new DummyOverrideEquals(5);
        DummyOverrideEquals dummyTwo = new DummyOverrideEquals(5);

        assertEquals(dummyOne, dummyTwo);
    }

    @Test
    public void testNotNullError() {
        Dummy dummy = null;
        assertNotNull(dummy);
    }

    @Test
    public void testNotNullSuccess() {
        Dummy dummy = new Dummy(1);
        assertNotNull(dummy);
    }

    @Test
    public void testNullError() {
        Dummy dummy = new Dummy(1);
        assertNull(dummy);
    }

    @Test
    public void testNullSuccess() {
        Dummy dummy = null;
        assertNull(dummy);
    }

    @Test
    public void testArrayEquals() {
        String[] arrOne = new String[]{"1","2"};
        String[] arrTwo = new String[]{"1","2"};

        assertArrayEquals(arrOne, arrTwo);
    }

    @Test
    public void testSameError() {
        DummyOverrideEquals dummyOne = new DummyOverrideEquals(5);
        DummyOverrideEquals dummyTwo = new DummyOverrideEquals(5);

        // assertSame don't use equals method
        assertSame(dummyOne, dummyTwo);
    }

    @Test
    public void testSameSuccess() {
        Dummy dummyOne = new Dummy(5);
        Dummy dummyTwo = dummyOne;

        // assertSame don't use equals method
        assertSame(dummyOne, dummyTwo);
    }
}