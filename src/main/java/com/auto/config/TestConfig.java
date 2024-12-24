package com.auto.config;

import com.auto.utils.Constants;
import lombok.Data;

import java.awt.*;

@Data
public class TestConfig {
    private String remote;
    private String maxRetry;
    private boolean headless;
    private String reportFolder;
    private String browserSize;
    private long timeout;
    private static TestConfig instance = null;

    private TestConfig() {
        this.remote = null;
        this.headless = false;
        this.reportFolder = "allure-reports";
        this.browserSize = "1920x1080";
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

    public void maximizedBrowserWindow(){
    }

    public String getScreenSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        return width + "x" + height;
    }
}
