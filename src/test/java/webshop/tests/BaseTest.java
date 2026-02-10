package webshop.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import webshop.pages.LoginPage;
import webshop.utils.EnvReader;

public abstract class BaseTest {

    protected static Playwright playwright;
    protected static Browser browser;

    protected BrowserContext context;
    protected Page page;
    protected LoginPage loginPage;

    protected static final String BASE_URL = EnvReader.get("BASE_URL");
    protected static final String VALID_USERNAME = EnvReader.get("VALID_USERNAME");
    protected static final String VALID_PASSWORD = EnvReader.get("VALID_PASSWORD");

    @BeforeAll
    static void setUpAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeEach
    void setUp() {
        context = browser.newContext();
        page = context.newPage();
        loginPage = new LoginPage(page);
        page.navigate(BASE_URL);
    }

    @AfterEach
    void tearDown() {
        if (page != null) page.close();
        if (context != null) context.close();
    }

    @AfterAll
    static void tearDownAll() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}