/**
 * @author: edson
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();

    Category findById(Long id);

    List<Category> find(String code);
}
