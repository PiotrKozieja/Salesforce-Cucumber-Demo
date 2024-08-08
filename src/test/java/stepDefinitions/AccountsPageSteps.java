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
    private SalesPage salesPage;
    private AccountsPage accountsPage;

    @Given("User is on Accounts Page")
    public void goToAccountsPage() throws InterruptedException {
        String username = EnvConfig.get("USERNAME_SALESFORCE");
        String password = EnvConfig.get("PASSWORD_SALESFORCE");

        driver.get("https://login.salesforce.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        HomePage homePage = loginPage.clickLoginButton();
        salesPage = homePage.goToSalesPage();
        accountsPage = salesPage.selectAccountsPage();
    }

    @When("User clicks on New button")
    public void clickOnNewButton() {
        accountsPage.clickNewButton();
    }
}
