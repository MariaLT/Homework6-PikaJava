package com.ironhack.contOppAccproxyservice.controller.impl;

import com.ironhack.contOppAccproxyservice.controller.interfaces.ContactController;
import com.ironhack.contOppAccproxyservice.model.Contact;
import com.ironhack.contOppAccproxyservice.repository.ContactRepository;
import com.ironhack.contOppAccproxyservice.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ContactControllerImpl implements ContactController {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactService contactService;

    @PostMapping("/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    // O RequieredParam
    public Contact convertLead(@RequestBody Contact contact){
        return contactRepository.save(contact);
    }
    @GetMapping("/contacts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contact showContactById(@PathVariable Long id){
        return contactService.showContactById(id);
    }
}

