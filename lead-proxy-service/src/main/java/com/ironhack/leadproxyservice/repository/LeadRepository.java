package com.ironhack.leadproxyservice.repository;

import com.ironhack.leadproxyservice.models.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeadRepository extends JpaRepository <Lead, Long> {

    List<Lead> findLeadsBySalesRepId(Long id);





}
