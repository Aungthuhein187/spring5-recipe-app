package com.deliforall.spring5recipeapp.controllers;

import com.deliforall.spring5recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = {"", "/", "index", "index.html"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("recipes", this.recipeService.getRecipes());
        return "index";
    }
}
