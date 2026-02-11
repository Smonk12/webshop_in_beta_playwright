package webshop.pages;

import com.microsoft.playwright.*;

import java.util.List;

public class CartPage {

    private final Page page;

    private final Locator checkoutButton;
    private final Locator cartItems;
    private final Locator itemName;
    private final Locator continueShoppingButton;

    public CartPage(Page page) {
        this.page = page;
        this.checkoutButton = page.locator("#checkout");
        this.cartItems = page.locator("div[data-test='inventory-item']");
        this.itemName = page.locator("div[data-test='inventory-item-name']");
        this.continueShoppingButton = page.locator("#continue-shopping");
    }

    public void removeItemFromCartByName(String name) {
        String formattedName = name.replace(" ", "-").toLowerCase();
        String removeButtonId = "remove-" + formattedName;

        Locator removeButton = page.locator("#" + removeButtonId);
        removeButton.click(); // auto-waits
    }

    public void clearCart() {
        continueShoppingButton.waitFor();

        while (cartItems.count() > 0) {
            Locator firstItem = cartItems.first();
            String name = firstItem.locator(itemName).innerText();
            removeItemFromCartByName(name);

        }

        continueShoppingButton.click();
    }

    public boolean checkIfItemIsInCart(String name) {
        continueShoppingButton.waitFor();

        int count = cartItems.count();
        for (int i = 0; i < count; i++) {
            Locator item = cartItems.nth(i);
            String currentName = item.locator(itemName).innerText();
            if (currentName.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public double getCartTotal() {
        cartItems.first().waitFor();

        double total = 0.0;
        int count = cartItems.count();

        for (int i = 0; i < count; i++) {
            Locator item = cartItems.nth(i);
            String priceText = item.locator("[data-test='inventory-item-price']").innerText();
            priceText = priceText.replace("$", "");
            total += Double.parseDouble(priceText);
        }
        return total;
    }

    public void returnToMainPage() {
        continueShoppingButton.click();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }
}
