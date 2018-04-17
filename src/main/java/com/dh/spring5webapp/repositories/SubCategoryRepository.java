package com.dh.spring5webapp.repositories;

import com.dh.spring5webapp.model.SubCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends CrudRepository<SubCategory, Long> {
    Optional<List<SubCategory>> findByCode(String code);
}
