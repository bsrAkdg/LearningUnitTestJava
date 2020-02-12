package com.bsrakdg.introductionunittest.stepFiveExceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.bsrakdg.introductionunittest.common.InformationHelper;
import com.bsrakdg.introductionunittest.common.MailServerUnavailableException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * JUnit catch exception 4 ways : try-catch / @Test-expected / @Rule / CatchException framework (https://code.google.com/archive/p/catch-exception/)
 */
public class ExceptionsTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private InformationHelper informationHelper = new InformationHelper();

    @Test(expected = MailServerUnavailableException.class)
    public void testExceptedException() throws Exception {
        // You can't show message and don't receive error when execute test method
        informationHelper.sendEmailWeekly();
    }

    @Test
    public void testRuleExceptionError() throws Exception {
        thrown.expect(MailServerUnavailableException.class);
        thrown.expectMessage("Different exception message");

        informationHelper.sendEmailWeekly();
    }

    @Test
    public void testRuleExceptionSuccess() throws Exception {
        thrown.expect(MailServerUnavailableException.class);
        thrown.expectMessage("Mail server unavailable");

        informationHelper.sendEmailWeekly();
    }

    @Test
    public void testTryCatchException() {
        try {
            informationHelper.sendEmailWeekly();
        } catch (Exception exception) {
            assertTrue(exception instanceof MailServerUnavailableException);
            assertEquals("Mail server unavailable", exception.getMessage());
        }
    }


}