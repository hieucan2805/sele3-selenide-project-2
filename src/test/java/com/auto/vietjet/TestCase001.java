package com.auto.vietjet;

import com.auto.TestBase;
import com.auto.page.vietjet.HomePage;
import com.auto.utils.Constants;
import com.auto.utils.Logger;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestCase001 extends TestBase {
    private final HomePage homePage = new HomePage();

    @Test
    public void googleSearchTest() {
        // Mở trình duyệt và truy cập Google
        Logger.info("Navigate to VietJetAir");
        open(Constants.VIETJET_EN);

        homePage.waitAndAcceptCookie();

        homePage.clickTypeOfFlight("oneway");
    }
}
