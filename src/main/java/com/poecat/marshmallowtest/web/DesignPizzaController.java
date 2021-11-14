package com.poecat.marshmallowtest.web;

import com.poecat.marshmallowtest.Ingredient;
import com.poecat.marshmallowtest.Order;
import com.poecat.marshmallowtest.Pizza;
import com.poecat.marshmallowtest.data.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.poecat.marshmallowtest.Ingredient.Type;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignPizzaController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignPizzaController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping
    public String showDesignForm(Model model) {

        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        return "design";

    }

    @PostMapping
    public String processDesign(
            @Valid Pizza pizza, Errors errors,
            @ModelAttribute Order order) {

        if (errors.hasErrors()) {
            return "design";
        }

        //TODO: save pizza data

        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
