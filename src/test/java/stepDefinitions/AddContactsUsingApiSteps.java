package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.API.SalesForceAPI;
import org.example.data.ContactData;
import org.json.JSONObject;
import org.testng.Assert;
import utilities.ContactDataGenerator;

import java.util.ArrayList;

public class AddContactsUsingApiSteps {

    private ContactData contactData;

    private ArrayList<ContactData> contactList = new ArrayList<>();
    public final SalesForceAPI salesForceAPI = new SalesForceAPI(EnvConfig.get("ACCESS_TOKEN"));

    @When("{int} contacts details are generated")
    public void generateContactDetails(int numberOfContacts){
        for(int i = 0; i<numberOfContacts;i++){
            contactData = ContactDataGenerator.generateContactData();
            contactList.add(contactData);
        }
    }
    @And("New contacts with details is successfully added")
    public void addingContacts(){
        for(ContactData contactData:contactList){
            contactData.setContactId(salesForceAPI.addNewContact(contactData));
            System.out.println(contactData.getFirstName()+" "+contactData.getLastName());
        }
    }
    @Then("Check if the new contact details are correct")
    public void checkContactsDetails(){
        for(ContactData contactData:contactList){
            JSONObject dataFromSource = salesForceAPI.getAccountDetails(contactData.getContactId());
            ContactData contactDataFromSource = salesForceAPI.transformJsonToContactData(dataFromSource);
            Assert.assertEquals(contactDataFromSource,contactData,"Contact details do not match for ID: " + contactData.getContactId());
        }
    }
}
