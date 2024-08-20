package org.example.API;

import org.example.data.Account;
import org.example.data.ContactData;
import org.json.JSONObject;

public class ContactAPI extends BaseAPI{

    public JSONObject getContactObject(String contactId) {
        return getObject("Contact", contactId);
    }

    public String createContactObject(ContactData contact) {
        JSONObject createdContact = createObject("Contact", contact.convertToJson());
        return createdContact.getString("id");
    }
}
