package webshop.pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.ArrayList;
import java.util.List;

public class MainPage {

    private final Page page;

    private final Locator burgerMenu;
    private final Locator logoutButton;
    private final Locator inventoryItems;
    private final Locator itemName;
    private final Locator addToCartButton;
    private final Locator shoppingCartButton;

    public MainPage(Page page) {
        this.page = page;
        this.burgerMenu         = page.locator("#react-burger-menu-btn");
        this.logoutButton       = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout"));
        this.inventoryItems     = page.locator("[data-test='inventory-item']");
        this.itemName           = page.locator("[data-test='inventory-item-name']");
        this.addToCartButton    = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart"));
        this.shoppingCartButton = page.locator("[data-test='shopping-cart-link']");
    }

    public void logout() {
        burgerMenu.click();
        logoutButton.click();
    }

    public List<String> getAllProductNames() {
        page.waitForSelector("[data-test='inventory-item']");
        List<String> names = new ArrayList<>();
        for (Locator item : inventoryItems.all()) {
            names.add(item.locator(itemName).innerText());
        }
        return names;
    }

    public void openProductByName(String name) {
        page.waitForSelector("[data-test='inventory-item']");
        for (Locator item : inventoryItems.all()) {
            Locator nameLocator = item.locator(itemName);
            if (nameLocator.innerText().equals(name)) {
                nameLocator.click();
                return;
            }
        }
        throw new RuntimeException("Product not found: " + name);
    }

    public void openCart() {
        shoppingCartButton.click();
    }

    public void addToCartByName(String name) {
        page.waitForSelector("[data-test='inventory-item']");
        for (Locator item : inventoryItems.all()) {
            Locator nameLocator = item.locator(itemName);
            if (nameLocator.innerText().equals(name)) {
                item.locator(addToCartButton).click();
                return;
            }
        }
        throw new RuntimeException("Item not found: " + name);
    }
}