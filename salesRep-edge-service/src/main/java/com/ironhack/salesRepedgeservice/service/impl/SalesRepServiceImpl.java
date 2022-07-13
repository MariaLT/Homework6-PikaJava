package com.ironhack.salesRepedgeservice.service.impl;

import com.ironhack.salesRepedgeservice.client.ContOppAccClient;
import com.ironhack.salesRepedgeservice.client.LeadClient;
import com.ironhack.salesRepedgeservice.controller.dto.*;
import com.ironhack.salesRepedgeservice.enums.Industry;
import com.ironhack.salesRepedgeservice.enums.Product;
import com.ironhack.salesRepedgeservice.enums.Status;
import com.ironhack.salesRepedgeservice.models.SalesRep;
import com.ironhack.salesRepedgeservice.repository.SalesRepRepository;
import com.ironhack.salesRepedgeservice.service.interfaces.SalesRepService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class SalesRepServiceImpl implements SalesRepService {

    @Autowired
    SalesRepRepository salesRepRepository;
    @Autowired
    ContOppAccClient contOppAccClient;
    @Autowired
    LeadClient leadClient;


    @Override
    public SalesRep showSalesReps(Long id) {
        // Si hay un valor presente, devuelve el valor, de lo contrario, lanza NoSuchElementException.
        SalesRep salesRep = salesRepRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "The SalesRep isn't exist"));
        return salesRepRepository.findById(id).get();

    }
  //  @CircuitBreaker(name="convertLeadToContactToOpportunity", fallbackMethod = "convertLeadToContactToOpportunityFallback")
    @Override
    public void convertLeadToContactToOpportunity(Long id, ContOppAccDTO contOppAccDTO) {
        Account account = new Account(
                contOppAccDTO.getEmployeeCount(),
                Industry.valueOf(contOppAccDTO.getIndustry().toUpperCase()),
                contOppAccDTO.getCity(),
                contOppAccDTO.getCountry()
        );

        Account account1 = contOppAccClient.createAccount(account);

        Lead lead = leadClient.showLead(id);

        Contact contact = new Contact(
                lead.getName(),
                lead.getEmail(),
                lead.getPhoneNumber(),
                lead.getCompanyName(),
                account1.getId(),
                lead.getSalesRepId()
        );

        Contact contact1 = contOppAccClient.convertLead(contact);

        Opportunity opportunity = new Opportunity(
                Product.valueOf(contOppAccDTO.getProduct().toUpperCase()),
                contOppAccDTO.getQuantity(),
                contact1.getId(),
                Status.valueOf(contOppAccDTO.getStatus().toUpperCase()),
                account1.getId(),
                lead.getSalesRepId());

        contOppAccClient.convertToOpportunity(opportunity);

        leadClient.deleteLead(id);
    }
    public void convertLeadToContactToOpportunityFallback(Long id, ContOppAccDTO contOppAccDTO,Exception e){
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Service unavailable");
    }
}
