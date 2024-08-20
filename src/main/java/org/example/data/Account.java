package org.example.data;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Objects;


public class Account {

    private String id;
    private String accountName;
    private String accountNumber;
    private String accountSite;
    private String parentAccount;
    private String type;
    private String industry;
    private String annualRevenue;
    private String rating;
    private String phoneNumber;
    private String faxNumber;
    private String accountWebsite;
    private String tickerSymbol;
    private String ownership;
    private String numberOfEmployees;
    private String sicCode;
    private Address billingAddress;
    private Address shippingAddress;
    private String customerPriority;
    private String expirationDate;
    private String numberOfLocations;
    private String activeOption;
    private String slaOption;
    private String slaSerialNumber;
    private String upsellOpportunity;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id)
                && Objects.equals(accountName, account.accountName)
                && Objects.equals(accountNumber, account.accountNumber)
                && Objects.equals(accountSite, account.accountSite)
                && Objects.equals(parentAccount, account.parentAccount)
                && Objects.equals(type, account.type)
                && Objects.equals(industry, account.industry)
                && Objects.equals(annualRevenue, account.annualRevenue)
                && Objects.equals(rating, account.rating)
                && Objects.equals(phoneNumber, account.phoneNumber)
                && Objects.equals(faxNumber, account.faxNumber)
                && Objects.equals(accountWebsite, account.accountWebsite)
                && Objects.equals(tickerSymbol, account.tickerSymbol)
                && Objects.equals(ownership, account.ownership)
                && Objects.equals(numberOfEmployees, account.numberOfEmployees)
                && Objects.equals(sicCode, account.sicCode)
                && billingAddress.equals(account.billingAddress)
                && shippingAddress.equals(account.shippingAddress)
                && Objects.equals(customerPriority, account.customerPriority)
                && Objects.equals(expirationDate, account.expirationDate)
                && Objects.equals(numberOfLocations, account.numberOfLocations)
                && Objects.equals(activeOption, account.activeOption)
                && Objects.equals(slaOption, account.slaOption)
                && Objects.equals(slaSerialNumber, account.slaSerialNumber)
                && Objects.equals(upsellOpportunity, account.upsellOpportunity)
                && Objects.equals(description, account.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                accountName,
                accountNumber,
                accountSite,
                parentAccount,
                type,
                industry,
                annualRevenue,
                rating,
                phoneNumber,
                faxNumber,
                accountWebsite,
                tickerSymbol,
                ownership,
                numberOfEmployees,
                sicCode,
                billingAddress,
                shippingAddress,
                customerPriority,
                expirationDate,
                numberOfLocations,
                activeOption,
                slaOption,
                slaSerialNumber,
                upsellOpportunity,
                description);
    }

    public static class Address {
        private String street;
        private String zipCode;
        private String city;
        private String state;
        private String country;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Address address = (Address) o;
            return Objects.equals(street, address.street)
                    && Objects.equals(zipCode, address.zipCode)
                    && Objects.equals(city, address.city)
                    && Objects.equals(state, address.state)
                    && Objects.equals(country, address.country);
        }

        @Override
        public int hashCode() {
            return Objects.hash(street, zipCode, city, state, country);
        }

        public Address(String street, String zipCode, String city, String state, String country) {
            this.street = street;
            this.zipCode = zipCode;
            this.city = city;
            this.state = state;
            this.country = country;
        }

        public String getStreet() {
            return street;
        }

        public String getZipCode() {
            return zipCode;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getCountry() {
            return country;
        }
    }

    public void setAccountId(String id) {
        this.id = id;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountSite(String accountSite) {
        this.accountSite = accountSite;
    }

    public void setParentAccount(String parentAccount) {
        this.parentAccount = parentAccount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setAnnualRevenue(String annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public void setAccountWebsite(String accountWebsite) {
        this.accountWebsite = accountWebsite;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void setSicCode(String sicCode) {
        this.sicCode = sicCode;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setCustomerPriority(String customerPriority) {
        this.customerPriority = customerPriority;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setActiveOption(String activeOption) {
        this.activeOption = activeOption;
    }

    public void setNumberOfLocations(String numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }

    public void setSlaOption(String slaOption) {
        this.slaOption = slaOption;
    }

    public void setSlaSerialNumber(String slaSerialNumber) {
        this.slaSerialNumber = slaSerialNumber;
    }

    public void setUpsellOpportunity(String upsellOpportunity) {
        this.upsellOpportunity = upsellOpportunity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccountId() {
        return id;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountSite() {
        return accountSite;
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public String getType() {
        return type;
    }

    public String getIndustry() {
        return industry;
    }

    public String getAnnualRevenue() {
        return annualRevenue;
    }

    public String getRating() {
        return rating;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public String getFax() {
        return faxNumber;
    }

    public String getWebsite() {
        return accountWebsite;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public String getOwnership() {
        return ownership;
    }

    public String getEmployees() {
        return numberOfEmployees;
    }

    public String getSicCode() {
        return sicCode;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public String getCustomerPriority() {
        return customerPriority;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getNumberOfLocations() {
        return numberOfLocations;
    }

    public String getActiveOption() {
        return activeOption;
    }

    public String getSlaOption() {
        return slaOption;
    }

    public String getSlaSerialNumber() {
        return slaSerialNumber;
    }

    public String getUpsellOpportunity() {
        return upsellOpportunity;
    }

    public String getDescription() {
        return description;
    }

    public JSONObject convertToJson() {
        JSONObject json = new JSONObject();

        json.put("Name", accountName); //
        json.put("AccountNumber", accountNumber); //
        json.put("Site", accountSite); //
        json.put("ParentId", parentAccount); //
        json.put("Type", type); //
        json.put("Industry", industry); //
        json.put("AnnualRevenue", annualRevenue); //
        json.put("Rating", rating); //
        json.put("Phone", phoneNumber); //
        json.put("Fax", faxNumber); //
        json.put("Website", accountWebsite); //
        json.put("TickerSymbol", tickerSymbol); //
        json.put("Ownership", ownership); //
        json.put("NumberOfEmployees", numberOfEmployees); //
        json.put("Sic", sicCode);

        if (billingAddress != null) {
            json.put("BillingStreet", billingAddress.getStreet());
            json.put("BillingPostalCode", billingAddress.getZipCode());
            json.put("BillingCity", billingAddress.getCity());
            json.put("BillingState", billingAddress.getState());
            json.put("BillingCountry", billingAddress.getCountry());
        }

        if (shippingAddress != null) {
            json.put("ShippingStreet", shippingAddress.getStreet());
            json.put("ShippingPostalCode", shippingAddress.getZipCode());
            json.put("ShippingCity", shippingAddress.getCity());
            json.put("ShippingState", shippingAddress.getState());
            json.put("ShippingCountry", shippingAddress.getCountry());
        }

        json.put("CustomerPriority__c", customerPriority);
        json.put("SLAExpirationDate__c", expirationDate);
        json.put("NumberofLocations__c", numberOfLocations);
        json.put("Active__c", activeOption);
        json.put("SLA__c", slaOption);
        json.put("SLASerialNumber__c", slaSerialNumber);
        json.put("UpsellOpportunity__c", upsellOpportunity);
        json.put("Description", description);


        return json;
    }

    public static Account convertJsonToAccount(JSONObject response) {
        Account account = new Account();

        account.setAccountId(response.getString("Id"));
        account.setAccountName(response.getString("Name"));
        account.setAccountNumber(response.getString("AccountNumber"));
        account.setAccountSite(response.getString("Site"));
        account.setParentAccount(response.getString("ParentId")); // Ustawianie ParentId
        account.setType(response.getString("Type"));
        account.setIndustry(response.getString("Industry"));
        account.setAnnualRevenue(String.valueOf(response.getInt("AnnualRevenue")));
        account.setRating(response.getString("Rating"));
        account.setPhoneNumber(response.getString("Phone"));
        account.setFaxNumber(response.getString("Fax"));
        account.setAccountWebsite(response.getString("Website"));
        account.setTickerSymbol(response.getString("TickerSymbol"));
        account.setOwnership(response.getString("Ownership"));
        account.setNumberOfEmployees(String.valueOf(response.getInt("NumberOfEmployees")));
        account.setSicCode(response.getString("Sic"));

        // Billing Address
        Address billingAddress = new Address(
                response.getString("BillingStreet"),
                response.getString("BillingPostalCode"),
                response.getString("BillingCity"),
                response.getString("BillingState"),
                response.getString("BillingCountry")
        );
        account.setBillingAddress(billingAddress);

        // Shipping Address
        Address shippingAddress = new Address(
                response.getString("ShippingStreet"),
                response.getString("ShippingPostalCode"),
                response.getString("ShippingCity"),
                response.getString("ShippingState"),
                response.getString("ShippingCountry")
        );
        account.setShippingAddress(shippingAddress);

        account.setCustomerPriority(response.getString("CustomerPriority__c"));
        account.setExpirationDate(response.getString("SLAExpirationDate__c"));
        account.setNumberOfLocations(String.valueOf(response.getInt("NumberofLocations__c")));
        account.setActiveOption(response.getString("Active__c"));
        account.setSlaOption(response.getString("SLA__c"));
        account.setSlaSerialNumber(response.getString("SLASerialNumber__c"));
        account.setUpsellOpportunity(response.getString("UpsellOpportunity__c"));
        account.setDescription(response.getString("Description"));

        return account;
    }
}
