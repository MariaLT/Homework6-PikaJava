package com.ironhack.contOppAccproxyservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.contOppAccproxyservice.enums.Industry;
import com.ironhack.contOppAccproxyservice.model.Account;
import com.ironhack.contOppAccproxyservice.model.Contact;
import com.ironhack.contOppAccproxyservice.repository.AccountRepository;
import com.ironhack.contOppAccproxyservice.repository.ContactRepository;
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
class ContactControllerImplTest {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MockMvc mockMvc; // Simular peticiones HTTP
    private final ObjectMapper objectMapper = new ObjectMapper(); // Contruir Objetos JSON a partir de clase de JAVA

    private Account account1, account2;
    private Contact contact1, contact2;

    @BeforeEach
    void setUp() {
        account1 = new Account(6, Industry.OTHER, "City1", "Country1");
        account2 = new Account(10, Industry.ECOMMERCE, "City2", "Country2");

        accountRepository.saveAll(List.of(account1, account2));

        contact1 = new Contact("Contact1", "contact1@hotmail.com", 234567890, "CompanyName", 1l, account1.getId());
        contact2 = new Contact("Contact2", "contact2@hotmail.com", 234567890, "CompanyName", 2l, account2.getId());

        contactRepository.saveAll(List.of(contact1, contact2));
    }

    @AfterEach
    void tearDown() {
        contactRepository.deleteAll();
    }


    @Test
    void convertLead() throws Exception {

        Contact contact3 = new Contact("Contact3", "contact3@hotmail.com", 876543, "CompanyName", 2l, account1.getId());
        contactRepository.save(contact3);

        String body = objectMapper.writeValueAsString(contact3);

        MvcResult mvcResult = mockMvc.perform(
                        post("/contacts")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(contact3.getId().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(contact3.getCompanyName()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(contact3.getEmail()));
    }

    @Test
    void showContactById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        get("/contacts/" + contact1.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(contact1.getId().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(contact1.getEmail()));

    }
}