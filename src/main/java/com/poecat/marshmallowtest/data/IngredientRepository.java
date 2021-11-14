package com.poecat.marshmallowtest.data;

import com.poecat.marshmallowtest.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);
}
