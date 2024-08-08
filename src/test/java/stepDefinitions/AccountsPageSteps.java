package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pages.AccountsPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.SalesPage;
import org.openqa.selenium.WebDriver;

public class AccountsPageSteps {

    private WebDriver driver = Hooks.driver;
    private HomePage homePage;
    private SalesPage salesPage;
    private AccountsPage accountsPage;
    private LoginPageSteps loginPageSteps;

    @Given("User is on Accounts Page")
    public void goToAccountsPage() throws InterruptedException {
        loginPageSteps.provideCredentials();
        loginPageSteps.pageSetUp();
        loginPageSteps.isHomePageDisplayed();
        loginPageSteps.clickLoginButton();
        salesPage = homePage.goToSalesPage();
        accountsPage = salesPage.selectAccountsPage();
    }

    @When("User clicks on New button")
    public void clickOnNewButton() {
        accountsPage.clickNewButton();
    }
}
