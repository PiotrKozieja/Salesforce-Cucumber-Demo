package org.example.pages;

import org.example.forms.AccountForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CreateAccountPage extends BasePage {

    private final By newButton = By.xpath("//div[@title='New']");

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public AccountForm clickNewAccountButton() {
        click(driver.findElement(newButton));
        return new AccountForm(driver);
    }

    public AccountPage getAccountPageByName(String accountName) {
        click(driver.findElement(By.xpath("//a[@title='" + accountName + "']")));
        return new AccountPage(driver);
    }

}
