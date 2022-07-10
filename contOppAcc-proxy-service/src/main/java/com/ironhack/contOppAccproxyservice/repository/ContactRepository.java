package com.ironhack.contOppAccproxyservice.repository;

import com.ironhack.contOppAccproxyservice.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository <Contact, Long> {
}
