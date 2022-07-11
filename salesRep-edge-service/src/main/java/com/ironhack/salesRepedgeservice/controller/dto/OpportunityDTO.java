package com.ironhack.salesRepedgeservice.controller.dto;

import com.ironhack.salesRepedgeservice.enums.Product;
import com.ironhack.salesRepedgeservice.enums.Status;

public class OpportunityDTO {

    private Product product;
    private int quantity;
    private Status status;

    public OpportunityDTO() {
    }

    public OpportunityDTO(Product product, int quantity, Status status) {
        this.product = product;
        this.quantity = quantity;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
