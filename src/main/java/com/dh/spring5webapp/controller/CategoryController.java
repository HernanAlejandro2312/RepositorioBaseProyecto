package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping
    public String getCategories(@RequestParam(value = "code", required = false) String code, Model model) {
        model.addAttribute("categories", StringUtils.isEmpty(code) ? categoryRepository.findAll() : categoryRepository.findByCode(code).get());
        return "categories";
    }

    @RequestMapping("/{id}")
    public String getCategoriesById(@PathVariable("id") @NotNull Long id, Model model) {
        model.addAttribute("category", categoryRepository.findById(id).get());
        return "category";
    }
}
