package com.deliforall.spring5recipeapp.services;

import com.deliforall.spring5recipeapp.domain.Recipe;
import com.deliforall.spring5recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.recipeService = new RecipeServiceImpl(this.recipeRepository);
    }

    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);

        when(this.recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = this.recipeService.getRecipes();
        assertEquals(1, recipes.size());
        verify(this.recipeRepository, times(1)).findAll();
    }
}