package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalesPage extends BasePage {
    public SalesPage(WebDriver driver) {
        super(driver);
    }

    public AccountsPage selectAccountsPage() {
        click(getSubPage("Accounts"));
        return new AccountsPage(driver);
    }
    public ContactsPage selectContactsPage(){
        click(getSubPage("Contacts"));
        return new ContactsPage(driver);
    }
    private WebElement getSubPage(String subPageName) {
        return driver.findElement(By.xpath("//nav[contains(@class,'navCenter')]//a[@title='" + subPageName + "']"));
    }
}
