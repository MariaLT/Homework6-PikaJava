package com.ironhack.contOppAccproxyservice.controller.impl;

import com.ironhack.contOppAccproxyservice.controller.interfaces.AccountController;
import com.ironhack.contOppAccproxyservice.model.Account;
import com.ironhack.contOppAccproxyservice.repository.AccountRepository;
import com.ironhack.contOppAccproxyservice.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountControllerImpl implements AccountController {


    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;


    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody Account account) {

        return accountRepository.save(accountService.createAccount(account));
    }

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> showAccounts(){

        return accountService.showAccounts();
    }
}
