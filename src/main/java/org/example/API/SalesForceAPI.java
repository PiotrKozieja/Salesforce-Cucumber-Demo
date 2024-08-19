package org.example.API;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.example.data.ContactData;
import org.json.JSONObject;
import java.io.IOException;

public class SalesForceAPI {

    private static final String INSTANCE_URL = "https://empathetic-moose-3qtf7l-dev-ed.trailblaze.my.salesforce.com";
    private static final String API_VERSION = "v58.0";

    private final String accessToken;

    public SalesForceAPI(String accessToken) {
        this.accessToken = accessToken;
    }

    public String addNewContact(ContactData contactData) {
        String url = INSTANCE_URL + "/services/data/" + API_VERSION + "/sobjects/Contact/";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Authorization", "Bearer " + accessToken);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setEntity(new StringEntity(transformContactDataToJson(contactData)));

            HttpResponse response = httpClient.execute(httpPost);
            String responseString = EntityUtils.toString(response.getEntity());
            System.out.println("Response: " + responseString);

            JSONObject jsonObject = new JSONObject(responseString);
            return jsonObject.getString("id");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject getAccountDetails(String contactId) {
        String url = INSTANCE_URL + "/services/data/" + API_VERSION + "/sobjects/Contact/" + contactId;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("Authorization", "Bearer " + accessToken);
            httpGet.setHeader("Content-Type", "application/json");

            HttpResponse response = httpClient.execute(httpGet);
            String responseString = EntityUtils.toString(response.getEntity());
            return new JSONObject(responseString);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String transformContactDataToJson(ContactData contactData) {
        JSONObject json = new JSONObject()
                .put("FirstName", contactData.getFirstName())
                .put("LastName", contactData.getLastName())
                .put("Email", contactData.getEmail())
                .put("Phone", contactData.getPhone())
                .put("HomePhone", contactData.getHomePhone())
                .put("Title", contactData.getTitle())
                .put("Department", contactData.getDepartment())
                .put("Fax", contactData.getFax())
                .put("AssistantName", contactData.getAssistant())
                .put("AssistantPhone", contactData.getAssistantPhone())
                .put("MailingStreet", contactData.getMailingStreet())
                .put("MailingPostalCode", contactData.getPostalCode())
                .put("MailingCity", contactData.getMailingCity())
                .put("MailingState", contactData.getMailingState())
                .put("MailingCountry", contactData.getMailingCountry())
                .put("Languages__c", contactData.getLanguage())
                .put("LeadSource", contactData.getLeadSource())
                .put("Salutation", contactData.getSalutation())
                .put("Level__c", contactData.getLanguageLevel());
        return json.toString();
    }

    public ContactData transformJsonToContactData(JSONObject jsonResponse) {
        ContactData contactData = new ContactData();
        contactData.setFirstName(jsonResponse.optString("FirstName"));
        contactData.setLastName(jsonResponse.optString("LastName"));
        contactData.setPhone(jsonResponse.optString("Phone"));
        contactData.setHomePhone(jsonResponse.optString("HomePhone"));
        contactData.setTitle(jsonResponse.optString("Title"));
        contactData.setDepartment(jsonResponse.optString("Department"));
        contactData.setFax(jsonResponse.optString("Fax"));
        contactData.setEmail(jsonResponse.optString("Email"));
        contactData.setAssistant(jsonResponse.optString("AssistantName"));
        contactData.setAssistantPhone(jsonResponse.optString("AssistantPhone"));

        JSONObject mailingAddress = jsonResponse.optJSONObject("MailingAddress");
        if (mailingAddress != null) {
            contactData.setMailingStreet(mailingAddress.optString("street"));
            contactData.setPostalCode(mailingAddress.optString("postalCode"));
            contactData.setMailingCity(mailingAddress.optString("city"));
            contactData.setMailingState(mailingAddress.optString("state"));
            contactData.setMailingCountry(mailingAddress.optString("country"));
        }

        contactData.setLanguage(jsonResponse.optString("Languages__c"));
        contactData.setSalutation(jsonResponse.optString("Salutation"));
        contactData.setLeadSource(jsonResponse.optString("LeadSource"));
        contactData.setLanguageLevel(jsonResponse.optString("Level__c"));
        contactData.setContactId(jsonResponse.optString("Id"));

        return contactData;
    }
}
