package com.ironhack.leadproxyservice.service.interfaces;

import com.ironhack.leadproxyservice.models.Lead;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface LeadService {

    Lead newLead(Lead lead);

    Lead showLead(Long id);

    List<Lead> showLeadBySalesRep(Long salesRepId);
}
