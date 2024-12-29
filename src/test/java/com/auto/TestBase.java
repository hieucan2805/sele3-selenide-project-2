package com.auto;

import com.auto.config.BrowserConfig;
import com.auto.config.TestConfig;
import com.auto.utils.Logger;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {
    private final TestConfig testConfig = TestConfig.getInstance();
    private  WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeTestSuite() {

        if (testConfig.getRemote().equals("true")) {
            Configuration.remote = testConfig.remote();
        }
        Configuration.browser = testConfig.getBrowser();
        Configuration.reportsFolder = testConfig.getReportFolder();
        Configuration.timeout = testConfig.getTimeout();
        Configuration.browserSize = testConfig.getBrowserSize();

//        MutableCapabilities capabilities = BrowserConfig.getBrowserCapabilities(testConfig.getBrowser());
//
//        switch (testConfig.getBrowser().toLowerCase()) {
//            case "firefox":
//                driver = new FirefoxDriver((FirefoxOptions) capabilities);
//                break;
//            case "edge":
//                driver = new EdgeDriver((EdgeOptions) capabilities);
//                break;
//            case "chrome":
//            default:
//                driver = new ChromeDriver((ChromeOptions) capabilities);
//                break;
//        }


        Logger.info("Max retry time: {}", System.getProperty("maxRetryCount"));
        Logger.info("Grid: {}", Configuration.remote);
        Logger.info("Browser: {}", Configuration.browser);
        Logger.info("Browser size: {}", Configuration.browserSize);
        Logger.info("Thread count: {}", System.getProperty("threadCount"));

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Logger.info("Close WebDriver");
        closeWebDriver();
    }
}
