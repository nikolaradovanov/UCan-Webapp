package com.ovdebeli.ucan.web.controller;

import com.ovdebeli.ucan.models.Category;
import com.ovdebeli.ucan.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category/categories";
    }

    @GetMapping("/categories/new")
    public String createCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/create_category";
    }

    @PostMapping("/categories")
    public String saveCategory(@ModelAttribute("category") Category category) {

        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {

        model.addAttribute("category", categoryService.getCategoryById(id));
        return "category/edit_category";
    }

    @PostMapping("/categories/edit/{id}")
    public String updateCategory(@PathVariable Long id, @ModelAttribute("category") Category category) {

        Category existingCategory = categoryService.getCategoryById(id);
        existingCategory.setId(id);
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());

        categoryService.saveCategory(existingCategory);

        return "redirect:/categories";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {

        categoryService.deleteCategoryById(id);
        return "redirect:/categories";
    }
}
