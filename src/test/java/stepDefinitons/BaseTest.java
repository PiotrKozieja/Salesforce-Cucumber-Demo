package stepDefinitons;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {
    public static WebDriver driver;

    @When("User opens login.salesforce.com")
    public void setupAndOpenLoginPage(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen\n");
        driver = new ChromeDriver(options);
        driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
    }
    @Then("There is login page")
    public void itLoginPageOpened(){
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Login | Salesforce",actualTitle);
        driver.quit();
    }
}
