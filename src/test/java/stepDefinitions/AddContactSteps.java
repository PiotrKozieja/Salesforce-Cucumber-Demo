package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.example.data.ContactData;
import utilities.ContactDataGenerator;

public class AddContactSteps {
    private WebDriver driver = Hooks.driver;
    private SalesPage salesPage;
    private AccountsPage accountsPage;
    private ContactsPage contactsPage;
    public HomePage homePage;
    public ContactDataGenerator contactDataGenerator;
    public ContactData contactData;

    @Before
    public void prepareContactData(){
        contactDataGenerator = new ContactDataGenerator();
        contactData = contactDataGenerator.generateContactData();
    }
    @Given("User is on Home Page")
    public void loginToAccount(){
        String username = EnvConfig.get("USERNAME_SALESFORCE");
        String password = EnvConfig.get("PASSWORD_SALESFORCE");
        driver = Hooks.driver;
        driver.get("https://login.salesforce.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        homePage = loginPage.clickLoginButton();
    }
    @When("User navigate to the Contacts tab")
    public void navigateToContacts(){
        contactsPage = homePage.selectContactsPage();
    }
    @And("Contacts page is opened")
    public void isContactsPageOpened(){
        Assert.assertTrue(contactsPage.isContactsPageOpened());
    }
    @And("User click New button")
    public void navigateToNewContactPopUp(){
        contactsPage.clickNewButton();
    }
    @And("New Contact PopUp is displayed")
    public void isNewContactPopUpDisplayed(){
        Assert.assertTrue(contactsPage.isNewContactPopUpOpened());
    }
    @And("User enter contact details")
    public void completingNewContactData(){
        contactsPage.fillAllForms(contactData);
    }
    @And("User click Save button")
    public void savingNewContact(){
        contactsPage.clickSaveButton();
    }
    @Then("New user is added")
    public void isNewUserAdded(){
        contactsPage.goToContactList();
        Assert.assertTrue(contactsPage.checkIfContactExist(contactData.getFirstName(),contactData.getMiddleName(),contactData.getLastName()));
    }
}
