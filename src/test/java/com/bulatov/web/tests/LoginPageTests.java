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

@Feature("LoginPage")
@DisplayName("Тестирование  страницы авторизации")
public class LoginPageTests extends WebTestBase {

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация на сайте без ввода логина и пароля")
    @Tags({@Tag("ui"), @Tag("smoke")})
    void unsuccessfulLoginOnLoginPageTest() {
        loginPage.openLoginPage()
                .displayOnPageTitle()
                .setEmail("")
                .setPassword("")
                .clickToButtonLogin()
                .unsuccessfulLogin();
    }

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Переход при клике по ссылке Восстановить пароль на странице авторизации")
    @Tags({@Tag("ui"), @Tag("smoke")})
    void clickToRestorePasswordOnLoginPageTest() {
        loginPage.openLoginPage()
                .clickToRestorePassword();

        restorePage.displayOnRestorePageTitle();
    }
}
