package com.ironhack.contOppAccproxyservice.service.interfaces;

import com.ironhack.contOppAccproxyservice.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> showAccounts();

    Account showAccountById(Long id);
}

