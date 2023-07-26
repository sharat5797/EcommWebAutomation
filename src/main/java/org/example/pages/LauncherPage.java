package org.example.pages;

import org.openqa.selenium.WebDriver;

public class LauncherPage {
    private WebDriver webDriver;
    public LauncherPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void navigateTo(String url) {
        webDriver.get(url);
    }
}
