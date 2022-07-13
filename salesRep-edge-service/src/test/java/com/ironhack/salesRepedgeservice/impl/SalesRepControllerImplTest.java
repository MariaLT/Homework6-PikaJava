package com.ironhack.salesRepedgeservice.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.salesRepedgeservice.client.ContOppAccClient;
import com.ironhack.salesRepedgeservice.client.LeadClient;
import com.ironhack.salesRepedgeservice.controller.dto.*;
import com.ironhack.salesRepedgeservice.enums.Industry;
import com.ironhack.salesRepedgeservice.enums.Product;
import com.ironhack.salesRepedgeservice.enums.Status;
import com.ironhack.salesRepedgeservice.models.SalesRep;
import com.ironhack.salesRepedgeservice.repository.SalesRepRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SalesRepControllerImplTest {

    @Autowired
    private SalesRepRepository salesRepRepository;

    @MockBean
    private LeadClient leadClient;

    @MockBean
    private ContOppAccClient contOppAccClient;

    @Autowired
    private MockMvc mockMvc; // Simular peticiones HTTP
    private final ObjectMapper objectMapper = new ObjectMapper(); // Contruir Objetos JSON a partir de clase de JAVA

    private SalesRep salesRep1, salesRep2;

    private Lead lead1, lead2;

    private Account account1;
    private Contact contact1;
    private Opportunity opportunity1;


    @BeforeEach
    void setUp() {
        salesRep1 = new SalesRep("salesRep1");
        salesRep2 = new SalesRep("salesRep2");

        salesRepRepository.saveAll(List.of(salesRep1, salesRep2));

        lead1 = new Lead(1l, "lead1", "lead1@hotmail.com", 1234567, "leadCompany1", salesRep1.getId());
        lead2 = new Lead(2l, "lead2", "lead2@hotmail.com", 6785438, "leadCompany2", salesRep1.getId());

        account1 = new Account(6, Industry.OTHER, "City1", "Country1");
        contact1 = new Contact("Contact1", "contact1@hotmail.com", 234567890, "CompanyName", account1.getId(), 1l);
        opportunity1 = new Opportunity(Product.BOX, 5, contact1.getId(), Status.OPEN, account1.getId(), 1l);

    }

    @AfterEach
    void tearDown() {
        salesRepRepository.deleteAll();
    }

    @Test
    void addSalesRep() throws Exception {
        SalesRep salesRep3 = new SalesRep("salesRep3");

        String body = objectMapper.writeValueAsString(salesRep3);

        MvcResult mvcResult = mockMvc.perform(
                        post("/salesReps")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(salesRep3.getName()));

    }


    @Test
    void showSalesReps() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        get("/salesReps/" + salesRep1.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(salesRep1.getId().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(salesRep1.getName()));
    }


    @Test
    void showAllSalesRep() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                        get("/salesReps")

                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // SalesRep1
        assertTrue(mvcResult.getResponse().getContentAsString().contains(salesRep1.getId().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(salesRep1.getName()));

        // SalesResp2
        assertTrue(mvcResult.getResponse().getContentAsString().contains(salesRep2.getId().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(salesRep2.getName()));

    }

    @Test
    void showAllLeadsBySalesRepId() throws Exception {

        Mockito.when(leadClient.showLeadsBySalesRep(salesRep1.getId())).thenReturn(List.of(lead1, lead2));

        MvcResult mvcResult = mockMvc.perform(
                        get("/salesRep/" + salesRep1.getId() + "/leads")
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(lead1.getName()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(lead2.getName()));

    }

/*
    @Test
    void convertLeadToContactToOpportunity() throws Exception {


        ContOppAccDTO contOppAccDTO = new ContOppAccDTO(6, "OTHER", "City1", "Country1", "BOX", 5, "OPEN");

 //       account1.setId(1l);

        Contact contact = contact1;
        contact.setId(1l);

 //       Account account = account1;
 //       account.setId(1l);

        Opportunity opportunity = opportunity1;
        opportunity.setId(1l);

        Mockito.when(leadClient.showLead(lead1.getId())).thenReturn(lead1);
        Mockito.when(contOppAccClient.showContactById(contact1.getId())).thenReturn(contact1);
        Mockito.when(contOppAccClient.convertLead(contact1)).thenReturn(contact);


//        Mockito.when(contOppAccClient.showAccountById(account1.getId())).thenReturn(account1);
//        Mockito.when(contOppAccClient.createAccount(account1)).thenReturn(account1);
        Mockito.when(contOppAccClient.convertToOpportunity(opportunity1)).thenReturn(opportunity);


        String body = objectMapper.writeValueAsString(contOppAccDTO);

        MvcResult mvcResult = mockMvc.perform(
                        post("/salesReps/convertLead/" + lead1.getId())
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andReturn();

        Optional<Contact> optionalContact = Optional.ofNullable(contOppAccClient.showContactById(contact1.getId()));

        assertEquals(contact1.getId(), optionalContact.get().getId());
     //   assertTrue(mvcResult.getResponse().getContentAsString().contains(contact1.getEmail()));
     //   assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity1.getStatus().toString()));


    }
*/


    @Test
    void contactById() throws Exception {
        contact1.setId(1l);
        Mockito.when(contOppAccClient.showContactById(contact1.getId())).thenReturn(contact1);
        MvcResult mvcResult = mockMvc.perform(
                        get("/salesReps/contact/" + contact1.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(contact1.getEmail()));
    }

    @Test
    void accounts() throws Exception {
        Mockito.when(contOppAccClient.showAccounts()).thenReturn(List.of(account1));

        MvcResult mvcResult = mockMvc.perform(
                        get("/salesReps/accounts")

                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();


        assertTrue(mvcResult.getResponse().getContentAsString().contains(account1.getCountry()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account1.getCity()));


    }

    @Test
    void updateStatus() throws Exception {

        opportunity1.setId(1l);

        Opportunity opportunity =  new Opportunity(Product.BOX, 5, contact1.getId(), Status.CLOSED_WON, account1.getId(), 1l);
        opportunity.setId(1l);

        StatusDTO statusDTO = new StatusDTO(Status.CLOSED_WON);
        String body = objectMapper.writeValueAsString(statusDTO);

        Mockito.when(contOppAccClient.updateStatus(opportunity1.getId(), statusDTO)).thenReturn(opportunity);

        MvcResult mvcResult = mockMvc.perform(
                        patch("/salesReps/opportunities/" + opportunity1.getId() + "/status")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent())
                .andReturn();

        assertFalse(mvcResult.getResponse().getContentAsString().contains(opportunity.getStatus().toString()));

    }

    @Test
    void showsOpportunities() throws Exception {
        Mockito.when(contOppAccClient.showsOpportunities()).thenReturn(List.of(opportunity1));

        MvcResult mvcResult = mockMvc.perform(
                        get("/salesReps/opportunities")

                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();


        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity1.getStatus().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity1.getProduct().toString()));


    }




}