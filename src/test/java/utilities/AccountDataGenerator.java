package utilities;

import com.github.javafaker.Faker;
import org.example.API.AccountAPI;
import org.example.data.Account;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class AccountDataGenerator {

    private static Faker faker = new Faker(new Locale("pl-PL"));
    private static String parentName;
    private static String parentId;

    public static Account generateAccount(boolean isForAPI) {
        Account generatedAccount = new Account();

        generatedAccount.setAccountName(faker.name().fullName());
        generatedAccount.setAccountNumber(faker.idNumber().valid());
        generatedAccount.setAccountSite(faker.internet().domainName());
        createParentAccount();
        if (isForAPI) {
            generatedAccount.setParentAccount(parentId);
            generatedAccount.setExpirationDate(getJsonFormatDate());
        } else {
            generatedAccount.setParentAccount(parentName); //User already exists
            generatedAccount.setExpirationDate(getFormatDate());
        }
        generatedAccount.setType("Customer - Channel");
        generatedAccount.setIndustry("Retail");
        generatedAccount.setAnnualRevenue(String.valueOf(faker.number().randomNumber(4, true)));
        generatedAccount.setRating("Hot");
        generatedAccount.setPhoneNumber(faker.phoneNumber().cellPhone());
        generatedAccount.setFaxNumber(faker.phoneNumber().phoneNumber());
        generatedAccount.setAccountWebsite(faker.internet().domainName());
        generatedAccount.setTickerSymbol(faker.slackEmoji().emoji());
        generatedAccount.setOwnership("Private");
        generatedAccount.setNumberOfEmployees(String.valueOf(faker.number().randomNumber(2, true)));
        generatedAccount.setSicCode(String.valueOf(faker.number().randomNumber(5, true)));
        generatedAccount.setBillingAddress(
                new Account.Address(
                        faker.address().streetAddress(),
                        faker.address().zipCode(),
                        faker.address().city(),
                        faker.address().state(),
                        "Poland"
                )

        );
        generatedAccount.setShippingAddress(
                new Account.Address(
                        faker.address().streetAddress(),
                        faker.address().zipCode(),
                        faker.address().city(),
                        faker.address().state(),
                        "Poland"
                )
        );
        generatedAccount.setCustomerPriority("High");
        generatedAccount.setNumberOfLocations(String.valueOf(faker.number().randomNumber(2, true)));
        generatedAccount.setActiveOption("Yes");
        generatedAccount.setSlaOption("Silver");
        generatedAccount.setSlaSerialNumber(String.valueOf(faker.number().randomNumber(5, true)));
        generatedAccount.setUpsellOpportunity("Maybe");
        generatedAccount.setDescription(faker.lorem().sentence(10));

        return generatedAccount;

    }

    private static Date getFeatureDate() {
        return faker.date().future(2040, TimeUnit.DAYS);
    }

    private static String getFormatDate() {
        return new SimpleDateFormat("d.MM.yyyy").format(getFeatureDate());
    }

    private static String getJsonFormatDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(getFeatureDate());
    }

    private static void createParentAccount() {
        AccountAPI accountAPI = new AccountAPI();
        Account parentAccount = new Account();
        parentName = faker.name().fullName();
        parentAccount.setAccountName(parentName);
        parentId = accountAPI.createAccountObject(parentAccount);
    }
}
