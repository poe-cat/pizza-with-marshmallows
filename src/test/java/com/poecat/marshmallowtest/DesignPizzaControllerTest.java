package com.poecat.marshmallowtest;

import static com.poecat.marshmallowtest.Ingredient.Type.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;

import com.poecat.marshmallowtest.data.IngredientRepository;
import com.poecat.marshmallowtest.data.OrderRepository;
import com.poecat.marshmallowtest.data.PizzaRepository;
import com.poecat.marshmallowtest.web.DesignPizzaController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(DesignPizzaController.class)
public class DesignPizzaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private List<Ingredient> ingredients;

    private Pizza design;

    @MockBean
    private IngredientRepository ingredientRepository;

    @MockBean
    private PizzaRepository designRepository;

    @MockBean
    private OrderRepository orderRepository;

    @Before
    public void setup() {
        ingredients = Arrays.asList(
                new Ingredient ("NEO", "Neopolitan", DOUGH),
                new Ingredient ("NYS", "New York", DOUGH),
                new Ingredient ("PEP", "pepperoni", PROTEIN),
                new Ingredient ("MAR", "marshmallow", PROTEIN),
                new Ingredient ("TOM", "tomatoes", VEGGIES),
                new Ingredient ("LET", "letuce", VEGGIES),
                new Ingredient ("MOZ", "mozarella", CHEESE),
                new Ingredient ("CHE", "cheddar", CHEESE),
                new Ingredient ("SLS", "spicy tomato sauce", SAUCE),
                new Ingredient ("GAR", "garlic sauce", SAUCE));

        when(ingredientRepository.findAll())
                .thenReturn(ingredients);

        when(ingredientRepository.findById("NEO")).thenReturn(new Ingredient("NEO", "Neopolitan", DOUGH));
        when(ingredientRepository.findById("PEP")).thenReturn(new Ingredient("PEP", "pepperoni", PROTEIN));
        when(ingredientRepository.findById("MOZ")).thenReturn(new Ingredient("MOZ", "mozarella", CHEESE));

        design = new Pizza();
        design.setName("Test Pizza");

        design.setIngredients(
                Arrays.asList(
                        new Ingredient("NEO", "Neopolitan", DOUGH),
                        new Ingredient("PEP", "pepperoni", PROTEIN),
                        new Ingredient("MOZ", "mozarella", CHEESE)));

    }

    @Test
    public void testShowDesignForm() throws Exception {
        mockMvc.perform(get("/design"))
                .andExpect(status().isOk())
                .andExpect(view().name("design"))
                .andExpect(model().attribute("dough", ingredients.subList(0, 2)))
                .andExpect(model().attribute("protein", ingredients.subList(2, 4)))
                .andExpect(model().attribute("veggies", ingredients.subList(4, 6)))
                .andExpect(model().attribute("cheese", ingredients.subList(6, 8)))
                .andExpect(model().attribute("sauce", ingredients.subList(8, 10)));
    }

    @Test
    public void processDesign() throws Exception {
        when(designRepository.save(design))
                .thenReturn(design);

        mockMvc.perform(post("/design")
                        .content("name=Test+Pizza&ingredients=NEO,PEP,MOZ")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().stringValues("Location", "/orders/current"));
    }

}