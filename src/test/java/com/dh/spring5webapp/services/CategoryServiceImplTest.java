package com.dh.spring5webapp.services;

import com.dh.spring5webapp.model.Category;
import com.dh.spring5webapp.repositories.CategoryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class CategoryServiceImplTest {
    private static final String OTRA_CAT = "OTRACAT";

    private List<Category> categorySet;
    @Mock
    CategoryRepository categoryRepository;
    @InjectMocks
    CategoryServiceImpl categoryServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        categorySet = new ArrayList<>();
        Category category = new Category();
        category.setName(OTRA_CAT);
        categorySet.add(category);

        when(categoryRepository.findAll()).thenReturn(categorySet);
    }

    @Test
    public void testGetCategories() throws Exception {
        List<Category> result = categoryServiceImpl.getCategories();
        Assert.assertEquals(categorySet, result);
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    @Ignore
    public void testFindById() throws Exception {
        Category result = categoryServiceImpl.findById(Long.valueOf(1));
        Assert.assertEquals(new Category(), result);
    }

    @Test
    @Ignore
    public void testFind() throws Exception {
        when(categoryRepository.findByCode(any())).thenReturn(null);

        List<Category> result = categoryServiceImpl.find("code");
        Assert.assertEquals(Arrays.<Category>asList(new Category()), result);
    }
}