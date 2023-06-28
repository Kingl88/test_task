package by.test.core.services;

import by.test.core.entities.Client;
import by.test.core.entities.Order;
import by.test.core.repositories.OrderRepository;
import by.test.core.services.interfaces.OrderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order id = " + id + " not found"));
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        Optional<Order> tmpOrder = orderRepository.findById(order.getId());
        if (tmpOrder.isPresent()) {
            tmpOrder.get().setStatus(order.getStatus());
            orderRepository.save(tmpOrder.get());
        }
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
