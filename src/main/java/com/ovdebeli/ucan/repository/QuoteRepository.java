package com.ovdebeli.ucan.repository;

import com.ovdebeli.ucan.models.Category;
import com.ovdebeli.ucan.models.Quote;
import com.ovdebeli.ucan.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query(
            value = "SELECT * FROM quote_table q WHERE q.category_id = :#{#category.id}",
            nativeQuery = true)
    List<Quote> findQuotesByCategory(@Param("category") Category category);
}