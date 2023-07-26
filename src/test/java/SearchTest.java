
import org.example.drivers.DriverCreator;
import org.example.models.Item;
import org.example.pages.HomePage;
import org.example.pages.LauncherPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public  class SearchTest{


    @Test
    public void verifyIfSearchTermShowsRelevantResults() {
        String searchItem = "Jeans";
        String searchKey = "Jean";
        String browser = "chrome";
        WebDriver webDriver = new DriverCreator().create(browser);
        LauncherPage launcherPage = new LauncherPage(webDriver);
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        //Act
        HomePage homepage = new HomePage(webDriver);
        homepage.search(searchItem);
        List<Item> searchItems = homepage.getSearchItems();

        //Assert
        Assert.assertEquals(4, searchItems.size());
        Assert.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(searchKey)));
    }
    @Test
    public void verifySearchUnavailableProduct() {
        // Arrange
        String unavailableProduct = "Unobtainium Widget";
        WebDriver webDriver = null;

        LauncherPage launcherPage = new LauncherPage(webDriver);
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        // Act
        HomePage homepage = new HomePage(webDriver);
        homepage.search(unavailableProduct);
        List<Item> searchItems = homepage.getSearchItems();

        // Assert
        Assert.assertTrue(searchItems.isEmpty());
    }

    @Test
    public void verifyBrandSearchListsOnlyBrandItems() {
        // Arrange
        String brandName = "Nike";
        WebDriver webDriver = null;

        LauncherPage launcherPage = new LauncherPage(webDriver);
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        // Act
        HomePage homepage = new HomePage(webDriver);
        homepage.search(brandName);
        List<Item> searchItems = homepage.getSearchItems();

        // Assert
        Assert.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(brandName)));
    }


    @Test
    public void verifySearchResultCountMatchesDisplayedItems() {
        // Arrange
        String searchItem = "Shoes";
        WebDriver webDriver = null;

        LauncherPage launcherPage = new LauncherPage(webDriver);
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        // Act
        HomePage homepage = new HomePage(webDriver);
        homepage.search(searchItem);
        List<Item> searchItems = homepage.getSearchItems();
        int itemCountDisplayed = homepage.getItemCount(); // Assume getItemCount method returns the number displayed on the page

        // Assert
        Assert.assertEquals(searchItems.size(), itemCountDisplayed);
    }

}