package com.bsrakdg.introductionunittest.stepEightHamcrest;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HamcrestTest {
    // Hamcrest includes very usable and readable assertions methods

    @Test
    public void testAllOfMatcherWithError() {
        List<String> cities = new ArrayList<>(Arrays.asList("İstanbul", "Bursa", "Çanakkale"));
        // allOf(..) is AND all of mathers response, not(...) reverses to result
        assertThat(cities, allOf(hasItems("Bursa", "Kars"), not(hasItem("Van"))));
    }

    @Test
    public void testAllOfMatcherWithSuccess() {
        List<String> cities = new ArrayList<>(Arrays.asList("İstanbul", "Bursa", "Çanakkale"));
        // allOf(..) is AND all of mathers response, not(...) reverses to result
        assertThat(cities, allOf(hasItems("Bursa", "İstanbul"), not(hasItem("Van"))));
    }

    @Test
    public void testAnyOfMatcherWithError() {
        String messageOne = "Hello I am message One";
        // anyOf is OR all of mathers response, any one is true, response is true
        assertThat(messageOne, anyOf(containsString("Two"), containsString("Three")));
    }

    @Test
    public void testAnyOfMatcherWithSuccess() {
        String messageOne = "Hello I am message One";
        // anyOf is OR all of mathers response, any one is true, response is true
        assertThat(messageOne, anyOf(containsString("Two"), containsString("One")));
    }

    @Test
    public void testContainsMatcherWithError() {
        String messageOne = "Hello I am message One";
        // containsString is if string contain Two return true
        assertThat(messageOne, is(containsString("Two")));
    }

    @Test
    public void testContainsMatcherWithSuccess() {
        String messageOne = "Hello I am message One";
        // containsString is if string contain Two return true
        assertThat(messageOne, is(containsString("message")));
    }

    @Test
    public void testEitherMatcherWithError() {
        List<String> cities = new ArrayList<>(Arrays.asList("İstanbul", "Bursa", "Çanakkale"));
        // either(..).or(..) is OR-OR all of mathers response
        assertThat(cities, either(hasItems("Gaziantep", "Van")).or(not(hasItem("Çanakkale"))));
    }

    @Test
    public void testEitherMatcherWithSuccess() {
        List<String> cities = new ArrayList<>(Arrays.asList("İstanbul", "Bursa", "Çanakkale"));
        // either(..).or(..) is OR-OR all of mathers response
        assertThat(cities, either(hasItems("Bursa", "İstanbul")).or(not(hasItem("Van"))));
    }

    @Test
    public void testEqualsMatcherWithout() {
        String messageOne = "Hello I am message One";
        String messageTwo = "Hello I am message One";

        assertEquals(messageOne, messageTwo);
    }

    @Test
    public void testHasItemMatcherWithError() {
        List<String> cities = new ArrayList<>(Arrays.asList("İstanbul", "Bursa", "Çanakkale"));

        assertThat(cities, hasItem("Ankara"));
    }

    @Test
    public void testHasItemMatcherWithSuccess() {
        List<String> cities = new ArrayList<>(Arrays.asList("İstanbul", "Bursa", "Çanakkale"));

        assertThat(cities, hasItem("Çanakkale"));
    }

    @Test
    public void testHasItemsMatcherWithError() {
        List<String> cities = new ArrayList<>(Arrays.asList("İstanbul", "Bursa", "Çanakkale"));

        assertThat(cities, hasItems("Ankara", "İstanbul"));
    }

    @Test
    public void testHasItemsMatcherWithSuccess() {
        List<String> cities = new ArrayList<>(Arrays.asList("İstanbul", "Bursa", "Çanakkale"));

        assertThat(cities, hasItems("Bursa", "İstanbul"));
    }

    @Test
    public void testNullMatcherWithError() {
        String messageOne = "Hello I am message One";

        assertThat(messageOne, is(nullValue()));
    }

    @Test
    public void testNullMatcherWithSuccess() {
        String messageOne = null;

        assertThat(messageOne, is(nullValue()));
    }

    @Test
    public void testThatMatcherWithError() {
        String messageOne = "Hello I am message One";
        String messageTwo = "Hello I am message Twoo";

        // is and equalTo are matchers
        assertThat(messageOne, is(equalTo(messageTwo)));
        // error response is very readable
    }

    @Test
    public void testThatMatcherWithSuccess() {
        String messageOne = "Hello I am message One";
        String messageTwo = "Hello I am message One";

        // is and equalTo are matchers
        assertThat(messageOne, is(equalTo(messageTwo)));
    }
}