package com.ironhack.salesRepedgeservice.client;

import com.ironhack.salesRepedgeservice.controller.dto.Account;
import com.ironhack.salesRepedgeservice.controller.dto.Contact;
import com.ironhack.salesRepedgeservice.controller.dto.Opportunity;
import com.ironhack.salesRepedgeservice.controller.dto.StatusDTO;
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

    @GetMapping("/accounts/{id}")
    Account showAccountById(@PathVariable Long id);

    @GetMapping("/contacts/{id}")
    Contact showContactById (@PathVariable Long id);

    @PostMapping("/opportunities")
    Opportunity convertToOpportunity(@RequestBody Opportunity opportunity);

    @PatchMapping("/opportunities/{id}/status")
    Opportunity updateStatus(@PathVariable Long id, @RequestBody StatusDTO statusDTO);

    @GetMapping("/opportunities")
    List <Opportunity> showsOpportunities();
}
