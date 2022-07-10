package com.ironhack.contOppAccproxyservice.service.impl;

import com.ironhack.contOppAccproxyservice.model.Contact;
import com.ironhack.contOppAccproxyservice.repository.ContactRepository;
import com.ironhack.contOppAccproxyservice.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;


    @Override
    public Contact convertLead(Contact contact) {
        Optional <Contact> optionalContact = contactRepository.findById(contact.getId());
        if(optionalContact.isPresent()){
            new ResponseStatusException(HttpStatus.ACCEPTED, "The contacts already exist");
        }
        return contact;
    }

    @Override
    public Contact showContactById(Long id) {
        Contact contact = contactRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "The contacts isn't exist"));
        return contact;
    }
}


