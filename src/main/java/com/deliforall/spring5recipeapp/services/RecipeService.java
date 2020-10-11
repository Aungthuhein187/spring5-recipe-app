package com.deliforall.spring5recipeapp.services;

import com.deliforall.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
