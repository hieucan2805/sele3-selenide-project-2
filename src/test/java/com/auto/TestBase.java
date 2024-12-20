package com.auto;

import com.auto.config.TestConfig;
import com.codeborne.selenide.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Slf4j
public class TestBase {
    private final TestConfig testConfig = TestConfig.getInstance();

    @BeforeSuite(alwaysRun = true)
    public void beforeTestSuite() {
        System.setProperty("selenide.browser", "edge");

        log.info("Max retry time: {}", System.getProperty("maxRetryCount"));
        log.info("Grid: {}", System.getProperty("remote"));
        log.info("Browser: {}", System.getProperty("selenide.browser"));
        log.info("Thread count: {}", System.getProperty("threadCount"));

        if (System.getProperty("remote").equals("true")) {
            Configuration.remote = testConfig.remote();
        }
        Configuration.browser = testConfig.getBrowser();
        Configuration.reportsFolder = testConfig.getReportFolder();
        Configuration.timeout = testConfig.getTimeout();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}
