package com.bsrakdg.introductionunittest.stepSevenIgnore;

import org.junit.Ignore;
import org.junit.Test;

public class IgnoreTest {

    @Test
    public void testSayHello() {
        System.out.println("Hi!, I am not ignored");
    }

    @Test
    @Ignore("Invalid")
    public void testIgnoreSayHello() {
        // TODO run the class by putting @Ignore in the comment line and not in the comment line.
        System.out.println("Hi!, I am ignored");
    }

}