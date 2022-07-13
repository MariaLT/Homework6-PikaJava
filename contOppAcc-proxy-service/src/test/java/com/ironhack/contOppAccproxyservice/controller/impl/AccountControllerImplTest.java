package com.ironhack.contOppAccproxyservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.contOppAccproxyservice.enums.Industry;
import com.ironhack.contOppAccproxyservice.model.Account;
import com.ironhack.contOppAccproxyservice.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerImplTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MockMvc mockMvc; // Simular peticiones HTTP
    private final ObjectMapper objectMapper = new ObjectMapper(); // Contruir Objetos JSON a partir de clase de JAVA

    private Account account1, account2;

    @BeforeEach
    void setUp() {
        account1 = new Account(6, Industry.OTHER, "City1", "Country1");
        account2 = new Account(10, Industry.ECOMMERCE, "City2", "Country2");

        accountRepository.saveAll(List.of(account1, account2));
    }

    @AfterEach
    void tearDown() {
        accountRepository.deleteAll();
    }

    @Test
    void createAccount() throws Exception {

        Account account3 = new Account(15, Industry.ECOMMERCE, "City3", "Country3");
        accountRepository.save(account3);

        String body = objectMapper.writeValueAsString(account3);

        MvcResult mvcResult = mockMvc.perform(
                        post("/accounts")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(account3.getId().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account3.getCountry()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account3.getCity()));

    }


    @Test
    void showAccounts() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        get("/accounts")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(account1.getId().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account1.getCity()));

        assertTrue(mvcResult.getResponse().getContentAsString().contains(account2.getId().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account2.getCity()));
    }


    @Test
    void showAccountById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        get("/accounts/" + account1.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(account1.getId().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account1.getIndustry().toString()));

    }




}