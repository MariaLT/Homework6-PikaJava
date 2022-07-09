package com.ironhack.salesRepedgeservice.controller.interfaces;

import com.ironhack.salesRepedgeservice.models.SalesRep;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface SalesRepController {
    SalesRep addSalesRep(SalesRep salesRep);

    SalesRep showSalesReps(Long id);

    List<SalesRep> showAllSalesRep();
}
