package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private final By headerTitle = By.xpath("//h1//span[text()='Home']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageDisplayed() {
        return driver.findElement(headerTitle).isDisplayed();
    }

    public ContactsPage selectContactsPage() {
        click(getSubPage("Contacts"));
        return new ContactsPage(driver);
    }
}
