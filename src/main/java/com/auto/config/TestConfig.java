package com.auto.config;

import com.auto.utils.Constants;
import lombok.Data;

@Data
public class TestConfig {
    private String remote;
    private String maxRetry;
    private boolean headless;
    private String reportFolder;
    private boolean browserSize;
    private long timeout;
    private static TestConfig instance = null;

    private TestConfig() {
        this.remote = null;
        this.headless = false;
        this.reportFolder = "allure-results";
        this.browserSize = true;
        this.timeout = 5000;
    }

    public static TestConfig getInstance() {
        if (instance == null) {
            instance = new TestConfig();
        }
        return instance;
    }

    public String remote() {
        return Constants.GRID_HUB_URL;
    }

    public String getBrowser() {
        return System.getProperty("selenide.browser") == null ? "chrome" : System.getProperty("selenide.browser");
    }
}
