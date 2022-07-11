package com.ironhack.salesRepedgeservice.controller.dto;

import com.ironhack.salesRepedgeservice.enums.Product;
import com.ironhack.salesRepedgeservice.enums.Status;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Opportunity {

    private Long id;
    private Product product;
    private int quantity;
    // Contact Id
    private Long decisionMaker;
    private Status status;
    private Long accountId;
    private Long salesRepId;

    public Opportunity() {
    }

    public Opportunity(Long id, Product product, int quantity, Long decisionMaker, Status status,
                       Long accountId, Long salesRepId) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.accountId = accountId;
        this.salesRepId = salesRepId;
    }

    public Opportunity(Product product, int quantity, Long decisionMaker, Status status, Long accountId, Long salesRepId) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.accountId = accountId;
        this.salesRepId = salesRepId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Long decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
}
