package com.ironhack.contOppAccproxyservice.service.impl;

import com.ironhack.contOppAccproxyservice.model.Account;
import com.ironhack.contOppAccproxyservice.repository.AccountRepository;
import com.ironhack.contOppAccproxyservice.repository.ContactRepository;
import com.ironhack.contOppAccproxyservice.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        Optional <Account> optionalAccount = accountRepository.findById(account.getId());
        if(optionalAccount.isPresent()){
            new ResponseStatusException(HttpStatus.ACCEPTED, "The contacts already exist");
        }
        return account;
    }
    /*/*public Lead newLead(Lead lead) {
        Optional<Lead> optionalLead = leadRepository.findById(lead.getId());
        if (optionalLead.isPresent()) {
            new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "The Lead " +
                    "already exist");
        }
        return lead;
    }*/

    @Override
    public List<Account> showAccounts() {
        List<Account> accountList = accountRepository.findAll();
        if(accountList == null || accountList.size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No accounts find");
        }
        return accountList;
    }
}
/*

    @Override
    public Lead showLead(Long id) {

        Lead lead = leadRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "The Lead isn't exist"));

        return leadRepository.findById(id).get();
    }


    @Override
    public List<Lead> showLeadBySalesRep(Long salesRepId) throws IllegalArgumentException {
        List<Lead> leadList = leadRepository.findLeadsBySalesRepId(salesRepId);
        if (leadList == null || leadList.size() == 0) {
            throw new IllegalArgumentException("No lead associated to Sales Rep");
        }
        return leadList;
    }*/