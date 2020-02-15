package com.bsrakdg.introductionunittest.stepTenFiles;

import static org.assertj.core.api.AssertionsForClassTypes.contentOf;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.bsrakdg.introductionunittest.common.MailServerUnavailableException;

import org.junit.Test;
import org.junit.runners.model.MultipleFailureException;

import java.io.File;

public class FilesTest {

    @Test
    public void testFile() throws Exception {
        File file = new File("/Users/bserdaroglu/GithubWorks/LearningUnitTestJava/IntroductionUnitTest/app/src/test/resources/test.txt");
        // new File("copyFilePathOn/app/src/test/resources/test.txt");
        assertThat(file)
                .exists()
                .canRead()
                .canWrite()
                .hasName("test.txt");
    }

    @Test
    public void testContentOfContentFile() throws Exception {
        File file = new File("/Users/bserdaroglu/GithubWorks/LearningUnitTestJava/IntroductionUnitTest/app/src/test/resources/test.txt");
        // new File("copyFilePathOn/app/src/test/resources/test.txt");
        assertThat(contentOf(file))
                .startsWith("Hi");
    }

    @Test
    public void testFileException() {
        Exception exception = new MailServerUnavailableException("Error message");

        assertThat(exception)
                .hasMessage("Error message")
                .isInstanceOf(MailServerUnavailableException.class)
                .hasMessageContaining("message");

    }
}