package com.deliforall.spring5recipeapp.services;

import com.deliforall.spring5recipeapp.domain.Recipe;
import com.deliforall.spring5recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        this.recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
