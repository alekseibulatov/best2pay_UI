package com.bulatov.web.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

/**
 * @author alekseibulatov (Aleksei Bulatov)
 */

@Feature("MainPage")
@DisplayName("Тестирование главной страницы")
public class MainPageTests extends WebTestBase {

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Главная страница сайта загружена ")
    @Tags({@Tag("ui"), @Tag("smoke")})
    void currentOpenMainPageTest() {
        mainPage.openPage()
                .verificationMainPage();
    }

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка отображения в header_menu кнопок 'Банкам и МФО', 'Бизнесу', " +
            "'Агрегаторам (BAAS)', 'Поддержка'")
    @Tags({@Tag("ui"), @Tag("smoke")})
    void verificationMainPageTest() {
        mainPage.openPage()
                .verificationHeaderMainPage();
    }

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка перехода в личный кабинет при клике по кнопке 'Войти на главной странице'")
    @Tags({@Tag("ui"), @Tag("smoke")})
    void verificationFollowingByLinkEnter() {
        mainPage.openPage()
                .clickToButtonEnter();
        loginPage.displayOnPageTitle();
    }
}

