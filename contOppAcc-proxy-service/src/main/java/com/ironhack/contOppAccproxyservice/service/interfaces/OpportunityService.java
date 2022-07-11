package com.ironhack.contOppAccproxyservice.service.interfaces;

import com.ironhack.contOppAccproxyservice.controller.dto.StatusDTO;
import com.ironhack.contOppAccproxyservice.enums.Status;
import com.ironhack.contOppAccproxyservice.model.Opportunity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OpportunityService {

    Opportunity  checkContact(Opportunity opportunity);

    Opportunity updateStatus(Long id, Status status);

    List<Opportunity> showsOpportunities();

}
