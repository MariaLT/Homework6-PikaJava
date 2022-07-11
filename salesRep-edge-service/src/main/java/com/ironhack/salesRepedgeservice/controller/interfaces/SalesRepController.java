package com.ironhack.salesRepedgeservice.controller.interfaces;

import com.ironhack.salesRepedgeservice.controller.dto.ContOppAccDTO;
import com.ironhack.salesRepedgeservice.models.SalesRep;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface SalesRepController {
    SalesRep addSalesRep(SalesRep salesRep);

    SalesRep showSalesReps(Long id);

    List<SalesRep> showAllSalesRep();

    void convertLeadToContactToOpportunity(Long id, ContOppAccDTO contOppAccDTO);
}
