package webshop.pages;

import com.microsoft.playwright.*;

public class ProductDetailPage {

    private final Page page;

    private final Locator title;
    private final Locator description;
    private final Locator price;
    private final Locator image;
    private final Locator backButton;

    public ProductDetailPage(Page page) {
        this.page = page;
        this.title = page.locator("div[data-test='inventory-item-name']");
        this.description = page.locator("div[data-test='inventory-item-desc']");
        this.price = page.locator("div[data-test='inventory-item-price']");
        this.image = page.locator("img.inventory_details_img");
        this.backButton = page.locator("#back-to-products");
    }

    public boolean isTitleVisible() {
        return title.isVisible();
    }

    public boolean isDescriptionVisible() {
        return description.isVisible();
    }

    public boolean isPriceVisible() {
        return price.isVisible();
    }

    public boolean isImageVisible() {
        return image.isVisible();
    }

    public void goBackToProducts() {
        backButton.click();
    }
}
