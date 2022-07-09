package com.ironhack.salesRepedgeservice.repository;

import com.ironhack.salesRepedgeservice.models.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalesRepRepository extends JpaRepository <SalesRep, Long> {



}
