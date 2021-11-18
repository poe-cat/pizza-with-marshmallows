package com.poecat.marshmallowtest;

import com.poecat.marshmallowtest.data.IngredientRepository;
import com.poecat.marshmallowtest.data.OrderRepository;
import com.poecat.marshmallowtest.data.PizzaRepository;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc; //MockMvc injection

    @MockBean
    private IngredientRepository ingredientRepository;

    @MockBean
    private PizzaRepository designRepository;

    @MockBean
    private OrderRepository orderRepository;

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))   //doing request HTTP GET to /
                .andExpect(status().isOk())  //HTTP 200 status expected
                .andExpect(view().name("home")) //home name expected
                .andExpect(content().string(
                        containsString("Life is hard, isn't it?"))); //String expected
    }

}