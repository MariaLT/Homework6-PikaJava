package com.ironhack.salesRepedgeservice.controller.dto;

import com.ironhack.salesRepedgeservice.enums.Status;

public class StatusDTO {
    private Status status;

    public StatusDTO() {
    }

    public StatusDTO(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
