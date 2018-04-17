package com.dh.spring5webapp.controller;

import org.junit.Assert;
import org.junit.Test;

public class IndexControllerTest {
    IndexController indexController = new IndexController();

    @Test
    public void testGetIndexPage() throws Exception {
        String result = indexController.getIndexPage();
        Assert.assertEquals("index", result);
    }
}