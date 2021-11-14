package com.poecat.marshmallowtest.data;

import com.poecat.marshmallowtest.Ingredient;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    @Override
    public Iterable<Ingredient> findAll() {
        return null;
    }

    @Override
    public Ingredient findById(String id) {
        return null;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }
}
