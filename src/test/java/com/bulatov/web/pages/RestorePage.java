package com.bulatov.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.bulatov.web.tests.WebTestData.contentRestoreText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RestorePage {

    private SelenideElement contentRestore = $(".content");

    @Step("Проверяем, что на странице отображается надпись 'Добро пожаловать в личный кабинет'")
    public RestorePage displayOnRestorePageTitle() {
        contentRestore.shouldHave(text(contentRestoreText));

        return this;
    }
}
