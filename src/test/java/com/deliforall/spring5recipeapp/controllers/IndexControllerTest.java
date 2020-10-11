package com.deliforall.spring5recipeapp.controllers;

import com.deliforall.spring5recipeapp.domain.Recipe;
import com.deliforall.spring5recipeapp.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

;

class IndexControllerTest {
    IndexController controller;
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.controller = new IndexController(this.recipeService);
    }

    @Test
    void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void index() {
        // given
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);

        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe1);
        recipes.add(recipe2);

        // when
        when(this.recipeService.getRecipes()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        // then
        String viewName = this.controller.index(this.model);
        assertEquals("index", viewName);

        verify(this.recipeService, times(1)).getRecipes();
        verify(this.model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());

        assertEquals(2, argumentCaptor.getValue().size());
    }
}