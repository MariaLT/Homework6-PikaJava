package com.ironhack.contOppAccproxyservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.contOppAccproxyservice.controller.dto.StatusDTO;
import com.ironhack.contOppAccproxyservice.enums.Industry;
import com.ironhack.contOppAccproxyservice.enums.Product;
import com.ironhack.contOppAccproxyservice.enums.Status;
import com.ironhack.contOppAccproxyservice.model.Account;
import com.ironhack.contOppAccproxyservice.model.Contact;
import com.ironhack.contOppAccproxyservice.model.Opportunity;
import com.ironhack.contOppAccproxyservice.repository.AccountRepository;
import com.ironhack.contOppAccproxyservice.repository.ContactRepository;
import com.ironhack.contOppAccproxyservice.repository.OpportunityRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OpportunityControllerImplTest {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private MockMvc mockMvc; // Simular peticiones HTTP
    private final ObjectMapper objectMapper = new ObjectMapper(); // Contruir Objetos JSON a partir de clase de JAVA

    private Account account1, account2;
    private Contact contact1, contact2;

    private Opportunity opportunity1, opportunity2;

    @BeforeEach
    void setUp() {
        account1 = new Account(6, Industry.OTHER, "City1", "Country1");
        account2 = new Account(10, Industry.ECOMMERCE, "City2", "Country2");

        accountRepository.saveAll(List.of(account1, account2));

        contact1 = new Contact("Contact1", "contact1@hotmail.com", 234567890, "CompanyName", 1l, account1.getId());
        contact2 = new Contact("Contact2", "contact2@hotmail.com", 234567890, "CompanyName", 2l, account2.getId());

        contactRepository.saveAll(List.of(contact1, contact2));

        opportunity1 = new Opportunity(Product.BOX, 5, contact1.getId(), Status.OPEN, account1.getId(), 1l);
        opportunity2 = new Opportunity(Product.HYBRID, 7, contact2.getId(), Status.CLOSED_WON, account2.getId(), 2l);

        opportunityRepository.saveAll(List.of(opportunity1, opportunity2));

    }

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
    }

    @Test
    void convertToOpportunity() throws Exception {
        Opportunity opportunity3 = new Opportunity(Product.HYBRID, 10, contact2.getId(), Status.CLOSED_WON, account1.getId(), 3l);
        opportunityRepository.save(opportunity3);

        String body = objectMapper.writeValueAsString(opportunity3);

        MvcResult mvcResult = mockMvc.perform(
                        post("/opportunities")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity3.getId().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity3.getAccountId().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity3.getProduct().toString()));
    }

    @Test

    // COMPROBAR

    void updateStatus() throws Exception {

        StatusDTO statusDTO = new StatusDTO(Status.CLOSED_WON);

        String body = objectMapper.writeValueAsString(statusDTO);

        MvcResult mvcResult = mockMvc.perform(
                        patch("/opportunities/" + opportunity1.getId() + "/status")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent())
                .andReturn();

        Optional<Opportunity> optionalOpportunity = opportunityRepository.findById(opportunity1.getId());
        assertTrue(optionalOpportunity.isPresent());
        assertEquals(statusDTO.getStatus(), optionalOpportunity.get().getStatus());

    }

    @Test
    void showsOpportunities() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        get("/oportunities")

                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // SalesRep1
        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity1.getId().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity2.getProduct().toString()));
    }
}