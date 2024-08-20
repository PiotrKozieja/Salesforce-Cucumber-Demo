package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.utilities.EnvConfig;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageSteps {

    private WebDriver driver = Hooks.driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @Given("User is on Login Page")
    public void pageSetUp() {
        driver.get("https://login.salesforce.com/");
        loginPage = new LoginPage(driver);
    }

    @When("User provides username and password")
    public void provideCredentials() {
        String username = EnvConfig.get("USERNAME_SALESFORCE");
        String password = EnvConfig.get("PASSWORD_SALESFORCE");
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @And("User clicks on Login button")
    public void clickLoginButton() {
        homePage = loginPage.clickLoginButton();
    }

    @Then("Home Page is displayed")
    public void isHomePageDisplayed() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }


}
