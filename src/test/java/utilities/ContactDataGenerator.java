package utilities;

import com.github.javafaker.Faker;
import org.example.data.ContactData;

public class ContactDataGenerator {
    public ContactData generateContactData(){
        Faker faker = new Faker();
        ContactData contactData = new ContactData();
        contactData.setFirstName(faker.name().firstName());
        contactData.setMiddleName(faker.name().firstName());
        contactData.setLastName(faker.name().lastName());
        contactData.setTitle(faker.job().title());
        contactData.setEmail(faker.internet().emailAddress());
        contactData.setPhone(faker.phoneNumber().cellPhone());
        contactData.setMailingStreet(faker.address().streetAddress());
        contactData.setPostalCode(faker.address().zipCode());
        contactData.setMailingCity(faker.address().city());
        contactData.setMailingState(faker.address().state());
        contactData.setMailingCountry(faker.address().country());
        return contactData;
    }
}
