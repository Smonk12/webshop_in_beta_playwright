package webshop.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import webshop.pages.MainPage;
import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTests extends BaseTest {

    @Test
    void testValidLogin() {
        loginPage.loginAs(VALID_USERNAME, VALID_PASSWORD);
        assertTrue(loginPage.isLoginSuccessful(), "Expected login to succeed");
    }

    @Test
    void testInvalidLogin() {
        loginPage.loginAs("wrong_user", "wrong_pass");
        assertTrue(loginPage.hasErrorMessage("Username and password do not match"));
    }

    @Test
    void testEmptyUsername() {
        loginPage.loginAs("", VALID_PASSWORD);
        assertTrue(loginPage.hasErrorMessage("Username is required"));
    }

    @Test
    void testEmptyPassword() {
        loginPage.loginAs(VALID_USERNAME, "");
        assertTrue(loginPage.hasErrorMessage("Password is required"));
    }

    @Test
    void testLogout() {
        loginPage.loginAs(VALID_USERNAME, VALID_PASSWORD);

        MainPage mainPage = new MainPage(page);

        mainPage.addToCartByName("Sauce Labs Backpack");
        mainPage.addToCartByName("Sauce Labs Bike Light");

        mainPage.logout();

        assertTrue(page.url().contains("saucedemo.com"));
    }
}