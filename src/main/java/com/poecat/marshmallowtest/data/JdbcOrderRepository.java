package com.poecat.marshmallowtest.data;

import com.poecat.marshmallowtest.Order;
import com.poecat.marshmallowtest.Pizza;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class JdbcOrderRepository implements OrderRepository{

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
