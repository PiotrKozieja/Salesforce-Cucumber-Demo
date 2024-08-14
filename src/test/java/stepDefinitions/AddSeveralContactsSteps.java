package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.data.ContactData;
import org.example.forms.ContactForm;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ContactDataGenerator;

import java.util.ArrayList;

public class AddSeveralContactsSteps {
    private WebDriver driver = Hooks.driver;
    private SalesPage salesPage;
    private ContactsPage contactsPage;
    public HomePage homePage;
    public ContactForm contactForm;
    public ContactDataGenerator contactDataGenerator= new ContactDataGenerator();
    public ContactData contactData;
    public ContactDetailPage contactDetailPage;
    ArrayList<ContactData> contactList = new ArrayList<>();

    ArrayList<ContactData> newContactsList = new ArrayList<>();
    @Given("User is logged and on Home Page")
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
    @When("User navigates to Contacts")
    public void navigateToContacts(){
        salesPage = homePage.goToSalesPage();
        contactsPage = salesPage.selectContactsPage();
    }
    @Then("User creates {int} contacts with generated data")
    public void createNewContactRecords(int numberOfNewContactRecords) throws InterruptedException {

        contactForm = contactsPage.goToNewContactForm();
        for(int i = 1; i<=numberOfNewContactRecords;i++){
            contactData = contactDataGenerator.generateContactData();
            contactList.add(contactData);

            contactForm.fillContactInformation(contactData);
            if (i == numberOfNewContactRecords) {
                contactDetailPage = contactForm.clickSaveButton();
            } else {
                contactForm.clickSaveAndNewButton();
                driver.navigate().refresh();
            }
        }
    }
    @And("Check if the contact details are correct")
    public void isContactDetailsCorrect() {
        for(ContactData contactData:contactList){
            contactsPage = contactDetailPage.selectContactsPage();
            contactDetailPage = contactsPage.getContactPageByName(contactData.getFirstName()+" "+contactData.getLastName());
            contactForm = contactDetailPage.clickEditButton();
            ContactData dataFromAccount = contactForm.getContactInformation();
            Assert.assertEquals(dataFromAccount,contactData);
            System.out.println(dataFromAccount.getFirstName()+" "+dataFromAccount.getLastName());
        }
    }

}
