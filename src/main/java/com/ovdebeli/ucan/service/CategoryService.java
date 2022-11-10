package com.ovdebeli.ucan.service;

import com.ovdebeli.ucan.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category saveCategory(Category category);

    Category getCategoryById(Long id);

    Category updateStudent(Category category);

    void deleteCategoryById(Long id);
}
