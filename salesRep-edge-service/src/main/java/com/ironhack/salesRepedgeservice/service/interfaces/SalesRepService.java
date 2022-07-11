package com.ironhack.salesRepedgeservice.service.interfaces;

import com.ironhack.salesRepedgeservice.controller.dto.Account;
import com.ironhack.salesRepedgeservice.controller.dto.ContOppAccDTO;
import com.ironhack.salesRepedgeservice.models.SalesRep;

public interface SalesRepService {

/*    SalesRep addSalesRep(SalesRep salesRep);*/

    SalesRep showSalesReps(Long id);

    void convertLeadToContactToOpportunity(Long id, ContOppAccDTO contOppAccDTO);
}
