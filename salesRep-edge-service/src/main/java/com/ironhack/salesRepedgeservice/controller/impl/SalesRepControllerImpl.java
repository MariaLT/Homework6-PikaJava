package com.ironhack.salesRepedgeservice.controller.impl;

import com.ironhack.salesRepedgeservice.client.ContOppAccClient;
import com.ironhack.salesRepedgeservice.client.LeadClient;
import com.ironhack.salesRepedgeservice.controller.dto.*;
import com.ironhack.salesRepedgeservice.controller.interfaces.SalesRepController;
import com.ironhack.salesRepedgeservice.enums.Industry;
import com.ironhack.salesRepedgeservice.enums.Product;
import com.ironhack.salesRepedgeservice.enums.Status;
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
    private SalesRepRepository salesRepRepository;
    @Autowired
    private SalesRepService salesRepService;

    @Autowired
    private LeadClient leadClient;

    @Autowired
    private ContOppAccClient contOppAccClient;

    @PostMapping("/salesReps")
    @ResponseStatus(HttpStatus.CREATED)
    public SalesRep addSalesRep(@RequestBody SalesRep salesRep) {
        return salesRepRepository.save(salesRep);
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

    @PostMapping("/salesReps/convertLead/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void convertLeadToContactToOpportunity(@PathVariable Long id,
                                           @RequestBody ContOppAccDTO contOppAccDTO) {
        salesRepService.convertLeadToContactToOpportunity(id,contOppAccDTO);

    }

    @GetMapping("/salesReps/contact/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contact contactById(@PathVariable Long id) {
        return contOppAccClient.showContactById(id);
    }

    @GetMapping("/salesReps/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> accountById() {
        return contOppAccClient.showAccounts();

    }

    @PatchMapping("/salesReps/opportunities/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Opportunity updateStatus(@PathVariable Long id, @RequestBody StatusDTO statusDTO) {
        return contOppAccClient.updateStatus(id, statusDTO);
    }

    @GetMapping("/salesReps/opportunities")
    @ResponseStatus(HttpStatus.OK)
    List<Opportunity> showsOpportunities() {
        List<Opportunity> opportunityList = contOppAccClient.showsOpportunities();
        return opportunityList;
    }


}
