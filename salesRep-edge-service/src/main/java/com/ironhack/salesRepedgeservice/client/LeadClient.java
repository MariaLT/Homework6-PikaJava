package com.ironhack.salesRepedgeservice.client;


import com.ironhack.salesRepedgeservice.controller.dto.Lead;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient("lead-proxy-service")
public interface LeadClient  {

    @PostMapping("/leads")
    Lead newLead(@RequestBody Lead lead);

    @GetMapping("/leads/{id}")
    Lead showLead(@PathVariable Long id);

    @GetMapping("/leads/salesRep/{salesRepId}")
    List<Lead> showLeadsBySalesRep(@PathVariable Long salesRepId);

    @DeleteMapping("/leads/{id}")
    void deleteLead(@PathVariable Long id);

}
