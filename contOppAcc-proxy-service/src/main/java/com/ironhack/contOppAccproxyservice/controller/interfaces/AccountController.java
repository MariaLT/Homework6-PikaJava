package com.ironhack.contOppAccproxyservice.controller.interfaces;

import com.ironhack.contOppAccproxyservice.model.Account;
import com.ironhack.contOppAccproxyservice.model.Contact;
import org.springframework.web.bind.annotation.RequestBody;

public interface AccountController {

    Account createAccount(Account account);

}
