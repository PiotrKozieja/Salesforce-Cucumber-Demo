package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    protected WebDriver driver;
    private final By appLauncherButton = By.xpath("//button[@title='App Launcher']");
    private final By searchAppField = By.xpath("//input[@placeholder='Search apps and items...']");
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }


}
