package com.ironhack.contOppAccproxyservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int phoneNumber;
    private String companyName;

    private Long accountId;

    private Long salesRepId;

    public Contact() {
    }

    public Contact(String name, String email, int phoneNumber, String companyName, Long salesRep) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.salesRepId = salesRepId;
    }

    public Contact(String name, String email, int phoneNumber, String companyName, Long salesRepId, Long accountId) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.salesRepId = salesRepId;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(Long salesRepId) {
        this.salesRepId = salesRepId;
    }

    public String toString() {
        return String.format(" ***   CONTACT   ***\n ID: %s\n NAME: %s\n EMAIL: %s\n PHONENUMBER: %s\n COMPANYNAME: %s\n --------------------",
                id,
                name,
                email,
                phoneNumber,
                companyName);
    }
}