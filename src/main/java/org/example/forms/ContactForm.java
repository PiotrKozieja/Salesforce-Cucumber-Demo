package org.example.forms;

import org.example.data.ContactData;
import org.example.pages.BasePage;
import org.example.pages.ContactDetailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactForm extends BasePage {

    private final By mailingStreetForm = By.xpath("//textarea[@name=\"street\"]");
    private final By saveButton = By.xpath("//button[@name='SaveEdit']");
    private final By saveAndNewButton = By.xpath("//button[@name='SaveAndNew']");

    public ContactForm(WebDriver driver){super(driver);}

    public ContactDetailPage clickSaveButton() {
        driver.findElement(saveButton).click();
        return new ContactDetailPage(driver);
    }

    public void clickSaveAndNewButton() {
        driver.findElement(saveAndNewButton).click();
    }

    public void setFirstName(String firstName) {
        getFieldByName("firstName").sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        getFieldByName("lastName").sendKeys(lastName);
    }

    public void setPhone(String phone) {
        getFieldByName("Phone").sendKeys(phone);
    }

    public void setHomePhone(String homePhone) {
        getFieldByName("HomePhone").sendKeys(homePhone);
    }

    public void setTitle(String title) {
        getFieldByName("Title").sendKeys(title);
    }

    public void setDepartment(String department) {getFieldByName("Department").sendKeys(department);}

    public void setFax(String fax) {
        getFieldByName("Fax").sendKeys(fax);
    }

    public void setEmail(String email) {
        getFieldByName("Email").sendKeys(email);
    }

    public void setAssistant(String assistant) {
        getFieldByName("AssistantName").sendKeys(assistant);
    }

    public void setAssistantPhone(String assistantPhone) {
        getFieldByName("AssistantPhone").sendKeys(assistantPhone);
    }

    public void setMailingStreet(String mailingStreet) {driver.findElement(mailingStreetForm).sendKeys(mailingStreet);}

    public void setPostalCode(String postalCode) {
        getFieldByName("postalCode").sendKeys(postalCode);
    }

    public void setMailingCity(String mailingCity) {
        getFieldByName("city").sendKeys(mailingCity);
    }

    public void setMailingState(String mailingState) {
        getFieldByName("province").sendKeys(mailingState);
    }

    public void setMailingCountry(String mailingCountry) {
        getFieldByName("country").sendKeys(mailingCountry);
    }

    public void setLanguage(String language){getFieldByName("Languages__c").sendKeys(language);}

    public void setLeadSource(String leadSource){selectOptionFromDropdown("Lead Source",leadSource);}

    public void setSalutation(String salutation){selectOptionFromDropdown("Salutation",salutation);}

    public void setLanguageLevel(String languageLevel){selectOptionFromDropdown("Level",languageLevel);}

    public String getFirstName() {
        return getInputValue(getFieldByName("firstName"));
    }

    public String getLastName() {
        return getInputValue(getFieldByName("lastName"));
    }

    public String getPhone() {
        return getInputValue(getFieldByName("Phone"));
    }

    public String getHomePhone() {
        return getInputValue(getFieldByName("HomePhone"));
    }

    public String getTitle() {
        return getInputValue(getFieldByName("Title"));
    }

    public String getDepartment() {
        return getInputValue(getFieldByName("Department"));
    }

    public String getFax() {
        return getInputValue(getFieldByName("Fax"));
    }

    public String getEmail() {
        return getInputValue(getFieldByName("Email"));
    }

    public String getAssistant() {
        return getInputValue(getFieldByName("AssistantName"));
    }

    public String getAssistantPhone() {
        return getInputValue(getFieldByName("AssistantPhone"));
    }

    public String getMailingStreet() {
        return getInputValue(driver.findElement(mailingStreetForm));
    }

    public String getPostalCode() {
        return getInputValue(getFieldByName("postalCode"));
    }

    public String getMailingCity() {
        return getInputValue(getFieldByName("city"));
    }

    public String getMailingState() {
        return getInputValue(getFieldByName("province"));
    }

    public String getMailingCountry() {
        return getInputValue(getFieldByName("country"));
    }

    public String getLanguage() {
        return getInputValue(getFieldByName("Languages__c"));
    }

    public String getSalutation() {
        return getInputValue(getFieldByName("Salutation"));
    }

    public void fillContactInformation(ContactData contactData){
        setFirstName(contactData.getFirstName());
        setLastName(contactData.getLastName());
        setPhone(contactData.getPhone());
        setHomePhone(contactData.getHomePhone());
        setTitle(contactData.getTitle());
        setDepartment(contactData.getDepartment());
        setFax(contactData.getFax());
        setEmail(contactData.getEmail());
        setAssistant(contactData.getAssistant());
        setAssistantPhone(contactData.getAssistantPhone());
        setMailingStreet(contactData.getMailingStreet());
        setPostalCode(contactData.getPostalCode());
        setMailingCity(contactData.getMailingCity());
        setMailingState(contactData.getMailingState());
        setMailingCountry(contactData.getMailingCountry());
        setLanguage(contactData.getLanguage());
        setLeadSource(contactData.getLeadSource());
        setLanguageLevel(contactData.getLanguageLevel());
        setSalutation(contactData.getSalutation());
    }
    public ContactData getContactInformation(){
        ContactData contactData = new ContactData();
        contactData.setFirstName(getFirstName());
        contactData.setLastName(getLastName());
        contactData.setPhone(getPhone());
        contactData.setHomePhone(getHomePhone());
        contactData.setTitle(getTitle());
        contactData.setDepartment(getDepartment());
        contactData.setFax(getFax());
        contactData.setEmail(getEmail());
        contactData.setAssistant(getAssistant());
        contactData.setAssistantPhone(getAssistantPhone());
        contactData.setMailingStreet(getMailingStreet());
        contactData.setPostalCode(getPostalCode());
        contactData.setMailingCity(getMailingCity());
        contactData.setMailingState(getMailingState());
        contactData.setMailingCountry(getMailingCountry());
        contactData.setLanguage(getLanguage());
        return contactData;
    }
}
