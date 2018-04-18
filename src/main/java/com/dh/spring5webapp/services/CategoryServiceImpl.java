/**
 * @author: edson
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.model.Category;
import com.dh.spring5webapp.repositories.CategoryRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category> implements CategoryService {
    private CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> find(String code) {
        return StringUtils.isEmpty(code) ? findAll() : repository.findByCode(code).get();
    }

    @Override
    protected CrudRepository<Category, Long> getRepository() {
        return repository;
    }
}