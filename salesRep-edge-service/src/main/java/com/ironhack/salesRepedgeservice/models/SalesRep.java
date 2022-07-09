package com.ironhack.salesRepedgeservice.models;

import com.ironhack.salesRepedgeservice.controller.dto.Lead;

import javax.persistence.*;
import java.util.List;

@Entity
public class SalesRep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String name;

    private List <Lead> leadList;

    public SalesRep() {
    }

    public SalesRep(String name) {
        this.name = name;
    }

        public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return " ***   SalesRep   ***: \nID: " + id + "\nNAME: " + name + "\n------------------";

    }

}

