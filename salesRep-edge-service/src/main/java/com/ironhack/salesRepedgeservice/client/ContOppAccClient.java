package com.ironhack.salesRepedgeservice.client;

import com.ironhack.salesRepedgeservice.controller.dto.Account;
import com.ironhack.salesRepedgeservice.controller.dto.Contact;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("contOppAcc-proxy-service")
public interface ContOppAccClient {

    @PostMapping("/contacts")
    Contact convertLead(@RequestBody Contact contact);


    @PostMapping("/accounts")
    Account createAccount(Account account);

    @GetMapping("/accounts")
    List<Account> showAccounts();

    @GetMapping("/contacts/{id}")
    Contact showContactById (@PathVariable Long id);
}
