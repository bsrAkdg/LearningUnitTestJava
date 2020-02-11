package com.bsrakdg.introductionunittest.stepTwoTestLifecycle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLifecycleTest {
    //TODO Outputs maybe wrong, to learn lifecycle you should debug

    @AfterClass
    public static void testAfterClass() {
        System.out.println("testAfterClass");
    }

    @BeforeClass
    public static void testBeforeClass() {
        System.out.println("testBeforeClass");
    }

    @After
    public void testAfter() {
        System.out.println("testAfter");
    }

    @Before
    public void testBefore() {
        System.out.println("testBefore");
    }

    @Test
    public void testSayHello() {
        System.out.println("testSayHello");
    }
}