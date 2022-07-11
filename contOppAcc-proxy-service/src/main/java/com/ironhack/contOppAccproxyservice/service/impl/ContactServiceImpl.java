package com.ironhack.contOppAccproxyservice.service.impl;

import com.ironhack.contOppAccproxyservice.model.Contact;
import com.ironhack.contOppAccproxyservice.repository.ContactRepository;
import com.ironhack.contOppAccproxyservice.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;


    @Override
    public Contact showContactById(Long id) {
        Contact contact = contactRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "The contacts don't exist"));
        return contact;
    }
}


