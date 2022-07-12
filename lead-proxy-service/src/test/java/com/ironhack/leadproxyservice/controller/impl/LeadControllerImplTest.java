package com.ironhack.leadproxyservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.leadproxyservice.models.Lead;
import com.ironhack.leadproxyservice.repository.LeadRepository;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class LeadControllerImplTest {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private MockMvc mockMvc; // Simular peticiones HTTP
    private final ObjectMapper objectMapper = new ObjectMapper(); // Contruir Objetos JSON a partir de clase de JAVA

    private Lead lead1, lead2;

    @BeforeEach
    void setUp() {
        lead1 = new Lead("lead1", "lead1@hotmail.com", 1234567, "leadCompany1", 1l);
        lead2 = new Lead("lead2", "lead2@hotmail.com", 6785438, "leadCompany2", 1l);


        leadRepository.save(lead1);
        leadRepository.save(lead2);

    }

    @AfterEach
    void tearDown() {
        leadRepository.deleteAll();
    }

    @Test
    void newLead() throws Exception {
        Lead lead3 = new Lead("lead3", "lead3@hotmail.com", 45678978, "leadCompany3", 3l);

        String body = objectMapper.writeValueAsString(lead3);

        MvcResult mvcResult = mockMvc.perform(
                        post("/leads")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(lead3.getName()));
    }


    @Test
    void showLead() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        get("/leads/" + lead1.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(lead1.getId().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(lead1.getName()));
    }


    @Test
    void showLeadBySalesRep() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                        get("/leads/salesRep/1")

                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Lead 1
        assertTrue(mvcResult.getResponse().getContentAsString().contains(lead1.getName()));

        // Lead 2
        assertTrue(mvcResult.getResponse().getContentAsString().contains(lead2.getName()));


    }

    @Test
    void deleteLead() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        delete("/leads/" + lead1.getId())
                )
                .andExpect(status().isNoContent())
                .andReturn();
        assertFalse(leadRepository.existsById(lead1.getId()));
    }


}