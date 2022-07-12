package com.ironhack.salesRepedgeservice.controller.interfaces;

import com.ironhack.salesRepedgeservice.controller.dto.*;
import com.ironhack.salesRepedgeservice.models.SalesRep;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface SalesRepController {
    SalesRep addSalesRep(SalesRep salesRep);

    SalesRep showSalesReps(Long id);

    List<SalesRep> showAllSalesRep();

    List<Account> accounts();

    Opportunity updateStatus(Long id, StatusDTO statusDTO);

    public Contact contactById(Long id);

    void convertLeadToContactToOpportunity(Long id, ContOppAccDTO contOppAccDTO);

    List<Opportunity> showsOpportunities();
}
