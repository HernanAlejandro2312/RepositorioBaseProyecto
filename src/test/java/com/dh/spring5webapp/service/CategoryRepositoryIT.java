/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.dh.spring5webapp.service;

import com.dh.spring5webapp.model.Category;
import com.dh.spring5webapp.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryIT {
    private Category categoryA;
    private Category categoryB;
    private int initialCount = 0;
    @Autowired
    private CategoryRepository categoryRepository;

    @Before
    public void before() {
        initialCount = categoryRepository.findAll().size();
        categoryA = new Category();
        categoryA.setCreatedOn(new Date());
        categoryRepository.save(categoryA);
        categoryB = new Category();
        categoryB.setCreatedOn(new Date());
        categoryRepository.save(categoryB);
    }

    @Test
    public void tesFindAllCategoriesIT() {
        Set<Category> categories = new HashSet<>();
        categoryRepository.findAll().iterator().forEachRemaining(categories::add);
        assertEquals(initialCount + 2, categories.size());
    }
}
