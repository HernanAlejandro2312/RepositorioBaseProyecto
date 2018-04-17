package com.dh.spring5webapp.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {
    private static final String RAW = "RAW";

    @Test
    public void getName() {
        Category category = new Category();
        category.setName(RAW);
        assertEquals(RAW, category.getName());
    }
}