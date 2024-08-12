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
    @FindBy(xpath = "//lightning-formatted-name[@data-output-element-id=\"output-field\"]")
    WebElement contactName;
    @FindBy(xpath = "//lightning-formatted-phone//a")
    WebElement contactPhone;
    @FindBy(xpath = "//a[@class=\"emailuiFormattedEmail\"]")
    WebElement contactEmail;
    @FindBy(xpath = "//a//div[@class=\"slds-truncate\"][position()=1]")
    WebElement contactMailingStreet;
    @FindBy(xpath = "//a//div[@class=\"slds-truncate\"][position()=2]")
    WebElement contactMailingCityAndPostalCode;
    @FindBy(xpath = "//a//div[@class=\"slds-truncate\"][position()=3]")
    WebElement contactMailingStateAndMailingCountry;

    private final By headerTitle = By.xpath("//span[@class=\"slds-var-p-right_x-small\" and contains(text(),\"Contacts\")]");
    private final By popUpTitle = By.xpath("//h2[@class=\"header slds-modal__title slds-hyphenate slds-text-heading_medium\"and contains(text(), 'New Contact')]");

    public void clickByJs(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",element);
    }
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
        WebElement contactListButton = driver.findElement(By.xpath("//nav[contains(@class,'navCenter')]//a[@title='Contacts']"));
        clickByJs(contactListButton);
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
        fillPostalCodeForm(contactData.getPostalCode());;
        fillMailingCityForm(contactData.getMailingCity());
        fillMailingStateForm(contactData.getMailingState());
        fillMailingCountryForm(contactData.getMailingCountry());
    }
    public boolean checkIfContactExist(String name, String middleName, String lastName){
        By contact = By.xpath("//th//a[@data-refid=\"recordId\" and contains(text(),'"+name+" "+middleName+" "+lastName+"')]");
        return driver.findElement(contact).isDisplayed();
    }
    public void clickSelectedAccount(String name, String middleName, String lastName){
        WebElement contact = driver.findElement(By.xpath("//th//a[@data-refid=\"recordId\" and contains(text(),'"+name+" "+middleName+" "+lastName+"')]"));
        clickByJs(contact);
    }
    public boolean checkIsNameCorrect(ContactData contactData){
        return contactName.getText().equals(contactData.getFirstName()+" "+contactData.getMiddleName()+" "+contactData.getLastName());
    }
    public boolean checkIsPhoneCorrect(ContactData contactData){
        return contactPhone.getText().equals(contactData.getPhone());
    }
    public boolean checkIsEmailCorrect(ContactData contactData){
        return contactEmail.getText().equals(contactData.getEmail());
    }
    public boolean checkIsMailingStreetCorrect(ContactData contactData){
        return contactMailingStreet.getText().equals(contactData.getMailingStreet());
    }
    public boolean checkIsMailingCityAndPostalCodeCorrect(ContactData contactData){
        return contactMailingCityAndPostalCode.getText().equals(contactData.getPostalCode()+" "+contactData.getMailingCity());
    }
    public boolean checkIsMailingStateAndMailingCountryCorrect(ContactData contactData){
        return contactMailingStateAndMailingCountry.getText().equals(contactData.getMailingState()+" "+contactData.getMailingCountry());
    }




}
