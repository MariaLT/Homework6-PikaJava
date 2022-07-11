package com.ironhack.contOppAccproxyservice.controller.interfaces;

import com.ironhack.contOppAccproxyservice.controller.dto.StatusDTO;
import com.ironhack.contOppAccproxyservice.model.Opportunity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface OpportunityController {

    Opportunity convertToOpportunity(Opportunity opportunity);

    Opportunity updateStatus(Long id, StatusDTO statusDTO);

}
