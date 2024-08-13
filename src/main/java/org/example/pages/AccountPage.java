package org.example.pages;

import org.example.forms.AccountForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage extends BasePage {

    private final By activePage = By.xpath("//div[@class='windowViewMode-normal oneContent active lafPageHost']");
    private final By detailsTab = By.xpath("//a[@id='detailTab__item']");
    private final By editButton = By.xpath("//button[@name='Edit']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void goToDetails() {
        getActivePage().findElement(detailsTab).click();
    }

    public AccountForm clickEditButton() {
        click(driver.findElement(editButton));
        return new AccountForm(driver);
    }

    private WebElement getActivePage() {
        return driver.findElement(activePage);
    }

    public void searchForAccount(String accountName) throws InterruptedException {
        clickSearchButton();
        setMainSearchInput(accountName);
        click(driver.findElement(By.xpath("//search_dialog-instant-result-item//span[@title='" + accountName + "']")));
        Thread.sleep(2000);
        driver.navigate().refresh(); // Needs to be here, otherwise test will open previous account edit form
    }
}
