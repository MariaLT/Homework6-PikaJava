package com.ironhack.contOppAccproxyservice.service.impl;

import com.ironhack.contOppAccproxyservice.enums.Status;
import com.ironhack.contOppAccproxyservice.model.Opportunity;
import com.ironhack.contOppAccproxyservice.repository.ContactRepository;
import com.ironhack.contOppAccproxyservice.repository.OpportunityRepository;
import com.ironhack.contOppAccproxyservice.service.interfaces.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class OpportunityServiceImpl implements OpportunityService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private OpportunityRepository opportunityRepository;
    @Override
    public Opportunity checkContact(Opportunity opportunity) {

        contactRepository.findById(opportunity.getDecisionMaker()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "The contact doesn't exist"));

        return opportunity;
    }

    @Override
    public Opportunity updateStatus(Long id, Status status) {

        Opportunity opportunity = opportunityRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "The opportunity doesn't exist"));
        opportunity.setStatus(status);

        return opportunity;
    }

    @Override
    public List<Opportunity> showsOpportunities() {

        List <Opportunity> opportunityList = opportunityRepository.findAll();
        if(opportunityList == null || opportunityList.size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No opportunities find");
        }
        return opportunityList;
    }

}
