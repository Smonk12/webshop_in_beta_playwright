package webshop.tests;

import org.junit.jupiter.api.*;
import webshop.pages.CartPage;
import webshop.pages.CheckoutPage;
import webshop.pages.LoginPage;
import webshop.pages.MainPage;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutPageTests extends BaseTest {

    private MainPage mainPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeEach
    void setUpTest() {
        loginPage = new LoginPage(page);
        page.navigate(BASE_URL);
        loginPage.loginAs(VALID_USERNAME, VALID_PASSWORD);

        mainPage = new MainPage(page);
    }

    @Test
    void testCheckoutWithEmptyCartIsNotAllowed() {
        mainPage.openCart();
        cartPage = new CartPage(page);

        cartPage.clearCart();
        mainPage.openCart();

        cartPage.clickCheckout();

        assertTrue(
                page.url().contains("cart"),
                "User should not be able to proceed to checkout with empty cart"
        );
    }

    @Test
    void testSuccessfulCheckout() {
        mainPage.addToCartByName("Sauce Labs Backpack");

        mainPage.openCart();
        cartPage = new CartPage(page);

        cartPage.clickCheckout();

        checkoutPage = new CheckoutPage(page);
        checkoutPage.fillCheckoutInformation("John", "Doe", "12345");

        checkoutPage.finishCheckout();

        assertTrue(checkoutPage.isCheckoutComplete(), "Checkout should be completed");

        assertTrue(
                checkoutPage.getConfirmationText().toLowerCase().contains("thank"),
                "Confirmation message should be visible"
        );
    }
}
