package webshop.tests;

import org.junit.jupiter.api.*;
import webshop.pages.CartPage;
import webshop.pages.LoginPage;
import webshop.pages.MainPage;

import static org.junit.jupiter.api.Assertions.*;

public class CartPageTests extends BaseTest {

    private MainPage mainPage;
    private CartPage cartPage;

    @BeforeEach
    void setUpTest() {
        loginPage = new LoginPage(page);
        page.navigate(BASE_URL);
        loginPage.loginAs(VALID_USERNAME, VALID_PASSWORD);

        mainPage = new MainPage(page);
    }

    @Test
    void testUserCanAddAndRemoveItems() {
        mainPage.openCart();
        cartPage = new CartPage(page);
        cartPage.clearCart();

        // Add item
        mainPage.addToCartByName("Sauce Labs Backpack");
        mainPage.openCart();

        // Check if item is in cart
        assertTrue(cartPage.checkIfItemIsInCart("Sauce Labs Backpack"));

        // Remove item
        cartPage.removeItemFromCartByName("Sauce Labs Backpack");

        // Check if item is out of cart
        assertFalse(cartPage.checkIfItemIsInCart("Sauce Labs Backpack"));
    }

    @Test
    void testCartTotalPriceUpdates() {
        mainPage.openCart();
        cartPage = new CartPage(page);
        cartPage.clearCart();

        // Add first product
        mainPage.addToCartByName("Sauce Labs Backpack");
        mainPage.openCart();
        assertEquals(29.99, cartPage.getCartTotal());
        cartPage.returnToMainPage();

        // Add second product
        mainPage.addToCartByName("Sauce Labs Bike Light");
        mainPage.openCart();
        assertEquals(29.99 + 9.99, cartPage.getCartTotal());

        // Remove first product
        cartPage.removeItemFromCartByName("Sauce Labs Backpack");
        assertEquals(9.99, cartPage.getCartTotal());

        // Final total check
        assertEquals(9.99, cartPage.getCartTotal());
    }
}
