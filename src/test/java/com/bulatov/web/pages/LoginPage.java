package com.bulatov.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.bulatov.web.tests.WebTestData.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private SelenideElement
            content = $(".content"),
            loginField = $(".form-control[name=login]"),
            passwordField = $(".form-control[name=password]"),
            buttonEntrance = $(".btn"),
            alert = $(".alert"),
            buttonRestorePassword = $(".col-md-2");


    @Step("Открываем страницу Login    по ссылке https://pay.best2pay.net/new-office/login.htm")
    public LoginPage openLoginPage() {
        open("https://pay.best2pay.net/new-office/login.htm");

        return this;
    }

    @Step("Проверяем, что на странице отображается надпись 'Добро пожаловать в личный кабинет'")
    public LoginPage displayOnPageTitle() {
        content.shouldHave(text(contentLoginText));

        return this;
    }

    @Step("Заполняем поле Email значением {value}")
    public LoginPage setEmail(String value) {
        loginField.setValue(value);

        return this;
    }

    @Step("Заполняем поле Password значением {value}")
    public LoginPage setPassword(String value) {
        passwordField.setValue(value);

        return this;
    }

    @Step("Кликаем по кнопке Войти на странице авторизации")
    public LoginPage clickToButtonLogin() {
        buttonEntrance.click();
        sleep(15000);

        return this;
    }

    @Step("Проверяем наличие предупреждения 'Неверный логин или пароль'" +
            " при пустых значениях в полях Email и Password")
    public LoginPage unsuccessfulLogin() {
        alert.shouldHave(text(alertText));

        return this;
    }

    @Step("Проверяем, что при клике на Восстановить пароль на странице Логина " +
            "происходит переход на страницу Восстановить пароль")
    public LoginPage clickToRestorePassword() {
        buttonRestorePassword.click();

        return this;
    }
}

