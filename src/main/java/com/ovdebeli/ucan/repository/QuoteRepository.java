package com.ovdebeli.ucan.repository;

import com.ovdebeli.ucan.models.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}