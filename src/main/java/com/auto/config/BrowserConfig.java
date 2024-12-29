package com.auto.config;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserConfig {

    public static MutableCapabilities getBrowserCapabilities(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--disable-infobars");
                return chromeOptions;
            }
            case "firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--width=1920"); // Firefox không hỗ trợ `--start-maximized`
                firefoxOptions.addArguments("--height=1080");
                firefoxOptions.addArguments("--disable-extensions");
                return firefoxOptions;
            }
            case "edge": {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--disable-extensions");
                edgeOptions.addArguments("--no-sandbox");
                edgeOptions.addArguments("--disable-infobars");
                return edgeOptions;
            }
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
