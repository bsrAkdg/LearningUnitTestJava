package com.bsrakdg.introductionunittest.stepNineAssertJ;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * AssertJ :allows us to match all kinds of matches one after another
 * https://joel-costigliola.github.io/assertj/assertj-core-quick-start.html
 */

public class AssertJStringsTest {

    @Test
    public void testStringsError() {
        String city = "İstanbul";
        assertThat(city)
                .describedAs("This is a exception") // show exception message
                .isEqualTo("İstanbul")
                .startsWith("İs")
                .endsWith("bul")
                .contains("tan")
                .isNotEmpty()
                .isNotNull()
                .doesNotContain("blabla")
                .containsOnlyOnce("lala");
    }

    @Test
    public void testStringsSuccess() {
        String city = "İstanbul";
        assertThat(city)
                .describedAs("This is a exception") // show exception message
                .isEqualTo("İstanbul")
                .startsWith("İs")
                .endsWith("bul")
                .contains("tan")
                .isNotEmpty()
                .isNotNull()
                .doesNotContain("blabla")
                .containsOnlyOnce("tan");
    }

}