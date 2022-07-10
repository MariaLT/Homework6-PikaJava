package com.ironhack.contOppAccproxyservice.model;

import com.ironhack.contOppAccproxyservice.enums.Industry;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account_table")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int employeeCount;
    @Enumerated(EnumType.STRING)
    private Industry industry;
    private String city;
    private String country;

//    private List<Long> contacListId; Cada Contacto lleva Account ID
//
//    private List<Long> opportunityListId;  Cada Opportunity lleva Account ID

    public Account() {
    }

    public Account(int employeeCount, Industry industry, String city, String country) {
        this.employeeCount = employeeCount;
        this.industry = industry;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString() {
        return String.format(" ***   ACCOUNT   ***\n ID: %s\n EMPLOYEECOUNT: %s\n INDUSTRY: %s\n CITY: %s\n COUNTRY: %s  --------------------",
                id,
                employeeCount,
                industry,
                city,
                country);
    }
}

