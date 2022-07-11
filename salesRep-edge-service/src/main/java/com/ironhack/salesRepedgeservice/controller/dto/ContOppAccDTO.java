package com.ironhack.salesRepedgeservice.controller.dto;

import com.ironhack.salesRepedgeservice.enums.Industry;
import com.ironhack.salesRepedgeservice.enums.Product;
import com.ironhack.salesRepedgeservice.enums.Status;

public class ContOppAccDTO {

    private int employeeCount;
    private String industry;
    private String city;
    private String country;

    private String product;
    private int quantity;
    private String status;

    public ContOppAccDTO(int employeeCount, String industry, String city,
                         String country, String product, int quantity, String status) {
        this.employeeCount = employeeCount;
        this.industry = industry;
        this.city = city;
        this.country = country;
        this.product = product;
        this.quantity = quantity;
        this.status = status;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
