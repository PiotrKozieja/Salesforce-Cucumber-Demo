//package stepDefinitions;
//
//
//import org.example.pages.ContactsPage;
//import org.example.pages.HomePage;
//import org.example.pages.LoginPage;
//import org.example.utilities.EnvConfig;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class AaaMove {
//    public static void main(String[] args) {
//        String username = EnvConfig.get("USERNAME_SALESFORCE");
//        String password = EnvConfig.get("PASSWORD_SALESFORCE");
//        WebDriver driver = Hooks.driver;
//        driver.get("https://login.salesforce.com/");
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.setUsername(username);
//        loginPage.setPassword(password);
//        HomePage homePage = loginPage.clickLoginButton();
//        ContactsPage contactsPage = homePage.selectContactsPage();
//    }
//
//}
