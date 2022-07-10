package com.ironhack.contOppAccproxyservice.controller.interfaces;

import com.ironhack.contOppAccproxyservice.model.Contact;
import com.ironhack.contOppAccproxyservice.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;


public interface ContactController {

    Contact convertLead(Contact contact);


}