package com.auto;

import com.codeborne.selenide.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class GoogleSearchTest extends TestBase {

    @Test
    public void googleSearchTest() {
        // Mở trình duyệt và truy cập Google
        open("https://www.google.com");

        // Tìm kiếm một từ khoá
        $("[name='q']").setValue("Selenide").pressEnter();

        // Kiểm tra kết quả
        $("#search").shouldHave(Condition.text("a: concise UI tests in Java"));

    }
}
