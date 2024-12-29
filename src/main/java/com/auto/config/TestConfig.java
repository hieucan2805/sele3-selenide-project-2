package com.auto.config;

import com.auto.utils.Constants;
import com.codeborne.selenide.WebDriverRunner;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

@Data
@Getter
@Setter
public class TestConfig {
    private String remote;
    private String maxRetry;
    private String headless;
    private String reportFolder;
    private String browserSize;
    private long timeout;
    private static TestConfig instance = null;
    Properties browserProps = new Properties();

    private TestConfig() {
        try {
            browserProps.load(new FileInputStream("src/test/resources/properties/config.browser.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.browser.properties", e);
        }


        String windowSize = getScreenSize();
        this.remote = browserProps.getProperty("remote");
        this.headless = browserProps.getProperty("headless");
        this.reportFolder = "allure-results";
        if(browserProps.getProperty("start-maximized").equals("false"))
        {
            if (windowSize.equals(browserProps.getProperty("browserSize"))) {
                this.browserSize = browserProps.getProperty("browserSize");
            } else {
                this.browserSize = windowSize;
            }
        }else {
            this.browserSize="maximized";

        }
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
        String browser = browserProps.getProperty("browser");
        return (browser == null || browser.trim().isEmpty()) ? "chrome" : browser;
    }

    public void maximizedBrowserWindow() {
    }

    public String getScreenSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        return width + "x" + height;
    }
}
