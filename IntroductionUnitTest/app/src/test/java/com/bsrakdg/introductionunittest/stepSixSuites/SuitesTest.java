package com.bsrakdg.introductionunittest.stepSixSuites;

import com.bsrakdg.introductionunittest.stepFourParameters.CalculatorEaslyTest;
import com.bsrakdg.introductionunittest.stepFourParameters.CalculatorTest;
import com.bsrakdg.introductionunittest.stepTwoTestLifecycle.TestLifecycleTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculatorEaslyTest.class,
        CalculatorTest.class,
        TestLifecycleTest.class
})
public class SuitesTest {
        // If run this class, all of above codes execute
}

