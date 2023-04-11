package com.bulatov.web.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.bulatov.web.tests.WebTestData.*;
import static com.bulatov.web.tests.WebTestData.titleMainText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement
            titleMain = $(".title_main"),
            headerSignIn = $(".header_sign_in");

    private final ElementsCollection
            headerMenuLink = $$(".header__menu_link");


    @Step("Открываем главную страницу сайта https://best2pay.net/")
    public MainPage openPage() {
        open("");

        return this;
    }

    @Step("Проверяем загрузку  главной страницы")
    public MainPage verificationMainPage() {
        titleMain.shouldHave(text(titleMainText));

        return this;
    }

    @Step("Проверяем наличие в header_menu кнопок 'Банкам и МФО', 'Бизнесу', " +
            "'Агрегаторам (BAAS)', 'Поддержка'")
    public MainPage verificationHeaderMainPage() {
        headerMenuLink.get(0).shouldHave(text(headerMenuLinkFirstText));
        headerMenuLink.get(1).shouldHave(text(headerMenuLinkSecondText));
        headerMenuLink.get(2).shouldHave(text(headerMenuLinkThirdText));
        headerMenuLink.get(3).shouldHave(text(headerMenuLinkFourthText));

        return this;
    }

    @Step("Кликаем по кнопке 'Войти' в header на главной странице")
    public MainPage clickToButtonEnter() {
        headerSignIn.click();

        return this;
    }
}