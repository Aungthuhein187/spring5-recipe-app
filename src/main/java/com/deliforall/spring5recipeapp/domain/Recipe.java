package com.deliforall.spring5recipeapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"ingredients", "categories"})
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    @Lob
    private String direction;
    @Enumerated(value = EnumType.STRING)
    private Difficulity difficulty;
    @Lob
    private Byte[] image;
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "recipe_caterogy",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public void setNotes(Notes notes) {
        if(notes != null) {
            this.notes = notes;
            this.notes.setRecipe(this);
        }
    }

    public void addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
    }
}
