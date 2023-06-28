package by.test.core.services.interfaces;

import by.test.core.entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    Order findById(Long id);

    Order save(Order order);

    void update(Order order);

    void deleteById(Long id);
}
