package com.auto.listener;

import com.auto.utils.Logger;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.openqa.selenium.OutputType;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class AllureITestListener implements ITestListener {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AllureITestListener.class);

    private String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestStart(ITestResult result) {
        Logger.info("[Allure] Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logger.info("[Allure] Test passed: " + result.getName());
        Logger.info("Test passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Test case \"{}\" has been \"{}\". Take a screenshot", result.getName(),
                Status.FAILED);
        try {
            byte[] buf = Selenide.screenshot(OutputType.BYTES);
            if (buf != null) {
                ByteArrayInputStream input = new ByteArrayInputStream(buf);
                Allure.attachment(getTestMethodName(result) +"_"+UUID.randomUUID().toString(), input);
            }
        } catch (Exception e) {
            logger.error("An error occurs when adding screenshot to report: \n{}", e.getMessage());
        }
        Logger.info("Test failed with exception: " + result.getThrowable().getMessage());
        Allure.step("Error stack trace", Status.FAILED);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logger.info("[Allure] Test skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        Logger.info("[Allure] Test suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        Logger.info("[Allure] Test suite finished: " + context.getName());
    }

}
