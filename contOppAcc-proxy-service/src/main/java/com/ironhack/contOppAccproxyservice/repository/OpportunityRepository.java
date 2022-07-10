package com.ironhack.contOppAccproxyservice.repository;

import com.ironhack.contOppAccproxyservice.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends JpaRepository <Opportunity, Long> {
}
