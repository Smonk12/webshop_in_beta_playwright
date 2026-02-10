package webshop.pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {

    private final Page page;

    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator errorMessage;

    public LoginPage(Page page) {
        this.page = page;
        this.usernameInput = page.locator("[data-test='username']");
        this.passwordInput = page.locator("[data-test='password']");
        this.loginButton   = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
        this.errorMessage  = page.locator("h3[data-test='error']");
    }

    public void loginAs(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        return page.locator("[data-test='inventory-container']").isVisible();
    }

    public boolean hasErrorMessage(String text) {
        return errorMessage.isVisible() &&
                errorMessage.innerText().contains(text);
    }
}