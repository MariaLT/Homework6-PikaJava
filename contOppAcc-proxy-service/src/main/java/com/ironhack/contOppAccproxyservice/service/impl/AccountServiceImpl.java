package com.ironhack.contOppAccproxyservice.service.impl;

import com.ironhack.contOppAccproxyservice.model.Account;
import com.ironhack.contOppAccproxyservice.repository.AccountRepository;
import com.ironhack.contOppAccproxyservice.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> showAccounts() {
        List<Account> accountList = accountRepository.findAll();
        if(accountList == null || accountList.size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No accounts find");
        }
        return accountList;
    }
}
