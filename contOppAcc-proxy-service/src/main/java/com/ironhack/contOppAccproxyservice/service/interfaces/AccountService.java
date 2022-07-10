package com.ironhack.contOppAccproxyservice.service.interfaces;

import com.ironhack.contOppAccproxyservice.model.Account;

import java.util.List;

public interface AccountService {

    Account createAccount(Account account);

    List<Account> showAccounts();

}

