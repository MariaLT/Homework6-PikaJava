package com.ironhack.leadproxyservice.controller.impl;

import com.ironhack.leadproxyservice.controller.interfaces.LeadController;
import com.ironhack.leadproxyservice.models.Lead;
import com.ironhack.leadproxyservice.repository.LeadRepository;
import com.ironhack.leadproxyservice.service.interfaces.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeadControllerImpl implements LeadController {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private LeadService leadService;

    @PostMapping("/leads")
    @ResponseStatus(HttpStatus.CREATED)
    public Lead newLead(@RequestBody Lead lead) {
        return leadRepository.save(lead);
    }

    @GetMapping("/leads/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lead showLead(@PathVariable Long id) {
        return leadService.showLead(id);
    }

    @GetMapping("/leads/salesRep/{salesRepId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Lead> showLeadBySalesRep(@PathVariable Long salesRepId){
        return leadService.showLeadBySalesRep(salesRepId);
                //leadRepository.findLeadsBySalesRepId(salesRepId);
    }

    @DeleteMapping("/leads/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLead(@PathVariable Long id){
        leadService.deleteLead(id);
    }

}




