package com.anderson.tiendaback.services;

import com.anderson.tiendaback.models.Order;
import com.anderson.tiendaback.models.Product;

import java.util.List;
import java.util.UUID;

public interface OrderService extends ICRUDService<Order, UUID> {
    Order saveTransactional(Order order, List<Product> products);

}
