package com.bsrakdg.introductionunittest.stepNineAssertJ;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * We can create own matchers use Condition for example : isAbroadCity and isTurkeyCity
 */

public class AssertJListTest {

    private List<String> cities = new ArrayList<>(Arrays
            .asList("İstanbul", "Ankara", "İzmir", "Konya", "Gaziantep", "Bursa"));
    private List<String> abroadCities = new ArrayList<>(Arrays
            .asList("Amsterdam", "Paris", "Londra"));

    private Condition<? super String> isAbroadCity() {
        return new Condition<String>() {
            @Override
            public boolean matches(String value) {
                return abroadCities.contains(value);
            }
        };
    }

    private Condition<? super String> isTurkeyCity() {
        return new Condition<String>() {
            @Override
            public boolean matches(String value) {
                return cities.contains(value);
            }
        };
    }

    @Test
    public void testAbroadCityListError() {
        List<String> controlCities = new ArrayList<>(Arrays.asList("Bursa", "Amsterdam"));

        assertThat(controlCities)
                .describedAs("This is not a city of abroad")
                .have(isTurkeyCity());

    }

    @Test
    public void testAbroadCityListSuccess() {
        List<String> controlCities = new ArrayList<>(Arrays.asList("Amsterdam", "Londra"));

        assertThat(controlCities)
                .have(isAbroadCity());

    }

    @Test
    public void testList() {
        assertThat(cities)
                .describedAs("This is a exception")
                .contains("Ankara")
                .doesNotContain("Bursa")
                .containsExactly("İstanbul", "Ankara", "İzmir")
                .doesNotHaveDuplicates();

    }

    @Test
    public void testMixCityListError() {
        List<String> controlCities = new ArrayList<>(Arrays.asList("Bursa", "Konya", "Gaziantep"));

        //matchers is valid if list contains 2 turkey and 3 abroad cities
        assertThat(controlCities)
                .haveExactly(2, isTurkeyCity())
                .haveExactly(3, isAbroadCity());

    }

    @Test
    public void testMixCityListSuccess() {
        List<String> controlCities = new ArrayList<>(Arrays
                .asList("Bursa", "Konya", "Amsterdam", "Londra", "Paris"));

        //matchers is valid if list contains 2 turkey and 3 abroad cities
        assertThat(controlCities)
                .haveExactly(2, isTurkeyCity())
                .haveExactly(3, isAbroadCity());

    }

    @Test
    public void testTurkeyCityListError() {
        List<String> controlCities = new ArrayList<>(Arrays.asList("Bursa", "Amsterdam"));

        assertThat(controlCities)
                .describedAs("This is not a city of Turkey")
                .have(isTurkeyCity());

    }

    @Test
    public void testTurkeyCityListSuccess() {
        List<String> controlCities = new ArrayList<>(Arrays.asList("Bursa", "Konya", "Gaziantep"));

        assertThat(controlCities)
                .have(isTurkeyCity());

    }

}