package org.example.pages;


import org.example.forms.ContactForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ContactsPage extends BasePage{

    private  final By newButton = By.xpath("//lightning-button[@class=\"middleButton\"]//button[@lwc-40a585din3p]");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    public ContactForm goToNewContactForm(){
        click(driver.findElement(newButton));
        return new ContactForm(driver);
    }
    public ContactDetailPage getContactPageByName(String contactName) {
        driver.navigate().refresh();
        click(driver.findElement(By.xpath("//a[@title='" + contactName + "']")));
        return new ContactDetailPage(driver);
    }
}
