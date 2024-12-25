package com.auto;

import com.auto.config.TestConfig;
import com.auto.utils.Logger;
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

        if (testConfig.getRemote().equals("true")) {
            Configuration.remote = testConfig.remote();
        }
        Configuration.browser = testConfig.getBrowser();
        Configuration.reportsFolder = testConfig.getReportFolder();
        Configuration.timeout = testConfig.getTimeout();
        Configuration.browserSize = testConfig.getBrowserSize();

        log.info("Max retry time: {}", System.getProperty("maxRetryCount"));
        log.info("Grid: {}", Configuration.remote);
        log.info("Browser: {}", Configuration.browser);
        log.info("Browser size: {}", Configuration.browserSize);
        log.info("Thread count: {}", System.getProperty("threadCount"));

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Logger.info("Close WebDriver");
        closeWebDriver();
    }
}
