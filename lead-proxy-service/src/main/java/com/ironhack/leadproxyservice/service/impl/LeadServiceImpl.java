package com.ironhack.leadproxyservice.service.impl;

import com.ironhack.leadproxyservice.models.Lead;
import com.ironhack.leadproxyservice.repository.LeadRepository;
import com.ironhack.leadproxyservice.service.interfaces.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LeadServiceImpl implements LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Override
    public Lead showLead(Long id) {

        Lead lead = leadRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "The Lead doesn't exist"));

        return leadRepository.findById(id).get();
    }


    @Override
    public List<Lead> showLeadBySalesRep(Long salesRepId) throws IllegalArgumentException {
        List<Lead> leadList = leadRepository.findLeadsBySalesRepId(salesRepId);
        if (leadList == null || leadList.size() == 0) {
            throw new IllegalArgumentException("No lead associated to SalesRep");
        }
        return leadList;
    }

    @Override
    public void deleteLead(Long id) {
        Lead lead = leadRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "The lead doesn't exist"));

        leadRepository.deleteById(id);
    }
}
