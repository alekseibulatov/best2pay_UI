package com.bulatov.web.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RestorePage {

    @Step("Проверяем, что на странице отображается надпись 'Добро пожаловать в личный кабинет'")
    public RestorePage displayOnRestorePageTitle() {
        $(".content").shouldHave(text("Восстановление пароля"));

        return this;
    }
}
