package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    protected WebDriver driver;
    private JavascriptExecutor executor;
    protected WebDriverWait wait;
    private final By appLauncherButton = By.xpath("//button[@title='App Launcher']");
    private final By searchAppField = By.xpath("//input[@placeholder='Search apps and items...']");
    private final By searchButton = By.cssSelector("button.search-button");
    private final By mainSearchInput = By.xpath("//div[contains(@class,'assistantPanel')]//input[@type='search']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public SalesPage goToSalesPage() {
        String pageTitle = "Sales";
        clickAppLauncher();
        setSearchAppField(pageTitle);
        click(getAppButton(pageTitle));
        return new SalesPage(driver);
    }

    private void clickAppLauncher() {
        driver.findElement(appLauncherButton).click();
    }

    private void setSearchAppField(String appName) {
        driver.findElement(searchAppField).sendKeys(appName);
    }

    private WebElement getAppButton(String appName) {
        return driver.findElement(By.xpath("//one-app-launcher-menu-item//div[.='" + appName + "']"));
    }

    protected void click(WebElement element) {
        executor.executeScript("arguments[0].click();", element);
    }

    protected void scrollTo(WebElement element) {
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickSearchButton() {
        click(driver.findElement(searchButton));
    }

    public void setMainSearchInput(String value) {
        WebElement element = driver.findElement(mainSearchInput);
        element.clear();
        element.sendKeys(value);
    }

    protected WebElement getSubPage(String subPageName) {
        return driver.findElement(By.xpath("//nav[contains(@class,'navCenter')]//a[@title='" + subPageName + "']"));
    }

    protected String getInputValue(WebElement inputField) {
        return inputField.getAttribute("value");
    }

    public CreateAccountPage selectAccountsPage() {
        click(getSubPage("Accounts"));
        return new CreateAccountPage(driver);
    }
    public ContactsPage selectContactsPage() {
        click(getSubPage("Contacts"));
        return new ContactsPage(driver);
    }
    public WebElement getFieldByName(String inputName) {
        return driver.findElement(By.xpath("//input[@name='" + inputName + "']"));
    }
    public WebElement getButtonByName(String labelName) {
        return driver.findElement(By.xpath("//button[@aria-label='" + labelName + "']"));
    }
    public void selectOptionFromDropdown(String labelName, String optionName) {
        WebElement button = getButtonByName(labelName);
        scrollTo(button);
        click(button);
        WebElement option = driver.findElement(By.xpath("//div[@aria-label='" + labelName + "']//span[@title='" + optionName + "']"));
        scrollTo(option);
        click(option);
    }
}
