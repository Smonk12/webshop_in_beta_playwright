package webshop.tests;

import org.junit.jupiter.api.*;
import webshop.pages.LoginPage;
import webshop.pages.MainPage;
import webshop.pages.ProductDetailPage;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDetailPageTests extends BaseTest {

    private MainPage mainPage;
    private ProductDetailPage productDetailPage;

    @BeforeEach
    void setUpTest() {
        loginPage = new LoginPage(page);
        page.navigate(BASE_URL);
        loginPage.loginAs(VALID_USERNAME, VALID_PASSWORD);

        mainPage = new MainPage(page);
    }

    @Test
    void testUserCanViewProductDetails() {
        mainPage.openProductByName("Sauce Labs Backpack");

        productDetailPage = new ProductDetailPage(page);

        assertTrue(productDetailPage.isTitleVisible());
        assertTrue(productDetailPage.isDescriptionVisible());
        assertTrue(productDetailPage.isPriceVisible());
        assertTrue(productDetailPage.isImageVisible());

        productDetailPage.goBackToProducts();

        assertTrue(page.url().contains("inventory"),
                "Expected to be back on product listing page");
    }
}
