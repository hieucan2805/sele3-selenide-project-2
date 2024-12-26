package com.auto.listener;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;

import com.auto.utils.Logger;
import java.io.ByteArrayInputStream;
import java.util.UUID;

public class AllureTestListener implements TestLifecycleListener {

    @Override
    public void beforeTestStop(TestResult result) {
        if (result.getStatus() != null &&
                (result.getStatus().equals(Status.BROKEN) || result.getStatus().equals(Status.FAILED))) {
            Logger.error("Test case \"{}\" has been \"{}\". Take a screenshot", result.getFullName(),
                    result.getStatus().value());
            try {
                byte[] buf = Selenide.screenshot(OutputType.BYTES);
                if (buf != null) {
                    ByteArrayInputStream input = new ByteArrayInputStream(buf);
                    Allure.attachment(UUID.randomUUID().toString(), input);
                }
            } catch (Exception e) {
                Logger.error("An error occurs when adding screenshot to report: \n{}", e.getMessage());
            }
        }
    }
}
