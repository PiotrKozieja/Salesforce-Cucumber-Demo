package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.API.AccountAPI;
import org.example.data.Account;
import org.json.JSONObject;
import org.testng.Assert;
import utilities.AccountDataGenerator;

import java.util.ArrayList;
import java.util.List;

public class AddAccountUsingApiSteps {

    private AccountAPI accountAPI;
    private List<Account> accountList;

    @When("User creates {int} Account using API")
    public void createAccountWithAPI(int numberOfAccounts) {
        accountAPI = new AccountAPI();
        accountList = new ArrayList<>();
        for (int i = 0; i < numberOfAccounts; i++) {
            Account account = AccountDataGenerator.generateAccount(true);
            String accountId = accountAPI.createAccountObject(account);
            account.setAccountId(accountId);
            System.out.println("Account with id: " + accountId + " created.");
            accountList.add(account);
        }
    }

    @Then("Verify if GET Account has proper data")
    public void verifyData() {
        for (Account account : accountList) {
            JSONObject response = accountAPI.getAccountObject(account.getAccountId());
            System.out.println("Checking Account: " + account.getAccountName());
            Assert.assertEquals(Account.convertJsonToAccount(response), account);
        }
    }

}
