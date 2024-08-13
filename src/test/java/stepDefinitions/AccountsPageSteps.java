package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.data.Account;
import org.example.forms.AccountForm;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.AccountDataGenerator;

import java.util.ArrayList;
import java.util.List;

public class AccountsPageSteps {

    private WebDriver driver = Hooks.driver;
    private SalesPage salesPage;
    private HomePage homePage;
    private CreateAccountPage createAccountPage;
    private AccountForm createAccountForm;
    private AccountForm editAccountForm;
    private AccountPage accountPage;

    private List<Account> accountsList;

    @Given("User is logged into the system")
    public void loginIntoSystem() {
        String username = EnvConfig.get("USERNAME_SALESFORCE");
        String password = EnvConfig.get("PASSWORD_SALESFORCE");

        driver.get("https://login.salesforce.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        homePage = loginPage.clickLoginButton();
    }

    @And("User navigates to the Accounts Page")
    public void goToAccountsPage() {
        salesPage = homePage.goToSalesPage();
        createAccountPage = salesPage.selectAccountsPage();
    }

    @When("User clicks on the New button")
    public void clickOnNewButton() {
        createAccountForm = createAccountPage.clickNewAccountButton();
    }

    @And("User creates {int} accounts with random data")
    public void userCreatesAccountsWithRandomData(int numberOfAccounts) throws InterruptedException {
        accountsList = new ArrayList<>();
        for (int i = 0; i < numberOfAccounts; i++) {
            Account account = AccountDataGenerator.generateAccount();
            createAccountForm.fillAccountForm(account);
            accountsList.add(account);

            if (i == numberOfAccounts - 1) {
                accountPage = createAccountForm.clickSaveButton();
            } else {
                createAccountForm.clickSaveAndNewButton();
            }
            Thread.sleep(2000);
        }
    }

    @Then("Verify that the data of the created accounts is correct")
    public void verifyThatTheDataOfTheCreatedAccountsIsCorrect() throws InterruptedException {
        for (Account account : accountsList) {
            accountPage.searchForAccount(account.getAccountName());
            System.out.println("Editing account: " + account.getAccountName());
            editAccountForm = accountPage.clickEditButton();
            Account actualAccount = editAccountForm.getAccountInfo();
            System.out.println("Form data: " + actualAccount.getAccountName());
            Assert.assertEquals(actualAccount, account);
            accountPage = editAccountForm.cancelEditForm();
        }
    }
}
