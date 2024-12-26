package com.auto.page.vietjet;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement radioReturnFlight = $("[type='radio'][value='roundTrip']");
    private final SelenideElement radioOneWayFlight = $("[type='radio'][value='oneway']");
}
