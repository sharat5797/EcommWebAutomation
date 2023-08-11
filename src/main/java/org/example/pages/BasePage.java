package org.example.pages;

import org.example.pages.PageWaits;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected PageWaits waits;
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.waits = new PageWaits(webDriver);
    }
}
  