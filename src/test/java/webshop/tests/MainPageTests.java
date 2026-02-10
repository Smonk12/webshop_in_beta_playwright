package webshop.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import webshop.pages.MainPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageTests extends BaseTest {

    private MainPage mainPage;

    @BeforeEach
    void setUpMain() {
        super.setUp();
        loginPage.loginAs(VALID_USERNAME, VALID_PASSWORD);
        mainPage = new MainPage(page);
    }

    @Test
    void testProductsAreSortedByName() {
        List<String> actualNames = mainPage.getAllProductNames();

        List<String> sortedNames = new ArrayList<>(actualNames);
        Collections.sort(sortedNames);

        assertEquals(sortedNames, actualNames, "Products should be sorted by name");
    }
}