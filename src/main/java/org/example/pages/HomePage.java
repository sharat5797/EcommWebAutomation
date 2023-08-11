package org.example.pages;

import org.example.models.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    By searchIcon = By.xpath("//*[@id=\"shopify-section-header\"]/sticky-header/header/div/details-modal/details/summary");
    By searchBar = By.id("Search-In-Modal");
    By searchResults = By.cssSelector("li[id^='predictive-search-option'] a");
    By productName = By.cssSelector(".predictive-search__item-heading h5");

    public HomePage (WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage search(String searchItem) {
        webDriver.findElement(searchIcon).click();
        webDriver.findElement(searchBar).sendKeys(searchItem);
        return this;
    }

    public List<Item> getSearchItems() {
        List<WebElement> elements = waits.waitUntilAllElementsAreVisible(searchResults);
        List<Item> items = new ArrayList<>();
        for (WebElement element: elements) {
            String name = element.findElement(productName).getText();
            Item item = new Item();
            item.setName(name);
            items.add(item);
        }
        return items;
    }

//    public int getItemCount(){
//        return getSearchItems().size();
//    }
}
