package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By headerTitle = By.xpath("//h1//span[text()='Home']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageDisplayed() {
        return driver.findElement(headerTitle).isDisplayed();
    }
}
