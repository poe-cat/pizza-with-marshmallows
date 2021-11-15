package com.poecat.marshmallowtest.data;

import com.poecat.marshmallowtest.Order;

public interface OrderRepository {

    Order save(Order order);
}
