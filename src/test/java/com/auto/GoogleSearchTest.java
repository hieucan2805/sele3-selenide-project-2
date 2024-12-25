package com.auto;

import com.auto.utils.Logger;
import com.auto.utils.Constants;
import com.codeborne.selenide.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class GoogleSearchTest extends TestBase {

    @Test
    public void googleSearchTest() {
        // Mở trình duyệt và truy cập Google
        Logger.info("Navigate to Google");
        open(Constants.GOOGLE);

//        // Tìm kiếm một từ khoá
//        Logger.info("Tìm kiếm một từ khoá");
//        $("[name='q']").setValue("Selenide").pressEnter();
//
//        // Kiểm tra kết quả
//        Logger.info("Kiểm tra kết quả");
//        $("#search").shouldHave(Condition.text("a: concise UI tests in Java"));

    }
}
