package com.dh.spring5webapp.repositories;

import com.dh.spring5webapp.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}