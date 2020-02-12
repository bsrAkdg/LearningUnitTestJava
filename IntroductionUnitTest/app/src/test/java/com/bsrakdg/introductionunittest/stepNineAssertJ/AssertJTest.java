package com.bsrakdg.introductionunittest.stepNineAssertJ;

import org.junit.Test;

/**
 * AssertJ : get, set, constructor, equals, toString, hashCode vs methods added when compile time
 * We can prepare own assertions class with AssertJ
 * We use Lombok framework for example :https://projectlombok.org/setup/gradle import this framework
 */
public class AssertJTest {

    @Test
    public void testLombok() {
        Gift gift = new Gift("Hello I am Gift for you!"); //@Data annotations added to Gift model
        System.out.println(gift.toString());
    }

    @Test
    public void testLombokBuilder() {
        Gift gift = Gift.builder().name("Hello I am Gift for you")
                .build();  //@Builder annotations added to Gift model
        System.out.println(gift.toString());
    }

}