package com.ironhack.salesRepedgeservice.controller.dto;

import com.ironhack.salesRepedgeservice.enums.Industry;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Account {
    private Long id;
    private int employeeCount;
    private Industry industry;
    private String city;
    private String country;


    public Account() {
    }

    public Account(int employeeCount, Industry industry, String city, String country) {
        this.employeeCount = employeeCount;
        this.industry = industry;
        this.city = city;
        this.country = country;
    }

    public Account(Long id, int employeeCount, Industry industry, String city, String country) {
        this.id = id;
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
}
