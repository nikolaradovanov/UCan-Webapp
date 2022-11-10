package com.ovdebeli.ucan.repository;

import com.ovdebeli.ucan.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
