package org.example.data;

import java.util.Objects;


public class Account {

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
        return Objects.equals(accountName, account.accountName)
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
}
