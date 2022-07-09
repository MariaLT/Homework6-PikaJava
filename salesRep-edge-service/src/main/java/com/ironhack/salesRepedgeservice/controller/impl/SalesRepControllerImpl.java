package com.ironhack.salesRepedgeservice.controller.impl;

import com.ironhack.salesRepedgeservice.client.LeadClient;
import com.ironhack.salesRepedgeservice.controller.dto.Lead;
import com.ironhack.salesRepedgeservice.controller.interfaces.SalesRepController;
import com.ironhack.salesRepedgeservice.models.SalesRep;
import com.ironhack.salesRepedgeservice.repository.SalesRepRepository;
import com.ironhack.salesRepedgeservice.service.interfaces.SalesRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SalesRepControllerImpl implements SalesRepController {

    @Autowired
    SalesRepRepository salesRepRepository;
    @Autowired
    SalesRepService salesRepService;

    @Autowired
    LeadClient leadClient;

    @PostMapping("/salesReps")
    @ResponseStatus(HttpStatus.CREATED)
    public SalesRep addSalesRep(@RequestBody SalesRep salesRep) {
        return salesRepRepository.save(salesRepService.addSalesRep(salesRep));
    }

    @GetMapping("/salesReps/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SalesRep showSalesReps(@PathVariable Long id) {

        return salesRepService.showSalesReps(id);
    }

    @GetMapping("/salesReps")
    @ResponseStatus(HttpStatus.OK)
    public List<SalesRep> showAllSalesRep() {
        return salesRepRepository.findAll();
    }

    @GetMapping("/salesRep/{id}/leads")
    @ResponseStatus(HttpStatus.OK)
    public List<Lead> showAllLeadsBySalesRepId(@PathVariable Long id) {

        List<Lead> leadList = leadClient.showLeadsBySalesRep(id);

        return leadList;
    }

}
