package com.ironhack.contOppAccproxyservice.controller.impl;

import com.ironhack.contOppAccproxyservice.controller.dto.StatusDTO;
import com.ironhack.contOppAccproxyservice.controller.interfaces.OpportunityController;
import com.ironhack.contOppAccproxyservice.model.Opportunity;
import com.ironhack.contOppAccproxyservice.repository.ContactRepository;
import com.ironhack.contOppAccproxyservice.repository.OpportunityRepository;
import com.ironhack.contOppAccproxyservice.service.interfaces.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class OpportunityControllerImpl implements OpportunityController {
    @Autowired
    private OpportunityRepository opportunityRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private OpportunityService opportunityService;

    @PostMapping("/opportunities")
    @ResponseStatus(HttpStatus.CREATED)
    public Opportunity convertToOpportunity(@RequestBody Opportunity opportunity){
        opportunityService.checkContact(opportunity);
        return opportunityRepository.save(opportunity);
    }
    @PatchMapping("/opportunities/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Opportunity updateStatus(@PathVariable Long id,
                                    @RequestBody StatusDTO statusDTO){
        return opportunityRepository.save(opportunityService.updateStatus(id, statusDTO.getStatus()));
    }
    @GetMapping("/opportunities")
    @ResponseStatus(HttpStatus.OK)
    public List <Opportunity> showsOpportunities(){
        return opportunityService.showsOpportunities();
    }


}
