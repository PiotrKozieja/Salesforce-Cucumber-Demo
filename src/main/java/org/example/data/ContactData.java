package org.example.data;

import org.json.JSONObject;

import java.util.Objects;

public class ContactData {
    private String firstName;
    private String lastName;
    private String phone;
    private String homePhone;
    private String title;
    private String department;
    private String fax;
    private String email;
    private String assistant;
    private String assistantPhone;
    private String mailingStreet;
    private String postalCode;
    private String mailingCity;
    private String mailingState;
    private String mailingCountry;
    private String language;
    private String salutation;
    private String leadSource;
    private String languageLevel;
    private String contactId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstName, that.firstName)
                && Objects.equals(lastName, that.lastName)
                && Objects.equals(phone, that.phone)
                && Objects.equals(homePhone, that.homePhone)
                && Objects.equals(title, that.title)
                && Objects.equals(department, that.department)
                && Objects.equals(fax, that.fax)
                && Objects.equals(email, that.email)
                && Objects.equals(assistant, that.assistant)
                && Objects.equals(assistantPhone, that.assistantPhone)
                && Objects.equals(mailingStreet, that.mailingStreet)
                && Objects.equals(postalCode, that.postalCode)
                && Objects.equals(mailingCity, that.mailingCity)
                && Objects.equals(mailingState, that.mailingState)
                && Objects.equals(mailingCountry, that.mailingCountry)
                && Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                firstName,
                lastName,
                phone,
                homePhone,
                title,
                department,
                fax,
                email,
                assistant,
                assistantPhone,
                mailingStreet,
                postalCode,
                mailingCity,
                mailingState,
                mailingCountry,
                language);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssistant() {
        return assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    public String getAssistantPhone() {
        return assistantPhone;
    }

    public void setAssistantPhone(String assistantPhone) {
        this.assistantPhone = assistantPhone;
    }

    public String getMailingStreet() {
        return mailingStreet;
    }

    public void setMailingStreet(String mailingStreet) {
        this.mailingStreet = mailingStreet;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMailingCity() {
        return mailingCity;
    }

    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
    }

    public String getMailingState() {
        return mailingState;
    }

    public void setMailingState(String mailingState) {
        this.mailingState = mailingState;
    }

    public String getMailingCountry() {
        return mailingCountry;
    }

    public void setMailingCountry(String mailingCountry) {
        this.mailingCountry = mailingCountry;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getLanguageLevel() {
        return languageLevel;
    }

    public void setLanguageLevel(String languageLevel) {
        this.languageLevel = languageLevel;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", title='" + title + '\'' +
                ", department='" + department + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", assistant='" + assistant + '\'' +
                ", assistantPhone='" + assistantPhone + '\'' +
                ", mailingStreet='" + mailingStreet + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", mailingCity='" + mailingCity + '\'' +
                ", mailingState='" + mailingState + '\'' +
                ", mailingCountry='" + mailingCountry + '\'' +
                ", language='" + language + '\'' +
                ", salutation='" + salutation + '\'' +
                ", leadSource='" + leadSource + '\'' +
                ", languageLevel='" + languageLevel + '\'' +
                ", contactId='" + contactId + '\'' +
                '}';
    }

    public JSONObject convertToJson() {

        return new JSONObject()
                .put("FirstName", firstName)
                .put("LastName", lastName)
                .put("Email", email)
                .put("Phone", phone)
                .put("HomePhone", homePhone)
                .put("Title", title)
                .put("Department", department)
                .put("Fax", fax)
                .put("AssistantName", assistant)
                .put("AssistantPhone", assistantPhone)
                .put("MailingStreet", mailingStreet)
                .put("MailingPostalCode", postalCode)
                .put("MailingCity", mailingCity)
                .put("MailingState", mailingState)
                .put("MailingCountry", mailingCountry)
                .put("Languages__c", language)
                .put("LeadSource", leadSource)
                .put("Salutation", salutation)
                .put("Level__c", languageLevel);
    }

    public static ContactData convertJsonToContact(JSONObject jsonResponse) {
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
