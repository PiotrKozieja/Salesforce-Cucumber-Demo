package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage extends BasePage {

    private final By newButton = By.xpath("//div[@title='New']");
    private final By accountNameField = By.name("Name");
    private final By accountNumberField = By.name("AccountNumber");
    private final By accountSiteField = By.name("Site");
    

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public void clickNewButton() {
        click(driver.findElement(newButton));
    }
}
