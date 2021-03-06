package com.deliforall.spring5recipeapp.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {
    Category category;

    @BeforeEach
    void setUp() {
        this.category = new Category();
    }

    @Test
    void getId() {
        Long idValue = 4L;
        this.category.setId(idValue);
        assertEquals(idValue, this.category.getId());
    }

    @Test
    void getDescription() {
    }

    @Test
    void getRecipes() {
    }
}