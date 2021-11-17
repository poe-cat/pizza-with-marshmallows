package com.poecat.marshmallowtest.data;

import com.poecat.marshmallowtest.Order;
import com.poecat.marshmallowtest.Pizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class JdbcOrderRepository implements OrderRepository{

    private SimpleJdbcInsert orderInserter;
    private SimpleJdbcInsert orderPizzaInserter;
    private ObjectMapper objectMapper;

    public JdbcOrderRepository(JdbcTemplate jdbc) {
        this.orderInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Pizza_Order")
                .usingGeneratedKeyColumns("id");

        this.orderPizzaInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Pizza_Order_Pizzas");

        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Order save(Order order) {
        order.setPlacedAt(new Date());
        long orderId = saveOrderDetails(order);
        order.setId(orderId);
        List<Pizza> pizzas = order.getPizzas();

        for (Pizza pizza : pizzas) {
            savePizzaToOrder(pizza, orderId);
        }

        return order;
    }

    private void savePizzaToOrder(Pizza pizza, long orderId) {
    }

    private long saveOrderDetails(Order order) {
        return 0;
    }
}
