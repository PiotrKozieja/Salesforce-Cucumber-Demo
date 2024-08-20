package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.API.ContactAPI;
import org.example.data.ContactData;
import org.json.JSONObject;
import org.testng.Assert;
import utilities.ContactDataGenerator;

import java.util.ArrayList;

public class AddContactsUsingApiSteps {

    private ContactData contactData;

    private ArrayList<ContactData> contactList = new ArrayList<>();
    private ContactAPI contactAPI;

    @When("{int} contacts details are generated")
    public void generateContactDetails(int numberOfContacts) {
        for (int i = 0; i < numberOfContacts; i++) {
            contactData = ContactDataGenerator.generateContactData();
            contactList.add(contactData);
        }
    }

    @And("New contacts with details is successfully added")
    public void addingContacts() {
        contactAPI = new ContactAPI();
        for (ContactData contactData : contactList) {
            String contactId = contactAPI.createContactObject(contactData);
            contactData.setContactId(contactId);
            System.out.println("Contact with id: " + contactId + " created.");
        }
    }

    @Then("Check if the new contact details are correct")
    public void checkContactsDetails() {
        for (ContactData contactData : contactList) {
            JSONObject response = contactAPI.getContactObject(contactData.getContactId());
            System.out.println("Checking Contact: " + contactData.getFirstName() + " " + contactData.getLastName());
            Assert.assertEquals(ContactData.convertJsonToContact(response), contactData);
        }
    }
}
