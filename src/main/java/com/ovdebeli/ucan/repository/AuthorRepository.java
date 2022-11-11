package com.ovdebeli.ucan.repository;

import com.ovdebeli.ucan.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
