package com.bulatov.web.pages;


import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {


    @Step("Открываем главную страницу сайта https://best2pay.net/")
    public MainPage openPage() {
        open("");

        return this;
    }

    @Step("Проверяем загрузку  главной страницы")
    public MainPage verificationMainPage() {
        $(".title_main").shouldHave(text("Платежи во всех измерениях"));

        return this;
    }

    @Step("Проверяем наличие в header_menu кнопок 'Банкам и МФО', 'Бизнесу', " +
            "'Агрегаторам (BAAS)', 'Поддержка'")
    public MainPage verificationHeaderMainPage() {
        $$(".header__menu_link").get(0).shouldHave(text("Банкам и МФО"));
        $$(".header__menu_link").get(1).shouldHave(text("Бизнесу"));
        $$(".header__menu_link").get(2).shouldHave(text("Агрегаторам (BAAS)"));
        $$(".header__menu_link").get(3).shouldHave(text("Поддержка"));

        return this;
    }

    @Step("Кликаем по кнопке 'Войти' в header на главной странице")
    public MainPage clickToButtonEnter() {
        $(".header_sign_in").click();

        return this;
    }
}