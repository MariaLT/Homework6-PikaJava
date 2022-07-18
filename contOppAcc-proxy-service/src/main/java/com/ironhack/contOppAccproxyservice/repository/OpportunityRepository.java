package com.ironhack.contOppAccproxyservice.repository;

import com.ironhack.contOppAccproxyservice.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OpportunityRepository extends JpaRepository <Opportunity, Long> {


}
