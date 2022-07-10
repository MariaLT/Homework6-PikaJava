package com.ironhack.contOppAccproxyservice.service.interfaces;

import com.ironhack.contOppAccproxyservice.model.Contact;

public interface ContactService {

    Contact convertLead(Contact contact);

    Contact showContactById(Long id);
}

