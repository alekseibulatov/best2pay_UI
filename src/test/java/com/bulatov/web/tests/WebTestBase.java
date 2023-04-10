package com.bulatov.web.tests;

import com.bulatov.config.WebDriverProvider;
import com.bulatov.helpers.Attach;
import com.bulatov.web.pages.LoginPage;
import com.bulatov.web.pages.MainPage;
import com.bulatov.web.pages.RestorePage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class WebTestBase {


    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    RestorePage restorePage = new RestorePage();


    @Step("Выполняем настройку запуска")
    @BeforeAll
    static void beforeAll() {
        WebDriverProvider.config();
    }

    @BeforeEach
    void addListener() {
        Configuration.pageLoadTimeout = 30000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Step("Загрузка Attachments")
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
