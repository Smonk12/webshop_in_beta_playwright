package webshop.pages;

import com.microsoft.playwright.*;

public class CheckoutPage {

    private final Page page;

    // Checkout-step-one
    private final Locator firstNameField;
    private final Locator lastNameField;
    private final Locator zipPostalCodeField;
    private final Locator continueButton;

    // Checkout-step-two
    private final Locator itemPrice;
    private final Locator totalPrice;
    private final Locator finishButton;

    // Checkout-final
    private final Locator completionConfirmation;
    private final Locator backToHomeButton;

    public CheckoutPage(Page page) {
        this.page = page;

        // Step one
        this.firstNameField = page.locator("#first-name");
        this.lastNameField = page.locator("#last-name");
        this.zipPostalCodeField = page.locator("#postal-code");
        this.continueButton = page.locator("#continue");

        // Step two
        this.itemPrice = page.locator("div[data-test='inventory-item-price']");
        this.totalPrice = page.locator("div[data-test='subtotal-label']");
        this.finishButton = page.locator("#finish");

        // Final step
        this.completionConfirmation = page.locator("h2[data-test='complete-header']");
        this.backToHomeButton = page.locator("#back-to-products");
    }

    public void fillCheckoutInformation(String firstName, String lastName, String zip) {
        firstNameField.fill(firstName);
        lastNameField.fill(lastName);
        zipPostalCodeField.fill(zip);
        continueButton.click();
    }

    public void finishCheckout() {
        finishButton.click();
    }

    public boolean isCheckoutComplete() {
        return completionConfirmation.isVisible();
    }

    public String getConfirmationText() {
        return completionConfirmation.innerText();
    }

    public void goBackToHome() {
        backToHomeButton.click();
    }
}
