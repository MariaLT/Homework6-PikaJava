package com.ironhack.leadproxyservice.controller.interfaces;

import com.ironhack.leadproxyservice.models.Lead;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface LeadController {

    Lead newLead(Lead lead);

    Lead showLead(Long id);

    List<Lead> showLeadBySalesRep(Long salesRepId);

    void deleteLead(Long id);

}
