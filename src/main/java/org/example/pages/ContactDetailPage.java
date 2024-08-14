package org.example.pages;

import org.example.forms.ContactForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ContactDetailPage extends BasePage{

    private final By editButton = By.xpath("//button[@name=\"Edit\"]");

    public ContactDetailPage(WebDriver driver) {
        super(driver);
    }

    public ContactForm clickEditButton(){
        click(driver.findElement(editButton));
        return new ContactForm(driver);
    }
}
