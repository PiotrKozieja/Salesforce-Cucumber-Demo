package org.example.pages;

import org.example.data.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage{
    @FindBy(xpath = "//a[@title=\"New\"]")
    WebElement newButton;
    @FindBy(xpath = "//li[@class=\"slds-button-group-item visible\" and  @data-target-selection-name=\"sfdc:StandardButton.Contact.SaveEdit\"]")
    WebElement saveButton;
    @FindBy(xpath = "//input[@name=\"Title\"]")
    WebElement titleForm;
    @FindBy(xpath = "//input[@name=\"Email\"]")
    WebElement emailForm;
    @FindBy(xpath = "//input[@name=\"Phone\"]")
    WebElement phoneForm;
    @FindBy(xpath = "//input[@name=\"firstName\"]")
    WebElement firstNameForm;
    @FindBy(xpath = "//input[@name=\"middleName\"]")
    WebElement middleNameForm;
    @FindBy(xpath = "//input[@name=\"lastName\"]")
    WebElement lastNameForm;
    @FindBy(xpath = "//textarea[@autocomplete=\"street-address\"]")
    WebElement mailingStreetForm;
    @FindBy(xpath = "//input[@autocomplete=\"postal-code\"]")
    WebElement postalCodeForm;
    @FindBy(xpath = "//input[@autocomplete=\"address-level2\"]")
    WebElement mailingCityForm;
    @FindBy(xpath = "//input[@autocomplete=\"address-level1\"]")
    WebElement mailingStateForm;
    @FindBy(xpath = "//input[@autocomplete=\"country\"]")
    WebElement mailingCountryForm;

    private final By headerTitle = By.xpath("//span[@class=\"slds-var-p-right_x-small\" and contains(text(),\"Contacts\")]");
    private final By popUpTitle = By.xpath("//h2[@class=\"header slds-modal__title slds-hyphenate slds-text-heading_medium\"and contains(text(), 'New Contact')]");

    public ContactsPage(WebDriver driver){
        super(driver);
    }
    public void clickNewButton(){
        newButton.click();
    }
    public void clickSaveButton(){
        saveButton.click();
    }
    public void goToContactList(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement contactListButton = driver.findElement(By.xpath("//nav[contains(@class,'navCenter')]//a[@title='Contacts']"));
        executor.executeScript("arguments[0].click();", contactListButton);
    }
    public boolean isContactsPageOpened(){
        return driver.findElement(headerTitle).isDisplayed();
    }
    public boolean isNewContactPopUpOpened(){
        return driver.findElement(popUpTitle).isDisplayed();
    }
    public void fillTitleForm(String title){
        titleForm.sendKeys(title);
    }
    public void fillPhoneForm(String phone){
        phoneForm.sendKeys(phone);
    }
    public void fillEmailForm(String email){
        emailForm.sendKeys(email);
    }
    public void fillFirstNameForm(String firstName){
        firstNameForm.sendKeys(firstName);
    }
    public void fillMiddleNameForm(String middleName){
        middleNameForm.sendKeys(middleName);
    }
    public void fillLastNameForm(String lastName) {
        lastNameForm.sendKeys(lastName);
    }
    public void fillMailingStreetForm(String mailingStreet){
        mailingStreetForm.sendKeys(mailingStreet);
    }
    public void fillPostalCodeForm(String postalCode){
        postalCodeForm.sendKeys(postalCode);
    }
    public void fillMailingCityForm(String mailingCity){
        mailingCityForm.sendKeys(mailingCity);
    }
    public void fillMailingStateForm(String mailingState){
        mailingStateForm.sendKeys(mailingState);
    }
    public void fillMailingCountryForm(String mailingCountry){
        mailingCountryForm.sendKeys(mailingCountry);
    }
    public void fillAllForms(ContactData contactData){
        fillTitleForm(contactData.getTitle());
        fillPhoneForm(contactData.getPhone());
        fillEmailForm(contactData.getEmail());
        fillFirstNameForm(contactData.getFirstName());
        fillMiddleNameForm(contactData.getMiddleName());
        fillLastNameForm(contactData.getLastName());
        fillMailingStreetForm(contactData.getMailingStreet());
        fillPostalCodeForm(contactData.getPostalCode());
        fillMailingCityForm(contactData.getMailingCity());
        fillMailingStateForm(contactData.getMailingState());
        fillMailingCountryForm(contactData.getMailingCountry());
    }
    public boolean checkIfContactExist(String name, String middleName, String lastName){
        By contact = By.xpath("//th//a[@data-refid=\"recordId\" and contains(text(),'"+name+" "+middleName+" "+lastName+"')]");
        return driver.findElement(contact).isDisplayed();
    }



}
