package com.auto.page.vietjet;

import com.auto.utils.Constants;
import com.auto.utils.Logger;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.UIAssertionError;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class BasePage {
    private final SelenideElement buttonAcceptCookie = $x("//div[@id='popup-dialog-description']//following-sibling::div//button");

    protected void waitForVisible(SelenideElement element) {
        element.shouldBe(visible, Duration.ofSeconds(10));
    }

    public void waitAndAcceptCookie() {
        if (isAcceptCookiePopUpAppear()) {
            waitForVisible(buttonAcceptCookie);
            buttonAcceptCookie.click();
        }
    }

    protected boolean isElementsBlocked(SelenideElement element) {
        try {
            element.click();
        } catch (UIAssertionError e) {
            if (e.getMessage().contains("is not clickable at point")) {
                Logger.warn("The element {} is blocked by another element.", element);
            } else {
                Logger.error(e.getMessage());
                return false;
            }
        }
        return true;
    }

    protected boolean isAcceptCookiePopUpAppear() {
        return buttonAcceptCookie.exists();
    }
}
