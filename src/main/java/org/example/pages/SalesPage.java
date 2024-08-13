package org.example.pages;

import org.openqa.selenium.WebDriver;

public class SalesPage extends BasePage {
    public SalesPage(WebDriver driver) {
        super(driver);
    }

    public ContactsPage selectContactsPage() {
        click(getSubPage("Contacts"));
        return new ContactsPage(driver);
    }
}
