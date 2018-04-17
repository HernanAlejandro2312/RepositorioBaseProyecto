/**
 * @author: edson
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.model.Category;
import com.dh.spring5webapp.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> find(String code) {
        return StringUtils.isEmpty(code) ? getCategories() : categoryRepository.findByCode(code).get();
    }
}