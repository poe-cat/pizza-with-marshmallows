package com.poecat.marshmallowtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignPizzaController {

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("NEO", "Neopolitan-style", Ingredient.Type.DOUGH),
                new Ingredient("NYS", "New York-style", Ingredient.Type.DOUGH),
                new Ingredient("PEP", "pepperoni", Ingredient.Type.PROTEIN),
                new Ingredient("MAR", "marshmallow", Ingredient.Type.PROTEIN),
                new Ingredient("TOM", "tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LET", "letuce", Ingredient.Type.VEGGIES),
                new Ingredient("MOZ", "mozarella", Ingredient.Type.CHEESE),
                new Ingredient("CHE", "cheddar", Ingredient.Type.CHEESE),
                new Ingredient("SLS", "spicy tomato sauce", Ingredient.Type.SAUCE),
                new Ingredient("GAR", "garlic sauce", Ingredient.Type.SAUCE)
        );



    }
}
