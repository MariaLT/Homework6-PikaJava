package com.ironhack.salesRepedgeservice.service.impl;

import com.ironhack.salesRepedgeservice.models.SalesRep;
import com.ironhack.salesRepedgeservice.repository.SalesRepRepository;
import com.ironhack.salesRepedgeservice.service.interfaces.SalesRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class SalesRepServiceImpl implements SalesRepService {

    @Autowired
    SalesRepRepository salesRepRepository;

    @Override
    public SalesRep addSalesRep(SalesRep salesRep) {

        Optional <SalesRep> optionalSalesRep = salesRepRepository.findById(salesRep.getId());

        if (optionalSalesRep.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "The Sales Rep" +
                    " already exist");
        }
        return salesRep;
    }

    @Override
    public SalesRep showSalesReps(Long id) {
        // Si hay un valor presente, devuelve el valor, de lo contrario, lanza NoSuchElementException.
        SalesRep salesRep = salesRepRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "The SalesRep isn't exist"));
        return salesRepRepository.findById(id).get();

    }
}
