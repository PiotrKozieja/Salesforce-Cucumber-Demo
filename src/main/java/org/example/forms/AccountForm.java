package org.example.forms;

import org.example.data.Account;
import org.example.pages.AccountPage;
import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class AccountForm extends BasePage {

    private final By descriptionField = By.xpath("//records-record-layout-item[@field-label='Description']//textarea");
    private final By saveButton = By.xpath("//button[@name='SaveEdit']");
    private final By saveAndNewButton = By.xpath("//button[@name='SaveAndNew']");
    private final By parentAccountField = By.xpath("//input[@placeholder='Search Accounts...']");
    private final By editForm_parentAccountField = By.xpath("//records-record-layout-item[@field-label='Parent Account']//input");
    private final By closeEditFormButton = By.xpath("//button[@name='CancelEdit']");

    public AccountForm(WebDriver driver) {
        super(driver);
    }

    private WebElement getAddressField(String addressType, String inputName) {
        if (Objects.equals(inputName, "street")) {
            return driver.findElement(By.xpath("//records-record-layout-item[@field-label='" + addressType + "']//textarea"));
        }
        return driver.findElement(By.xpath("//records-record-layout-item[@field-label='" + addressType + "']//input[@name='" + inputName + "']"));
    }

    private String getButtonValue(WebElement button) {
        return button.getAttribute("data-value");
    }

    private WebElement getBillingStreetElement() {
        return getAddressField("Billing Address", "street");
    }

    private WebElement getBillingZipCodeElement() {
        return getAddressField("Billing Address", "postalCode");
    }

    private WebElement getBillingCityElement() {
        return getAddressField("Billing Address", "city");
    }

    private WebElement getBillingStateElement() {
        return getAddressField("Billing Address", "province");
    }

    private WebElement getBillingCountryElement() {
        return getAddressField("Billing Address", "country");
    }

    private WebElement getShippingStreetElement() {
        return getAddressField("Shipping Address", "street");
    }

    private WebElement getShippingZipCodeElement() {
        return getAddressField("Shipping Address", "postalCode");
    }

    private WebElement getShippingCityElement() {
        return getAddressField("Shipping Address", "city");
    }

    private WebElement getShippingStateElement() {
        return getAddressField("Shipping Address", "province");
    }

    private WebElement getShippingCountryElement() {
        return getAddressField("Shipping Address", "country");
    }

    public void setAccountName(String accountName) {
        getFieldByName("Name").sendKeys(accountName);
    }

    public void setAccountNumber(String accountNumber) {
        getFieldByName("AccountNumber").sendKeys(accountNumber);
    }

    public void setAccountSite(String site) {
        getFieldByName("Site").sendKeys(site);
    }

    public void setParentAccount(String parentName) {
        WebElement searchParentInput = driver.findElement(parentAccountField);
        searchParentInput.sendKeys(parentName);
        click(searchParentInput);
        WebElement parentButton = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//records-record-layout-item[@field-label='Parent Account']//strong")));
        click(parentButton);
    }

    public void setType(String typeName) {
        selectOptionFromDropdown("Type", typeName);
    }

    public void setIndustry(String industryName) {
        selectOptionFromDropdown("Industry", industryName);
    }

    public void setAnnualRevenue(String annualRevenue) {
        getFieldByName("AnnualRevenue").sendKeys(annualRevenue);
    }

    public void setRating(String rating) {
        selectOptionFromDropdown("Rating", rating);
    }

    public void setPhone(String phoneNumber) {
        getFieldByName("Phone").sendKeys(phoneNumber);
    }

    public void setFax(String faxNumber) {
        getFieldByName("Fax").sendKeys(faxNumber);
    }

    public void setWebsite(String website) {
        getFieldByName("Website").sendKeys(website);
    }

    public void setTickerSymbol(String symbol) {
        getFieldByName("TickerSymbol").sendKeys(symbol);
    }

    public void setOwnership(String ownership) {
        selectOptionFromDropdown("Ownership", ownership);
    }

    public void setEmployees(String numberOfEmployees) {
        getFieldByName("NumberOfEmployees").sendKeys(numberOfEmployees);
    }

    public void setSicCode(String sicCode) {
        getFieldByName("Sic").sendKeys(sicCode);
    }

    public void setBillingAddress(String street, String zipCode, String city, String state, String country) {
        getBillingStreetElement().sendKeys(street);
        getBillingZipCodeElement().sendKeys(zipCode);
        getBillingCityElement().sendKeys(city);
        getBillingStateElement().sendKeys(state);
        getBillingCountryElement().sendKeys(country);
    }

    public void setShippingAddress(String street, String zipCode, String city, String state, String country) {
        getShippingStreetElement().sendKeys(street);
        getShippingZipCodeElement().sendKeys(zipCode);
        getShippingCityElement().sendKeys(city);
        getShippingStateElement().sendKeys(state);
        getShippingCountryElement().sendKeys(country);
    }

    public void setCustomerPriority(String priority) {
        selectOptionFromDropdown("Customer Priority", priority);
    }

    public void setExpirationDate(String date) {
        getFieldByName("SLAExpirationDate__c").sendKeys(date);
    }

    public void setNumberOfLocations(String numberOfLocations) {
        getFieldByName("NumberofLocations__c").sendKeys(numberOfLocations);
    }

    public void setActiveOption(String option) {
        selectOptionFromDropdown("Active", option);
    }

    public void setSLAOption(String option) {
        selectOptionFromDropdown("SLA", option);
    }

    public void setSlaSerialNumber(String serialNumber) {
        getFieldByName("SLASerialNumber__c").sendKeys(serialNumber);
    }

    public void setUpsellOpportunity(String option) {
        selectOptionFromDropdown("Upsell Opportunity", option);
    }

    public void setDescription(String text) {
        driver.findElement(descriptionField).sendKeys(text);
    }

    public String getAccountName() {
        return getInputValue(getFieldByName("Name"));
    }

    public String getParentAccount() {
        return getInputValue(driver.findElement(editForm_parentAccountField));
    }

    public String getAccountNumber() {
        return getInputValue(getFieldByName("AccountNumber"));
    }

    public String getAccountSite() {
        return getInputValue(getFieldByName("Site"));
    }

    public String getAccountType() {
        return getButtonValue(getButtonByName("Type"));
    }

    public String getAccountIndustry() {
        return getButtonValue(getButtonByName("Industry"));
    }

    public String getAccountRating() {
        return getButtonValue(getButtonByName("Rating"));
    }

    public String getAccountOwnership() {
        return getButtonValue(getButtonByName("Ownership"));
    }

    public Account.Address getBillingAddress() {
        return new Account.Address(
                getInputValue(getBillingStreetElement()),
                getInputValue(getBillingZipCodeElement()),
                getInputValue(getBillingCityElement()),
                getInputValue(getBillingStateElement()),
                getInputValue(getBillingCountryElement())
        );
    }

    public Account.Address getShippingAddress() {
        return new Account.Address(
                getInputValue(getShippingStreetElement()),
                getInputValue(getShippingZipCodeElement()),
                getInputValue(getShippingCityElement()),
                getInputValue(getShippingStateElement()),
                getInputValue(getShippingCountryElement())
        );
    }

    public String getCustomerPriority() {
        return getButtonValue(getButtonByName("Customer Priority"));
    }

    public String getAccountSLA() {
        return getButtonValue(getButtonByName("SLA"));
    }

    public String getUpsellOpportunity() {
        return getButtonValue(getButtonByName("Upsell Opportunity"));
    }

    public String getAnnualRevenue() {
        return getInputValue(getFieldByName("AnnualRevenue")).replaceAll("\\D", "");
    }

    public String getPhoneNumber() {
        return getInputValue(getFieldByName("Phone"));
    }

    public String getFaxNumber() {
        return getInputValue(getFieldByName("Fax"));
    }

    public String getAccountWebsite() {
        return getInputValue(getFieldByName("Website"));
    }

    public String getTickerSymbol() {
        return getInputValue(getFieldByName("TickerSymbol"));
    }

    public String getNumberOfEmployees() {
        return getInputValue(getFieldByName("NumberOfEmployees"));
    }

    public String getSicCode() {
        return getInputValue(getFieldByName("Sic"));
    }

    public String getExpirationDate() {
        return getInputValue(getFieldByName("SLAExpirationDate__c"));
    }

    public String getNumberOfLocations() {
        return getInputValue(getFieldByName("NumberofLocations__c"));
    }

    public String getActiveStatus() {
        return getButtonValue(getButtonByName("Active"));
    }

    public String getSlaSerialNumber() {
        return getInputValue(getFieldByName("SLASerialNumber__c"));
    }

    public String getAccountDescription() {
        return getInputValue(driver.findElement(descriptionField));
    }

    public AccountPage clickSaveButton() {
        driver.findElement(saveButton).click();
        return new AccountPage(driver);
    }

    public void clickSaveAndNewButton() {
        driver.findElement(saveAndNewButton).click();
    }

    public AccountPage cancelEditForm() {
        click(driver.findElement(closeEditFormButton));
        return new AccountPage(driver);
    }

    public Account getAccountInfo() {
        Account account = new Account();

        account.setAccountName(getAccountName());
        account.setAccountNumber(getAccountNumber());
        account.setParentAccount(getParentAccount());
        account.setAccountSite(getAccountSite());
        account.setType(getAccountType());
        account.setIndustry(getAccountIndustry());
        account.setAnnualRevenue(getAnnualRevenue());
        account.setBillingAddress(getBillingAddress());
        account.setShippingAddress(getShippingAddress());
        account.setExpirationDate(getExpirationDate());
        account.setNumberOfLocations(getNumberOfLocations());
        account.setActiveOption(getActiveStatus());
        account.setRating(getAccountRating());
        account.setPhoneNumber(getPhoneNumber());
        account.setFaxNumber(getFaxNumber());
        account.setAccountWebsite(getAccountWebsite());
        account.setTickerSymbol(getTickerSymbol());
        account.setCustomerPriority(getCustomerPriority());
        account.setOwnership(getAccountOwnership());
        account.setNumberOfEmployees(getNumberOfEmployees());
        account.setSicCode(getSicCode());
        account.setSlaOption(getAccountSLA());
        account.setSlaSerialNumber(getSlaSerialNumber());
        account.setUpsellOpportunity(getUpsellOpportunity());
        account.setDescription(getAccountDescription());

        return account;
    }

    public void fillAccountForm(Account account) {
        setAccountName(account.getAccountName());
        setParentAccount(account.getParentAccount());
        setAccountNumber(account.getAccountNumber());
        setAccountSite(account.getAccountSite());
        setType(account.getType());
        setIndustry(account.getIndustry());
        setAnnualRevenue(account.getAnnualRevenue());
        setRating(account.getRating());
        setPhone(account.getPhone());
        setFax(account.getFax());
        setWebsite(account.getWebsite());
        setTickerSymbol(account.getTickerSymbol());
        setOwnership(account.getOwnership());
        setEmployees(account.getEmployees());
        setSicCode(account.getSicCode());

        Account.Address billing = account.getBillingAddress();
        setBillingAddress(billing.getStreet(), billing.getZipCode(), billing.getCity(), billing.getState(), billing.getCountry());

        Account.Address shipping = account.getShippingAddress();
        setShippingAddress(shipping.getStreet(), shipping.getZipCode(), shipping.getCity(), shipping.getState(), shipping.getCountry());

        setCustomerPriority(account.getCustomerPriority());
        setExpirationDate(account.getExpirationDate());
        setNumberOfLocations(account.getNumberOfLocations());
        setActiveOption(account.getActiveOption());
        setSLAOption(account.getSlaOption());
        setSlaSerialNumber(account.getSlaSerialNumber());
        setUpsellOpportunity(account.getUpsellOpportunity());
        setDescription(account.getDescription());
    }
}

