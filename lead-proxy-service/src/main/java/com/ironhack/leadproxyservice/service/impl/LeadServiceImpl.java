package com.ironhack.leadproxyservice.service.impl;

import com.ironhack.leadproxyservice.models.Lead;
import com.ironhack.leadproxyservice.repository.LeadRepository;
import com.ironhack.leadproxyservice.service.interfaces.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class LeadServiceImpl implements LeadService {

    @Autowired
    LeadRepository leadRepository;

    @Override
    public Lead newLead(Lead lead) {

        Lead lead1 = leadRepository. findById(lead.getId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "The Lead" +
                        "already exist"));

        return null;
    }

    @Override
    public Lead showLead(Long id) {

        Optional <Lead> optionalLead = leadRepository.findById(id);

        if(!optionalLead.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The Lead isn't exist");
        }
        return optionalLead.get();
    }


    @Override
    public List<Lead> showLeadBySalesRep(Long salesRepId) {
        List<Lead> leadList = leadRepository.findLeadsBySalesRepId(salesRepId);
        if (leadList==null){
             throw new IllegalArgumentException("No lead associated to Sales Rep");
        }
        return leadList;
    }
}
