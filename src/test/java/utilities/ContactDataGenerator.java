package utilities;

import com.github.javafaker.Faker;
import org.example.data.ContactData;
import java.util.Random;

public class ContactDataGenerator {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    private static final String[] salutationOptions = {"Mr.", "Mrs.", "Ms.", "Dr.", "Prof.", "Mx."};
    private static final String[] languageLevelOptions = {"Secondary", "Tertiary", "Primary"};
    private static final String[] leadSourceOptions = {"Web", "Phone Inquiry", "Partner Referral", "Purchased List", "Other"};


    public static ContactData generateContactData(){
        ContactData contactData = new ContactData();

        contactData.setFirstName(faker.name().firstName());
        contactData.setLastName(faker.name().lastName());
        contactData.setPhone(faker.phoneNumber().cellPhone());
        contactData.setHomePhone(faker.phoneNumber().phoneNumber());
        contactData.setTitle(faker.job().title());
        contactData.setDepartment(faker.commerce().department());
        contactData.setFax("123456789");
        contactData.setEmail(faker.internet().emailAddress());
        contactData.setAssistant(faker.name().name());
        contactData.setAssistantPhone(faker.phoneNumber().cellPhone());
        contactData.setMailingStreet(faker.address().streetAddress());
        contactData.setPostalCode(faker.address().zipCode());
        contactData.setMailingCity(faker.address().city());
        contactData.setMailingState(faker.address().state());
        contactData.setMailingCountry(faker.address().country());
        contactData.setLanguage(faker.nation().language());
        contactData.setSalutation(salutationOptions[random.nextInt(salutationOptions.length)]);
        contactData.setLanguageLevel(languageLevelOptions[random.nextInt(languageLevelOptions.length)]);
        contactData.setLeadSource(leadSourceOptions[random.nextInt(leadSourceOptions.length)]);
        return contactData;
    }
}
