package com.dh.spring5webapp.repositories;

import com.dh.spring5webapp.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<List<Category>> findByCode(String code);

    @Override
    List<Category> findAll();
}